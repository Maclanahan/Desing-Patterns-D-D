package Character;

public class NoAction implements Action
{

	@Override
	public void execute(PlayerCharacter $hero, PlayerCharacter $target) 
	{
		
		
	}

	@Override
	public int attacked(PlayerCharacter $hero) 
	{
		//System.out.println("In No Action");
		//return $hero._stats.getDefense();
		return 0;
	}

	@Override
	public int specialed(PlayerCharacter $hero) 
	{
		//System.out.println("In No Action");
		//return $hero._stats.getDefense();
		return 0;
	}
}
