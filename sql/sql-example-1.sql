-- create database and select database for use
CREATE DATABASE IF NOT EXISTS PE2;
USE PE2;
-- create table
CREATE TABLE IF NOT EXISTS departments (
    departmentId INTEGER PRIMARY KEY,
    departmentName VARCHAR(256),
    managerId INTEGER
);
-- add data to the table
INSERT INTO departments (departmentId, departmentName, managerId)
VALUES (20, 'Controlling', 41573);
INSERT INTO departments (departmentId, departmentName, managerId)
VALUES (21, 'Marketing', 69547);
INSERT INTO departments (departmentId, departmentName, managerId)
VALUES (22, 'R&D', 69004);
INSERT INTO departments (departmentId, departmentName, managerId)
VALUES (25, 'Production', 38002);
-- retrieve data from table
SELECT *
FROM departments;