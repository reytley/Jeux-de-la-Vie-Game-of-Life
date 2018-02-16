package LeJeuxDeLaVie;


/*REGLES
Le jeu de la vie n�est pas un jeu, puisqu�il ne n�cessite aucun joueur ; il s�agit d�un automate cellulaire, un mod�le o� chaque �tat conduit m�caniquement � l��tat suivant � partir de r�gles pr�-�tablies.

Le � jeu � se d�roule sur une grille � deux dimensions, th�oriquement infinie (mais de longueur et de largeur finies et plus ou moins grandes dans la pratique), dont les cases � qu�on appelle des � cellules �, par analogie avec les cellules vivantes � peuvent prendre deux �tats distincts : � vivantes � ou � mortes �.

� chaque �tape, l��volution d�une cellule est enti�rement d�termin�e par l��tat de ses huit voisines de la fa�on suivante :

Une cellule morte poss�dant exactement trois voisines vivantes devient vivante (elle na�t).
Une cellule vivante poss�dant deux ou trois voisines vivantes le reste, sinon elle meurt.
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
