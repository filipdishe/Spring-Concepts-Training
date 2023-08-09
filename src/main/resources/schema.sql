CREATE SCHEMA IF NOT EXISTS vipschema  AUTHORIZATION filipdishe;

CREATE TABLE "user" (
                        user_id SERIAL NOT NULL PRIMARY KEY,
                        username VARCHAR(50) UNIQUE NOT NULL,
                        password VARCHAR(50),
                        first_name VARCHAR(50),
                        last_name VARCHAR(50),
                        email VARCHAR(255) UNIQUE NOT NULL,
                        creation_date TIMESTAMP NOT NULL,
                        phone_number VARCHAR(50),
                        role_id INT NOT NULL,
                        FOREIGN KEY (role_id) REFERENCES role (role_id)
);

CREATE TABLE role (
                      role_id SERIAL NOT NULL PRIMARY KEY,
                      role_name VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE "order" (
                         order_id SERIAL NOT NULL PRIMARY KEY,
                         to_street VARCHAR(255) NOT NULL,
                         to_city VARCHAR(255) NOT NULL,
                         to_zip INT NOT NULL,
                         order_date TIMESTAMP NOT NULL,
                         user_id INT NOT NULL,
                         FOREIGN KEY (user_id) REFERENCES "user" (user_id)
);

CREATE TYPE sex_type AS ENUM ('male', 'female');

CREATE TABLE product_type (
                              product_type_id SERIAL NOT NULL PRIMARY KEY,
                              sex_type sex_type UNIQUE NOT NULL
);

CREATE TABLE product (
                         product_id SERIAL NOT NULL PRIMARY KEY,
                         product_name VARCHAR(255),
                         description TEXT,
                         price INT NOT NULL,
                         quantity INT NOT NULL,
                         product_type_id INT,
                         FOREIGN KEY (product_type_id) REFERENCES Product_Type(product_type_id)
);

CREATE TABLE product_image (
                               product_image_id SERIAL NOT NULL PRIMARY KEY,
                               image VARCHAR(255),
                               product_id INT NOT NULL,
                               FOREIGN KEY (product_id) REFERENCES Product (product_id)
);

CREATE TABLE order_details (
                            order_details_id SERIAL NOT NULL PRIMARY KEY,
                            order_id         INT NOT NULL,
                            product_id       INT NOT NULL,
                            FOREIGN KEY (order_id) REFERENCES "order" (order_id),
                            FOREIGN KEY (product_id) REFERENCES product (product_id)
);