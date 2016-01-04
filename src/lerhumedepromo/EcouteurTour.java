
package lerhumedepromo;



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
       fenetreJeu.actualiserTour();//change le fenetreJeu par rapport le nouveau nombre des malades
       monPanelDessin.repaint();// repaint pour colorier rouges les élèves qui sont devenus malades
       fenetreJeu.setLabelTimer();//pour incrementer le nombre de semaine dans fenetreJeu
       if(fenetreJeu.monPlateau.finPartie()==1){
           fenetreJeu.ecranFinPartieLose();
       }
       if(fenetreJeu.monPlateau.finPartie()==2){
           fenetreJeu.ecranFinPartieWin();
       }


}
}

