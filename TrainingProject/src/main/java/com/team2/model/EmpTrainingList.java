package com.team2.model;

public class EmpTrainingList {
	protected String course_id;
	protected String course_title;
	protected String status;
	protected String date;
	protected int dateNumber;
	protected String dayName;
	protected String month;
	protected String startTime;
	protected String endTime;
	protected String instructor;
	protected String description;
	protected int training_id;
	
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}


	public String getDayName() {
		return dayName;
	}

	public int getTraining_id() {
		return training_id;
	}

	public void setTraining_id(int count) {
		this.training_id = count;
	}

	public void setDayName(String dayName) {
		this.dayName = dayName;
	}

	public int getDateNumber() {
		return dateNumber;
	}

	public void setDateNumber(int dateNumber) {
		this.dateNumber = dateNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public String getCourse_title() {
		return course_title;
	}

	public EmpTrainingList(String course_id, String course_title, String status, String date, int dateNumber,
			String dayName, String startTime, String endTime, String instructor, String description, int training_id, String month2) {
		super();
		this.course_id = course_id;
		this.course_title = course_title;
		this.status = status;
		this.date = date;
		this.dateNumber = dateNumber;
		this.dayName = dayName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.instructor = instructor;
		this.description = description;
		this.training_id = training_id;
	}

	public void setCourse_title(String course_name) {
		this.course_title = course_name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
