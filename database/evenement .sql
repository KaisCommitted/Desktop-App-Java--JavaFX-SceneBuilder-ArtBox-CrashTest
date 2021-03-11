-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 11, 2021 at 09:18 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 7.4.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
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
-- Table structure for table `evenement`
--

CREATE TABLE `evenement` (
  `id` int(255) NOT NULL,
  `id_org` int(255) NOT NULL,
  `date` date NOT NULL,
  `nom_event` varchar(255) NOT NULL,
  `type_event` varchar(255) NOT NULL,
  `categorie` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `capacite_event` int(11) NOT NULL,
  `nb_max` int(11) NOT NULL,
  `image_event` varchar(255) NOT NULL,
  `location_event` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `evenement`
--

INSERT INTO `evenement` (`id`, `id_org`, `date`, `nom_event`, `type_event`, `categorie`, `description`, `capacite_event`, `nb_max`, `image_event`, `location_event`) VALUES
(39, 1, '2021-03-10', 'Lets roll', 'Exposé', '1', 'whatever', 20, 20, 'C:/xampp/php/www/pidev/events/pink_mountains_by_minjuart_dedwq4d.png', 'Kelibia'),
(40, 1, '2021-03-11', 'yes', 'Exposé', 'yes', 'yes', 19, 20, 'C:/xampp/php/www/pidev/events/dreams_by_luetche_dec8f0s.png', 'dar chichou'),
(41, 1, '2021-03-11', 'wdym', 'Festival', 'Theatre', 'nono', 19, 20, 'C:/xampp/php/www/pidev/events/defafiv-b763cee0-e1c3-40b6-8a9e-8ff7606f8688.jpg', 'Dar jadti'),
(42, 1, '2021-03-09', 'firstimer', 'Exposé', 'Dancing', 'leggo', 20, 20, 'C:/xampp/php/www/pidev/events/Elite 128x128.png', 'dar jamila'),
(43, 1, '2021-08-10', 'Festival Jazz', 'Festival', 'Singing', 'Beth Hart is coming', 199, 200, 'C:/xampp/php/www/pidev/events/beth.jpg', 'Tabarka'),
(44, 1, '2021-03-01', 'WentTo', 'Exposé', 'Theatre', 'Trying wentTo', 19, 20, 'C:/xampp/php/www/pidev/events/attack_on_titans_anime_wallpaper__1920x1200__by_abdu1995_d61olzx.jpg', 'Kelibia'),
(45, 1, '2021-03-10', 'leggo', 'Formation', 'Dancing', 'nope', 10, 10, 'C:/xampp/php/www/pidev/events/andydoo (1).jpg', 'Dar chaab'),
(46, 1, '2021-03-11', 'yes', 'Exposé', 'Theatre', 'ss', 19, 20, 'C:/xampp/php/www/pidev/events/andydoo (15).jpg', '20'),
(47, 1, '2021-06-09', 'yes theory', 'Exposé', 'Slam', 'no theory', 21, 22, 'C:/xampp/php/www/pidev/events/textures_large_nkash_45.png', 'Gammarth'),
(48, 1, '2021-03-18', 'Lets Go', 'Formation', 'Theatre', '22', 21, 22, 'C:/xampp/php/www/pidev/events/andydoo (33).jpg', 'here'),
(49, 1, '2021-03-24', 'ArtHub', 'Festival', 'Slam', 'okok', 21, 22, 'C:/xampp/php/www/pidev/events/texturewintërowl12.png', 'Whatever'),
(50, 1, '2021-03-12', 'ArtBOxxx', 'Exposé', 'Dancing', 'ArtBox is a platform', 21, 22, 'C:/xampp/php/www/pidev/events/textures_large_nkash_44.png', 'ArtBox Inc.'),
(51, 1, '2021-03-11', 'Hello World!', 'Formation', 'Singing', 'Free drinks all the way!', 300, 300, 'C:/xampp/php/www/pidev/events/textures_large_nkash_50.png', 'here');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `evenement`
--
ALTER TABLE `evenement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_org` (`id_org`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `evenement`
--
ALTER TABLE `evenement`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `evenement`
--
ALTER TABLE `evenement`
  ADD CONSTRAINT `fk_org` FOREIGN KEY (`id_org`) REFERENCES `user` (`id_user`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
