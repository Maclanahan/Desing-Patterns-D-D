package Map;

import java.util.Random;

public class DungeonFactory 
{
		private Floor[] _floors;
		
		public DungeonFactory()
		{
			_floors = createDungeon();
		}
		
		public Floor[] createDungeon()
		{
			int i, j, num, type;
			Floor[] floors = new Floor[3];
			Random rdm = new Random();
		  
			for ( num=0; num<floors.length; num++)
			{
				i = rdm.nextInt(3)+3;
				j = rdm.nextInt(3)+3;
		   
				if(num == 0)
					type = 0; // starting floor
				else if ( num == floors.length-1)
					type = 1; // boss floor
				else
					type = 2; // other floor
			  
				floors[num] = new Floor(i,j,type);
			  
			}
			
			return floors;
		}
		
		public Floor[] getFloors()
		{
			return _floors;
		}
		
}
