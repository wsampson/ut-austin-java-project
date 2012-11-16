import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class PreferencePanel extends JPanel implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private  JButton    activateEngine,
			    deactivateEngine,
			    addEngine,
			    removeEngine,
			    savePreferences,
			    cancelPreferences;
	private  JTextArea  activeEngines;
	private  JTextArea  inactiveEngines;

	public PreferencePanel(){
		
		setLayout(new GridBagLayout());

		// create activePanel
		JPanel activeEnginesPanel = new JPanel();
		activeEngines             = new JTextArea("hello", 15, 15);
		activeEngines.setLineWrap(true);
		activeEngines.setWrapStyleWord(true);
		activeEngines.setEditable(false);
		JScrollPane activeResultsScroll = new JScrollPane(activeEngines, 
						      ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
						      ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		activeEnginesPanel.add(activeResultsScroll);
		add(activeResultsScroll,  getConstraints(0, 0, 1, 1, GridBagConstraints.NORTH));
		
		// create inactivePanel
		JPanel inactiveEnginesPanel = new JPanel();
		inactiveEngines = new JTextArea("hello", 15, 15);
		inactiveEngines.setLineWrap(true);
		inactiveEngines.setEditable(false);
		inactiveEngines.setWrapStyleWord(true);
		JScrollPane inactiveResultsScroll = new JScrollPane(inactiveEngines, 
							ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
							ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		inactiveEnginesPanel.add(inactiveResultsScroll);
		add(inactiveResultsScroll,  getConstraints(2, 0, 1, 1, GridBagConstraints.SOUTH));
		
		JPanel activateDeactivatePanel = new JPanel();
		activateDeactivatePanel.setLayout(new BoxLayout(activateDeactivatePanel, BoxLayout.Y_AXIS));
		activateDeactivatePanel.setPreferredSize(new Dimension(55, 55));
		activateEngine                 = new JButton("<");
		deactivateEngine               = new JButton(">");
		activateDeactivatePanel.add(activateEngine);
		activateDeactivatePanel.add(deactivateEngine);
		add(activateDeactivatePanel, getConstraints(1, 0, 1, 1, GridBagConstraints.CENTER));
		
		JPanel addRemoveButtonsPanel = new JPanel();
		addEngine                    = new JButton("+");
		removeEngine                 = new JButton("-");
		addRemoveButtonsPanel.add(addEngine);
		addRemoveButtonsPanel.add(removeEngine);
		add(addRemoveButtonsPanel, getConstraints(2, 1, 1, 1, GridBagConstraints.CENTER));
		
		JPanel bottomButtons = new JPanel();
		savePreferences      = new JButton("Save");
		cancelPreferences    = new JButton("Cancel");
		bottomButtons.add(savePreferences);
		bottomButtons.add(cancelPreferences);
		add(bottomButtons, getConstraints(2, 2, 1, 2, GridBagConstraints.SOUTH));
		
	}
	
	public void actionPerformed(ActionEvent e){
		Object source = e.getSource();
		if (source == addEngine){
			// open addEngine pane
		} else if (source == removeEngine) {
			// remove engine
		} else if (source == cancelPreferences) {
			
		}
	}

	GridBagConstraints getConstraints(int gridx, int gridy, int gridwidth, int gridheight, int anchor){

		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(6, 6, 6, 6);
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