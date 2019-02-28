package BlackJack;

public class BlackJack {
	
	
	
	public static void main (String [] args)
	{
		
	} 
	

	public int winner(int player, int dealer) {
		
		int winner = -1;
					
		if(player >= 22 && player <=31 && dealer >=4 && dealer <= 21) 
		{
			winner = dealer;
		}
		else if(player >= 4 && player <= 22 && dealer >=22 && dealer <= 31)
		{
			winner =  player;
		}
		else if(player >= 4 && player <= 22 && dealer >=4 && dealer <= 21 && player > dealer)
		{
			winner =  player;
		}
		else if(player >= 4 && player <= 22 && dealer >=4 && dealer <= 21 && player < dealer)
		{
			winner = dealer;
		}
		else if(player >= 22 && player <=31 && dealer >=22 && dealer <= 31) 
		{
			winner =  0;
		}
		return winner;
		
	}
	
	

}
