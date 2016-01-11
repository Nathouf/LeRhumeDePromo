
public class Etudiant {
    public boolean etat;
    public boolean incubation;
    public int filiere;
    private int fragilite;
    private int sociabilite;
    
    //evenements de l'année
    private boolean wei;
    private boolean ppJanvier;
    private boolean vingtQuatreHeures;
    private int timer;

    public Etudiant(int filiere, int fragilite, int sociabilité, boolean wei, boolean ppJanvier, boolean vingtQuatreHeures) {
        this.etat = false;
        this.incubation = false;
        this.filiere = filiere;
        this.fragilite = fragilite;
        this.sociabilite = sociabilite;
        this.wei = wei;
        this.ppJanvier = ppJanvier;
        this.vingtQuatreHeures = vingtQuatreHeures;
    }

    public void setEtat(int nbVoisins, int timer) {
        this.timer = timer;//intialisation de timer
        if (etat == true || nbVoisins == 0) {//l'étudiant est déja malade ou personne n'est malade autours de lui
            //ne rien faire
        } else {
            setIncubation(nbVoisins, timer);
        }
    }

    public boolean getEtat() {//récupere l'état pour l'utiliser dans paint component
        return etat;
    }

    public int getFiliere() {//donne les filières sous forme de int : nécéssaire pour créer les couleurs dans paint component
        return filiere;
    }

    public int getTimer() {// pour me donner timer pour utiliser dans les filières
        return timer;
    }

    public void setIncubation(int nbVoisins, int timer) {
        int C1 = fragilite + sociabilite;
        int C2 = 0; //les constantes C2,C3,C4 vont augmenter si l'etudiant participe aux differnts evenements
        int C3 = 0;
        int C4 = 0;
        int C5 = 0;//pas forcement nécessaire mais plus clair = C5 correspond au nombre voisins
        int C6 = 0;

        if (this.wei && timer == 1) { //si l'etudiant participe au wei et qu'on est en période de wei (semaine 2)
            C2 = 8; //l'etudiant a plus de riques d'imcuber la maladie
        }
        if (this.ppJanvier && timer == 15) { //si l'etudiant participe au ppJanvier et qu'on est en periode de ppJanvier (semaine 15)
            C3 = 8; //l'etudiant a plus de riques d'imcuber la maladie
        }
        if (this.vingtQuatreHeures && timer == 28) { //si l'etudiant participe au 24h et qu'on est en période de 24h (semaine 28)
            C4 = 8; //l'etudiant a plus de riques d'imcuber la maladie
        }
        if (nbVoisins <= 1) {
            //ne rien faire juste ici pour montrer que cas pris en compte
        }
        if (nbVoisins == 2 && C1 >= 8) {
            C5 = 4;
        }
        if (nbVoisins == 3 && C1 >= 4) {
            C5 = 4;
        }
        if (nbVoisins == 4) {
            C5 = 4;
        }
        if (filiere == 4) {
            C6 = 2;//nerf un peu les Sport Et
        }
        if ((2 * C1 + C2 + C3 + C4 + 3 * C5) >= 6) {
            this.incubation = true;
        }
    }

    public void lesSymptomesApparaissent() {//tous les étudiants qui étaient sous incubation deviennent malade
        if (incubation) {
            etat = true;
            incubation = false;
        }
    }
}
