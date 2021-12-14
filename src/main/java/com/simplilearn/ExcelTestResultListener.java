package com.simplilearn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

public class ExcelTestResultListener implements IReporter {
	public void generateReport(
		      List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		ISuite suite = suites.get(0);
		Map<String, ISuiteResult> iSuiteResults = suite.getResults();

		ISuiteResult suiteResult =  iSuiteResults.values().iterator().next();
		IResultMap passedTests = suiteResult.getTestContext().getPassedTests();
		Set<ITestResult> resultSet = passedTests.getAllResults();
		
		Map<String, String> resultMap  = new HashMap<String, String>();
		
		for(ITestResult result:resultSet) {
			String testResult = "";
			if(result.isSuccess()) {
				testResult = "PASS";
			} else {
				testResult = "FAIL";
			}
			String searchKey = (String)result.getParameters()[0];
			resultMap.put(searchKey, testResult);
			System.out.println(searchKey + ", " + testResult);
		}
	}
}
