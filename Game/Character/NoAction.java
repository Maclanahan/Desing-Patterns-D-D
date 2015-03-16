package Character;

import application.AnimationManager;

public class NoAction implements Action
{

	@Override
	public void execute(GameCharacter $hero, GameCharacter $target, AnimationManager $animator) 
	{
		
		
	}

	@Override
	public int attacked(GameCharacter $hero) 
	{
		//System.out.println("In No Action");
		//return $hero._stats.getDefense();
		return 0;
	}

	@Override
	public int specialed(GameCharacter $hero) 
	{
		//System.out.println("In No Action");
		//return $hero._stats.getDefense();
		return 0;
	}
}
