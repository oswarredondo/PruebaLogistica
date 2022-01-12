/**
 * 
 */
package com.innovargia.mail;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.innovargia.utils.UtilsStrings;

/**
 * @author aruaro
 *
 */
public class SendEMail {
    private static final Logger logger = LoggerFactory
	    .getLogger(SendEMail.class);
    /**
     * 
     */
    public static void send(String subjec,List<String> lista_email, String body,
	    EmailProperties email_propiedades, String from) {
	EmailProperties send_email = new EmailProperties();
	send_email.setSubject(subjec);
	for (String email : lista_email) {
	    if (UtilsStrings.isEmail(email)) {
		    send_email.addTo_Address(email);
		} else {
		    logger.debug("Cuenta invalida de correo de "
			    + email);
		}
	}

	if (send_email.arr_To_Address.size() <= 0) {
	    return;
	}
	// send_email.addTo_AddressCC(request.getParameter("concopia"));
	send_email.setBody(body);

	// Complementa la informacion de las propiedades del correo
	
	email_propiedades.setHTMLFormat(true);
	// Obtiene el correo de quien envia
	send_email.setMail_from(from);

	HTMLMail mail = new HTMLMail(email_propiedades);

	try {
	    mail.sendMail(false, email_propiedades.isWithDebug(), "Avisos");
	} catch (Exception e) {
	    logger.debug("Error en el envio de correo  "
		    + e.getMessage());
	    
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    
	  
	}

    }
    
    

}
