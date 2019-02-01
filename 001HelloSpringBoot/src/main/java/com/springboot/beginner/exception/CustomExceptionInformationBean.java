package com.springboot.beginner.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomExceptionInformationBean {
	
	private Date errorDate;
	private String errorMessage;
	private String errorDetail;

}
