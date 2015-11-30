package lerhumedepromo;

public class Plateau {

    public Etudiant[][] tabEtudiant; //on met en public pour y acceder plus facilement dans les autres classes
    public int timer;               //on met en public pour y acceder plus facilement dans les autres classes

    public Plateau(int hauteur, int longueur) {
                tabEtudiant = new Etudiant[hauteur][longueur];
        timer = 1;
    }
    


    public void generationTableau() {
        for (int i = 0; i < tabEtudiant.length; i++) {
            for (int j = 0; j < tabEtudiant[0].length; j++) {
                //on genere un entier aléatoire entre 1 et 6 pour choisir la filière
                int nombreAleatoire = 1 + (int) (Math.random() * 6);
                //on utilise switch case plutot qu'une horrible boucle if else
                switch (nombreAleatoire) {
                    case 1:
                        tabEtudiant[i][j] = new Eurinsa();
                        break;
                    case 2:
                        tabEtudiant[i][j] = new Amerinsa();
                        break;
                    case 3:
                        tabEtudiant[i][j] = new Asinsa();
                        break;
                    case 4:
                        tabEtudiant[i][j] = new SportEt();
                        break;
                    case 5:
                        tabEtudiant[i][j] = new Classique();
                        break;
                    case 6:
                        tabEtudiant[i][j] = new ZiqEt();
                        break;
                }
            }
        }
    }

    public void setTimer() {
        timer++;
    }
    

    public void leTour() {
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

    public boolean finPartie() {
        boolean fin = true; //si on rencontre un seul étudiant non malade, la partie n'est pas finie
        for (int i = 0; i < tabEtudiant.length; i++) {
            for (int j = 0; j < tabEtudiant[0].length; j++) {
                fin = (fin && tabEtudiant[i][j].etat);
            }
        }
        return fin;
    }

}
