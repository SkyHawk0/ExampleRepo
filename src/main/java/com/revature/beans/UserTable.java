package com.revature.beans;

import java.io.Serializable;

public class UserTable implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int u_id;
	private String u_fn;
	private String u_ln;
	private String u_username;
	private String u_password;
	private int ur_id;
	private String u_email;
	
	public UserTable() {}

	
	public UserTable(String u_username) {
		super();
		this.u_username = u_username;
	}
	
	
	public UserTable(String u_username, String u_password) {
		super();
		this.u_username = u_username;
		this.u_password = u_password;
	}

	

	public UserTable(String u_fn, String u_ln, String u_username, String u_password, String u_email) {
		super();
		this.u_fn = u_fn;
		this.u_ln = u_ln;
		this.u_username = u_username;
		this.u_password = u_password;
		this.u_email = u_email;
	}


	public UserTable(int u_id, String u_fn, String u_ln, String u_username, String u_password, int ur_id,
			String u_email) {
		super();
		this.u_id = u_id;
		this.u_fn = u_fn;
		this.u_ln = u_ln;
		this.u_username = u_username;
		this.u_password = u_password;
		this.ur_id = ur_id;
		this.u_email = u_email;
	}



	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public String getU_fn() {
		return u_fn;
	}

	public void setU_fn(String u_fn) {
		this.u_fn = u_fn;
	}

	public String getU_ln() {
		return u_ln;
	}

	public void setU_ln(String u_ln) {
		this.u_ln = u_ln;
	}

	public String getU_username() {
		return u_username;
	}


	public void setU_username(String u_username) {
		this.u_username = u_username;
	}

	public String getU_password() {
		return u_password;
	}

	public void setU_password(String u_password) {
		this.u_password = u_password;
	}

	public int getUr_id() {
		return ur_id;
	}

	public void setUr_id(int ur_id) {
		this.ur_id = ur_id;
	}

	public String getU_email() {
		return u_email;
	}

	public void setU_email(String u_email) {
		this.u_email = u_email;
	}

	
	
	@Override
	public String toString() {
		return "UserTable [u_id=" + u_id + ", u_fn=" + u_fn + ", u_ln=" + u_ln + ", u_username=" + u_username
				+ ", u_password=" + u_password + ", ur_id=" + ur_id + ", u_email=" + u_email + "]";
	};
	
	
	
}
