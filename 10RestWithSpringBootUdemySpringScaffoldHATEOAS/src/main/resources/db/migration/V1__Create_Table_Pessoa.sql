CREATE TABLE IF NOT EXISTS `tb_pessoa` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `endereco` varchar(100) NOT NULL,
  `primeiro_nome` varchar(80) NOT NULL,
  `sexo` varchar(10) NOT NULL,
  `segundo_nome` varchar(80) NOT NULL,
  PRIMARY KEY (`id`)
) 