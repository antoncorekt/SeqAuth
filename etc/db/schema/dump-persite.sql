-- MySQL dump 10.13  Distrib 5.7.17, for Linux (x86_64)
--
-- Host: localhost    Database: persite
-- ------------------------------------------------------
-- Server version	5.7.17-0ubuntu0.16.04.1

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
-- Table structure for table `DATABASECHANGELOG`
--

DROP TABLE IF EXISTS `DATABASECHANGELOG`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DATABASECHANGELOG` (
  `ID` varchar(255) NOT NULL,
  `AUTHOR` varchar(255) NOT NULL,
  `FILENAME` varchar(255) NOT NULL,
  `DATEEXECUTED` datetime NOT NULL,
  `ORDEREXECUTED` int(11) NOT NULL,
  `EXECTYPE` varchar(10) NOT NULL,
  `MD5SUM` varchar(35) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `COMMENTS` varchar(255) DEFAULT NULL,
  `TAG` varchar(255) DEFAULT NULL,
  `LIQUIBASE` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DATABASECHANGELOG`
--

LOCK TABLES `DATABASECHANGELOG` WRITE;
/*!40000 ALTER TABLE `DATABASECHANGELOG` DISABLE KEYS */;
INSERT INTO `DATABASECHANGELOG` VALUES ('0.0.1','Anton','etc/db/changelog.xml','2017-03-23 21:29:15',1,'EXECUTED','7:17e0df3c6ce5f6df5009f92fbab1dc52','sqlFile','',NULL,'3.1.1'),('0.0.2','Anton','etc/db/changelog.xml','2017-03-23 21:29:15',2,'EXECUTED','7:3dc32137f12f6717b66cf7c74da13a9a','sqlFile','',NULL,'3.1.1');
/*!40000 ALTER TABLE `DATABASECHANGELOG` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DATABASECHANGELOGLOCK`
--

DROP TABLE IF EXISTS `DATABASECHANGELOGLOCK`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DATABASECHANGELOGLOCK` (
  `ID` int(11) NOT NULL,
  `LOCKED` bit(1) NOT NULL,
  `LOCKGRANTED` datetime DEFAULT NULL,
  `LOCKEDBY` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DATABASECHANGELOGLOCK`
--

LOCK TABLES `DATABASECHANGELOGLOCK` WRITE;
/*!40000 ALTER TABLE `DATABASECHANGELOGLOCK` DISABLE KEYS */;
INSERT INTO `DATABASECHANGELOGLOCK` VALUES (1,'\0',NULL,NULL);
/*!40000 ALTER TABLE `DATABASECHANGELOGLOCK` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `UserConnection`
--

DROP TABLE IF EXISTS `UserConnection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `UserConnection` (
  `userId` varchar(255) NOT NULL,
  `providerId` varchar(255) NOT NULL,
  `providerUserId` varchar(255) NOT NULL,
  `rank` int(11) NOT NULL,
  `displayName` varchar(255) DEFAULT NULL,
  `profileUrl` varchar(512) DEFAULT NULL,
  `imageUrl` varchar(512) DEFAULT NULL,
  `accessToken` varchar(255) NOT NULL,
  `secret` varchar(255) DEFAULT NULL,
  `refreshToken` varchar(255) DEFAULT NULL,
  `expireTime` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`userId`,`providerId`,`providerUserId`),
  UNIQUE KEY `UserConnectionRank` (`userId`,`providerId`,`rank`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `UserConnection`
--

LOCK TABLES `UserConnection` WRITE;
/*!40000 ALTER TABLE `UserConnection` DISABLE KEYS */;
INSERT INTO `UserConnection` VALUES ('KOZLOVSKY@KO','facebook','715697101924356',1,NULL,'http://facebook.com/profile.php?id=715697101924356','http://graph.facebook.com/715697101924356/picture','EAAOPAMxFBOgBAL7cpNCbk5HXQalCBpKiR0XYKDFntBNZBVSCEFDZAjAsaeU6c06zJkLbAsgf7ZA9dlFXDg2LtkXMq43Pd9vfV4ioLTgZBWLjZAhPZBEH2ofnPi3hCxM93SYJP5EZApofQunK8fwmwIHx3eWJaRySi4ZD',NULL,NULL,1495723859766);
/*!40000 ALTER TABLE `UserConnection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stat`
--

DROP TABLE IF EXISTS `stat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ip` varchar(255) DEFAULT NULL,
  `time_login` bigint(20) DEFAULT NULL,
  `time_logout` bigint(20) DEFAULT NULL,
  `users_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_q70xnfrm1eqrw2r4omk65q49v` (`users_id`),
  CONSTRAINT `FK_q70xnfrm1eqrw2r4omk65q49v` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stat`
--

LOCK TABLES `stat` WRITE;
/*!40000 ALTER TABLE `stat` DISABLE KEYS */;
INSERT INTO `stat` VALUES (1,'k',1490110804459,NULL,42),(2,'127.0.0.1',1490111141994,NULL,NULL);
/*!40000 ALTER TABLE `stat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_accounts`
--

DROP TABLE IF EXISTS `user_accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_accounts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `creation_time` datetime NOT NULL,
  `email` varchar(100) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `modification_time` datetime NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `register_key` varchar(255) DEFAULT NULL,
  `enaeble` varchar(40) DEFAULT NULL,
  `role` varchar(20) NOT NULL,
  `sign_in_provider` varchar(20) DEFAULT NULL,
  `version` bigint(20) NOT NULL,
  `acc` bigint(20) DEFAULT NULL,
  `rsa` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  KEY `acc` (`acc`),
  CONSTRAINT `user_accounts_ibfk_1` FOREIGN KEY (`acc`) REFERENCES `user_accounts` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_accounts`
--

LOCK TABLES `user_accounts` WRITE;
/*!40000 ALTER TABLE `user_accounts` DISABLE KEYS */;
INSERT INTO `user_accounts` VALUES (13,'2017-03-24 21:15:12','dcsdc@cdscsdcsdc','??????','?????','2017-03-24 21:15:12','$2a$10$M6NCIYBFMAfNS9ptBKyAwOCs2py0.Cs5QoFKysmkCUj08nW58qBc6','7f6d09f2-acff-4c89-814f-cde5716a9398','not accept','ROLE_USER',NULL,0,NULL,NULL),(15,'2017-03-24 21:15:59','kloppppp@mlk','sdcs','sdcs','2017-03-24 21:15:59','$2a$10$OavXJ1WBU4rayAAXJ1q37.i25LMK/4WsIv3yHt1/eEeL1UkvNKu9u','9b4f909a-84a2-44ae-b3f0-efe35325a6a3','not accept','ROLE_USER',NULL,0,NULL,NULL),(17,'2017-03-24 21:25:44','sdcsdcqq@ppppmmn','sdcsdcs','dcsdcs','2017-03-24 21:25:44','$2a$10$uE6hOm8d5gJvM0l8R7h2bOFmOuT1C6X.0ZqI/FH0JXiz6ujrePXaW','93ff06af-9439-49b8-a04f-c05f45950210','not accept','ROLE_USER',NULL,0,NULL,NULL),(21,'2017-03-24 21:32:33','q@q111','1','q','2017-03-24 21:32:54','$2a$10$thoiq8nrgUexn3g1THpxwuQOzaBzB0Dx5aTVfi8BDj69TcNyAd9k.','bb93dce4-4de7-43f2-b78a-527c05bbc618','accept','ROLE_USER',NULL,1,NULL,NULL),(23,'2017-03-24 21:42:40','lol@lol','TEst','Data','2017-03-24 21:42:40','$2a$10$4bwYjM2PCBD2FNlAabUv5OuLbYdOey2BVBheIKDLx0BFi818yMiXC','af332e7c-22a9-4e2f-8868-b7715677e675','accept','ROLE_USER',NULL,1,NULL,NULL),(25,'2017-03-24 22:40:26','sdcsd@dscdccsdcs','csdcsd','sdcsdc','2017-03-24 22:40:26','$2a$10$KCqUhEd9p3pi8Yh6ZxODwek/T4Md0LF7Rh1gcMuRjTQNKdq.mn2iK','5d2d7435-3bd2-4e89-8d7a-f1aaffd04434','accept','ROLE_USER',NULL,1,NULL,NULL),(26,'2017-03-24 22:43:53','KOZLOVSKY@KO','ANTON','KOZLOVSKY','2017-03-24 22:43:53',NULL,'c9a15645-041f-4552-bb5a-62ff5a7fc227','accept','ROLE_USER','FACEBOOK',0,NULL,NULL),(28,'2017-03-25 06:22:14','a@a','csdcsdcs','dcsdcs','2017-03-25 06:22:14','$2a$10$dKRmDnb0.UvbheTE1KWB5ex7ws/eguFRMtkMaWJaUEMalmThx7pv.','d94bedfd-4fa1-4641-98a3-2d0357e1c8ac','accept','ROLE_USER',NULL,1,NULL,NULL),(29,'2017-03-25 06:25:30','fgbfgbf@q','bfgbf','fgbfgbf','2017-03-25 06:25:30','$2a$10$YtYy3TfWp9Bu8gFatETVZu5KjntiQjdPWpfM.pQiLa7sA9j/p4BDW','ab752055-af35-43ea-92f5-c1421ab4e8aa','not accept','ROLE_USER',NULL,0,NULL,NULL),(31,'2017-03-25 18:37:43','rospamip@sezet.com','Max','Test1','2017-03-25 18:37:43','$2a$10$IUQ2RVEcciO9zUvRmY9eyO0NXSuhpCJZBGDr8ktxQztx282SDVxXW','5f291bcf-64c7-42e8-bb86-55b33f134793','accept','ROLE_USER',NULL,1,NULL,NULL);
/*!40000 ALTER TABLE `user_accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_signin`
--

DROP TABLE IF EXISTS `user_signin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_signin` (
  `id` varchar(255) NOT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `signin_time` datetime NOT NULL,
  `user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_bvpn5inh5oxjd1rih11m984em` (`user`),
  CONSTRAINT `FK_bvpn5inh5oxjd1rih11m984em` FOREIGN KEY (`user`) REFERENCES `user_accounts` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_signin`
--

LOCK TABLES `user_signin` WRITE;
/*!40000 ALTER TABLE `user_signin` DISABLE KEYS */;
INSERT INTO `user_signin` VALUES ('0447edb1-1ed8-4f48-a2b3-e46f72713150','127.0.0.1','2017-03-24 22:30:44',23),('07fe75e9-7e6c-428a-863d-fc68434e081c','127.0.0.1','2017-03-26 14:51:27',23),('17125335-c22e-45a8-9a4c-ad593f6e3594','127.0.0.1','2017-03-25 04:30:20',26),('22d4eb22-94c0-4f64-a778-61f039e5f347','127.0.0.1','2017-03-25 04:28:19',26),('24cac80c-a7c2-44a0-a88a-adf8ecd8c3e6','lololol','2017-03-24 21:25:44',17),('24f8eff6-ab35-42bf-bbb9-c2f0c40b0225','127.0.0.1','2017-03-25 04:35:48',26),('260950bf-a6c0-46e0-8691-578d579433b9','127.0.0.1','2017-03-24 22:35:44',23),('274994ae-72d1-4fbc-ab15-46378af1c697','127.0.0.1','2017-03-25 05:40:22',23),('29d325c3-8066-40c6-ba2a-29d1d9f9a311','127.0.0.1','2017-03-24 22:34:23',23),('2a58bbea-65a6-428f-b1d6-f0a6598bfa7b','lololol','2017-03-24 21:15:12',13),('2e4933e6-a4f2-4865-9a20-0952cd6a2a64','lallalalal','2017-03-24 22:05:12',23),('318a4cf5-215f-4360-9097-0d6789f72c81','ip not found','2017-03-25 04:24:33',26),('36988364-6489-42df-8bc9-e91439041af7','lallalalal','2017-03-24 22:05:07',23),('3b818e65-eaf1-4836-8e11-7293c767dd73','127.0.0.1','2017-03-26 14:51:00',26),('3e5452cc-3b31-48eb-a003-0b61277c776b','lololol1','2017-03-24 21:42:51',23),('3e5cfb2d-ccb6-4c69-b383-406b7ea75fbf','127.0.0.1','2017-03-25 04:37:33',26),('4e30c59a-f52e-49f0-84c2-0d73a46ec1f4','127.0.0.1','2017-03-25 05:41:33',23),('542b3e51-a145-4f50-858f-0278818ce759','127.0.0.1','2017-03-25 12:23:29',26),('547c23d6-b6d4-42d1-b70f-51260c5741ee','10.8.4.2','2017-03-25 18:38:20',31),('63f04f44-2937-4ac9-85d5-15374851737f','127.0.0.1','2017-03-24 22:11:14',23),('666725d1-710f-4626-bd45-127188ce0899','127.0.0.1','2017-03-24 22:39:14',23),('6d1672a3-872b-4e70-b102-a022abc5ff76','127.0.0.1','2017-03-24 22:36:17',23),('77317e91-fab8-48ef-97ee-973d667d9d9b','127.0.0.1','2017-03-25 04:26:20',26),('791ab6c3-5bdd-4d41-ae60-08ec35e1d080','127.0.0.1','2017-03-26 14:57:09',23),('7e885220-1753-4fd0-9c76-74ebf79b8fff','127.0.0.1','2017-03-25 06:22:25',28),('7ef1c10a-948c-4fbd-a9f9-08f3ec68bff6','127.0.0.1','2017-03-26 14:47:17',21),('8efa9eaf-223a-4abb-bbbc-a93699b52c12','lololol1','2017-03-24 21:46:39',23),('9164fd60-2cd7-4773-b650-6c333786c181','127.0.0.1','2017-03-24 22:35:01',23),('9810a6f8-45ac-4571-baac-e058d127f77d','127.0.0.1','2017-03-24 22:38:09',23),('99607f20-d766-488b-82e2-b0f23a31e98a','127.0.0.1','2017-03-26 14:47:12',21),('9c6da1d0-f1b9-4d88-8147-3ea62226185b','127.0.0.1','2017-03-25 12:21:39',21),('9c9c64a0-62d6-42ce-8713-2f360e137243','127.0.0.1','2017-03-25 04:30:12',26),('a4b4105c-6e69-4f92-a8bc-d9c9d917194e','127.0.0.1','2017-03-25 04:12:49',26),('a53635d7-7ef3-4072-930d-a6b6452f5ded','127.0.0.1','2017-03-24 22:40:38',25),('a9791cc7-2b32-45a1-9104-f5f838945de6','lallalalal','2017-03-24 22:04:57',23),('aa5ec151-c075-4125-b2d5-3e9735ffb4e2','127.0.0.1','2017-03-24 22:19:43',23),('ab867b08-7cd3-4891-a54f-4ed1510a6bae','127.0.0.1','2017-03-25 04:30:00',26),('b0e9f2b9-7428-4562-bd99-38da56aa2351','127.0.0.1','2017-03-26 14:56:49',28),('b3b7310d-ca3a-45d8-b732-75391c5ac75d','127.0.0.1','2017-03-24 22:07:40',23),('b7baefb5-42ba-4768-b37b-0db769f3515e','127.0.0.1','2017-03-25 04:30:28',26),('bf7f0e6c-0851-4029-b93e-efd0dbbe26b0','127.0.0.1','2017-03-24 22:29:04',23),('cd6d41b5-5eb2-4fe8-91cc-5e6f6fee875f','127.0.0.1','2017-03-24 22:43:59',26),('d865aba8-9cdf-4520-80be-4041685de1e3','10.8.4.4','2017-03-25 18:45:33',23),('d9cbd97d-85fb-4049-af7c-3cf4a7abcc34','127.0.0.1','2017-03-26 14:48:36',23),('da1ce7e4-d512-4567-9ed2-ff5fa22de7cb','10.8.4.2','2017-03-25 18:38:00',31),('ec6c50e3-2def-41ff-b39e-f305d8e7156a','10.8.4.2','2017-03-25 18:47:02',31),('ecdfaaee-19e6-44ae-a95f-f354f20c7995','lololol1','2017-03-24 21:46:29',23),('ee318c15-0c64-4e5d-9db5-55790b0b9959','lololol','2017-03-24 21:15:59',15),('ef383c49-9840-4e05-bafa-9b20fdbe76b5','127.0.0.1','2017-03-25 04:28:06',26),('f002c58f-c2af-4c22-bbb0-dc3c70a26fb3','127.0.0.1','2017-03-24 22:33:04',23),('f298bd86-f9cc-46e0-9957-bc1f6551688f','127.0.0.1','2017-03-24 22:24:04',23),('f51b2a16-ccad-49da-96df-6fe61ea4eb63','lololol1','2017-03-24 21:32:33',21),('f867581e-c294-484b-8299-9603329b5af7','127.0.0.1','2017-03-24 22:41:00',25),('f99064eb-d8d3-4199-bfc0-8087fc2cfeba','10.8.4.2','2017-03-25 18:37:59',23),('fa6fc407-0bca-4a53-8309-ced597a07013','127.0.0.1','2017-03-24 22:44:04',26);
/*!40000 ALTER TABLE `user_signin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` tinyblob,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `hh` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'¨\Ì\0sr\0\rjava.time.Serï]Ñ∫\"H≤\0\0xpw\r\0\0\0\0X\À\÷Y\‰@x','user','user','c7a4f107fe9bd5fb68fad4a4617cc5990b2083dd9c440416b5fc1957d36aab359ce88e3a80cea488','ROLE_USER',NULL),(2,'¨\Ì\0sr\0\rjava.time.Serï]Ñ∫\"H≤\0\0xpw\r\0\0\0\0X\À\÷\ﬂ˘¿x','admin','admin','88670bc29d0bc660095c46badd18c9831cc594d5b1aa51ea1d27af62e21ee485fcc44d4974a0b86f','ROLE_ADMIN',NULL),(3,'¨\Ì\0sr\0\rjava.time.Serï]Ñ∫\"H≤\0\0xpw\r\0\0\0\0X\À\÷+í,¿x','email','email','pass','USER_ROLE',NULL),(40,'¨\Ì\0sr\0\rjava.time.Serï]Ñ∫\"H≤\0\0xpw\r\0\0\0\0X\—?\Zg§¿x','e@e','e','577ad9e7874d234e28952ecfea7aea98e85dfd090c2c6f31fb797c456188e7961a6c07a6268cf826','ROLE_USER',NULL),(41,'¨\Ì\0sr\0\rjava.time.Serï]Ñ∫\"H≤\0\0xpw\r\0\0\0\0X\—\Œ˙Äx','a@a','aaa','8c582a55396b23e8f77cc4280ea12aca73d3011a5a1ea428476fcaf694e7c0bafab4dcf07e9e5a4c','ROLE_USER',NULL),(42,'¨\Ì\0sr\0\rjava.time.Serï]Ñ∫\"H≤\0\0xpw\r\0\0\0\0X\—\ƒ!†¿x','z@z','z','a5debb163b813fa41e2657843404341a7845ccde0b328b6e4cdce7dd63ca30f56ba0479cc8e188eb','ROLE_USER',NULL),(43,'¨\Ì\0sr\0\rjava.time.Serï]Ñ∫\"H≤\0\0xpw\r\0\0\0\0X\—e8ÅU\0x','scdcs@dfvdf','vdf','deaee80c58ddbbb59d1f2568a0a5f399f9023c7a66257830ac631a5095ae45b3a141e5e4b9231d15','ROLE_USER',NULL),(44,'¨\Ì\0sr\0\rjava.time.Serï]Ñ∫\"H≤\0\0xpw\r\0\0\0\0X\—	ß\ÏÄx','k@k','kkk','7233d97e9a2acf0bd9bc0626cab7b6882959d43fe9e1cb8b4776d41b4aeee050b5e756c4980a90ae','ROLE_USER',NULL),(49,'¨\Ì\0sr\0\rjava.time.Serï]Ñ∫\"H≤\0\0xpw\r\0\0\0\0X\—?2(„áÄx','lololololololo','lololololololo','k','ROLE_USER',NULL),(51,'¨\Ì\0sr\0\rjava.time.Serï]Ñ∫\"H≤\0\0xpw\r\0\0\0\0X\—ITLÜÄx','lololololololo1','lololololololo1','k','ROLE_USER',NULL),(52,'¨\Ì\0sr\0\rjava.time.Serï]Ñ∫\"H≤\0\0xpw\r\0\0\0\0X\—J•;/˙@x','lololololololo2','lololololololo2','k','ROLE_USER',NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'persite'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-30 11:20:34
