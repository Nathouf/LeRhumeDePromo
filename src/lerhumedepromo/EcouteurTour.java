
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
       fenetreJeu.actualiserTour();//actualise la fenetreJeu par rapport au nombre de malades pour la semaine suivante
       monPanelDessin.repaint();// repaint est utilisé pour changer les élèves devenus malades en rouge
       fenetreJeu.setLabelTimer();//pour incrementer le nombre de semaine dans fenetreJeu et faire évoluer le jeu dans le temps
       if(fenetreJeu.monPlateau.finPartie()==1){
           fenetreJeu.ecranFinPartieLose();
       }
       if(fenetreJeu.monPlateau.finPartie()==2){
           fenetreJeu.ecranFinPartieWin();
       }


}
}

