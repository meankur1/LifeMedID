/*
SQLyog Ultimate v12.08 (64 bit)
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
  `id` varchar(100) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `middle_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) NOT NULL,
  `suffix`             VARCHAR(5)  DEFAULT NULL,
  `date_of_birth` varchar(10) NOT NULL,
  `gender`             VARCHAR(10) NOT NULL,
  `level_of_assurance` VARCHAR(20) DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `lifemed_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

/*Data for the table `applicants` */

INSERT INTO `applicants` (`id`, `first_name`, `middle_name`, `last_name`, `suffix`, `date_of_birth`, `gender`, `level_of_assurance`, `created_date`, `updated_date`, `lifemed_id`)
VALUES ('id1', 'first_name1', NULL, 'last_name1', NULL, 'date_of_bi', 'Male', 'level1', '2016-06-09 18:08:32',
        '2016-06-19 00:11:46', 1),
  ('id2', 'first_name2', NULL, 'last_name2', NULL, 'date_of_bi', 'Female', 'level1', '2016-06-09 18:08:32',
   '2016-06-19 00:11:49', 2),
  ('id3', 'first_name3', NULL, 'last_name3', NULL, 'date_of_bi', 'Male', 'level1', '2016-06-09 18:08:32',
   '2016-06-19 00:11:52', 3),
  ('id4', 'first_name4', NULL, 'last_name4', NULL, 'date_of_bi', 'Female', 'level1', '2016-06-09 18:08:32',
   '2016-06-19 00:11:56', 4);

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
  `id`                       BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `application_id`           VARCHAR(100) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `middle_name` varchar(100) DEFAULT NULL,
  `last_name`                VARCHAR(100) NOT NULL,
  `suffix`                   VARCHAR(5)            DEFAULT NULL,
  `date_of_birth` varchar(10) NOT NULL,
  `gender`                   VARCHAR(10)  NOT NULL,
  `issuing_authority` varchar(2) NOT NULL,
  `document_type` varchar(2) NOT NULL,
  `document_title` varchar(40) NOT NULL,
  `document_issuer`          VARCHAR(2)   NOT NULL,
  `document_id`              VARCHAR(80)  NOT NULL,
  `document_issuance_date`   VARCHAR(10)  NOT NULL,
  `document_expiration_date` VARCHAR(10)  NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_idpdocs_applicants_id` (`application_id`),
  CONSTRAINT `FK_idpdocs_applicants_id` FOREIGN KEY (`application_id`) REFERENCES `applicants` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARSET = latin1;

/*Data for the table `idpdocuments` */

INSERT INTO `idpdocuments` (`id`, `application_id`, `first_name`, `middle_name`, `last_name`, `suffix`, `date_of_birth`, `gender`, `issuing_authority`, `document_type`, `document_title`, `document_issuer`, `document_id`, `document_issuance_date`, `document_expiration_date`, `created_date`, `updated_date`)
VALUES (1, 'id1', 'first_name1', NULL, 'last_name1', NULL, '1988-11-26', 'Male', 'NY', 'A', 'Drivers License', 'NY',
        'FF-234-123-1231', '2016-12-25', '2018-12-25', '2016-06-09 18:07:30', '2016-06-21 19:58:40'),
  (2, 'id2', 'first_name2', NULL, 'last_name2', NULL, '1988-11-26', 'Female', 'NY', 'A', 'Drivers License', 'NY',
   'FF-234-123-1231', '2016-12-25', '2018-12-25', '2016-06-09 18:07:30', '2016-06-21 19:58:42'),
  (3, 'id3', 'first_name3', 'middle3', 'last_name3', NULL, '1988-11-26', 'Male', 'NY', 'A', 'Drivers License', 'NY',
   'FF-234-123-1231', '2016-12-25', '2018-12-25', '2016-06-09 18:07:30', '2016-06-21 19:58:44'),
  (4, 'id4', 'first_name4', NULL, 'last_name4', NULL, '1988-11-26', 'Female', 'NY', 'B', 'SSN Card', 'NY',
   'FF-234-123-1231', '2016-12-25', '2018-12-25', '2016-06-09 18:07:30', '2016-06-21 19:58:45'),
  (5, 'id4', 'first_name5', NULL, 'last_name5', NULL, '1988-04-21', 'Female', 'TX', 'B2', 'IDCard', 'TX',
   'FF-234-123-1232', '2015-05-06', '2018-06-06', '2016-06-10 14:38:32', '2016-06-21 19:58:55');

/*Table structure for table `lifemedid_transactions` */

DROP TABLE IF EXISTS `lifemedid_transactions`;

CREATE TABLE `lifemedid_transactions` (
  `id`             BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `transaction_id` VARCHAR(100) NOT NULL,
  `registar_id`    VARCHAR(100) NOT NULL,
  `organization_id` varchar(100) NOT NULL,
  `applicant_id`   VARCHAR(100) NOT NULL,
  `time_stamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `FK_transaction_id` (`transaction_id`),
  KEY `FK_applicants_id` (`applicant_id`),
  CONSTRAINT `FK_applicants_id` FOREIGN KEY (`applicant_id`) REFERENCES `applicants` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK_transaction_id` FOREIGN KEY (`transaction_id`) REFERENCES `transaction_docs` (`transaction_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 5
  DEFAULT CHARSET = latin1;

/*Data for the table `lifemedid_transactions` */

INSERT INTO `lifemedid_transactions` (`id`, `transaction_id`, `registar_id`, `organization_id`, `applicant_id`, `time_stamp`, `updated`)
VALUES (1, 'transaction_id10', 'person_id_1', 'org_id_1', 'id1', '2016-06-09 18:01:35', '2016-06-18 23:23:27'),
  (2, 'transaction_id11', 'person_id_2', 'org_id_2', 'id2', '2016-06-09 18:01:35', '2016-06-18 23:23:37'),
  (3, 'transaction_id12', 'person_id_3', 'org_id_3', 'id3', '2016-06-09 18:01:35', '2016-06-18 23:23:42'),
  (4, 'transaction_id13', 'person_id_4', 'org_id_4', 'id4', '2016-06-09 18:01:35', '2016-06-18 23:23:50');

/*Table structure for table `transaction_docs` */

DROP TABLE IF EXISTS `transaction_docs`;

CREATE TABLE `transaction_docs` (
  `transaction_id` VARCHAR(100) NOT NULL,
  `idpdoc_id`      BIGINT(20)   NOT NULL,
  PRIMARY KEY (`transaction_id`, `idpdoc_id`),
  KEY `FK_trans_idpdocs_id` (`idpdoc_id`),
  CONSTRAINT `FK_trans_idpdocs_id` FOREIGN KEY (`idpdoc_id`) REFERENCES `idpdocuments` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

/*Data for the table `transaction_docs` */

INSERT INTO `transaction_docs` (`transaction_id`, `idpdoc_id`)
VALUES ('transaction_id10', 1), ('transaction_id11', 2), ('transaction_id12', 3), ('transaction_id13', 4),
  ('transaction_id13', 5);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
