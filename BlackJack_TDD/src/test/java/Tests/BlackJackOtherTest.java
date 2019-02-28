package Tests;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import BlackJack.BlackJack;

public class BlackJackOtherTest 
{
	
	BlackJack blackJack;
	
	@Before
	public void setup()
	{
		blackJack = new BlackJack();
	}
	
	@Test
	public void bothBustTest()
	{
		assertEquals("Incorrect Output", 0, blackJack.winner(25,30));
	}
	
	@Test
	public void invalidInputTest()
	{
		assertEquals("Incorrect Output", -1, blackJack.winner(2,43));
	}


}
