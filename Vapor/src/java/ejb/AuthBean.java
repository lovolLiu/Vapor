/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Myuser;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Random;
import javax.ejb.Stateful;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * An EJB for user authentication.
 */
@Stateful
public class AuthBean {

    private static final String SYMBOLS = "abcdefghijklmnopqrstuvwxyz0123456789";
    private static final String COOKIE_ID = "USER_ID";
    private static final String COOKIE_TOKEN = "USER_TOKEN";

    @PersistenceContext
    private EntityManager em;

    /**
     * Returns a random token string with length of 32.
     *
     * @return a random token string.
     */
    private String generateToken() {
        char[] buffer = new char[32];
        Random random = new Random();
        for (int i = 0; i < 32; i++) {
            buffer[i] = SYMBOLS.charAt(random.nextInt(SYMBOLS.length()));
        }
        return new String(buffer);
    }

    /**
     * Creates an MD5 string based of the given string.
     * 
     * @param origin A string to be converted to MD5.
     * @return an MD5 string.
     */
    public String getMd5(String origin) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(origin.getBytes());

            byte[] stringDigest = digest.digest();

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < stringDigest.length; i++) {
                sb.append(Integer.toString((stringDigest[i] & 0xFF) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            // Ignored.
        }
        return "";
    }

    /**
     * Sets the value of a cookie.
     * 
     * @param name Name of the cookie.
     * @param value Value to be set.
     */
    private void setCookieValue(String name, String value) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(1000000);

        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addCookie(cookie);
    }

    /**
     * Gets the value of a cookie.
     * 
     * @param name Name of the cookie.
     * @return Value of the cookie.
     */
    private String getCookieValue(String name) {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        if (request.getCookies() == null) {
            return null;
        } else {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals(name)) {
                    return cookie.getValue();
                }
            }
        }

        return null;
    }

    /**
     * Creates a new user with the given infomation.
     * 
     * @param username Username of the user.
     * @param password Original password of the user.
     * @param email Email of the user.
     * @param tel Tel number of the user.
     * @return false if the username has been occupied, otherwise true.
     */
    public boolean userRegister(String username, String password,
            String email, String tel) {
        Myuser user = new Myuser();
        user.setUsername(username);
        user.setPassword(getMd5(password));
        user.setEmail(email);
        user.setTel(tel);
        
        int count = em.createNamedQuery("Myuser.findByUsername")
                    .setParameter("username", username)
                    .getResultList().size();
        if (count > 0) {
            return false;
        } else {
            em.persist(user);
            return true;
        }
    }

    /**
     * Checks if the username and password is correct and performs user
     * authentication.
     *
     * @param username Username of the user.
     * @param password Original password of the user.
     * @return a user entity if the authentication is successful, otherwise
     * null.
     */
    public Myuser userLogin(String username, String password) {
        String passwordMd5 = getMd5(password);

        try {
            Myuser user = (Myuser) em.createNamedQuery("Myuser.findByUsername")
                    .setParameter("username", username)
                    .getSingleResult();
            if (user == null) {
                return null;
            } else {
                if (user.getPassword().equals(passwordMd5)) {
                    // Password is correct.
                    // Generate a new token and store it in the database.
                    String token = generateToken();
                    user.setToken(token);
                    em.persist(user);

                    // Of couse, store it in the cookies.
                    setCookieValue(COOKIE_ID, Integer.toString(user.getId()));
                    setCookieValue(COOKIE_TOKEN, token);

                    return user;
                } else {
                    return null;
                }
            }
        } catch (NoResultException ex) {
            return null;
        }
    }

    /**
     * Checks if a token is valid.
     *
     * @param userId ID of the user.
     * @param token Token to check.
     * @return true if the token is valid.
     */
    private boolean isTokenValid(int userId, String token) {
        Myuser user = (Myuser) em.createNamedQuery("Myuser.findById")
                .setParameter("id", userId)
                .getSingleResult();
        return user != null && user.getToken().equals(token);
    }

    /**
     * Checks if there is a user logged in.
     *
     * @return true if there is a user logged in.
     */
    public boolean checkLoginState() {
        String idString = getCookieValue(COOKIE_ID);
        String token = getCookieValue(COOKIE_TOKEN);

        if (idString == null
                || token == null
                || idString.isEmpty()
                || token.isEmpty()) {
            return false;
        } else {
            return isTokenValid(Integer.parseInt(idString), token);
        }
    }
    
    /**
     * Returns ID of the user logged in.
     * 
     * @return ID of the user.
     */
    public int getLoggedInUserId() {
        String idValue = getCookieValue(COOKIE_ID);
        if (idValue == null) {
            return -1;
        } else {
            return Integer.parseInt(idValue);
        }
    }

    /**
     * Logs a user out of the website.
     *
     * @param userId ID of the user to be logged out.
     */
    public void userLogout(int userId) {
        Myuser user = (Myuser) em.createNamedQuery("Myuser.findById")
                .setParameter("id", userId)
                .getSingleResult();
        user.setToken("");
        em.persist(user);

        // Clear the cookies.
        setCookieValue(COOKIE_ID, "-1");
        setCookieValue(COOKIE_TOKEN, "");
    }

}
