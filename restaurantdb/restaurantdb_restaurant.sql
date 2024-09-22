-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: restaurantdb
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `restaurant`
--

DROP TABLE IF EXISTS `restaurant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `restaurant` (
  `id` int NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `restaurant_description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant`
--

LOCK TABLES `restaurant` WRITE;
/*!40000 ALTER TABLE `restaurant` DISABLE KEYS */;
INSERT INTO `restaurant` VALUES (1,'House 85, Road 25/a, Block A, Banani','Dhaka','Royal Park Residence Hotel','This restaurant is well known for their indian and western food items!!!'),(2,'Rangs Paramount, Plot No. 11, Road No. 17, Block K, Banani, Dhaka','Dhaka','Cafe CAF','This restaurant is well known for their western food items!!!'),(52,'House - 50. Level - 11, Block - C, Road - 11, Banani','Dhaka','Gotcha - Art of Tea - Banani','Their signature product is tea, they sell around 20 types of tea.And their drinks are also delicious!!!'),(202,'alamin 3/A manikpir road, noyasorok road, sylhet Near by The Mad Grill, Sylhet, Bangladesh','Sylhet','Juice Plus','Vibrant juice bar serving refreshing, exotic blends with fresh, organic ingredients.'),(203,'Shop No - 08, Biplop Uddan, 2no gate','Chittagong','Wow Waffle','Crispy waffle house offering sweet, savory, and gourmet toppings for everyone.'),(204,'GEC Circle\' Area, CDA Avenue, Chittagong','Chittagong','Kacchi Express','Authentic Kachhi Biriyani spot serving rich, aromatic flavors with tender meat.'),(205,'118 Upper Jessore Rd, Khulna Khulna 9000','Khulna','Foodbox','Flavor-packed meatbox restaurant serving juicy, tender meats with bold seasonings.'),(206,'IN front of Khalispur Mohsin College , Khulna.','Khulna','PizzaRolla','Artisanal pizza place offering wood-fired, thin-crust pies with gourmet topping...'),(252,'IN front of Khalispur Mohsin College , Khulna.','Khulna','PizzaRolla','Artisanal pizza place offering wood-fired, thin-crust pies with gourmet topping...');
/*!40000 ALTER TABLE `restaurant` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-22 19:04:39
