-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: swp391
-- ------------------------------------------------------
-- Server version	8.0.30
CREATE SCHEMA IF NOT EXISTS `SWP391` DEFAULT CHARACTER SET utf8 ;
USE `SWP391` ;
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
-- Table structure for table `assignment`
--

DROP TABLE IF EXISTS `assignment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assignment` (
  `ass_id` int NOT NULL AUTO_INCREMENT,
  `subject_id_ass` int NOT NULL,
  `tittle` varchar(200) NOT NULL,
  `ass_body` varchar(200) DEFAULT NULL,
  `eval_weight` double NOT NULL,
  `is_team_work` bit(1) NOT NULL,
  `is_ongoing` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  PRIMARY KEY (`ass_id`),
  KEY `subject_id_ass_idx` (`subject_id_ass`),
  CONSTRAINT `subject_id_ass` FOREIGN KEY (`subject_id_ass`) REFERENCES `subject` (`subject_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignment`
--

LOCK TABLES `assignment` WRITE;
/*!40000 ALTER TABLE `assignment` DISABLE KEYS */;
INSERT INTO `assignment` VALUES (1,1,'Assignment 1','present ',10,_binary '',_binary '',_binary '\0'),(2,1,'Assignment 2','1',10,_binary '',_binary '',_binary ''),(3,2,'Assignment 1','3',20,_binary '',_binary '\0',_binary ''),(4,2,'Assignment 2','1',10,_binary '',_binary '',_binary ''),(5,2,'Assignment 3','4',10,_binary '',_binary '',_binary ''),(6,1,'Assignment 3','1',10,_binary '',_binary '\0',_binary ''),(7,3,'Assignment 1','1',20,_binary '',_binary '',_binary ''),(8,3,'Assignment 2','1',10,_binary '',_binary '',_binary ''),(9,3,'Assignment 3','2',15,_binary '',_binary '',_binary '\0'),(10,4,'Assignment 1','1',10,_binary '',_binary '',_binary '\0'),(11,5,'asignment1','holaaaaaaaaa',10,_binary '',_binary '',_binary ''),(12,1,'a','a',10,_binary '',_binary '',_binary ''),(13,2,'aaaa','abc',10,_binary '',_binary '',_binary '');
/*!40000 ALTER TABLE `assignment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attendance` (
  `class_id_att` int NOT NULL,
  `trainee_id_att` int NOT NULL,
  `schedule_id_att` int NOT NULL,
  `status` varchar(45) DEFAULT NULL,
  `comment` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`class_id_att`,`trainee_id_att`,`schedule_id_att`),
  KEY `trainee_id_att_idx` (`trainee_id_att`),
  KEY `schedule_id_att_idx` (`schedule_id_att`),
  CONSTRAINT `class_id_att` FOREIGN KEY (`class_id_att`) REFERENCES `class` (`class_id`),
  CONSTRAINT `schedule_id_att` FOREIGN KEY (`schedule_id_att`) REFERENCES `schedule` (`schedule_id`),
  CONSTRAINT `trainee_id_att` FOREIGN KEY (`trainee_id_att`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class` (
  `class_id` int NOT NULL AUTO_INCREMENT,
  `class_code` varchar(45) DEFAULT NULL,
  `combo_id` int DEFAULT NULL,
  `trainer_id` int NOT NULL,
  `term_id` int NOT NULL,
  `status` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`class_id`),
  KEY `trainer_id_idx` (`trainer_id`),
  KEY `term_id_idx` (`term_id`),
  CONSTRAINT `trainer_id` FOREIGN KEY (`trainer_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
INSERT INTO `class` VALUES (1,'SE1623',NULL,2,27,'Active',NULL),(2,'SE1624',NULL,4,28,'Active',NULL),(3,'SE1625',NULL,4,29,'Deactive',NULL),(4,'IA1621',NULL,6,30,'Active',NULL),(5,'IA1623',NULL,2,31,'Deactive',NULL),(6,'IA1624',NULL,2,32,'Active',NULL),(7,'AI1611',NULL,3,33,'Active',NULL),(8,'AI1612',NULL,3,32,'Deactive',NULL),(9,'AI1613',NULL,5,31,'Active',NULL),(10,'SE1626',NULL,6,30,'Deactive',NULL),(11,'SE1620',NULL,4,29,'Active',NULL),(12,'AI1620',NULL,2,29,'Deactive',NULL),(13,'AI1600',NULL,4,30,'Deactive',NULL),(14,'IA1600',NULL,3,27,'Active',NULL),(15,'IA1601',NULL,3,28,'Deactive',NULL),(16,'SE1601',NULL,5,29,'Active',NULL),(17,'SE1602',NULL,5,30,'Deactive',NULL),(18,'SE1603',NULL,6,30,'Active',NULL),(19,'SE1604',NULL,6,33,'Deactive',NULL),(20,'IA1604',NULL,6,32,'Active',NULL),(21,'SE1606',NULL,5,29,'Active',NULL),(22,'SE1607',NULL,5,29,'Active',NULL),(24,'',NULL,5,0,NULL,NULL);
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_lesson`
--

DROP TABLE IF EXISTS `class_lesson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class_lesson` (
  `class_lesson_id` int NOT NULL AUTO_INCREMENT,
  `lesson_id_fk` int NOT NULL,
  `subject_class_id_fk` int NOT NULL,
  `class_lesson_id_fk` int NOT NULL,
  `slot_id` int NOT NULL,
  PRIMARY KEY (`class_lesson_id`),
  KEY `lesson_id_idx` (`lesson_id_fk`),
  KEY `subject_id_id_idx` (`subject_class_id_fk`),
  KEY `class_id_idx` (`class_lesson_id_fk`),
  KEY `slot_id_idx` (`slot_id`),
  CONSTRAINT `class_lesson_id_fk` FOREIGN KEY (`class_lesson_id_fk`) REFERENCES `class` (`class_id`),
  CONSTRAINT `lesson_id` FOREIGN KEY (`lesson_id_fk`) REFERENCES `lesson` (`lesson_id`),
  CONSTRAINT `slot_id` FOREIGN KEY (`slot_id`) REFERENCES `class_setting` (`setting_id`),
  CONSTRAINT `subject_class_id_fk` FOREIGN KEY (`subject_class_id_fk`) REFERENCES `subject` (`subject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_lesson`
--

LOCK TABLES `class_lesson` WRITE;
/*!40000 ALTER TABLE `class_lesson` DISABLE KEYS */;
/*!40000 ALTER TABLE `class_lesson` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_setting`
--

DROP TABLE IF EXISTS `class_setting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class_setting` (
  `setting_id` int NOT NULL AUTO_INCREMENT,
  `type_id_fk` int NOT NULL,
  `setting_title` varchar(45) DEFAULT NULL,
  `setting_value` varchar(45) DEFAULT NULL,
  `display_order` varchar(45) DEFAULT NULL,
  `class_id_fk` int NOT NULL,
  `status` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`setting_id`),
  KEY `type_id_idx` (`type_id_fk`),
  KEY `class_id_idx` (`class_id_fk`),
  CONSTRAINT `class_id_fk` FOREIGN KEY (`class_id_fk`) REFERENCES `class` (`class_id`),
  CONSTRAINT `type_id_fk` FOREIGN KEY (`type_id_fk`) REFERENCES `setting` (`setting_id`)
) ENGINE=InnoDB AUTO_INCREMENT=176 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_setting`
--

LOCK TABLES `class_setting` WRITE;
/*!40000 ALTER TABLE `class_setting` DISABLE KEYS */;
INSERT INTO `class_setting` VALUES (108,13,'room ','BE-201',NULL,1,NULL,NULL),(109,13,'room ','BE-202',NULL,2,NULL,NULL),(110,13,'room ','BE-203',NULL,3,NULL,NULL),(111,13,'room ','BE-204',NULL,4,NULL,NULL),(112,13,'room ','BE-205',NULL,5,NULL,NULL),(113,13,'room ','BE-206',NULL,6,NULL,NULL),(120,14,'slot ','Slot 1',NULL,1,NULL,NULL),(121,14,'slot ','Slot 2',NULL,1,NULL,NULL),(122,14,'slot ','Slot 3',NULL,1,NULL,NULL),(123,14,'slot ','Slot 4',NULL,1,NULL,NULL),(124,14,'slot ','Slot 5',NULL,1,NULL,NULL),(125,14,'slot ','Slot 6',NULL,1,NULL,NULL),(126,14,'slot','Slot 1',NULL,2,NULL,NULL),(127,13,'room','BE-202',NULL,2,NULL,NULL),(128,14,'slot','Slot 2',NULL,2,NULL,NULL),(129,13,'room','BE-202',NULL,2,NULL,NULL),(130,14,'slot','Slot 3',NULL,2,NULL,NULL),(131,13,'room','BE-202',NULL,2,NULL,NULL),(132,14,'slot','Slot 1',NULL,1,NULL,NULL),(133,13,'room','BE-201',NULL,1,NULL,NULL),(134,14,'slot','Slot 1',NULL,1,NULL,NULL),(135,13,'room','BE-201',NULL,1,NULL,NULL),(136,14,'slot','Slot 1',NULL,1,NULL,NULL),(137,13,'room','BE-201',NULL,1,NULL,NULL),(138,14,'slot','Slot 3',NULL,20,NULL,NULL),(139,13,'room','BE-201',NULL,20,NULL,NULL),(140,14,'slot','Slot 1',NULL,1,NULL,NULL),(141,13,'room','BE-201',NULL,1,NULL,NULL),(143,14,'slot','Slot 1',NULL,24,NULL,NULL),(144,14,'slot ','Slot 2',NULL,24,NULL,NULL),(145,14,'slot','Slot 3',NULL,24,NULL,NULL),(146,14,'slot','Slot 4',NULL,24,NULL,NULL),(147,14,'slot','Slot 5',NULL,24,NULL,NULL),(148,14,'slot','Slot 6',NULL,24,NULL,NULL),(150,13,'room','BE-201',NULL,24,NULL,NULL),(151,13,'room','BE-202',NULL,24,NULL,NULL),(152,13,'room','BE-203',NULL,24,NULL,NULL),(153,13,'room','BE-204',NULL,24,NULL,NULL),(154,13,'room','BE-205',NULL,24,NULL,NULL),(155,13,'room','BE-206',NULL,24,NULL,NULL),(156,13,'room','BE-207',NULL,24,NULL,NULL),(157,13,'room','BE-208',NULL,24,NULL,NULL),(158,14,'slot','Slot 2',NULL,4,NULL,NULL),(159,13,'room','BE-206',NULL,4,NULL,NULL),(160,14,'slot','Slot 4',NULL,9,NULL,NULL),(161,13,'room','BE-204',NULL,9,NULL,NULL),(162,14,'slot','Slot 3',NULL,10,NULL,NULL),(163,13,'room','BE-205',NULL,10,NULL,NULL),(164,14,'slot','Slot 1',NULL,24,NULL,NULL),(165,14,'slot','Slot 2',NULL,24,NULL,NULL),(166,14,'slot','Slot 3',NULL,24,NULL,NULL),(167,14,'slot','Slot 4',NULL,24,NULL,NULL),(168,14,'slot','Slot 5',NULL,24,NULL,NULL),(169,14,'slot','Slot 6',NULL,24,NULL,NULL),(170,13,'room','BE-201',NULL,24,NULL,NULL),(171,13,'room','BE-202',NULL,24,NULL,NULL),(172,13,'room','BE-203',NULL,24,NULL,NULL),(173,13,'room','BE-204',NULL,24,NULL,NULL),(174,13,'room','BE-205',NULL,24,NULL,NULL),(175,13,'room','BE-206',NULL,24,NULL,NULL);
/*!40000 ALTER TABLE `class_setting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_user`
--

DROP TABLE IF EXISTS `class_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class_user` (
  `class_user_id_fk` int NOT NULL,
  `user_user_id_fk` int NOT NULL,
  `status` bit(1) DEFAULT NULL,
  `note` varchar(45) DEFAULT NULL,
  `dropout_date` date DEFAULT NULL,
  `ongoing_eval` varchar(45) DEFAULT NULL,
  `final_eval` varchar(45) DEFAULT NULL,
  `topic_eval` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`class_user_id_fk`,`user_user_id_fk`),
  KEY `user_id_idx` (`user_user_id_fk`),
  CONSTRAINT `class_user_id_fk` FOREIGN KEY (`class_user_id_fk`) REFERENCES `class` (`class_id`),
  CONSTRAINT `user_user_id_fk` FOREIGN KEY (`user_user_id_fk`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_user`
--

LOCK TABLES `class_user` WRITE;
/*!40000 ALTER TABLE `class_user` DISABLE KEYS */;
INSERT INTO `class_user` VALUES (1,15,_binary '',NULL,NULL,NULL,NULL,NULL),(1,16,_binary '',NULL,NULL,NULL,NULL,NULL),(1,17,_binary '',NULL,NULL,NULL,NULL,NULL),(1,18,_binary '',NULL,NULL,NULL,NULL,NULL),(1,19,_binary '',NULL,NULL,NULL,NULL,NULL),(1,20,_binary '',NULL,NULL,NULL,NULL,NULL),(1,21,_binary '',NULL,NULL,NULL,NULL,NULL),(1,22,_binary '',NULL,NULL,NULL,NULL,NULL),(1,23,_binary '',NULL,NULL,NULL,NULL,NULL),(1,24,_binary '',NULL,NULL,NULL,NULL,NULL),(1,25,_binary '',NULL,NULL,NULL,NULL,NULL),(1,26,_binary '',NULL,NULL,NULL,NULL,NULL),(1,27,_binary '',NULL,NULL,NULL,NULL,NULL),(1,28,_binary '',NULL,NULL,NULL,NULL,NULL),(1,29,_binary '',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `class_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `client_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `possition` varchar(45) DEFAULT NULL,
  `company` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`client_id`),
  KEY `user_id_idx` (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eval_criteria`
--

DROP TABLE IF EXISTS `eval_criteria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eval_criteria` (
  `criteria_id` int NOT NULL AUTO_INCREMENT,
  `ass_id_cri` int NOT NULL,
  `milestone_id_cri` int DEFAULT NULL,
  `criteria_name` varchar(45) NOT NULL,
  `is_team_eval` bit(1) NOT NULL,
  `eval_weight` double NOT NULL,
  `max_loc` int NOT NULL,
  `status` bit(1) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`criteria_id`),
  KEY `ass_id_cri_idx` (`ass_id_cri`),
  KEY `milestone_id_cri_idx` (`milestone_id_cri`),
  CONSTRAINT `ass_id_cri` FOREIGN KEY (`ass_id_cri`) REFERENCES `assignment` (`ass_id`),
  CONSTRAINT `milestone_id_cri` FOREIGN KEY (`milestone_id_cri`) REFERENCES `milestone` (`milestone_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eval_criteria`
--

LOCK TABLES `eval_criteria` WRITE;
/*!40000 ALTER TABLE `eval_criteria` DISABLE KEYS */;
INSERT INTO `eval_criteria` VALUES (1,1,NULL,'Present',_binary '',10,100,_binary '\0','abcdef'),(2,1,NULL,'Self learning',_binary '',10,200,_binary '','abcdef'),(3,1,NULL,'Silde',_binary '',20,120,_binary '','abcdef'),(4,2,NULL,'Present',_binary '',10,100,_binary '','abcdef'),(5,2,NULL,'Self learning',_binary '',20,200,_binary '\0','abcdef'),(6,2,NULL,'Silde',_binary '\0',15,140,_binary '\0','abcdef'),(7,3,7,'Present',_binary '',20,120,_binary '\0','abcdef'),(8,3,NULL,'Self learning',_binary '',10,100,_binary '\0','abcdef'),(9,3,8,'Silde',_binary '',10,160,_binary '','abcdef'),(10,4,NULL,'Present',_binary '\0',10,150,_binary '','abcdef'),(11,5,NULL,'Present',_binary '',20,120,_binary '','abcdef'),(12,1,NULL,'abc',_binary '',15,100,_binary '',''),(13,4,NULL,'abc',_binary '',20,250,_binary '','');
/*!40000 ALTER TABLE `eval_criteria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lesson`
--

DROP TABLE IF EXISTS `lesson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lesson` (
  `lesson_id` int NOT NULL AUTO_INCREMENT,
  `subject_id` int NOT NULL,
  `author_id` int NOT NULL,
  `video_url` varchar(45) DEFAULT NULL,
  `file_url` varchar(45) DEFAULT NULL,
  `body` varchar(45) DEFAULT NULL,
  `module_id` int NOT NULL,
  PRIMARY KEY (`lesson_id`),
  KEY `module_id_idx` (`module_id`),
  KEY `subject_id_idx` (`subject_id`),
  KEY `author_id_idx` (`author_id`),
  CONSTRAINT `author_id` FOREIGN KEY (`author_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `module_id` FOREIGN KEY (`module_id`) REFERENCES `subject_setting` (`setting_id`),
  CONSTRAINT `subject_id` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lesson`
--

LOCK TABLES `lesson` WRITE;
/*!40000 ALTER TABLE `lesson` DISABLE KEYS */;
/*!40000 ALTER TABLE `lesson` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `milestone`
--

DROP TABLE IF EXISTS `milestone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `milestone` (
  `milestone_id` int NOT NULL AUTO_INCREMENT,
  `ass_id_mil` int NOT NULL,
  `class_id_mil` int NOT NULL,
  `from_date` datetime NOT NULL,
  `to_date` datetime NOT NULL,
  `tittle` varchar(200) NOT NULL,
  `ass_body` varchar(200) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `status` bit(8) NOT NULL,
  PRIMARY KEY (`milestone_id`),
  KEY `ass_id_mil_idx` (`ass_id_mil`),
  KEY `class_id_mil_idx` (`class_id_mil`),
  CONSTRAINT `ass_id_mil` FOREIGN KEY (`ass_id_mil`) REFERENCES `assignment` (`ass_id`),
  CONSTRAINT `class_id_mil` FOREIGN KEY (`class_id_mil`) REFERENCES `class` (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `milestone`
--

LOCK TABLES `milestone` WRITE;
/*!40000 ALTER TABLE `milestone` DISABLE KEYS */;
INSERT INTO `milestone` VALUES (4,1,1,'2022-10-01 00:00:00','2022-10-03 00:00:00','Lab  ','assignment','Lab  ',_binary '\0'),(6,2,2,'2022-10-01 00:00:00','2022-10-03 00:00:00','Lab 2  ','assignment','Lab 2  ',_binary ''),(7,2,1,'2022-10-02 00:00:00','2022-10-02 00:00:00','Lab 3','assignment',NULL,_binary ''),(8,3,5,'2022-10-01 00:00:00','2022-10-05 00:00:00','Lab 4  ','assignment','Lab 4  ',_binary '\0'),(9,4,3,'2022-10-03 00:00:00','2022-10-09 00:00:00','Lab 5','assignment',NULL,_binary ''),(10,3,4,'2022-10-10 00:00:00','2022-10-12 00:00:00','Lab 6','assignment',NULL,_binary ''),(11,7,5,'2022-10-07 00:00:00','2022-10-11 00:00:00','Lab 7','assignment',NULL,_binary ''),(12,9,6,'2022-10-01 00:00:00','2022-10-06 00:00:00','Lab 8','assignment',NULL,_binary '');
/*!40000 ALTER TABLE `milestone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `package`
--

DROP TABLE IF EXISTS `package`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `package` (
  `package_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `subject_package_id_fk` int DEFAULT NULL,
  PRIMARY KEY (`package_id`),
  KEY `subject_id_idx` (`subject_package_id_fk`),
  CONSTRAINT `subject_package_id_fk` FOREIGN KEY (`subject_package_id_fk`) REFERENCES `subject` (`subject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `package`
--

LOCK TABLES `package` WRITE;
/*!40000 ALTER TABLE `package` DISABLE KEYS */;
/*!40000 ALTER TABLE `package` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permission` (
  `screen_id` int NOT NULL,
  `setting_id` int NOT NULL,
  `get_all_data` bit(1) DEFAULT NULL,
  `can_delete` bit(1) DEFAULT NULL,
  `can_add` bit(1) DEFAULT NULL,
  `can_edit` bit(1) DEFAULT NULL,
  PRIMARY KEY (`screen_id`,`setting_id`),
  KEY `setting_id_idx` (`setting_id`),
  CONSTRAINT `setting_id` FOREIGN KEY (`setting_id`) REFERENCES `setting` (`setting_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission`
--

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schedule` (
  `schedule_id` int NOT NULL AUTO_INCREMENT,
  `class_id_schedule` int NOT NULL,
  `slot_id_schedule` int NOT NULL,
  `room_id_schedule` int NOT NULL,
  `training_date` date NOT NULL,
  `from_time` time NOT NULL,
  `to_time` time NOT NULL,
  `status` bit(1) NOT NULL,
  PRIMARY KEY (`schedule_id`),
  KEY `class_id_schedule_idx` (`class_id_schedule`),
  KEY `slot_id_schedule_idx` (`slot_id_schedule`),
  KEY `room_id_schedule_idx` (`room_id_schedule`),
  CONSTRAINT `class_id_schedule` FOREIGN KEY (`class_id_schedule`) REFERENCES `class` (`class_id`),
  CONSTRAINT `room_id_schedule` FOREIGN KEY (`room_id_schedule`) REFERENCES `class_setting` (`setting_id`),
  CONSTRAINT `slot_id_schedule` FOREIGN KEY (`slot_id_schedule`) REFERENCES `class_setting` (`setting_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES (26,1,143,150,'2022-10-17','07:30:00','09:00:00',_binary '\0'),(27,2,128,129,'2022-10-24','09:10:00','10:40:00',_binary ''),(28,2,130,131,'2022-10-22','10:50:00','12:20:00',_binary '\0'),(29,1,132,133,'2022-10-25','07:30:00','09:00:00',_binary ''),(30,1,134,135,'2022-10-06','07:30:00','09:00:00',_binary '\0'),(31,1,136,137,'2022-10-15','07:30:00','09:00:00',_binary '\0'),(32,1,143,151,'2022-10-24','10:50:00','12:20:00',_binary ''),(33,1,140,141,'2022-10-11','07:30:00','09:00:00',_binary '\0'),(34,4,143,154,'2022-10-25','09:10:00','10:40:00',_binary '\0'),(35,9,146,153,'2022-10-13','12:50:00','14:20:00',_binary '\0'),(36,10,162,163,'2022-10-25','10:50:00','12:20:00',_binary '');
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `setting`
--

DROP TABLE IF EXISTS `setting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `setting` (
  `setting_id` int NOT NULL AUTO_INCREMENT,
  `type_id` int DEFAULT NULL,
  `setting_title` varchar(45) DEFAULT NULL,
  `setting_value` varchar(45) DEFAULT NULL,
  `display_order` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`setting_id`),
  KEY `type_id_idx` (`type_id`),
  CONSTRAINT `type_id` FOREIGN KEY (`type_id`) REFERENCES `setting` (`setting_id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `setting`
--

LOCK TABLES `setting` WRITE;
/*!40000 ALTER TABLE `setting` DISABLE KEYS */;
INSERT INTO `setting` VALUES (1,NULL,'User Role','user role','','Active','123'),(2,NULL,'Web Contact Category',NULL,NULL,'Active',NULL),(3,NULL,'Class Setting Type',NULL,NULL,'Active',NULL),(4,NULL,'Subject Setting Type',NULL,NULL,'Active',NULL),(5,NULL,'SysTem Screnns',NULL,NULL,'Active',NULL),(6,NULL,'Term',NULL,NULL,'Active','This Type contain term of class'),(10,1,'Administrator','21,22,23,24,25,26,27',NULL,'Active',NULL),(11,1,'Trainer','21',NULL,'Deactive',NULL),(12,1,'Manager','21',NULL,'Active',NULL),(13,1,'Supporter','21',NULL,'Active',NULL),(14,1,'Student','26.27',NULL,'Deactive',NULL),(15,3,'Class Setting Type1',NULL,'1','Active',NULL),(16,3,'Class Setting Type2',NULL,'2','Active',NULL),(17,4,'Subject Setting Type1',NULL,'1','Deactive',NULL),(18,4,'Subject Setting Type2',NULL,'2','Deactive',NULL),(19,2,'Web Contact Category1',NULL,'1','Deactive',NULL),(20,2,'asd1123',NULL,'12312312','Deactive','abc'),(21,5,'Dashboard','/doashboard',NULL,'Active',NULL),(22,5,'User List','/userlist',NULL,'Active',NULL),(23,5,'User Details',NULL,'1','Active','abc'),(24,5,'Setting List','/settinglist',NULL,'Active',NULL),(25,5,'Setting details','/settingdetails',NULL,'Active',NULL),(26,5,'User Login','/userlogin',NULL,'Active',NULL),(27,5,'User profile','/userprofile',NULL,'Active',NULL),(28,6,'Spring 2022',NULL,'3','Active',NULL),(29,6,'Summer 2022',NULL,'2','Active',NULL),(30,6,'Fall 2022',NULL,'1','Active',NULL),(31,6,'Spring 2021',NULL,'6','Active',NULL),(32,6,'Summer 2021',NULL,'5','Active',NULL),(33,6,'Fall 2021',NULL,'4','Active',NULL),(46,1,'Expert',NULL,NULL,'Active',NULL),(47,NULL,'abc',NULL,'123','Deactive',''),(48,NULL,'abc','12','1','Active','a'),(49,NULL,'abcde','1','1','Active','abc');
/*!40000 ALTER TABLE `setting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject` (
  `subject_id` int NOT NULL AUTO_INCREMENT,
  `subject_code` varchar(45) DEFAULT NULL,
  `subject_name` varchar(45) DEFAULT NULL,
  `manager_id` int NOT NULL,
  `expert_id` int NOT NULL,
  `status` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`subject_id`),
  KEY `manager_id_idx` (`manager_id`),
  KEY `expert_id_idx` (`expert_id`),
  CONSTRAINT `expert_id` FOREIGN KEY (`expert_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `manager_id` FOREIGN KEY (`manager_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,'SWP391','Application development project',4,9,'1','abcdef'),(2,'SWE201c','	Introduction to Software Engineering',5,10,'1','abcdef'),(3,'PRJ301','Java Web Application Development',12,11,'1','abcdef'),(4,'IOT102','Internet of Things',13,11,'1','abcdef'),(5,'JPD123','	Elementary Japanese 1-A1.2',14,10,'1','abcdef');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject_setting`
--

DROP TABLE IF EXISTS `subject_setting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject_setting` (
  `setting_id` int NOT NULL,
  `type_subject_id` int DEFAULT NULL,
  `setting_title` varchar(45) DEFAULT NULL,
  `setting_value` varchar(45) DEFAULT NULL,
  `display_order` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `subject_id_fk` int DEFAULT NULL,
  PRIMARY KEY (`setting_id`),
  KEY `type_id_idx` (`type_subject_id`),
  KEY `subject_id_idx` (`subject_id_fk`),
  CONSTRAINT `subject_id_fk` FOREIGN KEY (`subject_id_fk`) REFERENCES `subject` (`subject_id`),
  CONSTRAINT `type_subject_id` FOREIGN KEY (`type_subject_id`) REFERENCES `setting` (`setting_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject_setting`
--

LOCK TABLES `subject_setting` WRITE;
/*!40000 ALTER TABLE `subject_setting` DISABLE KEYS */;
INSERT INTO `subject_setting` VALUES (1,17,'title 1','wef','qwfe','active',NULL,1),(2,18,'title 22','abc','ffe','active',NULL,1),(3,17,'title 3','asdfg','qwef','deactive',NULL,1),(4,17,'title 4','wdgasdga','qewf','active',NULL,2),(5,18,'title 5','adgasdg','qef','deactive',NULL,2),(6,18,'qwf','agasdg','qwefq','deactive',NULL,1),(7,18,'qwfe','qwef','qwef','active',NULL,2),(8,17,'qwef','sdfadf','qef','deactive',NULL,1);
/*!40000 ALTER TABLE `subject_setting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `submit`
--

DROP TABLE IF EXISTS `submit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `submit` (
  `submit_id` int NOT NULL AUTO_INCREMENT,
  `milestone_id_su_fk` int DEFAULT NULL,
  `class_id_su_fk` int DEFAULT NULL,
  `team_id_su_fk` int DEFAULT NULL,
  `user_id_su_fk` int DEFAULT NULL,
  `submit_file_url` varchar(45) DEFAULT NULL,
  `submit_time` datetime DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`submit_id`),
  KEY `milestone_id_su_fk_idx` (`milestone_id_su_fk`),
  KEY `class_id_su_fk_idx` (`class_id_su_fk`),
  KEY `team_id_su_fk_idx` (`team_id_su_fk`),
  KEY `user_id_su_fk_idx` (`user_id_su_fk`),
  CONSTRAINT `class_id_su_fk` FOREIGN KEY (`class_id_su_fk`) REFERENCES `class_user` (`class_user_id_fk`),
  CONSTRAINT `milestone_id_su_fk` FOREIGN KEY (`milestone_id_su_fk`) REFERENCES `milestone` (`milestone_id`),
  CONSTRAINT `team_id_su_fk` FOREIGN KEY (`team_id_su_fk`) REFERENCES `team` (`team_id`),
  CONSTRAINT `user_id_su_fk` FOREIGN KEY (`user_id_su_fk`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `submit`
--

LOCK TABLES `submit` WRITE;
/*!40000 ALTER TABLE `submit` DISABLE KEYS */;
INSERT INTO `submit` VALUES (2,4,1,1,16,'http://a/b/c','2022-10-20 00:00:00',_binary ''),(3,4,1,2,18,'http://a/b/c1','2022-10-20 00:00:00',_binary ''),(4,4,1,3,21,'http://a/b/c2','2022-10-20 00:00:00',_binary ''),(5,4,1,4,24,'http://a/b/c3','2022-10-20 00:00:00',_binary ''),(6,4,1,5,27,'http://a/b/c4','2022-10-20 00:00:00',_binary '');
/*!40000 ALTER TABLE `submit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team`
--

DROP TABLE IF EXISTS `team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `team` (
  `team_id` int NOT NULL AUTO_INCREMENT,
  `class_id_team` int DEFAULT NULL,
  `team_code` varchar(45) DEFAULT NULL,
  `topic_name` varchar(45) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`team_id`),
  KEY `class_id_team_idx` (`class_id_team`),
  CONSTRAINT `class_id_team` FOREIGN KEY (`class_id_team`) REFERENCES `class` (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=160 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team`
--

LOCK TABLES `team` WRITE;
/*!40000 ALTER TABLE `team` DISABLE KEYS */;
INSERT INTO `team` VALUES (1,1,'G1','Assignment1',_binary '','abcdefefghfdsafdsadfasasdf'),(2,1,'G2','Assignment1',_binary '','abcdef'),(3,1,'G3','Assignment1',_binary '','abcdef'),(4,1,'G4','Assignment1',_binary '','abcdef'),(5,1,'G5','Assignment1',_binary '','abcdef');
/*!40000 ALTER TABLE `team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team_member`
--

DROP TABLE IF EXISTS `team_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `team_member` (
  `team_id_tm` int NOT NULL,
  `user_id_tm` int NOT NULL,
  `is_leader` bit(1) NOT NULL,
  `is_active` bit(1) NOT NULL,
  PRIMARY KEY (`team_id_tm`,`user_id_tm`),
  KEY `user_id_tm_idx` (`user_id_tm`),
  CONSTRAINT `team_id_tm` FOREIGN KEY (`team_id_tm`) REFERENCES `team` (`team_id`),
  CONSTRAINT `user_id_tm` FOREIGN KEY (`user_id_tm`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_member`
--

LOCK TABLES `team_member` WRITE;
/*!40000 ALTER TABLE `team_member` DISABLE KEYS */;
INSERT INTO `team_member` VALUES (1,15,_binary '\0',_binary ''),(1,16,_binary '',_binary ''),(1,17,_binary '\0',_binary ''),(2,18,_binary '',_binary ''),(2,19,_binary '\0',_binary ''),(2,20,_binary '\0',_binary ''),(3,21,_binary '',_binary ''),(3,22,_binary '\0',_binary ''),(3,23,_binary '\0',_binary ''),(4,24,_binary '',_binary ''),(4,25,_binary '\0',_binary ''),(4,26,_binary '\0',_binary ''),(5,27,_binary '',_binary ''),(5,28,_binary '\0',_binary ''),(5,29,_binary '\0',_binary '');
/*!40000 ALTER TABLE `team_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(45) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(200) NOT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `avatar_url` varchar(1000) DEFAULT NULL,
  `company` varchar(45) DEFAULT NULL,
  `position` varchar(45) DEFAULT NULL,
  `status` varchar(500) DEFAULT NULL,
  `note` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Le van a','admin','ac0e7d037817094e9e0b4441f9bae3209d67b02fa484917065f71b16109a1a78','98123','nb','https://i.pinimg.com/originals/57/fb/31/57fb3190d0cc1726d782c4e25e8561e9.png','fp','hs','hi','hi'),(2,'Le van c','trainer','ac0e7d037817094e9e0b4441f9bae3209d67b02fa484917065f71b16109a1a78','123','123','123','123','123','123','123'),(3,'Le van b','maneger','ac0e7d037817094e9e0b4441f9bae3209d67b02fa484917065f71b16109a1a78','123','123',NULL,'123','123','123','123'),(4,'Le van d','supporter','ac0e7d037817094e9e0b4441f9bae3209d67b02fa484917065f71b16109a1a78','ac','ac',NULL,'ac','ac','active',NULL),(5,'huy anh','ha1','ha1','456','nn',NULL,'f','f','active',NULL),(6,'duong thanh','ha','ha','ha','ha',NULL,'ha','ha','active',NULL),(7,'kha vy','hq','hq','hq','hq',NULL,'hq','hq','active',NULL),(8,'min min','hs','hs','hs','hs',NULL,'hs','hs','active',NULL),(9,'mama','mv','mv','mv','mv',NULL,'fa','fa','active','note'),(10,'nam','bc','bc','056','bcb',NULL,'bc','bx','active',NULL),(11,'loan','f1','f1','f1','f1',NULL,'f1','f1','active',NULL),(12,'anh','af','af','8945','af',NULL,'af','af','active',NULL),(13,'mi','mh','mh','mh','mh',NULL,'mh','mh','mh','mh'),(14,'tieu','tt','tt','tt','tt',NULL,'tt','tt','tt','tt'),(15,'Nguyen van b','abc1@gmail.com','ac0e7d037817094e9e0b4441f9bae3209d67b02fa484917065f71b16109a1a78',NULL,NULL,NULL,NULL,NULL,'active',NULL),(16,'Nguyen van c','abc2@gmail.com','123435679',NULL,NULL,NULL,NULL,NULL,'active',NULL),(17,'Nguyen van d','abc3@gmail.com','123415679',NULL,NULL,NULL,NULL,NULL,'active',NULL),(18,'Nguyen van e','abc4@gmail.com','123435679',NULL,NULL,NULL,NULL,NULL,'active',NULL),(19,'Nguyen van f','abc5@gmail.com','124345679',NULL,NULL,NULL,NULL,NULL,'active',NULL),(20,'Nguyen van g','abc6@gmail.com','124345679',NULL,NULL,NULL,NULL,NULL,'active',NULL),(21,'Nguyen van h','abc7@gmail.com','123145679',NULL,NULL,NULL,NULL,NULL,'active',NULL),(22,'Nguyen van i','abc8@gmail.com','123456479',NULL,NULL,NULL,NULL,NULL,'active',NULL),(23,'Nguyen van k','abc9@gmail.com','123415679',NULL,NULL,NULL,NULL,NULL,'active',NULL),(24,'Nguyen van l','abc10@gmail.com','123545679',NULL,NULL,NULL,NULL,NULL,'active',NULL),(25,'Nguyen van m','abc11@gmail.com','123451679',NULL,NULL,NULL,NULL,NULL,'active',NULL),(26,'Nguyen van n','abc12@gmail.com','123345679',NULL,NULL,NULL,NULL,NULL,'active',NULL),(27,'Nguyen van o','abc13@gmail.com','123445679',NULL,NULL,NULL,NULL,NULL,'active',NULL),(28,'Nguyen van i','abc14@gmail.com','123451679',NULL,NULL,NULL,NULL,NULL,'active',NULL),(29,'Nguyen van p','abc15@gmail.com','123455679',NULL,NULL,NULL,NULL,NULL,'active',NULL),(30,'hoa','hehe','12351',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(31,'abcde','abc@gmail.com','xO@6HpYk',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `user_id_FK` int NOT NULL,
  `user_setting` int NOT NULL,
  PRIMARY KEY (`user_id_FK`,`user_setting`),
  KEY `user_setting_idx` (`user_setting`),
  CONSTRAINT `user_id_FK` FOREIGN KEY (`user_id_FK`) REFERENCES `user` (`user_id`),
  CONSTRAINT `user_setting` FOREIGN KEY (`user_setting`) REFERENCES `setting` (`setting_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,10),(2,11),(6,11),(7,11),(8,11),(3,12),(4,12),(5,12),(12,12),(13,12),(14,12),(9,46),(10,46),(11,46);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `web_contact`
--

DROP TABLE IF EXISTS `web_contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `web_contact` (
  `contact_id` int NOT NULL AUTO_INCREMENT,
  `category_id` int DEFAULT NULL,
  `supporter_id` int DEFAULT NULL,
  `full_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `message` varchar(45) DEFAULT NULL,
  `response` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`contact_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `web_contact`
--

LOCK TABLES `web_contact` WRITE;
/*!40000 ALTER TABLE `web_contact` DISABLE KEYS */;
INSERT INTO `web_contact` VALUES (1,19,NULL,'odifj','qwefw','qwefwef','qwefqwefwxcv','dfbsdfbsdf'),(2,20,NULL,'bsdfbghfm','ghmfghmfghm','0984098','bsdfsdfb','bsdfbs'),(3,19,NULL,'qwfqwfhrg','mfghmhg','15606','mtrh','56465'),(4,19,NULL,'sdfgdfbfb sef','sefgsesh','5046504','asdf sdf sdf','qfwef'),(5,20,NULL,'ergsed','fgnsdga','5689','jhtjt','fqwef'),(6,20,NULL,'dfgsefge','rthertf','065','jtj','wefqwefqwef'),(7,19,NULL,'sdfgsdfgd','rtnrthjerth','056','tyj','qwefqwef'),(8,19,NULL,'fgdfgsdfg','dfgndfg','4065','tjgbnd','fbfxvbs'),(9,19,NULL,'sdfgsdfg','ndfgn','89465','fed','wfqwef'),(10,20,NULL,'ewregwerwe','gfndfg','0984','ferf','sfwe'),(11,19,NULL,'hwrthrt','wfwefwe','0956','edfvsdf','gwergwe'),(12,20,NULL,'hrthwrth','22efqwef@gmail.com','08944','gthrth','ergwegfvb'),(13,20,NULL,'wrthsasd','wfwewef@gmail.com','980','qgeqweg','qwegqwe'),(14,20,NULL,'fqwefqw','23r2','232r2','23tqwe','3454eg');
/*!40000 ALTER TABLE `web_contact` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-09 20:43:18
