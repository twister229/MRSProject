package com.mrs.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "faq")
public class FAQ implements Serializable {

	private static final long serialVersionUID = -7988799579036225137L;

	private int faqID;
	private int symptomID;
	private String title;
	private String question;
	private String answer;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FAQID")
	public int getFaqID() {
		return faqID;
	}
	
	public void setFaqID(int faqID) {
		this.faqID = faqID;
	}

	@Column(name = "SymptomID")
	public int getSymptomID() {
		return symptomID;
	}

	public void setSymptomID(int symptomID) {
		this.symptomID = symptomID;
	}

	@Column(name = "Title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "Question")
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@Column(name = "Answer")
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
