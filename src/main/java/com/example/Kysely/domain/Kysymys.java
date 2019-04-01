package com.example.Kysely.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kysymys {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="kysymysid", nullable = false, updatable = false)
	private long kysymysid;
	private String kysymys;
	
	public Kysymys() {
	}
	
	public Kysymys(String kysymys) {
		super();
		this.kysymys = kysymys; 
	}

	public long getKysymysId() {
		return kysymysid;
	}
	
	public void setKysymysId(long kysymysid) {
		this.kysymysid = kysymysid;
	}
	
	public String getKysymys() {
		return kysymys;
	}
	
	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}
	
	@Override
	public String toString() {
		return "Kysymys [kysymysid=" + kysymysid + ", kysymys=" + kysymys + "]";
	}
	
}
