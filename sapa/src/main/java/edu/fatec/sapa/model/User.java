package edu.fatec.sapa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity User - create database table User structure
 */
@Entity
@Table(name="tb_user")
public class User {
	private int id;
	private String uname;
	private String upass;
	private int ulevel;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(unique=true)
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
		
	public int getUlevel() {
		return ulevel;
	}
	public void setUlevel(int ulevel) {
		this.ulevel = ulevel;
	}
	
}
