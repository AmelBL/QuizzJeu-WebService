package modele;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 * The persistent class for the PARTIE database table.
 * 
 */
@Entity
@XmlRootElement
@NamedQuery(name="Partie.findAll", query="SELECT p FROM Partie p")
public class Partie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idpartie;

	private int score;

	//bi-directional many-to-one association to Joueur
	@ManyToOne
    @XmlTransient
	@JoinColumn(name="IDJOUEUR")
	private Joueur joueur;

	public Partie() {
	}

	public int getIdpartie() {
		return this.idpartie;
	}

	public void setIdpartie(int idpartie) {
		this.idpartie = idpartie;
	}

	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Joueur getJoueur() {
		return this.joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}


}