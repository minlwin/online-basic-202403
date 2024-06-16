package com.jdc.demo;

import java.io.IOException;

import com.jdc.demo.app.exceptions.ApplicationException;
import com.jdc.demo.app.exceptions.ApplicationException.Type;

public class DemoApplication {
	
	

	public static void demo(SuperClass obj)  {
		try {
			obj.someMethod();
		} catch (IOException e) {
			// Log error message
			throw new ApplicationException(Type.Error, "Please check IO related information.", e);
		}
	}
}
