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
    
    private FenetreJeu FenetreJeu;
    
    public EcouteurTour(FenetreJeu fenetreDeJeu){
        
        
    }
    
    @Override
    	public void actionPerformed(ActionEvent e){
       FenetreJeu.actualiserTour();
       FenetreJeu.repaint();
        }
}
        
