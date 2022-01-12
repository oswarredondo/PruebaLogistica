/**
 * 
 */
package com.innovargia.ws.bo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.ws.repo.interfase.bo.IReplicaMsgBO;
import com.innovargia.ws.repo.interfase.dao.IMQMensajesPendientesDAO;

/**
 * @author aruaro
 *
 */
@Service
public class ReplicaMsgBO implements IReplicaMsgBO   {
    
    private static final Logger logger = LoggerFactory
		.getLogger(ReplicaMsgBO.class);

    @Autowired
    IMQMensajesPendientesDAO imqMensajesPendientesDAO;

	@Override
	public int insert(String iddocumento, String jsondata, String login, int enviado) throws Exception {
		// TODO Auto-generated method stub
		return imqMensajesPendientesDAO.insert(iddocumento, jsondata, login, enviado);
	}

	@Override
	public void updatePendientes(String uuid) throws Exception {
		// TODO Auto-generated method stub
		imqMensajesPendientesDAO.updatePendientes(uuid);
	}

	@Override
	public void updateEnviado(int enviado, String uuid) throws Exception {
		// TODO Auto-generated method stub
		imqMensajesPendientesDAO.updateEnviado(enviado, uuid);
	}

	@Override
	public void deleteEnviadosEnviado() throws Exception {
		// TODO Auto-generated method stub
		imqMensajesPendientesDAO.deleteEnviadosEnviado();
	}

	@Override
	public void replicaMsg() throws Exception {
		// TODO Auto-generated method stub
		
	}

    
  
}
