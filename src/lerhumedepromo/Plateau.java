package lerhumedepromo;

public class Plateau {

    public Etudiant[][] tabEtudiant; //on met en public pour y acceder plus facilement dans les autres classes
    public int timer;    //on met en public pour y acceder plus facilement dans les autres classes
    /* public  int nbrEr = 0;
	public int nbrAs = 0;
	public int nbrAm = 0;
	public int nbrCla = 0;
	public int nbrZiq = 0;
	public int nbrSpEt = 0;*/

    public Plateau(int hauteur, int longueur) {
        tabEtudiant = new Etudiant[hauteur][longueur];
        timer = 1;
        this.generationTableau(); //la methode crée le tableau puis le génère aléatoirement
    }



    public void generationTableau() {


		for (int j = 0; j < tabEtudiant[0].length; j++) {
			for (int i = 0; i < tabEtudiant.length; i++) {

                //on genere un entier aléatoire entre 1 et 6 pour choisir la filière
                int nombreAleatoire = 1 + (int) (Math.random() * 6);
                //on utilise switch case plutot qu'une horrible boucle if else
                switch (nombreAleatoire) {
                    case 1:
                        tabEtudiant[i][j] = new Eurinsa();
                        //nbrEr = nbrEr + 1;
                        break;
                    case 2:
                        tabEtudiant[i][j] = new Amerinsa();
                        //nbrAm = nbrAm + 1;
                        break;
                    case 3:
                        tabEtudiant[i][j] = new Asinsa();
                        //nbrAs = nbrAs + 1;
                        break;
                    case 4:
                        tabEtudiant[i][j] = new SportEt();
                        //nbrSpEt = nbrSpEt + 1;
                        break;
                    case 5:
                        tabEtudiant[i][j] = new Classique();
                        //nbrCla = nbrCla + 1;
                        break;
                    case 6:
                        tabEtudiant[i][j] = new ZiqEt();
                        //nbrZiq = nbrZiq +1;
                        break;
                }
            }
        }
    }

    public void setTimer() {
        timer++;
    }



    public void leTour() {//fait le tour du tableau deux fois : passe les incubés à la malade et appelle la methode setEtat qui détermine si un Etudiant devient incumbé
        for (int i = 0; i < tabEtudiant.length; i++) {
            for (int j = 0; j < tabEtudiant[0].length; j++) {
                tabEtudiant[i][j].lesSymptomesApparaissent();
            }
        }
        for (int i = 0; i < tabEtudiant.length; i++) {
            for (int j = 0; j < tabEtudiant[0].length; j++) {
                int nbVoisins = compteurVoisins(i, j);
                tabEtudiant[i][j].setEtat(nbVoisins, timer);
            }
        }
        setTimer();//il n'était utilisé null part


    }

    public int compteurVoisins(int i, int j) {//on ne compte pas les malades en diagonale
        int nbVoisins = 0;
        if (i == 0 && j == 0) {//en haut a gauche
            if (tabEtudiant[i + 1][j].etat) {
                nbVoisins++;
            }
            if (tabEtudiant[i][j + 1].etat) {
                nbVoisins++;
            }
        }
        if (i == 0 && j != (tabEtudiant[0].length) - 1 && j != 0) {//1ere ligne hors extrémités
            if (tabEtudiant[i + 1][j].etat) {
                nbVoisins++;
            }
            if (tabEtudiant[i][j + 1].etat) {
                nbVoisins++;
            }
            if (tabEtudiant[i][j - 1].etat) {
                nbVoisins++;
            }
        }
        if (i == (tabEtudiant.length) - 1 && j != (tabEtudiant[0].length) - 1 && j != 0) {//dernière ligne hors extrémités
            if (tabEtudiant[i - 1][j].etat) {
                nbVoisins++;
            }
            if (tabEtudiant[i][j + 1].etat) {
                nbVoisins++;
            }
            if (tabEtudiant[i][j - 1].etat) {
                nbVoisins++;
            }

        }
        if (i != 0 && i != (tabEtudiant.length) - 1 && j == 0) {//1ere colonne hors extrémités
            if (tabEtudiant[i - 1][j].etat) {
                nbVoisins++;
            }
            if (tabEtudiant[i +1 ][j].etat) {
                nbVoisins++;
            }
            if (tabEtudiant[i][j + 1].etat) {
                nbVoisins++;
            }
        }
        if (i != 0 && i != (tabEtudiant.length) - 1 && j == (tabEtudiant[0].length) - 1 ) {//dernière colonne hors extrémités
            if (tabEtudiant[i - 1][j].etat) {
                nbVoisins++;
            }
            if (tabEtudiant[i +1 ][j].etat) {
                nbVoisins++;
            }
            if (tabEtudiant[i][j - 1].etat) {
                nbVoisins++;
            }
        }
        if (i == (tabEtudiant.length) - 1 && j == (tabEtudiant[0].length) - 1) {//en bas à droite
            if (tabEtudiant[i - 1][j].etat) {
                nbVoisins++;
            }
            if (tabEtudiant[i][j - 1].etat) {
                nbVoisins++;
            }
        }
        if (i == (tabEtudiant.length) - 1 && j == 0) {//en bas à gauche
            if (tabEtudiant[i -1][j].etat) {
                nbVoisins++;
            }
            if (tabEtudiant[i][j + 1].etat) {
                nbVoisins++;
            }
        }
        if (i == 0 && j ==(tabEtudiant[0].length) - 1) {//en haut a droite
            if (tabEtudiant[i + 1][j].etat) {
                nbVoisins++;
            }
            if (tabEtudiant[i][j - 1].etat) {
                nbVoisins++;
            }
        }
         if (i != (tabEtudiant.length) - 1 && i != 0 && j != (tabEtudiant[0].length) - 1 && j!=0) {//cas quelconque
            if (tabEtudiant[i + 1][j].etat) {
                nbVoisins++;
            }
            if (tabEtudiant[i-1][j].etat) {
                nbVoisins++;
            }
            if (tabEtudiant[i ][j+1].etat) {
                nbVoisins++;
            }
            if (tabEtudiant[i][j-1].etat) {
                nbVoisins++;
            }
        }
        return nbVoisins;
    }

    public int finPartie() {
        int cas = 0;
        boolean tousMalade = true; //si on rencontre un seul étudiant non malade, la partie n'est pas finie
        for (int i = 0; i < tabEtudiant.length; i++) {
            for (int j = 0; j < tabEtudiant[0].length; j++) {
                tousMalade = (tousMalade && tabEtudiant[i][j].etat);
            }
        }
        if(timer==40 && !tousMalade){//Le joueur a perdu
            cas = 1;
        }
        if(timer<=40 && tousMalade){//Le joueur gagne
            cas = 2;
        }
        return cas;//si tout le monde est malade, le retour vaut 0 : le joueur a gagné !
    }

}
