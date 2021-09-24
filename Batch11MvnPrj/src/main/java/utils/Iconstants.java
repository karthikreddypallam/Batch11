package utils;

public interface Iconstants {
	
	String userDir = System.getProperty("user.dir");
	String chromeDriverPath = userDir+"/src/main/resources/drivers/mac/chromedriver";
	String firefoxDriverPath = userDir+"/src/main/resources/drivers/mac/geckodriver";
	String ieDriverPath = userDir+"/src/main/resources/drivers/windows/iedriver.exe";
	String edgeDriverPath = userDir+"/src/main/resources/drivers/mac/msdriver.exe";

	String envPath = userDir+"/src/test/resources/env.properties";

}
