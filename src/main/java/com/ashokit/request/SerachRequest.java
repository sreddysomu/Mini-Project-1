package com.ashokit.request;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SerachRequest {
	
	private String planName;
	private String planStatus;
	private String gender;
	private String startDate;
	private String endDate;

}
