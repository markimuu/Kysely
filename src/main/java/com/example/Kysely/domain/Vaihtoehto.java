package com.example.Kysely.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Vaihtoehto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="vaihtoehtoId", nullable=false, updatable=false)
	private long vaihtoehtoId;
	private String vaihtoehtoText;
	private long vaihtoehto;
	
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="kysymysid")
	private Kysymys kysymys;

	public Vaihtoehto() {
		super();
		//112
	}

	public Vaihtoehto(String vaihtoehtoText, long vaihtoehto, Kysymys kysymys) {
		super();
		this.vaihtoehtoText = vaihtoehtoText;
		this.vaihtoehto = vaihtoehto;
		this.kysymys = kysymys;
	}

	public long getVaihtoehto() {
		return vaihtoehto;
	}

	public void setVaihtoehto(long vaihtoehto) {
		this.vaihtoehto = vaihtoehto;
	}

	public String getVaihtoehtoText() {
		return vaihtoehtoText;
	}

	public void setVaihtoehtoText(String vaihtoehtoText) {
		this.vaihtoehtoText = vaihtoehtoText;
	}

	public Kysymys getKysymys() {
		return kysymys;
	}

	public void setKysymys(Kysymys kysymys) {
		this.kysymys = kysymys;
	}

	@Override
	public String toString() {
		return "Vaihtoehto [vaihtoehtoId=" + vaihtoehtoId + ", vaihtoehto=" + vaihtoehto + ", vaihtoehtoText="
				+ vaihtoehtoText + ", kysymys=" + kysymys + "]";
	}

}
