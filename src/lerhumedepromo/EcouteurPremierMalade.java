
import java.awt.event.*;

public class EcouteurPremierMalade implements MouseListener {

    private FenetreJeu FenetreJeu;
    public int posMaladeX;
    public int posMaladeY;

    public EcouteurPremierMalade(FenetreJeu fen) {
        FenetreJeu = fen;

    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {//nous donne les coordonnées du clic
        posMaladeX = e.getX();
        posMaladeY = e.getY();
        int x = posMaladeX / (FenetreJeu.monPanelDessin.getWidth() / FenetreJeu.nombreIconesx);
        int y = posMaladeY / (FenetreJeu.monPanelDessin.getHeight() / FenetreJeu.nombreIconesy);
        FenetreJeu.monPlateau.tabEtudiant[y][x].etat = true;
        FenetreJeu.monPanelDessin.repaint();
        FenetreJeu.DepartJeu();
    }

}
