
public class Fait {
	
	private String predicat;
	private String identifier1;
	private String identifier2;
	
	public Fait(String identifier1, String predicat, String identifier2) {
		this.identifier1 = identifier1;
		this.predicat = predicat;
		this.identifier2 = identifier2;
	}

	public String toString() {
		return this.identifier1 + " " + this.predicat + " " + this.identifier2;
	}

	/**
	 * METHODES
	 */
	
	public boolean egal(Fait fait) {
		return 
				this.predicat == fait.getPredicat()
				&& this.identifier1 == fait.getIdentifier1()
				&& this.identifier2 == fait.getIdentifier2()
				;
	}
	
	/**
	 * GETTERS & SETTERS
	 */
	
	public String getPredicat() {
		return predicat;
	}

	public String getIdentifier1() {
		return identifier1;
	}

	public String getIdentifier2() {
		return identifier2;
	}

}
