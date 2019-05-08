package com.example.Kysely.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Kysely {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="kyselyid", nullable = false, updatable = false)
	private long kyselyid;
	private String otsikko;
	private String kuvaus;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kysely")
	@JsonManagedReference(value = "kysymykset")
	private List<Kysymys> kysymykset;
	
	
	public Kysely() {
		super();
		//yolo
	}
	
	public Kysely(String otsikko, String kuvaus) {
		super();
		this.otsikko = otsikko;
		this.kuvaus = kuvaus;
	}
	
	public long getKyselyid() {
		return kyselyid;
	}

	public void setKyselyid(long kyselyid) {
		this.kyselyid = kyselyid;
	}

	public List<Kysymys> getKysymykset() {
		return kysymykset;
	}

	public void setKysymykset(List<Kysymys> kysymykset) {
		this.kysymykset = kysymykset;
	}
	
	public String getOtsikko() {
		return otsikko;
	}

	public void setOtsikko(String otsikko) {
		this.otsikko = otsikko;
	}
	
	public String getKuvaus() {
		return kuvaus;
	}

	public void setKuvaus(String kuvaus) {
		this.kuvaus = kuvaus;
	}

	@Override
	public String toString() {
		return "Kysely [kyselyid=" + kyselyid + ", otsikko=" + otsikko + ", kuvaus=" + kuvaus + ", kysymykset="
				+ kysymykset + "]";
	}

	
}