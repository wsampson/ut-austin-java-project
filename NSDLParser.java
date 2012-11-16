import java.util.ArrayList;

public class NSDLParser {
	
	static ArrayList<ResultPanel> parseResults(StringBuilder nsdlResults) {
		
		nsdlResults.trimToSize();
		ArrayList<SearchResult> searchResultList = new ArrayList<SearchResult>();
		ArrayList<ResultPanel>  resultPanels     = new ArrayList<ResultPanel>();		
		
		ArrayList<Integer> resultsIndex = new ArrayList<Integer>();

		int indexValue = 0;
		
		for (int i = 0; i < nsdlResults.length(); i = i + 1500) {
			
			indexValue = nsdlResults.indexOf("id=\"link_", i);
		
			// if loop encounters an 'id="link_' character string (it returns > -1), then do this:
			if (indexValue > -1) {
				
				// backtrack a bit to get the URL
				int endURL = indexValue - 18;
				int URLCount = 0;
				while (nsdlResults.charAt(endURL - URLCount) != '"') {
					URLCount++;
				}
				String url = nsdlResults.substring(endURL - URLCount + 1, endURL + 1);
				
				// grab the title and description for a single digit in 'id="link_x"'
				if (nsdlResults.charAt(indexValue + 11) == '>') {
					
					int titleCount = 0;
					while (nsdlResults.charAt(indexValue + 12 + titleCount) != '<') {
						titleCount++;
					}
					
					// pull title
					String title = nsdlResults.substring(indexValue + 12, indexValue + 12 + titleCount);
					
					// grab description
					int descMarker = indexValue + 12 + titleCount + 47;
					int descCount  = 0;
					while (nsdlResults.charAt(descMarker + descCount) != '<') {
							descCount++;
						}
					
					// pull description
					String desc = nsdlResults.substring(descMarker, descMarker + descCount);
					
					SearchResult searchResult = new SearchResult();
					searchResult.setURL(url);
					searchResult.setTitle(title);
					searchResult.setDescription(desc);
					searchResultList.add(searchResult);
					
					//System.out.println(title + " <" + url + "> " + "\n\t" + desc);
					
					resultPanels = SearchResultPanels.createPanels(searchResultList);
					resultsIndex.add(indexValue);
					i = resultsIndex.get(resultsIndex.size() - 1);
					
				} // if
				
				// grab the title for a double digit in 'id="link_xx"'
				if (nsdlResults.charAt(indexValue + 12) == '>') {
					
					int titleCount = 0;
					while (nsdlResults.charAt(indexValue + 12 + titleCount) != '<') {
						titleCount++;
					}
					String title = nsdlResults.substring(indexValue + 13, indexValue + 12 + titleCount);

					// grab description
					int descMarker = indexValue + 13 + titleCount + 48;
					int descCount  = 0;
					while (nsdlResults.charAt(descMarker + descCount) != '<') {
							descCount++;
						}
					
					// pull description
					String desc = nsdlResults.substring(descMarker, descMarker + descCount);

					SearchResult searchResult = new SearchResult();
					searchResult.setURL(url);
					searchResult.setTitle(title);
					searchResult.setDescription(desc);
					searchResultList.add(searchResult);
			
//					System.out.println(title + " <" + url + "> " + "\n\t" + desc);					
		
					resultPanels = SearchResultPanels.createPanels(searchResultList);
					resultsIndex.add(indexValue);
					i = resultsIndex.get(resultsIndex.size() - 1);
				}
			}
		}
		return resultPanels;
	}
}