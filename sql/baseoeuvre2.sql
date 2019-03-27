-- --------------------------------------------------------
--
-- Structure de la table `emprunt`
--

CREATE TABLE `emprunt` (
  `id_oeuvrepret` int(10) UNSIGNED NOT NULL,
  `id_adherent` int(10) UNSIGNED NOT NULL,
  `date_reservation` date NOT NULL,
  `statut` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Index pour les tables déchargées
--

--
-- Index pour la table `emprunt`
--
ALTER TABLE `emprunt`
  ADD PRIMARY KEY (`id_oeuvrepret`,`id_adherent`),
  ADD KEY `id_adherent` (`id_adherent`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `emprunt`
--
ALTER TABLE `emprunt`
  ADD CONSTRAINT `emprunt_ibfk_1` FOREIGN KEY (`id_oeuvrepret`) REFERENCES `id_oeuvrepret` (`id_oeuvrepret`),
  ADD CONSTRAINT `emprunt_ibfk_2` FOREIGN KEY (`id_adherent`) REFERENCES `adherent` (`id_adherent`);
COMMIT;