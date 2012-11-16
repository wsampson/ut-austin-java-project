import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class SearchURLGenerator {

	public static ArrayList<ResultPanel> createPostiveNSDLSearchURL(String userQuery){
		
		BasePanel.setFeedbackText("Working ......");
		
		//format userQuery	
		userQuery = userQuery.replace(" ", "+");
		
		ArrayList<ResultPanel> positiveResultsPanel = new ArrayList<ResultPanel>();
		
		try {
			URL positiveNSDL     = new URL("http://nsdl.org/search/?q=global+warming+OR+climate+change+" + userQuery + "+NOT+wait+NOT+forcings+NOT+variability+NOT+invalidate+NOT+unknown+NOT+flux+NOT+overestimated+NOT+assumes+NOT+nao&verb=Search&s=0&n=30&audience=4");
			positiveResultsPanel = NSDLConnector.connectToPositiveNSDL(positiveNSDL);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return positiveResultsPanel;
	}
	
	public static ArrayList<ResultPanel> createNeutralNSDLSearchURL(String userQuery){
		
		//format userQuery	
		userQuery = userQuery.replace(" ", "+");
		
		ArrayList<ResultPanel> neutralResultsPanel = new ArrayList<ResultPanel>();
	
		URL neutralNSDL;
		try {
				neutralNSDL = new URL("http://nsdl.org/search/?q=global+warming+OR+climate+change+AND+" + userQuery + "+AND+possibility+AND+possible+AND+controversial&verb=Search&s=0&n=30&audience=4");
				neutralResultsPanel = NSDLConnector.connectToNeutralNSDL(neutralNSDL);
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
		}
		return neutralResultsPanel;
	}	
	
	public static ArrayList<ResultPanel> createNegativeNSDLSearchURL(String userQuery){
		
		//format userQuery	
		userQuery = userQuery.replace(" ", "+");
		
		ArrayList<ResultPanel> negativeResultsPanel = new ArrayList<ResultPanel>();
			
			URL negativeNSDL;
			try {
				negativeNSDL = new URL("http://nsdl.org/search/?q=global%20warming%20OR%20climate%20change%20" + userQuery + "%20NOT%20rising%20NOT%20urgency%20NOT%20melting%20NOT%20mitigation%20NOT%20health%20NOT%20malaria%20NOT%20churn%20NOT%20genetic%20NOT%20un%20NOT%20kills%20NOT%20education%20NOT%20kids%20NOT%20kyoto%20NOT%20biosphere%20NOT%20blame%20NOT%20warmest%20NOT%20confronting%20NOT%20decline%20NOT%20fighting%20NOT%20socratic%20NOT%20framework%20NOT%20greenhouse-gas-induced%20NOT%20salinization&verb=Search&s=0&n=30&audience=4");
				negativeResultsPanel = NSDLConnector.connectToNegativeNSDL(negativeNSDL);
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		return negativeResultsPanel;
	}	
			
	
//	public static ArrayList<ResultPanel> createPostiveScholarSearchURL(String userQuery){
//		
//			URL positiveGoogle;
//			try {
//				positiveGoogle = new URL("http://scholar.google.com/scholar?q=global+warming+OR+climate+change+" + userQuery + "+-uncertainty+-risk+-cost+-losses+-thrive+-benefits+-ricardian+-decrease+-skepticism&hl=en&lr=&start=10&sa=N");
//				positiveResultsPanel = GoogleScholarConnector.connectToScholar(positiveGoogle);
//			} catch (MalformedURLException e11) {
//				// TODO Auto-generated catch block
//				e11.printStackTrace();
//			}
//			return positiveResultsPanel;
//	}		
//	
//	public static ArrayList<ResultPanel> createNeutralScholarSearchURL(String userQuery){
//		
//			URL neutralGoogle;
//			try {
//				neutralGoogle = new URL("http://scholar.google.com/scholar?hl=en&lr=&q=global+warming+OR+climate+change+" + userQuery + "+possibility+possible+controversial&btnG=Search");
//				neutralRsultsPanel = GoogleScholarConnector.connectToScholarL(neutralGoogle);
//			} catch (MalformedURLException e11) {
//				// TODO Auto-generated catch block
//				e11.printStackTrace();
//			}
//			return neutralResultsPanel;
//	}
//	
//	public static ArrayList<ResultPanel> createNegativeScholarSearchURL(String userQuery){
//		
//			URL negativeGoogle;
//			try {
//				negativeGoogle = new URL("http://scholar.google.com/scholar?hl=en&lr=&q=global+warming+OR+climate+change+" + userQuery + "+invalid+-retreat+-rising+-urgency+-melting+-mitigation+-health+-malaria+-churn+-genetic+-kills+-education+-kids+-kyoto+-biosphere+-blame+-confronting+-burning+-decline+&btnG=Search");
//				negativeResultsPanel = GoogleScholarConnector.connectToScholar(negativeGoogle);
//			} catch (MalformedURLException e11) {
//				// TODO Auto-generated catch block
//				e11.printStackTrace();
//			}
//		return negativeResultsPanel;
//	}

}