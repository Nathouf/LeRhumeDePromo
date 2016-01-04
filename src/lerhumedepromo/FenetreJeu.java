
package lerhumedepromo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.ImageIcon;
//import javax.swing.JProgressBar;


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
        //progress Bar
    //private JProgressBar pBEur;
	//private JProgressBar pBZiq;
	//private JProgressBar pBCla;
	//private JProgressBar pBSpEt;
	//private JProgressBar pBAs;
	//private JProgressBar pBAm;
    private JPanel panelDeCommande = new JPanel(); //zone qui contient l'étiquette labelTimer et le bouton passerTour (en haut)
    private JPanel cadrePrincipal = new JPanel(new BorderLayout());
    private JPanel zoneDeLegende = new JPanel(new BorderLayout()); //zone qui contient la légende (à droite)
    private JTextArea evenement; //afficher les évènements de chaque semaine

    public FenetreJeu(Plateau plateau, int nbreIconesx, int nbreIconesy) {
        super("Fenêtre de jeu");
        this.nombreIconesx = nbreIconesx; //nombre de colonnes
        this.nombreIconesy = nbreIconesy;  //nombre de lignes
        monPlateau = plateau;
        monPanelDessin = new MonPanelDessin(this);

        consignePremierMalade = new JLabel("Cliquez sur le premier étudiant à infecter");
        panelDeCommande.add(consignePremierMalade);
        ecoutPremierMalade = new EcouteurPremierMalade(this);//instanciation,, pas nécessaire maintenant que j'y pense,, on verra
        //pas trop sure de ou il faut placer l'instanciation
        //pBarEur = new JProgressBar(0, nbrEr);
        //pBAm = new JProgressBar(0, nbrAm);
        //pBAs = new JProgressBar(0, nbrAs);
        //pBZiq = new JProgressBar(0, nbrZiq);
        //pBSpEt = new JProgressBar(0, nbrSpEt);
        //pBCla = new JProgressBar(0, nbrCla);

        //Instanciations
        labelTimer = new JLabel("Semaine 1");
        passerTour = new JButton("Passer tour");
       // legende = new JLabel(" Légende ");

        File origFile = new File("C:\\Users\\Nath\\Desktop\\laplusbelle.jpg");
        ImageIcon icon = new ImageIcon(origFile.getPath());

        legende = new JLabel(icon);
                legende.setText("Légende");
                legende.setHorizontalTextPosition(JLabel.CENTER);
                legende.setVerticalTextPosition(JLabel.TOP);



        monPanelDessin.addMouseListener(ecoutPremierMalade);

        zoneDeLegende.add(legende, BorderLayout.NORTH);
        //zoneDeLegende.add(pBEur, BorderLayout.CENTER);
        //zoneDeLegende.add(pBAm, BorderLayout.CENTER);
        //zoneDeLegende.add(pBAs, BorderLayout.CENTER);
        //zoneDeLegende.add(pBZiq, BorderLayout.CENTER);
        //zoneDeLegende.add(pBSpEt, BorderLayout.CENTER);
        //zoneDeLegende.add(pBCla, BorderLayout.CENTER);
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

        JLabel messageWin = new JLabel("Bravo, vous avez gagné! Tous les étudiants ont été infectés avant la fin de l'année!");

        cadrePrincipal.add(messageWin, BorderLayout.CENTER);
    }
     public void ecranFinPartieLose() {
        cadrePrincipal.remove(monPanelDessin);
        cadrePrincipal.remove(zoneDeLegende);
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
    
    //int newValue = 0;
	/*public void updateBar(Etudiant e){
	 * 
	 * if( e.getFilière == Eurinsa){
	 * newValue = newValue +1;
	 * pBEur.setValue(newValue);
	 * 
		}
	* if( e.getFilière == Amerinsa){
	 * newValue = newValue +1;
	 * pBAm.setValue(newValue);
	 * 
		}
	* if( e.getFilière == Asinsa){
	 * newValue = newValue +1;
	 * pBAs.setValue(newValue);
	 * 
		}
	* if( e.getFilière == SportEt){
	 * newValue = newValue +1;
	 * pBSpEt.setValue(newValue);
	 * 
		}
	* if( e.getFilière == ZiqEt){
	 * newValue = newValue +1;
	 * pBZiq.setValue(newValue);
	 * 
		}
	* if( e.getFilière == Classique){
	 * newValue = newValue +1;
	 * pBCla.setValue(newValue);
	 * 
		}
	}*/
	
	public void setEvenement(){
		
		//comme timer est dans plateau
		if(monPlateau.timer==1){
			evenement.setText("Pour fêter l'arrivée des primo-rentrants, certains partent au WEI !");
		}
		if(monPlateau.timer==15){
			evenement.setText("Pour décompresser de la semaine de DS, les Etudiants participent aux post-partiels !");
		}
		if(monPlateau.timer==28){
			evenement.setText("Le beau temps, l'air printanier..C'est l'heure des 24H !");	
		}
		if(monPlateau.timer==30){
			evenement.setText("C'est la fin d'année, c'est les Post-partiels de Juin !!");
		}

	}

}
