package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropFileReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String path = Iconstants.envPath;
		File file = new File(path);
		FileInputStream fis;
		Properties prop = new Properties();

		try {
			
			fis = new FileInputStream(file);
			prop.load(fis);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(prop.getProperty("platform"));
		
		
		
		
		
		
		
		
	}

}
