package com.app.qr.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.app.qr.model.entity.Account;
import com.app.qr.model.entity.consts.Role;
import com.app.qr.model.repo.AccountRepo;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@PropertySource(value = "classpath:/admin-user.properties")
public class AdminUserInitializer {
	
	private final AccountRepo accountRepo;
	private final PasswordEncoder passwordEncoder;
	
	@Value("${app.admin.username}")
	private String username;
	@Value("${app.admin.password}")
	private String password;
	
	@PostConstruct
	@Transactional
	public void initialize() {
		
		var admin = new Account();
		admin.setUsename(username);
		admin.setPassword(passwordEncoder.encode(password));
		admin.setRole(Role.ADMIN);
		accountRepo.save(admin);
	}

}
