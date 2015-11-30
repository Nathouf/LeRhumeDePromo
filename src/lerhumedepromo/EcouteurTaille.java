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
        if(x<=2 || y<=2){
            fen.setLabelErreur();
        } else {
        Plateau plateauJeu = new Plateau(y,x);
        fen.masquerFenetre();
        
       // FenetreJeu fenJeu = new FenetreJeu(plateauJeu, x , y );
        }
    }
}
