package collect;

import java.util.Calendar;

import org.json.JSONObject;

public interface DataHandler {

	/**
	 *
	 * @param hoursBeforeNow is the delay
	 * @param icaoIds is the id of the airport
	 * @return the METAR data with a number of hours of delay, in a JSONObject
	 */
	public JSONObject getMetarHoursBeforeNow(double hoursBeforeNow, String... icaoIds);
	
	/**
	 * 
	 * @param startDateTime 
	 * @param endDateTime 
	 * @param icaoIds is the id of the airport
	 * @return all the METAR datas between two time, JSONObject
	 */
	public JSONObject getMetarStartTimeEndTime(Calendar startDateTime, Calendar endDateTime, String... icaoIds);
	/**
	 * 
	 * @param hoursBeforeNow is the delay
	 * @param icaoIds is the id of the airport
	 * @return the TAF data with a number of hours of delay, in a JSONObject
	 */

	public JSONObject getTafHoursBeforeNow(double hoursBeforeNow, String... icaoIds);
	/**
	 * 
	 * @param startTime
	 * @param endTime
	 * @param icaoIds is the id of the airport
	 * @return all the TAF datas between two time, JSONObject
	 */
	public JSONObject getTafStartTimeEndTime(Calendar startTime, Calendar endTime, String... icaoIds);
	/**
	 * 
	 * @param hoursAfterNow 
	 * @param icaoIds is the id of the airport
	 * @return the forecast of TAF data with a number of hours of advance (hoursAfterNow)
	 */
	public JSONObject getTafHoursAfterNow(double hoursAfterNow, String... icaoIds);
	/**
	 * 
	 * @return the forecast of marine weather from windy of Brest, chosen by default
	 */
	public JSONObject getWindyForecast();
	/**
	 * 
	 * @param latitude
	 * @param longitude
	 * @return the forecast of marine weather from windy according to the coordinates with a delay of 24h
	 */
	public JSONObject getWindyForecastLocation(double latitude, double longitude);
	/**
	 * 
	 * @param latitude
	 * @param longitude
	 * @param hours
	 * @return the forecast of marine weather from windy according to the coordinates and the delay chosen
	 */
	public JSONObject getWindyForecastHoursAfterNow(double latitude, double longitude, int hours);
	/**
	 * 
	 * @return the current meteo of brest
	 */
	public JSONObject getOpenWeatherCurrent();
	/**
	 * 
	 * @param cityId
	 * @return the current meteo of city defined with its cityId
	 */
	public JSONObject getOpenWeatherCurrentLocation(String cityId);
	/**
	 * 
	 * @param cityId
	 * @param hours
	 * @return the forecast of meteo of a city chosen with the cityId and the delay is chosen with hours
	 */
	public JSONObject getOpenWeatherForecast(String cityId, int hours);

	/**
	 * 
	 * @param timespan is the duration of the data in minutes
	 * @param maxlat
	 * @param maxlon
	 * @param minlat
	 * @param minlon
	 * @return the AIS data and the photos of the boat localised in the zone defined with the two coordinates
	 */
	public JSONObject getAISData(int timespan, double maxlat, double maxlon, double minlat, double minlon);

}
