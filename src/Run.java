import java.util.Vector;


public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SystemeExpertUI ui;
		
		BaseDeFait base_de_faits = new BaseDeFait();
		BaseDeConnaissance base_de_connaissances = new BaseDeConnaissance();
		
		// Prédicats
		String p_a = "a";
		String p_est = "est";
		String p_estMarieA = "est marié à";
		
		// Faits
		Fait fait1 = new Fait("Jack", p_a, "toux");
		Fait fait2 = new Fait("Jack", p_est, "tout blanc");
		Fait fait3 = new Fait("Jack", p_estMarieA, "Jane");
		Fait fait4 = new Fait("Jane", p_a, "la peste");
		Fait fait5 = new Fait("Jack", p_a, "la peste");
		
		// Si Jack tousse et est tout blanc, alors il est marié à Jane
		Vector<Fait> premisses1 = new Vector<Fait>();
		premisses1.add(fait1);
		premisses1.add(fait2);
		Regle regle1 = new Regle( premisses1, fait3 );
		
		// Si Jack est marié à Jane et Jane a la peste, alors Jack a la peste
		Vector<Fait> premisses2 = new Vector<Fait>();
		premisses2.add(fait3);
		premisses2.add(fait4);
		Regle regle2 = new Regle( premisses2, fait5 );
		
		// Regles
		base_de_faits.add(regle1);
		base_de_faits.add(regle2);
		
		// Base de connaissances
		base_de_connaissances.add( fait1 );
		base_de_connaissances.add( fait2 );
		base_de_connaissances.add( fait4 );

		System.out.println("\n#### BEGIN");
		display(base_de_connaissances);
		
		// On récupère le solveur
		Solveur solveur = Solveur.getInstance();
//		solveur.chainageAvant(base_de_faits, base_de_connaissances);
		solveur.chainageArriere(base_de_faits, base_de_connaissances, fait5);

		System.out.println("\n#### END");
		display(base_de_connaissances);

		ui = SystemeExpertUI.getInstance();

	}

	static <E> void display(Vector<E> array) {
		for (E obj : array) {
			System.out.println(obj.toString());
		}
	}
	
}
