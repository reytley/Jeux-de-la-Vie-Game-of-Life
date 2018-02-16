package LeJeuxDeLaVie;
 abstract class Etre {
	 private boolean Tab = false;
	 private int y,x;
	 private Matrice lM;
	 
	 ///////////////////////////////////////////
	//////////////////CONSTRUCTEUR/////////////
	///////////////////////////////////////////
	public Etre(int x,int y,Matrice LaMatrice){
	
		lM =  LaMatrice;
		this.x = x;
		this.y = y;
	

		
	}	
	public Etre(){}
	public Etre(int x,int y){
		
		this.x = x;
		this.y = y;
	
		
	}
	
	
	
	 ///////////////////////////////////////////
	//////////////////GETTERSETTER//////////////
	///////////////////////////////////////////
	
	public int getX(){return this.x;}
	
	public int getY(){return this.y;}
	
	
	 ///////////////////////////////////////////
	//////////////////FONCTION//////////////////
	///////////////////////////////////////////
	
	//DEcide si l'etre reste à son état actuel ou meurt 
	public Etre laVie(int count){
	
		return this;
	}
	
	public int voir(){
		return 0;
		
	} 
	
	public boolean equals(Etre unEtre){
		boolean retour = true;
		
		if(this.voir() != unEtre.voir()){
			
			retour = false;
		
		}

		return retour;
		
	}
	
	
	

	
}