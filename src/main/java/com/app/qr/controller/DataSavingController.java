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
import com.app.qr.controller.dto.DataForm;
import com.app.qr.service.DataSavingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("admin")
@RequiredArgsConstructor
public class DataSavingController {

	private final DataSavingService dataSavingService;
	
	@PostMapping
	private ResponseEntity<ApiResponse> login(
			@Validated @RequestBody DataForm form,
			BindingResult result){
		
		if(result.hasErrors()) {
			return ResponseEntity.badRequest()
					.body(new ApiResponse(false, "Validation failed",null));
		}
		
	ApiResponse response = dataSavingService.save(form);
		
	HttpStatus status = response.isSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
	
	return ResponseEntity.status(status).body(response);

	}
	
}
