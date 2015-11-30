/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerhumedepromo;

/**
 *
 * @author Nath
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EcouteurPremierMalade implements MouseListener {
    
    private MaFenetreJeu FenetreJeu;
    private int posMaladeX;
    private int posMaladeY;

    
    public EcouteurPremierMalade(JPanel zoneDeDessin, int x, int y){
		
		
		}
		//pour MouseListener si on met pas toutes les méthodes
		//dans le code cela ne compile pas
		//même si on ne veut pas faire override
		
		public void mouseExited(MouseEvent e){}
		
		public void mouseEntered(MouseEvent e){}
		
		public void mouseReleased(MouseEvent e){}
		
		public void mousePressed(MouseEvent e){}
		
		public void mouseClicked(MouseEvent e) {//nous donne les coordonnées du clic
			posMaladeX = e.getX();
			posMaladeY = e.getY();	
			}
			
		public int getPosMaladeX(){//getter pour utiliser coord. dans les autres classes
			return posMaladeX;
			}	
			
		public int getPosMaladeY(){////getter pour utiliser coord. dans les autres classes
			return posMaladeY;
			}			
		
		
		
}

//plateau.addMouseListener(new MouseAdapter() {// pour implementer tous les méthodes
						//de MouseListener
                                           	// overrides seulement celles qu'on a changé 
						//autre solution pour ne pas écrire dans EcouteurPremierMalade
						// toute methode de MouseListener
