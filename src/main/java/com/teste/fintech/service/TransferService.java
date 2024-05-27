package com.teste.fintech.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;

import com.teste.fintech.Exception.TransferNotAllowerForWalletTypeException;
import com.teste.fintech.Exception.TrasnferNotAuthorizedException;
import com.teste.fintech.Exception.InsufitientBalanceException;
import com.teste.fintech.Exception.WalletNotFoundxception;
import com.teste.fintech.controller.dto.TransferDto;
import com.teste.fintech.entity.Transfer;
import com.teste.fintech.entity.Wallet;
import com.teste.fintech.repository.TransferRepository;
import com.teste.fintech.repository.WalletRepository;

import jakarta.transaction.Transactional;


@Service
public class TransferService {

	public final AuthorizationService authorizationService;
	public final NotificationService notificationService;
	public final TransferRepository transferRepository;
	public final WalletRepository walletRepository;

	public TransferService(AuthorizationService authorizationService, NotificationService notificationService,
			TransferRepository trasnferRepository, WalletRepository walletRepository) {
		this.authorizationService = authorizationService;
		this.notificationService = notificationService;
		this.transferRepository = trasnferRepository;
		this.walletRepository = walletRepository;
	}

	// @Transactional para garantir que o commit no banco só será feito se não
	// ocorrer nenhuma exceção
	@Transactional
	public Transfer transfer(TransferDto transferDto) {
		var sender = walletRepository.findById(transferDto.payer())
				.orElseThrow(() -> new WalletNotFoundxception(transferDto.payer()));
		var receiver = walletRepository.findById(transferDto.payee())
				.orElseThrow(() -> new WalletNotFoundxception(transferDto.payee()));
		validateTransfer(transferDto, sender);
		sender.debit(transferDto.value());
		receiver.credit(transferDto.value());
		var transfer = new Transfer(sender, receiver, transferDto.value());
		walletRepository.save(sender);
		walletRepository.save(receiver);
		var transferResult = transferRepository.save(transfer);

		CompletableFuture.runAsync(() -> {
			notificationService.sendNotification(transferResult);
		});

		return transferResult;
	}

	private void validateTransfer(TransferDto transferDto, Wallet sender) {

		if (!sender.isTransferAllawedForWalletType()) {
			throw new TransferNotAllowerForWalletTypeException();
		}

		if (!sender.isBalanceGreaterOrEqualThan(transferDto.value())) {
			throw new InsufitientBalanceException(transferDto.value());
		}

		if (!authorizationService.isAuthorized(transferDto)) {
			throw new TrasnferNotAuthorizedException();
		}

	}

	public  List<Transfer> findAll() { 
		return transferRepository.findAll();
	}

}
