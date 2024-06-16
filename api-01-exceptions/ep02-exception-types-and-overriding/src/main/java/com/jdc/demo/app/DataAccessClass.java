package com.jdc.demo.app;

import com.jdc.demo.app.exceptions.DataAccessException;

public class DataAccessClass {

	public String[] search(String str) throws DataAccessException {
		
		if(null == str || str.isBlank()) {
			throw new DataAccessException("Parameter must be required!");
		}
		
		return new String[] {"It is OK"};
	}
}
