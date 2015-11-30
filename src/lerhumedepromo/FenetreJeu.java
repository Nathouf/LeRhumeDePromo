/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerhumedepromo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Nath
 */
public class FenetreJeu extends JFrame{
    	private Plateau monPlateau;
	private JLabel labelTimer;
	private JButton passerTour;
	private JPanel zoneDeDessin;
	int nombreIconesx;
	int nombreIconesy;
	
	public FenetreJeu(Plateau plateau, int nbreIconesx, int nbreIconesy){
		super("Fenêtre de jeu");
		JPanel cadrePrincipal = new JPanel(new BorderLayout()); //cadre principal de la fenêtre qui contiendra tout
		JPanel panelDeCommande = new JPanel(); //zone qui contient l'étiquette labelTimer et le bouton passerTour (en haut)
		JPanel zoneDeLegende = new JPanel(); //zone qui contient la légende (à droite)
		this.nombreIconesx = nbreIconesx; 
		this.nombreIconesy = nbreIconesy;
	
		//Instanciations
		labelTimer = new JLabel("Semaine 1");
		passerTour = new JButton("Passer tour");
		monPlateau = new Plateau(nombreIconesx,nombreIconesy); //création d'un plateau de la taille définie pare l'utilisateur via l'écouteur "EcouteurTaille"
		zoneDeDessin = new JPanel(); //zone qui contient le quadriage (au centre)		
		panelDeCommande.add(labelTimer); 
		panelDeCommande.add(passerTour);
		
		cadrePrincipal.add(zoneDeDessin,BorderLayout.CENTER);
		cadrePrincipal.add(panelDeCommande,BorderLayout.NORTH);
		cadrePrincipal.add(zoneDeLegende,BorderLayout.EAST);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //la fenêtre se ferme quand on clique sur la x
		setSize(600,400);
		setContentPane(cadrePrincipal);	
		setVisible(true);

	}
	
	public void setLabelTimer(){
		labelTimer.setText("Semaine : "+monPlateau.timer); //on modifie l'étiquette du timer en fonction de la semaine
	}
	
	public int getSizeIconeX(){
		int l = (int)zoneDeDessin.getWidth();
		return (int)(l/nombreIconesx); //renvoie la taille des colonnes
	}
	
	public int getSizeIconeY(){
		int h = (int)zoneDeDessin.getHeight();
		return (int)(h/nombreIconesy); //renvoie la taille des lignes
	}
	
	public void setPremierMalade(int x, int y){
		monPlateau.tabEtudiant[x][y].etat=true;
	}
	
	protected void paintComponent(Graphics g) { // A COMPLETER, PB DE COULEUR DES CASES EN FONCTIOBNS DES FILIERES
       /* for(int lig=0 ; lig <nombreIconesx ; lig++) {
            for(int col=0 ; col <nombreIconesy ; col++) {
                    g.fillRect((int)(col*l),(int)(lig*h),(int)l,(int)h);
  
            }
        }*/
	}
	
	public void actualiserTour(){
		monPlateau.timer++;  //le timer augmente de 1, on passe à la semaine suivante
		monPlateau.leTour();
	}
	
	public String messageFinDePartie(){ //A COMPLETER
		String message="";
		/*for(int i=0, i<nombreIconesx, i++){
			for(int j=0, j<nombreIconesy, j++){
			}
		}*/
		return message;
	}
	
    
}
