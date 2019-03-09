package BaseTest;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class TestNGListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		MainTest.test.log(Status.PASS, "Test Case Passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		MainTest.test.log(Status.FAIL, "Test Case Failed");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		MainTest.test.log(Status.SKIP, "Test Case skipped");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
