
CREATE DATABASE `ast-sql`;

use `ast-sql`;

CREATE TABLE user
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age  INT
);