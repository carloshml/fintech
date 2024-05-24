package com.teste.fintech.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.teste.fintech.controller.dto.TransferDto;
import com.teste.fintech.entity.Transfer;
import com.teste.fintech.service.TransferService;

import jakarta.validation.Valid;

@RestController
public class TransferController {

	private final TransferService transferService;

	public TransferController(TransferService transferService) {
		this.transferService = transferService;
	}

	@PostMapping("/transfer")
	public ResponseEntity<Transfer> transfer(@RequestBody @Valid TransferDto dto) {
		var resp = transferService.transfer(dto);
		return ResponseEntity.ok(resp);
	}

}
