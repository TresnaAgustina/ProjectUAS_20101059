/*
SQLyog Ultimate - MySQL GUI v8.21 
MySQL - 5.5.5-10.1.37-MariaDB : Database - dbmhs
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`dbmhs` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `dbmhs`;

/*Table structure for table `mhs` */

DROP TABLE IF EXISTS `mhs`;

CREATE TABLE `mhs` (
  `NIM` varchar(8) NOT NULL,
  `NAMA` varchar(25) DEFAULT NULL,
  `JURUSAN` varchar(15) DEFAULT NULL,
  `JK` varchar(1) DEFAULT NULL,
  `TGLLAHIR` date DEFAULT NULL,
  PRIMARY KEY (`NIM`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `mhs` */

insert  into `mhs`(`NIM`,`NAMA`,`JURUSAN`,`JK`,`TGLLAHIR`) values ('11223345','Samsul Arif Sanusi','KAB','P','2000-07-15'),('11223346','Siti Badriah ','KAB','L','2000-10-20');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `iduser` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(10) NOT NULL,
  `passkey` varchar(255) NOT NULL,
  PRIMARY KEY (`iduser`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `users` */

insert  into `users`(`iduser`,`username`,`passkey`) values (1,'andi','a152e841783914146e4bcd4f39100686'),(2,'deni','e10adc3949ba59abbe56e057f20f883e');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
