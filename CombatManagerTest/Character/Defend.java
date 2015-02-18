package Character;

public class Defend implements Action
{

	@Override
	public void execute(PlayerCharacter $hero, PlayerCharacter $target) 
	{
		//if($target != null)
		System.out.println($hero._name + " defends");
		
	}

	@Override
	public void defend(PlayerCharacter $hero, PlayerCharacter $target) 
	{
		// TODO Auto-generated method stub
		
	}


}
