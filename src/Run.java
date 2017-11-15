import java.util.Vector;


public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Vector<Regle> base_de_faits = new Vector<Regle>();
		Vector<Fait> base_de_connaissances = new Vector<Fait>();
		
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
		Vector<Fait> conditions1 = new Vector<Fait>();
		conditions1.add(fait1);
		conditions1.add(fait2);
		Regle regle1 = new Regle( conditions1, fait3 );
		
		// Si Jack est marié à Jane et Jane a la peste, alors Jack a la peste
		Vector<Fait> conditions2 = new Vector<Fait>();
		conditions2.add(fait3);
		conditions2.add(fait4);
		Regle regle2 = new Regle( conditions2, fait5 );
		
		// Regles
		base_de_faits.add(regle1);
		base_de_faits.add(regle2);
		
		// Base de connaissances
		base_de_connaissances.add( fait1 );
		base_de_connaissances.add( fait2 );
//		base_de_connaissances.add( fait4 );

		System.out.println("\n#### Avant");
		display(base_de_connaissances);
		
		for (Regle regle : base_de_faits) {
			System.out.println(regle.toString());
			if (regle.verifieRegle(base_de_connaissances)) {
				System.out.println("OK");
				base_de_connaissances.add(regle.getResultat());
			}
		}

		System.out.println("\n#### Après");
		display(base_de_connaissances);
		

	}

	static <E> void display(Vector<E> array) {
		for (E obj : array) {
			System.out.println(obj.toString());
		}
	}
	
}
