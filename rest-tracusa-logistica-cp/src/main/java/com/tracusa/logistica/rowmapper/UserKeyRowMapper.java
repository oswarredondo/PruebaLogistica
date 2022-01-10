package com.tracusa.logistica.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tracusa.logistica.model.UserKey;

public class UserKeyRowMapper implements RowMapper<UserKey> {

	public UserKey mapRow(ResultSet rs, int rowNum) throws SQLException {

		UserKey userKey = new UserKey();

		userKey.setIdUserKey(rs.getInt("iduserkey"));
		userKey.setNumCliente(rs.getString("numcliente"));
		userKey.setLogin(rs.getString("login"));
		userKey.setApikey(rs.getString("apikey"));
		userKey.setEstatus(rs.getString("estatus"));

		return userKey;

	}

}
