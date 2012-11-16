//import java.util.ArrayList;
//
//
//public class GoogleScholarParser {
//
//	static ArrayList<ResultPanel> parseResults(StringBuilder scholarResults) {
//		
//		scholarResults.trimToSize();
//		ArrayList<SearchResult> searchResultList = new ArrayList<SearchResult>();
//		ArrayList<ResultPanel>  resultPanels     = new ArrayList<ResultPanel>();		
//		
//		ArrayList<Integer> resultsIndex = new ArrayList<Integer>();
//
//		int indexValue = 0;
//		
//		for (int i = 0; i < scholarResults.length(); i = i + 50) {
//			
//			indexValue = scholarResults.indexOf("<h3 class=\"r\">", i);
//			
//			// if loop encounters an '<h3 class="r">' character string (it returns > -1), then do this:
//			if (indexValue > -1) {
//				
//				// check to see if result has the '[BOOK]' description
//				if (scholarResults.charAt(indexValue + 31) == '[') {
//					
//					// if so, pull title + book description					
//					int titleCount = 0;
//					while (scholarResults.charAt(indexValue + 13 + titleCount) != '<') {
//						titleCount++;
//					}
//					
//				}
//				
//			}
//	}
//}
