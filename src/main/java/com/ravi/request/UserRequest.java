package com.ravi.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRequest {

	private String userName;
	private String email;
	private String mobile;
	private String gender;
	private Integer age;
	private String nationality;
}
