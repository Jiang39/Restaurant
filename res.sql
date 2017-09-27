/*
SQLyog Ultimate v11.25 (64 bit)
MySQL - 5.1.32-community : Database - restaurant
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`restaurant` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `restaurant`;

/*Table structure for table `cuisine` */

DROP TABLE IF EXISTS `cuisine`;

CREATE TABLE `cuisine` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `cuisine` */

insert  into `cuisine`(`cid`,`cname`) values (1,'粤菜'),(2,'川菜'),(3,'湘菜'),(4,'东北菜'),(6,'鲁菜'),(7,'啊啊'),(8,'aaa'),(9,'1'),(10,'11');

/*Table structure for table `food` */

DROP TABLE IF EXISTS `food`;

CREATE TABLE `food` (
  `fid` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `vipprice` double DEFAULT NULL,
  `url` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `food` */

insert  into `food`(`fid`,`fname`,`cid`,`price`,`vipprice`,`url`) values (1,'白灼虾 ',1,36,23,'a'),(2,'白切鸡 ',1,68,50,'a'),(3,'烤乳猪 ',1,68,50,'a'),(4,'烧鹅 ',1,68,50,'a'),(5,'猪肉荷兰豆 ',1,68,50,'a'),(6,'黄埔炒蛋 ',1,68,50,'a'),(7,'狗肉煲 ',1,68,50,'a'),(8,'鲫鱼汤 ',1,23,29,'a'),(9,'酱猪蹄 ',2,23,18,'a'),(10,'饶汁豆腐 ',2,18,16,'a'),(11,'水煮鱼 ',2,23,20,'a'),(12,'鱼香肉丝 ',2,23,18,'a'),(13,'冰糖湘莲 ',3,23,18,'a'),(14,'东安子鸡 ',3,23,20,'a'),(15,'剁椒鱼头 ',3,23,20,'a'),(16,'烧鸭蛋 ',3,23,20,'a'),(17,'锅头肉 ',4,23,20,'a'),(18,'火腿白菜 ',4,23,20,'a'),(19,'青椒鸡丁 ',4,23,20,'a'),(20,'香锅肉丸 ',4,23,20,'a'),(22,'aaaa',1,11,1.2,'aaa');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
