package Tests;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import BlackJack.BlackJack;

public class BlackJackDealerTest 
{
	BlackJack blackJack;
	
	@Before
	public void setup()
	{
		blackJack = new BlackJack();
	}
	
	@Test
	public void dealerBustTest()
	{
		assertEquals("Incorrect Output", 19 , blackJack.winner(19, 30));
	}
	
	@Test
	public void dealerWinsTest()
	{
		assertEquals("Incorrect Output", 18, blackJack.winner(5, 18));
	}

}
