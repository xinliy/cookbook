-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: cookbook
-- ------------------------------------------------------
-- Server version	5.6.24-log

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
-- Table structure for table `ingredients`
--

DROP TABLE IF EXISTS `ingredients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingredients` (
  `ingredientId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ingredientName` varchar(80) NOT NULL,
  PRIMARY KEY (`ingredientId`),
  UNIQUE KEY `ingredient_id_UNIQUE` (`ingredientId`,`ingredientName`),
  UNIQUE KEY `ingredientName_UNIQUE` (`ingredientName`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredients`
--

LOCK TABLES `ingredients` WRITE;
/*!40000 ALTER TABLE `ingredients` DISABLE KEYS */;
INSERT INTO `ingredients` VALUES (18,'brown sugar'),(7,'Chiangang vinegar'),(3,'chicken breast'),(6,'chicken stock'),(22,'chicken stock or water'),(32,'chili powder'),(31,'Chinese five spicy powder'),(17,'cooking oil'),(26,'coriander'),(1,'cornstarch'),(9,'dark soy sauce'),(11,'dried red chilis'),(13,'garlic'),(14,'ginger'),(20,'light soy sauce'),(10,'peanut oil'),(15,'peanuts'),(27,'pickled Sichuan vegetable'),(16,'pork belly'),(23,'potato noodles'),(35,'salt'),(12,'scallions'),(8,'sesame oil'),(4,'Shaoxin rice wine'),(30,'Sichuan peppercorn powder'),(2,'soy sauce'),(25,'spring onion'),(5,'sugar'),(33,'vinegar');
/*!40000 ALTER TABLE `ingredients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preparation_step`
--

DROP TABLE IF EXISTS `preparation_step`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `preparation_step` (
  `recipeId` int(10) unsigned NOT NULL,
  `step` int(10) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`recipeId`,`step`),
  KEY `fk_Recipes_idx` (`recipeId`),
  CONSTRAINT `fk_preparation_step_recipe` FOREIGN KEY (`recipeId`) REFERENCES `recipe` (`recipeId`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preparation_step`
--

LOCK TABLES `preparation_step` WRITE;
/*!40000 ALTER TABLE `preparation_step` DISABLE KEYS */;
INSERT INTO `preparation_step` VALUES (1,1,'Mix together cornstarch and 1 tbsp. of the soy sauce in a medium bowl.'),(1,2,'Add chicken, toss well, and set aside to marinate for 30 minutes.'),(1,3,'Meanwhile, mix together the remaining 3 tbsp. soy sauce, rice wine, sugar, stock, vinegar, sesame oil, and dark soy sauce.'),(1,4,'Set aside.'),(1,5,'Heat peanut oil in a wok or large nonstick skillet over high heat until just beginning to smoke.'),(1,6,'Add chilis, half the scallions, garlic, ginger, and chicken and stir-fry until chicken is golden, 3-5 minutes.'),(1,7,'Add soy sauce mixture and stir-fry until sauce thickens, about 2 minutes.'),(1,8,'Stir in peanuts.'),(1,9,'Garnish with remaining scallions.'),(2,1,'Bring a pot of water to a boil and blanch the pork for a couple minutes.'),(2,2,'Take the pork out of the pot and set aside.'),(2,3,'Over low heat, add oil and sugar to your wok.'),(2,4,'Melt the sugar slightly and add the pork.'),(2,5,'Raise the heat to medium and cook until the pork is lightly browned.'),(2,6,'Turn the heat back down to low and add cooking wine, light soy sauce, dark soy sauce, and chicken stock.'),(2,7,'Cover and simmer for about 60 minutes to 90 minutes until pork is fork tender.'),(2,8,'Every 5-10 minutes, stir to prevent burning and add water if it gets too dry.'),(2,9,'Once the pork is fork tender, if there is still a lot of visible liquid, uncover the wok, turn up the heat, and stir continuously the sauce has reduced to a glistening coating.'),(3,1,'Soak the sweet potato noodles with hot water around 30 minutes.'),(3,2,'Transfer out and set aside.'),(3,3,'In the serving bowls and mix all the seasonings.'),(3,4,'Heat up peanuts oil in pan to stir-fry the mashed garlic until aroma.'),(3,5,'Mix the garlic oil with the seasonings.'),(3,6,'Add some spring onions and corianders in serving bowls.'),(3,7,'Pour in boiling water or stock to tune the seasonings.'),(3,8,'Add vinegar and light soy sauce.'),(3,9,'Mix well and set aside.'),(3,10,'Cook soaked sweet potato noodles around 3~5 minutes until you can break the noodles with your fingers.'),(3,11,'Transfer the noodles out to the serving bowls and then add top with pickled vegetables, roasted peanuts and chopped spring onions and coriander. '),(4,1,'Mix together cornstarch and 1 tbsp. of the soy sauce in a medium bowl.'),(4,2,'Add chicken, toss well, and set aside to marinate for 30 minutes.'),(4,3,'Meanwhile, mix together the remaining 3 tbsp. soy sauce, rice wine, sugar, stock, vinegar, sesame oil, and dark soy sauce.'),(4,4,'Set aside.'),(4,5,'Heat peanut oil in a wok or large nonstick skillet over high heat until just beginning to smoke.'),(4,6,'Add chilis, half the scallions, garlic, ginger, and chicken and stir-fry until chicken is golden, 3-5 minutes.'),(4,7,'Add soy sauce mixture and stir-fry until sauce thickens, about 2 minutes.'),(4,8,'Stir in peanuts.'),(4,9,'Garnish with remaining scallions.');
/*!40000 ALTER TABLE `preparation_step` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipe`
--

DROP TABLE IF EXISTS `recipe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recipe` (
  `recipeId` int(10) unsigned NOT NULL,
  `dishName` varchar(80) NOT NULL,
  `location` varchar(45) DEFAULT NULL,
  `servings` int(11) DEFAULT NULL,
  `preparationTime` int(10) unsigned DEFAULT NULL,
  `cookingTime` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`recipeId`),
  UNIQUE KEY `name_UNIQUE` (`dishName`,`recipeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipe`
--

LOCK TABLES `recipe` WRITE;
/*!40000 ALTER TABLE `recipe` DISABLE KEYS */;
INSERT INTO `recipe` VALUES (1,'Gong Bao Jiding','Sichuan Dish',4,30,10),(2,'Hong Shao Rou','Hunan Dish',4,5,100),(3,'Suan La Fen','Sichuan Dish',2,30,5),(4,'La Zi Ji','Sichuan Dish',4,60,20);
/*!40000 ALTER TABLE `recipe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipe_has_ingredients`
--

DROP TABLE IF EXISTS `recipe_has_ingredients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recipe_has_ingredients` (
  `recipe_recipeId` int(10) unsigned NOT NULL,
  `ingredients_ingredientId` int(10) unsigned NOT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `unit` varchar(45) DEFAULT NULL,
  `description` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`recipe_recipeId`,`ingredients_ingredientId`),
  KEY `fk_recipe_has_ingredients_ingredients1_idx` (`ingredients_ingredientId`),
  KEY `fk_recipe_has_ingredients_recipe1_idx` (`recipe_recipeId`),
  CONSTRAINT `fk_recipe_has_ingredients_ingredients1` FOREIGN KEY (`ingredients_ingredientId`) REFERENCES `ingredients` (`ingredientId`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_recipe_has_ingredients_recipe1` FOREIGN KEY (`recipe_recipeId`) REFERENCES `recipe` (`recipeId`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipe_has_ingredients`
--

LOCK TABLES `recipe_has_ingredients` WRITE;
/*!40000 ALTER TABLE `recipe_has_ingredients` DISABLE KEYS */;
INSERT INTO `recipe_has_ingredients` VALUES (1,1,1,'tablespoon','null'),(1,2,4,'tablespoon','null'),(1,3,1,'kg','null'),(1,4,3,'tablespoon','null'),(1,5,2,'tablespoon','null'),(1,6,3,'tablespoon','null'),(1,7,4,'teaspoon','null'),(1,8,4,'tablespoon','null'),(1,9,2,'teaspoon','null'),(1,10,3,'tablespoon','null'),(1,11,12,'pieces','stemmed, halved crosswise, and seeded'),(1,12,5,'pieces','white part only, thickly sliced crosswise'),(1,13,1,'cloves','peeled, thinly sliced'),(1,14,1,'pieces','peeled, minced'),(1,15,1,'cups','peeled, thinly sliced'),(2,4,3,'tablespoon','null'),(2,9,1,'tablespoon','null'),(2,16,1,'kg','cut into 2cm pieces'),(2,17,2,'tablespoon','null'),(2,18,1,'tablespoon','null'),(2,20,1,'tablespoon','null'),(2,22,2,'cups','null'),(3,10,1,'tablespoon','null'),(3,13,3,'cloves','mashed'),(3,15,2,'tablespoon','roasted'),(3,20,1,'tablespoon','null'),(3,23,1,'bunch','null'),(3,25,1,'tablespoon','chopped'),(3,26,1,'tablespoon','chopped'),(3,27,2,'tablespoon','chopped'),(3,30,1,'teaspoon','null'),(3,31,1,'teaspoon','null'),(3,32,1,'teaspoon','null'),(3,33,1,'tablespoon','null'),(3,35,1,'teaspoon','null'),(4,1,1,'tablespoon','null'),(4,2,4,'tablespoon','null'),(4,3,1,'kg','null'),(4,4,3,'tablespoon','null'),(4,5,2,'tablespoon','null'),(4,6,3,'tablespoon','null'),(4,7,4,'teaspoon','null'),(4,8,4,'tablespoon','null'),(4,9,2,'teaspoon','null'),(4,10,3,'tablespoon','null'),(4,11,12,'pieces','stemmed, halved crosswise, and seeded'),(4,12,5,'pieces','white part only, thickly sliced crosswise'),(4,13,1,'cloves','peeled, thinly sliced'),(4,14,1,'pieces','peeled, minced'),(4,15,1,'cups','peeled, thinly sliced');
/*!40000 ALTER TABLE `recipe_has_ingredients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipe_has_tag`
--

DROP TABLE IF EXISTS `recipe_has_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recipe_has_tag` (
  `recipe_recipeId` int(10) unsigned NOT NULL,
  `tag_tagId` int(11) NOT NULL,
  PRIMARY KEY (`recipe_recipeId`,`tag_tagId`),
  KEY `fk_recipe_has_tag_tag1_idx` (`tag_tagId`),
  KEY `fk_recipe_has_tag_recipe1_idx` (`recipe_recipeId`),
  CONSTRAINT `fk_recipe_has_tag_recipe1` FOREIGN KEY (`recipe_recipeId`) REFERENCES `recipe` (`recipeId`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_recipe_has_tag_tag1` FOREIGN KEY (`tag_tagId`) REFERENCES `tag` (`tagId`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipe_has_tag`
--

LOCK TABLES `recipe_has_tag` WRITE;
/*!40000 ALTER TABLE `recipe_has_tag` DISABLE KEYS */;
INSERT INTO `recipe_has_tag` VALUES (1,1),(2,1),(1,2),(4,2),(3,3),(4,3),(3,4);
/*!40000 ALTER TABLE `recipe_has_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tag` (
  `tagId` int(11) NOT NULL AUTO_INCREMENT,
  `tagContent` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`tagId`),
  UNIQUE KEY `tagContent_UNIQUE` (`tagContent`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` VALUES (2,'salty'),(4,'sour'),(3,'spicy'),(1,'sweet');
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'cookbook'
--

--
-- Dumping routines for database 'cookbook'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-30 11:19:15
