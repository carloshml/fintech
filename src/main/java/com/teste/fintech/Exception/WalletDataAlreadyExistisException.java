package com.teste.fintech.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class WalletDataAlreadyExistisException extends FintechException {
	
	
	private String detail;

	public WalletDataAlreadyExistisException(String detail) {
		this.detail = detail;
	}

	@Override
	public ProblemDetail toProblemDetail() {
		// status 422
		var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
		pb.setTitle(" Wallet Data Existis");
		pb.setDetail(this.detail);
		return pb;
	}

}
