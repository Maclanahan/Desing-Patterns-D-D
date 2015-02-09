package Character;

import java.util.ArrayList;

import Item.Item;

public class PlayerCharacter 
{
	public String _name;
	protected Stats _stats;
	protected CharacterInventory _items;
	protected Attack _atk;
	protected Defend _dfn;
	protected Special _Spcl;
	
	public PlayerCharacter(String $name)
	{
		_name = $name;
		setStats();
	}

	private void setStats() 
	{
		_stats = new Stats();
		
	}
}
