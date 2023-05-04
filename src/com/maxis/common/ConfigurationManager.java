package com.maxis.common;

import java.util.Properties;

import org.apache.commons.configuration.AbstractConfiguration;
import org.apache.commons.configuration.ConfigurationConverter;



public class ConfigurationManager {
	
	/*private static final Logger logger = LogManager.getLogger(ConfigurationManager.class.getName());*/

	
	private AbstractConfiguration propertiesConfiguration;	
	
	private static Properties properties;

	public ConfigurationManager() {
		super();
	}
    
	public AbstractConfiguration getPropertiesConfiguration() {
		return propertiesConfiguration;
	}

	public void setPropertiesConfiguration(AbstractConfiguration propertiesConfiguration) {
		this.propertiesConfiguration = propertiesConfiguration;
		properties = ConfigurationConverter.getProperties(this.propertiesConfiguration);
	}
	
	public static String getProperty(String key)
	{
		return properties.getProperty(key);
	}

}
