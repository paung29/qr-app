package com.app.qr.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.qr.controller.dto.ApiResponse;
import com.app.qr.controller.dto.LoginForm;
import com.app.qr.service.LoginService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("login")
@RequiredArgsConstructor
public class LoginController {
	
	private final LoginService loginService;
	
	@PostMapping
	private ResponseEntity<ApiResponse> login(
			@Validated @RequestBody LoginForm form,
			BindingResult result){
		
		if(result.hasErrors()) {
			return ResponseEntity.badRequest()
					.body(new ApiResponse(false, "Validation failed",null));
		}
		
		ApiResponse response = loginService.login(form);
		HttpStatus status = response.isSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
		
		return ResponseEntity.status(status).body(response);
	}

}
