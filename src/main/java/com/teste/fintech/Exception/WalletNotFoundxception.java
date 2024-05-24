package com.teste.fintech.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class WalletNotFoundxception extends   FintechException {

	private Long walletId;

	public WalletNotFoundxception(Long walletId) {
		this.walletId = walletId;
	}

	@Override
	public ProblemDetail toProblemDetail() {
		// status 422
		var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
		pb.setTitle(" Wallet Not  Found");
		pb.setDetail("There is not wallet with the id " + this.walletId);
		return pb;
	}

}
