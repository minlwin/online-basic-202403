package com.jdc.demo.app;

import com.jdc.demo.app.exceptions.ApplicationException;
import com.jdc.demo.app.exceptions.ApplicationException.Type;
import com.jdc.demo.app.exceptions.DataAccessException;

public class ModelClass {

	private DataAccessClass dao = new DataAccessClass();
	
	public String[] search(String param) {
		try {
			return dao.search(param);
		} catch (DataAccessException e) {
			throw new ApplicationException(Type.Error, "Error on data access calss.", e);
		}
	}
}
