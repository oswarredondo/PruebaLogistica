package com.tracusa.logistica.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.tracusa.logistica.model.Usuario;

@Controller
@RequestMapping("/rest/members")
public class MemberRestController {

	private static final Logger logger = LoggerFactory.getLogger(UsuarioRestController.class);

	@RequestMapping(value = "/insert", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> insert(@RequestBody Usuario usuario) throws Exception {

		JsonObject joResult = new JsonObject();

		int aux = 0;

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		try {

			logger.info("Start insert user.");
			logger.debug("Nombre de usuario:" + usuario.getUserName());

			aux = 0;

			joResult.addProperty("code", aux >= 1 ? "201" : "200");

			joResult.addProperty("info",
					aux >= 1 ? "El usuario ya se encuntra registrado" : "Usuario registrado con exito");

			return new ResponseEntity<>(joResult.toString(), HttpStatus.OK);

		} catch (DataAccessException dae) {
			if (dae.getMessage() == null) {
				joResult.addProperty("code", 400);
				joResult.addProperty("message", "Bad Request");
				return new ResponseEntity<>(joResult.toString(), HttpStatus.BAD_REQUEST);
			} else {
				joResult.addProperty("code", 201);
				joResult.addProperty("message", dae.getMessage());
			}
			return new ResponseEntity<>(joResult.toString(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/changePassword", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> changePassword(@RequestBody Usuario usuario) throws Exception {

		JsonObject joResult = new JsonObject();

		int aux = 0;

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		try {

			logger.info("Start insert user.");
			logger.debug("Nombre de usuario:" + usuario.getUserName());

			joResult.addProperty("code", "200");

			joResult.addProperty("info", "Contrase??a actualizada exitosamente.");

			return new ResponseEntity<>(joResult.toString(), HttpStatus.OK);

		} catch (DataAccessException dae) {
			if (dae.getMessage() == null) {
				joResult.addProperty("code", 400);
				joResult.addProperty("message", "Bad Request");
				return new ResponseEntity<>(joResult.toString(), HttpStatus.BAD_REQUEST);
			} else {
				joResult.addProperty("code", 201);
				joResult.addProperty("message", dae.getMessage());
			}
			return new ResponseEntity<>(joResult.toString(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> login(@RequestBody Usuario usuario) throws Exception {

		JsonObject joResult = new JsonObject();

		int aux = 0;

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		try {

			logger.info("Start insert user.");
			logger.debug("Nombre de usuario:" + usuario.getUserName());
			
			joResult.addProperty("code", aux == 1 ? "200" : "201");

			joResult.addProperty("info",
					aux >= 1 ? "Login exitoso" : "Login no exitoso");

			return new ResponseEntity<>(joResult.toString(), HttpStatus.OK);

		} catch (DataAccessException dae) {
			if (dae.getMessage() == null) {
				joResult.addProperty("code", 400);
				joResult.addProperty("message", "Bad Request");
				return new ResponseEntity<>(joResult.toString(), HttpStatus.BAD_REQUEST);
			} else {
				joResult.addProperty("code", 201);
				joResult.addProperty("message", dae.getMessage());
			}
			return new ResponseEntity<>(joResult.toString(), HttpStatus.BAD_REQUEST);
		}
	}

}
