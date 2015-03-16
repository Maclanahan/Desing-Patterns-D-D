package Character;

import java.util.Random;

public class StatsGenerator 
{
	private Random rand;
	
	public StatsGenerator(Random $rand)
	{
		rand = $rand;
	}
	
	public BaseStats getNewStats(int $level)
	{
		int poolOfTotalStats = 4 * (4 + $level);
		
		int[] stats = new int[5];
		
		for(int i = 0; i < 5; i++)
		{	
			if(i < 4)
			{
				int singleStat = Math.abs(rand.nextInt() % (poolOfTotalStats / 3 ));
				
				stats[i] = singleStat + $level + 1;
				
				poolOfTotalStats -= singleStat;
			}
			
			else
				stats[i] = poolOfTotalStats;
			
		}
		
		return new BaseStats(stats[0], stats[1], stats[2], stats[3], stats[4]);
	}
	
	
}
