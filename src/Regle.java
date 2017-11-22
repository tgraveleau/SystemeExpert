import java.util.Vector;


public class Regle {

	private Vector<Fait> premisses;
	private Vector<Fait> resultat;
	
	public Regle(Vector<Fait> premisses, Vector<Fait> resultat) {
		this.premisses = premisses;
		this.resultat = resultat;
	}

	/**
	 * MÉTHODES
	 */
	
	public boolean verifieRegle(Vector<Fait> base_de_connaissances) {
		
		// Pour chaque premisses
		for (Fait condition : this.premisses) {
			
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
		
		// Toutes les premisses sont réspectées
		return true;
	}
	
	/**
	 * GETTERS & SETTERS
	 */
	
	public Vector<Fait> getPremisses() {
		return premisses;
	}

	public Vector<Fait> getResultat() {
		return resultat;
	}

	@Override
	public String toString() {
		return "\nRegle :\n\tPremisses=" + this.premisses + "\n\tResultat=" + resultat;
	}

}
