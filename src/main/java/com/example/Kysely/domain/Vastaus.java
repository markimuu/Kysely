package com.example.Kysely.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Vastaus {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="vastausid", nullable = false, updatable = false)
	private long vastausid;
	private String vastaus;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "kysymysid")
	private Kysymys kysymys;
	
	public Vastaus() {
		//
	}
	

	public Vastaus(String vastaus, Kysymys kysymys) {
		super();
		this.vastaus = vastaus;
		this.kysymys = kysymys;
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
	
	public Kysymys getKysymys() {
		return kysymys;
	}


	public void setKysymys(Kysymys kysymys) {
		this.kysymys = kysymys;
	}


	@Override
	public String toString() {
		return "Vastaus [vastausid=" + vastausid + ", vastaus=" + vastaus + "]";
	}

	
	
}