import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import javax.swing.*;

public class BasePanel extends JPanel implements ActionListener, KeyListener
{
	private static final long serialVersionUID = 1L;
	private static JLabel     feedback;
	private JLabel        	  positiveCountLabel, 
	                          neutralCountLabel, 
	                          negativeCountLabel;
	private JTextField        queryField;
	private JButton           goButton,
			          clearButton,
				  saveButton,
				  resetButton,
				  exitButton,
				  printButton;
	private JRadioButton      allResultsButton,
    				  positiveResultsButton,
    				  neutralResultsButton,
    				  negativeResultsButton;
	private JPanel            resultsPanel;
	private JPanel            resultsContainerPanel,
				  positiveCountPanel,
				  neutralCountPanel,
				  negativeCountPanel;
	private JScrollPane       resultsScroll;

	Color greenColor = new Color(0,   153, 51);
	Color redColor   = new Color(153, 0,   51);
	Color grayColor  = new Color(209, 209, 209);
	
	ArrayList<ResultPanel> positiveResultsPanelArray = new ArrayList<ResultPanel>();
	ArrayList<ResultPanel> neutralResultsPanelArray  = new ArrayList<ResultPanel>();
	ArrayList<ResultPanel> negativeResultsPanelArray = new ArrayList<ResultPanel>();

	ArrayList<JPanel> allSessionResults              = new ArrayList<JPanel>();
	
