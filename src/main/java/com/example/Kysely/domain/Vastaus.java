package com.example.Kysely.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Vastaus {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="vastausid", nullable = false, updatable = false)
	private long vastausid;
	private String vastausteksti;

	@ManyToOne
	@JsonBackReference(value = "kysymykset")
	@JoinColumn(name = "kysymysid")
	private Kysymys kysymys;
	
	@OneToOne
	@JsonManagedReference(value = "vaihtoehtovastaus")
	@JoinColumn(name = "vaihtoehtoid")
	private Vaihtoehto vaihtoehto;
	
	public Vastaus() {
		super();
		//
	}
	
	/* public Vastaus(Vaihtoehto vaihtoehto, Kysymys kysymys) {
		super();
		this.vaihtoehto = vaihtoehto;
		this.kysymys = kysymys;
	} */

	public Vastaus(String vastaus, Kysymys kysymys, Vaihtoehto vaihtoehto) {
		super();
		this.vastausteksti = vastaus;
		this.kysymys = kysymys;
		this.vaihtoehto = vaihtoehto;
	}

	public long getVastausid() {
		return vastausid;
	}

	public void setVastausid(long vastausid) {
		this.vastausid = vastausid;
	}

	public String getVastausteksti() {
		return vastausteksti;
	}

	public void setVastausteksti(String vastausteksti) {
		this.vastausteksti = vastausteksti;
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
		return "Vastaus [vastausid=" + vastausid + ", vastausteksti=" + vastausteksti + "]";
	}

}
