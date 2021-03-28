-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 28, 2021 at 08:13 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

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
-- Table structure for table `postes`
--

CREATE TABLE `postes` (
  `id_post` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `Description` varchar(50) NOT NULL,
  `Nom_post` varchar(30) NOT NULL,
  `categorie` varchar(30) NOT NULL,
  `file` varchar(100) NOT NULL,
  `album_cover` varchar(100) DEFAULT NULL,
  `post_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `desc_analys` varchar(30) NOT NULL,
  `Likes` int(20) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `postes`
--

INSERT INTO `postes` (`id_post`, `id_user`, `Description`, `Nom_post`, `categorie`, `file`, `album_cover`, `post_date`, `desc_analys`, `Likes`) VALUES
(13, 2, 'goo dsong', 'Canopee', 'music', 'C:/xampp/php/www/pidev/Postes/POLO & PAN - Canopée (audio).mp3', 'C:\\Users\\Adam Khalfaoui\\Downloads\\302147.jpg', '2021-03-25 04:58:35', 'positive', 1),
(14, 2, 'sdfsdf', 'test', 'photography', 'C:/xampp/php/www/pidev/Postes/CHI_1000.JPG', NULL, '2021-03-25 04:58:36', 'neutral', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `postes`
--
ALTER TABLE `postes`
  ADD PRIMARY KEY (`id_post`),
  ADD KEY `id_user` (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `postes`
--
ALTER TABLE `postes`
  MODIFY `id_post` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `postes`
--
ALTER TABLE `postes`
  ADD CONSTRAINT `id_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
