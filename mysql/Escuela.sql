-- phpMyAdmin SQL Dump
-- version 4.4.13.1deb1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 01-02-2016 a las 23:13:15
-- Versión del servidor: 5.6.28-0ubuntu0.15.10.1
-- Versión de PHP: 5.6.11-1ubuntu3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `Escuela`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Alumno`
--

CREATE TABLE IF NOT EXISTS `Alumno` (
  `Nombre` varchar(50) NOT NULL,
  `Apellido` varchar(50) NOT NULL,
  `Cedula` int(10) NOT NULL,
  `Edad` int(3) NOT NULL,
  `Peso` float NOT NULL,
  `FechaNacimiento` date NOT NULL,
  `Estatura` float NOT NULL,
  `Grado` varchar(50) NOT NULL,
  `Enfermedades` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `Alumno`
--

INSERT INTO `Alumno` (`Nombre`, `Apellido`, `Cedula`, `Edad`, `Peso`, `FechaNacimiento`, `Estatura`, `Grado`, `Enfermedades`) VALUES
('petra', 'soinforoza', 7234682, 10, 30, '2015-07-08', 0, '3ro A', 'No tiene'),
('Yennifer de Jesus', 'Ramirez Doncel', 17662935, 29, 80, '1986-12-31', 1.68, '2do D', 'No tiene'),
('William Dasda', 'Paez Locura', 19102678, 25, 57.78, '1111-12-04', 1.7, '2do A', 'Puede Tener'),
('yose', 'care', 67890543, 19, 50, '1996-01-20', 1.57, '3', 'no teno');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Alumno`
--
ALTER TABLE `Alumno`
  ADD UNIQUE KEY `Cedula` (`Cedula`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
