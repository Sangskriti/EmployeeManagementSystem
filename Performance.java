package com.EmployeeManagementSystem.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Performance")

public class Performance {
@Id
@Column(name = "Performance_ID")
	private int performanceID;

@ManyToOne
@JoinColumn(name = "Employee_ID")
	private Employee employee;

@Column(name = "Review_Date")
	private LocalDate reviewDate;

@Column(name = "Performance_Rating")
	private int performanceRating;

@Column(name = "Comments")
	private String comments;

public int getPerformanceID() {
	return performanceID;
}

public void setPerformanceID(int performanceID) {
	this.performanceID = performanceID;
}

public Employee getEmployee() {
	return employee;
}

public void setEmployee(Employee employee) {
	this.employee = employee;
}

public LocalDate getReviewDate() {
	return reviewDate;
}

public void setReviewDate(LocalDate reviewDate) {
	this.reviewDate = reviewDate;
}

public int getPerformanceRating() {
	return performanceRating;
}

public void setPerformanceRating(int performanceRating) {
	this.performanceRating = performanceRating;
}

public String getComments() {
	return comments;
}

public void setComments(String comments) {
	this.comments = comments;
}
	

}
