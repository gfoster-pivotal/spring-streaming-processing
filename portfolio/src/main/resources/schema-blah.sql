-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema stock
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema stock
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `stock` DEFAULT CHARACTER SET latin1 ;
USE `stock` ;

-- -----------------------------------------------------
-- Table `stock`.`customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `stock`.`customer` ;

CREATE TABLE IF NOT EXISTS `stock`.`customer` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `free_cash` DOUBLE NOT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `stock`.`customer_order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `stock`.`customer_order` ;

CREATE TABLE IF NOT EXISTS `stock`.`customer_order` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `num_shares` INT(11) NOT NULL,
  `order_type` VARCHAR(255) NULL DEFAULT NULL,
  `stock_name` VARCHAR(255) NULL DEFAULT NULL,
  `stockprice` DOUBLE NOT NULL,
  `customer_id` BIGINT(20) NOT NULL,
  `customer_orders_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_puwshb8ptuseofvg0vd8iktd5` (`customer_id` ASC),
  INDEX `FK_r7sjus6pyv5j89p3s217xjmat` (`customer_orders_id` ASC),
  CONSTRAINT `FK_r7sjus6pyv5j89p3s217xjmat`
    FOREIGN KEY (`customer_orders_id`)
    REFERENCES `stock`.`customer` (`id`),
  CONSTRAINT `FK_puwshb8ptuseofvg0vd8iktd5`
    FOREIGN KEY (`customer_id`)
    REFERENCES `stock`.`customer` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `stock`.`customer_position`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `stock`.`customer_position` ;

CREATE TABLE IF NOT EXISTS `stock`.`customer_position` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `num_shares` INT(11) NOT NULL,
  `stock_name` VARCHAR(255) NULL DEFAULT NULL,
  `total_position_value` DOUBLE NOT NULL,
  `customer_id` BIGINT(20) NOT NULL,
  `customer_positions_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_r57ev8dnuj760cwsp0g182byp` (`customer_id` ASC),
  INDEX `FK_toly6hvi9l4cf3bfj33a383tm` (`customer_positions_id` ASC),
  CONSTRAINT `FK_toly6hvi9l4cf3bfj33a383tm`
    FOREIGN KEY (`customer_positions_id`)
    REFERENCES `stock`.`customer` (`id`),
  CONSTRAINT `FK_r57ev8dnuj760cwsp0g182byp`
    FOREIGN KEY (`customer_id`)
    REFERENCES `stock`.`customer` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `stock`.`stock`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `stock`.`stock` ;

CREATE TABLE IF NOT EXISTS `stock`.`stock` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `created_timestamp` BIGINT(20) NOT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `price` DOUBLE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 113
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
