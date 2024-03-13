create database employee_details;
use employee_details;

-- Create Employee table
CREATE TABLE Employee (
    EmployeeID INT PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    ContactNumber INT,
    Email VARCHAR(100),
    DepartmentID INT,
    PositionID INT,
    CONSTRAINT fk_Department FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID),
    CONSTRAINT fk_Position FOREIGN KEY (PositionID) REFERENCES Position (PositionID)
);
-- drop table Employee;

-- Create Department table
CREATE TABLE Department (
    DepartmentID INT PRIMARY KEY,
    DepartmentName VARCHAR(50),
    Description VARCHAR(255)
);

-- Create Position table
CREATE TABLE Position (
    PositionID INT PRIMARY KEY,
    Title VARCHAR(50),
    Description VARCHAR(255)
);

-- Create Salary table
CREATE TABLE Salary (
    SalaryID INT PRIMARY KEY,
    EmployeeID INT,
    Amount DECIMAL(10, 2),
    
    Deductions VARCHAR(255),
    CONSTRAINT fk_EmployeeSalary FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID)
);

-- Create Attendance table
CREATE TABLE Attendance (
    AttendanceID INT PRIMARY KEY,
    EmployeeID INT,
    AttendanceDate DATE,
    HoursWorked DECIMAL(5, 2),
    LeaveTaken BOOLEAN,
    CONSTRAINT fk_EmployeeAttendance FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID)
);
-- Create Performance table
CREATE TABLE Performance (
    PerformanceID INT PRIMARY KEY,
    EmployeeID INT,
    ReviewDate DATE,
    PerformanceRating INT,
    Comments VARCHAR(255),
    CONSTRAINT fk_EmployeePerformance FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID)
);
desc attendance;