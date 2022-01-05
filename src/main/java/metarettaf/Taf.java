package metarettaf;

import java.io.IOException;
import java.util.Calendar;

import org.json.JSONObject;

public interface Taf {
	
	/**
	 * to obtain all available TAFs for an airport in the last time, based on valid time
	 * @param icaoIds : the ICAO list of many airports
	 * @param hoursBeforeNow
	 * @return : all TAFs in format JSON
	 * @throws IOException
	 */
	public JSONObject getTafHoursBeforeNow(double hoursBeforeNow, String... icaoIds);
	
	/**
	 * to obtain all TAFs for an airport with valid time between start time and end time
	 * @param icaoIds : the ICAO list of many airports
	 * @param startTime
	 * @param endTime
	 * @return : all TAFs in format JSON
	 * @throws IOException 
	 */
	public JSONObject getTafStartTimeEndTime(Calendar startTime, Calendar endTime, String... icaoIds);
	
	/**
	 * to obtain all available TAFs for an airport in the next time, based on valid time
	 * @param icaoIds : the ICAO list of many airports
	 * @param hoursAfterNow
	 * @return : all TAFs in format JSON
	 * @throws IOException
	 */
	public JSONObject getTafHoursAfterNow(double hoursAfterNow, String... icaoIds);



}
