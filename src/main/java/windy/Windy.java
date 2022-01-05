package windy;

import org.json.JSONObject;

public interface Windy {

	/**
	 * Function to get forecast data from windy server. For Brest and for the next
	 * 24 hours.
	 * 
	 * @return Forecast data from windy server
	 */
	default JSONObject getData() {
		return getDataForecast(48.4, -4.48, 24); // default values for Brest, FR
	}

	/**
	 * Function to get forecast data from windy server. For the next 24 hours.
	 * 
	 * @param lat latitude
	 * @param lon longitude
	 * @return Forecast data from windy server
	 */
	default JSONObject getDataLocation(double lat, double lon) {
		return getDataForecast(lat, lon, 24);
	}

	/**
	 * Function to get forecast data from windy server.
	 * 
	 * @param lat   latitude
	 * @param lon   longitude
	 * @param hours number of forecast hours
	 * @return Forecast data from windy server
	 */
	public JSONObject getDataForecast(double lat, double lon, int hours);

}
