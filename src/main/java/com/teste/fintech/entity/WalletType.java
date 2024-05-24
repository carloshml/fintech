package com.teste.fintech.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_wallet_type")
public class WalletType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	public WalletType() {
	}
	
	public WalletType(Long id, String description) {
		this.id = id;
		this.description = description;
	} 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public enum  Enum {
		
		USER(1L, "user"),
		MERCHANT(2L, "merchant");		
		
		private Enum(Long id, String description) {
			this.id = id;
			this.description = description;
		} 
		
		private Long id;
		private String description;
		
		public WalletType get() {
			return new WalletType(id, description);
		}
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WalletType other = (WalletType) obj;
		return Objects.equals(description, other.description) && Objects.equals(id, other.id);
	} 
	

}
