/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerhumedepromo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;

/**
 *
 * @author Nath
 */
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
    private JPanel panelDeCommande = new JPanel(); //zone qui contient l'étiquette labelTimer et le bouton passerTour (en haut)
    private JPanel cadrePrincipal = new JPanel(new BorderLayout());
    ;
    private JPanel zoneDeLegende = new JPanel(new BorderLayout()); //zone qui contient la légende (à droite)

    public FenetreJeu(Plateau plateau, int nbreIconesx, int nbreIconesy) {
        super("Fenêtre de jeu");
        this.nombreIconesx = nbreIconesx; //nombre de colonnes
        this.nombreIconesy = nbreIconesy;  //nombre de lignes
        monPlateau = plateau;
        monPanelDessin = new MonPanelDessin(this);

        consignePremierMalade = new JLabel("Cliquez sur le premier étudiant à infecter");
        ecoutPremierMalade = new EcouteurPremierMalade(this);//instanciation,, pas nécessaire maintenant que j'y pense,, on verra

        //Instanciations
        labelTimer = new JLabel("Semaine 1");
        passerTour = new JButton("Passer tour");
        legende = new JLabel(" Légende ");

        monPanelDessin.addMouseListener(ecoutPremierMalade);

        zoneDeLegende.add(legende, BorderLayout.NORTH);
        cadrePrincipal.add(monPanelDessin, BorderLayout.CENTER);
        cadrePrincipal.add(panelDeCommande, BorderLayout.NORTH);
        cadrePrincipal.add(zoneDeLegende, BorderLayout.EAST);

        monPanelDessin.repaint();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //la fenêtre se ferme quand on clique sur la x
        setSize(600, 400);
        setContentPane(cadrePrincipal);
        setVisible(true);

    }

    public void setLabelTimer() {
        labelTimer.setText("Semaine : " + monPlateau.timer); //on modifie l'étiquette du timer en fonction de la semaine
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

    public void ecranFinPartieWin() {
        cadrePrincipal.remove(monPanelDessin);
        cadrePrincipal.remove(zoneDeLegende);
        for (ActionListener act : passerTour.getActionListeners()) { //On doit passer par ca par l'action listener de passer tour est anonyme
            passerTour.removeActionListener(act);
        }
        repaint();

        JLabel messageWin = new JLabel("Win");

        cadrePrincipal.add(messageWin, BorderLayout.CENTER);
    }
     public void ecranFinPartieLose() {
        cadrePrincipal.remove(monPanelDessin);
        cadrePrincipal.remove(zoneDeLegende);
        for (ActionListener act : passerTour.getActionListeners()) { //On doit passer par ca par l'action listener de passer tour est anonyme
            passerTour.removeActionListener(act);
        }
        repaint();
        JLabel messageWin = new JLabel("Lose");

        cadrePrincipal.add(messageWin, BorderLayout.CENTER);
        //AJOUTER UN MESSAGE / ANIMATION
    }

}
