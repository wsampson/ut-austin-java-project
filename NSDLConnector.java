import java.net.URL;
import java.util.ArrayList;

import org.htmlparser.Parser;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

public class NSDLConnector {
	
	static ArrayList<ResultPanel> connectToPositiveNSDL (Object nsdlURL) {
		
		ArrayList<ResultPanel> positiveResultsPanel = new ArrayList<ResultPanel>();
		
		// turn the URL to a string
		URL    nsdl       = (URL) nsdlURL;
		String stringNSDL = nsdl.toString();
	
		// use HTML Parser parser
		Parser pull = null;
		try {
			pull = new Parser(stringNSDL);
		} catch (ParserException e1) {
			e1.printStackTrace();
		}
		
		// do not ignore any nodes (HTML elements) in the page
		NodeList list = null;
		
		try {
			
			// parse the page
			list = pull.parse (null);
		} catch (ParserException e1) {
			e1.printStackTrace();
		}
		
		// convert parsed page to a string
		String     getIt   = list.toHtml();
		
		// send that string to a StringBuilder object
		StringBuilder nsdlResults = new StringBuilder(getIt);
		
		// call the parseResults method in the NSDLParser class
		positiveResultsPanel = NSDLParser.parseResults(nsdlResults);
		BasePanel.setFeedbackText("Working ::....");
//		System.out.println(positiveResultsPanel.size());
		return positiveResultsPanel;
	}
	
	static ArrayList<ResultPanel> connectToNeutralNSDL (Object nsdlURL) {
		
		ArrayList<ResultPanel> neutralResultsPanel = new ArrayList<ResultPanel>();
		
		// turn the URL to a string
		URL    nsdl       = (URL) nsdlURL;
		String stringNSDL = nsdl.toString();
	
		// use HTML Parser parser
		Parser pull = null;
		try {
			pull = new Parser(stringNSDL);
		} catch (ParserException e1) {
			e1.printStackTrace();
		}
		
		// do not ignore any nodes (HTML elements) in the page
		NodeList list = null;
		
		try {
			
			// parse the page
			list = pull.parse (null);
		} catch (ParserException e1) {
			e1.printStackTrace();
		}
		
		// convert parsed page to a string
		String     getIt   = list.toHtml();
		
		// send that string to a StringBuilder object
		StringBuilder nsdlResults = new StringBuilder(getIt);
		
		// call the parseResults method in the NSDLParser class
		neutralResultsPanel = NSDLParser.parseResults(nsdlResults);
		BasePanel.setFeedbackText("Working ::::..");
//		System.out.println(neutralResultsPanel.size());

		return neutralResultsPanel;
	}

	static ArrayList<ResultPanel> connectToNegativeNSDL (Object nsdlURL) {
	
		ArrayList<ResultPanel> negativeResultsPanel = new ArrayList<ResultPanel>();
	
		// turn the URL to a string
		URL    nsdl       = (URL) nsdlURL;
		String stringNSDL = nsdl.toString();

		// use HTML Parser parser
		Parser pull = null;
		try {
			pull = new Parser(stringNSDL);
		} catch (ParserException e1) {
			e1.printStackTrace();
		}
	
		// do not ignore any nodes (HTML elements) in the page
		NodeList list = null;
	
		try {
		
			// parse the page
			list = pull.parse (null);
		} catch (ParserException e1) {
			e1.printStackTrace();
		}
	
		// convert parsed page to a string
		String     getIt   = list.toHtml();
	
		// send that string to a StringBuilder object
		StringBuilder nsdlResults = new StringBuilder(getIt);
	
		// call the parseResults method in the NSDLParser class
		negativeResultsPanel = NSDLParser.parseResults(nsdlResults);
		BasePanel.setFeedbackText("Working ::::::");

//		System.out.println(negativeResultsPanel.size());

		BasePanel.setFeedbackText("");
		return negativeResultsPanel;
	}
}