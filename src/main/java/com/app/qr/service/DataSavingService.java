package com.app.qr.service;

import java.util.UUID;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.qr.controller.dto.ApiResponse;
import com.app.qr.controller.dto.DataForm;
import com.app.qr.model.entity.BalanceData;
import com.app.qr.model.repo.AccountRepo;
import com.app.qr.model.repo.BalanceDataRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DataSavingService {
	
	private final BalanceDataRepo dataRepo;
	private final AccountRepo accountRepo;
	
	@Transactional
	public ApiResponse save(DataForm form) {
		
		var username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		var account = accountRepo.findById(username).get();
		
			var data = new BalanceData();
		 	data.setBankName(form.getBankName());
		   	data.setAccountHolderName(form.getAccountHolderName());
		    data.setAccountNumber(form.getAccountNumber());
		    data.setAccountType(form.getAccountType());
		    data.setNrcNumber(form.getNrcNumber());
		    data.setAddress(form.getAddress());
		    data.setIssueBranch(form.getIssueBranch());
		    data.setIssueDate(form.getIssueDate());
		    data.setDateOfBalance(form.getDateOfBalance());
		    data.setBalance(form.getBalance());
		    data.setBalanceInWords(form.getBalanceInWords());
		    data.setValidDate(form.getValidDate());
		    
		    data.setPublicToken(UUID.randomUUID().toString());
		    
		    data.setAccount(account);
		    
		    dataRepo.save(data);
		
		return new ApiResponse(true, "data saved", data.getPublicToken());
	}

}
