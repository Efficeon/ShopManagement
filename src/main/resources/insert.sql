INSERT INTO shop_test.shops (id, shop_title) VALUES (1, 'PepitoMarket');
INSERT INTO shop_test.shops (id, shop_title) VALUES (2, 'MiniMarket');

INSERT INTO shop_test.category (id, category_title,shops_id) VALUES (1, 'milk products', 1);
INSERT INTO shop_test.category (id, category_title,shops_id) VALUES (2, 'vegetables', 1);
INSERT INTO shop_test.category (id, category_title,shops_id) VALUES (3, 'alcohol', 2);
INSERT INTO shop_test.category (id, category_title,shops_id) VALUES (4, 'bakery products', 2);

INSERT INTO shop_test.products (id, products_title,price,status, category_id) VALUES (1,'Milk',1000,'Available', 1);
INSERT INTO shop_test.products (id, products_title,price,status, category_id) VALUES (2,'Cheese',500,'Available', 1);
INSERT INTO shop_test.products (id, products_title,price,status, category_id) VALUES (3,'Sour cream',750,'Available', 1);

INSERT INTO shop_test.products (id, products_title,price,status, category_id) VALUES (4,'Potatoes',20,'Available', 2);
INSERT INTO shop_test.products (id, products_title,price,status, category_id) VALUES (5,'Cucumber',12,'Available', 2);
INSERT INTO shop_test.products (id, products_title,price,status, category_id) VALUES (6,'Parsley',33,'Available', 2);

INSERT INTO shop_test.products (id, products_title,price,status, category_id) VALUES (7,'Bintang',55,'Available', 3);
INSERT INTO shop_test.products (id, products_title,price,status, category_id) VALUES (8,'BaliBear',15,'Available', 3);
INSERT INTO shop_test.products (id, products_title,price,status, category_id) VALUES (9,'Martini',140,'Available', 3);

INSERT INTO shop_test.products (id, products_title,price,status, category_id) VALUES (10,'Croissant',85,'Available', 4);
INSERT INTO shop_test.products (id, products_title,price,status, category_id) VALUES (11,'Long loaf',67,'Available', 4);
INSERT INTO shop_test.products (id, products_title,price,status, category_id) VALUES (12,'Biscuit',160,'Available', 4);

