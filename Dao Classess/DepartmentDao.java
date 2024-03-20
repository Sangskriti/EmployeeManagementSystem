package com.EmployeeManagementSystem.Dao;


import java.util.List;


import com.EmployeeManagementSystem.entities.Department;



public interface DepartmentDao {
	void addDepartment(Department department);
    void updateDepartment(Department department);
    void deleteDepartment(int departmentID);
    Department getDepartmentByID(int departmentID);
    List<Department> getAllDepartments();

}

