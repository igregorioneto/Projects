CREATE TABLE `vaga_candidato` (
  `id` bigint AUTO_INCREMENT PRIMARY KEY,
  `vaga_id` bigint NOT NULL,
  `candidato_id` bigint NOT NULL,
  `score` INT NOT NULL
);
