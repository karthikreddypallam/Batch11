package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
	
	
	int retryCounter = 0;
	int maxTry = 2;

	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(retryCounter<maxTry) {
			retryCounter++;
			return true;
		}
		return false;
	}

}
