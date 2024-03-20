package com.EmployeeManagementSystem.Dao;



//import com.EmployeeManagementSystem.entities.Employee;
//
//import java.util.List;
//
//public interface EmployeeDao {
//  List<Employee> getAllEmployees();
//
//  Employee getEmployeeById(int id);
//
//  void saveEmployee(Employee employee);
//
//  void updateEmployee(Employee employee);
//
//  void deleteEmployee(int id);
//}
import java.util.List;
import com.EmployeeManagementSystem.entities.Employee;
import com.EmployeeManagementSystem.entities.Position;
import com.EmployeeManagementSystem.entities.Department; // Import Department entity

public interface EmployeeDao {
  void addEmployee(Employee employee);
  void updateEmployeeName(int eid,String  firstName, String lastName );
  void deleteEmployee(int employeeID);
  void getEmployeeByID(int employeeID);
  List<Employee> getAllEmployees();
  
  // Method to get Position by ID
 
}

