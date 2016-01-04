
package lerhumedepromo;
public class ZiqEt extends Etudiant{

	private boolean weiZiqEt;

	public ZiqEt(){
		super(6,5,2,false,true,true);
		weiZiqEt=false;
	}
        
       public void setWeiZiqEt(){//adjustement des coefficients d'incubation par rapport la participation des ziqEt au Wei. La participation est initialisé au hasard avec random
            int nombreAleatoire = (int) ( Math.random() * 2 + 1);
            int timer = getTimer();
            if((timer>10)&&(timer<17)){
                if(nombreAleatoire == 1){//if egal à 1 alors ils vont au wei
                this.weiZiqEt=true;
                } 
        
            }
        

        }
		
}
