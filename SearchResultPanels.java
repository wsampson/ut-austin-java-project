import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

public class SearchResultPanels {

	public static ArrayList<ResultPanel> createPanels(ArrayList<SearchResult> searchResultList) {
		
		ArrayList<ResultPanel> resultPanels = new ArrayList<ResultPanel>();
		
		for (SearchResult resultPanel : searchResultList) {
			resultPanels.add(new ResultPanel(resultPanel));
		}
		return resultPanels;
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