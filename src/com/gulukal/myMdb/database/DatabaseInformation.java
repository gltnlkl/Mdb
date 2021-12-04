package com.gulukal.myMdb.database;

import com.gulukal.myMdb.general.projectInformation.ProjectInformation;

public class DatabaseInformation {
	
	private String url;
	private String userName;
	private String password;
	private String forNameData;

	// parametresiz constructor
	public DatabaseInformation() {

		this.url = ProjectInformation.getString("DatabaseInformation.DATABASE_URL"); //$NON-NLS-1$
		this.userName = ProjectInformation.getString("DatabaseInformation.DATABASE_NAME"); //$NON-NLS-1$
		this.password = ProjectInformation.getString("DatabaseInformation.DATABASSE_PASSWORD"); //$NON-NLS-1$
		this.forNameData = ProjectInformation.getString("DatabaseInformation.DATABASE_FORNAME_DATA"); //$NON-NLS-1$
	}

	// getter and setter
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	 }

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getForNameData() {
		return forNameData;
	}

	public void setForNameData(String forNameData) {
		this.forNameData = forNameData;
	}

}

