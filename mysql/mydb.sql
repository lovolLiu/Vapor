CREATE DATABASE  IF NOT EXISTS `mydb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mydb`;
-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mydb
-- ------------------------------------------------------
-- Server version	5.6.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cart` (
  `myUser_id` int(8) NOT NULL,
  `myItem_id` int(8) NOT NULL,
  `Cart_id` int(8) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Cart_id`),
  UNIQUE KEY `Cart_id_UNIQUE` (`Cart_id`),
  KEY `fk_Cart_myItem1_idx` (`myItem_id`),
  KEY `fk_Cart_myUser1` (`myUser_id`),
  CONSTRAINT `fk_Cart_myItem1` FOREIGN KEY (`myItem_id`) REFERENCES `myitem` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cart_myUser1` FOREIGN KEY (`myUser_id`) REFERENCES `myuser` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (24,12,44);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gameclass`
--

DROP TABLE IF EXISTS `gameclass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gameclass` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `cName` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gameclass`
--

LOCK TABLES `gameclass` WRITE;
/*!40000 ALTER TABLE `gameclass` DISABLE KEYS */;
INSERT INTO `gameclass` VALUES (1,'动作'),(2,'解谜'),(3,'竞速'),(4,'角色扮演'),(5,'射击'),(6,'体育'),(7,'策略');
/*!40000 ALTER TABLE `gameclass` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gamedeveloper`
--

