package com.teste.fintech.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class TrasnferNotAuthorizedException extends FintechException {

	public TrasnferNotAuthorizedException() {
	}

	@Override
	public ProblemDetail toProblemDetail() {
		// status 422
		var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
		pb.setTitle("Transfer Not Authorized");
		pb.setDetail("Server not authorized the transfer");
		return pb;
	}

}
