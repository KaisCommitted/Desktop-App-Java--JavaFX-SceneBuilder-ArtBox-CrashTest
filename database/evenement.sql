-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 26, 2021 at 07:43 PM
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
-- Database: `artbox`
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
  `nb_max` int(11) NOT NULL DEFAULT 0,
  `image_event` varchar(255) NOT NULL,
  `location_event` varchar(255) DEFAULT NULL,
  `rating_event` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `evenement`
--

INSERT INTO `evenement` (`id`, `id_org`, `date`, `nom_event`, `type_event`, `categorie`, `description`, `capacite_event`, `nb_max`, `image_event`, `location_event`, `rating_event`) VALUES
(39, 1, '2020-03-10', 'Lets roll', 'Exposé', 'Theatre', 'whatever', 15, 20, 'C:/xampp/php/www/pidev/events/pink_mountains_by_minjuart_dedwq4d.png', 'Kelibia', 0),
(40, 1, '2022-04-11', 'yes', 'Exposé', 'Slam', 'yes', 18, 20, 'C:/xampp/php/www/pidev/events/dreams_by_luetche_dec8f0s.png', 'dar chichou', 0),
(41, 1, '2020-03-11', 'wdym', 'Festival', 'Theatre', 'nono', 15, 20, 'C:/xampp/php/www/pidev/events/defafiv-b763cee0-e1c3-40b6-8a9e-8ff7606f8688.jpg', 'Dar jadti', 4),
(43, 1, '2020-08-10', 'Festival Jazz', 'Festival', 'Singing', 'Beth Hart is coming', 197, 200, 'C:/xampp/php/www/pidev/events/beth.jpg', 'Tabarka', 4),
(44, 1, '2020-03-01', 'WentTo', 'Exposé', 'Theatre', 'Trying wentTo', 15, 20, 'C:/xampp/php/www/pidev/events/attack_on_titans_anime_wallpaper__1920x1200__by_abdu1995_d61olzx.jpg', 'Kelibia', 0),
(45, 1, '2020-03-10', 'leggo', 'Formation', 'Dancing', 'nope', 5, 10, 'C:/xampp/php/www/pidev/events/andydoo (1).jpg', 'Dar chaab', 0),
(46, 1, '2020-03-11', 'yes', 'Exposé', 'Theatre', 'ss', 15, 20, 'C:/xampp/php/www/pidev/events/andydoo (15).jpg', '20', 0),
(47, 1, '2020-06-09', 'yes theory', 'Exposé', 'Slam', 'no theory', 20, 22, 'C:/xampp/php/www/pidev/events/textures_large_nkash_45.png', 'Gammarth', 3),
(48, 1, '2022-03-18', 'Lets Go', 'Formation', 'Theatre', '22', 21, 22, 'C:/xampp/php/www/pidev/events/andydoo (33).jpg', 'here', 0),
(50, 1, '2020-03-30', 'ArtBOxxx', 'Exposé', 'Dancing', 'ArtBox is a platform', 20, 22, 'C:/xampp/php/www/pidev/events/textures_large_nkash_44.png', 'ArtBox Inc.', 2),
(51, 1, '2020-03-11', 'Hello World!', 'Formation', 'Singing', 'Free drinks all the way!', 295, 300, 'C:/xampp/php/www/pidev/events/textures_large_nkash_50.png', 'here', 0),
(53, 1, '2022-03-20', 'Validation demain', 'Exposé', 'Theatre', 'We gonna do great', 49, 50, 'C:/xampp/php/www/pidev/events/textures_large_nkash_47.png', 'G1-09', 0),
(54, 1, '2020-03-31', 'Lets go', 'Exposé', 'Singing', 'Leggo', 19, 20, 'C:/xampp/php/www/pidev/events/andydoo (9).jpg', 'Leggo', 2),
(55, 1, '2022-03-25', 'Blues', 'Festival', 'Singing', 'Ray Charles is alive', 19, 20, 'C:/xampp/php/www/pidev/events/ray-charles.jpg', 'Ray Charles', 0),
(56, 1, '2022-05-21', 'Sofar', 'Autres', 'Street Art', 'Artistes amateurs', 39, 40, 'C:/xampp/php/www/pidev/events/attack_on_titan__the_wings_of_freedom_by_itsbxd_d6we9gg.png', 'Esprit', 0),
(57, 1, '2022-03-19', 'SoFarSoGood', 'Exposé', 'Dancing', 'So far is a..', 19, 20, 'C:/xampp/php/www/pidev/events/andydoo (8).jpg', 'here', 0),
(58, 1, '2022-03-31', 'Validation in 1H', 'Exposé', 'Dancing', 'whatever', 20, 20, 'C:/xampp/php/www/pidev/events/andydoo (6).jpg', 'whatever', 0),
(60, 1, '2020-03-25', 'TryingPane', 'Exposé', 'Theatre', 'nonono', 19, 20, 'C:/xampp/php/www/pidev/events/andydoo (2).jpg', 'here', 2),
(61, 4, '2022-03-22', 'TodayEvent', 'Exposé', 'Theatre', 'yes', 19, 20, 'C:/xampp/php/www/pidev/events/andydoo (26).jpg', 'Dar Jamila', 0),
(62, 4, '2022-03-23', 'DateNow', 'Exposé', 'Slam', 'DateNow is GMT + ?', 50, 50, 'C:/xampp/php/www/pidev/events/textures_large_nkash_51.png', 'dar jamila', 0),
(63, 4, '2022-03-24', 'WhichUser', 'Exposé', 'Theatre', 'whatever', 20, 20, 'C:/xampp/php/www/pidev/events/andydoo (19).jpg', 'esprit', 0),
(64, 4, '2022-03-26', 'RatingWorks', 'Exposé', 'Theatre', 'here', 20, 20, 'C:/xampp/php/www/pidev/events/andydoo (24).jpg', 'here', 0),
(65, 4, '2021-04-02', 'ValidationToday', 'Exposé', 'Slam', 'leggo', 20, 20, 'C:/xampp/php/www/pidev/events/andydoo (28).jpg', 'G01-09', 0),
(66, 4, '2021-03-26', 'TryingRecom', 'Exposé', 'Singing', 'ss', 20, 20, 'C:/xampp/php/www/pidev/events/andydoo (22).jpg', 'Dar Jamila', 0),
(67, 4, '2021-03-27', 'Trying API', 'Exposé', 'Dancing', '20', 20, 20, 'C:/xampp/php/www/pidev/events/andydoo (30).jpg', 'here', 0),
(68, 4, '2021-03-31', 'API', 'Exposé', 'Singing', 'hello', 20, 20, 'C:/xampp/php/www/pidev/events/andydoo (23).jpg', 'wadup', 0),
(69, 4, '2021-03-31', 'API', 'Exposé', 'Singing', 'hello', 20, 20, 'C:/xampp/php/www/pidev/events/andydoo (23).jpg', 'wadup', 0);

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
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `evenement`
--
ALTER TABLE `evenement`
  ADD CONSTRAINT `fk_org` FOREIGN KEY (`id_org`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
