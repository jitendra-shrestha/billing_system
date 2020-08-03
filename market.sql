-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 25, 2019 at 02:01 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `market`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `c_id` int(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  `discount` varchar(5) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`c_id`, `name`, `discount`) VALUES
(1, 'cosmetics', '0.05'),
(2, 'groceries', '0.05'),
(3, 'sanitary', '0.02'),
(7, 'shoes', '0.0'),
(8, 'mobile', '0.05'),
(9, 'Cold drinks', '0.0'),
(10, 'Hard drinks', '0.0'),
(11, 'Furniture', '0.2');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `p_id` int(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` varchar(5) NOT NULL,
  `stock` varchar(50) NOT NULL,
  `barcode` varchar(255) NOT NULL,
  `manufacturer` varchar(255) NOT NULL,
  `c_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`p_id`, `name`, `price`, `stock`, `barcode`, `manufacturer`, `c_id`) VALUES
(1, 'toothpaste', '60', '7.0', '1001', 'colgate', 3),
(2, 'waiwai', '20', '23.0', '2001', 'chaudhary group', 2),
(3, 'facewash', '200', '-1.0', '3001', 'emami', 1),
(18, 'apple', '120', '19', '2002', 'china', 2),
(21, 'Fanta', '30', '400', '4444', 'COCACOLA', 9),
(22, 'Vodka', '300', '100', '7890', 'Vodka', 10),
(23, 'Redmi Note 7', '30000', '100', '0001', 'Mi', 8),
(24, 'Chair', '1000', '50', '55555', 'Ply', 11),
(25, 'Iphone11', '50000', '100', '3244', 'Apple', 8),
(26, 'Nike', '2300', '200', '3241', 'NIKE', 7),
(27, 'Sprite', '30', '299.0', '3333', 'Cocacola', 9),
(28, 'Samsung galaxy', '15000', '100', '1222', 'Samsung', 8),
(29, 'Kitkat', '50', '100', '1234', 'Chocolate', 2),
(31, 'oil', '100', '100', '11111', 'Surya', 2);

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `s_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `quantity` double NOT NULL,
  `category` varchar(255) NOT NULL,
  `cashier` varchar(255) NOT NULL,
  `amount` double NOT NULL,
  `discount` double NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`s_id`, `name`, `quantity`, `category`, `cashier`, `amount`, `discount`, `date`) VALUES
(1, 'toothpaste', 1, 'sanitary', 'suraj', 58.8, 1.2, '2019-11-21'),
(2, 'waiwai', 2, 'groceries', 'suraj', 38, 2, '2019-11-21'),
(3, 'facewash', 2, 'cosmetics', 'sujata', 360, 40, '2019-11-21'),
(4, 'toothpaste', 5, 'sanitary', 'sujata', 294, 6, '2019-11-21'),
(5, 'toothpaste', 1, 'sanitary', 'sujata', 58.8, 1.2, '2019-11-21'),
(6, 'waiwai', 1, 'groceries', 'sujata', 19, 1, '2019-11-21'),
(7, 'facewash', 1, 'cosmetics', 'sujata', 180, 20, '2019-11-21'),
(8, 'toothpaste', 2, 'sanitary', 'sujata', 117.6, 2.4, '2019-11-21'),
(9, 'waiwai', 1, 'groceries', 'suraj', 19, 1, '2019-11-21'),
(10, 'facewash', 1, 'cosmetics', 'sujata', 180, 20, '2019-11-21'),
(11, 'toothpaste', 1, 'sanitary', 'suraj', 58.8, 1.2, '2019-11-21'),
(12, 'toothpaste', 1, 'sanitary', 'suraj', 58.8, 1.2, '2019-11-21'),
(13, 'waiwai', 2, 'groceries', 'suraj', 38, 2, '2019-11-21'),
(14, 'toothpaste', 2, 'sanitary', 'suraj', 117.6, 2.4, '2019-11-21'),
(15, 'toothpaste', 3, 'sanitary', 'suraj', 176.4, 3.6, '2019-11-22'),
(16, 'waiwai', 1, 'groceries', 'suraj', 19, 1, '2019-11-22'),
(17, 'toothpaste', 1, 'sanitary', 'xnite', 58.8, 1.2, '2019-11-22'),
(18, 'waiwai', 1, 'groceries', 'xnite', 19, 1, '2019-11-22'),
(19, 'coke', 20, 'groceries', 'xnite', 950, 50, '2019-11-22'),
(20, 'coke', 1, 'groceries', 'xnite', 47.5, 2.5, '2019-11-22'),
(21, 'coke', 10, 'groceries', 'ajay', 475, 25, '2019-11-22'),
(22, 'waiwai', 5, 'groceries', 'ajay', 95, 5, '2019-11-22'),
(23, 'toothpaste', 5, 'sanitary', 'ajay', 294, 6, '2019-11-22'),
(24, 'toothpaste', 1, 'sanitary', 'suraj', 58.8, 1.2, '2019-11-22'),
(25, 'waiwai', 2, 'groceries', 'ajay', 38, 2, '2019-11-22'),
(26, 'facewash', 1, 'cosmetics', 'ajay', 190, 10, '2019-11-22'),
(27, 'toothpaste', 1, 'sanitary', 'ajay', 58.8, 1.2, '2019-11-22'),
(28, 'facewash', 1, 'cosmetics', 'ajay', 190, 10, '2019-11-23'),
(29, 'Sprite', 1, 'Cold drinks', 'suraj', 30, 0, '2019-11-23'),
(30, 'waiwai', 2, 'groceries', 'suraj', 190, 10, '2019-11-23'),
(31, 'facewash', 5, 'cosmetics', 'suraj', 190, 10, '2019-11-23');

-- --------------------------------------------------------

--
-- Table structure for table `temp`
--

CREATE TABLE `temp` (
  `temp_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `rate` varchar(255) NOT NULL,
  `category` varchar(255) NOT NULL,
  `barcode` varchar(255) NOT NULL,
  `quantity` double NOT NULL,
  `amount` double NOT NULL,
  `discount` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `u_id` int(10) NOT NULL,
  `firstname` varchar(20) NOT NULL,
  `lastname` varchar(20) NOT NULL,
  `address` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phoneno` varchar(10) NOT NULL,
  `type` varchar(20) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `designation` varchar(20) NOT NULL,
  `shift` varchar(20) NOT NULL,
  `status` int(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`u_id`, `firstname`, `lastname`, `address`, `email`, `phoneno`, `type`, `username`, `password`, `designation`, `shift`, `status`) VALUES
(1, 'jitendra', 'shrestha', 'bungmati', 'tjiten123@gmail.com', '9843359842', 'admin', 'jiten', 'jiten', 'manager', 'day', 1),
(2, 'suraj', 'maharjan', 'thecho', 'suraj@gmail.com', '9843414733', 'cashier', 'suraj', 'suraj', 'cashier', 'morning', 1),
(3, 'sujata', 'limbu', 'putalisadak', 'sujata@gmail.com', '9812345678', 'cashier', 'sujata', 'sujata', 'cashier', 'day', 1),
(4, 'nitesh', 'kc', 'kapan', 'niteshkc21@gmail.com', '980275881', 'cashier', 'xnite', 'xnite', 'cashier', 'evening', 1),
(5, 'Ajay', 'Prajapati', 'bhaktapur', 'ajpjpt@gmail.com', '9860013864', 'cashier', 'ajay', 'ajay', 'cashier', 'morning', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`c_id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`p_id`),
  ADD UNIQUE KEY `barcode` (`barcode`),
  ADD UNIQUE KEY `name` (`name`),
  ADD KEY `c_id` (`c_id`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`s_id`);

--
-- Indexes for table `temp`
--
ALTER TABLE `temp`
  ADD PRIMARY KEY (`temp_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `c_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `p_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `sales`
--
ALTER TABLE `sales`
  MODIFY `s_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `temp`
--
ALTER TABLE `temp`
  MODIFY `temp_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `u_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`c_id`) REFERENCES `category` (`c_id`),
  ADD CONSTRAINT `product_ibfk_2` FOREIGN KEY (`c_id`) REFERENCES `category` (`c_id`),
  ADD CONSTRAINT `product_ibfk_3` FOREIGN KEY (`c_id`) REFERENCES `category` (`c_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
