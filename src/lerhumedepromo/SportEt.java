package lerhumedepromo;

public class SportEt extends Etudiant{

	private boolean blessure;

	public SportEt (){
		super(4,1,3,true,false,true);
		this.blessure=false;

	}

        public void setBlessure(){//on met alétoirement s'ils sont blessés ou pas et on adjuste leur coefficient d'incubation
            int nombreAleatoire = (int) ( Math.random() * 2 + 1);
            int timer = getTimer();
            if((timer>16)&&(timer<24)){
                if(nombreAleatoire == 1){//if egal à 1 alors blessure sinon rien
                this.blessure=true;
                }

            }


        }
}
