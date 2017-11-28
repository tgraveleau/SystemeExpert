import java.awt.BorderLayout;

import javax.swing.JFrame;


public class SystemeExpertUI extends JFrame {

	private static final long serialVersionUID = -790850726500238628L;

	private static SystemeExpertUI instance;
	private BorderLayout layout;
	private TabbedPane tabbedPane;
	
	private SystemeExpertUI() {
		layout = new BorderLayout();
		tabbedPane = new TabbedPane();
		initUI();
	}

	private void initUI() {
		setLayout(layout);
		setTitle("Système Expert");
	    // Taille de la frame
	    setSize(800, 600);
	    // Placer au centre de l'ecran
	    setLocationRelativeTo(null);    
		 
        add(tabbedPane, BorderLayout.CENTER); 
        
	    setVisible(true);
	    
	}
	
	
	public static SystemeExpertUI getInstance() {
		if (instance == null) {
			instance = new SystemeExpertUI();
		}
		return instance;
	}
	
}
