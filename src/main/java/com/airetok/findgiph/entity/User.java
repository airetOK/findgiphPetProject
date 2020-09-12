package com.airetok.findgiph.entity;

public class User {
	
	private String gifUrl;
	private String subject;
	private String email;
	private String text;
	
	public User() {
		
	}

	

	public String getText() {
		return text;
	}



	public void setText(String text) {
		this.text = text;
	}



	public String getGifUrl() {
		return gifUrl;
	}



	public void setGifUrl(String gifUrl) {
		this.gifUrl = gifUrl;
	}



	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
