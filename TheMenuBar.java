import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class TheMenuBar extends JMenuBar implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private  JMenuItem  preferences;
	private  JMenuItem  exit;
	private  JMenuItem  about;
	
	public TheMenuBar(){
	
		// File Menu, F - Mnemonic
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		add(fileMenu);
			    
		// File->Preferences, P - Mnemonic
		preferences = new JMenuItem("Preferences", KeyEvent.VK_P);
		preferences.addActionListener(this);
		fileMenu.add(preferences);
			    
		// File->Exit, X - Mnemonic
		exit = new JMenuItem("Exit", KeyEvent.VK_X);
		exit.addActionListener(this);
		fileMenu.add(exit);
			
		// Help Menu, H - Mnemonic
		JMenu helpMenu = new JMenu("Help");
		helpMenu.setMnemonic(KeyEvent.VK_H);
		add(helpMenu);
		
		// Help->About, A - Mnemonic
		about = new JMenuItem("About", KeyEvent.VK_A);
		about.addActionListener(this);
		helpMenu.add(about);
	} //constructor
			
		 
	public void actionPerformed(ActionEvent e){
		Object source = e.getSource();
		if (source == preferences){
			JFrame frame = new PreferenceFrame();
			frame.setVisible(true);
		} else if (source == exit){
			System.exit(0);
		} else if (source == about){
			String message = "\nClimate Change Searcher v0.8\n\nAuthors Erik Brek, Ann Dobbs and Walker Sampson";
			JOptionPane.showMessageDialog(super.getComponent(), message, "About Climate Change Searcher", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}