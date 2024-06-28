-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 28, 2024 at 02:11 AM
-- Server version: 8.3.0
-- PHP Version: 8.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "-03:00";


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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tb_reservas`
--

DROP TABLE IF EXISTS `tb_reservas`;
CREATE TABLE IF NOT EXISTS `tb_reservas` (
  `reserva_id` int NOT NULL AUTO_INCREMENT,
  `horario_entrada` datetime NOT NULL,
  `horario_saida` datetime DEFAULT NULL,
  `tarifa` decimal(10,2) DEFAULT NULL,
  `reserva_status` enum('EM_ANDAMENTO','FINALIZADO') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `commentary` varchar(255) DEFAULT NULL,
  `vaga_id` int NOT NULL,
  `veiculo_id` int NOT NULL,
  PRIMARY KEY (`reserva_id`),
  KEY `fk_reserva_vaga` (`vaga_id`),
  KEY `fk_reserva_veiculo` (`veiculo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tb_vagas`
--

DROP TABLE IF EXISTS `tb_vagas`;
CREATE TABLE IF NOT EXISTS `tb_vagas` (
  `vaga_id` int NOT NULL AUTO_INCREMENT,
  `vaga_status` enum('LIVRE','OCUPADO') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'LIVRE',
  PRIMARY KEY (`vaga_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `tb_vagas`
--

INSERT INTO `tb_vagas` (`vaga_id`, `vaga_status`) VALUES
(1, 'LIVRE'),
(2, 'LIVRE'),
(3, 'LIVRE'),
(4, 'LIVRE'),
(5, 'LIVRE'),
(6, 'LIVRE'),
(7, 'LIVRE'),
(8, 'LIVRE'),
(9, 'LIVRE'),
(10, 'LIVRE'),
(11, 'LIVRE'),
(12, 'LIVRE'),
(13, 'LIVRE'),
(14, 'LIVRE'),
(15, 'LIVRE'),
(16, 'LIVRE'),
(17, 'LIVRE'),
(18, 'LIVRE'),
(19, 'LIVRE'),
(20, 'LIVRE'),

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
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tb_reservas`
--
ALTER TABLE `tb_reservas`
  ADD CONSTRAINT `fk_reserva_vaga` FOREIGN KEY (`vaga_id`) REFERENCES `tb_vagas` (`vaga_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_reserva_veiculo` FOREIGN KEY (`veiculo_id`) REFERENCES `tb_veiculos` (`veiculo_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tb_veiculos`
--
ALTER TABLE `tb_veiculos`
  ADD CONSTRAINT `fk_veiculo_cliente` FOREIGN KEY (`cliente_id`) REFERENCES `tb_clientes` (`cliente_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
