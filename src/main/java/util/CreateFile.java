package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONObject;

public class CreateFile {

	//Here are the methods used to create JSON files, JPG files and directories for the photos
	
	public static void createJSON(String path, String type, JSONObject data) {
		try {
			createPath(path);
			String filename = path + type + "_" + new SimpleDateFormat("yyyyMMdd_HHmmss_SSS").format(new Date()) +".json";
			FileWriter file = new FileWriter(filename);
			file.write(data.toString(2));
			file.flush();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SecurityException s) {
			s.printStackTrace();
		}
	}

	public static void createPhoto(String path, String mmsi, InputStream photo) {
		try {
			createPath(path+"photos/");
			String filename = path + "photos/" + mmsi + "_" + new SimpleDateFormat("yyyyMMdd_HHmmss_SSS").format(new Date()) +".jpg";
			Files.copy(photo, Paths.get(filename));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SecurityException s) {
			s.printStackTrace();
		}
	}
	
	protected static void createPath(String path) throws SecurityException {
		File directory = new File(path);
		if(!directory.exists())
			directory.mkdirs();
	}

}
