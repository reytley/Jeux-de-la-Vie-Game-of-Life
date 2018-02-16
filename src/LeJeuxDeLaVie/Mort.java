package LeJeuxDeLaVie;

public class Mort extends Etre {


public Mort(int x,int y){
	super( x, y);

}	


public Etre laVie(int count){
	Etre EtreRetour ;
	
	if(count < 2 || count > 3 || count == 2){
	//	System.out.println("reste mort");
		
		
	//	Etre.tableauTemp[this.getX()][this.getY()];
		
	}
	if(count == 3 ){
		// System.out.println("vie");
		Vivant leVivant = new Vivant(this.getX(),this.getY());	
		EtreRetour =  leVivant;
	}else{EtreRetour = this;
	}
	return EtreRetour;
}

public int voir(){
	return 0;
	
} 

}
