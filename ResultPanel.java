import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class ResultPanel extends JPanel 
{
	
	private  static final long serialVersionUID = 1L;
	private  JButton    titleButton,
						urlButton;
	private  JTextArea  descriptionArea;
							
	public ResultPanel(final SearchResult searchResult){
	
		setLayout(new GridBagLayout());
		setMaximumSize(new Dimension(910, 210));
		Border resultBorder = BorderFactory.createEtchedBorder();
		setBorder(resultBorder);
	
		Color defaultGray = new Color(238, 238, 238);
		
		// create title panel
		final JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		titlePanel.setPreferredSize(new Dimension(890, 26));
		titleButton = new JButton(searchResult.getTitle());
		titleButton.setBorderPainted(false);
		titleButton.setForeground(Color.blue);
		titleButton.setBackground(defaultGray);
		titleButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e){
				
				// cast URL string of searchResult object into URI object for the browse() method
				String makeURI = searchResult.getURL();
				URI connectURL = URI.create(makeURI);
					
				// check for support of the Desktop class on present system
				boolean support = java.awt.Desktop.isDesktopSupported();
				if (!support) {
					String message = "\nClimate Change Searcher v0.8\n\nAuthors Erik Brek, Ann Dobbs and Walker Sampson";
					JOptionPane.showMessageDialog(titlePanel, message, "About Climate Change Searcher", JOptionPane.ERROR_MESSAGE);
				}
				
				// create desktop object (for browse() method)
				java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

				try {
					desktop.browse(connectURL);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}	
		} );
		titleButton.setFont(new Font("sansserif", Font.BOLD, 12));
		titleButton.setHorizontalAlignment(SwingConstants.LEFT);
		titlePanel.add(titleButton);
		add(titlePanel, getConstraints(0, 0, 1, 1, GridBagConstraints.WEST));
	
		// create URLButton panel
		final JPanel urlPanel = new JPanel();
		urlPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		urlPanel.setPreferredSize(new Dimension(890, 25));
		urlButton             = new JButton(searchResult.getURL());
		urlButton.setBorderPainted(false);
		urlButton.setBackground(defaultGray);
		urlButton.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e){
				
				// cast URL string of searchResult object into URI object for the browse() method
				String makeURI = searchResult.getURL();
				URI connectURL = URI.create(makeURI);
					
				// check for support of the Desktop class on present system
				boolean support = java.awt.Desktop.isDesktopSupported();
				if (!support) {
					String message = "\nClimate Change Searcher v0.8\n\nAuthors Erik Brek, Ann Dobbs and Walker Sampson";
					JOptionPane.showMessageDialog(urlPanel, message, "About Climate Change Searcher", JOptionPane.ERROR_MESSAGE);
				}
				// create desktop object (for browse() method)
				java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

				try {
					desktop.browse(connectURL);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}	
		} );
		urlButton.setFont(new Font("sansserif", Font.PLAIN, 10));
		urlPanel.add(urlButton);
		add(urlPanel, getConstraints(0, 1, 1, 1, GridBagConstraints.WEST));

//      create description textArea
		JPanel descriptionPanel = new JPanel();
		descriptionPanel.setPreferredSize(new Dimension(890, 70));
//		Border descriptionBorder = BorderFactory.createEtchedBorder();

		descriptionArea = new JTextArea(searchResult.getDescription(), 3, 71);
		descriptionArea.setLineWrap(true);
		descriptionArea.setWrapStyleWord(true);
		descriptionArea.setEditable(false);
		descriptionArea.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		descriptionArea.setBackground(defaultGray);
		descriptionPanel.add(descriptionArea);
		
		add(descriptionPanel, getConstraints(0, 2, 1, 1, GridBagConstraints.WEST));
		
		setVisible(true);
	}
	
	GridBagConstraints getConstraints(int gridx, int gridy, int gridwidth, int gridheight, int anchor){
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(2, 2, 2, 2);
		c.ipadx = 0;
		c.ipady = 0;
		c.gridx = gridx;
		c.gridy = gridy;
		c.gridwidth = gridwidth;
		c.gridheight = gridheight;
		c.anchor = anchor;
		return c;
	}
}


