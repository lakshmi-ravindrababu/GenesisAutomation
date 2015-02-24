package utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.testng.ISuiteListener;
import org.testng.ISuite;
import org.testng.ISuiteResult;

import utility.MailReport;



public class TestResultListener implements  ISuiteListener {
	
	public void onStart(ISuite suite)
	{
		
	}

	/*On Test Suite Finish get the test date,test results and store it into variables
	 * Initiate sendMail*/
	public void onFinish(ISuite suite)
	{
	   try{	
		   
	   Map<String, ISuiteResult> suiteresult = suite.getResults(); 	 
	   for(ISuiteResult r : suiteresult.values())
	    {
	   Date date = r.getTestContext().getEndDate();
	   SimpleDateFormat formatter =new SimpleDateFormat("yyyy-MM-dd");
	   String formats1 = formatter.format(date);

	   DataValues.testDate = formats1;	   
	   DataValues.testFailCount = r.getTestContext().getFailedTests().size();
	   DataValues.testPassCount =r.getTestContext().getPassedTests().size();
	   DataValues.testSkipCount = r.getTestContext().getSkippedTests().size();
	   DataValues.totalTests =  DataValues.testFailCount + DataValues.testPassCount + DataValues.testSkipCount;
	    }
		   
	   MailReport.execute("Genesis Test.pdf");
	   
	   }catch(Exception E){
		   E.printStackTrace();
	   }
	}
}
