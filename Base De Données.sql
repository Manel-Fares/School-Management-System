-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Feb 25, 2020 at 07:02 PM
-- Server version: 5.7.19
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pidev`
--

-- --------------------------------------------------------

--
-- Table structure for table `absence`
--

DROP TABLE IF EXISTS `absence`;
CREATE TABLE IF NOT EXISTS `absence` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `id_matiere` int(11) NOT NULL,
  `Date` date NOT NULL,
  `TimeDeb` time NOT NULL,
  `TimeFin` time NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_matier` (`id_matiere`),
  KEY `id_user` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `absence`
--

INSERT INTO `absence` (`id`, `id_user`, `id_matiere`, `Date`, `TimeDeb`, `TimeFin`) VALUES
(5, 131, 3, '2020-02-19', '02:49:00', '05:49:00');

-- --------------------------------------------------------

--
-- Table structure for table `calendarannuel`
--

DROP TABLE IF EXISTS `calendarannuel`;
CREATE TABLE IF NOT EXISTS `calendarannuel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subject` varchar(255) NOT NULL,
  `term` varchar(255) NOT NULL,
  `DateC` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `calendarannuel`
--

INSERT INTO `calendarannuel` (`id`, `subject`, `term`, `DateC`) VALUES
(19, 'ss', 'Exams', '2020-02-15'),
(17, 'wwwww', 'PI', '2020-01-31'),
(16, 'sqdsdqq', 'Exams', '2020-01-04'),
(15, 'qqqaaabbccc', 'PI', '2020-01-10'),
(14, 'qqss', 'Results', '2020-01-11'),
(2, 'bbbbb', 'ds', '2020-01-15'),
(1, 'aaa', 'holidays', '2020-02-12');

-- --------------------------------------------------------

--
-- Table structure for table `chapitre`
--

