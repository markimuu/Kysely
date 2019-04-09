package com.example.Kysely.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vastaus {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="vastausid", nullable = false, updatable = false)
	private long vastausid;
	private String vastaus;

	public Vastaus() {
	}

	public Vastaus(String vastaus) {
		super();
		this.vastaus = vastaus; 
	}

	public long getVastausid() {
		return vastausid;
	}

	public void setVastausid(long vastausid) {
		this.vastausid = vastausid;
	}

	public String getVastaus() {
		return vastaus;
	}

	public void setVastaus(String vastaus) {
		this.vastaus = vastaus;
	}

	@Override
	public String toString() {
		return "Vastaus [vastausid=" + vastausid + ", vastaus=" + vastaus + "]";
	}
	
}