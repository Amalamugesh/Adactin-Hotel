package org.adactin;

import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class AdactinJunitreport {
	
	public static void main(String[] args) {
		
		Result r = JUnitCore.runClasses(AdactinJunit.class);
		
		int failureCount = r.getFailureCount();
		int runCount = r.getRunCount();
		System.out.println("runcount "+ runCount);
		long runTime = r.getRunTime();
		System.out.println("Run Time "+runTime);
		int passcount = runCount-failureCount;
		System.out.println("pass Count "+passcount);
		List<Failure> failures = r.getFailures();
		for (Failure failure : failures) {
			
			System.out.println(failure);
			
		}
	}

}
