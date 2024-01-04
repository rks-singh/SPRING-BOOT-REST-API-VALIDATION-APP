package com.ravi.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserResponse {

	private Integer userId;
	private String userName;
	private String email;
	private String mobile;
	private String gender;
	private Integer age;
	private String nationality;
}
