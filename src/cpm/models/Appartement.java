package cpm.models;


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
@Table(name="Appartement")
public class Appartement {

	@Id
	@Column(name="lettre_appartement")
	String id;
	
	
	@Column(name="nb_pieces_total")
	int nbPiece;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="num_etage")
	private Etage etage;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public int getNbPiece() {
		return nbPiece;
	}


	public Appartement() {
		super();
	}


	public Appartement(String id, int nbPiece) {
		super();
		this.id = id;
		this.nbPiece = nbPiece;
	}


	public void setNbPiece(int nbPiece) {
		this.nbPiece = nbPiece;
	}
	
	
}



