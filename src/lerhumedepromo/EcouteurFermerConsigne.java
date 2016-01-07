package lerhumedepromo;

import java.awt.event.*;

public class EcouteurFermerConsigne implements ActionListener {

    private FenetreConsigne consigne;
    private FenetreJeu fenJeu;

    public EcouteurFermerConsigne(FenetreConsigne fen, FenetreJeu fenJeu) {
        consigne = fen;
        this.fenJeu = fenJeu;
    }

    public void actionPerformed(ActionEvent e) {
        consigne.masquerFenetre(); //on masque la fenetre quand on clique sur le bouton et la fenetre de jeu apparait
        fenJeu.afficherFenetre(); //on affiche la fenetre jeu pour que le joueur puisse commencer à jouer
    }
}
