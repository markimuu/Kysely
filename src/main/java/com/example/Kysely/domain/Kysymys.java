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
	@Column(name="id", nullable = false, updatable = false)
	private long id;
	private String kysymys;
	
	public Kysymys() {
	}
	
	public Kysymys(String kysymys) {
		super();
		this.kysymys = kysymys; 
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getKysymys() {
		return kysymys;
	}
	
	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}
	
	@Override
	public String toString() {
		return "Kysymys [id=" + id + ", kysymys=" + kysymys + "]";
	}
	
}
