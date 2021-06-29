package com.team2.model;

public class CreateTraining {

	private String course_id;
	private String course_title;
	private String description;
	private int status;
	private String date;
	private String startTime;
	private String endTime;
	private String instructor;
	
	
	public CreateTraining(String course_id, String course_title, String description, int status, String date,
			String startTime, String endTime, String instructor) {
		super();
		this.course_id = course_id;
		this.course_title = course_title;
		this.description = description;
		this.status = status;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.instructor = instructor;
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
	public void setCourse_title(String course_title) {
		this.course_title = course_title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	
	
	
	
	
	
	
	
	
	
	 




}
