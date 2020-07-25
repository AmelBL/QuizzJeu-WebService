package bean;

import java.util.List;

import javax.ejb.Remote;

import modele.Joueur;
import modele.Partie;
import modele.Question;

@Remote
public interface Quizz1beanRemote {
	
	void ajouterJoueur(String id, String nom, String mail);
	Joueur trouverJoueur(String id);	
	
	int ajouterPartie(String idJoueur, int score);
	Partie trouvePartie(int id);
	
	int ChargerQst(String[] data);//qst.csv path
	Question trouvQuestion(int id);
	void majQuestion(List<Question> questions, List<Integer> reponses, Partie p);
	
	//int getLastID();
}
