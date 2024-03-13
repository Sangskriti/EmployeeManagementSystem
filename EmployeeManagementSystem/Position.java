package com.EmployeeManagementSystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Position")
public class Position {
	
@Id
@Column(name = "Position_ID")
private int positionID;
	
@Column(name = "Title")
private String title;

@Column(name="Description")
private String description;

public int getPositionID() {
	return positionID;
}

public void setPositionID(int positionID) {
	this.positionID = positionID;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}
}

