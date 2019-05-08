package com.example.Kysely.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Vaihtoehto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="vaihtoehtoId", nullable=false, updatable=false)
	private long vaihtoehtoid;
	private String vaihtoehto;
	private long jarjestusnumero;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="kysymysid")
	private Kysymys kysymys;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonBackReference(value = "vaihtoehtovastaus")
	@JoinColumn(name = "vastausid")
	private Vastaus vastaus;

	public Vaihtoehto() {
		super();
		//112
	}

	public Vaihtoehto(String vaihtoehtoText, long jarjestusnumero, Kysymys kysymys) {
		super();
		this.jarjestusnumero = jarjestusnumero;
		this.kysymys = kysymys;
		this.jarjestusnumero = jarjestusnumero;
	}
	
	public long getVaihtoehtoId() {
		return vaihtoehtoid;
	}

	public void setVaihtoehtoId(Long vaihtoehtoId) {
		this.vaihtoehtoid = vaihtoehtoId;
	}

	public long getJarjestusnumero() {
		return jarjestusnumero;
	}

	public Kysymys getKysymys() {
		return kysymys;
	}

	public void setKysymys(Kysymys kysymys) {
		this.kysymys = kysymys;
	}


	public void setJarjestusnumero(long jarjestusnumero) {
		this.jarjestusnumero = jarjestusnumero;
	}

}
