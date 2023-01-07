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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Rue")
public class Rue implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="code_rue")
	int id;
	
	@Column(name="nom_rue")
	String nom;
	
	@OneToMany(mappedBy="Immeuble", fetch=FetchType.EAGER)
	List<Immeuble> immeubles=new ArrayList<Immeuble>();

	
	
	public Rue() {
		super();
	}

	public Rue(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Immeuble> getImmeubles() {
		return immeubles;
	}

	public void setImmeubles(List<Immeuble> immeubles) {
		this.immeubles = immeubles;
	}
	
	
}
