package util;

import java.util.ArrayList;
import java.util.Arrays;

public class Constants {

	//Here are all the link and api key to access the APIs
	
	public static final String SERVER_URL_WINDY = "https://api.windy.com/api/point-forecast/v2";
	public static final ArrayList<String> REQUESTS_WINDY = new ArrayList<>(Arrays.asList(
			"{\"lat\": %s, \"lon\": %s, \"model\": \"gfs\","
					+ "\"parameters\": [\"temp\", \"precip\", \"wind\", \"windGust\", \"ptype\"],"
					+ "\"levels\": [\"surface\", \"800h\", \"300h\"],\"key\": \"z56bdESVSkOWRXkKSEkQYwKmBgvjKinm\"}",
			"{\"lat\": %s,\"lon\": %s, \"model\": \"gfsWave\","
					+ "\"parameters\": [\"waves\", \"windWaves\"],"
					+ "\"levels\": [\"surface\", \"800h\", \"300h\"],\"key\": \"z56bdESVSkOWRXkKSEkQYwKmBgvjKinm\"}"));
	public static final String SERVER_URL_AVWX = "https://avwx.rest/api/metar/LFRB";
	
	public static final String SERVER_URL_OW ="https://api.openweathermap.org/data/2.5/%s?id=%s&units=metric&appid=e84220537668db850e3540c2cbc4fe78";
	
	public static final String SERVER_URL_NOAA_METAR = "https://aviationweather.gov/adds/dataserver_current/httpparam?"
	+ "dataSource=metars&requestType=retrieve&format=xml&";	
	
	public static final String SERVER_URL_NOAA_TAF = "https://aviationweather.gov/adds/dataserver_current/httpparam?"
	+ "dataSource=tafs&requestType=retrieve&format=xml&";	
	
	public static final String OUTPUT_PATH = "./output/";
	
	public static final String SERVER_URL_MARINETRAFFIC = "https://services.marinetraffic.com/api/exportvessels/";
	
	public static final String MARINETRAFFIC_KEY1 = "7698ca66d410cbd80ccc41ec1f908dbda94a6586";
	
	public static final String MARINETRAFFIC_KEY2 = "57c39917c87215abceca5f002f69b93c6280497d";

	public static final String MARINETRAFFIC_KEY3 = "3f035226751d53e8ea8509eee0851ec471d11dfb";

	public static final String MARINETRAFFIC_KEY4 = "2e7d2130a2923efe5299e856f61b9e657aafeabc";
	
	public static final String MARINETRAFFIC_KEY5 = "b34137d063215474a13de005935deb46e0e896c7";
	
	public static final String MARINETRAFFIC_KEY6 = "ea02416a37aac6c81c3172c1815a31bb875bfe8a";
	
	public static final String SERVER_URL_MARINETRAFFIC_PHOTO = "https://services.marinetraffic.com/api/exportvesselphoto/";
	
	public static final String MARINETRAFFIC_KEYPHOTO1 = "335f5640429d5489efdf047d6a0daabd032fd1bc";
	
	public static final String MARINETRAFFIC_KEYPHOTO2 = "504a75acd5c0e6020561f154342e52e4bb474bd0";
	
	public static final String MARINETRAFFIC_KEYPHOTO3 = "8820500a2b270ffa02be9e6a17078e6dc25aae68";
	
	public static final String MARINETRAFFIC_KEYPHOTO4 = "53a64729364ac828a0bfc8377e0b68386c5c8413";
	
	public static final String MARINETRAFFIC_KEYPHOTO5 = "8d362de06eec40bd3a98c6fc084a051ba024879a";
	
	public static final String MARINETRAFFIC_KEYPHOTO6 = "d98b006fd42b3940cf74e779d0602c1449c4fe57";
}
