DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS members;

-- members Table
CREATE TABLE members (
    user_id VARCHAR(50) NOT NULL PRIMARY KEY,
    pw VARCHAR(68) NOT NULL,
    active BOOLEAN NOT NULL
);

INSERT INTO members(user_id, pw, active) VALUES 
  ('john', '{bcrypt}$2a$10$yXBRnAEMgXhcN6NSs3anS.hjtCpWCMkFdIXBlY6l5Uuz4U7SAdkHO', true),
  ('mary', '{bcrypt}$2a$10$yXBRnAEMgXhcN6NSs3anS.hjtCpWCMkFdIXBlY6l5Uuz4U7SAdkHO', true),
  ('susan', '{bcrypt}$2a$10$yXBRnAEMgXhcN6NSs3anS.hjtCpWCMkFdIXBlY6l5Uuz4U7SAdkHO', true);


-- roles (roles) Table
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