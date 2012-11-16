import java.awt.*;
import javax.swing.*;

public class ClimateChangeFrame extends JFrame implements Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void run() {
				
			this.setTitle("Climate Change Search Portal");
			this.setResizable(false);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    setDefaultLookAndFeelDecorated(true);
			
		    //put in the menu bar
			JMenuBar menuBar = new TheMenuBar();
			setJMenuBar(menuBar);

			JPanel panel = new BasePanel();
			this.add(panel);
			this.pack();
			
			centerWindow(this);
			setVisible(true);
		}
	
	/**
	 * @param Centers a window
	 */
	private void centerWindow(Window w){
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		setLocation((d.width - w.getWidth()) / 2, (d.height - w.getHeight()) / 2);
	}
}