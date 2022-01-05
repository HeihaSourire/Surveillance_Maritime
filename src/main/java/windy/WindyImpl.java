package windy;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import util.Constants;
import util.HttpRequest;
import util.WrongStatusCodeException;

public class WindyImpl implements Windy {

	private static final String SERVER_URL_WINDY = Constants.SERVER_URL_WINDY;
	private static final ArrayList<String> REQUESTS_WINDY = Constants.REQUESTS_WINDY;

	public JSONObject getDataForecast(double lat, double lon, int hours) {
		JSONObject result = new JSONObject();
		for (String request : getRequest(lat, lon)) {
			try {
				JSONObject response = new JSONObject(HttpRequest.postHttp(request, SERVER_URL_WINDY));
				response.remove("warning");
				int begin = getBeginIndex((JSONArray) response.get("ts"), hours);
				for (String key : response.keySet()) {
					if (response.get(key) instanceof JSONArray) {
						response.put(key, ((JSONArray) response.get(key)).toList().subList(begin, begin + hours / 3));
					}
				}
				result.put((new JSONObject(request)).get("model").toString(), response);
			} catch (JSONException e) {
				e.printStackTrace();
			}catch(WrongStatusCodeException e) {
				e.printStackTrace();
				return e.getErrorJSON();
			}
		}
		return result;
	}

	private static int getBeginIndex(JSONArray timestamps, int hours) {
		int begin = 0;
		long now = System.currentTimeMillis();
		while((long)timestamps.get(begin) < now) begin++;
		return --begin;
	}
	
	private static ArrayList<String> getRequest(double lat, double lon) {
		ArrayList<String> requestLoc = new ArrayList<>();
		for (String request : REQUESTS_WINDY) {
			request = String.format(request, ""+lat, ""+lon);
			requestLoc.add(request);
		}
		return requestLoc;
	}

}
