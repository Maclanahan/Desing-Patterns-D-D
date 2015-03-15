package Map;

import java.util.Random;

public class Tile
{
	private String _name;
	
	public Tile(char c, int level)
	{
		int num;
		Random rdm = new Random();
		
		num = rdm.nextInt(100);
		
		if ( level == 1 )
		{
			if (c == 'X')
			{
				if ( num < 1)
					_name = "Map/Wall1Type3.png";
				else if ( num < 10)
					_name = "Map/Wall1Type2.png";
				else
					_name = "Map/Wall1Type1.png";
			}
			else if (c == 'T')
				_name = "Map/Treasure1Closed.png";
			else if (c == 'O')
				_name = "Map/Treasure1Open.png";
			else
			{
				if ( num < 10)
					_name = "Map/Ground1Type2.png";
				else
					_name = "Map/Ground1Type1.png";
			}
		}
		else if ( level == 2 )
		{
			if (c == 'X')
			{
				if ( num < 1)
					_name = "Map/Wall2Type3.png";
				else if ( num < 10)
					_name = "Map/Wall2Type2.png";
				else
					_name = "Map/Wall2Type1.png";
			}
			else if (c == 'T')
				_name = "Map/Treasure2Closed.png";
			else if (c == 'O')
				_name = "Map/Treasure2Open.png";
			else
			{
				if ( num < 10)
					_name = "Map/Ground2Type2.png";
				else
					_name = "Map/Ground2Type1.png";
			}
		}
		else
		{
			if (c == 'X')
			{
				if ( num < 1)
					_name = "Map/Wall3Type3.png";
				else if ( num < 10)
					_name = "Map/Wall3Type2.png";
				else
					_name = "Map/Wall3Type1.png";
			}
			else if (c == 'T')
				_name = "Map/Treasure3Closed.png";
			else if (c == 'O')
				_name = "Map/Treasure3Open.png";
			else
			{
				if ( num < 10)
					_name = "Map/Ground3Type2.png";
				else
					_name = "Map/Ground3Type1.png";
			}
		}
		
		if (c == 'E')
			_name = "Map/Stairs.png";
		
		if (c == 'B')
			_name = "Map/Boss.png";
		
	}
	
	public String getName()
	{
		return _name;
	}
	
}
