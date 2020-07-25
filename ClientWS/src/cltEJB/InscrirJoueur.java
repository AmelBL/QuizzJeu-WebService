package cltEJB;
//cette classe s'occupe de la GUI de l'inscritpion du jeur
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import bean.Quizz1Bean;
import bean.Quizz1BeanProxy;

@SuppressWarnings("serial")
public class InscrirJoueur extends JFrame {
	private JTextField pseudo;
	private JTextField nom;
	private JTextField mail;
	private String[] infoJoueur;
	
	public InscrirJoueur() {
		WindowAdapter manipFenetre = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			  interupMatch();
			} };
		addWindowListener(manipFenetre);
		setBackground(new Color(169, 169, 169));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 564, 347);
		setLocationRelativeTo(null);
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		setResizable(false);
		setSize(new Dimension(300, 300));
		setTitle("JOUEUR");
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("INSCRIRE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					inscrire();
				} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(10, 192, 120, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SORTIR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		      //manipFenetre.windowClosed(null);
				interupMatch();
			}
		});
		btnNewButton_1.setBounds(140, 192, 120, 23);
		getContentPane().add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 25, 267, 145);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblPseudo = new JLabel("PSEUDO");
		lblPseudo.setBounds(10, 38, 60, 14);
		panel.add(lblPseudo);
		
		pseudo = new JTextField();
		pseudo.setBounds(107, 35, 150, 20);
		panel.add(pseudo);
		pseudo.setText("MonPseudo");
		pseudo.setColumns(10);
		
		JLabel lblInscriptionAuJeux = new JLabel("INSCRIPTION AU JEUX");
		lblInscriptionAuJeux.setBounds(67, 11, 120, 14);
		panel.add(lblInscriptionAuJeux);
		
		nom = new JTextField();
		nom.setBounds(107, 63, 150, 20);
		panel.add(nom);
		nom.setText("NOM");
		nom.setColumns(10);
		
		JLabel lblNom = new JLabel("NOM");
		lblNom.setBounds(10, 63, 60, 14);
		panel.add(lblNom);
		
		mail = new JTextField();
		mail.setBounds(107, 97, 150, 20);
		panel.add(mail);
		mail.setText("exemplel@exemple.xxx");
		mail.setColumns(10);
		
		JLabel lblMail = new JLabel("MAIL");
		lblMail.setBounds(10, 100, 60, 14);
		panel.add(lblMail);

	}
	

	private void inscrire() throws HeadlessException, RemoteException {
		 infoJoueur=new String[3];
		 infoJoueur[0]= pseudo.getText();
		 infoJoueur[1]= nom.getText();
		 infoJoueur[2]= mail.getText();
		 this.setVisible(false);
		 
		 Quizz1Bean q = new Quizz1BeanProxy();
		 if (q.trouverJoueur(infoJoueur[0])!= null){//ce pseudo existe déjà
			 //msg d'err
				JOptionPane.showMessageDialog(null, "Ce pseudo existe deja !!") ;
				this.dispose();
		 }else{
			 q.ajouterJoueur(infoJoueur[0], infoJoueur[1], infoJoueur[2]);
			//lancer le jeu
			 JouerQuestion jqst = new JouerQuestion(infoJoueur[0]);
			 jqst.setVisible(true);
		 }
	}

	
	private void interupMatch() {
		int reponse = JOptionPane.showConfirmDialog(null, "cette action annulera l'inscription et la partie : continuez?", 
				"OUI", JOptionPane.YES_NO_OPTION);
			if(reponse == JOptionPane.YES_OPTION){
				JOptionPane.showMessageDialog(null, " Partie interompue Merci ") ;
				this.dispose();
			}	
	}
	
}
