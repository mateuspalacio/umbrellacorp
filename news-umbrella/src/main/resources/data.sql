SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema bd_pas
-- -----------------------------------------------------

-- LIMPAR TUDO --
DROP TABLE IF EXISTS `subscription`;
DROP TABLE IF EXISTS `image`;
DROP TABLE IF EXISTS `news`;
DROP TABLE IF EXISTS `category`;

-- -----------------------------------------------------
-- Table `category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `news`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `news` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `text` VARCHAR(5000) NOT NULL,
  `title` VARCHAR(500) NOT NULL,
  `category_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_news_category1_idx` (`category_id` ASC),
  CONSTRAINT `fk_news_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `image`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `image` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `source` VARCHAR(255) NOT NULL,
  `news_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_image_news_idx` (`news_id` ASC),
  CONSTRAINT `image_fk_news_id`
    FOREIGN KEY (`news_id`)
    REFERENCES `news` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `subscription`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `subscription` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_email` VARCHAR(255) NOT NULL,
  `category_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_subscription_category1_idx` (`category_id` ASC),
  CONSTRAINT `subscription_fk_category_id`
    FOREIGN KEY (`category_id`)
    REFERENCES `category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- INSERIR DADOS

--		 CATEGORY		*/ -- (id, "name")
INSERT INTO category VALUES (1, "NBA");
INSERT INTO category VALUES (2, "NFL");

--		   NEWS			*/ -- (id, "text", "title", "category_id")
INSERT INTO news VALUES (1, "Texto de uma noticia", "Titulo de uma noticia", 1);
INSERT INTO news VALUES (2, "Texto de uma noticia1232", "Titulo de uma noticia", 1);
INSERT INTO news VALUES (3, "Texto de uma noticia55", "Titulo de uma noticia", 1);
INSERT INTO news VALUES (4, "Texto de uma noticia3", "Titulo de uma noticia", 2);
INSERT INTO news VALUES (5, "Texto de uma noticia2", "Titulo de uma noticia", 2);

--		   IMAGE		*/ -- (id, "source", news_id)
INSERT INTO image VALUES (1, "http://google.com", 1);
INSERT INTO image VALUES (2, "http://unifor.br", 4);
INSERT INTO image VALUES (3, "http://imagemdogoogle.com", 4);
INSERT INTO image VALUES (4, "http://algumacoisa.com", 4);

--		SUBSCRIPTION 	*/ -- (id, "user_email", category_id)
INSERT INTO subscription VALUES (1, "mateuspalacio@gmail.com", 1);
INSERT INTO subscription VALUES (2, "stevestarkffxiv@gmail.com", 1);
INSERT INTO subscription VALUES (3, "mateus@gmail.com", 2);
INSERT INTO subscription VALUES (4, "rodrigo@gmail.com", 2);
INSERT INTO subscription VALUES (5, "todosnos@gmail.com", 2);