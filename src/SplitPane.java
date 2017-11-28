import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;



public class SplitPane extends JSplitPane {
	
	private static final long serialVersionUID = -1219909763548701268L;
	
	private JSplitPane splitPane;
//	private JScrollPane scrollPane;
	private JTabbedPane tabbedPane;
	
	public SplitPane(){
		super(HORIZONTAL_SPLIT);
		
//		scrollPane = new JScrollPane();
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Faits", null);
		tabbedPane.addTab("Base de connaissance", null);
		tabbedPane.addTab("Base de Fait", null);
		
//		setLeftComponent(scrollPane);
		setTopComponent(tabbedPane);
	}

}
