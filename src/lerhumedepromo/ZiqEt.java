
package lerhumedepromo;
public class ZiqEt extends Etudiant{

	private boolean weiZiqEt;

	public ZiqEt(){
		super(6,5,2,false,true,true);
		weiZiqEt=false;
	}
        
       public void setWeiZiqEt(){
            int nombreAleatoire = (int) ( Math.random() * 2 + 1);
            int timer = getTimer();
            if((timer>10)&&(timer<17)){
                if(nombreAleatoire == 1){//if egal à 1 alors blessure sinon rien
                this.weiZiqEt=true;
                } 
        
            }
        

        }
		
}
