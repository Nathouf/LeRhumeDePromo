/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerhumedepromo;
import javax.swing.*;//utilisation de Widgets 
import java.awt.*; // Utilisation d'habillages
import java.awt.event.*;


public class FenetreTaille extends JFrame {
	
	private JTextField largeur;
	private JTextField longueur;
	private JLabel consigne;
	private JLabel nombreEtudiantsHorizontal;
	private JLabel nombreEtudiantsVertical;
	private JLabel messageErreur;
	private JButton creerPlateau;
	
	public FenetreTaille(){
		super("Taille de plateau");
			
			//Instanciations 
		largeur = new JTextField("2",4);
		longueur = new JTextField("2", 4);
		consigne = new JLabel("Sélectionner une taille de plateau");
		nombreEtudiantsHorizontal = new JLabel("Nombre étudiants par ligne (min 2)");
		nombreEtudiantsVertical = new JLabel("Nombre étudiants par colonne (min 2)");
		messageErreur = new JLabel();
		creerPlateau = new JButton("Créer");
		
			//Structure
		JPanel cadrePrincipal = new JPanel();
		JPanel tableauCommande = new JPanel();
		
		cadrePrincipal.setLayout(new BorderLayout());
		tableauCommande.setLayout(new BorderLayout());
		
		tableauCommande.add(nombreEtudiantsVertical, BorderLayout.NORTH);
		tableauCommande.add(largeur, BorderLayout.NORTH); //hauteur
		tableauCommande.add(nombreEtudiantsHorizontal, BorderLayout.CENTER);
		tableauCommande.add(longueur, BorderLayout.CENTER);
		tableauCommande.add(creerPlateau, BorderLayout.SOUTH);
		
		cadrePrincipal.add(consigne, BorderLayout.SOUTH);
		
		setContentPane(cadrePrincipal);
		setSize(600,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public int getLongueur(){
		 int x = 0;
		//verifie si input est bien un int
		try{
			x = Integer.parseInt(longueur.getText());
		}
		catch(Exception e){ 
			x = -1; //symbolise l'erreur	
		} 
		return x; 
	}
	
	public int getLargeur(){
		int y= 0;
		try{
			y = Integer.parseInt(largeur.getText());
		}
		catch(Exception e){ 
			y = -1; //symbolise l'erreur	
		} 
		return y; 
	}
	
	public void masquerFenetre(){
		setVisible(false);
	}
	
	public void setLabelErreur(){
		messageErreur.setText("Veuillez rentrer quelque chose de valide");
        
    }
}