	public BasePanel(){
		
		setLayout(new GridBagLayout());
		
		// create query panel
		JPanel queryPanel = new JPanel();

		queryField        = new JTextField(65);
		queryField.addKeyListener(this);
		queryPanel.add(queryField);
		
		goButton          = new JButton("Go");
		goButton.addActionListener(this);
		goButton.setEnabled(false);
		queryPanel.add(goButton);
		
		clearButton = new JButton("Clear");
		clearButton.addActionListener(this);
		clearButton.setEnabled(false);
		queryPanel.add(clearButton);
		
		// add queryPanel to the base panel
		add(queryPanel, getConstraints(0, 0, 2, 1, GridBagConstraints.NORTH));
		
		// create results panel
		resultsPanel = new JPanel();
		resultsPanel.setLayout(new BoxLayout(resultsPanel, BoxLayout.Y_AXIS));
		resultsPanel.setAutoscrolls(true); 
		
		// create feedback panel
		JPanel feedbackPanel = new JPanel();
		feedbackPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		feedback = new JLabel("");
		feedback.setFont(new Font("sansserif", Font.PLAIN, 10));
		feedbackPanel.add(feedback);
		
		add(feedbackPanel, getConstraints(0, 1, 1, 1, GridBagConstraints.WEST));
		
		
		// create view panel
		JPanel viewPanel = new JPanel();
		viewPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		allResultsButton      = new JRadioButton("All");
		positiveResultsButton = new JRadioButton("Positive");
		neutralResultsButton  = new JRadioButton("Neutral");
		negativeResultsButton = new JRadioButton("Negative");
		
		allResultsButton.addActionListener(this);
		positiveResultsButton.addActionListener(this);
		neutralResultsButton.addActionListener(this);
		negativeResultsButton.addActionListener(this);
		
		allResultsButton.setEnabled(false);
		positiveResultsButton.setEnabled(false);
		neutralResultsButton.setEnabled(false);
		negativeResultsButton.setEnabled(false);
		
		viewPanel.add(allResultsButton);
		viewPanel.add(positiveResultsButton);
		viewPanel.add(neutralResultsButton);
		viewPanel.add(negativeResultsButton);
		
		ButtonGroup viewResultsGroup = new ButtonGroup();
		viewResultsGroup.add(allResultsButton);
		viewResultsGroup.add(positiveResultsButton);
		viewResultsGroup.add(neutralResultsButton);
		viewResultsGroup.add(negativeResultsButton);
		
		add(viewPanel, getConstraints(1, 1, 1, 1, GridBagConstraints.EAST));
		
		// create panel scroll pane container
		resultsScroll = new JScrollPane(resultsPanel, 
						ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
						ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		resultsScroll.setPreferredSize(new Dimension(975, 470));
		
		// add resultsScroll
		add(resultsScroll,  getConstraints(0, 2, 2, 1, GridBagConstraints.SOUTH));
		
		// create options panel
		JPanel optionsPanel = new JPanel();
		optionsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		printButton = new JButton("Print");
		printButton.addActionListener(this);
		printButton.setEnabled(false);
		optionsPanel.add(printButton);
		
		saveButton = new JButton("Save");
		saveButton.addActionListener(this);
		saveButton.setEnabled(false);
		optionsPanel.add(saveButton);
		
		resetButton = new JButton("Reset");
		resetButton.addActionListener(this);
		resetButton.setEnabled(false);
		optionsPanel.add(resetButton);
		
		exitButton = new JButton("Exit");
		exitButton.addActionListener(this);
		optionsPanel.add(exitButton);
		
		add(optionsPanel, getConstraints(0, 3, 2, 1, GridBagConstraints.EAST));
	}
	
	public void actionPerformed(ActionEvent e){
		
		Object source = e.getSource();
		
		if (source == goButton){
			
			class getResults extends SwingWorker<ArrayList<JPanel>, JPanel> {
				
				public ArrayList<JPanel> doInBackground() {
					
					// call 'createSearchURL', generate URL search, connect and eventually return resultsPanel			
					positiveResultsPanelArray = SearchURLGenerator.createPostiveNSDLSearchURL (queryField.getText());
					neutralResultsPanelArray  = SearchURLGenerator.createNeutralNSDLSearchURL (queryField.getText());
					negativeResultsPanelArray = SearchURLGenerator.createNegativeNSDLSearchURL(queryField.getText());

					ArrayList<JPanel> resultContainerPanelList = new ArrayList<JPanel>();
					
					// loop through resultsPanel and add each resultPanel to positiveResultsPanel
					for (int i = 0; i < positiveResultsPanelArray.size(); i++) {
						
						resultsContainerPanel = new JPanel();
						resultsContainerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
						resultsContainerPanel.setVisible(true);
						
						positiveCountPanel = new JPanel();
						positiveCountPanel.setPreferredSize(new Dimension(30, 135));
						positiveCountPanel.setBackground(greenColor);
						positiveCountPanel.setVisible(true);
						
						positiveCountLabel = new JLabel(Integer.toString(i + 1));
						positiveCountPanel.add(positiveCountLabel);

						resultsContainerPanel.add(positiveCountPanel);
						resultsContainerPanel.add(positiveResultsPanelArray.get(i));
						
						resultContainerPanelList.add(resultsContainerPanel);
					}

					// loop through resultsPanel and add each resultPanel to neutralResultsPanel
					for (int i = 0; i < neutralResultsPanelArray.size(); i++) {

						resultsContainerPanel = new JPanel();
						resultsContainerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
						resultsContainerPanel.setVisible(true);
						
						neutralCountPanel = new JPanel();
						neutralCountPanel.setPreferredSize(new Dimension(30, 135));
						neutralCountPanel.setBackground(grayColor);
						neutralCountPanel.setVisible(true);
						
						neutralCountLabel = new JLabel(Integer.toString(i + positiveResultsPanelArray.size() + 1));
						neutralCountPanel.add(neutralCountLabel);

						resultsContainerPanel.add(neutralCountPanel);
						resultsContainerPanel.add(neutralResultsPanelArray.get(i));
						
						resultContainerPanelList.add(resultsContainerPanel);
					}
				
					// loop through resultsPanel and add each resultPanel to negativeResultsPanel
					for (int i = 0; i < negativeResultsPanelArray.size(); i++) {
					
						resultsContainerPanel = new JPanel();
						resultsContainerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
						resultsContainerPanel.setVisible(true);
						
						negativeCountPanel = new JPanel();
						negativeCountPanel.setPreferredSize(new Dimension(30, 135));
						negativeCountPanel.setBackground(redColor);
						negativeCountPanel.setVisible(true);
						
						negativeCountLabel = new JLabel(Integer.toString(i + positiveResultsPanelArray.size() + neutralResultsPanelArray.size() + 1));
						negativeCountPanel.add(negativeCountLabel);

						resultsContainerPanel.add(negativeCountPanel);
						resultsContainerPanel.add(negativeResultsPanelArray.get(i));
						
						resultContainerPanelList.add(resultsContainerPanel);
					}
					
					return resultContainerPanelList;
				}
				
				protected void done() {
					try {
						ArrayList<JPanel> finalResults = get();
						
						allSessionResults.addAll(finalResults);
						
						for (int i = 0; i < finalResults.size(); i++) {
							resultsPanel.add(finalResults.get(i));
							resultsPanel.revalidate();
						}
						
						feedback.setText(allSessionResults.size() + " results");
						allResultsButton.setEnabled(true);
						positiveResultsButton.setEnabled(true);
						neutralResultsButton.setEnabled(true);
						negativeResultsButton.setEnabled(true);
						
						resetButton.setEnabled(true);
					
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ExecutionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			new getResults().execute();
			
		} else if (source == positiveResultsButton) {
			
			resultsPanel.removeAll();
			
			for (JPanel resultPanel : allSessionResults) {

				if (resultPanel.findComponentAt(10, 10).getBackground() == greenColor) {
					resultsPanel.add(resultPanel);
				}
				
			}
			resultsPanel.revalidate();
			resetButton.setEnabled(true);
		} else if (source == neutralResultsButton) {
			
			resultsPanel.removeAll();
			
			for (JPanel resultPanel : allSessionResults) {

				if (resultPanel.findComponentAt(10, 10).getBackground() == grayColor) {
					resultsPanel.add(resultPanel);
				}
				
			}
	
			resultsPanel.revalidate();
			resetButton.setEnabled(true);
			
		} else if (source == negativeResultsButton) {
			
			resultsPanel.removeAll();
			
			for (JPanel resultPanel : allSessionResults) {

				if (resultPanel.findComponentAt(10, 10).getBackground() == redColor) {
					resultsPanel.add(resultPanel);
				}
			}
			
			resultsPanel.revalidate();
			resetButton.setEnabled(true);
		} else if (source == allResultsButton) {
			
			resultsPanel.removeAll();
			
			for (JPanel resultPanel : allSessionResults) {
				resultsPanel.add(resultPanel);
			}
						
			// re-validate (refresh) the resultsPanel to display new contents
			resultsPanel.revalidate();
			resetButton.setEnabled(true);
			
		} else if (source == clearButton) {
			queryField.setText("");
			goButton.setEnabled(false);
			queryField.requestFocus();
			clearButton.setEnabled(false);
		} else if (source == resetButton) {

			allSessionResults.removeAll(allSessionResults);
			feedback.setText("");
			
			resultsPanel.removeAll();
			resultsPanel.revalidate();
			resultsPanel.requestFocus();
			resetButton.setEnabled(false);
			
			allResultsButton.setEnabled(false);
			positiveResultsButton.setEnabled(false);
			neutralResultsButton.setEnabled(false);
			negativeResultsButton.setEnabled(false);
		
		} else if (source == exitButton) {
			System.exit(0);
		}
	}
	
	GridBagConstraints getConstraints(int gridx, int gridy, int gridwidth, int gridheight, int anchor){
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(3, 3, 3, 3);
		c.ipadx = 0;
		c.ipady = 0;
		c.gridx = gridx;
		c.gridy = gridy;
		c.gridwidth = gridwidth;
		c.gridheight = gridheight;
		c.anchor = anchor;
		return c;
	}
	
	public void keyPressed(KeyEvent e) {
	     if (e.getKeyCode() == KeyEvent.VK_ENTER && !queryField.getText().equals("")) {
	    	 goButton.doClick();
    	 }
	 } 

	public void keyReleased(KeyEvent e) {
			if (queryField.getText().equals("")) {
				goButton.setEnabled(false);
				clearButton.setEnabled(false);
			}
	}
	
	public void keyTyped(KeyEvent e) {
		if (!queryField.getText().equals("")){
			clearButton.setEnabled(true);
			goButton.setEnabled(true);	
		}
	}
	
	public static void setFeedbackText (String message) {
		feedback.setText(message);
	}
}

// TEST: read XML file, print output
//new ReadXMLFile();