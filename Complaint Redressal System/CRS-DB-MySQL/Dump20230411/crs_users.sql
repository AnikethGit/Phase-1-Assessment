-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: crs
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL,
  `email` varchar(255) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `pin_code` int NOT NULL,
  `role_name` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'anikethsahu580@gmail.com',_binary '','Aniketh','Sahu','$2a$10$wXOQGG7r6vwng8XZoOvrXOhQsznpy9FrT1qW1/ZhalCwLi3F8nA7y','+919876543210',769004,'ADMIN','crs-admin@abc.com'),(3,'abhijit@gmail.com',_binary '','Abhijit','Mohanty','$2a$10$4HhnAKLhkCqVEeuis4sas.atOpyai0NjLDAETAOfwFki4/cPW0xPi','8974651323',769001,'CUSTOMER','abhijit@abc'),(5,'sweetleena@gmail.com',_binary '','Sweetleena','Banjeeta','$2a$10$Q6MuUf23BdfxtK6nsr/jre3vpPLu1FiVexmOND7D8d/bLmRi9epTm','5698741238',769001,'MANAGER','sweetleena@abc'),(7,'ankit@gmail.com',_binary '','Ankit','Mehta','$2a$10$C6AdzHxLENdUywjq0MUG/umtaCfPZDDP3YI13w.6Fy/zCdFOiMye.','1236579453',769001,'ENGINEER','ankit@abc'),(9,'rahul@gmail.com',_binary '','Rahul','Upadhyay','$2a$10$c4q2g5lmuAi3.MZ38x2Fp.sys6WE6FJNT2HFzABfdT6Ag73J9lKNG','9723121862',769002,'CUSTOMER','rahul@abc'),(11,'rajesh@gmail.com',_binary '','Rajesh','Davili','$2a$10$PQdz4c6ih6vBLTjEip4Yfe1Mov6mzFfK2XpUh98Qr.2R0V6LZUHwu','8956132132',769002,'MANAGER','rajesh@abc'),(13,'krushna@gmail.com',_binary '','Krushna','Sahoo','$2a$10$O5dbHatcSEYjHGffpAO6GOjzNT7Yvj3pREnBvHjlQcXE71Jt3Hpnq','7896541235',769002,'ENGINEER','krushna@abc'),(15,'tahseen@gmail.com',_binary '','Tahseen','Rahman','$2a$10$35cLzHOwC9ra9sLiG544r.Idn2a9c.XbWCcoVcU6cgiPUJFigzQrq','7865942368',769003,'ENGINEER','tahseen@abc'),(17,'pinky@gmail.com',_binary '','Pinky','Sahu','$2a$10$IFClT5T0.HSwSQPpOUfe8.eMziHHBxrVE/M6AB3grL0Xd2mYQC9lq','7986651329',769003,'CUSTOMER','pinky@abc'),(19,'swaty@gmail.com',_binary '','Swaty','Sahu','$2a$10$aVao0qjXTZXEnBzISUOuX.2Qbw8qIpVH.D7azgJB4sLv.kawILZxW','98323232933',769001,'CUSTOMER','swaty@abc'),(21,'nicky@gmail.com',_binary '','Nicky','Sahu','$2a$10$hexgtv456sYBmpXJNSgxsus/1n6aFU8Xn2w6Yd6QQCuGKncPXZ2ja','9786319865',769002,'CUSTOMER','nicky@abc'),(28,'anshu@gmail.com',_binary '','Anshu','Sahu','$2a$10$UEKnjhVAyuHf.uyY5Hl5t.L26U1gTPXBQ5AtBhnfRU/7zbksBlsnu','6977136+95',769003,'MANAGER','anshu@abc');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-11 19:40:23
