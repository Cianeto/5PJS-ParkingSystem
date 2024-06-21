-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 21, 2024 at 09:13 PM
-- Server version: 8.3.0
-- PHP Version: 8.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `parking_system_5pjs`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_clientes`
--

DROP TABLE IF EXISTS `tb_clientes`;
CREATE TABLE IF NOT EXISTS `tb_clientes` (
  `cliente_id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `telefone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`cliente_id`),
  UNIQUE KEY `cpf` (`cpf`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tb_reservas`
--

DROP TABLE IF EXISTS `tb_reservas`;
CREATE TABLE IF NOT EXISTS `tb_reservas` (
  `reserva_id` int NOT NULL AUTO_INCREMENT,
  `horarioEntrada` datetime NOT NULL,
  `horarioSaida` datetime NOT NULL,
  `tarifa` decimal(10,2) NOT NULL,
  `reserva_status` enum('AGENDADA','EM_ANDAMENTO','PENDENTE','FINALIZADA') NOT NULL,
  `vaga_id` int NOT NULL,
  `veiculo_id` int NOT NULL,
  PRIMARY KEY (`reserva_id`),
  UNIQUE KEY `veiculo_id` (`veiculo_id`),
  KEY `fk_reserva_vaga` (`vaga_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tb_vagas`
--

DROP TABLE IF EXISTS `tb_vagas`;
CREATE TABLE IF NOT EXISTS `tb_vagas` (
  `vaga_id` int NOT NULL AUTO_INCREMENT,
  `vaga_status` enum('LIVRE','OCUPADA') NOT NULL,
  PRIMARY KEY (`vaga_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tb_veiculos`
--

DROP TABLE IF EXISTS `tb_veiculos`;
CREATE TABLE IF NOT EXISTS `tb_veiculos` (
  `veiculo_id` int NOT NULL AUTO_INCREMENT,
  `modelo` varchar(255) NOT NULL,
  `placa` varchar(7) NOT NULL,
  `porte` varchar(20) NOT NULL,
  `cliente_id` int NOT NULL,
  PRIMARY KEY (`veiculo_id`),
  UNIQUE KEY `placa` (`placa`),
  KEY `fk_veiculo_cliente` (`cliente_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
