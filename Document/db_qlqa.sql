-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Dim 27 Mars 2016 à 18:23
-- Version du serveur :  10.1.9-MariaDB
-- Version de PHP :  5.5.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `db_qlqa`
--

-- --------------------------------------------------------

--
-- Structure de la table `ban_an`
--

CREATE TABLE `ban_an` (
  `id` int(11) NOT NULL,
  `songuoitoida` int(11) DEFAULT NULL,
  `tinhtrang` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `ban_an`
--

INSERT INTO `ban_an` (`id`, `songuoitoida`, `tinhtrang`) VALUES
(2, 10, 'con'),
(3, 2, 'trong');

-- --------------------------------------------------------

--
-- Structure de la table `calamviec`
--

CREATE TABLE `calamviec` (
  `id` int(11) NOT NULL,
  `calamviec` enum('sang','chieu','toi') DEFAULT NULL,
  `ngaylamviec` int(11) DEFAULT NULL,
  `tinhtrang` varchar(45) DEFAULT NULL,
  `nhanvienxinphepvang` varchar(45) DEFAULT NULL,
  `nhanvienditre` varchar(45) DEFAULT NULL,
  `chamcong` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `chitiet_hoadon`
--

CREATE TABLE `chitiet_hoadon` (
  `id` int(11) NOT NULL,
  `tenmonan` varchar(45) DEFAULT NULL,
  `soluong` int(11) DEFAULT NULL,
  `gia` float DEFAULT NULL,
  `ngaythang` datetime DEFAULT NULL,
  `ghichu` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `hoadon`
--

CREATE TABLE `hoadon` (
  `id` int(11) NOT NULL,
  `ngaythang` datetime DEFAULT NULL,
  `tongtien` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `mon_an`
--

CREATE TABLE `mon_an` (
  `id` int(11) NOT NULL,
  `tenmonan` varchar(45) DEFAULT NULL,
  `nguyenlieu` varchar(45) DEFAULT NULL,
  `gia` float DEFAULT NULL,
  `tinhtrang` varchar(45) DEFAULT NULL,
  `trangthainguyenlieu` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `mon_an`
--

INSERT INTO `mon_an` (`id`, `tenmonan`, `nguyenlieu`, `gia`, `tinhtrang`, `trangthainguyenlieu`) VALUES
(1, 'ca kho ', 'ca', 50000, 'co', 'con');

-- --------------------------------------------------------

--
-- Structure de la table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `id` int(11) NOT NULL,
  `hoten` varchar(45) DEFAULT NULL,
  `giotinh` varchar(45) DEFAULT NULL,
  `ngaysinh` datetime DEFAULT NULL,
  `dienthoai` int(11) DEFAULT NULL,
  `diachi` varchar(45) DEFAULT NULL,
  `cmnd` int(11) DEFAULT NULL,
  `thoigianbatdau` datetime DEFAULT NULL,
  `trinhdovitinh` varchar(45) DEFAULT NULL,
  `calamviec` varchar(45) DEFAULT NULL,
  `vitri` varchar(45) DEFAULT NULL,
  `nghiviec` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `nhanvien`
--

INSERT INTO `nhanvien` (`id`, `hoten`, `giotinh`, `ngaysinh`, `dienthoai`, `diachi`, `cmnd`, `thoigianbatdau`, `trinhdovitinh`, `calamviec`, `vitri`, `nghiviec`) VALUES
(1, 'Huynh Tam', 'nam', '1991-03-07 00:00:00', 1224925150, 'hcm', 3221413, '2016-03-09 00:00:00', 'van phong', 'sang', 'nhan vien', 'chua');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `username` varchar(11) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `pass` varchar(45) DEFAULT NULL,
  `user_role` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`username`, `email`, `pass`, `user_role`) VALUES
('user', 'infinitylog01@gmail.com', '123456', 2);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `ban_an`
--
ALTER TABLE `ban_an`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`),
  ADD KEY `id_2` (`id`);

--
-- Index pour la table `calamviec`
--
ALTER TABLE `calamviec`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `chitiet_hoadon`
--
ALTER TABLE `chitiet_hoadon`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `mon_an`
--
ALTER TABLE `mon_an`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
