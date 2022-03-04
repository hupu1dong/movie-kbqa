package com.zgy.moviekbqa.node;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class User extends BaseEntity {


	private String userName;
	private String password;
	private String status;

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

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    
}
