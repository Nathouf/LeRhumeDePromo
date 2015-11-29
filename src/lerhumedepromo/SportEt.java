package lerhumedepromo;

public class SportEt extends Etudiant{
	
	private boolean blessure;
	
	public SportEt (){
		super(4,1,3,true,false,true);
		this.blessure=false;
                
	}
        
        public void setBlessure(){
            int nombreAleatoire = (int) ( Math.random() * 2 + 1);
            int timer = getTimer();
            if((timer>10)&&(timer<17)){
                if(nombreAleatoire == 1){//if egal à 1 alors blessure sinon rien
                this.blessure=true;
                } 
        
            }
        

        }
}
