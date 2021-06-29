CREATE TABLE `addemptraining` (
  `enrollment_id` int NOT NULL AUTO_INCREMENT,
  `employee_id` int DEFAULT NULL,
  `training_id` int DEFAULT NULL,
  PRIMARY KEY (`enrollment_id`),
  KEY `fk_at_ct_idx` (`training_id`),
  CONSTRAINT `fk_at_ct` FOREIGN KEY (`training_id`) REFERENCES `createtraining` (`training_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `createtraining` (
  `training_id` int NOT NULL AUTO_INCREMENT,
  `course_id` varchar(45) NOT NULL,
  `course_title` varchar(45) NOT NULL,
  `date` date NOT NULL,
  `startTime` varchar(45) NOT NULL,
  `endTime` varchar(45) NOT NULL,
  `instructor` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL,
  `status` tinyint(1) NOT NULL,
  `username` varchar(45) NOT NULL,
  PRIMARY KEY (`training_id`),
  KEY `fk_ct_status_idx` (`status`),
  KEY `fk_ct_employee_idx` (`username`),
  CONSTRAINT `fk_ct_status` FOREIGN KEY (`status`) REFERENCES `status` (`status_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `employee` (
  `employee_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `contact` varchar(45) NOT NULL,
  `isAdmin` bit(1) NOT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `login` (
  `login_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `isAdmin` bit(1) NOT NULL,
  PRIMARY KEY (`login_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `status` (
  `status_id` tinyint NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
