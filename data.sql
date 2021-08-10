-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: personalweb
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article` (
  `article_id` int NOT NULL,
  `articleName` char(32) DEFAULT NULL,
  `label` char(32) DEFAULT NULL,
  `viewCount` int DEFAULT NULL,
  `commentCount` int DEFAULT NULL,
  `content` text,
  `posttime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (0,'关于梦想','感悟',3,0,'我有一个理想，那是一个绚丽多彩的梦，梦里我的我曾经当上了科学家、艺术家、作家等等。在这个梦中，我想了太多，经历了太多。只为着一个目的，做一个为人民服务，对国家有用的人。而今天，我将用咒语把梦的宝藏开启，带你遨游我的梦之国度。','2021-08-10 01:02:43'),(1,'关于Vue','技术',13,2,'Vue 是一套用于构建用户界面的渐进式框架。库（插件）是一种封装好的特定方法集合，对项目的侵入性较小，提供给开发者使用，控制权在使用者手中，如果某个库无法完成某些需求，可以很容易切换到其它库实现需求。','2021-08-10 01:03:45'),(2,'关于日记','日记',4,0,'一个人把自己在每天的工作、学习和生活中的事情、感想和见闻有选择地、真实地记录下来，这就是日记。坚持写日记，可以积累知识、积累生活经验和写作素材；有助于培养观察能力、理解能力和表达能力；有助于提高思想品德修养，激励自己不断进步；有助于锻炼意志，培养恒心。','2021-08-10 01:04:09'),(3,'关于美食','美食',7,0,'美食可以是一种习惯，能让生活变得怡然自乐，称心快意。在我看来，食物的美，既有食物本身带给味蕾的美妙，又有源自生活中的点滴快乐。拥有美食和享受美食的快乐，是构成幸福生活的重要部分。品味美食，总能让人得到心理上的满足，是一种让自己快乐的生活方式，是真实自然的慰藉；是一种向生命表达善意的举动，是水到渠成的升华。','2021-08-10 01:04:44');
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `comment_id` int NOT NULL,
  `artId` int DEFAULT NULL,
  `userId` int DEFAULT NULL,
  `pid` int DEFAULT NULL,
  `leaveId` int DEFAULT NULL,
  `leavePid` int DEFAULT NULL,
  `content` text,
  `tempname` varchar(30) DEFAULT NULL,
  `tempemail` varchar(40) DEFAULT NULL,
  `posttime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (0,0,0,0,0,0,'哟，几天不见这么拉了','','','2021-08-07 02:01:01'),(1,-1,-1,0,4,0,'棒棒哒！','','','2021-08-10 01:18:03'),(2,-1,-1,0,4,0,'棒棒哒！','','','2021-08-10 01:18:22'),(3,-1,0,0,4,0,'真不错','','','2021-08-10 01:22:37'),(4,-1,-1,0,3,0,'我们很厉害','','','2021-08-10 01:27:26'),(5,-1,-1,0,4,0,'你们好','','','2021-08-10 01:28:38'),(6,-1,-1,0,3,0,'顶顶','','','2021-08-10 01:29:13'),(7,1,-1,0,0,0,'我们真的很棒','我的很大','111@123.com','2021-08-10 01:44:25'),(8,1,-1,0,3,0,'厉害呀','','','2021-08-10 01:44:57'),(9,1,-1,0,4,0,'你们好吗','','','2021-08-10 01:45:32'),(10,1,-1,0,3,0,'真的厉害','','','2021-08-10 01:47:42'),(11,1,-1,0,3,0,'早上好','','','2021-08-10 01:49:14'),(12,1,-1,0,3,0,'明天好','明天','123@123.com','2021-08-10 01:53:20');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `likecollect`
--

DROP TABLE IF EXISTS `likecollect`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `likecollect` (
  `userId` int NOT NULL,
  `artId` int NOT NULL,
  `type` int NOT NULL,
  PRIMARY KEY (`userId`,`artId`,`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `likecollect`
--

LOCK TABLES `likecollect` WRITE;
/*!40000 ALTER TABLE `likecollect` DISABLE KEYS */;
INSERT INTO `likecollect` VALUES (0,0,3);
/*!40000 ALTER TABLE `likecollect` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `likecount`
--

DROP TABLE IF EXISTS `likecount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `likecount` (
  `id` int NOT NULL DEFAULT '0',
  `likeCount` int DEFAULT '100',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `likecount`
--

LOCK TABLES `likecount` WRITE;
/*!40000 ALTER TABLE `likecount` DISABLE KEYS */;
INSERT INTO `likecount` VALUES (0,0);
/*!40000 ALTER TABLE `likecount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message` (
  `message_id` int NOT NULL,
  `userId` int DEFAULT NULL,
  `content` text,
  `posttime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL,
  `username` varchar(16) DEFAULT NULL,
  `password` varchar(16) DEFAULT NULL,
  `email` varchar(16) DEFAULT NULL,
  `avatar` varchar(32) DEFAULT NULL,
  `label` varchar(16) DEFAULT NULL,
  `sex` int DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (0,'admin','123456','123@163.com','./res/avatar/1.jpg','小萌新',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-10 19:05:34
