-- V2__Create_customer_table.sql

CREATE TABLE customer (
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    customer_no VARCHAR(50) NOT NULL,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES "user"(id)
);
