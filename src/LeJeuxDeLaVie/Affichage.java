package LeJeuxDeLaVie;

 public   class Affichage {

	 
	 public Affichage(){}
	 
	 public void affichageInt(int lInt){
		 System.out.println(lInt);
	 }
	 
	 public void affichageBool(boolean bool){
		 
		 System.out.println(bool);
	 }
	 
	 public void affichageMultiMAt(Matrice [][]tab){}
	 
	 public void Entete(int Compteur){
		 
			System.out.println("///////////////////////////");
			System.out.println("/////////" +"Tour  N°"+Compteur+"/////////");
	 }
	 
	 public void affichageMAt(String []tab,int Compteur){
		 	this.Entete(Compteur);
			for(int i = 0; i < tab.length; i ++){
				System.out.println(tab[i]);
			}
		 
		 
	 }
	
}
