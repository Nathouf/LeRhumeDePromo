
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.ImageIcon;
//inutile d'importer les sous fichiers de Java swing comme ProgressBar

public class FenetreJeu extends JFrame {

    public Plateau monPlateau;
    private JLabel labelTimer;
    private JLabel consignePremierMalade;
    private JButton passerTour;
    private JLabel legende;
    public int nombreIconesx;
    public int nombreIconesy;
    public MonPanelDessin monPanelDessin;
    private EcouteurPremierMalade ecoutPremierMalade;//pour nous donner sa position

    private JProgressBar pBMalades;

    private JPanel panelDeCommande = new JPanel(); //zone qui contient l'étiquette labelTimer et le bouton passerTour (en haut)
    private JPanel cadrePrincipal = new JPanel(new BorderLayout());
    private JPanel zoneDeLegende = new JPanel(new BorderLayout()); //zone qui contient la légende (à droite)
    private JLabel evenement; //afficher les évènements de chaque semaine

    public FenetreJeu(Plateau plateau, int nbreIconesx, int nbreIconesy) {
        super("Fenêtre de jeu");
        this.nombreIconesx = nbreIconesx; //nombre de colonnes
        this.nombreIconesy = nbreIconesy;  //nombre de lignes
        monPlateau = plateau;
        monPanelDessin = new MonPanelDessin(this);
        zoneDeLegende.setBackground(Color.decode("0xD1DDD3"));
        panelDeCommande.setBackground(Color.decode("0xD1DDD3"));

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("./src/lerhumedepromo/seringue.png");
        Cursor c = toolkit.createCustomCursor(image, new Point(monPanelDessin.getX(),
                monPanelDessin.getY()), "img");
        monPanelDessin.setCursor(c);

        consignePremierMalade = new JLabel("Cliquez sur le premier étudiant à infecter");
        panelDeCommande.add(consignePremierMalade);
        ecoutPremierMalade = new EcouteurPremierMalade(this);
        pBMalades = new JProgressBar(0, monPlateau.tabEtudiant[0].length * monPlateau.tabEtudiant.length);
        pBMalades.setForeground(Color.decode("0xdd1f1f"));
        pBMalades.setBackground(Color.GREEN);
        pBMalades.setStringPainted(true);
        pBMalades.setString("Infectés");
        labelTimer = new JLabel("Semaine 1");
        passerTour = new JButton("Passer tour");
        evenement = new JLabel();
        zoneDeLegende.setPreferredSize(new Dimension(200, monPanelDessin.getHeight()));
        File origFile = new File( "./src/lerhumedepromo/legende.png");
        ImageIcon icon = new ImageIcon(origFile.getPath());

        legende = new JLabel(icon);
        legende.setText("Légende");
        legende.setHorizontalTextPosition(JLabel.CENTER);
        legende.setVerticalTextPosition(JLabel.TOP);

        monPanelDessin.addMouseListener(ecoutPremierMalade);

        zoneDeLegende.add(legende, BorderLayout.NORTH);
        zoneDeLegende.add(pBMalades, BorderLayout.SOUTH);
        zoneDeLegende.add(evenement, BorderLayout.CENTER);

        cadrePrincipal.add(monPanelDessin, BorderLayout.CENTER);
        cadrePrincipal.add(panelDeCommande, BorderLayout.NORTH);
        cadrePrincipal.add(zoneDeLegende, BorderLayout.EAST);

        monPanelDessin.repaint();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //la fenêtre se ferme quand on clique sur la x
        setSize(600, 400);
        setContentPane(cadrePrincipal);
        setVisible(false);

    }

    public void setLabelTimer() {
        labelTimer.setText("Semaine : " + monPlateau.timer); //on modifie l'étiquette du timer en fonction de la semaine
        setEvenement();
    }

