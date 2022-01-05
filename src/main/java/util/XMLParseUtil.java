package util;

import java.util.LinkedList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;
import org.json.JSONObject;

public class XMLParseUtil {
	
	public static final String METAR = "METAR";
	public static final String TAF = "TAF";
	
	public static List<String> parseXMLString(String xmlString, String type) {
		Document doc = null;
		JSONObject jsonObject = new JSONObject();
		
        try {
            doc = DocumentHelper.parseText(xmlString);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        
        List<Node> nodes = doc.selectNodes("/response/data/"+type+"/raw_text");
        
        List<String> rawTextList =  new LinkedList<>();
        for(Node node : nodes) {
        	rawTextList.add(node.getText());
        }
  
		return rawTextList;
	}

}
