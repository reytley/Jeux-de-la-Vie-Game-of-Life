package LeJeuxDeLaVie;

import java.util.function.Predicate;

public class Matrice extends Etre {
     private int tM ;
	 private int Compteur = 0;
	 private int Etat = 0;
	 private boolean fin = false;
	 private Etre [][]tableau;
	 private Etre [][]tableauTemp;
	// static Suplier<int>random = Etre::getX;
	 
	 //////////////////////////////////////
	 /////////////CONSTRUCTEUR/////////////
	 //////////////////////////////////////
	 public Matrice(int TailleMatrice){
		 tM = TailleMatrice;
		 this.tableau = new Etre[TailleMatrice][TailleMatrice];
		 this.tableauTemp = new Etre[TailleMatrice][TailleMatrice];
			for(int i = 0; i < TailleMatrice; i ++){
				for(int p = 0; p < TailleMatrice; p ++){
						Mort LesMort = new Mort(i,p);	
						this.tableau[i][p] = LesMort;
				}
			}
	 }
	 
	 ///////////CReation de matrice qui sera contenenu dans une matrice
	 public Matrice(int TailleMatrice,int x,int y){
		 super( x, y);
		 tM = TailleMatrice;
		 this.tableau = new Etre[TailleMatrice][TailleMatrice];
		 this.tableauTemp = new Etre[TailleMatrice][TailleMatrice];
			for(int i = 0; i < TailleMatrice; i ++){
				for(int p = 0; p < TailleMatrice; p ++){
						Mort LesMort = new Mort(i,p);	
						this.tableau[i][p] = LesMort;
				}
			}
	 }
	 
	 //Ajoute un etre vivant dans la matride actuel 
	public void AjoutVivant(int x,int y){
		Vivant unVivant = new Vivant( x, y);
		this.tableau[x][y] = unVivant;
	} 
		
	// Recupere un matrice 
	public void AjoutGroupeVivant(int [][]matrice2){
		for(int i = 0; i < matrice2.length; i ++){
			for(int p = 0; p < matrice2[i].length; p ++){
				if(matrice2[i][p] == 1){
					Vivant lesVivant = new Vivant(i,p);	
					this.tableau[i][p] = lesVivant;
					
					 
				//	System.out.println(lesMort.voir());
				}
			
			}
		
		}	
		
		
		
	}
	 
	 // va effecture le traitement sur la generation actuel
	public void Traitementgeneration(){
		
		
			//corp du jeux

			for(int i = 0; i < this.tableau.length; i ++){
				String ligneCp = "";
				for(int p = 0; p < this.tableau[i].length; p ++){
					
					//System.out.println("Etre X:"+Etre.tableau[i][p].getX() + " Y:" + Etre.tableau[i][p].getY() + " Count :"+ Etre.tableau[i][p].nbVoisin() );
				//	ligneCp = ligneCp + Etre.tableau[i][p].nbVoisin();
				
				this.tableauTemp[i][p] = this.tableau[i][p].laVie(this.nbVoisin(i,p));
				if(	this.tableau[i][p].laVie(this.nbVoisin(i,p)).voir() == 1){
					Etat = 1;
				}
				}
				//System.out.println(ligneCp);
			}
			
			Compteur = Compteur + 1;
		
			//Etre.tableau == Etre.tableauTemp
			
			//Fonction d'arret de l'application quand la matrice temps est égal à la matrice actuelle 
			if( this.tableau.equals(this.tableauTemp)){
			fin = true;
			}
				
			


		

			

			
		
		
		
	}
	 
	public  String[] VueGenationActuel(){
		String []MatriceVisuel = new String[tM];
		for(int i = 0; i < this.tableau.length; i ++){
			String ligne = "";
			
			for(int p = 0; p < this.tableau[i].length; p ++){
				//System.out.println("Etre X:"+Etre.tableau[i][p].getX() + " Y:" + Etre.tableau[i][p].getY() + " Count :"+ Etre.tableau[i][p].nbVoisin() );
			
				this.tableau[i][p] = this.tableauTemp[i][p];
				ligne = ligne +  this.tableau[i][p].voir();
			
			}
			//System.out.println(ligne);
			MatriceVisuel[i] = ligne;
		}
		
		
		return MatriceVisuel;
	}

	public void add(int x,int y, Etre unEtre){
		this.tableau[x][y]= unEtre;
		
		
	}
	
	public void addMatriceTemp(Etre unEtre){
		this.tableauTemp[unEtre.getX()][unEtre.getY()]= unEtre;
		
		
	}
	
	public void SetMatTemp( Etre [][]tableauTempEnvoi){
		
		this.tableauTemp = tableauTempEnvoi;
	}	
	
