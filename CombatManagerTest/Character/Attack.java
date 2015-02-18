package Character;

public class Attack implements Action
{

	@Override
	public void execute(PlayerCharacter $hero, PlayerCharacter $target) 
	{
		if($target != null)
		System.out.println($hero._name + " attacks " + $target._name);
		
	}

	@Override
	public void defend(PlayerCharacter $hero, PlayerCharacter $target) 
	{
		System.out.println($target._name + " does a normal amount of damage to " + $hero._name);
		
	}

	
}
