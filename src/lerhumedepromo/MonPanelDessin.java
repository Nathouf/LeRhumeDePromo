package lerhumedepromo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;



public class MonPanelDessin extends JPanel {
	
	private FenetreJeu fenJeu;
	private int nbIconesx;
	private int nbIconesy;

public MonPanelDessin(FenetreJeu fen){
fenJeu=fen;
nbIconesx = fenJeu.nombreIconesx;
nbIconesy = fenJeu.nombreIconesy;
}
	

	
	protected void paintComponent(Graphics g) { // A COMPLETER, PB DE COULEUR DES CASES EN FONCTIOBNS DES FILIERES
            super.paintComponent(g);

            for(int lig=0 ; lig <nbIconesx ; lig++) {
                for(int col=0 ; col <nbIconesy ; col++) {
            
            
                    if(fenJeu.monPlateau.tabEtudiant[lig][col].getEtat()){//si etat true(donc si malade) il devient rouge
                        g.setColor(Color.red);            }//sinon on regarde les autres
                    else if(fenJeu.monPlateau.tabEtudiant[lig][col].getFiliere()==1){//d'abord on prend le filiere on fait if pour 
                        g.setColor(Color.orange);            }//trouver les filieres et on leur assigne une couleur
                    else if(fenJeu.monPlateau.tabEtudiant[lig][col].getFiliere()==2){//puis le fillRect dois donner la couleur qui correspond
                        g.setColor(Color.white);            }//si tout se passe bien
                    else if(fenJeu.monPlateau.tabEtudiant[lig][col].getFiliere()==3){
                        g.setColor(Color.yellow);            }
                    else if(fenJeu.monPlateau.tabEtudiant[lig][col].getFiliere()==4){
                        g.setColor(Color.green);            }
                    else if(fenJeu.monPlateau.tabEtudiant[lig][col].getFiliere()==5){
                        g.setColor(Color.blue);            }
                    else if(fenJeu.monPlateau.tabEtudiant[lig][col].getFiliere()==6){
                        g.setColor(Color.black);            }
                    
                    g.fillRect(col*fenJeu.getSizeIconeX(),lig*fenJeu.getSizeIconeY(),fenJeu.getSizeIconeX(),fenJeu.getSizeIconeY());

                        }
               }
            

            
           
  
            }
        }
