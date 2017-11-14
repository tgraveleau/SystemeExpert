import java.util.Vector;


public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Vector<Regle> base_de_faits = new Vector<Regle>();
		Vector<Fait> base_de_connaissances = new Vector<Fait>();
		
		Fait fait1 = new Fait("Jack", "a", "toux");
		Fait fait2 = new Fait("Jack", "est", "tout blanc");
		Fait fait3 = new Fait("Jack", "est marié à", "Jane");
		Fait fait4 = new Fait("Jane", "a", "la peste");
		Fait fait5 = new Fait("Jack", "a", "la peste");
		
		// Si Jack tousse et est tout blanc, alors il est marié à Jane
		Vector<Fait> conditions1 = new Vector<Fait>();
		conditions1.add(fait1);
		conditions1.add(fait2);
		base_de_faits.add(new Regle( conditions1, fait3 ));
		
		// Si Jack est marié à Jane et Jane a la peste, alors Jack a la peste
		Vector<Fait> conditions2 = new Vector<Fait>();
		conditions1.add(fait3);
		conditions1.add(fait4);
		base_de_faits.add(new Regle( conditions2, fait5 ));
		
		base_de_connaissances.add( fait1 );
		base_de_connaissances.add( fait2 );

		System.out.println("####\nAvant\n####");
		display(base_de_connaissances);
		
		for (Regle regle : base_de_faits) {
				if (regle.verifieRegle(base_de_connaissances)) {
					base_de_connaissances.add(regle.getResultat());
				}
		}

		System.out.println("####\nAprès\n####");
		display(base_de_connaissances);
		

	}

	static void display(Vector<Fait> base_de_connaissances) {
		for (Fait obj : base_de_connaissances) {
			System.out.println(obj.toString());
		}
	}
	
}
