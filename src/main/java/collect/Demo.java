package collect;

import java.util.Calendar;

public class Demo {
	
	public static void main(String[] args) {
		DataHandlerImpl dataHandlerDemo = new DataHandlerImpl();
		
		//test of the API request methods, with Brest datas
		String icaoId = "LFRB";
		double hoursBeforeNow = 5.0 ;
		Calendar startDateTime = Calendar.getInstance();
		startDateTime.set(2021, 12, 15, 8, 30);
		Calendar endDateTime = Calendar.getInstance();
		endDateTime.set(2021, 12, 15, 11, 20);
		Calendar startTime = Calendar.getInstance();
		startTime.set(2021, 12, 15, 8, 30);
		Calendar endTime = Calendar.getInstance();
		endTime.set(2021, 12, 15, 11, 20);
		double hoursAfterNow = 5.0;
		double latitude = 48.366218 ;
		double longitude = -4.480615;
		int hours = 4;
		String cityId = "3030300";
		int timespan = 5;
		double maxlat = 48.380683;
		double maxlon = -4.406086;
		double minlat = 48.357358;
		double minlon = -4.553229;
		
		
		dataHandlerDemo.getMetarHoursBeforeNow(hoursBeforeNow, icaoId);
		
		dataHandlerDemo.getMetarStartTimeEndTime(startDateTime, endDateTime, icaoId);
		
		dataHandlerDemo.getTafHoursBeforeNow(hoursBeforeNow, icaoId);
		
		dataHandlerDemo.getTafStartTimeEndTime(startTime, endTime, icaoId);
		
		dataHandlerDemo.getTafHoursAfterNow(hoursAfterNow, icaoId);
		
		dataHandlerDemo.getWindyForecast();
		
		dataHandlerDemo.getWindyForecastLocation(latitude, longitude);
		
		dataHandlerDemo.getWindyForecastHoursAfterNow(latitude, longitude, hours);
		
		dataHandlerDemo.getOpenWeatherCurrent();
		
		dataHandlerDemo.getOpenWeatherCurrentLocation(cityId);
		
		dataHandlerDemo.getOpenWeatherForecast(cityId, hours);
		
		//dataHandlerDemo.getAISData(timespan, maxlat, maxlon, minlat, minlon);
		
				
	}

}
