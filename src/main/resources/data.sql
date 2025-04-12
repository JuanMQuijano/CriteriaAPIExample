INSERT INTO customers(name, email) VALUES('Juan Quijano', 'jmquijano@gmail.com');

INSERT INTO category(name) VALUES('Aseo'), ('Entretenimiento');

INSERT INTO product(name, price, category_id) VALUES ('Toothbrush', 12.8, 1), ('Funko Pop', 17.5, 2);

INSERT INTO orders(total_price, customer_id) VALUES(25.6, 1);

INSERT INTO order_products(order_id, product_id) VALUES(1,1), (1,1);
