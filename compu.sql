-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-08-2017 a las 01:33:52
-- Versión del servidor: 10.1.22-MariaDB
-- Versión de PHP: 7.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `compu`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tecno`
--

CREATE TABLE `tecno` (
  `noSerie` varchar(10) NOT NULL,
  `marca` varchar(30) NOT NULL,
  `modelo` varchar(30) NOT NULL,
  `disco` int(11) NOT NULL,
  `ram` int(11) NOT NULL,
  `procesador` varchar(40) NOT NULL,
  `estado` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tecno`
--
ALTER TABLE `tecno`
  ADD PRIMARY KEY (`noSerie`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
