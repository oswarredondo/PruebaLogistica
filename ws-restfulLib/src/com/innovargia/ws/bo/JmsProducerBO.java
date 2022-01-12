package com.innovargia.ws.bo;

import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service
public class JmsProducerBO {

	private static final Logger logger = LoggerFactory.getLogger(JmsProducerBO.class);

	private JmsTemplate jmsTemplate;

	@Autowired
	
	public void envoyerMessage() {
		jmsTemplate.send(new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				return session.createTextMessage("Message " + new Date());
			}
		});
	}

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(final JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void sendMessage(final String texto) {

		try {
			jmsTemplate.send(new MessageCreator() {

				@Override
				public Message createMessage(Session session) throws JMSException {
					// TODO Auto-generated method stub
					return session.createTextMessage(texto);
				}
			});
		} catch (Exception e) {
			logger.error("Error:" + e.getMessage());
		}

	}
}