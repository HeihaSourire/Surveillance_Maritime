package openweather;

import org.json.JSONObject;

public interface OpenWeather {

	default JSONObject getData() {
		return getDataOpenWeather("weather", "3030300"); // default values for Brest, FR
	}

	default JSONObject getDataLocation(String cityId) {
		return getDataOpenWeather("weather", cityId);
	}

	default JSONObject getDataForecast(String cityId, int hours) {
		return getDataOpenWeather("forecast", cityId, hours);
	}

	public JSONObject getDataOpenWeather(String typeRequest, String cityId);

	public JSONObject getDataOpenWeather(String typeRequest, String cityId, int hours);

}
