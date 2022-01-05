package collect;

import java.util.ArrayList;
import java.util.Calendar;

import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
public class TestDataHandlerImpl {

	DataHandlerImpl dataHandlerImpl = new DataHandlerImpl();
	String[] icaoIds = new String[] { "PHTO", "KDEN" };
	Calendar startTime = Calendar.getInstance();
	Calendar endTime = Calendar.getInstance();

	@Test
	public void testGetMetarHoursBeforeNow() {
		JSONObject res = dataHandlerImpl.getMetarHoursBeforeNow(1.0, icaoIds);
		ArrayList<String> keys = new ArrayList<String>(res.keySet());
		Assertions.assertTrue(keys.contains("Metar"));
		Assertions.assertEquals("JSONArray", res.get("Metar").getClass().getSimpleName());
	}

	@Test
	public void testGetMetarStartTimeEndTime() {
		startTime.set(2021, 11, 22, 15, 44, 55);
		endTime.set(2021, 11, 22, 17, 44, 55);
		JSONObject res = dataHandlerImpl.getMetarStartTimeEndTime(startTime, endTime, icaoIds);
		ArrayList<String> keys = new ArrayList<String>(res.keySet());
		Assertions.assertTrue(keys.contains("Metar"));
		Assertions.assertEquals("JSONArray", res.get("Metar").getClass().getSimpleName());
	}

	@Test
	public void testGetTafHoursBeforeNow() {
		JSONObject res = dataHandlerImpl.getTafHoursBeforeNow(3.0, icaoIds);
		ArrayList<String> keys = new ArrayList<String>(res.keySet());
		Assertions.assertTrue(keys.contains("TAF"));
		Assertions.assertEquals("JSONArray", res.get("TAF").getClass().getSimpleName());
	}

	@Test
	public void testGetTafStartTimeEndTime() {
		startTime.set(2021, 11, 22, 16, 51, 28);
		endTime.set(2021, 11, 22, 17, 51, 28);
		JSONObject res = dataHandlerImpl.getTafStartTimeEndTime(startTime, endTime, icaoIds);
		ArrayList<String> keys = new ArrayList<String>(res.keySet());
		Assertions.assertTrue(keys.contains("TAF"));
		Assertions.assertEquals("JSONArray", res.get("TAF").getClass().getSimpleName());
	}

	@Test
	public void testGetTafHoursAfterNow() {
		JSONObject res = dataHandlerImpl.getTafHoursAfterNow(1.5, icaoIds);
		ArrayList<String> keys = new ArrayList<String>(res.keySet());
		Assertions.assertTrue(keys.contains("TAF"));
		Assertions.assertEquals("JSONArray", res.get("TAF").getClass().getSimpleName());
	}

	@Test
	public void testGetWindyForecast() {
		JSONObject res = dataHandlerImpl.getWindyForecast();
		ArrayList<String> keys = new ArrayList<String>(res.keySet());
		Assertions.assertTrue(keys.contains("gfsWave"));
		Assertions.assertTrue(keys.contains("gfs"));
		Assertions.assertEquals("JSONObject", res.get("gfsWave").getClass().getSimpleName());
		Assertions.assertEquals("JSONObject", res.get("gfs").getClass().getSimpleName());
	}

	@Test
	public void testGetWindyForecastLocation() {
		JSONObject res = dataHandlerImpl.getWindyForecastLocation(48.4, -4.48);
		ArrayList<String> keys = new ArrayList<String>(res.keySet());
		Assertions.assertTrue(keys.contains("gfsWave"));
		Assertions.assertTrue(keys.contains("gfs"));
		Assertions.assertEquals("JSONObject", res.get("gfsWave").getClass().getSimpleName());
		Assertions.assertEquals("JSONObject", res.get("gfs").getClass().getSimpleName());
	}

	@Test
	public void testGetWindyForecastHoursAfterNow() {
		JSONObject res = dataHandlerImpl.getWindyForecastHoursAfterNow(48.4, -4.48, 24);
		ArrayList<String> keys = new ArrayList<String>(res.keySet());
		Assertions.assertTrue(keys.contains("gfsWave"));
		Assertions.assertTrue(keys.contains("gfs"));
		Assertions.assertEquals("JSONObject", res.get("gfsWave").getClass().getSimpleName());
		Assertions.assertEquals("JSONObject", res.get("gfs").getClass().getSimpleName());
	}

	@Test
	public void testGetOpenWeatherCurrent() {
		JSONObject res = dataHandlerImpl.getOpenWeatherCurrent();
		ArrayList<String> keys = new ArrayList<String>(res.keySet());
		Assertions.assertFalse(keys.contains("list"));
	}

	@Test
	public void testGetOpenWeatherCurrentLocation() {
		JSONObject res = dataHandlerImpl.getOpenWeatherCurrentLocation("3030300");
		Assertions.assertEquals(res, res);
		ArrayList<String> keys = new ArrayList<String>(res.keySet());
		Assertions.assertFalse(keys.contains("list"));
	}

	@Test
	public void testGetOpenWeatherForecast() {
		JSONObject res = dataHandlerImpl.getOpenWeatherForecast("3030300", 24);
		Assertions.assertEquals(res, res);
		ArrayList<String> keys = new ArrayList<String>(res.keySet());
		Assertions.assertTrue(keys.contains("forecast"));
		Assertions.assertEquals("JSONArray", res.get("forecast").getClass().getSimpleName());
	}

}
