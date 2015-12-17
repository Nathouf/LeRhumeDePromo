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

public class EcouteurTour implements ActionListener{
    
    private FenetreJeu fenetreJeu;
    private MonPanelDessin monPanelDessin;
    
    public EcouteurTour(FenetreJeu fenetreDeJeu, MonPanelDessin monPanel){
        fenetreJeu = fenetreDeJeu;
        monPanelDessin = monPanel;
        
    }
    
    @Override
    	public void actionPerformed(ActionEvent e){
       fenetreJeu.actualiserTour();
       monPanelDessin.repaint();
       fenetreJeu.setLabelTimer();
       if(fenetreJeu.monPlateau.finPartie()){
           fenetreJeu.ecranFinPartie();
       }
       
        
}
}
        
