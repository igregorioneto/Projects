CREATE TABLE `candidatos` (
  `id` bigint AUTO_INCREMENT PRIMARY KEY,
  `nome` longtext,
  `profissao` varchar(80) NOT NULL,
  `localizacao` varchar(1) NOT NULL,
  `nivel` varchar(1) NOT NULL
);
