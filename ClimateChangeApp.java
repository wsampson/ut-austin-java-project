import javax.swing.SwingUtilities;

public class ClimateChangeApp {

	/**
	 * <b> Climate Change Search Portal</b>
	 * @author Erik, Ann and Walker
	 * @version 0.8
	 */
	public static void main(String[] args) {
		
		Thread climateChangeFrame = new Thread(new ClimateChangeFrame());
		
		SwingUtilities.invokeLater(climateChangeFrame);
	}
}