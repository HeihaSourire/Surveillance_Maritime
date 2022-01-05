package collect;

import java.io.InputStream;
import java.util.Calendar;
import java.util.Iterator;

import org.json.JSONObject;

import AIS.DataAISImpl;
import metarettaf.MetarImpl;
import metarettaf.TafImpl;
import openweather.OpenWeatherImpl;
import util.Constants;
import util.CreateFile;
import util.HttpRequest;
import windy.WindyImpl;

public class DataHandlerImpl implements DataHandler {
	
	//Implementation of all request methods
	
	private MetarImpl metarImpl = new MetarImpl();
	private TafImpl tafImpl = new TafImpl();
	private WindyImpl windyImpl = new WindyImpl();
	private OpenWeatherImpl openWeatherImpl = new OpenWeatherImpl();
	private DataAISImpl dataAISimpl = new DataAISImpl();
	
	@Override
	public JSONObject getMetarHoursBeforeNow(double hoursBeforeNow, String... icaoIds) {
		JSONObject data = metarImpl.getMetarHoursBeforeNow(hoursBeforeNow, icaoIds);
		CreateFile.createJSON(Constants.OUTPUT_PATH, "METAR", data);
		return data;
	}

	@Override
	public JSONObject getMetarStartTimeEndTime(Calendar startDateTime, Calendar endDateTime, String... icaoIds) {
		JSONObject data = metarImpl.getMetarStartTimeEndTime(startDateTime, endDateTime, icaoIds);
		CreateFile.createJSON(Constants.OUTPUT_PATH, "METAR", data);
		return data;
	}

	@Override
	public JSONObject getTafHoursBeforeNow(double hoursBeforeNow, String... icaoIds) {
		JSONObject data = tafImpl.getTafHoursBeforeNow(hoursBeforeNow, icaoIds);
		CreateFile.createJSON(Constants.OUTPUT_PATH, "TAF", data);
		return data;
	}

	@Override
	public JSONObject getTafStartTimeEndTime(Calendar startTime, Calendar endTime, String... icaoIds) {
		JSONObject data = tafImpl.getTafStartTimeEndTime(startTime, endTime, icaoIds);
		CreateFile.createJSON(Constants.OUTPUT_PATH, "TAF", data);
		return data;
	}

	@Override
	public JSONObject getTafHoursAfterNow(double hoursAfterNow, String... icaoIds) {
		JSONObject data = tafImpl.getTafHoursAfterNow(hoursAfterNow, icaoIds);
		CreateFile.createJSON(Constants.OUTPUT_PATH, "TAF", data);
		return data;
	}

	@Override
	public JSONObject getWindyForecast() {
		JSONObject data = windyImpl.getData();
		CreateFile.createJSON(Constants.OUTPUT_PATH, "windy", data);
		return data;
	}

	@Override
	public JSONObject getWindyForecastLocation(double latitude, double longitude) {
		JSONObject data = windyImpl.getDataLocation(latitude, longitude);
		CreateFile.createJSON(Constants.OUTPUT_PATH, "windy", data);
		return data;
	}

	@Override
	public JSONObject getWindyForecastHoursAfterNow(double latitude, double longitude, int hours) {
		JSONObject data = windyImpl.getDataForecast(latitude, longitude, hours);
		CreateFile.createJSON(Constants.OUTPUT_PATH, "windy", data);
		return data;
	}

	@Override
	public JSONObject getOpenWeatherCurrent() {
		JSONObject data = openWeatherImpl.getData();
		CreateFile.createJSON(Constants.OUTPUT_PATH, "openWeather", data);
		return data;
	}

	@Override
	public JSONObject getOpenWeatherCurrentLocation(String cityId) {
		JSONObject data = openWeatherImpl.getDataLocation(cityId);
		CreateFile.createJSON(Constants.OUTPUT_PATH, "openWeather", data);
		return data;
	}

	@Override
	public JSONObject getOpenWeatherForecast(String cityId, int hours) {
		JSONObject data = openWeatherImpl.getDataForecast(cityId, hours);
		CreateFile.createJSON(Constants.OUTPUT_PATH, "openWeather", data);
		return data;
	}

	@Override
	public JSONObject getAISData(int timespan, double maxlat, double maxlon, double minlat, double minlon) {
		JSONObject data = dataAISimpl.getAISData(timespan, maxlat, maxlon, minlat, minlon);
		CreateFile.createJSON(Constants.OUTPUT_PATH, "AIS", data);
		Iterator<String> photoUrls = ((JSONObject) data.get("photos")).keys();
		while(photoUrls.hasNext()) {
			String mmsi = photoUrls.next();
			String photoUrl = ((JSONObject) data.get("photos")).getString(mmsi);
			InputStream photo = HttpRequest.getPhoto(photoUrl);
			if(photo!=null)
				CreateFile.createPhoto(Constants.OUTPUT_PATH, mmsi, photo);
		}
		return data;
	}

}
