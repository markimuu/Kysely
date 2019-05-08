package com.example.Kysely.domain;

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

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Kysymys {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="kysymysid", nullable = false, updatable = false)
	private long kysymysid;
	private String kysymys;
	private String kysymystyyppi;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kysymys")
	private List<Vastaus> vastaukset;
	
	@ManyToOne
	@JsonBackReference(value = "kysymykset")
	@JoinColumn(name = "kyselyid")
	private Kysely kysely;
	
	
	public Kysymys() {
		super();
		//yolo
	}
	
	public Kysymys(String kysymys, Kysely kysely, String kysymystyyppi) {
		super();
		this.kysymys = kysymys;
		this.kysely = kysely;
		this.kysymystyyppi = kysymystyyppi;
	}
	
	public String getKysymys() {
		return kysymys;
	}
	
	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}
	
	
	public long getKysymysid() {
		return kysymysid;
	}

	public void setKysymysid(long kysymysid) {
		this.kysymysid = kysymysid;
	}

	public List<Vastaus> getVastaus() {
		return vastaukset;
	}

	public void setVastaus(List<Vastaus> vastaukset) {
		this.vastaukset = vastaukset;
	}
	

	public List<Vastaus> getVastaukset() {
		return vastaukset;
	}

	public void setVastaukset(List<Vastaus> vastaukset) {
		this.vastaukset = vastaukset;
	}

	public Kysely getKysely() {
		return kysely;
	}

	public void setKysely(Kysely kysely) {
		this.kysely = kysely;
	}
	

	public String getKysymystyyppi() {
		return kysymystyyppi;
	}

	public void setKysymystyyppi(String kysymysTyyppi) {
		this.kysymystyyppi = kysymysTyyppi;
	}

	@Override
	public String toString() {
		return "Kysymys [kysymysid=" + kysymysid + ", kysymys=" + kysymys + ", vastaukset=" + vastaukset + ", kysely="
				+ kysely + "]";
	}

	
	
}