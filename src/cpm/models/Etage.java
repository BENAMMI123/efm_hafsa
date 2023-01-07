package cpm.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Etage")
public class Etage implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="num_etage")
	int id;
	
	@Column(name="nb_appartement_tot")
	int nbApp;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="num_immeuble")
	private Immeuble immeuble;
	
	
	@OneToMany(mappedBy="Appartement", fetch=FetchType.EAGER)
	List<Appartement> appartements=new ArrayList<Appartement>();


	public Etage(int id, int nbApp) {
		super();
		this.id = id;
		this.nbApp = nbApp;
		this.immeuble = immeuble;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getNbApp() {
		return nbApp;
	}


	public void setNbApp(int nbApp) {
		this.nbApp = nbApp;
	}


	public Immeuble getImmeuble() {
		return immeuble;
	}


	public void setImmeuble(Immeuble immeuble) {
		this.immeuble = immeuble;
	}


	
	
	
	
}
