package org.rest_tracusa_logistica.controller;

import java.util.ArrayList;
import java.sql.SQLException;

import org.rest_tracusa_logistica.db.Connect;
import org.rest_tracusa_logistica.db.UserKeyDB;
import org.rest_tracusa_logistica.struct.UserKey;

public class UserKeyController {
	
	public UserKey getUserKey(String key) throws Exception{
		return UserKeyDB.getUserKeyDB(key, new Connect());
	}

}
