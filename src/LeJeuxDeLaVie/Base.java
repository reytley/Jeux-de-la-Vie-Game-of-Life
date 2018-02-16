package LeJeuxDeLaVie;


/*REGLES
Le jeu de la vie n’est pas un jeu, puisqu’il ne nécessite aucun joueur ; il s’agit d’un automate cellulaire, un modèle où chaque état conduit mécaniquement à l’état suivant à partir de règles pré-établies.

Le « jeu » se déroule sur une grille à deux dimensions, théoriquement infinie (mais de longueur et de largeur finies et plus ou moins grandes dans la pratique), dont les cases — qu’on appelle des « cellules », par analogie avec les cellules vivantes — peuvent prendre deux états distincts : « vivantes » ou « mortes ».

À chaque étape, l’évolution d’une cellule est entièrement déterminée par l’état de ses huit voisines de la façon suivante :

Une cellule morte possédant exactement trois voisines vivantes devient vivante (elle naît).
Une cellule vivante possédant deux ou trois voisines vivantes le reste, sinon elle meurt.
*/
public class Base {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 boolean arret = false;
		 Matrice LaMatrice = new Matrice(40);
		 Affichage lAffichage = new Affichage();
		 
		 //REMPLI MATRICE
		 
			LaMatrice.PatternEnregister(1, 1, 2);
		 	LaMatrice.PatternEnregister(1, 1, 7);
		 	LaMatrice.PatternEnregister(1, 1, 12);
		 	
		 	LaMatrice.PatternEnregister(1, 7, 2);
		 	LaMatrice.PatternEnregister(1, 7, 7);
		 	LaMatrice.PatternEnregister(1, 7, 12);
		 	
			LaMatrice.PatternEnregister(1, 13, 2);
		 	LaMatrice.PatternEnregister(1, 13, 7);
		 	LaMatrice.PatternEnregister(1, 13, 12);
		 	
		 	LaMatrice.GroupPatternEnregistrer(1);
		 	Vivant	Lavie  = new Vivant(1,1);

		 	
		 	
		// LaMatrice.AjoutGroupeVivant(matrice2);
		 	
		 	
		 	
		 do{
			 LaMatrice.Traitementgeneration();
			
			 
			 
			 
			 if(LaMatrice.CompareLesList()){arret = true;}
			 lAffichage.affichageMAt(LaMatrice.VueGenationActuel(),LaMatrice.getCompteur());
		
	
			 try        
			 {
			     Thread.sleep(500);
			 } 
			 catch(InterruptedException ex) 
			 {
			     Thread.currentThread().interrupt();
			 }
			 
		 }while(arret == false);
		 
		 try        
		 {
		     Thread.sleep(20000);
		 } 
		 catch(InterruptedException ex) 
		 {
		     Thread.currentThread().interrupt();
		 }
		 
	
	}
}
