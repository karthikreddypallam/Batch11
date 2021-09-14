package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	String path = Iconstants.envPath;
	Properties prop = null;
	
	public void readConfig() {
		File file = new File(path);
		FileInputStream fis;
		prop = new Properties();

		try {
			fis = new FileInputStream(file);
			prop.load(fis);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getBrowser() {
		return prop.getProperty("browser");
	}
	
	public String getURL() {
		return prop.getProperty("url");
	}
	

}
