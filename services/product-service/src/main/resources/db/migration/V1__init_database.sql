CREATE TABLE IF NOT EXISTS category (
    id          BIGINT NOT NULL PRIMARY KEY,
    description VARCHAR(255),
    name        VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS product (
    id                 BIGINT NOT NULL PRIMARY KEY,
    available_quantity DOUBLE PRECISION NOT NULL,
    description        VARCHAR(255),
    name               VARCHAR(255),
    price              NUMERIC(38, 2),
    category_id        BIGINT REFERENCES category
);

CREATE SEQUENCE IF NOT EXISTS category_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS product_seq INCREMENT BY 50;

ALTER TABLE category
    ADD COLUMN created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP;

ALTER TABLE category
    ADD COLUMN last_modified_date TIMESTAMP;

ALTER TABLE product
    ADD COLUMN created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP;

ALTER TABLE product
    ADD COLUMN last_modified_date TIMESTAMP;