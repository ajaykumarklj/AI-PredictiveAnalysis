package com.ai.prediction.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="claim_amount_per_service")
public class ClaimAmountPerService {
	
		@Id
		@GeneratedValue
		private long id;
		
		@Column(name="city")
		private String city;
		
		@Column(name="service_name")
		private String serviceName;
		
		@Column(name="claim_amount")
		private float claimAmount;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getServiceName() {
			return serviceName;
		}

		public void setServiceName(String serviceName) {
			this.serviceName = serviceName;
		}

		public float getClaimAmount() {
			return claimAmount;
		}

		public void setClaimAmount(float claimAmount) {
			this.claimAmount = claimAmount;
		}
		
		

}
