package Character;

public class NoAction implements Action
{

	@Override
	public void execute(PlayerCharacter $hero, PlayerCharacter $target) 
	{
		
		
	}

	@Override
	public void defend(PlayerCharacter $hero, PlayerCharacter $target) 
	{
		System.out.println($target._name + " does a normal amount of damage to " + $hero._name);
		
	}


}
