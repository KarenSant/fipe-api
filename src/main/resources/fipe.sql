create database db_fipe_api;

use db_fipe_api;

CREATE TABLE IF NOT EXISTS brands (
    id                      BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    key2 VARCHAR(50),
    country                 VARCHAR(50)
);


CREATE TABLE IF NOT EXISTS models (
	id                      BIGINT PRIMARY KEY AUTO_INCREMENT,
    code varchar(100),
    name varchar(100),
    brand_id BIGINT
);
ALTER TABLE `models` ADD CONSTRAINT `Models_fk0` FOREIGN KEY (`brand_id`) REFERENCES `brands`(`id`);


CREATE TABLE IF NOT EXISTS tb_cars (
    id                      BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    key2 VARCHAR(50),
    brand_id int(50),
    amount int(50),
    category varchar(50)
);

select * from marca inner join modelo on marca.id = modelo.marca_id where marca.name = "Acura";

CREATE TABLE IF NOT EXISTS marca (
	id                      BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    code varchar(25)
);


CREATE TABLE IF NOT EXISTS modelo (
	id                      BIGINT PRIMARY KEY AUTO_INCREMENT,
    code varchar(100),
    name varchar(100),
    marca_id BIGINT
);
ALTER TABLE `modelo` ADD CONSTRAINT `Modelo_fk0` FOREIGN KEY (`marca_id`) REFERENCES `marca`(`id`);





drop table teste;
CREATE TABLE IF NOT EXISTS teste (
	id                      BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    code varchar(25)
);

CREATE TABLE IF NOT EXISTS cars (
    id                      BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    key2 VARCHAR(50),
    brand_id int(50),
    amount int(50),
    category varchar(50)
);


SELECT * FROM db_fipe_api.tb_cars WHERE name LIKE 'c%';

select* from cars where name like '%celta%';

SELECT * FROM db_fipe_api.modelo;
