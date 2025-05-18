package com.app.qr.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.qr.controller.dto.ApiResponse;
import com.app.qr.controller.dto.LoginForm;
import com.app.qr.model.entity.Account;
import com.app.qr.model.repo.AccountRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {
	
	private final AccountRepo accountRepo;
	private final PasswordEncoder passwordEncoder;
	
	@Transactional(readOnly = true)
	public ApiResponse login(LoginForm form) {
		
		var isAccountExist = accountRepo.existsById(form.getUsername());

		if(!isAccountExist) {
			return new ApiResponse(false, "account doesn't exist", null);
		}
		
		Account account = accountRepo.findById(form.getUsername()).get();
		
		boolean isPasswordCorrect =  passwordEncoder.matches(form.getPassword(), account.getPassword());
		
		if(!isPasswordCorrect) {
			return new ApiResponse(false, "worng password", null);
		}
		
		return new ApiResponse(true, "authentication success", null);
	}

}
