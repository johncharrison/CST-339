CREATE DATABASE  IF NOT EXISTS `nile`;
USE `nile`;
SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';


SET NAMES utf8mb4;

DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `ID` bigint unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `DESCRIPTION` text,
  `PRICE` float NOT NULL,
  `STOCK` int NOT NULL,
  `CREATED_DATE` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `MODIFIED_DATE` datetime NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `ID` bigint unsigned NOT NULL AUTO_INCREMENT,
  `FIRSTNAME` varchar(255) NOT NULL,
  `LASTNAME` varchar(255) NOT NULL,
  `EMAIL` varchar(255) NOT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  `CREATED_DATE` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `MODIFIED_DATE` datetime NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `ID` bigint unsigned NOT NULL AUTO_INCREMENT,
  `USERS_ID` bigint unsigned NOT NULL,
  `PRODUCTS_ID` bigint unsigned NOT NULL,
  `QUANTITY` int unsigned NOT NULL,
  `COMPLETED` tinyint(1) NOT NULL DEFAULT '0',
  `CREATED_DATE` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `MODIFIED_DATE` datetime NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `USERS_ID` (`USERS_ID`),
  KEY `PRODUCTS_ID` (`PRODUCTS_ID`),
  CONSTRAINT `ORDERS_ibfk_1` FOREIGN KEY (`USERS_ID`) REFERENCES `users` (`ID`) ON DELETE RESTRICT,
  CONSTRAINT `ORDERS_ibfk_2` FOREIGN KEY (`PRODUCTS_ID`) REFERENCES `products` (`ID`) ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
