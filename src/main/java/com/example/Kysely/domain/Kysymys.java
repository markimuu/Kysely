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
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Kysymys {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="kysymysid", nullable = false, updatable = false)
	private long kysymysid;
	private String kysymys;
	private String kystyyppi; //tekstikysymys, radioButtonkysymys
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kysymys")
	@JsonManagedReference //!
	private List<Vastaus> vastaukset;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "kyselyid")
	private Kysely kysely;
	
	
	public Kysymys() {
		//yolo
	}
	
	public Kysymys(String kysymys, Kysely kysely) {
		super();
		this.kysymys = kysymys;
		this.kysely = kysely;
	}
	
	public Kysymys(String kysymys, Kysely kysely, String kystyyppi) {
		super();
		this.kysymys = kysymys;
		this.kysely = kysely;
		this.kystyyppi = kystyyppi; 
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
<<<<<<< HEAD
	
	public List<Vaihtoehto> getVaihtoehdot() {
		return vaihtoehdot;
	}

	public void setVaihtoehdot(List<Vaihtoehto> vaihtoehdot) {
		this.vaihtoehdot = vaihtoehdot;
	}
	

	public String getKystyyppi() {
		return kystyyppi;
	}

	public void setKystyyppi(String kystyyppi) {
		this.kystyyppi = kystyyppi;
	}
=======
>>>>>>> parent of 8bc294c... Hyvää vappua t. Mark

	@Override
	public String toString() {
		return "Kysymys [kysymysid=" + kysymysid + ", kysymys=" + kysymys + ", vastaukset=" + vastaukset + ", kysely="
				+ kysely + "]";
	}

	
	
}