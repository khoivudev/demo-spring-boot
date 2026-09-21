DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS members;

-- Users Table
CREATE TABLE members (
    user_id VARCHAR(50) NOT NULL PRIMARY KEY,
    pw VARCHAR(68) NOT NULL,
    active BOOLEAN NOT NULL
);

INSERT INTO members(user_id, pw, active) VALUES 
  ('john', '{bcrypt}$2a$10$NvsV3xv9AsL9TK3pcfa2guudKCQ7NAStLeU3uQZ56ojsj5a75hBkK', true),
  ('mary', '{bcrypt}$2a$10$QSLgi/c92LaMB7nQyotK4uDBIYeHMmcydnuv0hz.mYwFo99WWQyHq', true),
  ('susan', '{bcrypt}$2a$10$QSLgi/c92LaMB7nQyotK4uDBIYeHMmcydnuv0hz.mYwFo99WWQyHq', true);


-- Authorities (Roles) Table
CREATE TABLE roles (
    user_id VARCHAR(50) NOT NULL,
    role VARCHAR(50) NOT NULL,
    CONSTRAINT fk_roles_members FOREIGN KEY (user_id) REFERENCES members(user_id)
);

-- Ensure a user doesn't have duplicate roles assigned
CREATE UNIQUE INDEX ix_auth_user_id ON roles (user_id, role);

INSERT INTO roles(user_id, role)  VALUES
  ('john', 'ROLE_EMPLOYEE'),
  ('mary', 'ROLE_EMPLOYEE'),
  ('mary', 'ROLE_MANAGER'),
  ('susan', 'ROLE_EMPLOYEE'),
  ('susan', 'ROLE_MANAGER'),
  ('susan', 'ROLE_ADMIN');