package com.app.qr.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.qr.controller.dto.ApiResponse;
import com.app.qr.controller.dto.DataForm;
import com.app.qr.model.repo.BalanceDataRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DisplayUserDataService {
	
	private final BalanceDataRepo dataRepo;

	@Transactional(readOnly = true)
	public ApiResponse show(String token) {
	
		return dataRepo.findByPublicToken(token)
	            .map(data -> {
	            	DataForm dto = DataForm.from(data);
					return new ApiResponse(true, "Data found", dto);
	            })
	            .orElseGet(() -> new ApiResponse(false, "Invalid or expired token", null));
	}

}
