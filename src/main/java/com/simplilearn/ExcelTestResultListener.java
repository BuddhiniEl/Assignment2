package com.simplilearn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

public class ExcelTestResultListener implements IReporter {
	public void generateReport(
		      List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		ISuite suite = suites.get(0);
		Map<String, ISuiteResult> iSuiteResults = suite.getResults();

		ITestContext context = iSuiteResults.values().iterator().next().getTestContext();
		
		Map<String, String> resultMap  = new HashMap<String, String>();
		addResultsToMap(resultMap, context.getPassedTests(), "PASSED");
		addResultsToMap(resultMap, context.getFailedTests(), "FAILED");
		addResultsToMap(resultMap, context.getSkippedTests(), "SKIPPED");
		
		ExcelData excelData = new ExcelData();
		try {
			excelData.updateResults(resultMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addResultsToMap(Map<String, String> map, IResultMap results, String status) {

		Set<ITestResult> resultSet = results.getAllResults();
		for(ITestResult result:resultSet) {
			String searchKey = (String)result.getParameters()[0];
			map.put(searchKey, status);
		}
	}
}
