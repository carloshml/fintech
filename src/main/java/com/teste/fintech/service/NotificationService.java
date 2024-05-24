package com.teste.fintech.service;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.teste.fintech.Exception.FintechException;
import com.teste.fintech.client.AuthorizationClient;
import com.teste.fintech.client.NotificationClient;
import com.teste.fintech.entity.Transfer;

@Service
public class NotificationService {

	private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

	private final NotificationClient notificationClient;

	public NotificationService(NotificationClient n) {
		this.notificationClient = n;
	}

	public void sendNotification(Transfer transfer) {

		try {
			logger.info("Sending notification");
			var resp = notificationClient.sendNotification(transfer);
			
			if(resp.getStatusCode().isError()) {
				logger.error("Error while sending notification, status code is not OK");
			}
			
		} catch (Exception e) {
			logger.error("Error while sending notification", e);
		}
 
	}

}
