package com.pnb.systematics.interaction;

import javax.xml.bind.annotation.XmlElement;


public abstract class InteractionBase {
	
	private int id;
	private String username;
	private String password;

	
	@XmlElement(required = true)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@XmlElement(required = true)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@XmlElement(required = true)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}