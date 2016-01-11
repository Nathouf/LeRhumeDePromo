
import java.awt.event.*;

//on doit expliciter toutes les méthodes de MouseListener pour que ça fonctionne, même si elles ne sont pas utiles
public class EcouteurPremierMalade implements MouseListener {

    private FenetreJeu FenetreJeu;
    public int posMaladeX;
    public int posMaladeY;

    public EcouteurPremierMalade(FenetreJeu fen) {
        FenetreJeu = fen;

    }
    //ne sert pas
    public void mouseExited(MouseEvent e) {
    }
    //ne sert pas 
    public void mouseEntered(MouseEvent e) {
    }
    //ne sert pas
    public void mouseReleased(MouseEvent e) {
    }
    //ne sert pas 
    public void mousePressed(MouseEvent e) {
    }
    //nous permet de récuperer les coordonnées du clic
    public void mouseClicked(MouseEvent e) {
        posMaladeX = e.getX(); //recupere les coordonnées en pixels
        posMaladeY = e.getY();
        int x = posMaladeX / (FenetreJeu.monPanelDessin.getWidth() / FenetreJeu.nombreIconesx); //on recupère la taille de chaque cases en divisant la longueur/largeur du tableau par le nombre de cases
        int y = posMaladeY / (FenetreJeu.monPanelDessin.getHeight() / FenetreJeu.nombreIconesy); //puis on divise les coordonnées en pixel par la taille obtenue pour avoir la case ou a été faite le clic
        FenetreJeu.monPlateau.tabEtudiant[y][x].etat = true; //on change l'état de l'étudiant placé sur la case cliquée
        FenetreJeu.monPanelDessin.repaint(); //réinitialise le plateau
        FenetreJeu.DepartJeu(); //lance le jeu
    }

}
