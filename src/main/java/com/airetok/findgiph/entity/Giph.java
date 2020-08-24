package com.airetok.findgiph.entity;

public class Giph {
	private String type;
	private String title;
	private String url;
	private String rate;

	
	
	
	public Giph(String type, String title, String url, String rate) {
		super();
		this.type = type;
		this.title = title;
		this.url = url;
		this.rate = rate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	
	
	

}
