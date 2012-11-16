import java.awt.*;
import javax.swing.*;

public class PreferenceFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PreferenceFrame(){
		setTitle("Preferences");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new PreferencePanel();
		
		this.add(panel);
		this.pack();
		centerWindow(this);
	}

	private void centerWindow(Window w){
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		setLocation((d.width - w.getWidth()) / 2, (d.height - w.getHeight()) / 2);
	}
}