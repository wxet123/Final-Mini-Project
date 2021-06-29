package com.team2.model;

public class AddEmpTraining {



	private String employee_id;
	private int training_id;
	
	
	


	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public int getTraining_id() {
		return training_id;
	}
	public void setTraining_id(int training_id) {
		this.training_id = training_id;
	}
	public AddEmpTraining(String employee_id, int training_id) {
		super();
		this.employee_id = employee_id;
		this.training_id = training_id;
	}
	
	
	
}
