package com.app.qr.model.entity;

import java.util.List;

import com.app.qr.model.entity.consts.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Account {
	
	@Id
	private String usename;
	
	@Column(nullable = false)
	private Role role;
	
	@Column(nullable = false)
	private String password;
	
	@OneToMany(mappedBy = "account")
	private List<BalanceData> balanceData;

}
