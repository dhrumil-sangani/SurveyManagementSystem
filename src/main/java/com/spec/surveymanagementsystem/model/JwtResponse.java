package com.spec.surveymanagementsystem.model;

public class JwtResponse {

	private String jwtToken;
	private Object user;
	
	public JwtResponse(String jwtToken, Object user) {
		super();
		this.jwtToken = jwtToken;
		this.user = user;
	}
	public String getJwtToken() {
		return jwtToken;
	}
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	public Object getUser() {
		return user;
	}
	public void setUser(Object user) {
		this.user = user;
	}
}
