package AIS;

import org.json.JSONObject;

public interface DataAIS {
	

	/**
	 * 
	 * @param timespan is the duration of the data in minutes
	 * @param maxlat
	 * @param maxlon
	 * @param minlat
	 * @param minlon
	 * @return the AIS data for a bounding box defined with two latitudes and 2 longitudes
	 */
	public JSONObject getAISData(int timespan, double maxlat, double maxlon, double minlat, double minlon);
	
}