DROP TABLE IF EXISTS `chapitre`;
CREATE TABLE IF NOT EXISTS `chapitre` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `file` varchar(255) NOT NULL,
  `matier` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `matier` (`matier`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `classe`
--

DROP TABLE IF EXISTS `classe`;
CREATE TABLE IF NOT EXISTS `classe` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  `Niveau` varchar(255) NOT NULL,
  `Spec` varchar(255) NOT NULL,
  `Nbr_Etudiant` int(11) NOT NULL,
  `Description` varchar(255) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `classe`
--

INSERT INTO `classe` (`Id`, `Name`, `Niveau`, `Spec`, `Nbr_Etudiant`, `Description`) VALUES
(1, '4A2', '4', 'A', 20, '4 eme annee'),
(2, '2A2', '2', 'A', 20, '2eme annee'),
(7, '3A1', '4', 'A', 20, '4 eme'),
(12, '3B1', '3', 'B', 40, 'qsdqsd'),
(13, '3A5', '3', 'A', 30, 'qsdqsd'),
(14, '3B', '3', 'TWIN', 20, 'wxc'),
(15, 'as', '1', 'B', 54, 'tgrg'),
(17, '3A55', '3', 'A', 22, 'qsd');

-- --------------------------------------------------------

--
-- Table structure for table `classeenseignantmatiere`
--

DROP TABLE IF EXISTS `classeenseignantmatiere`;
CREATE TABLE IF NOT EXISTS `classeenseignantmatiere` (
  `id_class` int(255) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_matiere` int(11) NOT NULL,
  KEY `FK_classqqs` (`id_class`),
  KEY `FK_USER` (`id_user`),
  KEY `FK_Matiere` (`id_matiere`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `classeenseignantmatiere`
--

INSERT INTO `classeenseignantmatiere` (`id_class`, `id_user`, `id_matiere`) VALUES
(13, 188, 2),
(12, 18, 5),
(12, 18, 5);

-- --------------------------------------------------------

--
-- Table structure for table `club`
--

DROP TABLE IF EXISTS `club`;
CREATE TABLE IF NOT EXISTS `club` (
  `idClub` int(11) NOT NULL AUTO_INCREMENT,
  `nomClub` varchar(250) NOT NULL,
  `idResponsable` int(11) NOT NULL,
  `domaine` varchar(250) NOT NULL,
  PRIMARY KEY (`idClub`)
) ENGINE=MyISAM AUTO_INCREMENT=213 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `club`
--

INSERT INTO `club` (`idClub`, `nomClub`, `idResponsable`, `domaine`) VALUES
(1, 'EEE3', 131, 'info'),
(2, 'Esprit', 1, 'info'),
(3, 'enacts', 1, 'info'),
(212, 'ClubEsprit', 13, 'info');

-- --------------------------------------------------------

--
-- Table structure for table `demandecreationclub`
--

DROP TABLE IF EXISTS `demandecreationclub`;
CREATE TABLE IF NOT EXISTS `demandecreationclub` (
  `idDemandeClub` int(11) NOT NULL AUTO_INCREMENT,
  `IDEtudiant` int(11) NOT NULL,
  `nomClub` varchar(250) NOT NULL,
  `domaine` varchar(250) NOT NULL,
  `Description` text NOT NULL,
  PRIMARY KEY (`idDemandeClub`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `demandeevenement`
--

DROP TABLE IF EXISTS `demandeevenement`;
CREATE TABLE IF NOT EXISTS `demandeevenement` (
  `idDemandeEvenement` int(11) NOT NULL AUTO_INCREMENT,
  `Description` text NOT NULL,
  `DateDebut` date NOT NULL,
  `DateFin` date NOT NULL,
  `Etat` varchar(250) NOT NULL,
  `idClub` int(11) NOT NULL,
  `Budget` float NOT NULL,
  `image` varchar(250) NOT NULL,
  PRIMARY KEY (`idDemandeEvenement`)
) ENGINE=MyISAM AUTO_INCREMENT=54 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `demandeevenement`
--

INSERT INTO `demandeevenement` (`idDemandeEvenement`, `Description`, `DateDebut`, `DateFin`, `Etat`, `idClub`, `Budget`, `image`) VALUES
(39, 'yyyyyyyyyyyyyyyyy', '2020-02-18', '2020-02-26', 'valider', 10, 100000000000, 'C:\\Users\\asus\\Desktop\\img\\1.jpg'),
(40, 'bbbbbbbbb', '2020-02-18', '2020-02-26', 'valider', 10, 15000, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event2.jpg'),
(46, '2', '2020-02-19', '2020-02-19', 'valider', 68, 2, ''),
(50, 'descroption', '2020-02-10', '2020-02-19', 'Non valider', 0, 10202, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event1.webp'),
(45, 'aaa', '2020-02-19', '2020-02-19', 'Non valider', 0, 1, ''),
(51, 'aaaaaaaaaa', '2020-02-18', '2020-02-25', 'Non valider', 0, 12121200, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event1.webp');

-- --------------------------------------------------------

--
-- Table structure for table `emplois`
--

DROP TABLE IF EXISTS `emplois`;
CREATE TABLE IF NOT EXISTS `emplois` (
  `IdEmplois` int(11) NOT NULL AUTO_INCREMENT,
  `Date` date NOT NULL,
  `Heure` time NOT NULL,
  `Source` varchar(255) NOT NULL,
  PRIMARY KEY (`IdEmplois`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `emplois`
--

INSERT INTO `emplois` (`IdEmplois`, `Date`, `Heure`, `Source`) VALUES
(4, '2020-02-06', '14:36:00', 'Calcul.txt'),
(6, '2020-02-05', '15:42:00', 'Map.pdf'),
(7, '2020-02-06', '10:47:00', 'wwww.pdf');

-- --------------------------------------------------------

--
-- Table structure for table `enseigner`
--

DROP TABLE IF EXISTS `enseigner`;
CREATE TABLE IF NOT EXISTS `enseigner` (
  `idEnseignant` int(11) NOT NULL,
  `idMatiere` int(11) NOT NULL,
  PRIMARY KEY (`idEnseignant`,`idMatiere`),
  KEY `AAAAAAAAAAAA` (`idMatiere`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `enseigner`
--

INSERT INTO `enseigner` (`idEnseignant`, `idMatiere`) VALUES
(188, 2),
(185, 3),
(18, 4),
(18, 5),
(186, 7);

-- --------------------------------------------------------

--
-- Table structure for table `evenement`
--

DROP TABLE IF EXISTS `evenement`;
CREATE TABLE IF NOT EXISTS `evenement` (
  `idEvenement` int(11) NOT NULL AUTO_INCREMENT,
  `dateDebut` date NOT NULL,
  `dateFin` date NOT NULL,
  `idClub` int(11) NOT NULL,
  `image` text NOT NULL,
  PRIMARY KEY (`idEvenement`)
) ENGINE=MyISAM AUTO_INCREMENT=3506 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `evenement`
--

INSERT INTO `evenement` (`idEvenement`, `dateDebut`, `dateFin`, `idClub`, `image`) VALUES
(3437, '2020-02-19', '2020-02-11', 10, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event2.jpg'),
(3344, '2020-02-01', '2020-02-02', 11, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event2.jpg'),
(3346, '2020-02-27', '2020-02-26', 1, 'C:\\Users\\asus\\Desktop\\img\\2.jpg'),
(3348, '2020-02-26', '2020-02-26', 1, 'C:\\Users\\asus\\Desktop\\img\\2.jpg'),
(3432, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event2.jpg'),
(3436, '2020-02-26', '2020-02-26', 0, 'Path'),
(3353, '2020-02-26', '2020-02-26', 68, 'C:\\Users\\asus\\Desktop\\img\\2.jpg'),
(3354, '2020-02-26', '2020-02-26', 68, 'C:\\Users\\asus\\Desktop\\img\\2.jpg'),
(3355, '2020-02-26', '2020-02-26', 68, 'C:\\Users\\asus\\Desktop\\img\\2.jpg'),
(3357, '2020-02-26', '2020-02-26', 0, 'C:\\Users\\asus\\Desktop\\img\\2.jpg'),
(3431, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Desktop\\img\\1.jpg'),
(3430, '2020-02-03', '2020-02-17', 1, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event1.webp'),
(3368, '2020-02-12', '2020-02-26', 1333, 'C:\\Users\\asus\\Desktop\\img\\2.jpg'),
(3369, '2020-02-10', '2020-02-26', 68, 'C:\\Users\\asus\\Desktop\\img\\2.jpg'),
(3429, '2020-02-19', '2020-02-11', 10, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event2.jpg'),
(3425, '2020-02-19', '2020-02-11', 10, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event2.jpg'),
(3386, '2020-02-03', '2020-02-17', 1, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event1.webp'),
(3387, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Desktop\\img\\1.jpg'),
(3388, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event2.jpg'),
(3389, '2020-02-03', '2020-02-17', 1, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event1.webp'),
(3390, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Desktop\\img\\1.jpg'),
(3391, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event2.jpg'),
(3392, '2020-02-03', '2020-02-17', 1, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event1.webp'),
(3393, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Desktop\\img\\1.jpg'),
(3394, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event2.jpg'),
(3395, '2020-02-03', '2020-02-17', 1, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event1.webp'),
(3396, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Desktop\\img\\1.jpg'),
(3397, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event2.jpg'),
(3398, '2020-02-03', '2020-02-17', 1, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event1.webp'),
(3399, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Desktop\\img\\1.jpg'),
(3400, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event2.jpg'),
(3401, '2020-02-03', '2020-02-17', 1, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event1.webp'),
(3402, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Desktop\\img\\1.jpg'),
(3403, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event2.jpg'),
(3404, '2020-02-03', '2020-02-17', 1, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event1.webp'),
(3405, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Desktop\\img\\1.jpg'),
(3406, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event2.jpg'),
(3407, '2020-02-03', '2020-02-17', 1, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event1.webp'),
(3408, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Desktop\\img\\1.jpg'),
(3409, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event2.jpg'),
(3410, '2020-02-03', '2020-02-17', 1, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event1.webp'),
(3411, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Desktop\\img\\1.jpg'),
(3412, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event2.jpg'),
(3413, '2020-02-03', '2020-02-17', 1, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event1.webp'),
(3414, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Desktop\\img\\1.jpg'),
(3415, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event2.jpg'),
(3416, '2020-02-03', '2020-02-17', 1, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event1.webp'),
(3417, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Desktop\\img\\1.jpg'),
(3418, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event2.jpg'),
(3419, '2020-02-03', '2020-02-17', 1, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event1.webp'),
(3420, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Desktop\\img\\1.jpg'),
(3421, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event2.jpg'),
(3422, '2020-02-03', '2020-02-17', 1, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event1.webp'),
(3423, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Desktop\\img\\1.jpg'),
(3424, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event2.jpg'),
(3426, '2020-02-03', '2020-02-17', 1, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event1.webp'),
(3427, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Desktop\\img\\1.jpg'),
(3428, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event2.jpg'),
(3433, '2020-02-19', '2020-02-19', 68, ''),
(3435, '2020-02-26', '2020-02-26', 0, 'Path'),
(3438, '2020-02-03', '2020-02-17', 1, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event1.webp'),
(3439, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Desktop\\img\\1.jpg'),
(3440, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event2.jpg'),
(3441, '2020-02-19', '2020-02-19', 68, ''),
(3442, '2020-02-19', '2020-02-19', 0, ''),
(3443, '2020-02-19', '2020-02-11', 10, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event2.jpg'),
(3444, '2020-02-03', '2020-02-17', 1, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event1.webp'),
(3445, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Desktop\\img\\1.jpg'),
(3446, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event2.jpg'),
(3447, '2020-02-19', '2020-02-19', 68, ''),
(3448, '2020-02-19', '2020-02-19', 0, ''),
(3449, '2020-02-19', '2020-02-11', 10, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event2.jpg'),
(3450, '2020-02-03', '2020-02-17', 1, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event1.webp'),
(3451, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Desktop\\img\\1.jpg'),
(3452, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event2.jpg'),
(3453, '2020-02-19', '2020-02-19', 68, ''),
(3454, '2020-02-19', '2020-02-19', 0, ''),
(3455, '2020-02-19', '2020-02-11', 10, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event2.jpg'),
(3456, '2020-02-03', '2020-02-17', 1, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event1.webp'),
(3457, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Desktop\\img\\1.jpg'),
(3458, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event2.jpg'),
(3459, '2020-02-19', '2020-02-19', 68, ''),
(3460, '2020-02-19', '2020-02-19', 0, ''),
(3461, '2020-02-19', '2020-02-11', 10, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event2.jpg'),
(3462, '2020-02-03', '2020-02-17', 1, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event1.webp'),
(3463, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Desktop\\img\\1.jpg'),
(3464, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event2.jpg'),
(3465, '2020-02-19', '2020-02-19', 68, ''),
(3466, '2020-02-19', '2020-02-19', 0, ''),
(3467, '2020-02-17', '2020-02-21', 10, 'C:\\Users\\asus\\Desktop\\img\\1.jpg'),
(3468, '2020-02-19', '2020-02-11', 10, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event2.jpg'),
(3469, '2020-02-03', '2020-02-17', 1, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event1.webp'),
(3470, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Desktop\\img\\1.jpg'),
(3471, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event2.jpg'),
(3472, '2020-02-19', '2020-02-19', 68, ''),
(3473, '2020-02-19', '2020-02-19', 0, ''),
(3474, '2020-02-19', '2020-02-03', 10, 'C:\\Users\\asus\\Desktop\\img\\1.jpg'),
(3475, '2020-02-19', '2020-02-11', 10, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event2.jpg'),
(3476, '2020-02-03', '2020-02-17', 1, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event1.webp'),
(3477, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Desktop\\img\\1.jpg'),
(3478, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event2.jpg'),
(3479, '2020-02-19', '2020-02-19', 68, ''),
(3480, '2020-02-10', '2020-02-19', 0, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event1.webp'),
(3481, '2020-02-19', '2020-02-19', 0, ''),
(3482, '2020-02-18', '2020-02-25', 0, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event1.webp'),
(3483, '2020-02-03', '2020-02-17', 1, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event1.webp'),
(3484, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Desktop\\img\\1.jpg'),
(3485, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event2.jpg'),
(3486, '2020-02-19', '2020-02-19', 68, ''),
(3487, '2020-02-10', '2020-02-19', 0, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event1.webp'),
(3488, '2020-02-19', '2020-02-19', 0, ''),
(3489, '2020-02-18', '2020-02-25', 0, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event1.webp'),
(3490, '2020-02-13', '2020-02-21', 0, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Weboss\\src\\weboss\\Image\\teachearss.png'),
(3491, '2020-02-29', '2020-02-03', 0, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Weboss\\src\\weboss\\Image\\teachearss.png'),
(3492, '2020-02-03', '2020-02-04', 1, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event1.webp'),
(3493, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Desktop\\img\\1.jpg'),
(3494, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event2.jpg'),
(3495, '2020-02-19', '2020-02-19', 68, ''),
(3496, '2020-02-10', '2020-02-19', 0, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event1.webp'),
(3497, '2020-02-19', '2020-02-19', 0, ''),
(3498, '2020-02-18', '2020-02-25', 0, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event1.webp'),
(3499, '2000-02-17', '2018-11-08', 1, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event2.jpg'),
(3500, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Desktop\\img\\1.jpg'),
(3501, '2020-02-18', '2020-02-26', 10, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event2.jpg'),
(3502, '2020-02-19', '2020-02-19', 68, ''),
(3503, '2020-02-10', '2020-02-19', 0, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event1.webp'),
(3504, '2020-02-19', '2020-02-19', 0, ''),
(3505, '2020-02-18', '2020-02-25', 0, 'C:\\Users\\asus\\Documents\\NetBeansProjects\\Pidev\\src\\pidev\\img\\event1.webp');

-- --------------------------------------------------------

--
-- Table structure for table `matier`
--

DROP TABLE IF EXISTS `matier`;
CREATE TABLE IF NOT EXISTS `matier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `coef` float NOT NULL,
  `responsable` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `responsable` (`responsable`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `matier`
--

INSERT INTO `matier` (`id`, `nom`, `coef`, `responsable`) VALUES
(1, 'Unix', 3, 1),
(2, 'Finance', 1.5, 1),
(3, 'Algebre', 2, 3),
(4, 'prog c++', 2, 3),
(5, 'POO Java', 3, 3),
(6, 'TLA', 4, 6),
(7, 'droit', 1, 5),
(8, 'francais', 1, 7);

-- --------------------------------------------------------

--
-- Table structure for table `note`
--

DROP TABLE IF EXISTS `note`;
CREATE TABLE IF NOT EXISTS `note` (
  `idEtudiant` int(11) NOT NULL,
  `idMatiere` varchar(50) NOT NULL,
  `idEnseignant` int(11) DEFAULT NULL,
  `dateNote` date NOT NULL,
  `noteCC` double DEFAULT NULL,
  `noteDS` double DEFAULT NULL,
  `noteExam` double DEFAULT NULL,
  `Moyenne` double DEFAULT NULL,
  PRIMARY KEY (`idMatiere`,`idEtudiant`,`dateNote`),
  KEY `idEnseignant` (`idEnseignant`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `note`
--

INSERT INTO `note` (`idEtudiant`, `idMatiere`, `idEnseignant`, `dateNote`, `noteCC`, `noteDS`, `noteExam`, `Moyenne`) VALUES
(15, '3', 19, '2020-02-07', 20, 10.5, 15.5, 15.85),
(18, '4', 18, '2020-02-13', 9, 7.25, 10, 9.15),
(15, '2', 18, '2020-01-29', 10.25, 10.5, 2.25, 6.3),
(25, '3', 19, '2020-02-14', 16.75, 12, 11.5, 13.175),
(1, '4', 18, '2020-02-12', 11.5, 16, 7, 10.15),
(16, '3', 19, '2020-02-05', 3.75, 9.25, 8.5, 7.225),
(15, '6', 18, '2020-01-30', 17.5, 11.75, 9.5, 12.35),
(15, '5', 18, '2020-02-06', 6.75, 10.75, 2.25, 5.3),
(1, '3', 18, '2020-02-13', 12, 1, 15, 11.3),
(25, '5', 19, '2020-02-05', 2.75, 3, 3, 2.925),
(2, '8', 19, '2020-02-19', 9, 9, 9, 9),
(4, '7', 19, '2020-01-14', 8.5, 5.2, 19, 13.09);

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
CREATE TABLE IF NOT EXISTS `question` (
  `id_question` int(11) NOT NULL AUTO_INCREMENT,
  `body` varchar(100) NOT NULL,
  `vote_question` int(11) DEFAULT NULL,
  `id_tag` int(11) DEFAULT NULL,
  `id_personne` int(11) DEFAULT NULL,
  `title` varchar(200) NOT NULL,
  `tag_name` varchar(200) NOT NULL,
  PRIMARY KEY (`id_question`),
  KEY `id_personne` (`id_personne`),
  KEY `id_tag` (`id_tag`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`id_question`, `body`, `vote_question`, `id_tag`, `id_personne`, `title`, `tag_name`) VALUES
(1, 'null pointer', 1, 1, 137, 'java exception', 'java');

-- --------------------------------------------------------

--
-- Table structure for table `questionquizz`
--

DROP TABLE IF EXISTS `questionquizz`;
CREATE TABLE IF NOT EXISTS `questionquizz` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(255) NOT NULL,
  `rep1` varchar(255) NOT NULL,
  `rep2` varchar(255) NOT NULL,
  `rep3` varchar(255) NOT NULL,
  `rep` varchar(255) NOT NULL,
  `quiz` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `quiz` (`quiz`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `quizz`
--

DROP TABLE IF EXISTS `quizz`;
CREATE TABLE IF NOT EXISTS `quizz` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `chapitre` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `chapitre` (`chapitre`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `rating`
--

DROP TABLE IF EXISTS `rating`;
CREATE TABLE IF NOT EXISTS `rating` (
  `idrating` int(11) NOT NULL AUTO_INCREMENT,
  `iduser` int(11) NOT NULL,
  `idClub` int(11) NOT NULL,
  `rating` double NOT NULL,
  PRIMARY KEY (`idrating`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rating`
--

INSERT INTO `rating` (`idrating`, `iduser`, `idClub`, `rating`) VALUES
(1, 131, 212, 5),
(2, 131, 2, 5),
(3, 131, 1, 5),
(4, 131, 3, 5);

-- --------------------------------------------------------

--
-- Table structure for table `reclamation`
--

DROP TABLE IF EXISTS `reclamation`;
CREATE TABLE IF NOT EXISTS `reclamation` (
  `idReclamation` int(11) NOT NULL AUTO_INCREMENT,
  `sujetReclamation` varchar(255) NOT NULL,
  `descriptionReclamation` varchar(255) NOT NULL,
  `statutReclamation` varchar(11) NOT NULL DEFAULT 'Non Traité',
  `dateCreation` date NOT NULL,
  `IdEtd` int(11) DEFAULT NULL,
  PRIMARY KEY (`idReclamation`),
  KEY `FK_reclamation` (`IdEtd`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reclamation`
--

INSERT INTO `reclamation` (`idReclamation`, `sujetReclamation`, `descriptionReclamation`, `statutReclamation`, `dateCreation`, `IdEtd`) VALUES
(13, 'sdf', 'sdf', 'Non Traité', '1918-07-05', 125),
(4, '', 'note', 'Non Traité', '3921-01-12', 121),
(16, 'qsdf', 'qsdqd', 'Non Traité', '2020-02-18', 106),
(15, 'sf', 'sdfsdfsdf', 'Non Traité', '3921-01-12', 106),
(17, 'note', 'qdfqsf', 'Non Traité', '2020-02-18', 117);

-- --------------------------------------------------------

--
-- Table structure for table `reponse`
--

DROP TABLE IF EXISTS `reponse`;
CREATE TABLE IF NOT EXISTS `reponse` (
  `id_reponse` int(11) NOT NULL AUTO_INCREMENT,
  `body` varchar(100) NOT NULL,
  `vote_reponse` int(11) DEFAULT NULL,
  `id_question` int(11) NOT NULL,
  PRIMARY KEY (`id_reponse`),
  KEY `id_question` (`id_question`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reponse`
--

INSERT INTO `reponse` (`id_reponse`, `body`, `vote_reponse`, `id_question`) VALUES
(1, 'import packages', 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `resultat`
--

DROP TABLE IF EXISTS `resultat`;
CREATE TABLE IF NOT EXISTS `resultat` (
  `idEtudiant` int(11) NOT NULL,
  `dateResultat` date NOT NULL,
  `resultat` float DEFAULT NULL,
  PRIMARY KEY (`idEtudiant`,`dateResultat`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `resultat`
--

INSERT INTO `resultat` (`idEtudiant`, `dateResultat`, `resultat`) VALUES
(2, '2020-02-25', 9),
(4, '2020-02-25', 13.09),
(18, '2020-02-25', 9.15),
(25, '2020-02-25', 7.025),
(16, '2020-02-25', 7.225),
(1, '2020-02-25', 10.725),
(15, '2020-02-25', 12.1095);

-- --------------------------------------------------------

--
-- Table structure for table `sondage`
--

DROP TABLE IF EXISTS `sondage`;
CREATE TABLE IF NOT EXISTS `sondage` (
  `id_sondage` int(11) NOT NULL AUTO_INCREMENT,
  `id_club` int(11) NOT NULL,
  `titre` varchar(250) NOT NULL,
  `description` text NOT NULL,
  `reponse` text NOT NULL,
  PRIMARY KEY (`id_sondage`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sondage`
--

INSERT INTO `sondage` (`id_sondage`, `id_club`, `titre`, `description`, `reponse`) VALUES
(1, 455, 'lll', 'dfghjk', 'Null');

-- --------------------------------------------------------

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
CREATE TABLE IF NOT EXISTS `tag` (
  `id_tag` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_tag`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tag`
--

INSERT INTO `tag` (`id_tag`, `nom`, `description`) VALUES
(1, 'java', 'java'),
(2, 'mobile', 'mobile'),
(3, 'mni', 'mni'),
(4, 'probabilite', 'probabilite'),
(5, 'finance', 'finance'),
(6, 'C', 'C');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `cinUser` int(11) NOT NULL,
  `nomUser` varchar(50) DEFAULT NULL,
  `prenomUser` varchar(50) DEFAULT NULL,
  `DateNaissanceUser` date DEFAULT NULL,
  `sexeUser` varchar(10) DEFAULT NULL,
  `emailUser` varchar(100) DEFAULT NULL,
  `adresseUser` varchar(50) DEFAULT NULL,
  `numTelUser` int(8) DEFAULT NULL,
  `roleUser` varchar(50) DEFAULT NULL,
  `dateEmbaucheUser` date DEFAULT NULL,
  `motDePasseUser` varchar(100) DEFAULT NULL,
  `classeEtd` varchar(100) DEFAULT NULL,
  `inscriptionEtd` date DEFAULT NULL,
  `nomResponsableEtd` varchar(100) DEFAULT NULL,
  `specialiteEtd` varchar(100) DEFAULT NULL,
  `statutUser` varchar(50) DEFAULT NULL,
  `salaireUser` double DEFAULT NULL,
  `domaineUser` varchar(100) DEFAULT NULL,
  `idParent` varchar(30) DEFAULT NULL,
  `picUser` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idUser`),
  UNIQUE KEY `cinUser` (`cinUser`),
  KEY `idParent` (`idParent`),
  KEY `sqdsssss` (`classeEtd`)
) ENGINE=InnoDB AUTO_INCREMENT=189 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`idUser`, `cinUser`, `nomUser`, `prenomUser`, `DateNaissanceUser`, `sexeUser`, `emailUser`, `adresseUser`, `numTelUser`, `roleUser`, `dateEmbaucheUser`, `motDePasseUser`, `classeEtd`, `inscriptionEtd`, `nomResponsableEtd`, `specialiteEtd`, `statutUser`, `salaireUser`, `domaineUser`, `idParent`, `picUser`) VALUES
(15, 1113670, 'Yosr', 'Jerby', '1998-11-05', 'F', 'yosra@gmail.com', '7ay khadhra', 2014587, 'Etudiant', NULL, 'yosra', '3B1', NULL, NULL, 'Info', 'Entravail', NULL, NULL, NULL, NULL),
(18, 10004578, 'mohsen', 'hssino', '2020-02-12', 'Homme', 'mohsen@gmail.com', NULL, NULL, 'Enseignant', NULL, 'aa', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '', NULL),
(131, 147885, 'sofien', 'Jmai', NULL, NULL, 'omar.jmai@esprit.tn', 'null', 0, 'Etudiant', NULL, '123456', '3A5', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(137, 1485, 'Etudiant', 'Esprit', NULL, NULL, 'Etudiant@gmail.com', NULL, NULL, 'Etudiant', NULL, '1234', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(139, 13235258, NULL, NULL, NULL, NULL, 'root', NULL, NULL, 'root', NULL, '0000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(140, 456456, 'sdfgsd', '', '2020-02-24', '', '', 'sdf', 456, 'Parent', NULL, '456456', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(142, 44, 'wsdqs', '', '2020-02-24', '', '', 'sdfsdf', 44444, 'Parent', NULL, '45645', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(144, 789789, 'qsd', '', '2020-02-24', '', '', 'dsf', 56456, 'Parent', NULL, '5645', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(146, 4564, 'sdfsdf', '', '2020-02-24', '', '', 'vdffg', 888, 'Parent', NULL, '9999', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(149, 78, 'sdf', '', '2020-02-24', '', '', 'qsd', 454, 'Parent', NULL, '456', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(151, 458, 'sd', '', '2020-02-24', '', '', 'qsd', 4669, 'Parent', NULL, '44', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(153, 454, 'cfg', '', '2020-02-24', '', '', 'sdf', 45, 'Parent', NULL, '213', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(157, 777, 'aaaa', 'zzzz', '2020-02-24', 'femme', 'zzz', 'ssd', 154, 'Personnel', '2020-02-24', '777', NULL, NULL, NULL, NULL, 'En cours', 1.11, 'Service Scolarite', NULL, NULL),
(158, 99564, 'sdgf', '', '2020-02-24', '', '', 'sdf', 888, 'Parent', NULL, '444', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(160, 358, 'dfg', '', '2020-02-24', '', '', 'sdgf', 2325, 'Parent', NULL, '1010', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(162, 2301, 'sdf', '', '2020-02-24', '', '', 'sdfs', 8889, 'Parent', NULL, '112222', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(164, 2310, 'qsdf', '', '2020-02-24', '', '', 'sdf', 8564, 'Parent', NULL, '4562', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(166, 8854, 'wdf', '', '2020-02-24', '', '', 'dsf', 456, 'Parent', NULL, '4561', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(168, 966, 'qsd', '', '2020-02-24', '', '', 'sdf', 85, 'Parent', NULL, '110', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(170, 95, 'qsd', '', '2020-02-24', '', '', 'dfg', 45, 'Parent', NULL, '1112', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(172, 5245, 'fsdf', '', '2020-02-24', '', '', 'fsdfsd', 968, 'Parent', NULL, '747', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(173, 747, 'dsgf', 'sdfg', '2020-02-01', 'Homme', 'sdfsd', 'fsdfsd', 7856, 'Etudiant', NULL, '747', '3A5', '2020-02-24', NULL, 'Info', NULL, NULL, NULL, '', NULL),
(174, 44428782, 'gfyhf', '', '2020-02-24', '', '', 'sdf', 45453, 'Parent', NULL, '4442124', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(175, 4442124, 'gg', 'gg', '2020-02-06', 'Homme', 'sdf', 'sdf', 5421, 'Etudiant', NULL, '4442124', NULL, '2020-02-24', NULL, 'Info', NULL, NULL, NULL, '', NULL),
(176, 8965, 'azaz', '', '2020-02-24', '', '', 'rtghyu', 1447, 'Parent', NULL, '1010', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(185, 4556, 'fdf', 'sbvb', '2020-02-24', 'femme', 'qsd', 'zeef', 786, 'Enseignant', '2020-02-24', '4556', NULL, NULL, NULL, NULL, 'En cours', 145.33, 'Math', NULL, 'hamzatahan'),
(186, 102486, 'ahmed', 'ben ali', '2020-02-24', 'Femme', 'argo', 'fffd', 4586, 'Enseignant', '2020-02-24', '102486', NULL, NULL, NULL, NULL, 'En cours', 1452.3, 'Math', NULL, 'C:\\Users\\Neifos\\Desktop\\student_PNG62542.png'),
(188, 1045, 'hama', 'derbali', '2020-02-24', 'Homme', 'aaa', 'sdf', 896, 'Enseignant', '2020-02-24', '1045', NULL, NULL, NULL, NULL, 'Conge', 1001.2, 'Math', NULL, 'formateursst.png');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `absence`
--
ALTER TABLE `absence`
  ADD CONSTRAINT `id_matierss` FOREIGN KEY (`id_matiere`) REFERENCES `matier` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `id_userss` FOREIGN KEY (`id_user`) REFERENCES `users` (`idUser`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `classeenseignantmatiere`
--
ALTER TABLE `classeenseignantmatiere`
  ADD CONSTRAINT `CXCCCCCCCCCCCC` FOREIGN KEY (`id_matiere`) REFERENCES `enseigner` (`idMatiere`),
  ADD CONSTRAINT `FNBVCBV` FOREIGN KEY (`id_class`) REFERENCES `classe` (`Id`),
  ADD CONSTRAINT `sfdsqdqsdqsdXWXW` FOREIGN KEY (`id_user`) REFERENCES `enseigner` (`idEnseignant`);

--
-- Constraints for table `enseigner`
--
ALTER TABLE `enseigner`
  ADD CONSTRAINT `AAAAAAAAAAAA` FOREIGN KEY (`idMatiere`) REFERENCES `matier` (`id`),
  ADD CONSTRAINT `QQQQQQQQQQQQQQQQQQ` FOREIGN KEY (`idEnseignant`) REFERENCES `users` (`idUser`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `sqdsssss` FOREIGN KEY (`classeEtd`) REFERENCES `classe` (`Name`) ON DELETE SET NULL ON UPDATE SET NULL;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
