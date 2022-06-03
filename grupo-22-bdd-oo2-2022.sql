CREATE SCHEMA IF NOT EXISTS `grupo-22-bdd-oo2-2022` DEFAULT CHARACTER SET utf8 ;
USE `grupo-22-bdd-oo2-2022`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: grupo-22-bdd-oo2-2022
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `apellido` varchar(45) NOT NULL,
  `clave` varchar(60) NOT NULL,
  `createdat` datetime(6) DEFAULT NULL,
  `dni` bigint NOT NULL,
  `email` varchar(45) NOT NULL,
  `enabled` tinyint(1) DEFAULT '1',
  `nombre` varchar(45) NOT NULL,
  `tipo_documento` varchar(255) NOT NULL,
  `updatedat` datetime(6) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `rol_id` int NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `UK_ma71x4n4tydibsd9qt0m71le7` (`dni`),
  UNIQUE KEY `UK_5171l57faosmj8myawaucatdw` (`email`),
  UNIQUE KEY `UK_i02kr8ui5pqddyd7pkm3v4jbt` (`usuario`),
  KEY `FKbl9l2tfkiy0krho63kbqmlwyf` (`rol_id`),
  CONSTRAINT `FKbl9l2tfkiy0krho63kbqmlwyf` FOREIGN KEY (`rol_id`) REFERENCES `usuario_rol` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'admin','21232f297a57a5a743894a0e4a801fc3','2022-05-16 12:05:07.317713',11111111,'admin@admin.com',1,'admin','DNI','2022-05-16 12:05:07.317713','admin',1),(2,'auditor','f7d07071ed9431ecae3a8d45b4c82bb2','2022-05-16 12:03:04.781961',22222222,'auditor@auditor.com',1,'auditor','DNI','2022-05-16 12:03:04.781961','auditor',2);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_rol`
--

DROP TABLE IF EXISTS `usuario_rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario_rol` (
  `id` int NOT NULL AUTO_INCREMENT,
  `createdat` datetime(6) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT '1',
  `rol` varchar(100) NOT NULL,
  `updatedat` datetime(6) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_9fb2oynawbjqah9pylnfgkxfj` (`rol`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_rol`
--

LOCK TABLES `usuario_rol` WRITE;
/*!40000 ALTER TABLE `usuario_rol` DISABLE KEYS */;
INSERT INTO `usuario_rol` VALUES (1,'2022-05-16 12:05:07.317713',1,'ROL_ADMIN','2022-05-16 12:28:10.214720'),(2,'2022-05-16 12:05:07.317713',1,'ROL_AUDITOR','2022-05-16 11:34:23.423287');
/*!40000 ALTER TABLE `usuario_rol` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `Aula`
--

DROP TABLE IF EXISTS `Aula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Aula` (
  `id_aula` int NOT NULL AUTO_INCREMENT,
  `numero` int NOT NULL,
  `id_edificio` int NOT NULL,
  PRIMARY KEY (`id_aula`),
  KEY `fk_Aula_1_idx` (`id_edificio`),
  CONSTRAINT `fk_Aula_1` FOREIGN KEY (`id_edificio`) REFERENCES `Edificio` (`id_edificio`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Aula`
--

LOCK TABLES `Aula` WRITE;
/*!40000 ALTER TABLE `Aula` DISABLE KEYS */;
INSERT INTO `Aula` VALUES (1,7,1),(2,6,1),(3,19,1),(4,21,1),(5,11,1),(6,1,2),(7,2,2);
/*!40000 ALTER TABLE `Aula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Edificio`
--

DROP TABLE IF EXISTS `Edificio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Edificio` (
  `id_edificio` int NOT NULL AUTO_INCREMENT,
  `edificio` varchar(30) NOT NULL,
  PRIMARY KEY (`id_edificio`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Edificio`
--

LOCK TABLES `Edificio` WRITE;
/*!40000 ALTER TABLE `Edificio` DISABLE KEYS */;
INSERT INTO `Edificio` VALUES (1,'José Hernandez'),(2,'Scalabrini');
/*!40000 ALTER TABLE `Edificio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Espacio`
--

DROP TABLE IF EXISTS `Espacio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Espacio` (
  `id_espacio` int NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `turno` char(1) NOT NULL,
  `id_aula` int NOT NULL,
  `libre` tinyint NOT NULL,
  PRIMARY KEY (`id_espacio`),
  KEY `fk_Espacio_1_idx` (`id_aula`),
  CONSTRAINT `fk_Espacio_1` FOREIGN KEY (`id_aula`) REFERENCES `Aula` (`id_aula`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Espacio`
--

LOCK TABLES `Espacio` WRITE;
/*!40000 ALTER TABLE `Espacio` DISABLE KEYS */;
INSERT INTO `Espacio` VALUES (1,'2022-05-01','M',5,1),(2,'2022-05-02','M',5,1),(3,'2022-05-03','M',5,1),(4,'2022-05-04','M',5,1),(5,'2022-05-05','M',5,1),(6,'2022-05-06','M',5,1),(7,'2022-05-07','M',5,1),(8,'2022-05-08','M',5,1),(9,'2022-05-09','M',5,1),(10,'2022-05-10','M',5,1),(11,'2022-05-11','M',5,1),(12,'2022-05-12','M',5,1),(13,'2022-05-13','M',5,1),(14,'2022-05-14','M',5,1),(15,'2022-05-15','M',5,1),(16,'2022-05-16','M',5,1),(17,'2022-05-17','M',5,1),(18,'2022-05-18','M',5,1),(19,'2022-05-19','M',5,1),(20,'2022-05-20','M',5,1),(21,'2022-05-21','M',5,1),(22,'2022-05-22','M',5,1),(23,'2022-05-23','M',5,1),(24,'2022-05-24','M',5,1),(25,'2022-05-25','M',5,1),(26,'2022-05-26','M',5,1),(27,'2022-05-27','M',5,1),(28,'2022-05-28','M',5,1),(29,'2022-05-29','M',5,1),(30,'2022-05-30','M',5,1),(31,'2022-05-31','M',5,1),(32,'2022-05-01','M',6,1),(33,'2022-05-02','M',6,1),(34,'2022-05-03','M',6,1),(35,'2022-05-04','M',6,1),(36,'2022-05-05','M',6,1),(37,'2022-05-06','M',6,1),(38,'2022-05-07','M',6,1),(39,'2022-05-08','M',6,1),(40,'2022-05-09','M',6,1),(41,'2022-05-10','M',6,1),(42,'2022-05-11','M',6,1),(43,'2022-05-12','M',6,1),(44,'2022-05-13','M',6,1),(45,'2022-05-14','M',6,1),(46,'2022-05-15','M',6,1),(47,'2022-05-16','M',6,1),(48,'2022-05-17','M',6,1),(49,'2022-05-18','M',6,1),(50,'2022-05-19','M',6,1),(51,'2022-05-20','M',6,1),(52,'2022-05-21','M',6,1),(53,'2022-05-22','M',6,1),(54,'2022-05-23','M',6,1),(55,'2022-05-24','M',6,1),(56,'2022-05-25','M',6,1),(57,'2022-05-26','M',6,1),(58,'2022-05-27','M',6,1),(59,'2022-05-28','M',6,1),(60,'2022-05-29','M',6,1),(61,'2022-05-30','M',6,1),(62,'2022-05-31','M',6,1);
/*!40000 ALTER TABLE `Espacio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Laboratorio`
--

DROP TABLE IF EXISTS `Laboratorio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Laboratorio` (
  `id_laboratorio` int NOT NULL,
  `cantSillas` int NOT NULL,
  `cantPC` int NOT NULL,
  PRIMARY KEY (`id_laboratorio`),
  CONSTRAINT `fk_Laboratorio_1` FOREIGN KEY (`id_laboratorio`) REFERENCES `Aula` (`id_aula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Laboratorio`
--

LOCK TABLES `Laboratorio` WRITE;
/*!40000 ALTER TABLE `Laboratorio` DISABLE KEYS */;
INSERT INTO `Laboratorio` VALUES (5,70,36),(6,73,36),(7,65,32);
/*!40000 ALTER TABLE `Laboratorio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tradicional`
--

DROP TABLE IF EXISTS `Tradicional`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Tradicional` (
  `id_tradicional` int NOT NULL,
  `cantBancos` int NOT NULL,
  `pizarron` varchar(10) NOT NULL,
  `tieneProyector` tinyint NOT NULL,
  PRIMARY KEY (`id_tradicional`),
  CONSTRAINT `fk_Tradicional_1` FOREIGN KEY (`id_tradicional`) REFERENCES `Aula` (`id_aula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tradicional`
--

LOCK TABLES `Tradicional` WRITE;
/*!40000 ALTER TABLE `Tradicional` DISABLE KEYS */;
INSERT INTO `Tradicional` VALUES (1,100,'fibron',0),(2,100,'tiza',0),(3,120,'fibron',1),(4,100,'tiza',0);
/*!40000 ALTER TABLE `Tradicional` ENABLE KEYS */;
UNLOCK TABLES;

/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-16 13:01:23
