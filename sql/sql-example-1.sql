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
VALUES (20, 'Controlling', 41573),
    (21, 'Marketing', 69547),
    (22, 'R&D', 69004),
    (25, 'Production', 38002);
-- retrieve data from table
SELECT *
FROM departments;
-- similar example for employees table
CREATE TABLE IF NOT EXISTS employees (
    employeeId INTEGER PRIMARY KEY,
    employeeName VARCHAR(255),
    departmentId INTEGER
);
INSERT INTO employees (employeeId, employeeName, departmentId)
VALUES (27004, 'A. Einstein', 22),
    (38002, 'H. Ford', 25),
    (41573, 'A. Smith', 20);
SELECT *
FROM employees;