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

@Entity
public class Kysely {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="kyselyid", nullable = false, updatable = false)
	private long kyselyid;
	private String otsikko;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kysely")
	@JsonBackReference
	private List<Kysymys> kysymykset;
	
	
	public Kysely() {
		//yolo
	}
	
	public Kysely(String otsikko) {
		super();
		this.otsikko = otsikko;
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

	@Override
	public String toString() {
		return "Kysely [kyselyid=" + kyselyid + ", otsikko=" + otsikko + "]";
	}

	
}