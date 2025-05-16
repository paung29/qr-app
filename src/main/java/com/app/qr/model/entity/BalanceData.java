package com.app.qr.model.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class BalanceData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String bankName;
	
	@Column(nullable = false)
	private String accountHolderName;
	
	@Column(nullable = false)
	private String accountNumber;
	
	@Column(nullable = false)
	private String accountType;
	
	@Column(nullable = false)
	private String nrcNumber;
	
	@Column(nullable = false)
	private String address;
	
	@Column(nullable = false)
	private String issueBranch;
	
	@Column(nullable = false)
	private String issueDate;
	
	@Column(nullable = false)
	private String dateOfBalance;
	
	@Column(nullable = false)
	private String balance;
	
	@Column(nullable = false)
	private String balanceInWords;
	
	@Column(nullable = false)
	private String validDate;
	
	@ManyToOne()
	private Account account;
	
	@Column(unique = true, nullable = false, updatable = false)
	private String publicToken = UUID.randomUUID().toString();
	

}
