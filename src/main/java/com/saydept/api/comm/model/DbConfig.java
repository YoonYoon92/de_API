package com.saydept.api.comm.model;

public class DbConfig {
	
	private static DbConfig __DbConfig = null;
	private String dbType = "";

	private DbConfig()
	{		
	}
	
	public static DbConfig getInstance()
	{
		if(__DbConfig == null)
		{
			__DbConfig = new DbConfig();			
		}
		
		return __DbConfig;
	}

	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}
}
