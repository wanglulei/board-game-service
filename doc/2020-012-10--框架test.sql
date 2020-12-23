CREATE TABLE `t_json` (
  `id` int NOT NULL,
  `sname` varchar(20) DEFAULT NULL,
  `info` json DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

