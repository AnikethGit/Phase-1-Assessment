-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: foodbox
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
-- Table structure for table `dishes`
--

DROP TABLE IF EXISTS `dishes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dishes` (
  `did` bigint NOT NULL,
  `course` varchar(255) DEFAULT NULL,
  `cuisine` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `is_available` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `total_available` int NOT NULL,
  `dish_image_img_id` bigint DEFAULT NULL,
  PRIMARY KEY (`did`),
  KEY `FKoh67r86ucs7cff4w9noxvy05o` (`dish_image_img_id`),
  CONSTRAINT `FKoh67r86ucs7cff4w9noxvy05o` FOREIGN KEY (`dish_image_img_id`) REFERENCES `dish_image` (`img_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dishes`
--

LOCK TABLES `dishes` WRITE;
/*!40000 ALTER TABLE `dishes` DISABLE KEYS */;
INSERT INTO `dishes` VALUES (3,'Main course','Mughlai','Biryani is a mixed rice dish originating among the Muslims of South Asia. It is made with Indian spices, vegetables, rice, and usually some type of meat, or in some cases without any meat, and sometimes, in addition, eggs and potatoes.',_binary '','Chicken Biryani',273,'Chicken',33,4),(5,'Main Course','Continental','Paneer or cottage cheese pieces in a hot and spicy Peri Peri sauce. With tossed vegetables on the side. Try this easy to cook, healthy, and wholesome meal that is perfect for lunch or dinner.',_binary '','Peri Peri Paneer Steak with Tossed Vegetables',350,'Vegetarian',14,6),(9,'Main Course','Indian','Potato cheese patties or balls or koftas as we call them served on a bed of rich creamy spiced gravy. They make for a rich and delicious dinner when served with a side of roti, paratha, naan or cumin rice.',_binary '','Aloo Kofta',240,'Vegetarian',25,10),(11,'Main Course','Italian','Flavorful Margherita Pizza made with homemade whole wheat pizza dough, tomato sauce, mozzarella cheese and fresh basil, but can also be made using store bought staples and your choice of toppings.',_binary '','Margherita Pizza',480,'Vegetarian',36,12),(17,'Antipasto','Italian','Bruschetta with tomato and basil! Chopped fresh tomatoes with garlic, basil, olive oil, and vinegar, served on toasted slices of French or Italian bread.',_binary '','Bruschetta',320,'Chicken',9,18),(19,'Main Course','Fusion','Mexican Lasagna! Also known as Taco Lasagna or Mexican Casserole, this dish is layered with corn tortillas, ground beef, green chiles, beans, salsa, and cheese. A huge hit with a crowd! Perfect for potlucks.',_binary '','Mexican Lasagna',480,'Vegetarian',15,20),(21,'Main Course','Fusion','Mushroom cooked in spicy coconut gravy. An improvised version of Kerala theeyal preparation with mushrooms.',_binary '','Mushroom Masala Curry with Coconut',310,'Vegetarian',26,22),(23,'Main Course','Indian','Paneer butter masala, also known as butter paneer is a rich & creamy curry made with paneer, spices, onions, tomatoes, cashews and butter.',_binary '','Paneer Butter Masala',270,'Vegetarian',48,24),(25,'Main Course','Continental','Barbecue chicken consists of chicken parts or entire chickens that are barbecued, grilled or smoked. There are many global and regional preparation techniques and cooking styles.',_binary '','Barbecue chicken',450,'Chicken',16,26),(27,'Dessert','Dessert','Blueberry Cheesecake',_binary '','Blueberry Cheesecake',180,'Vegetarian',50,28),(29,'Dessert','Dessert','Three-layered Nutella Chocolate Cake with Swiss Meringue frosting is a show-stopping dessert that’s perfectly nutty, moist, and decadent.',_binary '','Nutella Cake',550,'Vegetarian',28,30),(31,'Dessert','Dessert','Three-layered Nutella Chocolate Cake with Swiss Meringue frosting is a show-stopping dessert that’s perfectly nutty, moist, and decadent.',_binary '','Fruit Cocktail with Ice-cream',120,'Vegetarian',45,32),(33,'Main Course','Chinese','The egg roll is a variety of deep-fried appetizer served in American Chinese restaurants. It is a cylindrical, savory roll with shredded cabbage, chopped meat, or other fillings inside a thickly-wrapped wheat flour skin, which is fried in hot oil.',_binary '','Egg roll',140,'Egg',49,34),(35,'Snacks','Quick Bites','French fries are deep-fried potatoes of disputed origin from Belgium or France. They are prepared by cutting potatoes into even strips, drying them, and frying them.',_binary '','French Fries',150,'Vegetarian',47,36),(37,'Main Course','Mughlai','Mughlai paratha is a soft fried bread enhanced by a stuffing of keema, egg, onions and pepper; or a paratha stuffed with the same or similar ingredients.',_binary '','Mughlai Paratha',190,'Lamb',85,38),(39,'Main Course','Chinese','It is a famous Sichuan-style specialty, popular with both Chinese and foreigners. The major ingredients are diced chicken, dried chili, cucumber, and fried peanuts (or cashews).',_binary '','Kung Pao Chicken',420,'Chicken',42,40),(41,'Snacks','Quick Bites','This Burger Recipe covers everything needed to make delightful veggie burgers from scratch, including how to prepare delicious homemade vegetable patties, a spiced mayonnaise dressing with fresh veggie toppings.',_binary '\0','Veggie Burger',220,'Vegetarian',30,42);
/*!40000 ALTER TABLE `dishes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-23  0:26:50
