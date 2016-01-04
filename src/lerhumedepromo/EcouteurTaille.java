package lerhumedepromo;
import javax.swing.*;
import java.awt.event.*;



public class EcouteurTaille implements ActionListener{
    private FenetreTaille fen;
    
    public EcouteurTaille(FenetreTaille fen){
        this.fen=fen;
    }
    public void actionPerformed(ActionEvent ae){
        int x=fen.getLongueur();
        int y=fen.getLargeur();//hauteur
        if(x<=2 || y<=2){
            fen.setLabelErreur();//Pour afficher un message d'erreur au cas où le joueur ne respecte pas la consigne du jeu par rapport la taille du tableau
        } else {
        Plateau plateauJeu = new Plateau(y,x);
        fen.masquerFenetre();
        
        FenetreJeu fenJeu = new FenetreJeu(plateauJeu, x , y );
        FenetreConsigne fenConsigne = new FenetreConsigne(fenJeu); //création d'un fenetre qui explique les consignes du jeu
        }
    }
}
