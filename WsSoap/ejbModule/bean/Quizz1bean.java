package bean;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import modele.Joueur;
import modele.Partie;
import modele.Question;

@WebService
@Stateless (mappedName = "bean/Quizz1beanBean")
@Remote( Quizz1beanRemote.class )
public class Quizz1bean implements Quizz1beanRemote {

    public Quizz1bean() {
    }
    
	@Override
	public void ajouterJoueur(String id,String nom,String mail) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WsSoap");
	    EntityManager em = emf.createEntityManager();
	    
	    EntityTransaction transac = em.getTransaction();
	    transac.begin();
	    //add Joueur
	  	 Joueur j = new Joueur();
	    j.setId(id);
	    j.setNom(nom);
	    j.setMail(mail);
	    em.persist(j);
        
	    
	    transac.commit();		    
	    em.close();
	    emf.close();
		
	    System.out.print("Partie ajouté\n");
	}
		
	@Override
	public Joueur trouverJoueur(String id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WsSoap");
	    EntityManager em = emf.createEntityManager();
	    
	    EntityTransaction transac = em.getTransaction();
	    transac.begin();
	    //find Joueur
	    Joueur j = em.find(Joueur.class,id);
	    transac.commit();		    
	    em.close();
	    emf.close();

		return j;
	}
	
	@Override
	public int ajouterPartie(String idJoueur, int score) {
		
		int id =0;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WsSoap");
	    EntityManager em = emf.createEntityManager();
	    
	    EntityTransaction transac = em.getTransaction();
	    transac.begin();
	    //add Partie
	    
	    Partie p = new Partie();
	    Joueur j = new Joueur();
	    
		p.setIdpartie(p.getIdpartie());
		
		Quizz1bean b = new Quizz1bean();
		//recuperer j 
		j = b.trouverJoueur(idJoueur);
	    
		p.setJoueur(j);
	    p.setScore(score);
	     
	    em.persist(p);
	    em.flush();
        
        id = p.getIdpartie();
	    
	    transac.commit();		    
	    em.close();
	    emf.close();
		
	    System.out.print("Partie ajouté\n");
	    return id;
	}

	@Override
	public Partie trouvePartie(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WsSoap");
	    EntityManager em = emf.createEntityManager();
	    
	    EntityTransaction transac = em.getTransaction();
	    transac.begin();
	    //find Partie
	    Partie p = em.find(Partie.class,id);
	    transac.commit();		    
	    em.close();
	    emf.close();

		return p;
	}
	
	
	@Override
	public int ChargerQst(String[] data) {
		int init = 0;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WsSoap");
	    EntityManager em = emf.createEntityManager();
		
		    EntityTransaction transac = em.getTransaction();
	
            	transac.begin();
            	 Question q = new Question();
            	//add qst		    

    		    q.setIdquestion(q.getIdquestion());
                q.setEnonce(data[0]);
                q.setReponse1(data[1]);
                q.setReponse2(data[2]);
                q.setReponse3(data[3]);
                q.setReponse4(data[4]);
                q.setBonnereponse(Integer.parseInt(data[5]));
                q.setScore(Integer.parseInt(data[6]));
                q.setPartie(null);
                q.setRepjoueur(0); //0 s'il n'a pas répondu //1,2,3,4 la réponse
                em.persist(q); 
        	    em.flush();
                
                init = q.getIdquestion();

    		    transac.commit();		    
		    em.close();
		    emf.close();
         
			return init;
	}

	@Override
	public Question trouvQuestion(int id) {
		
		System.out.print("question\n");
		
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("WsSoap");
	    EntityManager em = emf.createEntityManager();
	    
	    EntityTransaction transac = em.getTransaction();
	    transac.begin();
	    
	    //find question
	    Question q = em.find(Question.class,id);
	    transac.commit();		    
	    em.close();
	    emf.close();
	    
		if (q != null){
			System.out.print("QST trouvée\n");
		}
		else {System.out.print("QST non trouvée\n");}
		return q;
		
	}

	@Override
	public void majQuestion(List<Question> questions, List<Integer> reponses, Partie p) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WsSoap");
	    EntityManager em = emf.createEntityManager();
	    
	    EntityTransaction transac = em.getTransaction();
	    transac.begin();
	    //ajouter le idPartie aux questions jouées 
	    	   
	    int i =0;
	    for (Question q : questions) {
	    	q.setPartie(p);
	    	q.setRepjoueur(reponses.get(i));
	    	i++;
	    	em.merge(q);

	    }	    
	    transac.commit();		    
	    em.close();
	    emf.close();
	}

}
