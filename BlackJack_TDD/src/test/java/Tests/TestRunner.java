package Tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestRunner 
{
	public static void main(String[] args)
	{
		TestRunner runner = new TestRunner();
		
		String input = "other";
		
		if(input.equals("player"))
		{
			runner.playerTests();
		}
		else if(input.equals("dealer"))
		{
			runner.dealerTests();
		}
		else if(input.equals("other"))
		{
			runner.otherTests();
		}		
	}


	private void playerTests() {
		Result result = JUnitCore.runClasses(BlackJackPlayerTest.class);
		System.out.println("All results passed: " +result.wasSuccessful());
		
		if(!result.wasSuccessful())
		{
			System.out.println("Failed Tests: ");
			for(Failure failure: result.getFailures()) 
			{
				System.out.println(failure.getMessage());
			}
		}
	}

	private void dealerTests() {
		Result result = JUnitCore.runClasses(BlackJackDealerTest.class);
		System.out.println("All result passed: " +result.wasSuccessful());
		
		if(!result.wasSuccessful())
		{
			System.out.println("Failed Tests: ");
			for(Failure failure: result.getFailures()) 
			{
				System.out.println(failure.getMessage());
			}
		}
	}
	
	private void otherTests() 
	{
		Result result = JUnitCore.runClasses(BlackJackOtherTest.class);
		System.out.println("All results passed: " +result.wasSuccessful());
		
		if(!result.wasSuccessful())
		{
			System.out.println("Failed Tests: ");
			for(Failure failure: result.getFailures()) 
			{
				System.out.println(failure.getMessage());
			}
		}
	}

}
