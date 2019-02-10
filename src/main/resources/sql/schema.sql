DROP TABLE IF EXISTS members_diary;

CREATE TABLE IF NOT EXISTS members_diary(
  id SERIAL PRIMARY KEY,
  name VARCHAR NOT NULL,
  birthday DATE NOT NULL ,
  blood_type VARCHAR NOT NULL,
  address VARCHAR NOT NULL
);