package com.innovargia.salesmanager.bo.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.mail.EmailProperties;
import com.innovargia.mail.HTMLMail;
import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.dtos.TareaDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.ITareasBO;
import com.innovargia.salesmanager.idao.IAdicionalesDAO;
import com.innovargia.salesmanager.idao.IParametrosSistemaDAO;
import com.innovargia.salesmanager.idao.ITareasDAO;
import com.innovargia.salesmanager.idao.IUsuarioDAO;
import com.innovargia.utils.ConstantesAdminSale;
import com.innovargia.utils.UtilsStrings;

@Service
public class TareasBO implements ITareasBO {

    private static final Logger logger = LoggerFactory
	    .getLogger(TareasBO.class);

    @Autowired
    ITareasDAO iTareasDAO;
    @Autowired
    IUsuarioDAO iUsuarioDAO;
    @Autowired
    IParametrosSistemaDAO iParametrosSistemaDAO;

    public TareasBO() {
	// TODO Auto-generated constructor stub
    }

    @Override
    public Number insert(TareaDTO catalogo) throws Exception {

	if ("USUARIO".equals(catalogo.getAmbito())) {
	    catalogo.setIdusuarioresponsable(catalogo.getIdambitotarea());
	}
	// //tarea.setIdusuarioresponsable(idusuarioresponsable);
	Number idtarea = iTareasDAO.insert(catalogo);
	if (catalogo.getIdtareaorigina() == -1) {
	    catalogo.setIdtarea(idtarea.intValue());
	    catalogo.setIdtareaorigina(idtarea.intValue());
	    // Actualiza los datos de la tarea con el mismo identificador de la
	    // tarea original
	    iTareasDAO.update(catalogo);
	}

	// Verifica si se deben enviar correos
	enviaCorreo(catalogo);

	return idtarea;
    }

    /**
     * Envia correo a todos los usuarios involucrados en la notificacion
     * 
     * @param tarea
     */
    private void enviaCorreo(TareaDTO tarea) {
	// Verifica si se envia correo
	try {

	    List<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();
	    UsuarioDTO usuario = new UsuarioDTO();
	    if ("USUARIO".equals(tarea.getAmbito())) {
		tarea.setIdusuarioresponsable(tarea.getIdambitotarea());
		usuario.setLogin(tarea.getIdusuarioresponsable());
		lista = iUsuarioDAO.getUsuariosConLogin(usuario);
	    } else if ("NIVEL".equals(tarea.getAmbito())) {
		usuario.setNivelPuesto(tarea.getIdambitotarea());
		lista = iUsuarioDAO.getUsuariosConNivel(usuario);
	    } else if ("GRUPO".equals(tarea.getAmbito())) {
		usuario.setIdagrupamiento(tarea.getIdambitotarea());
		lista = iUsuarioDAO.getUsuariosConGrupo(usuario);
	    } else if ("TODOS".equals(tarea.getAmbito())) {
		lista = iUsuarioDAO.getTodosLosUsuarios(true);
	    }
	    //Agrega los responsables de las tareas
	    for (UsuarioDTO usuarioDTO : lista) {
		tarea.setIdusuarioresponsable(usuarioDTO.getLogin());
		iTareasDAO.insertResponsable(tarea);
	    }
	    if (tarea.isEnviarcorreo()) {

		EmailProperties send_email = new EmailProperties();
		send_email.setSubject(tarea.getImportancia() + ":"
			+ tarea.getTipo() + ", " + tarea.getTitulo());
		for (UsuarioDTO usuarioDTO : lista) {
		    if ((usuarioDTO.getEmail() != null)
			    && (usuarioDTO.getEmail().trim().length() > 0)) {
			if (UtilsStrings.isEmail(usuarioDTO.getEmail())) {
			    send_email.addTo_Address(usuarioDTO.getEmail());
			} else {
			    logger.debug("Cuenta invalida de correo de "
				    + usuarioDTO.getLogin());
			}

		    } else {
			logger.debug("Cuenta invalida de correo de "
				+ usuarioDTO.getLogin());
		    }
		}

		if (send_email.arr_To_Address.size() <= 0) {
		    return;
		}
		// send_email.addTo_AddressCC(request.getParameter("concopia"));
		send_email.setBody(tarea.getSolicitud());

		// Complementa la informacion de las propiedades del correo
		EmailProperties email_propiedades = iParametrosSistemaDAO
			.getPropiedadesEmail(send_email,
				ConstantesAdminSale.ID_APP_MAIL);
		email_propiedades.setHTMLFormat(true);
		// Obtiene el correo de quien envia
		send_email.setMail_from(iParametrosSistemaDAO
			.getValorPropiedad("mail.send.from",
				ConstantesAdminSale.ID_APP_MAIL));

		HTMLMail mail = new HTMLMail(email_propiedades);

		mail.sendMail(false, email_propiedades.isWithDebug(), "Avisos");

	    }
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    logger.debug("Error:" + e.getMessage());
	}
    }

    @Override
    public void update(TareaDTO catalogo) throws Exception {
	iTareasDAO.update(catalogo);

	// Verifica si se deben enviar correos
	enviaCorreo(catalogo);

    }

    @Override
    public void updateEstatus(TareaDTO catalogo) throws Exception {
	iTareasDAO.updateEstatus(catalogo);

    }

    @Override
    public void delete(TareaDTO catalogo) throws Exception {
	iTareasDAO.delete(catalogo);

    }

    @Override
    public List<TareaDTO> getExistentes() throws Exception {
	// TODO Auto-generated method stub
	return iTareasDAO.getExistentes();
    }

    @Override
    public List<TareaDTO> getAsignadasAlUsuario(UsuarioDTO usuario)
	    throws Exception {
	// TODO Auto-generated method stub
	return iTareasDAO.getAsignadasAlUsuario(usuario);
    }

    @Override
    public List<TareaDTO> getCreadasPorElUsuario(UsuarioDTO usuario)
	    throws Exception {
	// TODO Auto-generated method stub
	return iTareasDAO.getCreadasPorElUsuario(usuario);
    }

    @Override
    public List<TareaDTO> getTareasAsociadas(TareaDTO tarea) throws Exception {
	// TODO Auto-generated method stub
	return iTareasDAO.getTareasAsociadas(tarea);
    }

    @Override
    public TareaDTO get(TareaDTO catalogo) throws Exception {
	// TODO Auto-generated method stub
	return iTareasDAO.get(catalogo);
    }

    @Override
    public List<TareaDTO> getCreadasPorElUsuarioDeUnTipo(UsuarioDTO usuario,
	    String tipo) throws Exception {
	// TODO Auto-generated method stub
	return iTareasDAO.getCreadasPorElUsuarioDeUnTipo(usuario, tipo);
    }

}
