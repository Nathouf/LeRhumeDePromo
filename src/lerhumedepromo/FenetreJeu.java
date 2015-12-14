/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerhumedepromo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;

/**
 *
 * @author Nath
 */
public class FenetreJeu extends JFrame{
    	public Plateau monPlateau;
	private JLabel labelTimer;
        private JLabel consignePremierMalade ;
        private JButton passerTour;
	private JLabel legende;
	public int nombreIconesx;
	public int nombreIconesy;
	private MonPanelDessin monPanelDessin;
	private EcouteurPremierMalade ecoutPremierMalade;//pour nous donner sa position
	private JPanel panelDeCommande = new JPanel(); //zone qui contient l'étiquette labelTimer et le bouton passerTour (en haut)
        
	public FenetreJeu(Plateau plateau, int nbreIconesx, int nbreIconesy){
		super("Fenêtre de jeu");
                this.nombreIconesx = nbreIconesx; //nombre de colonnes  
		this.nombreIconesy = nbreIconesy;  //nombre de lignes
                monPlateau = plateau;
                monPanelDessin = new MonPanelDessin(this);
		JPanel cadrePrincipal = new JPanel(new BorderLayout()); //cadre principal de la fenêtre qui contiendra tout
		JPanel zoneDeLegende = new JPanel(new BorderLayout()); //zone qui contient la légende (à droite)
                consignePremierMalade = new JLabel("Cliquez sur le premier étudiant à infecter");
		ecoutPremierMalade = new EcouteurPremierMalade(this);//instanciation,, pas nécessaire maintenant que j'y pense,, on verra
	
		//Instanciations
		labelTimer = new JLabel("Semaine 1");
		passerTour = new JButton("Passer tour");
		legende = new JLabel(" Légende ");
		 
			
                passerTour.addActionListener(new EcouteurTour(this, monPanelDessin));//addition d'action au button,,changement car j'ai changé le constructeur pour qu'on mette repaint
                monPanelDessin.addMouseListener(ecoutPremierMalade);

		panelDeCommande.add(labelTimer,BorderLayout.NORTH);
		cadrePrincipal.add(passerTour,BorderLayout.SOUTH);
		zoneDeLegende.add(legende,BorderLayout.NORTH);
		cadrePrincipal.add(monPanelDessin,BorderLayout.CENTER);
		cadrePrincipal.add(panelDeCommande,BorderLayout.NORTH);
		cadrePrincipal.add(zoneDeLegende,BorderLayout.EAST);
		
		monPanelDessin.repaint();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //la fenêtre se ferme quand on clique sur la x
		setSize(600,400);
		setContentPane(cadrePrincipal);	
		setVisible(true);

	}
	
	public void setLabelTimer(){
		labelTimer.setText("Semaine : "+monPlateau.timer); //on modifie l'étiquette du timer en fonction de la semaine
	}
	

	
	/*public void setPremierMalade(int x, int y)
	à quoi servent les paramètres? coordonnées données pas mouseListener*/
	public void setPremierMalade(){
		int x = ecoutPremierMalade.posMaladeX;//nous donne la position qu'il a récupérée
		int y = ecoutPremierMalade.posMaladeY;

		monPlateau.tabEtudiant[x][y].etat=true;//maintenant la la méthode paintComponent va le peidre rouge et c'est fini
	}
	
	
        
	
	
	public void actualiserTour(){
		monPlateau.timer++;  //le timer augmente de 1, on passe à la semaine suivante
		monPlateau.leTour();
	}
	
	public String messageFinDePartie(){ 
		String message="";
		if(monPlateau.finPartie()){
			message=message+"Vous avez perdu, vous n'avez pas infecté tous les étudiants!";
		}
		return message;
	}
	
	public void DepartJeu(){
		 
		 monPanelDessin.removeActionListener(ecoutPremierMalade);//pour qu'on ne choississe qu'une fois le premier malade
		 panelDeCommande.add(labelTimer); //on ajoute les caractéristiques du jeu
		 panelDeCommande.add(passerTour);
	//	 consignePremierMalade.setText("");// la consigne initiale ne s'affiche plus 
	}
    
}
