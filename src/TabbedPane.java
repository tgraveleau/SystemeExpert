import javax.swing.JTabbedPane;


public class TabbedPane extends JTabbedPane {

	private static final long serialVersionUID = 3000424415804506806L;

	public TabbedPane() {
		addTab("Faits", new FaitUI());
		addTab("Base de connaissance", new BaseDeConnaissanceUI());
		addTab("Base de Fait", new BaseDeFaitUI());  
		addTab("Solveur", new SolveurUI());  
	}
	
}
