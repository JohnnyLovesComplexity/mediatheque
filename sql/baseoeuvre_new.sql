-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  ven. 19 avr. 2019 à 10:46
-- Version du serveur :  10.1.37-MariaDB
-- Version de PHP :  7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `baseoeuvre`
--

-- --------------------------------------------------------

--
-- Suppresion des tables
--
DROP TABLE IF EXISTS `utilisateur`;
DROP TABLE IF EXISTS `emprunt`;
DROP TABLE IF EXISTS `reservation`;
DROP TABLE IF EXISTS `status`;
DROP TABLE IF EXISTS `adherent`;
DROP TABLE IF EXISTS `oeuvrepret`;
DROP TABLE IF EXISTS `oeuvrevente`;
DROP TABLE IF EXISTS `proprietaire`;

-- --------------------------------------------------------

--
-- Structure de la table `adherent`
--

CREATE TABLE `adherent` (
  `id_adherent` int(10) UNSIGNED NOT NULL,
  `nom_adherent` varchar(100) NOT NULL,
  `prenom_adherent` varchar(100) DEFAULT NULL,
  `ville_adherent` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `adherent`
--

INSERT INTO `adherent` (`id_adherent`, `nom_adherent`, `prenom_adherent`, `ville_adherent`) VALUES
(3, 'DUPONT', 'Didier', 'Grenoble'),
(4, 'Michel', 'DURANT', 'Givors'),
(5, 'CHOPIN', 'Daniel', 'Villefranche'),
(6, 'MOZART', 'Albert', 'Craponne'),
(7, 'FRUCCI', 'Fraise', 'Craponne'),
(8, 'BRUN', 'Pierre', 'Lyon'),
(9, 'Blanc', 'Serge', 'Oullins'),
(11, 'VIAL', 'albert  ', 'Lyon'),
(12, 'VIAL', 'fg  ', 'Lyon'),
(13, 'Grand', 'Alain', 'Tours'),
(14, 'Vial', 'Guillaume', 'COPENHAGUE'),
(15, 'THOAR', 'Ingrid', 'BERLIN'),
(16, 'BERGER', 'Valentin', 'Lyon');

-- --------------------------------------------------------

--
-- Structure de la table `emprunt`
--

CREATE TABLE `emprunt` (
  `id_oeuvrepret` int(10) UNSIGNED NOT NULL,
  `id_adherent` int(10) UNSIGNED NOT NULL,
  `date_reservation` date NOT NULL,
  `id_statut` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `emprunt`
--

INSERT INTO `emprunt` (`id_oeuvrepret`, `id_adherent`, `date_reservation`, `id_statut`) VALUES
(1, 16, '2019-04-19', 1),
(14, 16, '2019-04-19', 1);

-- --------------------------------------------------------

--
-- Structure de la table `oeuvrepret`
--

CREATE TABLE `oeuvrepret` (
  `id_oeuvrepret` int(10) UNSIGNED NOT NULL,
  `titre_oeuvrepret` varchar(200) NOT NULL,
  `id_proprietaire` int(10) UNSIGNED DEFAULT NULL,
  `etat_oeuvrepret` varchar(1) DEFAULT 'L'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `oeuvrepret`
--

INSERT INTO `oeuvrepret` (`id_oeuvrepret`, `titre_oeuvrepret`, `id_proprietaire`, `etat_oeuvrepret`) VALUES
(1, 'Oeuvre en pret 1', 1000, 'R'),
(2, 'Oeuvre en pret 2', 1000, 'L'),
(10, 'Oeuvre en pret 3', 1000, 'L'),
(13, 'Planet', 1001, 'L'),
(14, 'Blanc', 1000, 'R'),
(15, 'Rouge', 1002, 'L');

-- --------------------------------------------------------

--
-- Structure de la table `oeuvrevente`
--

CREATE TABLE `oeuvrevente` (
  `id_oeuvrevente` int(10) UNSIGNED NOT NULL,
  `titre_oeuvrevente` varchar(200) NOT NULL,
  `etat_oeuvrevente` varchar(1) NOT NULL,
  `prix_oeuvrevente` float NOT NULL,
  `id_proprietaire` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `oeuvrevente`
--

INSERT INTO `oeuvrevente` (`id_oeuvrevente`, `titre_oeuvrevente`, `etat_oeuvrevente`, `prix_oeuvrevente`, `id_proprietaire`) VALUES
(10000, 'lala', 'L', 17, 1000),
(10001, 'Ete', 'L', 400, 1000),
(10002, 'Automne', 'R', 10, 1000),
(10003, 'Crepuscule', 'L', 111, 1001),
(10004, 'Hiver', 'L', 234, 1000),
(10005, 'Aurore', 'R', 654, 1002),
(10006, 'Nuit de printemps', 'L', 789, 1001),
(10007, 'nouvelle Oeuvre 2', 'L', 12, 1000),
(10010, 'Titre', 'L', 4645, 1000),
(10013, 'Oeuvre en vente', 'L', 456, 1000),
(10014, 'Oeuvre en vente', 'L', 5465, 1000),
(10015, 'Teeest', 'L', 2457, 1000),
(10016, 'Bleu', 'L', 15, 1000);

-- --------------------------------------------------------

--
-- Structure de la table `proprietaire`
--

CREATE TABLE `proprietaire` (
  `id_proprietaire` int(10) UNSIGNED NOT NULL,
  `nom_proprietaire` varchar(100) CHARACTER SET latin1 NOT NULL,
  `prenom_proprietaire` varchar(100) CHARACTER SET latin1 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `proprietaire`
--

INSERT INTO `proprietaire` (`id_proprietaire`, `nom_proprietaire`, `prenom_proprietaire`) VALUES
(1000, 'DUPONT', 'Isabelle'),
(1001, 'DUPUIS', 'Valerie'),
(1002, 'MOZART', 'Albert');

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

CREATE TABLE `reservation` (
  `id_oeuvrevente` int(10) UNSIGNED NOT NULL,
  `id_adherent` int(10) UNSIGNED NOT NULL,
  `date_reservation` date NOT NULL,
  `statut` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`id_oeuvrevente`, `id_adherent`, `date_reservation`, `statut`) VALUES
(10002, 16, '2019-04-19', 'En attente'),
(10005, 16, '2019-04-19', 'En attente');

-- --------------------------------------------------------

--
-- Structure de la table `status`
--

CREATE TABLE `status` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `status`
--

INSERT INTO `status` (`id`, `name`) VALUES
(1, 'En attente'),
(2, 'Confirme'),
(3, 'Annule');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `NumUtil` int(11) NOT NULL,
  `NomUtil` varchar(100) COLLATE utf8_bin NOT NULL,
  `MotPasse` varchar(100) COLLATE utf8_bin NOT NULL,
  `role` varchar(100) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`NumUtil`, `NomUtil`, `MotPasse`, `role`) VALUES
(1, 'Merlot', '5ebe2294ecd0e0f08eab7690d2a6ee69', 'admin'),
(2, 'Lalande', '5ebe2294ecd0e0f08eab7690d2a6ee69', 'visiteur'),
(3, 'Pinot', '5ebe2294ecd0e0f08eab7690d2a6ee69', 'visiteur');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `adherent`
--
ALTER TABLE `adherent`
  ADD PRIMARY KEY (`id_adherent`);

--
-- Index pour la table `emprunt`
--
ALTER TABLE `emprunt`
  ADD PRIMARY KEY (`id_oeuvrepret`,`id_adherent`),
  ADD KEY `id_adherent` (`id_adherent`),
  ADD KEY `emprunt_ibfk_3` (`id_statut`);

--
-- Index pour la table `oeuvrepret`
--
ALTER TABLE `oeuvrepret`
  ADD PRIMARY KEY (`id_oeuvrepret`),
  ADD KEY `id_proprietaire` (`id_proprietaire`);

--
-- Index pour la table `oeuvrevente`
--
ALTER TABLE `oeuvrevente`
  ADD PRIMARY KEY (`id_oeuvrevente`),
  ADD KEY `id_proprietaire` (`id_proprietaire`);

--
-- Index pour la table `proprietaire`
--
ALTER TABLE `proprietaire`
  ADD PRIMARY KEY (`id_proprietaire`);

--
-- Index pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`id_oeuvrevente`,`id_adherent`),
  ADD KEY `id_adherent` (`id_adherent`);

--
-- Index pour la table `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`NumUtil`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `adherent`
--
ALTER TABLE `adherent`
  MODIFY `id_adherent` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT pour la table `oeuvrepret`
--
ALTER TABLE `oeuvrepret`
  MODIFY `id_oeuvrepret` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT pour la table `oeuvrevente`
--
ALTER TABLE `oeuvrevente`
  MODIFY `id_oeuvrevente` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10017;

--
-- AUTO_INCREMENT pour la table `proprietaire`
--
ALTER TABLE `proprietaire`
  MODIFY `id_proprietaire` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1003;

--
-- AUTO_INCREMENT pour la table `status`
--
ALTER TABLE `status`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `emprunt`
--
ALTER TABLE `emprunt`
  ADD CONSTRAINT `emprunt_ibfk_1` FOREIGN KEY (`id_oeuvrepret`) REFERENCES `oeuvrepret` (`id_oeuvrepret`),
  ADD CONSTRAINT `emprunt_ibfk_2` FOREIGN KEY (`id_adherent`) REFERENCES `adherent` (`id_adherent`),
  ADD CONSTRAINT `emprunt_ibfk_3` FOREIGN KEY (`id_statut`) REFERENCES `status` (`id`);

--
-- Contraintes pour la table `oeuvrepret`
--
ALTER TABLE `oeuvrepret`
  ADD CONSTRAINT `oeuvrepret_ibfk_1` FOREIGN KEY (`id_proprietaire`) REFERENCES `proprietaire` (`id_proprietaire`);

--
-- Contraintes pour la table `oeuvrevente`
--
ALTER TABLE `oeuvrevente`
  ADD CONSTRAINT `oeuvrevente_ibfk_1` FOREIGN KEY (`id_proprietaire`) REFERENCES `proprietaire` (`id_proprietaire`);

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`id_oeuvrevente`) REFERENCES `oeuvrevente` (`id_oeuvrevente`),
  ADD CONSTRAINT `reservation_ibfk_2` FOREIGN KEY (`id_adherent`) REFERENCES `adherent` (`id_adherent`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
