package com.EmployeeManagementSystem.Dao;


//import com.EmployeeManagementSystem.entities.Salary;
//
//import java.util.List;
//
//public interface SalaryDao {
//    List<Salary> getAllSalaries();
//
//    Salary getSalaryById(int id);
//
//    void saveSalary(Salary salary);
//
//    void updateSalary(Salary salary);
//
//    void deleteSalary(int id);
//}
//
import java.util.List;
import com.EmployeeManagementSystem.entities.Salary;

public interface SalaryDao {
    void addSalary(Salary salary);
    void updateSalary(Salary salary);
    void deleteSalary(int salaryID);
    Salary getSalaryByID(int salaryID);
    List<Salary> getAllSalaries();
}

