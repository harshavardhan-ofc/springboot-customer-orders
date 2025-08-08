--liquibase formatted sql

--changeset harsha:insert-user-1
INSERT INTO customer ( name, email) VALUES ( 'Lakshmi Narayan', 'lakshmi.narayan@example.com');
