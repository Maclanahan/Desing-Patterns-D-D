package Character;

import java.util.Random;

public class Defend implements Action
{

	private Random rand = new Random();
	private int max = 5;
	@Override
	public void execute(PlayerCharacter $hero, PlayerCharacter $target) 
	{
		if($target != null)
			System.out.println($hero._name + " defends." );
		
	}
	
	@Override
	public int attacked(PlayerCharacter $hero) 
	{
		return $hero._stats.getDefense() * 2;
	}

	@Override
	public int specialed(PlayerCharacter $hero) 
	{
		return $hero._stats.getDefense() / 2;
	}


}
