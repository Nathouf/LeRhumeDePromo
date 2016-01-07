package lerhumedepromo;

import java.awt.event.*;

public class EcouteurTaille implements ActionListener {

    private FenetreTaille fen;

    public EcouteurTaille(FenetreTaille fen) {
        this.fen = fen;
    }

    public void actionPerformed(ActionEvent ae) {
        int x = fen.getLongueur();
        int y = fen.getLargeur();//équivaut à la hauteur du tableau
        if (x <= 2 || y <= 2) {
            fen.setLabelErreur();//Pour afficher un message d'erreur au cas où le joueur ne respecte pas la taille du tableau minimum
        } else {
            Plateau plateauJeu = new Plateau(y, x);
            fen.masquerFenetre(); //si les valeurs entrées sont correctes, on masque la FenêtreTaille
            FenetreJeu fenJeu = new FenetreJeu(plateauJeu, x, y);
            FenetreConsigne fenConsigne = new FenetreConsigne(fenJeu); //création de la FenetreConsigne
        }
    }
}
