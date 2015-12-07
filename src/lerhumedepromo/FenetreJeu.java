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
	private JButton passerTour;
	private JPanel zoneDeDessin;
	public int nombreIconesx;
	public int nombreIconesy;
	private MonPanelDessin monPanelDessin;
	
        
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
                monPanelDessin = new MonPanelDessin(this);
                passerTour.addActionListener(new EcouteurTour(this));//addition d'action au button
		
		cadrePrincipal.add(zoneDeDessin,BorderLayout.CENTER);
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
	
	protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            for(int lig=0 ; lig <nombreIconesx ; lig++) {
                for(int col=0 ; col <nombreIconesy ; col++) {
            
            
                    if(monPlateau.tabEtudiant[lig][col].getEtat()){//si etat true(donc si malade) il devient rouge
                        g.setColor(Color.red);            }//sinon on regarde les autres
                    else if(monPlateau.tabEtudiant[lig][col].getFiliere()==1){//d'abord on prend le filiere on fait if pour 
                        g.setColor(Color.orange);            }//trouver les filieres et on leur assigne une couleur
                    else if(monPlateau.tabEtudiant[lig][col].getFiliere()==2){//puis le fillRect dois donner la couleur qui correspond
                        g.setColor(Color.white);            }//si tout se passe bien
                    else if(monPlateau.tabEtudiant[lig][col].getFiliere()==3){
                        g.setColor(Color.yellow);            }
                    else if(monPlateau.tabEtudiant[lig][col].getFiliere()==4){
                        g.setColor(Color.green);            }
                    else if(monPlateau.tabEtudiant[lig][col].getFiliere()==5){
                        g.setColor(Color.blue);            }
                    else if(monPlateau.tabEtudiant[lig][col].getFiliere()==6){
                        g.setColor(Color.black);            }
                    
                    g.fillRect(col*getSizeIconeX(),lig*getSizeIconeY(),getSizeIconeX(),getSizeIconeY());

                        }
               }
            

            
           
  
            }
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
		 
		 monPanelDessin.addActionListener(null);//pour qu'on ne choississe qu'une fois le premier malade
		 panelDeCommande.add(labelTimer); //on ajoute les caractéristiques du jeu
		 panelDeCommande.add(passerTour);
		 consignePremierMalade.setText("");// la consigne initiale ne s'affiche plus 
	}
    
}
