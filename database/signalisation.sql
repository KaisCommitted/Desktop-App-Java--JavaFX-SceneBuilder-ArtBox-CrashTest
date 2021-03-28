-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 28, 2021 at 05:54 PM
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
-- Table structure for table `signalisation`
--

CREATE TABLE `signalisation` (
  `id_signal` int(30) NOT NULL,
  `id_post` int(30) DEFAULT NULL,
  `id_user` int(30) DEFAULT NULL,
  `type_signal` varchar(30) NOT NULL,
  `contenu_signal` varchar(150) NOT NULL,
  `etat_signal` varchar(10) NOT NULL,
  `date_signal` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `signalisation`
--
ALTER TABLE `signalisation`
  ADD PRIMARY KEY (`id_signal`),
  ADD KEY `FKpost` (`id_post`),
  ADD KEY `FKuser` (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `signalisation`
--
ALTER TABLE `signalisation`
  MODIFY `id_signal` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
