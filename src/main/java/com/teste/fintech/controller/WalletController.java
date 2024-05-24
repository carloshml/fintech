package com.teste.fintech.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.teste.fintech.controller.dto.CreateWalletDto;
import com.teste.fintech.entity.Wallet;
import com.teste.fintech.service.WalletService;

import jakarta.validation.Valid;

@RestController
public class WalletController {

	private final WalletService walletService;

	public WalletController(WalletService walletService) {
		this.walletService = walletService;
	}

	@PostMapping("/wallets")
	public ResponseEntity<Wallet> creatWallet(@RequestBody @Valid CreateWalletDto dto) {
		var wallet = walletService.createWallet(dto);
		return ResponseEntity.ok(wallet);
	}
	
	@GetMapping("/wallets")
	public ResponseEntity<List<Wallet>> Get() {
		var resp = walletService.findAll();
		return ResponseEntity.ok(resp); 	 
	}

}
