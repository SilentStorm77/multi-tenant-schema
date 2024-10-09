CREATE SCHEMA LaLiga;
CREATE SCHEMA Association;

CREATE TABLE Association.Manager (
    manager_name VARCHAR(255) PRIMARY KEY
);

CREATE TABLE PL.Manager (
    manager_name VARCHAR(255) PRIMARY KEY
);

CREATE TABLE PL.Team (
    team_name VARCHAR(255) PRIMARY KEY,
    city VARCHAR(255) NOT NULL,
    manager_name VARCHAR(255) NOT NULL,
    FOREIGN KEY (manager_name) REFERENCES Association.Manager(manager_name)
);

CREATE TABLE LaLiga.Team (
    team_name VARCHAR(255) PRIMARY KEY,
    city VARCHAR(255) NOT NULL,
    manager_name VARCHAR(255) NOT NULL,
    FOREIGN KEY (manager_name) REFERENCES Association.Manager(manager_name)
);