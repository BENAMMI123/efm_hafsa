package cpm.models;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Immeuble")
public class Immeuble implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="num_immeuble")
	int id;
	
	@Column(name="nb_etage_total")
	int nbEtage;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="code_rue")
	private Rue rues;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNbEtage() {
		return nbEtage;
	}

	public void setNbEtage(int nbEtage) {
		this.nbEtage = nbEtage;
	}

	public Rue getRues() {
		return rues;
	}

	public void setRues(Rue rues) {
		this.rues = rues;
	}

	public Immeuble() {
		super();
	}

	public Immeuble(int id, int nbEtage, Rue rues) {
		super();
		this.id = id;
		this.nbEtage = nbEtage;
		this.rues = rues;
	}

	
}