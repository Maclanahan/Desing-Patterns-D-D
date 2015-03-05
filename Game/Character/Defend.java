package Character;

import java.util.Random;

public class Defend implements Action
{

	private Random rand = new Random();
	private int max = 5;
	@Override
	public void execute(GameCharacter $hero, GameCharacter $target) 
	{
		if($target != null)
			System.out.println($hero.getName() + " defends." );
		
	}
	
	@Override
	public int attacked(GameCharacter $hero) 
	{
		//System.out.println("In Defend");
		return $hero.getStats().getDefense() * 2;
	}

	@Override
	public int specialed(GameCharacter $hero) 
	{
		//System.out.println("In Defend");
		return $hero.getStats().getDefense() / 2;
	}


}
