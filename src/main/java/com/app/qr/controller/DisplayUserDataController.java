package com.app.qr.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.qr.controller.dto.ApiResponse;
import com.app.qr.controller.dto.DataForm;
import com.app.qr.service.DisplayUserDataService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("advice")
public class DisplayUserDataController {
	
	private final DisplayUserDataService service;
	
	@GetMapping("document/{token}")
	private ResponseEntity<ApiResponse> show(@PathVariable String token){
		
		
	ApiResponse response = service.show(token);
		
	HttpStatus status = response.isSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
	
	return ResponseEntity.status(status).body(response);

	}

}
