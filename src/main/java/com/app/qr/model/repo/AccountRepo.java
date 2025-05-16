package com.app.qr.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.qr.model.entity.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, String>{

}
