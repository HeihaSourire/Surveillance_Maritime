package AIS;

import org.json.JSONArray;
import org.json.JSONObject;

import util.Constants;
import util.HttpRequest;
import util.WrongStatusCodeException;

public class DataAISImpl implements DataAIS{

	private static final String SERVER_URL_MARINETRAFFIC = Constants.SERVER_URL_MARINETRAFFIC + Constants.MARINETRAFFIC_KEY4;
	//If there is no left credits on the MarineTraffic account --> Change the number at the end of MARINETRAFFIC_KEY
	private static final String SERVER_URL_MARINETRAFFIC_PHOTO = Constants.SERVER_URL_MARINETRAFFIC_PHOTO + Constants.MARINETRAFFIC_KEYPHOTO3;
	//If there is no left credits on the MarineTraffic account --> Change the number at the end of the MARINETRAFFIC_KEYPHOTO
	
	@Override
	public JSONObject getAISData(int timespan, double maxlat, double maxlon, double minlat, double minlon) {
		
		//In order to obtain more or less AIS data, you can change the String option with "simple" or "extended" or "full"
		String option = "extended";
		//url is the link of the API
		String url = SERVER_URL_MARINETRAFFIC+"%20%20%20%20?v=8&timespan="+String.valueOf(timespan)+"&MAXLAT="
				+String.valueOf(48.346864)+"&MINLON="+String.valueOf(-4.544722)+"&MAXLON="
				+String.valueOf(-4.418770)+"&MINLAT="+String.valueOf(48.307454)+"&protocol=jsono&msgtype="+option;
		//the JSONObject result will contain the AIS data and the JSONObject photos which will contain the photos of the boats
		JSONObject result = new JSONObject();
		JSONObject photos = new JSONObject();
		try {
			//connexion protocol
			String response = HttpRequest.getHttp(url);		
			JSONArray data = new JSONArray(response);
			result.put("AIS", data);
			//recuperation of all the photos
			for(Object json : data) {
				String MMSI = ((JSONObject) json).getString("MMSI");
	            JSONArray photo = this.getAISPhoto(MMSI);
	            if(photo!=null)
	            	photos.put("MMSI_" + MMSI, photo.getJSONObject(0).getString("URL"));
			}
		}catch(WrongStatusCodeException e) {
			e.printStackTrace();
			e.getErrorJSON();
		}
		result.put("photos", photos);
		return result;
	}
	
	/**
	 * 
	 * @param vesselId is the MMSI id of the boat
	 * @return a JSONArray with boat's photo, method used for getAISData()
	 */
	private JSONArray getAISPhoto(String vesselId) {
		//url is the link of the API
		String url = SERVER_URL_MARINETRAFFIC_PHOTO+"?vessel_id="+ vesselId+"&protocol=jsono";
		String response = "";
		//connexion protocol
		try {
			response = HttpRequest.getHttp(url);
		} catch (WrongStatusCodeException e) {
			e.printStackTrace();
			return null;
		}
		JSONArray data = new JSONArray(response);
		return data;
	}
	
}