	public int nbVoisin(int x,int y){
		int Count = 0;	
			if(x != 0 && x != (tM - 1)){
				if(y < 19 && y > 0 ){
		
					Count  = Count + this.tableau[x + 1][y - 1].voir();
					Count  = Count + this.tableau[x + 1][y ].voir();
					Count  = Count + this.tableau[x + 1][y + 1].voir();
					
					Count  = Count + this.tableau[x - 1][y - 1].voir();
					Count  = Count + this.tableau[x - 1][y ].voir();
					Count  = Count + this.tableau[x - 1][y + 1].voir();
					
					Count  = Count + this.tableau[x][y - 1].voir();
					Count  = Count + this.tableau[x][y + 1].voir();
					
				}else if(y == (tM - 1)){
					Count  = Count + this.tableau[x + 1][y - 1].voir();
					Count  = Count + this.tableau[x + 1][y ].voir();
					
					Count  = Count + this.tableau[x - 1][y - 1].voir();
					Count  = Count + this.tableau[x - 1][y ].voir();
					
					Count  = Count + this.tableau[x][y - 1].voir();
					
					
					
				}else if(y == 0){
					Count  = Count + this.tableau[x + 1][y ].voir();
					Count  = Count + this.tableau[x + 1][y + 1].voir();
					
					Count  = Count + this.tableau[x - 1][y ].voir();
					Count  = Count + this.tableau[x - 1][y + 1].voir();
					
					Count  = Count + this.tableau[x][y + 1].voir();
				}
				
			}else if(x == 0){
				
				if(y < (tM - 1) && y > 0 ){
					
					Count  = Count + this.tableau[x + 1][y - 1].voir();
					Count  = Count + this.tableau[x + 1][y ].voir();
					Count  = Count + this.tableau[x + 1][y + 1].voir();
					
			
					
					Count  = Count + this.tableau[x][y - 1].voir();
					Count  = Count + this.tableau[x][y + 1].voir();
					
				}else if(y == (tM - 1)){
					Count  = Count + this.tableau[x + 1][y - 1].voir();
					Count  = Count + this.tableau[x + 1][y ].voir();
				
					Count  = Count + this.tableau[x][y - 1].voir();
					
					
					
				}else if(y == 0){
					Count  = Count + this.tableau[x + 1][y ].voir();
					Count  = Count + this.tableau[x + 1][y + 1].voir();
					
			
					Count  = Count + this.tableau[x][y + 1].voir();
				}
				
			}else if(x == (tM - 1)){
				if(y < (tM - 1) && y > 0 ){
					
				
					
					Count  = Count + this.tableau[x - 1][y - 1].voir();
					Count  = Count + this.tableau[x - 1][y ].voir();
					Count  = Count + this.tableau[x - 1][y + 1].voir();
					
					Count  = Count + this.tableau[x][y - 1].voir();
					Count  = Count + this.tableau[x][y + 1].voir();
					
				}else if(y == (tM - 1)){
				
					
					Count  = Count + this.tableau[x - 1][y - 1].voir();
					Count  = Count + this.tableau[x - 1][y ].voir();
					
					Count  = Count + this.tableau[x][y - 1].voir();
					
					
					
				}else if(y == 0){
			
					
					Count  = Count + this.tableau[x - 1][y ].voir();
					Count  = Count + this.tableau[x - 1][y + 1].voir();
					
					Count  = Count + this.tableau[x][y + 1].voir();
				}
				
				
				
			}
		 //	Count  = Count + Etre.tableau[x][y].voir();
		
		
		return Count;
	}
	
	public Etre[][] GetMatrice(){
		
		return this.tableau;
	}
	
	public Etre[][] GetMatriceTemp(){
		
		return this.tableauTemp;
	}
	 
	public int getCompteur(){
		
		return this.Compteur;
		
	}
	
	public boolean CompareLesList(){
		boolean retour = true;
		
		for(int i = 0; i < this.tableau.length; i ++){
			
			
			for(int p = 0; p < this.tableau[i].length; p ++){
				
							
				 if(( this.tableau[i][p].equals(this.tableauTemp[i][p])) == false)
								 
							 {
								 retour = false;
						
								 
							 }
			
			}
		
		}
		
		return retour;
		
		
		
	}
	
	public void GroupPatternEnregistrer(int choix){
		 switch (choix) {
		 case 2:   

			 	
		 			
		 case 1: 
				int i = this.tM - 2;
				int xt = this.tM - 2;
				
				while(i >= 0 || i == 1){
					
					  this.PatternEnregister(2, xt, i);
			 			
					
					i = i - 3;
				}
			 break;
		 }
		 
		
		
	}
	
	public void PatternEnregister(int ChoixParttern,int x,int y){
		

		   switch (ChoixParttern) {
	       case 1:   
		    	this.AjoutVivant(x, y);
		   		this.AjoutVivant(x+1, y);
		   		this.AjoutVivant(x+2, y);
		   		this.AjoutVivant(x+2, y-1);  
		   		this.AjoutVivant(x+1, y-2);
		   		break;
	       case 2:
	    	   this.AjoutVivant(x, y);
	    	   this.AjoutVivant(x+1, y);
	    	   this.AjoutVivant(x, y+1);
	    	   this.AjoutVivant(x+1, y+1);
	   		break;
	  
	   }
	}
	
	
	public Etre find(Predicate<Etre> f){
		Etre result = null;
		
	for(int i = 0; i < this.tableau.length; i ++){
			
			
			for(int p = 0; p < this.tableau[i].length; p ++){
				
				if(f.test(tableau[i][p])){
					return tableau[i][p];
				}
			
			}
		
		}
		
	return result;	
	}
	
	///////FONCTION LIER à extends ETRE
	public int voir(){
		return Etat;
		
	} 
	
	
	
	
	
}
