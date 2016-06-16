/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.6.21 : Database - lifemedid
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`lifemedid` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `lifemedid`;

/*Table structure for table `applicants` */

DROP TABLE IF EXISTS `applicants`;

CREATE TABLE `applicants` (
  `applicant_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `id` varchar(100) NOT NULL,
  `suffix` varchar(5) DEFAULT NULL,
  `first_name` varchar(100) NOT NULL,
  `middle_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) NOT NULL,
  `level_of_assurance` varchar(20) DEFAULT NULL,
  `date_of_birth` varchar(10) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `lifemed_id` bigint(20) NOT NULL,
  PRIMARY KEY (`applicant_id`),
  UNIQUE KEY `FK_lifemed_id` (`lifemed_id`),
  CONSTRAINT `FK_lifemed_id` FOREIGN KEY (`lifemed_id`) REFERENCES `lifemedid_transactions` (`lifemed_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=65537 DEFAULT CHARSET=latin1;

/*Data for the table `applicants` */

insert  into `applicants`(`applicant_id`,`id`,`suffix`,`first_name`,`middle_name`,`last_name`,`level_of_assurance`,`date_of_birth`,`created_date`,`updated_date`,`lifemed_id`) values (1,'id1',NULL,'first_name1',NULL,'last_name1','level1','date_of_bi','2016-06-09 18:08:32','2016-06-16 12:12:23',1),(2,'id2',NULL,'first_name2',NULL,'last_name2','level1','date_of_bi','2016-06-09 18:08:32','2016-06-16 12:12:27',2),(3,'id3',NULL,'first_name3',NULL,'last_name3','level1','date_of_bi','2016-06-09 18:08:32','2016-06-16 12:12:28',3),(4,'id4',NULL,'first_name4',NULL,'last_name4','level1','date_of_bi','2016-06-09 18:08:32','2016-06-16 12:12:30',4),(65536,'12345',NULL,'Freddy',NULL,'Flintstone','level1','1978-11-22','2016-06-10 15:11:50','2016-06-16 12:12:36',65536);

/*Table structure for table `hibernate_sequences` */

DROP TABLE IF EXISTS `hibernate_sequences`;

CREATE TABLE `hibernate_sequences` (
  `sequence_name` varchar(255) DEFAULT NULL,
  `sequence_next_hi_value` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `hibernate_sequences` */

insert  into `hibernate_sequences`(`sequence_name`,`sequence_next_hi_value`) values ('applicants',3),('idpdocuments',3),('lifemedids',3);

/*Table structure for table `idpdocuments` */

DROP TABLE IF EXISTS `idpdocuments`;

CREATE TABLE `idpdocuments` (
  `idp_document_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `suffix` varchar(5) DEFAULT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `middle_name` varchar(100) DEFAULT NULL,
  `date_of_birth` varchar(10) NOT NULL,
  `issuing_authority` varchar(2) NOT NULL,
  `document_issuer` varchar(2) NOT NULL,
  `document_expiration_date` varchar(10) NOT NULL,
  `document_type` varchar(2) NOT NULL,
  `document_title` varchar(40) NOT NULL,
  `document_number` varchar(80) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `applicant_id` bigint(20) NOT NULL,
  PRIMARY KEY (`idp_document_id`),
  KEY `FK_applicant_IDPDocs_keys` (`applicant_id`),
  CONSTRAINT `FK_applicant_IDPDocs_keys` FOREIGN KEY (`applicant_id`) REFERENCES `applicants` (`applicant_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=65537 DEFAULT CHARSET=latin1;

/*Data for the table `idpdocuments` */

insert  into `idpdocuments`(`idp_document_id`,`suffix`,`first_name`,`last_name`,`middle_name`,`date_of_birth`,`issuing_authority`,`document_issuer`,`document_expiration_date`,`document_type`,`document_title`,`document_number`,`created_date`,`updated_date`,`applicant_id`) values (1,NULL,'first_name1','last_name1',NULL,'1988-11-26','NY','NY','2018-12-25','A','Drivers License','FF-234-123-1231','2016-06-09 18:07:30','2016-06-10 02:53:06',1),(2,NULL,'first_name2','last_name2',NULL,'1988-11-26','NY','NY','2018-12-25','A','Drivers License','FF-234-123-1231','2016-06-09 18:07:30','2016-06-10 02:53:08',2),(3,NULL,'first_name3','last_name3','middle3','1988-11-26','NY','NY','2018-12-25','A','Drivers License','FF-234-123-1231','2016-06-09 18:07:30','2016-06-10 02:53:10',3),(4,NULL,'first_name4','last_name4',NULL,'1988-11-26','NY','NY','2018-12-25','B','SSN Card','FF-234-123-1231','2016-06-09 18:07:30','2016-06-10 02:53:15',4),(5,NULL,'first_name5','last_name5',NULL,'1988-04-21','TX','TX','2018-06-06','B2','IDCard','FF-234-123-1232','2016-06-10 14:38:32','2016-06-10 14:38:41',4),(65536,NULL,'Frederick','Flintstone','J','1978-11-22','IL','IL','2018-04-13','A1','Passport','PP-465-67-6546','2016-06-10 15:11:50','2016-06-10 15:11:50',65536);

/*Table structure for table `lifemedid_transactions` */

DROP TABLE IF EXISTS `lifemedid_transactions`;

CREATE TABLE `lifemedid_transactions` (
  `lifemed_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `transaction_id` varchar(256) NOT NULL,
  `person_id` varchar(100) NOT NULL,
  `organization_id` varchar(100) NOT NULL,
  `time_stamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`lifemed_id`)
) ENGINE=InnoDB AUTO_INCREMENT=65537 DEFAULT CHARSET=latin1;

/*Data for the table `lifemedid_transactions` */

insert  into `lifemedid_transactions`(`lifemed_id`,`transaction_id`,`person_id`,`organization_id`,`time_stamp`,`updated`) values (1,'transaction_id10','person_id_1','org_id_1','2016-06-09 18:01:35','2016-06-09 18:01:35'),(2,'transaction_id11','person_id_2','org_id_2','2016-06-09 18:01:35','2016-06-09 18:01:35'),(3,'transaction_id12','person_id_3','org_id_3','2016-06-09 18:01:35','2016-06-09 18:01:35'),(4,'transaction_id13','person_id_4','org_id_4','2016-06-09 18:01:35','2016-06-09 18:01:35'),(65536,'b3a59d45-6fbb-1014-a7a4-dfe5ca3b7ee6','v2015','22042-3307','2016-06-10 15:11:50','2016-06-10 15:11:50');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
