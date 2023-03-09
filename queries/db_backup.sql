-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: hotel_springboot_db
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `advances`
--

DROP TABLE IF EXISTS `advances`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `advances` (
  `advanceID` int NOT NULL AUTO_INCREMENT,
  `description` varchar(100) NOT NULL,
  `amount` decimal(7,2) NOT NULL,
  `date` date NOT NULL DEFAULT (curdate()),
  `employeeID` char(11) NOT NULL,
  `handlerManagerID` char(11) NOT NULL,
  `deletedAt` datetime DEFAULT NULL,
  PRIMARY KEY (`advanceID`),
  KEY `employeeID` (`employeeID`),
  KEY `handlerManagerID` (`handlerManagerID`),
  CONSTRAINT `advances_ibfk_1` FOREIGN KEY (`employeeID`) REFERENCES `employees` (`employeeID`),
  CONSTRAINT `advances_ibfk_2` FOREIGN KEY (`handlerManagerID`) REFERENCES `managers` (`managerID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `advances`
--

LOCK TABLES `advances` WRITE;
/*!40000 ALTER TABLE `advances` DISABLE KEYS */;
INSERT INTO `advances` VALUES (2,'old year',80.00,'2022-10-12','CHEFS001','MANGR001','2022-10-13 07:28:46'),(3,'week advance',699.00,'2022-10-13','CASHR001','MANGR001',NULL),(4,'old year',4000.00,'2022-10-13','CHEFS001','MANGR001',NULL);
/*!40000 ALTER TABLE `advances` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `advances_view`
--

DROP TABLE IF EXISTS `advances_view`;
/*!50001 DROP VIEW IF EXISTS `advances_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `advances_view` AS SELECT 
 1 AS `advanceID`,
 1 AS `description`,
 1 AS `amount`,
 1 AS `date`,
 1 AS `employeeID`,
 1 AS `handlerManagerID`,
 1 AS `deletedAt`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `bills`
--

DROP TABLE IF EXISTS `bills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bills` (
  `orderID` int NOT NULL,
  `itemID` char(8) NOT NULL,
  `unitPrice` decimal(7,2) NOT NULL,
  `quantity` int NOT NULL,
  `deletedAt` datetime DEFAULT NULL,
  PRIMARY KEY (`orderID`,`itemID`),
  KEY `itemID` (`itemID`),
  CONSTRAINT `bills_ibfk_1` FOREIGN KEY (`orderID`) REFERENCES `orders` (`orderID`),
  CONSTRAINT `bills_ibfk_2` FOREIGN KEY (`itemID`) REFERENCES `items` (`itemID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bills`
--

LOCK TABLES `bills` WRITE;
/*!40000 ALTER TABLE `bills` DISABLE KEYS */;
INSERT INTO `bills` VALUES (1,'ITEMS001',1500.00,2,NULL),(1,'ITEMS002',2000.00,1,NULL),(3,'ITEMS001',1500.00,3,NULL),(3,'ITEMS002',2000.00,3,NULL);
/*!40000 ALTER TABLE `bills` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `after_bills_insert_netPrice_cal` AFTER INSERT ON `bills` FOR EACH ROW BEGIN
	DECLARE currentNetPrice, newNetPrice DECIMAL(8,2);
	DECLARE id INT;
    
    SET id = NEW.orderID;
	
    SELECT netPrice
    INTO currentNetPrice
    FROM orders
    WHERE orderID = id;
    
    IF currentNetPrice IS NULL THEN
		SET currentNetPrice = 0.00;
	END IF;
    
    SET newNetPrice = currentNetPrice + (NEW.unitPrice * NEW.quantity);
    
	UPDATE orders
	SET 
		netPrice = newNetPrice
	WHERE orderID = id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `after_bills_update_netPrice_cal` AFTER UPDATE ON `bills` FOR EACH ROW BEGIN
    DECLARE currentNetPrice, newNetPrice DECIMAL(8,2);
	DECLARE id INT;
    
    IF NEW.deletedAt IS NOT NULL THEN
		SET Id = OLD.orderID;
        
        SELECT netPrice
		INTO currentNetPrice
		FROM orders
		WHERE orderID = id;
        
        SET newNetPrice = currentNetPrice - (OLD.unitPrice * OLD.quantity);
        
        IF newNetPrice < 0 THEN
			SET newNetPrice = 0.00;
		END IF;

        UPDATE orders
		SET 
			netPrice = newNetPrice
		WHERE orderID = id;
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `before_bills_delete_netPrice_cal` BEFORE DELETE ON `bills` FOR EACH ROW BEGIN
    DECLARE currentNetPrice, newNetPrice DECIMAL(8,2);
	DECLARE id INT;
    
    IF OLD.deletedAt IS NULL THEN
		SET Id = OLD.orderID;
        
        SELECT netPrice
		INTO currentNetPrice
		FROM orders
		WHERE orderID = id;
        
		SET newNetPrice = currentNetPrice - (OLD.unitPrice * OLD.quantity);
        
        IF newNetPrice < 0 THEN
			SET newNetPrice = 0.00;
		END IF;

        UPDATE orders
		SET 
			netPrice = newNetPrice
		WHERE orderID = id;
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `bonuses`
--

DROP TABLE IF EXISTS `bonuses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bonuses` (
  `bonusID` int NOT NULL AUTO_INCREMENT,
  `employeeID` char(8) NOT NULL,
  `amount` decimal(7,2) NOT NULL,
  `description` varchar(100) NOT NULL,
  `date` date NOT NULL DEFAULT (curdate()),
  `deletedAt` datetime DEFAULT NULL,
  PRIMARY KEY (`bonusID`),
  KEY `employeeID` (`employeeID`),
  CONSTRAINT `bonuses_ibfk_1` FOREIGN KEY (`employeeID`) REFERENCES `employees` (`employeeID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bonuses`
--

LOCK TABLES `bonuses` WRITE;
/*!40000 ALTER TABLE `bonuses` DISABLE KEYS */;
INSERT INTO `bonuses` VALUES (2,'CASHR001',4500.00,'newold year','2022-10-12','2022-10-13 07:27:37'),(3,'CASHR001',4000.00,'old year','2022-10-13',NULL),(4,'CASHR001',4000.00,'old year','2022-10-13',NULL);
/*!40000 ALTER TABLE `bonuses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `bonuses_view`
--

DROP TABLE IF EXISTS `bonuses_view`;
/*!50001 DROP VIEW IF EXISTS `bonuses_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `bonuses_view` AS SELECT 
 1 AS `bonusID`,
 1 AS `employeeID`,
 1 AS `amount`,
 1 AS `description`,
 1 AS `date`,
 1 AS `deletedAt`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `bookings`
--

DROP TABLE IF EXISTS `bookings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookings` (
  `bookingID` int NOT NULL AUTO_INCREMENT,
  `guestID` char(10) NOT NULL,
  `dateFrom` date NOT NULL,
  `dateTo` date NOT NULL,
  `status` char(9) NOT NULL DEFAULT 'Reserved',
  `billingAmount` decimal(8,2) DEFAULT NULL,
  `noOfPerson` int NOT NULL,
  `checkIn` datetime DEFAULT NULL,
  `checkOut` datetime DEFAULT NULL,
  `receptionistID` char(8) NOT NULL,
  `deletedAt` datetime DEFAULT NULL,
  PRIMARY KEY (`bookingID`),
  KEY `guestID` (`guestID`),
  KEY `receptionistID` (`receptionistID`),
  CONSTRAINT `bookings_ibfk_1` FOREIGN KEY (`guestID`) REFERENCES `guests` (`telNo`),
  CONSTRAINT `bookings_ibfk_2` FOREIGN KEY (`receptionistID`) REFERENCES `receptionists` (`receptionistID`),
  CONSTRAINT `bookings_chk_1` CHECK ((`Status` in (_utf8mb4'Reserved',_utf8mb4'Confirmed',_utf8mb4'Cancelled',_utf8mb4'Completed')))
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookings`
--

LOCK TABLES `bookings` WRITE;
/*!40000 ALTER TABLE `bookings` DISABLE KEYS */;
INSERT INTO `bookings` VALUES (1,'0717893412','2023-11-10','2023-11-12','Cancelled',38000.00,5,'2022-10-15 19:14:58','2022-10-15 19:15:15','RECEP001','2022-10-15 19:16:25'),(2,'0717893412','2023-11-10','2023-11-12','Cancelled',20000.00,3,'2022-10-15 20:57:38','2022-10-15 20:58:06','RECEP001',NULL),(11,'0717893412','2022-11-10','2022-11-12','Reserved',38000.00,4,NULL,NULL,'RECEP001',NULL);
/*!40000 ALTER TABLE `bookings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `bookings_view`
--

DROP TABLE IF EXISTS `bookings_view`;
/*!50001 DROP VIEW IF EXISTS `bookings_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `bookings_view` AS SELECT 
 1 AS `bookingID`,
 1 AS `guestID`,
 1 AS `dateFrom`,
 1 AS `dateTo`,
 1 AS `status`,
 1 AS `billingAmount`,
 1 AS `noOfPerson`,
 1 AS `checkIn`,
 1 AS `checkOut`,
 1 AS `receptionistID`,
 1 AS `deletedAt`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `cashiers`
--

DROP TABLE IF EXISTS `cashiers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cashiers` (
  `cashierID` char(8) NOT NULL,
  PRIMARY KEY (`cashierID`),
  CONSTRAINT `cashiers_ibfk_1` FOREIGN KEY (`cashierID`) REFERENCES `employees` (`employeeID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cashiers`
--

LOCK TABLES `cashiers` WRITE;
/*!40000 ALTER TABLE `cashiers` DISABLE KEYS */;
INSERT INTO `cashiers` VALUES ('CASHR001');
/*!40000 ALTER TABLE `cashiers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chefs`
--

DROP TABLE IF EXISTS `chefs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chefs` (
  `chefID` char(8) NOT NULL,
  PRIMARY KEY (`chefID`),
  CONSTRAINT `chefs_ibfk_1` FOREIGN KEY (`chefID`) REFERENCES `employees` (`employeeID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chefs`
--

LOCK TABLES `chefs` WRITE;
/*!40000 ALTER TABLE `chefs` DISABLE KEYS */;
INSERT INTO `chefs` VALUES ('CHEFS001'),('CHEFS002'),('CHEFS003');
/*!40000 ALTER TABLE `chefs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `employeeID` char(8) NOT NULL,
  `employeeType` varchar(20) NOT NULL,
  `title` varchar(5) NOT NULL,
  `nic` varchar(12) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) DEFAULT NULL,
  `dob` date NOT NULL,
  `sex` char(6) NOT NULL,
  `telNo` char(10) NOT NULL,
  `address` varchar(150) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `salary` decimal(8,2) NOT NULL,
  `status` char(10) NOT NULL DEFAULT 'Active',
  `joinedDate` date DEFAULT (curdate()),
  `deletedAt` datetime DEFAULT NULL,
  PRIMARY KEY (`employeeID`),
  CONSTRAINT `employees_chk_1` CHECK ((`employeeType` in (_utf8mb4'Cashier',_utf8mb4'Chef',_utf8mb4'Manager',_utf8mb4'Receptionist',_utf8mb4'Waiter'))),
  CONSTRAINT `employees_chk_2` CHECK ((`title` in (_utf8mb4'Mr.',_utf8mb4'Miss.',_utf8mb4'Mrs.',_utf8mb4'Ms.'))),
  CONSTRAINT `employees_chk_3` CHECK ((`sex` in (_utf8mb4'Male',_utf8mb4'Female',_utf8mb4'Other'))),
  CONSTRAINT `employees_chk_4` CHECK ((`status` in (_utf8mb4'Active',_utf8mb4'Deactivate')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES ('CASHR001','Cashier','Mr.','96566462674v','Dananjaya','Karunarathna','1996-04-16','Male','0717893412','Gampaha','dana.silva@gmail.com',38500.00,'Active','2022-10-12',NULL),('CHEFS001','Chef','Mr.','96566462674v','Dananjaya','Karunarathna','1996-04-16','Male','0717893412','Gampaha','dana.silva@gmail.com',38500.00,'Active','2022-10-12',NULL),('CHEFS002','Chef','Mr.','972701556V','pra','kas','1997-09-26','Male','0771174613','Mathugama Road, Nagoda, Dodangoda, Kalutara','heshankas26@yahoo.com',65000.00,'Deactivate','2022-10-12','2022-10-12 21:06:26'),('CHEFS003','Chef','Mr.','972701556V','pra','kas','1997-09-26','Male','0771174613','Mathugama Road, Nagoda, Dodangoda, Kalutara','heshankas26@yahoo.com',65000.00,'Deactivate','2022-10-12',NULL),('MANGR001','Manager','Mr.','96566462674v','Dananjaya','Karunarathna','1996-04-16','Male','0717893412','Gampaha','dana.silva@gmail.com',38500.00,'Active','2022-10-12',NULL),('RECEP001','Receptionist','Mr.','96566462674v','Dananjaya','Karunarathna','1996-04-16','Male','0717893412','Gampaha','dana.silva@gmail.com',38500.00,'Active','2022-10-12',NULL),('WAITR001','Waiter','Mr.','96566462674v','Dananjaya','Karunarathna','1996-04-16','Male','0717893412','Gampaha','dana.silva@gmail.com',38500.00,'Active','2022-10-12',NULL);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `after_employees_insert` AFTER INSERT ON `employees` FOR EACH ROW BEGIN
	CASE NEW.employeeType
		WHEN 'Cashier' THEN
			INSERT INTO cashiers (cashierID)
			VALUES (new.employeeID);
        WHEN 'Chef' THEN
			INSERT INTO chefs (chefID)
			VALUES (new.employeeID);
		WHEN 'Manager' THEN
			INSERT INTO managers (managerID)
			VALUES (new.employeeID);
		WHEN 'Receptionist' THEN
			INSERT INTO receptionists (receptionistID)
			VALUES (new.employeeID);
		WHEN 'Waiter' THEN
			INSERT INTO waiters (waiterID)
			VALUES (new.employeeID);
	END CASE;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Temporary view structure for view `employees_view`
--

DROP TABLE IF EXISTS `employees_view`;
/*!50001 DROP VIEW IF EXISTS `employees_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `employees_view` AS SELECT 
 1 AS `employeeID`,
 1 AS `employeeType`,
 1 AS `title`,
 1 AS `nic`,
 1 AS `firstName`,
 1 AS `lastName`,
 1 AS `dob`,
 1 AS `sex`,
 1 AS `telNo`,
 1 AS `address`,
 1 AS `email`,
 1 AS `salary`,
 1 AS `status`,
 1 AS `JoinedDate`,
 1 AS `deletedAt`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `guests`
--

DROP TABLE IF EXISTS `guests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `guests` (
  `telNo` char(10) NOT NULL,
  `title` varchar(5) NOT NULL,
  `nic` varchar(12) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) DEFAULT NULL,
  `sex` char(6) NOT NULL,
  `address` varchar(150) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `deletedAt` datetime DEFAULT NULL,
  PRIMARY KEY (`telNo`),
  CONSTRAINT `guests_chk_1` CHECK ((`title` in (_utf8mb4'Mr.',_utf8mb4'Miss.',_utf8mb4'Mrs.',_utf8mb4'Ms.',_utf8mb4'Rev.'))),
  CONSTRAINT `guests_chk_2` CHECK ((`Sex` in (_utf8mb4'Male',_utf8mb4'Female',_utf8mb4'Other')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guests`
--

LOCK TABLES `guests` WRITE;
/*!40000 ALTER TABLE `guests` DISABLE KEYS */;
INSERT INTO `guests` VALUES ('0717893412','Mr.','96566462674v','Dananjaya','Karunarathna','Male','Gampaha','dana.silva@gmail.com',NULL),('0717893419','Mr.','96566462674v','Dasun','Dananjaya','Male','Kalutara','danaa.silva@gmail.com','2022-10-13 08:08:16');
/*!40000 ALTER TABLE `guests` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `guests_view`
--

DROP TABLE IF EXISTS `guests_view`;
/*!50001 DROP VIEW IF EXISTS `guests_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `guests_view` AS SELECT 
 1 AS `telNo`,
 1 AS `title`,
 1 AS `nic`,
 1 AS `firstName`,
 1 AS `lastName`,
 1 AS `sex`,
 1 AS `address`,
 1 AS `email`,
 1 AS `deletedAt`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `items` (
  `itemID` char(8) NOT NULL,
  `name` varchar(50) NOT NULL,
  `category` varchar(20) NOT NULL,
  `description` varchar(150) DEFAULT NULL,
  `price` decimal(7,2) NOT NULL,
  `image` varchar(300) NOT NULL,
  `deletedAt` datetime DEFAULT NULL,
  PRIMARY KEY (`itemID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` VALUES ('ITEMS001','Dum Biriyani','Main Course','include eggs, checken etc.',1500.00,'http://127.0.0.1:8080/',NULL),('ITEMS002','Prawn Biriyani','Main Course','include checken, prawn etc.',2000.00,'http://127.0.0.1:8080/',NULL);
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `items_view`
--

DROP TABLE IF EXISTS `items_view`;
/*!50001 DROP VIEW IF EXISTS `items_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `items_view` AS SELECT 
 1 AS `itemID`,
 1 AS `name`,
 1 AS `category`,
 1 AS `description`,
 1 AS `price`,
 1 AS `image`,
 1 AS `deletedAt`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `managers`
--

DROP TABLE IF EXISTS `managers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `managers` (
  `managerID` char(8) NOT NULL,
  PRIMARY KEY (`managerID`),
  CONSTRAINT `managers_ibfk_1` FOREIGN KEY (`managerID`) REFERENCES `employees` (`employeeID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `managers`
--

LOCK TABLES `managers` WRITE;
/*!40000 ALTER TABLE `managers` DISABLE KEYS */;
INSERT INTO `managers` VALUES ('MANGR001');
/*!40000 ALTER TABLE `managers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `orderID` int NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL DEFAULT (now()),
  `status` varchar(20) NOT NULL DEFAULT 'Pending',
  `netPrice` decimal(8,2) DEFAULT NULL,
  `waiterID` char(8) NOT NULL,
  `chefID` char(8) DEFAULT NULL,
  `cashierID` char(8) DEFAULT NULL,
  `deletedAt` datetime DEFAULT NULL,
  PRIMARY KEY (`orderID`),
  KEY `waiterID` (`waiterID`),
  KEY `chefID` (`chefID`),
  KEY `cashierID` (`cashierID`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`waiterID`) REFERENCES `waiters` (`waiterID`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`chefID`) REFERENCES `chefs` (`chefID`),
  CONSTRAINT `orders_ibfk_3` FOREIGN KEY (`cashierID`) REFERENCES `cashiers` (`cashierID`),
  CONSTRAINT `orders_chk_1` CHECK ((`Status` in (_utf8mb4'Pending',_utf8mb4'Cooking',_utf8mb4'Cooked',_utf8mb4'Cancelled',_utf8mb4'Paid')))
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'2022-10-12 17:23:42','Cancelled',5000.00,'WAITR001','CHEFS001','CASHR001','2022-10-15 21:00:22'),(3,'2022-10-15 20:53:12','Cancelled',10500.00,'WAITR001','CHEFS001','CASHR001',NULL);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `orders_view`
--

DROP TABLE IF EXISTS `orders_view`;
/*!50001 DROP VIEW IF EXISTS `orders_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `orders_view` AS SELECT 
 1 AS `orderID`,
 1 AS `date`,
 1 AS `status`,
 1 AS `netPrice`,
 1 AS `waiterID`,
 1 AS `chefID`,
 1 AS `cashierID`,
 1 AS `deletedAt`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `receptionists`
--

DROP TABLE IF EXISTS `receptionists`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `receptionists` (
  `receptionistID` char(8) NOT NULL,
  PRIMARY KEY (`receptionistID`),
  CONSTRAINT `receptionists_ibfk_1` FOREIGN KEY (`receptionistID`) REFERENCES `employees` (`employeeID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receptionists`
--

LOCK TABLES `receptionists` WRITE;
/*!40000 ALTER TABLE `receptionists` DISABLE KEYS */;
INSERT INTO `receptionists` VALUES ('RECEP001');
/*!40000 ALTER TABLE `receptionists` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservations`
--

DROP TABLE IF EXISTS `reservations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservations` (
  `bookingID` int NOT NULL,
  `roomID` int NOT NULL,
  `nett` decimal(8,2) NOT NULL,
  `deletedAt` datetime DEFAULT NULL,
  PRIMARY KEY (`bookingID`,`roomID`),
  KEY `roomID` (`roomID`),
  CONSTRAINT `reservations_ibfk_1` FOREIGN KEY (`bookingID`) REFERENCES `bookings` (`bookingID`),
  CONSTRAINT `reservations_ibfk_2` FOREIGN KEY (`roomID`) REFERENCES `rooms` (`roomID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservations`
--

LOCK TABLES `reservations` WRITE;
/*!40000 ALTER TABLE `reservations` DISABLE KEYS */;
INSERT INTO `reservations` VALUES (1,1,20000.00,NULL),(1,2,18000.00,NULL),(2,1,20000.00,NULL),(11,1,20000.00,NULL),(11,2,18000.00,NULL);
/*!40000 ALTER TABLE `reservations` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `after_reservations_insert_billingAmount_cal` AFTER INSERT ON `reservations` FOR EACH ROW BEGIN
	DECLARE currentNett DECIMAL(8,2);
	DECLARE newNett DECIMAL(8,2);
	DECLARE id INT;
    
    SET id = NEW.bookingID;
	
    SELECT billingAmount
    INTO currentNett
    FROM bookings
    WHERE  bookingID = id;
    
    IF currentNett IS NULL THEN
		SET currentNett = 0.00;
	END IF;
    
    SET newNett = currentNett + NEW.nett;
    
	UPDATE bookings
	SET 
		billingAmount = newNett
	WHERE bookingID = id;
    
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `after_reservations_update_billingAmount_cal` AFTER UPDATE ON `reservations` FOR EACH ROW BEGIN
	DECLARE currentNett, newNett DECIMAL(8,2);
	DECLARE Id INT;
    
    IF NEW.deletedAt IS NOT NULL THEN
		SET Id = OLD.bookingID;
        
        SELECT billingAmount
		INTO currentNett
		FROM bookings
		WHERE  bookingID = Id;
        
        SET newNett = currentNett - OLD.nett;
        
        IF newNett < 0 THEN
			SET newNett = 0.00;
		END IF;
        
        UPDATE bookings
		SET 
			billingAmount = newNett
		WHERE bookingID = Id;
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `before_reservations_delete_billingAmount_cal` BEFORE DELETE ON `reservations` FOR EACH ROW BEGIN
	DECLARE currentNett, newNett DECIMAL(8,2);
	DECLARE Id INT;
    
    IF OLD.deletedAt IS NULL THEN
		SET Id = OLD.bookingID;
        
        SELECT billingAmount
		INTO currentNett
		FROM bookings
		WHERE  bookingID = Id;
        
        SET newNett = currentNett - OLD.nett;
        
        IF newNett < 0 THEN
			SET newNett = 0.00;
		END IF;
        
        UPDATE bookings
		SET 
			billingAmount = newNett
		WHERE bookingID = Id;
        
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `rooms`
--

DROP TABLE IF EXISTS `rooms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rooms` (
  `roomID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `roomNo` int NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `bedType` varchar(15) NOT NULL,
  `noOfBed` int NOT NULL,
  `roomType` varchar(10) NOT NULL,
  `charge` decimal(7,2) NOT NULL,
  `deletedAt` datetime DEFAULT NULL,
  PRIMARY KEY (`roomID`),
  CONSTRAINT `rooms_chk_1` CHECK ((`bedType` in (_utf8mb4'Double/Full',_utf8mb4'Queen',_utf8mb4'King'))),
  CONSTRAINT `rooms_chk_2` CHECK ((`roomType` in (_utf8mb4'Single',_utf8mb4'Double',_utf8mb4'Triple',_utf8mb4'Quad')))
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rooms`
--

LOCK TABLES `rooms` WRITE;
/*!40000 ALTER TABLE `rooms` DISABLE KEYS */;
INSERT INTO `rooms` VALUES (1,'Chilax',101,'aaa bb cc','Double/Full',2,'Double',20000.00,NULL),(2,'Chilax 3',201,'bb bb cc','Double/Full',2,'Double',18000.00,NULL);
/*!40000 ALTER TABLE `rooms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `rooms_view`
--

DROP TABLE IF EXISTS `rooms_view`;
/*!50001 DROP VIEW IF EXISTS `rooms_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `rooms_view` AS SELECT 
 1 AS `roomID`,
 1 AS `name`,
 1 AS `roomNo`,
 1 AS `description`,
 1 AS `bedType`,
 1 AS `noOfBed`,
 1 AS `roomType`,
 1 AS `charge`,
 1 AS `deletedAt`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `userloginrecords`
--

DROP TABLE IF EXISTS `userloginrecords`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userloginrecords` (
  `userID` char(8) NOT NULL,
  `loginDate` date NOT NULL DEFAULT (curdate()),
  `loginTime` time NOT NULL DEFAULT (curtime()),
  `logoutTime` time DEFAULT NULL,
  PRIMARY KEY (`userID`,`loginDate`,`loginTime`),
  CONSTRAINT `userloginrecords_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `users` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userloginrecords`
--

LOCK TABLES `userloginrecords` WRITE;
/*!40000 ALTER TABLE `userloginrecords` DISABLE KEYS */;
/*!40000 ALTER TABLE `userloginrecords` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `userID` char(8) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` char(100) NOT NULL,
  `status` char(10) NOT NULL DEFAULT 'Active',
  `employeeID` char(8) NOT NULL,
  `deletedAt` datetime DEFAULT NULL,
  PRIMARY KEY (`userID`),
  KEY `employeeID` (`employeeID`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`employeeID`) REFERENCES `employees` (`employeeID`) ON DELETE CASCADE,
  CONSTRAINT `users_chk_1` CHECK ((`Status` in (_utf8mb4'Active',_utf8mb4'Deactivate')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('USERS001','hotelAdmin','09332014e86ebe7314d17b011ba80edf','Active','CASHR001',NULL),('USERS002','hotelUser123','09332014e86ebe7314d17b011ba80edf','Deactivate','CHEFS002','2022-10-13 05:23:40');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `users_view`
--

DROP TABLE IF EXISTS `users_view`;
/*!50001 DROP VIEW IF EXISTS `users_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `users_view` AS SELECT 
 1 AS `userID`,
 1 AS `username`,
 1 AS `password`,
 1 AS `status`,
 1 AS `employeeID`,
 1 AS `deletedAt`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `waiters`
--

DROP TABLE IF EXISTS `waiters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `waiters` (
  `waiterID` char(8) NOT NULL,
  PRIMARY KEY (`waiterID`),
  CONSTRAINT `waiters_ibfk_1` FOREIGN KEY (`waiterID`) REFERENCES `employees` (`employeeID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `waiters`
--

LOCK TABLES `waiters` WRITE;
/*!40000 ALTER TABLE `waiters` DISABLE KEYS */;
INSERT INTO `waiters` VALUES ('WAITR001');
/*!40000 ALTER TABLE `waiters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `advances_view`
--

/*!50001 DROP VIEW IF EXISTS `advances_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `advances_view` AS select `advances`.`advanceID` AS `advanceID`,`advances`.`description` AS `description`,`advances`.`amount` AS `amount`,`advances`.`date` AS `date`,`advances`.`employeeID` AS `employeeID`,`advances`.`handlerManagerID` AS `handlerManagerID`,`advances`.`deletedAt` AS `deletedAt` from `advances` where (`advances`.`deletedAt` is null) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `bonuses_view`
--

/*!50001 DROP VIEW IF EXISTS `bonuses_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `bonuses_view` AS select `bonuses`.`bonusID` AS `bonusID`,`bonuses`.`employeeID` AS `employeeID`,`bonuses`.`amount` AS `amount`,`bonuses`.`description` AS `description`,`bonuses`.`date` AS `date`,`bonuses`.`deletedAt` AS `deletedAt` from `bonuses` where (`bonuses`.`deletedAt` is null) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `bookings_view`
--

/*!50001 DROP VIEW IF EXISTS `bookings_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `bookings_view` AS select `bookings`.`bookingID` AS `bookingID`,`bookings`.`guestID` AS `guestID`,`bookings`.`dateFrom` AS `dateFrom`,`bookings`.`dateTo` AS `dateTo`,`bookings`.`status` AS `status`,`bookings`.`billingAmount` AS `billingAmount`,`bookings`.`noOfPerson` AS `noOfPerson`,`bookings`.`checkIn` AS `checkIn`,`bookings`.`checkOut` AS `checkOut`,`bookings`.`receptionistID` AS `receptionistID`,`bookings`.`deletedAt` AS `deletedAt` from `bookings` where (`bookings`.`deletedAt` is null) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `employees_view`
--

/*!50001 DROP VIEW IF EXISTS `employees_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `employees_view` AS select `employees`.`employeeID` AS `employeeID`,`employees`.`employeeType` AS `employeeType`,`employees`.`title` AS `title`,`employees`.`nic` AS `nic`,`employees`.`firstName` AS `firstName`,`employees`.`lastName` AS `lastName`,`employees`.`dob` AS `dob`,`employees`.`sex` AS `sex`,`employees`.`telNo` AS `telNo`,`employees`.`address` AS `address`,`employees`.`email` AS `email`,`employees`.`salary` AS `salary`,`employees`.`status` AS `status`,`employees`.`joinedDate` AS `JoinedDate`,`employees`.`deletedAt` AS `deletedAt` from `employees` where (`employees`.`deletedAt` is null) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `guests_view`
--

/*!50001 DROP VIEW IF EXISTS `guests_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `guests_view` AS select `guests`.`telNo` AS `telNo`,`guests`.`title` AS `title`,`guests`.`nic` AS `nic`,`guests`.`firstName` AS `firstName`,`guests`.`lastName` AS `lastName`,`guests`.`sex` AS `sex`,`guests`.`address` AS `address`,`guests`.`email` AS `email`,`guests`.`deletedAt` AS `deletedAt` from `guests` where (`guests`.`deletedAt` is null) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `items_view`
--

/*!50001 DROP VIEW IF EXISTS `items_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `items_view` AS select `items`.`itemID` AS `itemID`,`items`.`name` AS `name`,`items`.`category` AS `category`,`items`.`description` AS `description`,`items`.`price` AS `price`,`items`.`image` AS `image`,`items`.`deletedAt` AS `deletedAt` from `items` where (`items`.`deletedAt` is null) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `orders_view`
--

/*!50001 DROP VIEW IF EXISTS `orders_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `orders_view` AS select `orders`.`orderID` AS `orderID`,`orders`.`date` AS `date`,`orders`.`status` AS `status`,`orders`.`netPrice` AS `netPrice`,`orders`.`waiterID` AS `waiterID`,`orders`.`chefID` AS `chefID`,`orders`.`cashierID` AS `cashierID`,`orders`.`deletedAt` AS `deletedAt` from `orders` where (`orders`.`deletedAt` is null) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `rooms_view`
--

/*!50001 DROP VIEW IF EXISTS `rooms_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `rooms_view` AS select `rooms`.`roomID` AS `roomID`,`rooms`.`name` AS `name`,`rooms`.`roomNo` AS `roomNo`,`rooms`.`description` AS `description`,`rooms`.`bedType` AS `bedType`,`rooms`.`noOfBed` AS `noOfBed`,`rooms`.`roomType` AS `roomType`,`rooms`.`charge` AS `charge`,`rooms`.`deletedAt` AS `deletedAt` from `rooms` where (`rooms`.`deletedAt` is null) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `users_view`
--

/*!50001 DROP VIEW IF EXISTS `users_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `users_view` AS select `users`.`userID` AS `userID`,`users`.`username` AS `username`,`users`.`password` AS `password`,`users`.`status` AS `status`,`users`.`employeeID` AS `employeeID`,`users`.`deletedAt` AS `deletedAt` from `users` where (`users`.`deletedAt` is null) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-15 21:06:11
