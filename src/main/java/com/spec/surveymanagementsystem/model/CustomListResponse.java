package com.spec.surveymanagementsystem.model;

import java.util.List;

public class CustomListResponse<T> {
	private int status;
    private String message;
    private List<T> data;
    
    
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
