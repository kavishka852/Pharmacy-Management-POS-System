-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 10, 2023 at 10:51 PM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+5:30";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pharmacy`
--

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE `invoice` (
  `id` int(11) NOT NULL,
  `date` varchar(250) DEFAULT NULL,
  `item_list` longtext DEFAULT NULL,
  `total` varchar(250) DEFAULT NULL,
  `pay` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `invoice`
--

INSERT INTO `invoice` (`id`, `date`, `item_list`, `total`, `pay`) VALUES
(1, '2023-07-04 20:00:52', '( Panadol X1 )', '30.0', '0'),
(2, '2023-07-04 20:02:43', '( parasitamolt X1 )', '36.0', '100'),
(3, '2023-07-04 20:04:47', '( ( Panadol X5 )anti X1 )', '1080.0', '5000'),
(4, '2023-08-05 08:00:26', '( ( ( Panadol X1 )Panadol X3 )Panadol X5 )', '75.0', '100'),
(5, '2023-08-05 08:39:27', '( ( Panadol X1 )Panadol X4 )', '60.0', '100'),
(6, '2023-08-05 15:23:57', '( Panadol X4 )', '60.0', '100'),
(7, '2023-08-07 20:30:32', '', '0', '100'),
(8, '2023-08-07 21:42:28', '', '0', '100'),
(9, '2023-08-08 01:38:11', '( fddv X1 )', '20000.0', '50000'),
(10, '2023-08-08 01:40:27', '( fddv X3 )', '30000.0', '500000'),
(11, '2023-08-08 01:43:02', '( fddv X3 )', '30000.0', '500000'),
(12, '2023-08-08 01:45:02', '( fddv X1 )', '10000.0', '20000'),
(13, '2023-08-08 01:50:03', '( fddv X1 )', '10000.0', '10000'),
(14, '2023-08-08 01:51:51', '( ( ( ( fddv X1 )\r\nfddv X3 )\r\nfd X2 )\r\ndf X1 )', '34.0', '50'),
(15, '2023-08-08 01:58:01', '( ( ( ( ( Panadol X1 )dddd X3 )Panadol X1 )dddd X3 )dxdx X3 )', '7668.0', '10000'),
(16, '2023-08-08 10:06:41', '( ( fddv X4 )w23 X3 )', '41062.0', '50000'),
(17, '2023-08-09 14:47:39', '( Panadol X1 )', '15.0', '100'),
(18, '2023-08-10 11:55:31', '( Panadol X3 )', '45.0', '200'),
(19, '2023-08-10 20:00:43', '( Panadol X3 )( df X4 )( fd X3 )( Panadol X3 )( df X4 )( dxdx X2 )', '1877.0', '2000');

-- --------------------------------------------------------

--
-- Table structure for table `manufacturer`
--

CREATE TABLE `manufacturer` (
  `id` int(11) NOT NULL,
  `maid` varchar(25) NOT NULL,
  `name` varchar(250) NOT NULL,
  `address` varchar(250) NOT NULL,
  `phone` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `manufacturer`
--

INSERT INTO `manufacturer` (`id`, `maid`, `name`, `address`, `phone`) VALUES
(6, 'MA002', 'KRW', 'Embilipitiya', '0774422589'),
(5, 'MA001', 'PPW', 'Beliatta', '0714455258'),
(7, 'MA003', 'LGIV', 'Matara', '0714488651'),
(25, 'CO23', 'aaa', 'rrr', '0710868690'),
(9, 'MA005', 'RAW', 'Matara', '0714455214'),
(10, 'MA006', 'KKR', 'Collombo', '0114455254'),
(20, '009', 'www', 'www', 'www'),
(17, '4', 'aaaaa', 'rrr', '0710868690'),
(18, 'emnjb', 'df dfb', 'mnnfd', 'mnd'),
(21, 'e3', 'vvv', 'vv', '111'),
(24, 'aaaa', 'aaaaabbbb', 'matara', '0710868690');

-- --------------------------------------------------------

--
-- Table structure for table `medicine`
--

CREATE TABLE `medicine` (
  `id` int(11) NOT NULL,
  `mid` varchar(25) NOT NULL,
  `mname` varchar(250) NOT NULL,
  `price` varchar(100) NOT NULL,
  `quantity` varchar(100) NOT NULL,
  `dosage` varchar(250) NOT NULL,
  `purchus` date DEFAULT NULL,
  `dtype` varchar(250) NOT NULL,
  `dweight` varchar(250) NOT NULL,
  `expdate` datetime NOT NULL,
  `manufacturer` varchar(250) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `medicine`
--

INSERT INTO `medicine` (`id`, `mid`, `mname`, `price`, `quantity`, `dosage`, `purchus`, `dtype`, `dweight`, `expdate`, `manufacturer`) VALUES
(32, '111', 'fddv', '10000', '2', 'Syrups', '2023-08-04', 'g', '123', '2023-08-05 00:00:00', 'prashasthi'),
(31, '11111', 'fd', '10000', '7', 'Syrups', '2023-08-04', '-Select-', '123', '2023-08-05 00:00:00', 'prashasthi'),
(30, 'dfer', 'df', '34', '-6', 'Ointments', '2023-08-04', '-Select-', '100', '2023-07-01 00:00:00', 'prashasthi'),
(41, 'w223', 'w23', '354', '0', 'Ointments', '2023-08-04', '-Select-', '45', '2023-07-01 00:00:00', 'Sisitha'),
(9, 'w2', 'w2', '35', '3', 'Ointments', '2023-07-30', '-Select-', '45', '2023-07-01 00:00:00', 'Sisitha'),
(29, 'w22', 'w233', '354', '3', 'Ointments', '2023-08-04', 'mg', '45f', '2023-07-01 00:00:00', 'KRW'),
(17, 'mk21', 'vgvg', '500', '50', 'Syrups', '2023-08-03', 'mg', '50', '2026-08-07 00:00:00', 'Roshan'),
(28, 'mk2s', 'vgvg', '500', '50', 'Syrups', '2023-08-04', 'mg', '50', '2026-08-07 00:00:00', 'Roshan'),
(15, 'dd', 'dxdx', '230', '195', 'Creams', '2023-08-01', 'g', '20', '2024-08-24 00:00:00', 'Sisitha'),
(22, '0099', 'www', '13', '1', 'Creams', '2023-08-04', 'ml', '100', '2023-08-18 00:00:00', 'prashasthi'),
(21, '008', 'www', '13', '1', 'Creams', '2023-08-04', 'ml', '100', '2023-08-18 00:00:00', 'prashasthi'),
(27, '009', 'fucke', '12', '100', 'Creams', '2023-08-04', 'g', '23', '2023-08-05 00:00:00', 'Sisitha'),
(25, 'dff', 'df', '34', '3', 'Ointments', '2023-08-04', 'g', '45', '2023-07-01 00:00:00', 'prashasthi'),
(26, '000', 'fuck', '12', '100', 'Creams', '2023-08-04', 'g', '23', '2023-08-05 00:00:00', 'Sisitha'),
(34, '1', 'fd', '3410000', '12', 'Syrups', '2023-08-04', 'g', '123', '2023-08-05 00:00:00', 'prashasthi'),
(35, '32', 'Panadol', '15', '-9', 'Tablets', '2023-08-04', '-Select-', '23', '2025-07-17 00:00:00', 'prashasthi'),
(36, '333', 'fdvv', '10000', '12', 'Syrups', '2023-08-04', 'g', '123', '2023-08-05 00:00:00', 'prashasthi'),
(37, 'dfd', 'df', '34', '3', 'Ointments', '2023-08-04', '-Select-', '34', '2021-07-17 00:00:00', 'prashasthi'),
(38, 'dfee', 'dfdd2', '34', '3', 'Ointments', '2023-08-04', 'g', '23f', '2022-07-09 00:00:00', 'KRW'),
(39, 'dferd', 'df', '9876', '3', 'Ointments', '2023-08-04', '-Select-', '100', '2023-07-01 00:00:00', 'prashasthi'),
(40, 'dferef', 'df', '34', '40', 'Ointments', '2023-08-04', '-Select-', '100', '2023-07-01 00:00:00', 'prashasthi'),
(42, '122', 'dddd', '2321', '15', 'Ointments', '2023-08-04', '-Select-', '2', '2023-08-10 00:00:00', 'prashasthi'),
(45, 'dferee', 'df', '343', '3', 'Ointments', '2023-08-04', 'g', '100', '2023-07-01 00:00:00', 'prashasthi'),
(46, 'bhghg', 'dfrdrrd', '234', '60', 'Capsules', '2023-08-04', 'g', '40', '2023-08-18 00:00:00', 'prashasthi'),
(50, 'inoth', 'inoth', '1234', '1234', 'Creams', '2023-08-04', 'g', '123', '2023-08-19 00:00:00', 'KRW'),
(51, '431231', 'test123', '4000', '20', 'Syrups', '2023-08-05', 'ml', '250', '2023-09-28 00:00:00', 'df dfb');

-- --------------------------------------------------------

--
-- Table structure for table `story`
--

CREATE TABLE `story` (
  `StoryID` int(10) UNSIGNED NOT NULL,
  `StoryName` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `uid` int(10) NOT NULL,
  `u_fname` varchar(50) NOT NULL,
  `u_lname` varchar(50) NOT NULL,
  `u_uname` varchar(50) NOT NULL,
  `u_pass` varchar(64) NOT NULL,
  `u_bdate` date NOT NULL,
  `u_address` varchar(100) NOT NULL,
  `u_type` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`uid`, `u_fname`, `u_lname`, `u_uname`, `u_pass`, `u_bdate`, `u_address`, `u_type`) VALUES
(15, 'inoth', 'vishwajith', 'inoth', 'eccdc0108f26a44e42570a0be12ca5292a81d2936ea335d068f8d5cfaf214c77', '2023-08-24', 'matara', 'Admin'),
(19, 'fraddy', 'appolo', 'fraddytm', 'a4584e33b75d6398b36ddd16768ab1fe17efb5ecf3d390dc9c6c96ac5b725c92', '2001-01-28', 'sdadadad', 'Admin'),
(20, 'fraddy2', 'appolo2', 'fraddytm2', 'a4584e33b75d6398b36ddd16768ab1fe17efb5ecf3d390dc9c6c96ac5b725c92', '2001-01-28', 'sdadad', 'Employee');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `manufacturer`
--
ALTER TABLE `manufacturer`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- Indexes for table `medicine`
--
ALTER TABLE `medicine`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `story`
--
ALTER TABLE `story`
  ADD PRIMARY KEY (`StoryID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`uid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `invoice`
--
ALTER TABLE `invoice`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `manufacturer`
--
ALTER TABLE `manufacturer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `medicine`
--
ALTER TABLE `medicine`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT for table `story`
--
ALTER TABLE `story`
  MODIFY `StoryID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `uid` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
