CREATE TABLE `vagas` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `empresa` varchar(80) NOT NULL,
  `titulo` varchar(80) NOT NULL,
  `descricao` varchar(100) NOT NULL,
  `localizacao` varchar(1) NOT NULL,
  `nivel` varchar(1) NOT NULL,
  PRIMARY KEY (`id`)
);