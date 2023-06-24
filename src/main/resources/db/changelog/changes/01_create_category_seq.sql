--liquibase formatted sql
--changeset your_author_name:01
CREATE TABLE category_seq (
                              sequence_name VARCHAR(255) NOT NULL,
                              next_val BIGINT DEFAULT 0, -- Set default value as 0
                              PRIMARY KEY (sequence_name)
);

--changeset your_author_name:02
INSERT INTO category_seq (sequence_name, next_val)
VALUES ('category_category_id_seq', COALESCE((SELECT MAX(category_id) + 1 FROM category), 0)); -- Use COALESCE to handle null value
