package com.ai.prediction.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ai.prediction.app.model.Claim.ServiceType;
import com.ai.prediction.app.model.ClaimAmountPerService;

@Repository
public interface ClaimAmountPerServiceRepository extends JpaRepository<ClaimAmountPerService, Long> {

	List<ClaimAmountPerService> findByCityAndServiceName(String city, String serviceName);

	List<ClaimAmountPerService> findByCityAndServiceName(String city, ServiceType angiography);

}
