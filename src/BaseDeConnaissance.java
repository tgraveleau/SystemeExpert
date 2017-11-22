import java.util.Vector;


public class BaseDeConnaissance extends Vector<Fait> {

	private static final long serialVersionUID = 1L;

	public boolean verifieRegle(Regle regle) {

		// Pour chaque premisses
		for (Fait premisse : regle.getPremisses()) {
			
			// La premisse n'est pour le moment pas vérifiée
			boolean premisse_verifiee = false;
			
			// Pour chaque fait de la base de connaissances
			for (Fait fait : this) {
				
				// On vérifie qu'au moins un fait de la base de connaissances est égal à une premisse
				if (premisse.egal(fait)) {
					premisse_verifiee = true;
					// Si on a trouvé un fait alors on arrête la boucle pour passer à la premisse suivante
					break;
				}
				
			}
			
			// Si une premisse n'a pas été vérifiée alors la règle ne peut pas l'être
			if ( ! premisse_verifiee) {
				return false;
			}
			
		}
		
		// Toutes les premisses sont réspectées
		return true;
	}
	
}
