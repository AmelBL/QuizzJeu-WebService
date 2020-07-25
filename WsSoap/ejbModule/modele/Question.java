package modele;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.eclipse.persistence.oxm.annotations.XmlInverseReference;


/**
 * The persistent class for the QUESTION database table.
 * 
 */
@Entity
@XmlRootElement
@NamedQuery(name="Question.findAll", query="SELECT q FROM Question q")
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idquestion;

	private int bonnereponse;

	private String enonce;

	private int repjoueur;

	private String reponse1;

	private String reponse2;

	private String reponse3;

	private String reponse4;

	private int score;

	//bi-directional many-to-one association to Partie
	@ManyToOne
	@JoinColumn(name="IDPARTIE")
    @XmlTransient
    @XmlInverseReference(mappedBy="questions")
	private Partie partie;

	public Question() {
	}

	public int getIdquestion() {
		return this.idquestion;
	}

	public void setIdquestion(int idquestion) {
		this.idquestion = idquestion;
	}

	public int getBonnereponse() {
		return this.bonnereponse;
	}

	public void setBonnereponse(int bonnereponse) {
		this.bonnereponse = bonnereponse;
	}

	public String getEnonce() {
		return this.enonce;
	}

	public void setEnonce(String enonce) {
		this.enonce = enonce;
	}

	public int getRepjoueur() {
		return this.repjoueur;
	}

	public void setRepjoueur(int repjoueur) {
		this.repjoueur = repjoueur;
	}

	public String getReponse1() {
		return this.reponse1;
	}

	public void setReponse1(String reponse1) {
		this.reponse1 = reponse1;
	}

	public String getReponse2() {
		return this.reponse2;
	}

	public void setReponse2(String reponse2) {
		this.reponse2 = reponse2;
	}

	public String getReponse3() {
		return this.reponse3;
	}

	public void setReponse3(String reponse3) {
		this.reponse3 = reponse3;
	}

	public String getReponse4() {
		return this.reponse4;
	}

	public void setReponse4(String reponse4) {
		this.reponse4 = reponse4;
	}

	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Partie getPartie() {
		return this.partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}

}