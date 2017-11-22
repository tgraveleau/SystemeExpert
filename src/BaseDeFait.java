import java.util.Vector;


public class BaseDeFait extends Vector<Regle> {

	private static final long serialVersionUID = 1L;

	/**
	 * cqvd = ce que l'on veut démontrer
	 * @param base_de_connaissances
	 * @param cqvd
	 * @return
	 */
	public boolean solveChainageAvantLargeur(BaseDeConnaissance base_de_connaissances, Fait cqvd) {
		
		// Si cqvd est déjà dans la bdc alors pas besoin d'aller plus loin
		if (base_de_connaissances.contains(cqvd)) {
			return true;
		}
		
		// Pour chaque règle de la base de fait
		for (Regle regle : this) {
			
			// Si la règle est vérifié avec ce que l'on sait
			if (base_de_connaissances.verifieRegle(regle)) {
//				System.out.println("OK");
				
				// On récupère tous les résultats
				Vector <Fait> resultats = regle.getResultat();
				
				// On les ajoute à la base de connaissances
				for (Fait resultat : resultats) {
					
					// Si on est en train d'ajouter à la bdc cqvd alors on peut s'arrêter
					if (resultat == cqvd) {
						return true;
					}
					
					// On ajoute le resultat à ce qu'on sait
					base_de_connaissances.add(resultat);
				}
				
			}
			
		}
		
		return false;
	}
	
}
