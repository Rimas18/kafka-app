-- V1__Create_user_table.sql

CREATE TABLE "user" (
    id SERIAL PRIMARY KEY,
    fullname VARCHAR(255) NOT NULL,
    age INT NOT NULL
);
