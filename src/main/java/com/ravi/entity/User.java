package com.ravi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER_MASTER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	@NotNull(message = "User name shouldn't be null")
	private String userName;
	
	@Email(message = "Invalid Email")
	private String email;
	
	@Pattern(regexp = "^\\d{10}$", message = "Invalid Mobile Number.")
	private String mobile;
	
	private String gender;
	
	@Min(18)
	@Max(60)
	private Integer age;
	
	@NotBlank()
	private String nationality;
	
}
