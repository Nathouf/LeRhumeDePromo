
import javax.swing.*;
import java.awt.*;

public class FenetreConsigne extends JFrame {

    private JPanel cadreConsigne;
    private JLabel consignes;
    private JButton fermerFenetre;
    private FenetreJeu fenJeu;

    public FenetreConsigne(FenetreJeu fenJeu) {
        super("Règles du jeu");
        cadreConsigne = new JPanel(new BorderLayout());
        //Le contenu du JLabel consignes est très long. On utilise la syntaxe HTML pour faire des retour à la ligne
        consignes = new JLabel("<html>Le but du jeu est de contaminer l'ensemble de la population étudiante avant la fin de l'année (40 semaines).<br> Au premier tour, le joueur place son virus sur l'un des étudiants afin de l'infecter.<br> Au fur et à mesure des semaines, le virus se propage.<br> Après une semaine d'incubation, les étudiants infectés tombent malade.<br> Différents évènements viennent augmenter le risque pour les étudiants de tomber malade <br> (WEI pour la semaine 1, postPartiels de janvier semaine 15, 24h de l'INSA semaine 28). <br> Les étudiants des différentes filières ont des caractéristiques différentes et ne tombent pas tous aussi facilement malade. <br> A vous de bien placer votre virus au premier tour. <br> Bonne chance! </html>");
        consignes.setVerticalAlignment(SwingConstants.CENTER); //on centre le texte
        consignes.setHorizontalAlignment(JLabel.CENTER);
        fermerFenetre = new JButton("Jouer");
        this.fenJeu = fenJeu;
        fermerFenetre.addActionListener(new EcouteurFermerConsigne(this, fenJeu));//quand on clique sur le bouton, on masque la fenetre de consigne et on affiche la fenetre de jeu
        cadreConsigne.add(consignes, BorderLayout.CENTER);
        cadreConsigne.add(fermerFenetre, BorderLayout.SOUTH);
        //Caractéristiques basiques de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //la fenêtre se ferme quand on clique sur la x
        setSize(600, 400);
        setContentPane(cadreConsigne);
        setVisible(true);
    }

    public void masquerFenetre() {
        setVisible(false);
    }
}
