package com.ravi.exception;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionInfo {
	private String exceptionCode;
	private String exceptionMessage;
	private LocalDate exceptionOccurTime;
}