DROP TABLE IF EXISTS `gamedeveloper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gamedeveloper` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `dName` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gamedeveloper`
--

LOCK TABLES `gamedeveloper` WRITE;
/*!40000 ALTER TABLE `gamedeveloper` DISABLE KEYS */;
INSERT INTO `gamedeveloper` VALUES (1,'DICE'),(2,'Crytek'),(3,'PopCap Games'),(5,'ColdWood Interactive'),(6,'Codemasters Racing Studio'),(7,'Criterion Games'),(8,'Ghost Games'),(9,'BeamNG '),(10,'Warner Bros. Interactive Entertainment'),(11,'Studio Wildcard'),(12,'Bethesda Game Studios'),(13,'Rockstar Games'),(14,'BioWare'),(15,'Visceral Games'),(16,'Valve'),(17,'Electronic Arts'),(18,'Visual Concepts'),(19,'Cyanide Studios'),(20,'Psyonix'),(21,'Ubisoft'),(22,'Ndemic Creations'),(23,'Gaming Minds Studios'),(24,'Colossal Order Ltd.');
/*!40000 ALTER TABLE `gamedeveloper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gamepicture`
--

DROP TABLE IF EXISTS `gamepicture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gamepicture` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `URL` varchar(100) NOT NULL,
  `myItem_id` int(8) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_gamePicture_myItem1_idx` (`myItem_id`),
  CONSTRAINT `fk_gamePicture_myItem1` FOREIGN KEY (`myItem_id`) REFERENCES `myitem` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=186 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gamepicture`
--

LOCK TABLES `gamepicture` WRITE;
/*!40000 ALTER TABLE `gamepicture` DISABLE KEYS */;
INSERT INTO `gamepicture` VALUES (1,'封面1.jpg',1),(2,'1_1.jpg',1),(3,'1_2.jpg',1),(4,'1_3.jpg',1),(5,'1_4.jpg',1),(6,'封面2.jpg',2),(7,'2_1.jpg',2),(8,'2_2.jpg',2),(9,'2_3.jpg',2),(10,'2_4.jpg',2),(11,'封面3.jpg',3),(12,'3_1.jpg',3),(13,'3_2.jpg',3),(14,'3_3.jpg',3),(15,'3_4.jpg',3),(16,'封面4.jpg',4),(17,'4_1.jpg',4),(18,'4_2.jpg',4),(19,'4_3.jpg',4),(20,'4_4.jpg',4),(21,'封面5.jpg',5),(22,'5_1.jpg',5),(23,'5_2.jpg',5),(24,'5_3.jpg',5),(25,'5_4.jpg',5),(26,'封面6.jpg',6),(27,'6_1.jpg',6),(28,'6_2.jpg',6),(29,'6_3.jpg',6),(30,'6_4.jpg',6),(31,'封面7.jpg',7),(32,'7_1.jpg',7),(33,'7_2.jpg',7),(34,'7_3.jpg',7),(35,'7_4.jpg',7),(36,'封面8.jpg',8),(37,'8_1.jpg',8),(38,'8_2.jpg',8),(39,'8_3.jpg',8),(40,'8_4.jpg',8),(41,'封面9.jpg',9),(42,'9_1.jpg',9),(43,'9_2.jpg',9),(44,'9_3.jpg',9),(45,'9_4.jpg',9),(46,'封面10.jpg',10),(47,'10_1.jpg',10),(48,'10_2.jpg',10),(49,'10_3.jpg',10),(50,'10_4.jpg',10),(51,'封面11.jpg',11),(52,'11_1.jpg',11),(53,'11_2.jpg',11),(54,'11_3.jpg',11),(55,'11_4.jpg',11),(56,'封面12.jpg',12),(57,'12_1.jpg',12),(58,'12_2.jpg',12),(59,'12_3.jpg',12),(60,'12_4.jpg',12),(61,'封面13.jpg',13),(62,'13_1.jpg',13),(63,'13_2.jpg',13),(64,'13_3.jpg',13),(65,'13_4.jpg',13),(66,'封面14.jpg',14),(67,'14_1.jpg',14),(68,'14_2.jpg',14),(69,'14_3.jpg',14),(70,'14_4.jpg',14),(71,'封面15.jpg',15),(72,'15_1.jpg',15),(73,'15_2.jpg',15),(74,'15_3.jpg',15),(75,'15_4.jpg',15),(76,'封面16.jpg',16),(77,'16_1.jpg',16),(78,'16_2.jpg',16),(79,'16_3.jpg',16),(80,'16_4.jpg',16),(81,'封面17.jpg',17),(82,'17_1.jpg',17),(83,'17_2.jpg',17),(84,'17_3.jpg',17),(85,'17_4.jpg',17),(86,'封面18.jpg',18),(87,'18_1.jpg',18),(88,'18_2.jpg',18),(89,'18_3.jpg',18),(90,'18_4.jpg',18),(91,'封面19.jpg',19),(92,'19_1.jpg',19),(93,'19_2.jpg',19),(94,'19_3.jpg',19),(95,'19_4.jpg',19),(96,'封面20.jpg',20),(97,'20_1.jpg',20),(98,'20_2.jpg',20),(99,'20_3.jpg',20),(100,'20_4.jpg',20),(101,'封面21.jpg',21),(102,'21_1.jpg',21),(103,'21_2.jpg',21),(104,'21_3.jpg',21),(105,'21_4.jpg',21),(106,'封面22.jpg',22),(107,'22_1.jpg',22),(108,'22_2.jpg',22),(109,'22_3.jpg',23),(110,'22_4.jpg',22),(111,'封面23.jpg',23),(112,'23_1.jpg',23),(113,'23_2.jpg',23),(114,'23_3.jpg',23),(115,'23_4.jpg',23),(116,'封面24.jpg',24),(117,'24_1.jpg',24),(118,'24_2.jpg',24),(119,'24_3.jpg',24),(120,'24_4.jpg',24),(121,'封面25.jpg',25),(122,'25_1.jpg',25),(123,'25_2.jpg',25),(124,'25_3.jpg',25),(125,'25_4.jpg',25),(126,'封面26.jpg',26),(127,'26_1.jpg',26),(128,'26_2.jpg',26),(129,'26_3.jpg',26),(130,'26_4.jpg',26),(131,'封面27.jpg',27),(132,'27_1.jpg',27),(133,'27_2.jpg',27),(134,'27_3.jpg',27),(135,'27_4.jpg',27),(136,'封面28.jpg',28),(137,'28_1.jpg',28),(138,'28_2.jpg',28),(139,'28_3.jpg',28),(140,'28_4.jpg',28),(141,'封面29.jpg',29),(142,'29_1.jpg',29),(143,'29_2.jpg',29),(144,'29_3.jpg',29),(145,'29_4.jpg',29),(146,'封面30.jpg',30),(147,'30_1.jpg',30),(148,'30_2.jpg',30),(149,'30_3.jpg',30),(150,'30_4.jpg',30),(151,'封面31.jpg',31),(152,'31_1.jpg',31),(153,'31_2.jpg',31),(154,'31_3.jpg',31),(155,'31_4.jpg',31);
/*!40000 ALTER TABLE `gamepicture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `myitem`
--

