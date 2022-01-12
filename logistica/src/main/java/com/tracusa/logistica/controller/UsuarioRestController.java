package com.tracusa.logistica.controller;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.administracion.ibo.IParamsSistemaBO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.tracusa.logistica.model.Usuario;
import com.tracusa.logistica.interfase.bo.IUsuarioBO;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Controller
@RequestMapping("/rest/user")
public class UsuarioRestController {

	private static final Logger logger = LoggerFactory.getLogger(UsuarioRestController.class);

	@Autowired
	private IUsuarioBO iUsuario;

	@Autowired
	private IParamsSistemaBO iParamsSistemaBO;

	@RequestMapping(value = "/insert", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> insert(@RequestBody Usuario usuario) throws Exception {

		JsonObject joResult = new JsonObject();

		String adminKey = "";

		int aux = 0;

		try {

			logger.info("Start insert user.");

			logger.debug("Nombre de usuario:" + usuario.getUserName());
			logger.debug("Nombre de usuario:" + usuario.getEmployeedNumber());
			logger.debug("Nombre de usuario:" + usuario.getPhone());

			logger.info("Getting data server....");
			
			adminKey = iParamsSistemaBO.getValorPropiedad("api.tracusa.logistica.password", "TRSLogistica");

			if (adminKey.equals(usuario.getAdminKey())) {

				logger.info("Inserting user.....");
				
				aux = iUsuario.insert(usuario);
				
				logger.info("Finish insert user.");
				
				joResult.addProperty("code", aux >= 1 ? "201" : "200");

				joResult.addProperty("info",
						aux >= 1 ? "El usuario ya se encuntra registrado" : "Usuario registrado con exito");


			}else {
				
				logger.info("Finish insert user.");
				
				joResult.addProperty("code", "202");

				joResult.addProperty("info","Clave administrativa invalida");
				
			}

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

		try {

			logger.info("Start change password.");

			logger.debug("Nombre de usuario:" + usuario.getUserName());
			logger.debug("Nombre de usuario:" + usuario.getEmployeedNumber());
			logger.debug("Nombre de usuario:" + usuario.getPhone());

			logger.info("Changing password.");
			
			iUsuario.changePassword(usuario);

			logger.info("Finish change password.");
			
			joResult.addProperty("code", "200");

			joResult.addProperty("info", "Contraseña actualizada exitosamente.");

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

		List<Usuario> lstUsuario = new ArrayList<Usuario>();

		JsonObject joResult = new JsonObject();
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		int aux = 0;


		try {

			logger.info("Start user login.");

			logger.debug("Nombre de usuario:" + usuario.getUserName());
			logger.debug("Nombre de usuario:" + usuario.getEmployeedNumber());
			logger.debug("Nombre de usuario:" + usuario.getPhone());

			String token = getJWTToken(usuario.getUserName());

			logger.info("Logging in....");
			
			lstUsuario = iUsuario.login(usuario);
			
			aux = lstUsuario.size();

			logger.info("Finish user login.");
			
			if(aux == 1){
			
				joResult.addProperty("code", "200");

				joResult.addProperty("token", token);

				joResult.addProperty("info", "Login exitoso");
				
				joResult.add("user", gson.toJsonTree(lstUsuario));

				return new ResponseEntity<>(joResult.toString(), HttpStatus.OK);
				
			}else{
				
				joResult.addProperty("code", "201");

				joResult.addProperty("token", "");

				joResult.addProperty("info", "Login no exitoso");
				
				joResult.add("user", gson.toJsonTree(lstUsuario));

				return new ResponseEntity<>(joResult.toString(), HttpStatus.UNAUTHORIZED);
				
			}

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
	
	@RequestMapping(value = "/getServer/{server}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> getServer(@PathVariable("server") String server) throws Exception {

		JsonObject joResult = new JsonObject();

		String urlServer = "";


		try {

			logger.info("Start user login.");


			logger.info("Getting Server....");
			
			if(server.equals("PRD")){
				
				urlServer = iParamsSistemaBO.getValorPropiedad("api.tracusa.logistica.server.prd", "TRSLogistica");
				
			}else{
				
				urlServer = iParamsSistemaBO.getValorPropiedad("api.tracusa.logistica.server.qas", "TRSLogistica");
				
			}

			logger.info("Finish user login.");
			
			joResult.addProperty("code", !urlServer.equals("") ? "200" : "201");

			joResult.addProperty("server", !urlServer.equals("") ? urlServer : "");

			joResult.addProperty("info", !urlServer.equals("") ? "Servidor obtenido" : "Servidor no obtenido");

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

	@RequestMapping(value = "/getToken", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> getToken(@RequestBody Usuario usuario) throws Exception {

		JsonObject joResult = new JsonObject();

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		try {

			logger.info("Start get new Token.");

			logger.debug("Nombre de usuario:" + usuario.getUserName());
			logger.debug("Nombre de usuario:" + usuario.getEmployeedNumber());
			logger.debug("Nombre de usuario:" + usuario.getPhone());

			logger.info("Getting new Token....");
			
			String token = getJWTToken(usuario.getUserName());

			logger.info("Finish get new Token....");
			
			joResult.addProperty("code", "200");

			joResult.addProperty("token", token);

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

	@RequestMapping(value = "/checkAPI")
	public @ResponseBody HttpStatus checkAPI() throws Exception {

			return HttpStatus.OK;
			
	}
	
	private String getJWTToken(String username) {

		String secretKey = "lzh85xxkVZAE0LxDhfP48hOJ6ajC+Z/3uaV9LTmZvVhpoqIEWXSSnO5piCacZyk2rt+"
				+ "lrMkeUfwuKifnuA7eH9FnQD8RonuhLobB46Fksw+e+6b3PP4d6aNHRN7ZR0azzKUZL2FVgubiIyoJ3"
				+ "uzGXKqsjkL+QLs6XOzBJ+sGEBq+8BN5aAiMmUot9Q812gTTmZKTOTPQsCzomsOQHqFtB/3KI4d3g0q/"
				+ "79uUvFeL9o4qF8H8PiHg8DnApUYdCrfrUqBAGsRB0Re1TgX+lFJQChhgbd8GU4OBIF3IIv1sAt7VOf0"
				+ "d7sKJSOmSc1K6xCC2puFINuS9FC5HVVlt/tr0+DQVzeZwc/ClmlfnxunJ2bIPx6DuGnJUEkU6Zxso7K2"
				+ "F9nKB5G6nYn25eNkSI1GxiasrTR7JcAPVsgciDm5EtTi3y3x6hKMf9kEpECEyE8yD+fJ+icNGoGq3t5jcC"
				+ "2rsdf6Hm0QyyPq7bds4UzDKlxVW55KchbaPnA";
		
		//List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("OPERADOR");

		Instant issuedAt = Instant.now().truncatedTo(ChronoUnit.SECONDS);
		
		Instant expiration = issuedAt.plus(1, ChronoUnit.HOURS);

		String token = Jwts.builder().setId("TRSLogistica").setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(Date.from(issuedAt)).setExpiration(Date.from(expiration))
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

		return token;

	}

}
