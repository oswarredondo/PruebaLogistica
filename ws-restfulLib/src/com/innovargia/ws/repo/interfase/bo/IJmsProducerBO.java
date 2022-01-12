package com.innovargia.ws.repo.interfase.bo;

import org.springframework.jms.core.JmsTemplate;

public interface IJmsProducerBO {

	public void envoyerMessage() ;
	public void sendMessage(String mensaje) ;
	public JmsTemplate getJmsTemplate() ;
	public void setJmsTemplate(final JmsTemplate jmsTemplate);

}