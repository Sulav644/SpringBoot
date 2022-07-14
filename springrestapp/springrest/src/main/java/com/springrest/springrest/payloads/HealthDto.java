package com.springrest.springrest.payloads;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class HealthDto {
	
	private int id;
	@NotEmpty
	@Size(min=4, message="Title must be min of 4 chars")
	private String title;
	@NotEmpty
	@Size(min=4, max=10000, message= "Description must be min of 4 and max of 20 chars")
	private String description;
	
	
	public HealthDto(int id, @NotEmpty String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
	}
	public HealthDto() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
