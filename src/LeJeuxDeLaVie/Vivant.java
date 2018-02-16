package LeJeuxDeLaVie;

public class Vivant extends Etre {




public Vivant(int x,int y){
	super( x, y);
	
}
	
public Etre laVie(int count){
	Etre EtreRetour ;
	
	if(count == 3 || count == 2){
	//	System.out.println("Vie");
		
		EtreRetour = this;
		
	}else{	Mort leMort = new Mort(this.getX(),this.getY());
	EtreRetour = leMort;
		}
	return EtreRetour;
}


public int voir(){
	return 1;
	
} 

}
