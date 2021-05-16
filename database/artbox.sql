-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 16, 2021 at 09:11 PM
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
-- Table structure for table `annonce`
--

CREATE TABLE `annonce` (
  `id_ann` int(11) NOT NULL,
  `id_user` int(11) DEFAULT NULL,
  `titre_ann` varchar(250) NOT NULL,
  `desc_ann` varchar(250) NOT NULL,
  `pay` int(11) NOT NULL,
  `categorie` varchar(255) DEFAULT NULL,
  `ddl_ann` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `annonce`
--

INSERT INTO `annonce` (`id_ann`, `id_user`, `titre_ann`, `desc_ann`, `pay`, `categorie`, `ddl_ann`) VALUES
(8, 19, 'Yes', 'Sir', 1200, 'Design', '2021-04-29');

-- --------------------------------------------------------

--
-- Table structure for table `candidature`
--

CREATE TABLE `candidature` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `ann_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `categorie`
--

CREATE TABLE `categorie` (
  `categorie_name` varchar(255) NOT NULL,
  `categorie_image` varchar(255) NOT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `categorie`
--

INSERT INTO `categorie` (`categorie_name`, `categorie_image`, `status`) VALUES
('Cinema', '(4).png', '+'),
('Design', '(6).png', '+'),
('Manga', '(5).png', '+'),
('Painting', '(6).png', '+'),
('Photography', '(1).png', '+'),
('Singing', '(2).png', '+'),
('Theatre', '(3).png', '+');

-- --------------------------------------------------------

--
-- Table structure for table `comments`
--

CREATE TABLE `comments` (
  `id_comment` int(100) NOT NULL,
  `id_post` int(11) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  `comment` varchar(100) NOT NULL,
  `comment_analys` varchar(255) NOT NULL,
  `comment_date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `comment_event`
--

CREATE TABLE `comment_event` (
  `id` int(11) NOT NULL,
  `id_user` int(11) DEFAULT NULL,
  `id_event` int(11) DEFAULT NULL,
  `content` varchar(255) NOT NULL,
  `commentDate` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `comment_event`
--

INSERT INTO `comment_event` (`id`, `id_user`, `id_event`, `content`, `commentDate`) VALUES
(40, 20, 127, 'hello world', '2021-04-29'),
(41, 18, 127, 'hello world', '2021-04-29'),
(42, 18, 127, 'whatsapp', '2021-04-29'),
(44, 20, 130, 'je suuis yasmine', '2021-04-29'),
(45, 18, 130, 'je suuis yasmine', '2021-04-29');

-- --------------------------------------------------------

--
-- Table structure for table `doctrine_migration_versions`
--

CREATE TABLE `doctrine_migration_versions` (
  `version` varchar(191) COLLATE utf8_unicode_ci NOT NULL,
  `executed_at` datetime DEFAULT NULL,
  `execution_time` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `doctrine_migration_versions`
--

INSERT INTO `doctrine_migration_versions` (`version`, `executed_at`, `execution_time`) VALUES
('DoctrineMigrations\\Version20210409150002', '2021-04-09 17:00:15', 37608),
('DoctrineMigrations\\Version20210409164028', '2021-04-09 18:40:39', 14560),
('DoctrineMigrations\\Version20210410100256', '2021-04-10 12:03:16', 1195);

-- --------------------------------------------------------

--
-- Table structure for table `evenement`
--

CREATE TABLE `evenement` (
  `id` int(255) NOT NULL,
  `id_org` int(11) DEFAULT NULL,
  `date` date NOT NULL,
  `nom_event` varchar(255) NOT NULL,
  `type_event` varchar(255) DEFAULT NULL,
  `categorie` varchar(255) DEFAULT NULL,
  `description` varchar(255) NOT NULL,
  `capacite_event` int(11) NOT NULL,
  `nb_max` int(11) NOT NULL,
  `image_event` varchar(255) DEFAULT NULL,
  `location_event` varchar(255) DEFAULT NULL,
  `rating_event` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `evenement`
--

INSERT INTO `evenement` (`id`, `id_org`, `date`, `nom_event`, `type_event`, `categorie`, `description`, `capacite_event`, `nb_max`, `image_event`, `location_event`, `rating_event`) VALUES
(126, 18, '2021-04-29', 'testingFieldss', 'Festival', 'Singing', 'What is an event description? An event description is copy that aims to tell your potential attendees what will be happening at the event, who will be speaking, and what they will get out of attending. ', 19, 20, '1 (8).jpg', 'whatever', 4),
(127, 18, '2021-04-29', 'TryingShow', 'Festival', 'Manga', 'What is an event description? An event description is copy that aims to tell your potential attendees what will be happening at the event, who will be speaking, and what they will get out of attending. ', 19, 20, '1 (9).png', 'whatever', 5),
(129, 19, '2021-04-29', 'Alphabetical', 'Festival', 'Photography', 'Alphabetical', 19, 20, '1 (10).jpg', 'Alphabetical', 0),
(130, 19, '2021-04-29', 'ThisMonth', 'Festival', 'Cinema', 'ThisMonth', 14, 20, '1 (10).png', 'whatever', 0),
(131, 18, '2021-04-30', 'Testing', 'Festival', 'Cinema', 'testingTri', 17, 20, '1 (11).png', 'whatever', 0),
(132, 19, '2020-01-01', 'searchme', 'Festival', 'Cinema', 'SearchMee', 20, 20, '1 (13).jpg', 'whatever', 5),
(133, 18, '2021-04-30', 'BundleCalendar', 'Festival', 'Cinema', 'BundleCalendar', 20, 20, '1 (3).png', 'Here', 0),
(134, 18, '2021-04-30', 'Leggo', 'Festival', 'Theatre', 'BundleCalendar', 20, 20, '1 (21).jpg', 'Here', 0),
(135, 18, '2020-01-01', 'EasyPeasy', 'Festival', 'Theatre', 'BundleCalendar', 20, 20, '1 (20).jpg', 'Here', 4),
(136, 18, '2020-01-01', 'Calendarpls', 'Festival', 'Cinema', 'whatever', 20, 20, '1 (9).jpg', 'whatever', 2),
(137, 18, '2020-01-01', 'Calendarplss', 'Festival', 'Cinema', 'whatever', 20, 20, '1 (18).jpg', 'whatever', 0),
(138, 18, '2021-04-30', 'Calendarplsss', 'Festival', 'Cinema', 'whatever', 20, 20, '1 (11).jpg', 'whatever', 0),
(139, 18, '2021-04-30', 'CalendarYes', 'Festival', 'Cinema', 'whatever', 20, 20, '1 (9).png', 'whatever', 0),
(140, 18, '2021-04-30', 'CalendarNo', 'Festival', 'Cinema', 'whatever', 20, 20, '1 (3).jpg', 'whatever', 0),
(141, 18, '2021-04-30', 'Lazy', 'Festival', 'Cinema', 'whatever', 20, 20, '1 (10).png', 'whatever', 0),
(142, 18, '2021-04-30', 'Easy', 'Festival', 'Cinema', 'whatever', 20, 20, '1 (14).jpg', 'whatever', 0),
(143, 18, '2021-04-30', 'xxxx', 'Festival', 'Cinema', 'xxxx', 20, 20, '1 (11).png', 'xxx', 0),
(144, 18, '2021-04-30', 'TryingNoFormType', 'Festival', 'Cinema', 'TryingNoFormType', 20, 20, '1 (12).jpg', 'TryingNoFormType', 0),
(145, 18, '2021-04-30', 'Whateverrrrrrrrrrrrrrrrrrrr', 'Festival', 'Cinema', 'Whateverrrrrrrrrrrrrrrrr', 20, 20, '1 (12).png', 'here', 0),
(146, 18, '2020-01-01', 'TestingRender', 'Festival', 'Cinema', 'TestingRenderTestingRender', 20, 20, '1 (18).jpg', 'whatever', 0),
(147, 20, '2023-01-01', 'Modal test', 'Festival', 'Photography', 'whatever is right', 20, 20, '1 (19).jpg', 'whatever', 0),
(148, 18, '2024-01-01', 'whateverrrrrrrr', 'Festival', 'Cinema', 'sdq', 20, 20, '1 (12).png', 'whatever', 0),
(149, 18, '2025-01-01', 'test', 'Festival', 'Cinema', 'te', 2, 2, '1 (3).png', 'whatever', 0),
(150, 18, '2022-01-01', 'yesss', 'Festival', 'Cinema', 'dqs', 20, 20, '1 (12).jpg', 'sdq', 0),
(151, 18, '2022-01-01', 'yessssd', 'Festival', 'Cinema', 'dqs', 20, 20, '1 (18).jpg', 'sdq', 0),
(152, 18, '2022-01-01', 'whateversdqs', 'Festival', 'Cinema', 's', 20, 20, '1 (11).jpg', 's', 0),
(153, 18, '2026-01-01', 'sdsa', 'Festival', 'Cinema', 'sdq', 20, 20, '1 (14).jpg', 'dsq', 0),
(154, 18, '2023-01-01', 'louza', 'Festival', 'Cinema', 'sdq', 20, 20, '1 (12).png', 'sdq', 0),
(155, 18, '2022-01-01', 'whateverrs', 'Festival', 'Cinema', 'sdq', 20, 20, '1 (5).jpg', 'qsdqd', 0),
(156, 19, '2022-01-01', 'VeryNewEvent', 'Festival', 'Cinema', 'whatever', 20, 20, '1 (5).jpg', 'here', 0),
(157, 18, '2023-01-01', 'ProjetS', 'Festival', 'Cinema', 'sada', 20, 20, '1 (3).png', 'whatever', 0),
(158, 18, '2023-01-01', 'JSON', 'Festival', 'Cinema', 'JSON', 20, 20, '1 (3).png', 'JSON', 0),
(159, 19, '2021-05-06', 'JSONNN', 'Online', 'Cinema', 'json', 20, 20, '1 (5).jpg', 'StreetArt', 0);

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `id_feedback` int(30) NOT NULL,
  `id_user` int(11) DEFAULT NULL,
  `contenu_feedback` varchar(255) NOT NULL,
  `type_feedback` varchar(30) NOT NULL,
  `etat_feedback` varchar(30) NOT NULL,
  `date_feedback` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `interactions`
--

CREATE TABLE `interactions` (
  `id_inter` int(20) NOT NULL,
  `id_post` int(11) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  `like_check` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `label`
--

CREATE TABLE `label` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `imageLabel` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `label`
--

INSERT INTO `label` (`id`, `name`, `type`, `imageLabel`) VALUES
(3, 'Partner', 'qsd', 'C:\\xampp\\php\\www\\ArtBox-CrashTest\\src\\ArtHub\\images\\users\\kaisicona-partnership.png');

-- --------------------------------------------------------

--
-- Table structure for table `partenaire`
--

CREATE TABLE `partenaire` (
  `id_part` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `logo` varchar(255) NOT NULL,
  `rib` varchar(255) NOT NULL,
  `tel` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `id_user` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `partenaire`
--

INSERT INTO `partenaire` (`id_part`, `nom`, `adresse`, `logo`, `rib`, `tel`, `status`, `id_user`) VALUES
(1, 'Sodexo', 'whatever', 'C:/xampp/php/www/ArtBox-CrashTest-WEB/public/imagepartenaire/partner.jpg', '15695213', '5447264', '1', 19);

-- --------------------------------------------------------

--
-- Table structure for table `participant`
--

CREATE TABLE `participant` (
  `id_participation` int(11) NOT NULL,
  `id_user` int(11) DEFAULT NULL,
  `id_event` int(11) DEFAULT NULL,
  `ticket` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `participant`
--

INSERT INTO `participant` (`id_participation`, `id_user`, `id_event`, `ticket`) VALUES
(293, 18, 126, '12618'),
(295, 18, 127, '12718');

-- --------------------------------------------------------

--
-- Table structure for table `postes`
--

CREATE TABLE `postes` (
  `id_post` int(11) NOT NULL,
  `Description` varchar(50) NOT NULL,
  `Nom_post` varchar(30) NOT NULL,
  `categorie` varchar(255) DEFAULT NULL,
  `file` varchar(255) NOT NULL,
  `post_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `album_cover` varchar(255) DEFAULT NULL,
  `Likes` int(11) NOT NULL,
  `desc_analys` varchar(30) NOT NULL,
  `id_user` int(11) DEFAULT NULL,
  `post_type` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `rating_event`
--

CREATE TABLE `rating_event` (
  `id_rating` int(11) NOT NULL,
  `id_user` int(11) DEFAULT NULL,
  `id_event` int(11) DEFAULT NULL,
  `rating` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rating_event`
--

INSERT INTO `rating_event` (`id_rating`, `id_user`, `id_event`, `rating`) VALUES
(78, 19, 126, 5),
(86, 21, 126, 1),
(87, 20, 126, 3),
(96, 18, 127, 5),
(100, 18, 126, 4);

-- --------------------------------------------------------

--
-- Table structure for table `signalisation`
--

CREATE TABLE `signalisation` (
  `id_signal` int(11) NOT NULL,
  `id_user` int(11) DEFAULT NULL,
  `id_post` int(11) DEFAULT NULL,
  `contenu_signal` varchar(255) NOT NULL,
  `type_signal` varchar(30) NOT NULL,
  `etat_signal` varchar(30) NOT NULL,
  `date_signal` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `type_event`
--

CREATE TABLE `type_event` (
  `type_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `type_event`
--

INSERT INTO `type_event` (`type_name`) VALUES
('Festival'),
('Online'),
('Other');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `mail` varchar(255) NOT NULL,
  `date_naissance` date NOT NULL,
  `pwd_user` varchar(255) NOT NULL,
  `ref_admin` varchar(1) NOT NULL,
  `id_label` int(11) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `nom`, `prenom`, `username`, `mail`, `date_naissance`, `pwd_user`, `ref_admin`, `id_label`, `image`) VALUES
(18, 'kais', 'lamine', 'kais', 'kais.lamine@esprit.tn', '1999-03-04', '0000', '+', 3, 'C:\\xampp\\php\\www\\ArtBox-CrashTest\\src\\ArtHub\\images\\users\\kaisicona-partnership.png'),
(19, 'louay', 'louay', 'louay', 'louay.jeddou@esprit.tn', '2016-01-01', '0000', '-', 3, 'C:\\xampp\\php\\www\\ArtBox-CrashTest\\src\\ArtHub\\images\\users\\kaisicona-partnership.png'),
(20, 'yasmine', 'zerai', 'yasmine', 'yasmine.zerai@esprit.tn', '1999-03-04', '0000', '+', 3, 'C:\\xampp\\php\\www\\ArtBox-CrashTest\\src\\ArtHub\\images\\users\\kaisicona-partnership.pngC:\\xampp\\php\\www\\ArtBox-CrashTest\\src\\ArtHub\\images\\users\\kaisicona-partnership.png'),
(21, 'moetez', 'karoui', 'moetez', 'moetez.karoui@esprit.tn', '1999-03-04', '0000', '-', 3, 'C:\\xampp\\php\\www\\ArtBox-CrashTest\\src\\ArtHub\\images\\users\\kaisicona-partnership.png');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `annonce`
--
ALTER TABLE `annonce`
  ADD PRIMARY KEY (`id_ann`),
  ADD KEY `fk_userrrrr` (`id_user`),
  ADD KEY `cattt` (`categorie`);

--
-- Indexes for table `candidature`
--
ALTER TABLE `candidature`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_userrrr` (`user_id`),
  ADD KEY `fk_annnnn` (`ann_id`);

--
-- Indexes for table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`categorie_name`),
  ADD UNIQUE KEY `categorie_name` (`categorie_name`);
ALTER TABLE `categorie` ADD FULLTEXT KEY `categorie_name_2` (`categorie_name`);

--
-- Indexes for table `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`id_comment`),
  ADD KEY `id_post2` (`id_post`),
  ADD KEY `id_use2` (`id_user`);

--
-- Indexes for table `comment_event`
--
ALTER TABLE `comment_event`
  ADD PRIMARY KEY (`id`),
  ADD KEY `userr` (`id_user`),
  ADD KEY `eventt` (`id_event`);

--
-- Indexes for table `doctrine_migration_versions`
--
ALTER TABLE `doctrine_migration_versions`
  ADD PRIMARY KEY (`version`);

--
-- Indexes for table `evenement`
--
ALTER TABLE `evenement`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nom_event` (`nom_event`),
  ADD KEY `id_org` (`id_org`),
  ADD KEY `categorie` (`categorie`),
  ADD KEY `ssss` (`type_event`);
ALTER TABLE `evenement` ADD FULLTEXT KEY `nom_event_2` (`nom_event`,`description`);
ALTER TABLE `evenement` ADD FULLTEXT KEY `categorie_2` (`categorie`);

--
-- Indexes for table `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`id_feedback`),
  ADD KEY `fk_usee` (`id_user`);

--
-- Indexes for table `interactions`
--
ALTER TABLE `interactions`
  ADD PRIMARY KEY (`id_inter`),
  ADD KEY `fk_uppppp` (`id_post`),
  ADD KEY `fk_ussssss` (`id_user`);

--
-- Indexes for table `label`
--
ALTER TABLE `label`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `partenaire`
--
ALTER TABLE `partenaire`
  ADD PRIMARY KEY (`id_part`),
  ADD KEY `fk_useerr` (`id_user`);

--
-- Indexes for table `participant`
--
ALTER TABLE `participant`
  ADD PRIMARY KEY (`id_participation`),
  ADD KEY `fk_userid` (`id_user`),
  ADD KEY `fk_idevt` (`id_event`);

--
-- Indexes for table `postes`
--
ALTER TABLE `postes`
  ADD PRIMARY KEY (`id_post`),
  ADD KEY `ctn1` (`id_user`),
  ADD KEY `dsqd` (`categorie`);

--
-- Indexes for table `rating_event`
--
ALTER TABLE `rating_event`
  ADD PRIMARY KEY (`id_rating`),
  ADD KEY `fk_event` (`id_event`),
  ADD KEY `fk_user` (`id_user`);

--
-- Indexes for table `signalisation`
--
ALTER TABLE `signalisation`
  ADD PRIMARY KEY (`id_signal`),
  ADD KEY `fkkk` (`id_post`),
  ADD KEY `fuuaz` (`id_user`);

--
-- Indexes for table `type_event`
--
ALTER TABLE `type_event`
  ADD PRIMARY KEY (`type_name`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `annonce`
--
ALTER TABLE `annonce`
  MODIFY `id_ann` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `candidature`
--
ALTER TABLE `candidature`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `comments`
--
ALTER TABLE `comments`
  MODIFY `id_comment` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `comment_event`
--
ALTER TABLE `comment_event`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- AUTO_INCREMENT for table `evenement`
--
ALTER TABLE `evenement`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=162;

--
-- AUTO_INCREMENT for table `feedback`
--
ALTER TABLE `feedback`
  MODIFY `id_feedback` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `interactions`
--
ALTER TABLE `interactions`
  MODIFY `id_inter` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=176;

--
-- AUTO_INCREMENT for table `label`
--
ALTER TABLE `label`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `partenaire`
--
ALTER TABLE `partenaire`
  MODIFY `id_part` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `participant`
--
ALTER TABLE `participant`
  MODIFY `id_participation` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=297;

--
-- AUTO_INCREMENT for table `postes`
--
ALTER TABLE `postes`
  MODIFY `id_post` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `rating_event`
--
ALTER TABLE `rating_event`
  MODIFY `id_rating` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;

--
-- AUTO_INCREMENT for table `signalisation`
--
ALTER TABLE `signalisation`
  MODIFY `id_signal` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `annonce`
--
ALTER TABLE `annonce`
  ADD CONSTRAINT `FK_F65593E5497DD634` FOREIGN KEY (`categorie`) REFERENCES `categorie` (`categorie_name`),
  ADD CONSTRAINT `fk_userrrrr` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `candidature`
--
ALTER TABLE `candidature`
  ADD CONSTRAINT `FK_E33BD3B816912862` FOREIGN KEY (`ann_id`) REFERENCES `annonce` (`id_ann`),
  ADD CONSTRAINT `FK_E33BD3B8A76ED395` FOREIGN KEY (`user_id`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `comments`
--
ALTER TABLE `comments`
  ADD CONSTRAINT `FK_5F9E962A6B3CA4B` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`),
  ADD CONSTRAINT `FK_5F9E962AD1AA708F` FOREIGN KEY (`id_post`) REFERENCES `postes` (`id_post`);

--
-- Constraints for table `comment_event`
--
ALTER TABLE `comment_event`
  ADD CONSTRAINT `FK_923492566B3CA4B` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_92349256D52B4B97` FOREIGN KEY (`id_event`) REFERENCES `evenement` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `evenement`
--
ALTER TABLE `evenement`
  ADD CONSTRAINT `FK_B26681E497DD634` FOREIGN KEY (`categorie`) REFERENCES `categorie` (`categorie_name`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_B26681EECB152DA` FOREIGN KEY (`id_org`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `evenement_ibfk_2` FOREIGN KEY (`type_event`) REFERENCES `type_event` (`type_name`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `feedback`
--
ALTER TABLE `feedback`
  ADD CONSTRAINT `fk_usee` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `interactions`
--
ALTER TABLE `interactions`
  ADD CONSTRAINT `FK_538B74BD6B3CA4B` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`),
  ADD CONSTRAINT `FK_538B74BDD1AA708F` FOREIGN KEY (`id_post`) REFERENCES `postes` (`id_post`);

--
-- Constraints for table `partenaire`
--
ALTER TABLE `partenaire`
  ADD CONSTRAINT `FK_32FFA3736B3CA4B` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `participant`
--
ALTER TABLE `participant`
  ADD CONSTRAINT `fk_idevt` FOREIGN KEY (`id_event`) REFERENCES `evenement` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_userid` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `postes`
--
ALTER TABLE `postes`
  ADD CONSTRAINT `FK_5A763C64497DD634` FOREIGN KEY (`categorie`) REFERENCES `categorie` (`categorie_name`),
  ADD CONSTRAINT `FK_5A763C646B3CA4B` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `rating_event`
--
ALTER TABLE `rating_event`
  ADD CONSTRAINT `fk_event` FOREIGN KEY (`id_event`) REFERENCES `evenement` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `signalisation`
--
ALTER TABLE `signalisation`
  ADD CONSTRAINT `FK_1BD243CD6B3CA4B` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`),
  ADD CONSTRAINT `FK_1BD243CDD1AA708F` FOREIGN KEY (`id_post`) REFERENCES `postes` (`id_post`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
