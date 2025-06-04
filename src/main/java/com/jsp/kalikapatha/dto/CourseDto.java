package com.jsp.kalikapatha.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CourseDto {
	@Size(min=5,max = 100, message = "* Title should be 5~100 characters")
	private String title;
	@Size(min=10,max = 500, message = "* Title should be 10~500 characters")
	private String description;
	@NotNull(message = "* select Any one")
	private boolean paid;

}
