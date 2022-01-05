package metarettaf;

import java.io.IOException;
import java.util.Calendar;

import org.json.JSONObject;

public interface Metar {
	
	/**
	 * to get all METARs for many airports from the past time
	 * @param icaoId : the ICAO list of many airports
	 * @param hoursBeforeNow : how much hours from now
	 * @return : METAR data in format JSON
	 * @throws IOException
	 */
	public JSONObject getMetarHoursBeforeNow(double hoursBeforeNow, String... icaoIds);
	
	/**
	 * to obtain all METARs collected between start time and end time
	 * @param icaoId : the ICAO list of many airports
	 * @param startDateTime
	 * @param endDateTime
	 * @return : METAR data in format JSON
	 * @throws IOException 
	 */
	public JSONObject getMetarStartTimeEndTime(Calendar startDateTime, Calendar endDateTime, String... icaoIds);


}
