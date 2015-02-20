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
		return $hero._stats.getDefense();
	}

	@Override
	public int specialed(PlayerCharacter $hero) 
	{
		return $hero._stats.getDefense();
	}
}
