-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 28, 2021 at 08:12 PM
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
-- Table structure for table `interactions`
--

CREATE TABLE `interactions` (
  `id_inter` int(20) NOT NULL,
  `id_post` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `like_check` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `interactions`
--

INSERT INTO `interactions` (`id_inter`, `id_post`, `id_user`, `like_check`) VALUES
(171, 13, 2, 1),
(172, 14, 2, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `interactions`
--
ALTER TABLE `interactions`
  ADD PRIMARY KEY (`id_inter`),
  ADD KEY `id_user1` (`id_user`),
  ADD KEY `id_post` (`id_post`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `interactions`
--
ALTER TABLE `interactions`
  MODIFY `id_inter` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=173;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `interactions`
--
ALTER TABLE `interactions`
  ADD CONSTRAINT `id_post` FOREIGN KEY (`id_post`) REFERENCES `postes` (`id_post`),
  ADD CONSTRAINT `id_user1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
