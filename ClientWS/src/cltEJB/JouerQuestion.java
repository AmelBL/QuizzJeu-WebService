package cltEJB;
/*
 * Tâche principal de la GUI : montrer les questions et récupérer les réponses
 */
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Dimension;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.rmi.RemoteException;
import java.awt.event.ItemEvent;
import java.awt.Color;
import javax.swing.UIManager;

import bean.Joueur;
import bean.Partie;
import bean.Question;
import bean.Quizz1Bean;
import bean.Quizz1BeanProxy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JouerQuestion extends JFrame {

	private static final long serialVersionUID = 1L;
    private JTextArea cntntQuest;
    JTextArea evalReponse;
    private JComboBox<String> repList;
    private JLabel nQuest;
    private JLabel scorQuest;
    private JLabel totalScroe;   
    protected int flaqFinDepartie; // 0 si tout se termine bien 1 si le joueur à interompu le jeux avant la fin de questions
    
    private String pseudo;                  // identification du joueur
    private int numQuestCour;                 // le numéro de la question en cours dans la banque - aléatoire
    private int cptQstJouee = 0;                  // compteur des questions jouées - séquentiel
    private Question[] tracQuest = new Question[15];        //  liste des questions déjà posées dans la partie
    private int[] tracRepJoueur = new int[15];   // Les réponses donnée par le joueur
    private int totalScroeINT = 0;                 
    

	Quizz1Bean b = new Quizz1BeanProxy();

    Joueur j = new Joueur();
	Question q = new Question();
	Partie p = new Partie();
		
	//liste 
	List<Integer> num = new ArrayList<>();
    
	JButton btnNewButton = new JButton("Question Suivante");

	
	public JouerQuestion(String idJ) throws RemoteException {
		
		pseudo = idJ;
		
		//initialiation de la liste des indices des qst aleatoirement
		for (int i = 1; i <= 15; i++) {
			
		    num.add(i);
		}
		Collections.shuffle(num);
		
		flaqFinDepartie=1;     //au départ la partie n'est pas terminée ... donc risque de fin anormale
		/*WindowAdapter manipQuestFen = new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				stopMatch();
			}
		};
		addWindowListener(manipQuestFen);*/

		setSize(new Dimension(298, 252));
		setLocationRelativeTo(null);
		setBounds(100, 100, 564, 347);
	
		JLabel score = new JLabel(" ");
		score.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().setLayout(null);
				
		cntntQuest = new JTextArea();
		cntntQuest.setWrapStyleWord(true);
		cntntQuest.setEditable(false);
		cntntQuest.setBounds(21, 61, 517, 114);
		getContentPane().add(cntntQuest);
		
		repList = new JComboBox<String>();
		repList.setForeground(UIManager.getColor("ComboBox.foreground"));
		
		repList.addItemListener(new ItemListener() {   // Une réponse est jouée ...
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
				evaluerReponse();}			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					chargerUneQuestion();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(21, 234, 190, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Arr\u00EAter");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//manipQuestFen.windowClosed(null);
				try {
					stopMatch();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnNewButton_1.setBounds(381, 234, 157, 23);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Question:  ");
		lblNewLabel.setBounds(21, 36, 66, 14);
		getContentPane().add(lblNewLabel);
		
		nQuest = new JLabel(" ");
		nQuest.setBounds(97, 36, 46, 14);
		getContentPane().add(nQuest);
		
		scorQuest = new JLabel(" ");
		scorQuest.setBounds(394, 36, 46, 14);
		getContentPane().add(scorQuest);
		
		JLabel lblScore = new JLabel("BAREME");
		lblScore.setBounds(318, 36, 66, 14);
		getContentPane().add(lblScore);
		
		JLabel lblScore_2 = new JLabel("SCORE ");
		lblScore_2.setBounds(158, 11, 72, 14);
		getContentPane().add(lblScore_2);
		
		totalScroe = new JLabel(" ");
		totalScroe.setBounds(205, 11, 66, 14);
		getContentPane().add(totalScroe);
		
		evalReponse = new JTextArea();
		evalReponse.setBackground(Color.GRAY);
		evalReponse.setForeground(Color.BLACK);
		//evalReponse.setBounds(158, 275, 203, 22);
		getContentPane().add(evalReponse);
        // on charge une première question
		chargerUneQuestion();
	}
	
	// Charger une question à jouer
	private void chargerUneQuestion() throws RemoteException {
		cptQstJouee++;

		if ( cptQstJouee < 15 ){

			numQuestCour = num.get(0);			
			System.out.print("\n\n\n\n"+QuizJeux.lastID +"\n\n\n\n");
			
			num.remove(0);//pour ne pas re-choisir cette qst 
			
			q = b.trouvQuestion(QuizJeux.lastID - 15 + numQuestCour);
			
			cntntQuest.setText(q.getEnonce());
			nQuest.setText(String.valueOf(numQuestCour));
			scorQuest.setText(String.valueOf(q.getScore()));
			totalScroe.setText(String.valueOf(totalScroeINT));
				
			repList.setModel(new DefaultComboBoxModel<String>(new String[] {"Choisir une réponse parmi les 4 choix",q.getReponse1(),q.getReponse2() ,q.getReponse3() ,q.getReponse4()}));
			repList.setBounds(21, 186, 517, 37);
			repList.setBackground(Color.WHITE);
	      	repList.setForeground(Color.BLACK);
	      	repList.setEnabled(true);
	      	
	      	evalReponse.setBackground(Color.GRAY);
	      	evalReponse.setText("");
	      	
			getContentPane().add(repList);
			
		    this.setVisible(true);
		}else{
			//banque epuisée ==fin normal
			flaqFinDepartie=0;
			stopMatch();
						}
	}
	
	 // évaluer la réponse du joueur: si vrai incrémenter le score sinon afficher un message d'erreur et passer à la suivante
	private void evaluerReponse() {

		repList.setEnabled(false);//ne pas permettre une autre tentative
		
		//garder la trace
		tracQuest[cptQstJouee] = q;
		tracRepJoueur[cptQstJouee] = repList.getSelectedIndex() ;

		if (q.getBonnereponse() == repList.getSelectedIndex()) {   // cas de réponse juste
			
			System.out.print(String.valueOf(numQuestCour) + "\t"+q.getScore()+"\n");
			
			totalScroeINT = totalScroeINT + q.getScore();
			
			totalScroe.setText(String.valueOf(totalScroeINT)); // le score cummulé du joueur
			repList.setBackground(Color.GREEN);
          	repList.setForeground(Color.WHITE);
			evalReponse.setBackground(Color.GREEN);
          	evalReponse.setForeground(Color.WHITE);
          	evalReponse.setText("BONNE REPONSE (:>)");
          	evalReponse.setVisible(true);
		} else {
			repList.setBackground(Color.RED);
          	repList.setForeground(Color.BLACK);			
			evalReponse.setBackground(Color.RED);
          	evalReponse.setForeground(Color.BLACK);
          	evalReponse.setText("MAUVAISE REPONSE (:o)");
          	evalReponse.setVisible(true);
		  }
		
		}
    // Fin de partie banque epuisée (totues les questions utilisée) fin normale 0 dégats
	
	private void stopMatch() throws RemoteException {
		
		btnNewButton.setEnabled(false);

		
		//vérifier si il n'y a pas eu de fin normal		
		if (flaqFinDepartie==0){//fin normal == banque epuisée
						
			//ajout de la partie à la bdd
			int idp = b.ajouterPartie(pseudo, totalScroeINT);
			
			//MAJ des QST : idPartie
			p = b.trouvePartie(idp);
			
			b.majQuestion(tracQuest,tracRepJoueur, p);
			
			//fenetre vous voulez jouer une nouvelle partie??
			JOptionPane.showMessageDialog(null, "vous avez terminé ce partie  avec le score: "+totalScroeINT);
			this.dispose();
			//...

		}else{
			//si confirmé ==> Supprimer les QST dont idPartie==NULL de la bdd
			int reponse = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de vouloir quitter la partie en cours ?","OUI", JOptionPane.YES_NO_OPTION);
			if(reponse == JOptionPane.YES_OPTION){
				if (cptQstJouee > 0) {//il a joueé des qst
					reponse = JOptionPane.showConfirmDialog(null, "voulez enregister la partie ?", "OUI", JOptionPane.YES_NO_OPTION);
					if(reponse == JOptionPane.YES_OPTION){
						try {
							//ajout de la partie à la bdd
							int idp = b.ajouterPartie(pseudo, totalScroeINT);
							//MAJ des QST : idPartie							
							
							p = b.trouvePartie(idp);
							b.majQuestion(tracQuest,tracRepJoueur, p);
							
							JOptionPane.showMessageDialog(null,"vous avez terminé ce partie avec le score: "+totalScroeINT+ "\nPartie interompue et enregistrée ... Merci ... ") ;
								 
						} catch (Exception e) {e.printStackTrace();}
					}else JOptionPane.showMessageDialog(null,"vous avez terminé ce partie avec le score: "+totalScroeINT+ "\n Partie interompue et non enregistrée ... Merci ... ") ; 
				}	
				this.dispose();
			}else{		btnNewButton.setEnabled(true);}
				
			}
		}

}