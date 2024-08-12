-- create role table
CREATE TABLE IF NOT EXISTS TAG (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100),
    insert_date TIMESTAMP,
    update_date TIMESTAMP,
    version INT
);