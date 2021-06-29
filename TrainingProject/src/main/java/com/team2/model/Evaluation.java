package com.team2.model;

import java.io.Serializable;

public class Evaluation implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int evaluation_id;
	private String question_one, question_two, question_three,
	question_four,question_five, comments;
	private String evaluationStatus;
	
	
	
	public Evaluation(String question_one, String question_two, String question_three, String question_four,
			String question_five, String comments, String evaluationStatus) {
		super();
		this.question_one = question_one;
		this.question_two = question_two;
		this.question_three = question_three;
		this.question_four = question_four;
		this.question_five = question_five;
		this.comments = comments;
		this.evaluationStatus = evaluationStatus;
	}
	
	public Evaluation(int evaluation_id, String question_one, String question_two, String question_three,
			String question_four, String question_five, String comments, String evaluationStatus) {
		super();
		this.evaluation_id = evaluation_id;
		this.question_one = question_one;
		this.question_two = question_two;
		this.question_three = question_three;
		this.question_four = question_four;
		this.question_five = question_five;
		this.comments = comments;
		this.evaluationStatus = evaluationStatus;
	}
	public int getEvaluation_id() {
		return evaluation_id;
	}
	public String getQuestion_one() {
		return question_one;
	}
	public void setQuestion_one(String question_one) {
		this.question_one = question_one;
	}
	public String getQuestion_two() {
		return question_two;
	}
	public void setQuestion_two(String question_two) {
		this.question_two = question_two;
	}
	public String getQuestion_three() {
		return question_three;
	}
	public void setQuestion_three(String question_three) {
		this.question_three = question_three;
	}
	public String getQuestion_four() {
		return question_four;
	}
	public void setQuestion_four(String question_four) {
		this.question_four = question_four;
	}
	public String getQuestion_five() {
		return question_five;
	}
	public void setQuestion_five(String question_five) {
		this.question_five = question_five;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getEvaluationStatus() {
		return evaluationStatus;
	}

	public void setEvaluationStatus(String evaluationStatus) {
		this.evaluationStatus = evaluationStatus;
	}

	
}
