package lerhumedepromo;
//commtest

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
    public Etudiant(int filiere ,int fragilite,int sociabilité, boolean wei, boolean ppJanvier, boolean vingtQuatreHeures){
        this.etat=false;
        this.incubation=false;
        this.filiere=filiere;
        this.fragilite=fragilite;
        this.sociabilite=sociabilite;
        this.wei=wei;
        this.ppJanvier=ppJanvier;
        this.vingtQuatreHeures=vingtQuatreHeures;
    }
    
   public void setEtat(int nbVoisins, int timer){
       if(etat=true || nbVoisins ==0){//l'étudiant est déja malade ou personne n'est malade autours de lui
       //ne rien faire  
       } else {
           setIncubation(nbVoisins,timer);
       }
   }
   public void setIncubation(int nbVoisins,int timer){ //methode a completer 
       int C1=fragilite+sociabilite;
       int C2=0; //les constantes C2,C3,C4 vont augmenter si l'etudiant participe aux differnts evenements
       int C3=0;
       int C4=0;
       
       if(this.wei && timer==2){ //si l'etudiant participe au wei et qu'on est en période de wei (semaine 2 à ajuster)
		   C2=6; //l'etudiant a plus de rique d'imcuber la maladie
	   }
	   
	   if(this.ppJanvier && timer==15){ //si l'etudiant participe au ppJanvier et qu'on est en periode de ppJanvier (semaine 15, à ajuster)
		  C3=4; //l'etudiant a plus de rique d'imcuber la maladie
	  }
	  if(this.vingtQuatreHeures && timer==22){ //si l'etudiant participe au 24h et qu'on est en période de 24h (semaine 22 à ajuster)
		  C4=4; //l'etudiant a plus de rique d'imcuber la maladie
	  }
	  //COMPLETER METHODE avec formule finale
	  
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
