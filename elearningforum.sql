# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.5.5-10.1.19-MariaDB)
# Database: elearningforum
# Generation Time: 2017-02-07 00:00:36 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table KOMENTAR
# ------------------------------------------------------------

DROP TABLE IF EXISTS `KOMENTAR`;

CREATE TABLE `KOMENTAR` (
  `KOMENTAR_ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `SADRZAJ` varchar(255) NOT NULL DEFAULT '',
  `DATUM_KREIRANJA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `MATERIJAL_ID` int(11) NOT NULL,
  `KORISNIK_ID` int(11) NOT NULL,
  PRIMARY KEY (`KOMENTAR_ID`),
  KEY `KOMENTAR-MATERIJAL` (`MATERIJAL_ID`),
  KEY `KOMENTAR-KORISNIK` (`KORISNIK_ID`),
  CONSTRAINT `KOMENTAR-KORISNIK` FOREIGN KEY (`KORISNIK_ID`) REFERENCES `KORISNIK` (`KORISNIK_ID`) ON UPDATE NO ACTION,
  CONSTRAINT `KOMENTAR-MATERIJAL` FOREIGN KEY (`MATERIJAL_ID`) REFERENCES `MATERIJAL` (`MATERIJAL_ID`) ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table KORISNIK
# ------------------------------------------------------------

DROP TABLE IF EXISTS `KORISNIK`;

CREATE TABLE `KORISNIK` (
  `KORISNIK_ID` int(11) NOT NULL AUTO_INCREMENT,
  `KORISNICKO_IME` varchar(50) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL DEFAULT '',
  `LOZINKA` varchar(50) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL DEFAULT '',
  `ADRESA` varchar(255) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `BROJ_TELEFONA` varchar(20) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `DATUM_KREIRANJA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`KORISNIK_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;



# Dump of table MATERIJAL
# ------------------------------------------------------------

DROP TABLE IF EXISTS `MATERIJAL`;

CREATE TABLE `MATERIJAL` (
  `MATERIJAL_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAZIV_MATERIJALA` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  `OPIS_MATERIJALA` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `LINK` varchar(255) COLLATE utf8_bin DEFAULT '',
  `VIDEO` longblob,
  `AUDIO` longblob,
  `DATUM_KREIRANJA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `BROJ_PREPORUKA_POZITIVNO` int(11) DEFAULT NULL,
  `BROJ_PREPORUKA_NEGATIVNO` int(11) DEFAULT NULL,
  `MATERIJAL_FLAG` int(11) NOT NULL DEFAULT '0',
  `TEMA_ID` int(11) NOT NULL,
  `KORISNIK_ID` int(11) NOT NULL,
  PRIMARY KEY (`MATERIJAL_ID`),
  KEY `TEMA-MATERIJAL` (`TEMA_ID`),
  KEY `MATERIJAL-KORISNIK` (`KORISNIK_ID`),
  CONSTRAINT `MATERIJAL-KORISNIK` FOREIGN KEY (`KORISNIK_ID`) REFERENCES `KORISNIK` (`KORISNIK_ID`) ON UPDATE NO ACTION,
  CONSTRAINT `TEMA-MATERIJAL` FOREIGN KEY (`TEMA_ID`) REFERENCES `TEMA` (`TEMA_ID`) ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;



# Dump of table PREDMET
# ------------------------------------------------------------

DROP TABLE IF EXISTS `PREDMET`;

CREATE TABLE `PREDMET` (
  `PREDMET_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAZIV_PREDMETA` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  `OPIS_PREDMETA` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `SKOLSKA_GODINA` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  `DATUM_KREIRANJA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`PREDMET_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;



# Dump of table PREDMET_KORISNIKA
# ------------------------------------------------------------

DROP TABLE IF EXISTS `PREDMET_KORISNIKA`;

CREATE TABLE `PREDMET_KORISNIKA` (
  `PREDMET_KORISNIKA_ID` int(10) NOT NULL AUTO_INCREMENT,
  `KORISNIK_ID` int(11) NOT NULL,
  `PREDMET_ID` int(11) NOT NULL,
  `DATUM_KREIRANJA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`PREDMET_KORISNIKA_ID`),
  KEY `PREDMET` (`PREDMET_ID`),
  KEY `PREDMET-KORISNIK` (`KORISNIK_ID`),
  CONSTRAINT `PREDMET` FOREIGN KEY (`PREDMET_ID`) REFERENCES `PREDMET` (`PREDMET_ID`) ON UPDATE NO ACTION,
  CONSTRAINT `PREDMET-KORISNIK` FOREIGN KEY (`KORISNIK_ID`) REFERENCES `KORISNIK` (`KORISNIK_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;



# Dump of table ROLA
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ROLA`;

CREATE TABLE `ROLA` (
  `ROLA_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAZIV_ROLE` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '',
  `KORISNIK_ID` int(11) NOT NULL,
  `DATUM_KREIRANJA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ROLA_ID`),
  KEY `ROLA-KORISNIK` (`KORISNIK_ID`),
  CONSTRAINT `ROLA-KORISNIK` FOREIGN KEY (`KORISNIK_ID`) REFERENCES `KORISNIK` (`KORISNIK_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;



# Dump of table TEMA
# ------------------------------------------------------------

DROP TABLE IF EXISTS `TEMA`;

CREATE TABLE `TEMA` (
  `TEMA_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAZIV_TEME` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  `OPIS_TEME` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DATUM_KREIRANJA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `PREDMET_ID` int(11) NOT NULL,
  PRIMARY KEY (`TEMA_ID`),
  KEY `PREDMET-TEMA` (`PREDMET_ID`),
  CONSTRAINT `PREDMET-TEMA` FOREIGN KEY (`PREDMET_ID`) REFERENCES `PREDMET` (`PREDMET_ID`) ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
