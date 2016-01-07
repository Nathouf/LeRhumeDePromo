package lerhumedepromo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;

public class MonPanelDessin extends JPanel {

    private FenetreJeu fenJeu;
    private int nbIconesx;
    private int nbIconesy;

    public MonPanelDessin(FenetreJeu fen) {
        fenJeu = fen;
        nbIconesx = fenJeu.nombreIconesx;
        nbIconesy = fenJeu.nombreIconesy;
    }

    protected void paintComponent(Graphics g) {//on "peint" le tableau pour différencier les étudiants
        int largeur = this.getWidth();
        int hauteur = this.getHeight();
        super.paintComponent(g);
        //on parcours le tableau et on traite les cases une à une
        for (int lig = 0; lig < fenJeu.monPlateau.tabEtudiant.length; lig++) {
            for (int col = 0; col < fenJeu.monPlateau.tabEtudiant[0].length; col++) {

                if (fenJeu.monPlateau.tabEtudiant[lig][col].getEtat()) {//si etat==true, l'étudiant est malade et il devient rouge
                    g.setColor(Color.decode("0xdd1f1f"));
                } //sinon on regarde les autres
                else if (fenJeu.monPlateau.tabEtudiant[lig][col].getFiliere() == 1) {//on trie les étudiants en fonction de leur filière
                    g.setColor(Color.decode("0x049c00"));
                }//puis on leur assigne une couleur
                else if (fenJeu.monPlateau.tabEtudiant[lig][col].getFiliere() == 2) {
                    g.setColor(Color.decode("0x8900F2"));
                } else if (fenJeu.monPlateau.tabEtudiant[lig][col].getFiliere() == 3) {
                    g.setColor(Color.decode("0xe6ed3d"));
                } else if (fenJeu.monPlateau.tabEtudiant[lig][col].getFiliere() == 4) {
                    g.setColor(Color.decode("0xf1a31b"));
                } else if (fenJeu.monPlateau.tabEtudiant[lig][col].getFiliere() == 5) {
                    g.setColor(Color.decode("0x13dbc8"));
                } else if (fenJeu.monPlateau.tabEtudiant[lig][col].getFiliere() == 6) {
                    g.setColor(Color.cyan);
                }
                //fillRect colorie les cases en fonction des couleurs attribuées aux filières
                g.fillRect(col * (int) (largeur / nbIconesx), lig * (int) (hauteur / nbIconesy), (int) (largeur / nbIconesx), (int) (hauteur / nbIconesy));
                //pour rendre plus propre le visuel: on crée des bordures au tableau
                g.setColor(Color.black);
                g.drawRect(col * (int) (largeur / nbIconesx), lig * (int) (hauteur / nbIconesy), (int) (largeur / nbIconesx), (int) (hauteur / nbIconesy));
            }

        }

    }
}
