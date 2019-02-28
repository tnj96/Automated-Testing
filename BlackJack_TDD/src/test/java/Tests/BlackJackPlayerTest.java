package Tests;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import BlackJack.BlackJack;

public class BlackJackPlayerTest 
{
	BlackJack blackJack;
	
	@Before
	public void setup()
	{
		blackJack = new BlackJack();
	}
	
	@Test
	public void playerBustTest()
	{
		assertEquals("Incorrect Output", 20, blackJack.winner(29, 20));
	}
		
	@Test
	public void playerWinsTest()
	{
		assertEquals("Incorrect Output", 20, blackJack.winner(20, 9));
	}
	
}
