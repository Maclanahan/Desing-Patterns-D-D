package Character;

public class Special implements Action
{
	@Override
	public void execute(PlayerCharacter $hero, PlayerCharacter $target) 
	{
		if($target != null)
		System.out.println($hero._name + " does a special thing to " + $target._name);
		
	}

	@Override
	public void defend(PlayerCharacter $hero, PlayerCharacter $target) 
	{
		// TODO Auto-generated method stub
		
	}

}
