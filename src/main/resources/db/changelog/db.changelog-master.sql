--liquibase formatted sql

-- ================================================
-- Initial data inserts - safe for existing tables
-- ================================================

-- changeset harsha:1
INSERT INTO customer (name, email)
VALUES ('Sample Customer 1', 'customer1@example.com');

-- changeset harsha:2
INSERT INTO customer (name, email)
VALUES ('Sample Customer 2', 'customer2@example.com');

-- changeset harsha:3
INSERT INTO orders (product, quantity, order_date, customer_id)
VALUES ('Laptop', 1, NOW(), 1);

-- changeset harsha:4
INSERT INTO orders (product, quantity, order_date, customer_id)
VALUES ('Mobile Phone', 2, NOW(), 1);

-- changeset harsha:5
INSERT INTO orders (product, quantity, order_date, customer_id)
VALUES ('Headphones', 1, NOW(), 2);

-- ================================================
-- Future Changeset Example (Schema Change)
-- Will only be added when you actually need it
-- ================================================

-- changeset harsha:6 runOnChange:true
-- Example of future schema evolution
-- ALTER TABLE customer ADD COLUMN phone_number VARCHAR(20);
