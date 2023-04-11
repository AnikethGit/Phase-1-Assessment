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
-- Table structure for table `complaint`
--

DROP TABLE IF EXISTS `complaint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `complaint` (
  `id` int NOT NULL,
  `address` varchar(255) NOT NULL,
  `assigned_engineer` varchar(255) DEFAULT NULL,
  `complaint` varchar(255) NOT NULL,
  `contact` varchar(255) NOT NULL,
  `date` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `is_assigned` bit(1) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `pin_code` int NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `state` varchar(255) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `complaint`
--

LOCK TABLES `complaint` WRITE;
/*!40000 ALTER TABLE `complaint` DISABLE KEYS */;
INSERT INTO `complaint` VALUES (30,'Bhubaneshwar','ankit@abc','Unable to make a call','8974651323','11-Apr-2023','Abhijit',_binary '',_binary '','Mohanty',769001,'WIP','Odisha','WIP','abhijit@abc'),(31,'Daltonganj','krushna@abc','Unable to receive a call','9723121862','11-Apr-2023','Rahul',_binary '',_binary '','Upadhyay',769002,'WIP','Jharkhand','WIP','rahul@abc'),(32,'Bimlagarh','tahseen@abc','Phone dead','7986651329','11-Apr-2023','Pinky',_binary '\0',_binary '','Sahu',769003,'Issue Escalated','Odisha','ESCALATED','pinky@abc'),(33,'Nagpur','krushna@abc','Noisy voice','98323232933','11-Apr-2023','Swaty',_binary '\0',_binary '','Sahu',769001,'Issue Resolved','Maharashtra','RESOLVED','swaty@abc'),(34,'Ranchi','ankit@abc','Slow broadband speed','9786319865','11-Apr-2023','Nicky',_binary '\0',_binary '','Sahu',769002,'Issue Resolved','Jharkhand','RESOLVED','nicky@abc');
/*!40000 ALTER TABLE `complaint` ENABLE KEYS */;
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
