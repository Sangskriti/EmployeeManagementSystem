package com.EmployeeManagementSystem.Dao;



import java.util.List;


import com.EmployeeManagementSystem.entities.Attendance;

public interface AttendanceDao {
	
	void addAttendance(Attendance attendance);
    void updateAttendance(Attendance attendance);
    void deleteAttendance(int attendanceID);
    Attendance getAttendanceByID(int attendanceID);
    List<Attendance> getAllAttendances();

}
