package com.app.qr.controller.dto;

import com.app.qr.model.entity.BalanceData;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DataForm {
	
	 @NotBlank(message = "Bank name is required.")
	 private String bankName;
	 
	 @NotBlank(message = "Account holder name is required.")
	 private String accountHolderName;
	 
	 @NotBlank(message = "Account number is required.")
	 private String accountNumber;
	 
	 @NotBlank(message = "Account type is required.")
	 private String accountType;
	 
	 @NotBlank(message = "NRC number is required.")
	 private String nrcNumber;

	 @NotBlank(message = "Address is required.")
	 private String address;

	 @NotBlank(message = "Issue branch is required.")
	 private String issueBranch;
	 
	 @NotNull(message = "Issue date is required.")
	 private String issueDate;
	 
	 @NotNull(message = "Date of balance is required.")
	 private String dateOfBalance;

	 @NotNull(message = "Balance amount is required.")
	 private String balance;
	 
	 @NotBlank(message = "Balance in words is required.")
	 private String balanceInWords;
	 
	 @NotNull(message = "Valid date is required.")
	 private String validDate;
	 
	 public static DataForm from(BalanceData entity) {
		 
		 var data = new DataForm();
		 data.setBankName(entity.getBankName());
		 data.setAccountHolderName(entity.getAccountHolderName());
		 data.setAccountNumber(entity.getAccountNumber());
		 data.setAccountType(entity.getAccountType());
		 data.setNrcNumber(entity.getNrcNumber());
		 data.setAddress(entity.getAddress());
		 data.setIssueBranch(entity.getIssueBranch());
		 data.setIssueDate(entity.getIssueDate());
		 data.setDateOfBalance(entity.getDateOfBalance());
		 data.setBalance(entity.getBalance());
		 data.setBalanceInWords(entity.getBalanceInWords());
		 data.setValidDate(entity.getValidDate());
		 
		 return data;
	 }

}
