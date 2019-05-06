package com.example.Kysely.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	
	@OneToOne
	@JsonBackReference
	@JoinColumn(name = "vaihtoehto")
	private Vaihtoehto vaihtoehto;
	
	public Vastaus() {
		//
	}
	
	

	public Vastaus(long vastausid, String vastaus, Kysymys kysymys, Vaihtoehto vaihtoehto) {
		super();
		this.vastausid = vastausid;
		this.vastaus = vastaus;
		this.kysymys = kysymys;
		this.vaihtoehto = vaihtoehto;
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

	public Vaihtoehto getVaihtoehto() {
		return vaihtoehto;
	}

	public void setVaihtoehto(Vaihtoehto vaihtoehto) {
		this.vaihtoehto = vaihtoehto;
	}

	@Override
	public String toString() {
		return "Vastaus [vastausid=" + vastausid + ", vastaus=" + vastaus + "]";
	}

	
	
}