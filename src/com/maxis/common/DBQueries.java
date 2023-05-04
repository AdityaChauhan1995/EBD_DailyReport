package com.maxis.common;

import java.util.Properties;

import org.apache.commons.configuration.AbstractConfiguration;
import org.apache.commons.configuration.ConfigurationConverter;
import org.springframework.stereotype.Repository;


/**
 * @author Kamal
 *
 */
@Repository("dbQueries")
public class DBQueries {
	
	
	private AbstractConfiguration queryPropertiesConfiguration;	
	
	private static Properties queryProperties;


	public DBQueries() {
		super();
	}


	public AbstractConfiguration getQueryPropertiesConfiguration() {
		return queryPropertiesConfiguration;
	}


	public void setQueryPropertiesConfiguration(
			AbstractConfiguration queryPropertiesConfiguration) {
		this.queryPropertiesConfiguration = queryPropertiesConfiguration;
		queryProperties = ConfigurationConverter.getProperties(this.queryPropertiesConfiguration);

	}


	public static String getQueryProperties(String key) {
		return queryProperties.getProperty(key);
	}


	

}
