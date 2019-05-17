-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 04, 2017 at 02:26 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `contacts`
--

-- --------------------------------------------------------

--
-- Table structure for table `contactlist`
--

CREATE TABLE `contactlist` (
  `Serial_No` int(255) NOT NULL,
  `Contact_Name` varchar(30) NOT NULL,
  `Contact_Number` varchar(15) NOT NULL,
  `Contact_Gender` varchar(6) NOT NULL,
  `Contact_Mail` varchar(64) NOT NULL,
  `Contact_Date_Of_Birth` varchar(20) NOT NULL,
  `Contact_Address` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `contactlist`
--

INSERT INTO `contactlist` (`Serial_No`, `Contact_Name`, `Contact_Number`, `Contact_Gender`, `Contact_Mail`, `Contact_Date_Of_Birth`, `Contact_Address`) VALUES
(1, 'mzsmunna', '01744692979', 'Male', 'mzs.munna@gmail.com', '28.1.95', 'uttara,Dhaka');

-- --------------------------------------------------------

--
-- Table structure for table `recent_log`
--

CREATE TABLE `recent_log` (
  `Recent_Log` varchar(30) NOT NULL,
  `Time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `Serial_No` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `recent_log`
--

INSERT INTO `recent_log` (`Recent_Log`, `Time`, `Serial_No`) VALUES
('1', '2017-05-02 18:00:00', 1),
('12', '2017-05-02 18:00:00', 2),
('4', '2017-05-02 18:00:00', 3),
('2', '2017-05-03 07:55:05', 4),
('01744692979', '2017-05-03 07:56:47', 5),
('0155421218578', '2017-05-03 08:01:42', 6),
('0155421218578', '2017-05-03 12:58:20', 7),
('01744692978', '2017-05-03 13:30:11', 8),
('01744692979', '2017-05-03 13:32:21', 9),
('01', '2017-05-03 13:35:35', 10),
('01744692979', '2017-05-03 14:01:34', 11),
('01744692979', '2017-05-03 14:02:12', 12),
('01722405252', '2017-05-04 09:30:18', 13);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `contactlist`
--
ALTER TABLE `contactlist`
  ADD PRIMARY KEY (`Serial_No`);

--
-- Indexes for table `recent_log`
--
ALTER TABLE `recent_log`
  ADD PRIMARY KEY (`Serial_No`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `contactlist`
--
ALTER TABLE `contactlist`
  MODIFY `Serial_No` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `recent_log`
--
ALTER TABLE `recent_log`
  MODIFY `Serial_No` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
