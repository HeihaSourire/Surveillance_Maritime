package metarettaf;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.json.JSONObject;

import util.Constants;
import util.HttpRequest;
import util.WrongStatusCodeException;
import util.XMLParseUtil;

public class TafImpl implements Taf {
	
	@Override
	public JSONObject getTafHoursBeforeNow(double hoursBeforeNow, String... icaoIds){		
		JSONObject jsonObject = new JSONObject();
		
		for(String icaoId : icaoIds) {
			try {

			//Generate the full URL based on the time range and airports ICAO.
			String url = Constants.SERVER_URL_NOAA_TAF + "stationString=" + icaoId + "&hoursBeforeNow=" + hoursBeforeNow;
			String string = new String();
			//Get request using URL
			string = HttpRequest.getHttp(url);
			//Get useful datas (raw) and add in format JSON
			jsonObject.accumulate("TAF", XMLParseUtil.parseXMLString(string, XMLParseUtil.TAF));
			}catch(WrongStatusCodeException e) {
				e.printStackTrace();
				return e.getErrorJSON();
			}
		}
		return jsonObject;
	}

	@Override
	public JSONObject getTafStartTimeEndTime(Calendar startTime, Calendar endTime, String... icaoIds) {
		//Month in Calendar class start from 0
		startTime.add(Calendar.MONTH, -1);
		endTime.add(Calendar.MONTH, -1);
		
		SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		
		JSONObject jsonObject = new JSONObject();
		
		for(String icaoId : icaoIds) {
			try {
			//Generate the full URL
			String url = Constants.SERVER_URL_NOAA_TAF + "startTime=" + newFormat.format(startTime.getTime()) + 
					"&endTime=" + newFormat.format(endTime.getTime()) + 
					"&stationString=" + icaoId;
			
			String string = new String();
			string = HttpRequest.getHttp(url);
			
			//Get useful data and add in format JSON
			jsonObject.accumulate("TAF", XMLParseUtil.parseXMLString(string, XMLParseUtil.TAF));
			}catch(WrongStatusCodeException e) {
				e.printStackTrace();
				return e.getErrorJSON();
			}
		}
		return jsonObject;
	}

	@Override
	public JSONObject getTafHoursAfterNow(double hoursAfterNow, String... icaoIds) {
		//Get current time and time in a few hours
		long currentTime = System.currentTimeMillis();
		Calendar startTime = Calendar.getInstance();
		startTime.setTimeInMillis(currentTime);
		
		currentTime += 1.5 * 3600 *1000;
		Calendar endTime = Calendar.getInstance();
		endTime.setTimeInMillis(currentTime);
		
		startTime.add(Calendar.MONTH, +1);
		endTime.add(Calendar.MONTH, +1);
		
		JSONObject jsonObject = this.getTafStartTimeEndTime(startTime, endTime, icaoIds);
		return jsonObject;
	}

}
