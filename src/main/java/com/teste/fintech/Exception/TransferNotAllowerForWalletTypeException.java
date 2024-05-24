package com.teste.fintech.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class TransferNotAllowerForWalletTypeException extends FintechException {

	public TransferNotAllowerForWalletTypeException() {

	}

	@Override
	public ProblemDetail toProblemDetail() {
		// status 422
		var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
		pb.setTitle("  This wallet type is not allowed to transfer ");

		return pb;
	}

}
