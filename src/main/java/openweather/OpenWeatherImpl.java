package openweather;

import org.json.JSONArray;
import org.json.JSONObject;
import util.Constants;
import util.HttpRequest;
import util.WrongStatusCodeException;

public class OpenWeatherImpl implements OpenWeather {

	public JSONObject getDataOpenWeather(String typeRequest, String cityId) {
		JSONObject result = new JSONObject();
		String request = String.format(Constants.SERVER_URL_OW, typeRequest, cityId);
		try {
			String response = HttpRequest.getHttp(request);
			result = new JSONObject(response);
			if (typeRequest.equals("weather")) {
				removeForecastData(result);
				result.remove("base");
				result.remove("cod");
				result.remove("id");
			}
		}catch(WrongStatusCodeException e) {
			e.printStackTrace();
			return e.getErrorJSON();
		}
		return result;
	}

	public JSONObject getDataOpenWeather(String typeRequest, String cityId, int hours) {
		JSONObject result = getDataOpenWeather(typeRequest, cityId);
		if (!result.has("error") && typeRequest.equals("forecast")) {
			int length = hours / 3;
			result.put("list", ((JSONArray) result.get("list")).toList().subList(0, length));
			JSONArray list = (JSONArray) result.get("list");
			for (int i = 0; i < length; i++) {
				JSONObject forecast = (JSONObject) list.get(i);
				removeForecastData(forecast);
				forecast.remove("pop");
			}
			result = new JSONObject().put("forecast", list);
		}
		return result;
	}

	private void removeForecastData(JSONObject data) {
		data.remove("sys");
		data.remove("weather");
		data.remove("wind");
	}
}
