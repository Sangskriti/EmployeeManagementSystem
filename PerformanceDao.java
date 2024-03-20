package com.EmployeeManagementSystem.Dao;

//import com.EmployeeManagementSystem.entities.Performance;
//
//import java.util.List;
//
//public interface PerformanceDao {
//    List<Performance> getAllPerformances();
//
//    Performance getPerformanceById(int id);
//
//    void savePerformance(Performance performance);
//
//    void updatePerformance(Performance performance);
//
//    void deletePerformance(int id);
//}

import java.util.List;
import com.EmployeeManagementSystem.entities.Performance;

public interface PerformanceDao {
    void addPerformance(Performance performance);
    void updatePerformance(Performance performance);
    void deletePerformance(int performanceID);
    Performance getPerformanceByID(int performanceID);
    List<Performance> getAllPerformances();
}