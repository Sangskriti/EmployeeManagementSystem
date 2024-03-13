package com.EmployeeManagementSystem.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Attendance")
public class Attendance {
@Id
@Column(name = "Attendance")
	private int attendanceID;

@ManyToOne
@JoinColumn(name = "Employee_ID")
	private Employee employee;

@Column(name = "AttendanceDate")
	private LocalDate attendanceDate;

@Column(name = "HoursWorked")
	private BigDecimal hoursWorked;

@Column(name = "LeaveTaken")
	private boolean leaveTaken;

public int getAttendanceID() {
	return attendanceID;
}

public void setAttendanceID(int attendanceID) {
	this.attendanceID = attendanceID;
}

public Employee getEmployee() {
	return employee;
}

public void setEmployee(Employee employee) {
	this.employee = employee;
}

public LocalDate getAttendanceDate() {
	return attendanceDate;
}

public void setAttendanceDate(LocalDate attendanceDate) {
	this.attendanceDate = attendanceDate;
}

public BigDecimal getHoursWorked() {
	return hoursWorked;
}

public void setHoursWorked(BigDecimal hoursWorked) {
	this.hoursWorked = hoursWorked;
}

public boolean isLeaveTaken() {
	return leaveTaken;
}

public void setLeaveTaken(boolean leaveTaken) {
	this.leaveTaken = leaveTaken;
}
	

}
