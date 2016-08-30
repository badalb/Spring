CREATE TABLE account(id int(11) NOT NULL AUTO_INCREMENT,username varchar(45) DEFAULT NULL,amount int(11) DEFAULT NULL,PRIMARY KEY (id)););
                 
CREATE TABLE products(id int(11) NOT NULL,name varchar(45) DEFAULT NULL,price int(11) DEFAULT NULL,stock int(11) DEFAULT NULL,PRIMARY KEY (id));

INSERT INTO account (username, amount) VALUES ('user1', 2000); 
INSERT INTO account (username, amount) VALUES ('user2', 4000); 
INSERT INTO account (username, amount) VALUES ('user3', 1300);
INSERT INTO products (id, name, price, stock) VALUES (101, 'Product A', 100, 20); 
INSERT INTO products(id, name, price, stock) VALUES (102, 'Product B', 200, 25); 