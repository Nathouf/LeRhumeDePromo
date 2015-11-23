
public class Etudiant {//certains attributs devront peut etre mis en public pour que le programme fonctionne
    //Cela permet de ne pas mettre plein de setters 
    public boolean etat;
    public boolean incubation;
    private int filiere ;
    private int fragilite;
    private int sociabilite;
    private boolean wei;
    private boolean ppJanvier;
    private boolean vingtQuatreHeures;
    //constucteur
    public Etudiant(boolean etat, boolean incubation,  int filiere ,int fragilite,int sociabilité, boolean wei, boolean ppJanvier, boolean vingtQuatreHeures){
        this.etat=etat;
        this.incubation=incubation;
        this.filiere=filiere;
        this.fragilite=fragilite;
        this.sociabilite=sociabilite;
        this.wei=wei;
        this.ppJanvier=ppJanvier;
        this.vingtQuatreHeures=vingtQuatreHeures;
    }
    
   public void setEtat(int nbVoisins){
       if(etat=true || nbVoisins ==0){//l'étudiant est déja malade ou personne n'est malade autours de lui
       //ne rien faire  
       } else {
           setIncubation(nbVoisins);
       }
   }
   public void setIncubation(int nbVoisins){
       //a completer
   }
   public void lesSymptomesApparaissent(){//sert au premier balayage du tableau, pour que tous les incubés deviennent malades, 
       //PUIS que l'on traite les nouveaux cas
       if(incubation){
           etat=true;
           incubation=false;
       }
   }
   //La methode setPremierMalade doit etre inutile puisque il suffit d'écrire directement sur l'argument (il est en public)
}

