package Character;

import java.util.ArrayList;
import java.util.Random;

public class NameGenerator 
{
	Random _rand;
	
	ArrayList<String> _names;

	public NameGenerator(Random $rand) 
	{
		_rand = $rand;
		
		_names = new ArrayList<String>();
		
		setUpNamesInList();
	}

	private void setUpNamesInList() 
	{
		_names.add("Spider");
		_names.add("Scorpion");
		_names.add("Troll");
		_names.add("Goblin");
		_names.add("Imp");
		_names.add("Gloop");
		_names.add("Gryphon");
		_names.add("Wolf");
		_names.add("Evil Wizard");
		_names.add("Sand Person");
	}
	
	public String getName()
	{		
		return _names.get( Math.abs(_rand.nextInt() % _names.size()));
	}

}
