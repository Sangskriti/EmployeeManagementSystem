package com.EmployeeManagementSystem.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Salary")
public class Salary {
@Id
@Column(name = "Salary_ID")
private int salaryID;

@ManyToOne
@JoinColumn(name = "Employee_ID")
private Employee employee;

@Column(name = "Amount")
private BigDecimal amount;

@Column(name = "Deductions")
private String deductions;

public int getSalaryID() {
	return salaryID;
}

public void setSalaryID(int salaryID) {
	this.salaryID = salaryID;
}

public Employee getEmployee() {
	return employee;
}

public void setEmployee(Employee employee) {
	this.employee = employee;
}

public BigDecimal getAmount() {
	return amount;
}

public void setAmount(BigDecimal amount) {
	this.amount = amount;
}

public String getDeductions() {
	return deductions;
}

public void setDeductions(String deductions) {
	this.deductions = deductions;
}
}
