package com.servicenow.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class is to load property file which will be used to save constants
 * 
 * @author sapnago
 *
 */
public class PropertiesLoader {

	private Properties pro;
	private FileInputStream fi = null;

	public PropertiesLoader(String path) {
		pro = new Properties();
		try {
			fi = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			pro.load(fi);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getProperty(String propertyName) {
		return pro.getProperty(propertyName);
	}

	
	
}
