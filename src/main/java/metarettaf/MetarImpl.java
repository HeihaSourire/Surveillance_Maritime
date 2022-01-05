package metarettaf;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.json.JSONObject;

import util.Constants;
import util.HttpRequest;
import util.WrongStatusCodeException;
import util.XMLParseUtil;

public class MetarImpl implements Metar {
	
	@Override
	public JSONObject getMetarHoursBeforeNow(double hoursBeforeNow, String... icaoIds){
		JSONObject jsonObject = new JSONObject();
		for(String icaoId : icaoIds) {
			try {
			//Splicing request address
			String url = Constants.SERVER_URL_NOAA_METAR + "stationString=" + icaoId + "&hoursBeforeNow=" + hoursBeforeNow; 
			String XMLstring = new String();
			XMLstring = HttpRequest.getHttp(url);
			
			//Convert the XML string to JSON format and store it in jsonObject  
			jsonObject.accumulate("Metar", XMLParseUtil.parseXMLString(XMLstring, XMLParseUtil.METAR));
			}catch(WrongStatusCodeException e) {
				e.printStackTrace();
				return e.getErrorJSON();
			}
		}
		return jsonObject;
	
	}

	@Override
	public JSONObject getMetarStartTimeEndTime(Calendar startDateTime, Calendar endDateTime, String... icaoIds) {
		//The month of calendar start from 0, so we decrease startDateTime and endDateTime by one
		startDateTime.add(Calendar.MONTH, -1);
		endDateTime.add(Calendar.MONTH, -1);
		
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ" );
        JSONObject jsonObject = new JSONObject();
        
        for(String icaoId :icaoIds) {
        	try {
        	//Splicing request address
    		String url = Constants.SERVER_URL_NOAA_METAR + "startTime=" + sdf.format(startDateTime.getTime()) +"&endTime=" + sdf.format(endDateTime.getTime()) + 
    				"&stationString=" + icaoId;
    		String XMLstring = new String();
			XMLstring = HttpRequest.getHttp(url);
			
			//Convert the XML string to JSON format and store it in jsonObject  
    		jsonObject.accumulate("Metar", XMLParseUtil.parseXMLString(XMLstring, XMLParseUtil.METAR));
        	}catch(WrongStatusCodeException e) {
        		e.printStackTrace();
    			return e.getErrorJSON();
        	}
        }
		return jsonObject;
	}
	
	

}