DROP TABLE IF EXISTS `myitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `myitem` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `price` float NOT NULL,
  `description` varchar(2000) NOT NULL,
  `gameDeveloper_id` int(8) NOT NULL,
  `gameClass_id` int(2) NOT NULL,
  `pubTime` datetime NOT NULL,
  `times_of_buy` int(8) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_myItem_gameDeveloper1_idx` (`gameDeveloper_id`),
  KEY `fk_myItem_gameClass1_idx` (`gameClass_id`),
  CONSTRAINT `fk_myItem_gameClass1` FOREIGN KEY (`gameClass_id`) REFERENCES `gameclass` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_myItem_gameDeveloper1` FOREIGN KEY (`gameDeveloper_id`) REFERENCES `gamedeveloper` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `myitem`
--

LOCK TABLES `myitem` WRITE;
/*!40000 ALTER TABLE `myitem` DISABLE KEYS */;
INSERT INTO `myitem` VALUES (1,'镜之边缘',59.99,'From the outside, the city of Glass appears to be an elegant, high-tech metropolis. But a terrible secret is buried deep within its heart – and it\'s up to the free runner Faith to expose it. Experience Faith\'s origin story in Mirror’s Edge™ Catalyst and fight for freedom in the city of Glass. This huge world is your playground. Run, climb, and explore every corner in the first-person perspective, from the sun-drenched rooftops to the dark, gritty tunnels below. Combine Faith\'s free-running movement and agility with her advanced combat techniques to take out those who stand in your way. Only by mastering the environment can you hope to uncover the harrowing conspiracy hidden within the city of Glass.',1,1,'2016-02-25 00:00:00',2),(2,'孤岛危机3',9.99,'The award-winning developer Crytek is back with Crysis 3, the first blockbuster shooter of 2013. Return to the fight as Prophet, the Nanosuit soldier on a quest to save humanity. Adapt on the fly with the stealth and armor abilities of your unique Nanosuit as you battle through the seven wonders of New York’s Liberty Dome. Unleash the firepower of your all-new, high-tech bow and alien weaponry to hunt both human and alien enemies. Uncover the truth behind the death of your squad while reestablishing the power of human will in a rich story full of exciting twists and turns. Crysis 3 is the ultimate sandbox shooter, realized in the stunning visuals only Crytek and the latest version of CryENGINE can deliver. Assess, Adapt, and Attack!',2,1,'2013-02-22 00:00:00',1),(3,'星球大战：前线',59.99,'Experience Epic Battles on a Galactic Scale   Feel the ominous thud of an AT-AT stomping down on the frozen tundra of Hoth. Zip through the lush forests of Endor on an Imperial speeder bike while dodging incoming blaster fire. Engage in intense dogfights as squadrons of X-wings and TIE fighters fill the skies. Immerse yourself in the epic Star Wars™ battles you’ve always dreamed of and create new heroic moments of your own in Star Wars™ Battlefront™. ',1,1,'2015-11-19 00:00:00',1),(4,'PvZ：花园战争',29.99,'Plants vs. Zombies Garden Warfare digs into the trenches with an explosive action experience. Blast zombies, plants and unique characters across a mine-blowing world that delivers the depth of a traditional online shooter and the refreshing humor of the Plants vs. Zombies universe.   The Digital Deluxe Edition is the best way to start the Garden Warfare action, scoring you your first 150,000 coins to spend on customization options in addition to an Origin-exclusive Custom Accessories Pack.',3,1,'2014-01-27 00:00:00',40),(5,'UNRAVEL',19.99,'Experience a Heartwarming Tale.  Yarny isn’t an ordinary thread of… well, yarn. No, this tiny, new character has a noble goal: to reconnect the long-lost memories of a family. And he needs your help to do it. Embark on an inspiring adventure in this physics-based puzzle platformer, and guide Yarny past the many obstacles and challenges that stand in his way. Whether you’re using his yarn to swing from tree branch to tree branch, or to hitch a ride on a kite, no feat is too big to overcome. Featuring a heartfelt story expressed without words, Unravel is an exciting tale about the bonds of life.',5,2,'2016-06-01 00:00:00',5),(6,'逃离翡翠星',4.99,'Find the clues, escape the ship!  While vacationing on the Emerald Star cruise liner, you awake to find the ship abandoned and in disarray. You’re alone and lost at sea. Can you find your way to shore?  You’ll have to track down over 2,200 objects in 25 intriguing scenes. Solve 7 unique mini-game puzzles and piece together fragments of a map to help you escape. If you locate the hidden anchors in each scene you’ll unlock two bonus game modes. But hurry – the ship is drifting and you need to escape!',3,2,'2011-06-16 00:00:00',0),(7,'MYSTERY P.I.',4.99,'The hidden-object hit heads to New England!  The picturesque New England village of Whaler\'s Cove is preparing for the fall tourism season, but counterfeit bills are popping up all around the seaside settlement. You\'ve been hired by the town elders to track down the counterfeiting ring before the fake bills ruin the local economy.  Visit 25 charming seaside locations as you search for more than 2,200 hidden objects. Explore more than 100 levels and find hidden lobsters and keys to unlock 2 bonus game modes. Solve 6 unique mini-game puzzles. Go for a Perfect Search and earn speed bonuses to beat your high score. ',3,2,'2011-11-02 00:00:00',1),(8,'神奇冒险：环游世界',4.99,'Seek and find the World Diamond!  Set out on a globetrotting journey to find the most expensive gem ever known! Pieces of an ancient stone tablet are turning up around the globe and the Museum needs your help to locate the World Diamond.   Complete over 100 levels by finding hidden objects and circumventing unique puzzle traps. Travel to 25 exotic locations to find over 2,100 hidden objects, and take on eight types of mini-game puzzles to track down the diamond and earn your big reward. But it won’t be easy: as things get puzzling you’ll need to stay sharp… can you put all the pieces together?',3,2,'2008-06-26 00:00:00',0),(9,'独家寻奇：澳大利亚',4.99,'Take an exotic seek and find adventure Down Under!  Grab your passport for an exotic seek and find adventure! Take a trip Down Under as you search for hidden clues to unlock new adventures and extend your stay. It’s your own relaxing getaway!  Explore 28 scenes across Australia in search of over 2,200 hidden objects. Track down boomerangs in each location to tour new sites and earn a Perfect Score. Fill your vacation journal with your achievements and discover cool facts. Relax in untimed Vacation mode or compete against the clock. Either way, you’ll never want it to end!',3,2,'2012-01-18 00:00:00',0),(10,'尘埃3',29.99,'Get DiRT 3 Complete Edition, the definitive edition of off-road racer DiRT 3 now expanded with extra content and enhanced with Steamworks integration, including Achievements, Leaderboards and Steam Cloud Saves.  In DiRT 3 Complete Edition, you’ll race iconic cars representing 50 years of off-road motorsport across three continents – from the forests of Michigan to the infamous roads of Finland and the national parks of Kenya. You’ll also express yourself in the stunning Gymkhana mode, inspired by Ken Block’s incredible freestyle driving event, and take on other modes including Rallycross, Trailblazer and Landrush. Powered by Codemasters’ award-winning EGO Engine, DiRT 3 Complete Edition features Flashback to rewind time, genre-leading damage and you can take on all game modes in split-screen and competitive online multiplayer.',6,3,'2015-04-01 00:00:00',1),(11,'极品飞车：热力追踪',69.99,'Need for Speed Hot Pursuit launches you into a new open-world landscape behind the wheel of the world\'s fastest and most beautiful cars. From Criterion, the award-winning studio behind the Burnout series, Hot Pursuit will redefine racing games for a whole new generation.   You\'ll experience stunning speeds, takedowns, and getaways as you battle your friends in the most connected Need for Speed game ever. Through Need for Speed Autolog and its innovative approach to connected social competition, your Hot Pursuit experience will extend beyond the console onto the web, constantly moving your gameplay in new and unique directions.   Loaded with action, this game will challenge you to become Seacrest County\'s top cop or most wanted racer. For the first time ever in a Need for Speed game, you\'ll be able to play a full career on either side of the law. Whether you\'re a lead-foot speeder or a cop with a mean streak, make sure your aviators are spotless and your driving record is anything but. ',7,3,'2010-11-16 00:00:00',5),(12,'极品飞车19',59.99,'Rediscover the Need for Speed  Ready to own the streets? Get behind the wheel of iconic cars and floor it through Ventura Bay, a sprawling urban playground. Explore overlapping stories as you build your reputation – and your dream car – and become the ultimate racing icon. Play again and again because this time, you have 5 distinct ways to win.',8,3,'2016-03-01 00:00:00',3),(13,'极品飞车18',39.99,'Need for Speed: Rivals Base Game Erase the line between single player and multiplayer in this street-racing rivalry between Cops and Racers. Seamlessly join a world where your friends are already racing and chasing.',8,3,'2014-10-21 00:00:00',1),(14,'BeamNG.drive',24.99,'BeamNG.drive is a realistic, immersive driving game offering near-limitless possibilities. Our soft-body physics engine simulates every component of a vehicle in real time, resulting in realistic, dynamic behavior.  The driving feel is authentic and visceral, and crashes are realistic and violent; yet the physics are accessible enough to drive with a keyboard or gamepad while still being authentic with a full racing wheel with uncompromising realism.   Environments and vehicles in BeamNG.drive are hand-crafted with passionate attention to detail. With years of meticulous design, research, and experience, we authentically recreate the feeling and excitement of real world driving.   We are a small team from around the world with no obligations to publishers or outside interests. Our users and modding community are our first priority. Help us make BeamNG.drive the ultimate driving experience and discover what an open and uncompromising soft-body vehicle simulator can be.',9,3,'2015-05-24 00:00:00',0),(15,'疯狂的麦克斯',59.99,'Become Mad Max, the lone warrior in a savage post-apocalyptic world where cars are the key to survival. In this action-packed, open world, third person action game, you must fight to stay alive in The Wasteland, using brutal on-ground and vehicular against vicious gangs of bandits. A reluctant hero with an instinct for survival, Max wants nothing more than to leave the madness behind and find solace in the storied “Plains of Silence.” Players are challenged with treacherous missions as they scavenge the dangerous landscape for supplies to build the ultimate combat vehicle.',10,4,'2015-09-01 00:00:00',1),(16,'方舟：生存进化',29.99,'“ARK is a huge game, in terms of geographical space, scope of content, features, technology, and just about every other metric. We\'re a veteran team with some major hits behind our leads, and much of the core challenge is already met, but this is still an ambitious one for us. We want the player community\'s help to \'evolve\' ARK into the dinosaur world game that we\'ve been dreaming about since the days we played with plastic green T-Rex toys during elementary school recess, since we shed a tear to \'The Land Before Time\', since we wistfully imagined the towering cities of \'Dinotopia\', and since we nearly choked on our popcorn to the thrills of \'Jurassic Park\'. We love games, and holy smokes do we ever love dinos (along with all sorts of other extinct creatures/natural sciences), and through interaction and iteration with the ARK\'s community, we think we have the best shot at creating the be-all, end-all long-term prehistoric universe that we want to live and thrive in. We have a great start, and with your valued input and contributions, we will take it all the way together!”',11,4,'2015-06-02 00:00:00',0),(17,'上古卷轴5',19.99,'EPIC FANTASY REBORN  The next chapter in the highly anticipated Elder Scrolls saga arrives from the makers of the 2006 and 2008 Games of the Year, Bethesda Game Studios. Skyrim reimagines and revolutionizes the open-world fantasy epic, bringing to life a complete virtual world open for you to explore any way you choose.   LIVE ANOTHER LIFE, IN ANOTHER WORLD  Play any type of character you can imagine, and do whatever you want; the legendary freedom of choice, storytelling, and adventure of The Elder Scrolls is realized like never before.   ALL NEW GRAPHICS AND GAMEPLAY ENGINE  Skyrim’s new game engine brings to life a complete virtual world with rolling clouds, rugged mountains, bustling cities, lush fields, and ancient dungeons. ',12,4,'2011-11-10 00:00:00',0),(18,'GTA5',19.99,'resolutions of up to 4k and beyond, as well as the chance to experience the game running at 60 frames per second.   The game offers players a huge range of PC-specific customization options, including over 25 separate configurable settings for texture quality, shaders, tessellation, anti-aliasing and more, as well as support and extensive customization for mouse and keyboard controls. Additional options include a population density slider to control car and pedestrian traffic, as well as dual and triple monitor support, 3D compatibility, and plug-and-play controller support. ',13,4,'2015-04-14 00:00:00',1),(19,'龙腾世纪4',59.99,'Your New Adventure Begins.  When the sky opens up and rains down chaos, the world needs heroes. Become the savior of Thedas in Dragon Age: Inquisition. You are the Inquisitor, tasked with saving the world from itself. But the road ahead is paved with difficult decisions. Thedas is a land of strife. Factions constantly war with each other even as a larger demonic invasion has begun. And you? You and your band of champions are the only ones who can hold it together. It’s your job to lead them… or fall. ',14,4,'2014-11-21 00:00:00',0),(20,'战地4',19.99,'Experience unrivaled destruction.  Battlefield 4™ is the genre-defining action blockbuster known for its unrivaled destruction. Fueled by the next-generation power and fidelity of Frostbite™ 3, Battlefield 4 provides a visceral, dramatic experience..   Only in Battlefield can you demolish the buildings shielding your enemy. Only in Battlefield will you lead an assault from the back of a gun boat. Battlefield grants you the freedom to do more and be more while playing to your strengths and carving your own path to victory.   In addition to its hallmark multiplayer, Battlefield 4™ features an intense, dramatic character-driven campaign that starts with the evacuation of American VIPs from Shanghai and follows your squad\'s struggle to find its way home.   There is no comparison. Immerse yourself in the glorious chaos of all-out war, found only in Battlefield. ',1,5,'2013-11-01 00:00:00',0),(21,'战地：硬仗',59.99,'Join the Heist like a Pro.  A security truck loaded with cash lays abandoned in a parking garage, and you only have seconds to cram as much cash as possible into your backpack before the cops arrive. Stray bills flutter behind you as you make a mad dash for the elevators. When you get to the roof a teammate jumps on the zip-line, but you choose a more direct route and swan-dive over the edge of the building. Your chute deploys. Bullets are whizzing far too close for comfort. The moment you hit the pavement it’s a straight-out sprint to the getaway van. Sirens are blaring. Cops are on the way. And that’s when you notice the massive crane crashing down. This is just a day in the life of the Battlefield Hardline player.',15,5,'2015-03-20 00:00:00',0),(22,'战地4：二次突袭',14.99,'• Operation Metro 2014: Fight both enemy opponents and claustrophobia in subterranean Paris. Bring the sky down on your opponents with destructible ceilings, and trap them in the flooded subway tunnels.  • Caspian Border 2014: The central communications tower is now a hammer, ready to fall on your enemies. Take advantage of the confusion by fortifying your teammates in the new vantage points along the walls.  • Gulf of Oman 2014: Everything feels normal on this map until the sandstorm whips through, destroying visibility and reducing the efficacy of your combat vehicles.  • Operation Firestorm 2014: Create Hell on Earth as you breach the refinery pipelines and send gouts of flame to roast your opponents.  Deploy five new weapons and execute on 10 new assignments, each with their own unlocks. Play Capture the Flag made even more fun with the returning Dune Buggy. The classics are new again in Second Assault!',1,5,'2014-02-18 00:00:00',1),(23,'CS:GO',7.49,'Counter-Strike: Global Offensive (CS: GO) will expand upon the team-based action gameplay that it pioneered when it was launched 14 years ago.  CS: GO features new maps, characters, and weapons and delivers updated versions of the classic CS content (de_dust, etc.). In addition, CS: GO will introduce new gameplay modes, matchmaking, leader boards, and more.  \"Counter-Strike took the gaming industry by surprise when the unlikely MOD became the most played online PC action game in the world almost immediately after its release in August 1999,\" said Doug Lombardi at Valve. \"For the past 12 years, it has continued to be one of the most-played games in the world, headline competitive gaming tournaments and selling over 25 million units worldwide across the franchise. CS: GO promises to expand on CS\' award-winning gameplay and deliver it to gamers on the PC as well as the next gen consoles and the Mac.\"',16,5,'2012-08-21 00:00:00',2),(24,'FIFA16',59.99,'Play Your Best Season Yet in FIFA 16.  Create more moments of magic than ever before with FIFA 16. Make every match memorable with increased control in Midfield, improved defensive moves, more stars, and a new way to play. Build your dream team in FIFA Ultimate Team, or compete as one of 12 Women’s National Teams for the first time ever in the FIFA franchise, including Germany, USA, France, Sweden, England, Brazil, and more. FIFA 16 innovates across the entire pitch, delivering a lifelike and authentic football experience.',17,6,'2015-09-24 00:00:00',0),(25,'NBA 2K16',45,'The NBA 2K franchise is back with the most true-to-life NBA experience to date with NBA 2K16. Featuring an all-new MyCAREER experience written, directed and produced by acclaimed filmmaker Spike Lee. Guide your MyPLAYER through the complete NBA journey, take control of an entire NBA franchise, or hone your skills online competing against gamers from around the world. With animations that provide smoother movement and more realistic articulation, and a unique cover design featuring NBA stars Stephen Curry, Anthony Davis and James Harden, it’s certain to be the most authentic NBA gaming experience yet.',18,6,'2015-09-29 00:00:00',51),(26,'blood bowl2',44.99,'TOUCHDOWN!  Blood Bowl 2 smashes Warhammer and American football together, in an explosive cocktail of turn-based strategy, humour and brutality, adapted from Games Workshop’s famous boardgame.   Blood Bowl 2’s new graphics engine and high-flying realization makes for a faithful portrayal of the fury and intensity of classic Blood Bowl matches. The solo game mode will have you lead the famous Reikland Reavers. Former star team of Blood Bowl you are tasked with bringing them back to glory, following a full story campaign supported by the hilarious commentators Jim & Bob from Cabalvision. Each match of the campaign is unique, with unexpected and surprising events constantly renewing the experience!   The multiplayer modes are bigger and richer than ever. In the persistent online mode, create and manage your own team comprised of one of eight races from the Warhammer world – Humans, Orcs, Dwarfs, Skaven, High Elves, Dark Elves, Chaos, and the Bretonnia newcomers. You will develop your team, gaining XP and unlocking new skills. But beware! On the pitch, all losses are permanent... Organize entirely customisable championships, from qualifications to finale, and use the new Transfer Market to buy and sell your players, and build your Blood Bowl dream-team!   The next generation of Blood Bowl touches down today, will YOU be the champion?',19,6,'2015-09-22 00:00:00',1),(27,'火箭联盟',19.99,'Soccer meets driving once again in the long-awaited, physics-based sequel to the beloved arena classic, Supersonic Acrobatic Rocket-Powered Battle-Cars!   A futuristic Sports-Action game, Rocket League, equips players with booster-rigged vehicles that can be crashed into balls for incredible goals or epic saves across multiple, highly-detailed arenas. Using an advanced physics system to simulate realistic interactions, Rocket League relies on mass and momentum to give players a complete sense of intuitive control in this unbelievable, high-octane re-imagining of association football. ',20,6,'2015-07-07 00:00:00',0),(28,'英雄无敌7',49.99,'Our story takes place during a war of succession. The Empress’ murder has left a realm in flames with many hungry rivals ready to seize the throne by force. The Duke Ivan then calls together a prestigious council of six trusted advisors to restore order and end the conflict that set ablaze Ashan’s lands.   Might & Magic® Heroes® VII makes a triumphant return bringing you the essence of turn based strategy gaming. Set in a fantasy universe with RPG progression with a strong story narrative, you will embark on a journey that you will never forget!   Explore and conquer the enchanted world of Ashan   Develop and manage your economy   Lead armies of legendary creatures to battle   Build up Heroes of Might & Magic with hundreds of abilities and powerful artifacts',21,7,'2015-09-29 00:00:00',1),(29,'瘟疫公司：进化',14.99,'Plague Inc: Evolved is a unique mix of high strategy and terrifyingly realistic simulation. Your pathogen has just infected \'Patient Zero\' - now you must bring about the end of human history by evolving a deadly, global Plague whilst adapting against everything humanity can do to defend itself.   Plague Inc. is so realistic that the CDC even asked the developer to come and speak about the infection models in the game!',22,7,'2014-04-20 00:00:00',4),(30,'伟大时代：中世纪',39.99,'It is the year 1050 AD. At the beginning of the High Middle Ages development in Europe has seen an unprecedented level of progress and a rapidly growing population spreads across the length and breadth of the continent. New frontiers are explored, settlements founded and vast trading routes established. As the head of one of these small settlements, it falls upon you to lead your people towards greatness. Explore a vast world, gather resources, encounter other societies and use your trading expertise to expand and make your fortune. Found new cities, progress your nation with inventive technology and protect your trade routes against barbarian attacks until you are powerful enough to begin your conquest over Europe and forge a bold new empire.   Grand Ages: Medieval is a real-time strategy game from Gaming Minds. Lead your people and advance through the decades by utilising construction, research, expansion and conquest in an area extending from Scandinavia and North Africa; to Portugal, the Caucasus and the Middle East. Rise from the humble role of a simple mayor governing a small settlement and rule over all of Europe. Experience an exciting campaign with elaborately designed cut-scenes, play by your own rules in free play or test your skills in multiplayer against up to 8 players!',23,7,'2015-09-25 00:00:00',2),(31,'城市：天际线',29.99,'Cities: Skylines is a modern take on the classic city simulation. The game introduces new game play elements to realize the thrill and hardships of creating and maintaining a real city whilst expanding on some well-established tropes of the city building experience.     From the makers of the Cities in Motion franchise, the game boasts a fully realized transport system. It also includes the ability to mod the game to suit your play style as a fine counter balance to the layered and challenging simulation. You’re only limited by your imagination, so take control and reach for the sky! ',24,7,'2015-03-10 00:00:00',0);
/*!40000 ALTER TABLE `myitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `myorder`
--

