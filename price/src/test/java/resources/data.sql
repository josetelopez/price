DELETE FROM price;
DELETE FROM product;
DELETE FROM brand;

INSERT INTO brand (id, name) VALUES (1, 'ZARA');

INSERT INTO product (id, name) VALUES (35455, 'Shirt');

INSERT INTO PRICE (brand_id, start_date, end_date, price_list, product_id, priority, price, curr) VALUES (1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 1, 35455, 0, 35.50, 'EUR');
INSERT INTO PRICE (brand_id, start_date, end_date, price_list, product_id, priority, price, curr) VALUES (1, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 2, 35455, 1, 25.45, 'EUR');
INSERT INTO PRICE (brand_id, start_date, end_date, price_list, product_id, priority, price, curr) VALUES (1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 3, 35455, 1, 30.50, 'EUR');
INSERT INTO PRICE (brand_id, start_date, end_date, price_list, product_id, priority, price, curr) VALUES (1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 3, 35455, 1, 30.50, 'EUR');

