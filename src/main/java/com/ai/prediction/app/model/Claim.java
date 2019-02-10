package com.ai.prediction.app.model;

import java.io.Serializable;
import java.util.UUID;

public class Claim implements Serializable {

	private static final long serialVersionUID = -2578750383190124007L;
	private UUID claimId;
	private String city;
	private String providerName;
	private float claimAmount;
	private boolean provDetailsReq;
	private ClaimType claimType;
	private ServiceType serviceType;
	private float deviation;
	
	
	

	public float getDeviation() {
		return deviation;
	}

	public void setDeviation(float deviation) {
		this.deviation = deviation;
	}

	public UUID getClaimId() {
		return claimId;
	}

	public void setClaimId(UUID claimId) {
		this.claimId = claimId;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public float getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(float claimAmount) {
		this.claimAmount = claimAmount;
	}

	public boolean isProvDetailsReq() {
		return provDetailsReq;
	}

	public void setProvDetailsReq(boolean provDetailsReq) {
		this.provDetailsReq = provDetailsReq;
	}

	

	

	public enum ClaimType {
		Medical, Dental, Pharmacy;
	}

	
	public enum ServiceType {
		Angiography;
	}


	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public ClaimType getClaimType() {
		return claimType;
	}

	public void setClaimType(ClaimType claimType) {
		this.claimType = claimType;
	}

	public ServiceType getServiceType() {
		return serviceType;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	@Override
	public String toString() {
		return "Claim [claimId=" + claimId + ", city=" + city + ", providerName=" + providerName + ", claimAmount="
				+ claimAmount + ", provDetailsReq=" + provDetailsReq + ", claimType=" + claimType + ", serviceType="
				+ serviceType + "]";
	}

	

}
