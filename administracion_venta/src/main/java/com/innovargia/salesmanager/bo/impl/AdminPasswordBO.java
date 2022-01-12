package com.innovargia.salesmanager.bo.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.ibo.IAdminPasswordBO;
import com.innovargia.salesmanager.idao.IAdminPasswordDAO;
import com.innovargia.utils.AESEncriptacion;
import com.innovargia.utils.PasswordValidator;

@Service
public class AdminPasswordBO implements IAdminPasswordBO {

	private static final Logger logger = LoggerFactory.getLogger(AdminPasswordBO.class);

	@Autowired
	IAdminPasswordDAO iAdminPasswordDAO;

	@Override
	public void insertBitacoraAcceso(String login, String modulo, String password) throws Exception {
		PasswordValidator validator = PasswordValidator.buildValidator(PasswordValidator.ForceSpecialChar,
				PasswordValidator.ForceCapitalLetter, PasswordValidator.ForceLowerLetter, PasswordValidator.ForceNumber,
				PasswordValidator.MinLength, PasswordValidator.MaxLength);

		// String password_encode= validator.cifrarBase64(password);
		String password_encode = AESEncriptacion.encryptText(password);
		password = "";  //No guarda historial
		iAdminPasswordDAO.insertBitacoraAcceso(login.toUpperCase().trim(), modulo, password_encode);

	}

	@Override
	public void insertHistorial(String login, String password, String estado) throws Exception {
		PasswordValidator validator = PasswordValidator.buildValidator(PasswordValidator.ForceSpecialChar,
				PasswordValidator.ForceCapitalLetter, PasswordValidator.ForceLowerLetter, PasswordValidator.ForceNumber,
				PasswordValidator.MinLength, PasswordValidator.MaxLength);

		// String password_encode= validator.cifrarBase64(password);
		String password_encode = AESEncriptacion.encryptText(password);
		iAdminPasswordDAO.insertHistorial(login.toUpperCase().trim(), password_encode, estado);

	}

	@Override
	public boolean existeLoginPass(String login, String password) throws Exception {
		PasswordValidator validator = PasswordValidator.buildValidator(PasswordValidator.ForceSpecialChar,
				PasswordValidator.ForceCapitalLetter, PasswordValidator.ForceLowerLetter, PasswordValidator.ForceNumber,
				PasswordValidator.MinLength, PasswordValidator.MaxLength);

		// String password_encode= validator.cifrarBase64(password);
		String password_encode = AESEncriptacion.encryptText(password);
		return iAdminPasswordDAO.existeLoginPass(login.toUpperCase().trim(), password_encode);
	}

	@Override
	public void cambiaEstatus() throws Exception {

		logger.debug("Cambiando estatus de contraseñas");
		iAdminPasswordDAO.cambiaEstatus();

	}

	@Override
	public String estadoLoginPass(String login, String password) throws Exception {
		PasswordValidator validator = PasswordValidator.buildValidator(PasswordValidator.ForceSpecialChar,
				PasswordValidator.ForceCapitalLetter, PasswordValidator.ForceLowerLetter, PasswordValidator.ForceNumber,
				PasswordValidator.MinLength, PasswordValidator.MaxLength);

		// String password_encode= validator.cifrarBase64(password);
		String password_encode = AESEncriptacion.encryptText(password);
		return iAdminPasswordDAO.estadoLoginPass(login.toUpperCase().trim(), password_encode);
	}

}
