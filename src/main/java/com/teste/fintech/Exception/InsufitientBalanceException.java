package com.teste.fintech.Exception;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class InsufitientBalanceException extends FintechException {

	private BigDecimal value;

	public InsufitientBalanceException(BigDecimal value) {
		this.value = value;
	}

	@Override
	public ProblemDetail toProblemDetail() {
		// status 422
		var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
		pb.setTitle("Insufitioent Balance, transfer is not allowed to transfer ");
		pb.setDetail(" You can not transfer a value greater than  your balance ");
		return pb;
	}

}