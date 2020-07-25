package modele;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the JOUEUR database table.
 * 
 */
@Entity
@XmlRootElement
@NamedQuery(name="Joueur.findAll", query="SELECT j FROM Joueur j")
public class Joueur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String mail;

	private String nom;

	public Joueur() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


}