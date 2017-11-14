import java.util.Vector;


public class Regle {

	Vector<Fait> conditions;
	Fait resultat;
	
	public Regle(Vector<Fait> conditions, Fait resultat) {
		this.conditions = conditions;
		this.resultat = resultat;
	}

	/**
	 * MÉTHODES
	 */
	
	public boolean verifieRegle(Vector<Fait> base_de_connaissances) {
		
		// Pour chaque conditions
		for (Fait condition : this.conditions) {
			
			// La condition n'est pour le moment pas vérifiée
			boolean condition_verifiee = false;
			
			// Pour chaque fait de la base de connaissances
			for (Fait fait : base_de_connaissances) {
				
				// On vérifie qu'au moins un fait de la base de connaissances est égal à une condition
				if (condition.egal(fait)) {
					condition_verifiee = true;
					// Si on a trouvé un fait alors on arrête la boucle pour passer à la condition suivante
					break;
				}
				
			}
			
			// Si une condition n'a pas été vérifiée alors la règle ne peut pas l'être
			if ( ! condition_verifiee) {
				return false;
			}
			
		}
		
		// Toutes les conditions sont réspectées
		return true;
	}
	
	/**
	 * GETTERS & SETTERS
	 */
	
	public Vector<Fait> getConditions() {
		return conditions;
	}

	public Fait getResultat() {
		return resultat;
	}

}
