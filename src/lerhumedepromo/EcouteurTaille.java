package lerhumedepromo;
import javax.swing.*;
import java.awt.event.*;



public class EcouteurTaille {
    private FenetreTaille fen;
    
    public EcouteurTaille(FenetreTaille fen){
        this.fen=fen;
    }
    public void actionPerformed(ActionEvent ae){
        int x=fen.getLongueur();
        int y=fen.getLargeur();//hauteur
        Plateau plateauJeu = new Plateau(y,x);
        FenetreJeu fenJeu = new FenetreJeu(plateauJeu, x , y );
    }
}
