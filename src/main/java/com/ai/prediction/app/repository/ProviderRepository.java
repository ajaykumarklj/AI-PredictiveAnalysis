package com.ai.prediction.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ai.prediction.app.model.Provider;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {
	
	List<Provider> findByProvId(String providerId);

}
