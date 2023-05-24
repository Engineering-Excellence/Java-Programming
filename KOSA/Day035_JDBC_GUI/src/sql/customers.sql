-- customers.sql

SELECT *
FROM customers;

CREATE TABLE customers
(
    code  NUMBER(4) PRIMARY KEY,
    name  varchar2(30) NOT NULL,
    email varchar2(30),
    phone varchar2(20)
);