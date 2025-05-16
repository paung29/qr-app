package com.app.qr.model.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.qr.model.entity.BalanceData;

@Repository
public interface BalanceDataRepo extends JpaRepository<BalanceData, Long>{

	Optional<BalanceData> findByPublicToken(String token);

}
