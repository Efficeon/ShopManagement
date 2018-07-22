CREATE DATABASE IF NOT EXISTS shop_test;

CREATE TABLE shops (
  id INT NOT NULL,
  shop_title VARCHAR(50),
  PRIMARY KEY (id)
)ENGINE = InnoDB,
  DEFAULT CHARACTER SET  = utf8,
  COLLATE = utf8_general_ci;

CREATE TABLE category (
  id INT NOT NULL,
  category_title VARCHAR(50),
  shops_id INT,
  PRIMARY KEY (id),
  UNIQUE (category_title, shops_id)
)ENGINE = InnoDB,
  DEFAULT CHARACTER SET  = utf8,
  COLLATE = utf8_general_ci;


CREATE TABLE products (
  id INT NOT NULL,
  products_title VARCHAR(50),
  price REAL,
  status VARCHAR(50),
  category_id INT,
  PRIMARY KEY (id)
)ENGINE = InnoDB,
DEFAULT CHARACTER SET  = utf8,
COLLATE = utf8_general_ci;


ALTER TABLE products
ADD CONSTRAINT fk_ProductsCateg
FOREIGN KEY (category_id)
REFERENCES category(id);

ALTER TABLE category
ADD CONSTRAINT fk_CategShop
FOREIGN KEY (shops_id)
REFERENCES shops(id);