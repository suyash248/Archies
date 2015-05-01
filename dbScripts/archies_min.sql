/*
SQLyog Ultimate - MySQL GUI v8.2 
MySQL - 5.6.20 : Database - archies
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`archies` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `archies`;

/*Table structure for table `authorities` */

DROP TABLE IF EXISTS `authorities`;

CREATE TABLE `authorities` (
  `AUTH_ID` int(10) NOT NULL AUTO_INCREMENT,
  `AUTHORITY_NAME` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`AUTH_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `authorities` */

insert  into `authorities`(`AUTH_ID`,`AUTHORITY_NAME`) values (1,'ROLE_USER'),(2,'ROLE_ADMIN');

/*Table structure for table `group_authorities` */

DROP TABLE IF EXISTS `group_authorities`;

CREATE TABLE `group_authorities` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `GROUP_ID` int(10) NOT NULL,
  `AUTH_ID` int(10) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_3vv0hp8pfdwi7kfqhqwjedry3` (`AUTH_ID`),
  KEY `FK_od0behvix3bo1t025vif36tk7` (`GROUP_ID`),
  CONSTRAINT `FK_3vv0hp8pfdwi7kfqhqwjedry3` FOREIGN KEY (`AUTH_ID`) REFERENCES `authorities` (`AUTH_ID`),
  CONSTRAINT `FK_od0behvix3bo1t025vif36tk7` FOREIGN KEY (`GROUP_ID`) REFERENCES `groups` (`GROUP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `group_authorities` */

/*Table structure for table `group_members` */

DROP TABLE IF EXISTS `group_members`;

CREATE TABLE `group_members` (
  `GROUP_MEMBER_ID` int(10) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(50) NOT NULL,
  `GROUP_ID` int(10) NOT NULL,
  PRIMARY KEY (`GROUP_MEMBER_ID`),
  KEY `FK_dw0515xfyfi4o5bla1ya1yqfc` (`GROUP_ID`),
  KEY `FK_jngujmbxgyqvlodgcehdqp0yh` (`USER_NAME`),
  CONSTRAINT `FK_dw0515xfyfi4o5bla1ya1yqfc` FOREIGN KEY (`GROUP_ID`) REFERENCES `groups` (`GROUP_ID`),
  CONSTRAINT `FK_jngujmbxgyqvlodgcehdqp0yh` FOREIGN KEY (`USER_NAME`) REFERENCES `users` (`USER_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `group_members` */

/*Table structure for table `groups` */

DROP TABLE IF EXISTS `groups`;

CREATE TABLE `groups` (
  `GROUP_ID` int(10) NOT NULL AUTO_INCREMENT,
  `GROUP_NAME` varchar(100) NOT NULL,
  PRIMARY KEY (`GROUP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `groups` */

/*Table structure for table `user_authorities` */

DROP TABLE IF EXISTS `user_authorities`;

CREATE TABLE `user_authorities` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(50) NOT NULL,
  `AUTH_ID` int(10) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_ihsn0h5ni6gvesvusfiv7xf2i` (`AUTH_ID`),
  KEY `FK_5qd13nxr8p5yhycfonrurwi2d` (`USER_NAME`),
  CONSTRAINT `FK_5qd13nxr8p5yhycfonrurwi2d` FOREIGN KEY (`USER_NAME`) REFERENCES `users` (`USER_NAME`),
  CONSTRAINT `FK_ihsn0h5ni6gvesvusfiv7xf2i` FOREIGN KEY (`AUTH_ID`) REFERENCES `authorities` (`AUTH_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `user_authorities` */

insert  into `user_authorities`(`ID`,`USER_NAME`,`AUTH_ID`) values (1,'archadmin',1),(2,'archadmin',2);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `USER_ID` int(10) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(40) NOT NULL,
  `USER_PASS` varchar(40) NOT NULL,
  `ACTIVE` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`USER_NAME`),
  UNIQUE KEY `USER_NAME` (`USER_NAME`),
  KEY `USER_ID` (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`USER_ID`,`USER_NAME`,`USER_PASS`,`ACTIVE`) values (5,'archadmin','1234',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