    /*public void setPremierMalade(int x, int y)
     à quoi servent les paramètres? coordonnées données pas mouseListener*/
    public void setPremierMalade() {
        int x = ecoutPremierMalade.posMaladeX;//nous donne la position qu'il a récupérée
        int y = ecoutPremierMalade.posMaladeY;

        monPlateau.tabEtudiant[x][y].etat = true;//maintenant la la méthode paintComponent va le peidre rouge et c'est fini
    }

    public void actualiserTour() {
        monPlateau.leTour();
        pBMalades.setValue(monPlateau.compteurMalades());//actualisation de la barre de Progrès
    }

    public void DepartJeu() {//On entre dans la phase de jeu tout par tour
        //    cadrePrincipal.add(passerTour,BorderLayout.SOUTH);
        passerTour.addActionListener(new EcouteurTour(this, monPanelDessin));//addition d'action au button,,changement car j'ai changé le constructeur pour qu'on mette repaint

        monPanelDessin.removeMouseListener(ecoutPremierMalade);//pour qu'on ne choississe qu'une fois le premier malade
        panelDeCommande.add(labelTimer, BorderLayout.NORTH);
        panelDeCommande.add(passerTour);
        consignePremierMalade.setText("");// la consigne initiale ne s'affiche plus
        revalidate(); //sert à actualiser la fenetre comme un repaint, sinon elle ne s'actualisait qu'au redimensionnement de la fenetre

    }

    public void ecranFinPartieWin() {//les actions à faire quand le joueur a gagné, utilisé dans ecouteurTour
        cadrePrincipal.remove(monPanelDessin);
        cadrePrincipal.remove(zoneDeLegende);
        panelDeCommande.remove(passerTour);
        panelDeCommande.remove(labelTimer);

        for (ActionListener act : passerTour.getActionListeners()) { //On doit passer par ca par l'action listener de passer tour est anonyme
            passerTour.removeActionListener(act);
        }
        repaint();

        JLabel messageWin = new JLabel("Bravo, vous avez gagné! Tous les étudiants ont été infectés avant la fin de l'année!");

        cadrePrincipal.add(messageWin, BorderLayout.CENTER);
    }

    public void ecranFinPartieLose() {//les actions à faire au cas où le joueur a perdu, utilisé dans ecouteurTour
        cadrePrincipal.remove(monPanelDessin);
        cadrePrincipal.remove(zoneDeLegende);
        panelDeCommande.remove(passerTour);
        panelDeCommande.remove(labelTimer);

        for (ActionListener act : passerTour.getActionListeners()) { //On doit passer par ca par l'action listener de passer tour est anonyme
            passerTour.removeActionListener(act);
        }
        repaint();
        JLabel messageWin = new JLabel("Vous avez perdu, il reste encore des étudiants en forme!");

        cadrePrincipal.add(messageWin, BorderLayout.CENTER);
        //AJOUTER UN MESSAGE / ANIMATION
    }

    public void afficherFenetre() {
        setVisible(true);
    }

    public void setEvenement() {

		//comme timer est dans plateau
        if (monPlateau.timer == 2) {
            evenement.setText("<html> Pour fêter l'arrivée <br> des primo-rentrants,<br>  certains partent au WEI ! </html>");
        } else if (monPlateau.timer == 15) {
            evenement.setText("<html>Pour décompresser<br> de la semaine de DS,<br> les Etudiants participent <br>aux post-partiels ! </html>");

        } else if (monPlateau.timer > 24 && monPlateau.timer < 27) {
            evenement.setText("<html>Les Sport'Et partent <br> aux championnats ! ils ont plus de risque de se blesser et<br> de tomber malades </html>");
        } else if (monPlateau.timer == 28) {
            evenement.setText("<html>Le beau temps, <br>l'air printanier..<br>C'est l'heure des 24H ! </html>");
        } else if (monPlateau.timer == 30) {
            evenement.setText("<html>C'est la fin d'année,<br> c'est les Post-partiels <br>de Juin !! </html>");
        } else if (monPlateau.timer == 38) {
            evenement.setText("<html>C'est bientôt la fin ! <br>Etait-ce trop ambitieux ?! </html>");
        } else {
            evenement.setText("");
        }

    }

}
