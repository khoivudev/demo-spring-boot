DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
  id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  email VARCHAR(100) UNIQUE
);

INSERT INTO employee (first_name, last_name, email) VALUES
  ('John', 'Doe', 'john.doe@company.com'),
  ('Jane', 'Smith', 'jane.smith@company.com'),
  ('Michael', 'Johnson', 'michael.johnson@company.com');