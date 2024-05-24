package com.teste.fintech.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_transfer")
public class Transfer {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
 
	@ManyToOne
	@JoinColumn(name = "wallet_sender_id")			
	private Wallet sender;
	
	@ManyToOne
	@JoinColumn(name = "wallet_receiver_id")		
	private Wallet receiver;
	
	@Column(name = "value")
	private BigDecimal value;
	
	@Column(name = "transfer_time")
	private LocalDateTime transferTime;
	
	public Transfer() { 
	} 
	
	public Transfer(Wallet sender, Wallet receiver, BigDecimal value) {	 
		this.sender = sender;
		this.receiver = receiver;
		this.value = value;
		this.transferTime = LocalDateTime.now();
	} 

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Wallet getSender() {
		return sender;
	}

	public void setSender(Wallet sender) {
		this.sender = sender;
	}

	public Wallet getReceiver() {
		return receiver;
	}

	public void setReceiver(Wallet receiver) {
		this.receiver = receiver;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public LocalDateTime getTransferTime() {
		return transferTime;
	}

	public void setTransferTime(LocalDateTime transferTime) {
		this.transferTime = transferTime;
	}
	

}
