package com.tracusa.logistica.interfaces.dao;

import com.tracusa.logistica.model.UserKey;

public interface IUserKeyDAO {

	public UserKey getUserKey(String key) throws Exception;
	
}
