
import javax.swing.*;//utilisation de Widgets
import java.awt.*; // Utilisation d'habillages

public class FenetreTaille extends JFrame {

    private JTextField largeur;
    private JTextField longueur;
    private JLabel consigne;
    private JLabel nombreEtudiantsHorizontal;
    private JLabel nombreEtudiantsVertical;
    private JLabel messageErreur;
    private JButton creerPlateau;

    public FenetreTaille() {
        super("Taille de plateau");
        //Instanciations des JTextFields
        largeur = new JTextField("", 4);
        longueur = new JTextField("", 4);
        consigne = new JLabel("Sélectionner une taille de plateau");
        
        //Instanciations Jlabel
        nombreEtudiantsHorizontal = new JLabel("Nombre étudiants par colonne (min 3)");
        nombreEtudiantsVertical = new JLabel("Nombre étudiants par ligne (min 3)");
        messageErreur = new JLabel();
        
        //Le bouton
        creerPlateau = new JButton("Créer");
        
        //Ecouteurs
        creerPlateau.addActionListener(new EcouteurTaille(this));
        
         //Instanticiations JPanel
        JPanel cadrePrincipal = new JPanel();
        JPanel tableauCommande = new JPanel();
        JPanel caseX = new JPanel(new FlowLayout());
        JPanel caseY = new JPanel(new FlowLayout());
        
        //Ajout des JTextField dans les JPanel
        caseX.add(nombreEtudiantsVertical);
        caseX.add(largeur);
        caseY.add(nombreEtudiantsHorizontal);
        caseY.add(longueur);
        
        ////Ajout des Jpanels + Ecouteurs dans les Jpanels principaux
        cadrePrincipal.setLayout(new BorderLayout());
        tableauCommande.setLayout(new BorderLayout());
        tableauCommande.add(creerPlateau, BorderLayout.SOUTH);
        tableauCommande.add(caseX, BorderLayout.NORTH);
        tableauCommande.add(caseY, BorderLayout.CENTER);
        cadrePrincipal.add(consigne, BorderLayout.NORTH);
        cadrePrincipal.add(tableauCommande, BorderLayout.CENTER);
        cadrePrincipal.add(messageErreur, BorderLayout.SOUTH);
        
        //Caractéristiques de la fenêtre
        setContentPane(cadrePrincipal);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    //Récupération des valeurs de taille de tableau mises par l'utilisateur
    public int getLongueur() {
        int x = 0;
        //verifie si input est bien un int
        try {
            x = Integer.parseInt(longueur.getText());
        } catch (Exception e) { //si ce n'est pas le cas
            x = -1; // le -1 symbolise l'erreur
        }
        return x;
    }
    
    public int getLargeur() {//de même pour la largeur
        int y = 0;
        try {
            y = Integer.parseInt(largeur.getText());
        } catch (Exception e) {
            y = -1; //symbolise l'erreur
        }
        return y;
    }

    public void masquerFenetre() {//une fois qu'une fenêtre n'est plus utile
        setVisible(false);
    }

    public void setLabelErreur() {
        messageErreur.setText("Veuillez rentrer quelque chose de valide");
    }
}
