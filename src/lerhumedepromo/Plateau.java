package lerhumedepromo;
public class Plateau {
    private Etudiant[][] tabEtudiant;
    private int timer;

    public Plateau(int hauteur, int longueur){
        tabEtudiant = new Etudiant[hauteur][longueur];
        timer=1;
    }
  /*  public void generationTableau(){
        for(int i=0;i<tabEtudiant.length;i++){
            for(int j=0;j<tabEtudiant[0].length;j++){
                //on genere un entier aléatoire entre 1 et 6 pour choisir la filière
                int nombreAleatoire = 1 + (int)(Math.random()*6);    
                //on utulise switch case plutot qu'une horrible boucle if else
                switch(nombreAleatoire){
                    case 1:
                        tabEtudiant[i][j]=new Eurinsa();
                        break;
                    case 2:
                        tabEtudiant[i][j]=new Amerinsa();
                        break;
                    case 3:
                        tabEtudiant[i][j]=new Asinsa();
                        break;
                    case 4:
                        tabEtudiant[i][j]=new SportEt();
                        break;
                    case 5:
                        tabEtudiant[i][j]=new Classique();
                        break;
                    case 6:
                        tabEtudiant[i][j]=new ZiqEt();
                        break;
                }
            }
        }
    }*/
    public void setTimer(){
        timer++;
    }
    public void leTour(){
        for(int i=0;i<tabEtudiant.length;i++){
            for(int j=0;j<tabEtudiant[0].length;j++){
                tabEtudiant[i][j].lesSymptomesApparaissent();
            }
        }
        for(int i=0;i<tabEtudiant.length;i++){
            for(int j=0;j<tabEtudiant[0].length;j++){
                int nbVoisins = compteurVoisins(i,j);
                tabEtudiant[i][j].setEtat(nbVoisins);
            }
        }
        
    }
    
    public int compteurVoisins(int i, int j){
        int nbVoisins=0;
        if(i==0 && j==0){
            if(tabEtudiant[i+1][j].etat){
                nbVoisins++;
            }
            if(tabEtudiant[i][j+1].etat){
                nbVoisins++;
            }
        }
        if(i==0 && j!=tabEtudiant[0].length && j!=0){
            if(tabEtudiant[i+1][j].etat){
                nbVoisins++;
            }
        }
        return nbVoisins;//a changer
    }
    
    public boolean finPartie(){
        boolean fin = true; //si on rencontre un seul étudiant non malade, la partie n'est pas finie
        for(int i=0;i<tabEtudiant.length;i++){
            for(int j=0;j<tabEtudiant[0].length;j++){
                fin=(fin && tabEtudiant[i][j].etat);
            }
        }
        return fin;
    }
    
}
