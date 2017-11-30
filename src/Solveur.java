import java.util.Vector;

/**
 * Singleton
 * cqvd = ce que l'on veut démontrer
 *
 */
public class Solveur {

	private static Solveur instance;

	/**
	 * 
	 * @param base_de_faits
	 * @param base_de_connaissances
	 * @param cqvd
	 * @return
	 */
	public void chainageAvant(BaseDeFait base_de_faits, BaseDeConnaissance base_de_connaissances) {
		
		// Pour chaque règle de la base de fait
		for (Regle regle : base_de_faits) {
			
			// Si la règle est vérifié avec ce que l'on sait
			if (base_de_connaissances.verifieRegle(regle)) {
//				System.out.println("OK");
				
				// On ajoute à la base de connaissances le résultat de la règle
				base_de_connaissances.add(regle.getResultat());
				
			}
			
		}
		
	}
	
	public boolean chainageArriere(BaseDeFait base_de_faits, BaseDeConnaissance base_de_connaissances, Fait cqvd) {
//		Vector<Regle> regles_validees = new Vector<Regle>();
//		Vector<Fait> fait_a_rechercher = new Vector<Fait>();
//		fait_a_rechercher.add(cqvd);
//		
//		while ( ! base_de_faits.contains(cqvd) ) {
////			System.out.println("tour");
//			for (Regle regle : base_de_faits) {
//				
//				if ( fait_a_rechercher.contains(regle.getResultat()) ) {
//					System.out.println(regle);
//					regles_validees.add(regle);
//				}
//				
//			}
//			
//			if ( regles_validees.isEmpty() ) {
//				break;
//			}
//			
//			for (Regle regle : regles_validees) {
//				
//				if ( base_de_connaissances.containsAll(regle.getPremisses()) ) {
//					
//					base_de_connaissances.add(regle.getResultat());
//					base_de_faits.remove(regle);
//					fait_a_rechercher.remove(regle.getResultat());
//					
//				} else {
//					fait_a_rechercher.addAll(regle.getPremisses());
//				}
//				
//			}
//			
//		}
//		
//	
//	return base_de_faits.contains(cqvd);
	
		if ( base_de_faits.contains(cqvd) ) {
			return true;
		}
		
		// Pour toutes les règles
		for (Regle regle : base_de_faits) {
			Vector<Regle> regles_a_verifier = new Vector<Regle>();
			
			// Si la règle est activable
			if ( regle.isActivable() ) {
			
				// Si on a une règle qui donne cqvd
				if ( regle.getResultat() == cqvd ) {
					
					// Si on a les prémisses pour répondre à cette règle alors on a fini
					for (Fait premisse : regle.getPremisses()) {
						if (base_de_faits.contains(premisse)) {
							return true;
						} else {
							regles_a_verifier.add(regle);
						}
					}
					
					// Sinon, on reccomence le chainage arrière avec les premisse pour voir si on peut les avoir
					
					
				}
			
			}
			
			if ( regles_a_verifier.size() == 0 ) {
				return false;
			}
			
			regle.setActivable(false);
		}
		
		return false;
	}
	
	public static Solveur getInstance() {
		if (instance == null) {
			instance = new Solveur();
		}
		return instance;
	}
	
}
