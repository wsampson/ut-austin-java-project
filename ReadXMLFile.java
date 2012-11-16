import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import javax.xml.stream.*;

public class ReadXMLFile {
	
	XMLInputFactory inputFactory = XMLInputFactory.newInstance();
	
	static ArrayList<SearchEngine> searchEngineList = new ArrayList<SearchEngine>();
	static SearchEngine searchEngine = null;
	
		public ReadXMLFile(){
		
		try {
			//create a XMLStreamReader object
			FileReader fileReader = new FileReader("sdr_config.xml");
			XMLStreamReader reader = inputFactory.createXMLStreamReader(fileReader);
			
			//Read XML here:
				
			while (reader.hasNext()){
				int eventType = reader.getEventType();
				switch (eventType){
				case XMLStreamConstants.START_ELEMENT:
					String elementName = reader.getLocalName();
					if (elementName.equals("search_engine")){
						
						searchEngine = new SearchEngine();
					}
					if (elementName.equals("name")){
						String name = reader.getElementText();
						searchEngine.setName(name);
					}
					if (elementName.equals("url")){
						String url = reader.getElementText();
						searchEngine.setURL(url);
					}
					if (elementName.equals("description")){
						String description = reader.getElementText();
						searchEngine.setDescription(description);
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					elementName = reader.getLocalName();
					if (elementName.equals("search_engine")){
						searchEngineList.add(searchEngine);
					}
					break;
				default:
					break;
				}
				reader.next();
			} //while
			
			} catch (FileNotFoundException e){
				e.printStackTrace();
			} catch (XMLStreamException e) {
				e.printStackTrace();
			}
	}
		
	public static String outputSearchEngines(){
		String printEngines = "";
		
		for (int i = 0; i <        searchEngineList.size(); i++){
			printEngines += "\n" + 
						   searchEngineList.get(i).getName()        + "\n" + 
			       		           searchEngineList.get(i).getDescription() + "\n" +
						   searchEngineList.get(i).getURL()         + "\n";	
		}
		return printEngines;
	}
} //class
