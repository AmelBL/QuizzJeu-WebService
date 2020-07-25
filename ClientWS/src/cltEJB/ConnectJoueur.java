package cltEJB;

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
public class ConnectJoueur extends JFrame{
	
	private JTextField pseudo;
	private String[] infoJoueur;
	//private JouerQuestion jouer;

	public ConnectJoueur() {
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
		setTitle("Connexion");
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("CONNECTER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					connect();
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
		
		JLabel lblInscriptionAuJeux = new JLabel("Connexion");
		lblInscriptionAuJeux.setBounds(67, 11, 120, 14);
		panel.add(lblInscriptionAuJeux);
	
	}
	
	private void connect() throws HeadlessException, RemoteException {
		 infoJoueur=new String[3];
		 infoJoueur[0]= pseudo.getText();
		 
		 Quizz1Bean q = new Quizz1BeanProxy();
		 if (q.trouverJoueur(infoJoueur[0]) != null){//ce pseudo existe 
			 			//lance le jeu	
			 JouerQuestion jqst = new JouerQuestion(infoJoueur[0]);
			 jqst.setVisible(true);
		 }else {
			 			  //msg d'err
			JOptionPane.showMessageDialog(null, "Vous devez inserer un pseudo valide") ;
			this.dispose();
		 }

		 this.setVisible(false);
	}
	
	private void interupMatch() {
		int reponse = JOptionPane.showConfirmDialog(null, "cette action annulera la connexion et la partie : continuez?", 
				"OUI", JOptionPane.YES_NO_OPTION);
			if(reponse == JOptionPane.YES_OPTION){
				JOptionPane.showMessageDialog(null, " Partie interompue Merci ") ;
				this.dispose();
			}	
	}
}
