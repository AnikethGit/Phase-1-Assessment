CREATE DATABASE  IF NOT EXISTS `flyawaydb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `flyawaydb`;

-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: flyawaydb
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
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flight` (
  `flight_id` varchar(64) COLLATE utf8mb3_unicode_ci NOT NULL,
  `flight_name` varchar(45) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `origin` varchar(128) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `destination` varchar(128) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `days` varchar(128) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `ticket_price` varchar(128) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`flight_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES ('1','Hindustan Air','India','USA','MONDAY, TUESDAY, THURSDAY, SATURDAY','35433'),('2','Air USA','USA','India','MONDAY, TUESDAY, THURSDAY, SATURDAY, FRIDAY','37560'),('3','IndiaEuropa','India','UK','MONDAY, TUESDAY, THURSDAY, SATURDAY, FRIDAY, WEDNESDAY','44560'),('4','UK Air','UK','India','MONDAY, TUESDAY, THURSDAY, SATURDAY, FRIDAY, WEDNESDAY','47855'),('5','FlyHigh','UK','USA','MONDAY, TUESDAY, THURSDAY, SATURDAY, FRIDAY, WEDNESDAY','37525'),('6','AmericanAirX','USA','UK','MONDAY, TUESDAY, THURSDAY, SATURDAY, FRIDAY, WEDNESDAY','68999');
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-14  0:09:45
