package Map;

public class Player 
{
	private int _row, _col;
	
	public Player(Floor floor)
	{
		int i, j, x = 0, y = 0;
		char[][] layout = floor.getFloor();
		
		for ( i=0; i<layout.length; i++)
			for ( j=0; j<layout[0].length; j++)
				if ( layout[i][j] == 'S')
				{	
					x = i;
					y = j;
				}
		
		_row = x;
		_col = y;
	}
	
	public void setRow(int row)
	{
		_row = row;
	}
	
	public void setCol(int col)
	{
		_col = col;
	}
	
	public int getRow()
	{
		return _row;
	}
	
	public int getCol()
	{
		return _col;
	}
}
