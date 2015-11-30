/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerhumedepromo;
import javax.swing.*;//utilisation de Widgets 
import java.awt.*; // Utilisation d'habillages
import java.awt.event.*;

public class FenetreTaille {
    private JTextField largeur;
	private JTextField longueur;
	private JLabel consigne;
	private JLabel nombreEtudiantsHorizontal;
	private JLabel nombreEtudiantsVertical;
	private JLabel messageErreur;
	private JButton creerPlateau;
	
	public FenetreTaille(){
		super("Taille de plateau ");
			
			//Instanciations 
		largeur = new JTextField("10",4);
		longueur = new JTextField("10", 4);
		consigne = new JLabel("Sélectionner une taille de plateau");
		nombreEtudiantsHorizontal = new JLabel("Nombre étudiants par ligne");
		nombreEtudiantsVertical = new JLabel("Nombre étudiants par colonne");
		messageErreur = new JLabel("Veuillez recommencer, cela n'a pas fonctionné!");
		creerPlateau = new JButton("Créer");
		
			//Structure
		JPanel cadrePrincipal = new JPanel();
		
		cadrePrincipal.add(consigne);
		cadrePrincipal.add(nombreEtudiantsVertical);
		cadrePrincipal.add(largeur); //hauteur
		cadrePrincipal.add(nombreEtudiantsHorizontal);
		cadrePrincipal.add(longueur);
		cadrePrincipal.add(creerPlateau);
		cadrePrincipal.add(messageErreur);
		
		setContentPane(cadrePrincipal);
		setSize(600,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public int getLongueur(){
		return longueur;
	}
	
	public int getLargeur(){
		return largeur;
	}
	
	public void masquerFenetre(){
		setVisible(false);
	}
    
}
