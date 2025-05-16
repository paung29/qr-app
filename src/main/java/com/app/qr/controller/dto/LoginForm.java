package com.app.qr.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginForm {

	@NotBlank(message = "invalid username")
	private String username;
	@NotBlank(message = "invalid password")
	private String password;
}
