CREATE SCHEMA IF NOT EXISTS `employees` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `employees` ;

-- -----------------------------------------------------
-- Table `mydb`.`Employees`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `employees`.`Employee` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `date_of_birth` DATE NULL ,
  `surname` VARCHAR(200) NULL ,
  `salary` DOUBLE NULL ,
  `dtype` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB;