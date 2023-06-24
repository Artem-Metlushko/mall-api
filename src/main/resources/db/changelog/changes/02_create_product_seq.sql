--liquibase formatted sql
--changeset your_author_name:01
CREATE TABLE product_seq (

                               sequence_name VARCHAR(255) NOT NULL,
                               next_val BIGINT DEFAULT 0,
                               PRIMARY KEY (sequence_name)
);

--changeset your_author_name:02
INSERT INTO product_seq (sequence_name, next_val)
VALUES ('product_product_id_seq', COALESCE((SELECT MAX(category_id) + 1 FROM category), 0));