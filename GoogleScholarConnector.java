//import java.net.URL;
//import java.util.ArrayList;
//
//import org.htmlparser.Parser;
//import org.htmlparser.util.NodeList;
//import org.htmlparser.util.ParserException;
//
//public class GoogleScholarConnector {
//	
//	static ArrayList<ResultPanel> connectToPositiveGScholar (Object scholarURL) {
//		
//		ArrayList<ResultPanel> positiveResultsPanel = new ArrayList<ResultPanel>();
//		
//		// turn the URL to a string
//		URL    scholar       = (URL) scholarURL;
//		String stringNSDL = scholar.toString();
//	
//		// use HTML Parser parser
//		Parser pull = null;
//		try {
//			pull = new Parser(stringNSDL);
//		} catch (ParserException e1) {
//			e1.printStackTrace();
//		}
//		
//		// do not ignore any nodes (HTML elements) in the page
//		NodeList list = null;
//		
//		try {
//			
//			// parse the page
//			list = pull.parse (null);
//		} catch (ParserException e1) {
//			e1.printStackTrace();
//		}
//		
//		// convert parsed page to a string
//		String     getIt   = list.toHtml();
//		
//		// send that string to a StringBuilder object
//		StringBuilder scholarResults = new StringBuilder(getIt);
//		
//		// call the parseResults method in the NSDLParser class
//		positiveResultsPanel = GoogleScholarParser.parseResults(scholarResults);
//		System.out.println(positiveResultsPanel.size());
//
//		// write it to a file (may be unnecessary)
////		File       outNSDL = new File("nsdl.html");
////		FileWriter out     = null;
////		try {
////			out = new FileWriter(outNSDL);
////		} catch (IOException e) {
////		
////			e.printStackTrace();
////		}
////			try {
////				out.write(getIt);
////			} catch (IOException e) {
////		
////				e.printStackTrace();
////			}
////		    try {
////				out.close();
////			} catch (IOException e) {
////		
////				e.printStackTrace();
////			}
//		return positiveResultsPanel;
//	}
//	
//	static ArrayList<ResultPanel> connectToNeutralNSDL (Object scholarURL) {
//		
//		ArrayList<ResultPanel> neutralResultsPanel = new ArrayList<ResultPanel>();
//		
//		// turn the URL to a string
//		URL    scholar       = (URL) scholarURL;
//		String stringNSDL = scholar.toString();
//	
//		// use HTML Parser parser
//		Parser pull = null;
//		try {
//			pull = new Parser(stringNSDL);
//		} catch (ParserException e1) {
//			e1.printStackTrace();
//		}
//		
//		// do not ignore any nodes (HTML elements) in the page
//		NodeList list = null;
//		
//		try {
//			
//			// parse the page
//			list = pull.parse (null);
//		} catch (ParserException e1) {
//			e1.printStackTrace();
//		}
//		
//		// convert parsed page to a string
//		String     getIt   = list.toHtml();
//		
//		// send that string to a StringBuilder object
//		StringBuilder scholarResults = new StringBuilder(getIt);
//		
//		// call the parseResults method in the NSDLParser class
//		neutralResultsPanel = GoogleScholarParser.parseResults(scholarResults);
//		System.out.println(neutralResultsPanel.size());
//	
////      write it to a file (may be unnecessary)
////		File       outNSDL = new File("nsdl.html");
////		FileWriter out     = null;
////		try {
////			out = new FileWriter(outNSDL);
////		} catch (IOException e) {
////		
////			e.printStackTrace();
////		}
////			try {
////				out.write(getIt);
////			} catch (IOException e) {
////		
////				e.printStackTrace();
////			}
////		    try {
////				out.close();
////			} catch (IOException e) {
////		
////				e.printStackTrace();
////			}
//		return neutralResultsPanel;
//	}
//
//	static ArrayList<ResultPanel> connectToNegativeNSDL (Object scholarURL) {
//	
//		ArrayList<ResultPanel> negativeResultsPanel = new ArrayList<ResultPanel>();
//	
//		// turn the URL to a string
//		URL    scholar    = (URL) scholarURL;
//		String stringNSDL = scholar.toString();
//
//		// use HTML Parser parser
//		Parser pull = null;
//		try {
//			pull = new Parser(stringNSDL);
//		} catch (ParserException e1) {
//			e1.printStackTrace();
//		}
//	
//		// do not ignore any nodes (HTML elements) in the page
//		NodeList list = null;
//	
//		try {
//		
//			// parse the page
//			list = pull.parse (null);
//		} catch (ParserException e1) {
//			e1.printStackTrace();
//		}
//	
//		// convert parsed page to a string
//		String     getIt   = list.toHtml();
//	
//		// send that string to a StringBuilder object
//		StringBuilder scholarResults = new StringBuilder(getIt);
//	
//		// call the parseResults method in the NSDLParser class
//		negativeResultsPanel = GoogleScholarParser.parseResults(scholarResults);
//		System.out.println(negativeResultsPanel.size());
//
//		// write it to a file (may be unnecessary)
////		File       outNSDL = new File("nsdl.html");
////		FileWriter out     = null;
////		try {
////			out = new FileWriter(outNSDL);
////		} catch (IOException e) {
////	
////			e.printStackTrace();
////		}
////			try {
////				out.write(getIt);
////			} catch (IOException e) {
////	
////				e.printStackTrace();
////			}
////	 	   try {
////				out.close();
////			} catch (IOException e) {
////	
////				e.printStackTrace();
////			}
//		return negativeResultsPanel;
//	}
//}