DROP TABLE IF EXISTS `myorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `myorder` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `time` datetime NOT NULL,
  `state` int(1) NOT NULL,
  `user_id` int(8) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_order_user1_idx` (`user_id`),
  CONSTRAINT `fk_order_user1` FOREIGN KEY (`user_id`) REFERENCES `myuser` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `myorder`
--

LOCK TABLES `myorder` WRITE;
/*!40000 ALTER TABLE `myorder` DISABLE KEYS */;
INSERT INTO `myorder` VALUES (1,'2015-09-24 20:55:15',2,16),(2,'2015-09-24 20:59:53',2,17),(3,'2015-09-24 21:00:44',2,17),(4,'2015-09-24 21:01:25',2,17),(5,'2015-09-24 21:01:51',2,17),(6,'2015-09-24 21:08:11',2,20),(7,'2015-09-24 21:14:27',2,21),(8,'2015-09-24 21:18:13',2,18),(9,'2015-09-24 21:19:08',2,18),(10,'2015-09-24 21:19:19',2,19),(11,'2015-09-24 21:19:43',2,18),(12,'2015-09-24 21:19:55',2,19),(13,'2015-09-24 21:19:58',2,12),(14,'2015-09-24 21:20:29',2,18),(15,'2015-09-24 21:20:51',2,19),(16,'2015-09-24 21:22:38',2,19),(17,'2015-09-24 21:22:56',2,23),(18,'2015-09-24 21:23:24',2,22),(19,'2015-09-24 21:27:05',2,22),(20,'2015-09-24 21:32:15',2,18),(21,'2015-09-24 21:32:52',2,18),(22,'2015-09-24 21:44:20',2,24),(23,'2015-09-24 21:55:22',2,18);
/*!40000 ALTER TABLE `myorder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `myuser`
--

DROP TABLE IF EXISTS `myuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `myuser` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `password` varchar(32) NOT NULL,
  `username` varchar(20) NOT NULL,
  `email` varchar(45) NOT NULL,
  `tel` char(11) NOT NULL,
  `charge` float NOT NULL,
  `token` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `myuser`
--

LOCK TABLES `myuser` WRITE;
/*!40000 ALTER TABLE `myuser` DISABLE KEYS */;
INSERT INTO `myuser` VALUES (12,'81dc9bdb52d04dc20036dbd8313ed055','betakuang','beta.kuang@gmail.com','12345678',9965.02,''),(13,'81dc9bdb52d04dc20036dbd8313ed055','test','beta.kuang@gmail.com','123456678',0,NULL),(14,'81dc9bdb52d04dc20036dbd8313ed055','lovol','lxtlovol@163.com','110',0,'lb99uxcvw0gcpniqjgjhahrskwpuq3fo'),(15,'56f2c6adcabaac40de3521c37dc64609','gaoboyang','1012276012@qq.com','18511073185',0,'f3ovlh9rfli0kyqq23282x7ozht7hyi6'),(16,'81dc9bdb52d04dc20036dbd8313ed055','ccccccc','523332@qq.com','123456789',29920,''),(17,'56f2c6adcabaac40de3521c37dc64609','Yang','1012276012@qq.com','18511073185',2792.54,''),(18,'e10adc3949ba59abbe56e057f20f883e','GilC','c@live.cn','123456789',592.12,'uffkp0ek2gj3qww82dmvql80va9sxllj'),(19,'202cb962ac59075b964b07152d234b70','asdfasdf','asdf@asdf.com','12345',1715.06,''),(20,'56f2c6adcabaac40de3521c37dc64609','ashland','1012276012@qq.com','18511073185',1352.54,''),(21,'d0970714757783e6cf17b26fb8e2298f','heyidi','heyidine@163.com','18673257000',9985.01,'ktzkbaysbvcjsslokieg12fggz6fv1q4'),(22,'202cb962ac59075b964b07152d234b70','aaaa','asdf@adsf.com','123123123',8.01,''),(23,'e10adc3949ba59abbe56e057f20f883e','asdfg','12345135','1234567',1365.02,''),(24,'202cb962ac59075b964b07152d234b70','suchang','suchang@163.com','12345',55,'');
/*!40000 ALTER TABLE `myuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_item`
--

DROP TABLE IF EXISTS `order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_item` (
  `myItem_id` int(8) NOT NULL,
  `myOrder_id` int(8) NOT NULL,
  `Order_Item_id` int(8) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Order_Item_id`),
  UNIQUE KEY `Order_Item_id_UNIQUE` (`Order_Item_id`),
  KEY `fk_Order_Item_myOrder1_idx` (`myOrder_id`),
  KEY `fk_Order_Item_myItem1` (`myItem_id`),
  CONSTRAINT `fk_Order_Item_myItem1` FOREIGN KEY (`myItem_id`) REFERENCES `myitem` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Order_Item_myOrder1` FOREIGN KEY (`myOrder_id`) REFERENCES `myorder` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_item`
--

LOCK TABLES `order_item` WRITE;
/*!40000 ALTER TABLE `order_item` DISABLE KEYS */;
INSERT INTO `order_item` VALUES (5,1,1),(12,1,2),(25,2,3),(23,2,4),(26,3,5),(11,4,6),(30,5,7),(5,6,8),(1,6,9),(25,6,10),(29,6,11),(23,6,12),(29,7,13),(30,8,14),(25,9,15),(12,9,16),(15,9,17),(25,10,18),(12,10,19),(1,10,20),(11,11,21),(10,11,22),(13,11,23),(29,12,24),(11,12,25),(5,13,26),(29,13,27),(5,14,28),(4,15,29),(7,16,30),(11,17,31),(5,17,32),(25,17,33),(25,18,34),(11,19,35),(3,20,36),(18,21,37),(25,22,38),(28,23,39),(2,23,40),(22,23,41);
/*!40000 ALTER TABLE `order_item` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-09-24 22:28:44
