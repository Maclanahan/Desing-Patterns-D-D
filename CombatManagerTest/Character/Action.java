package Character;

public interface Action 
{
	public void execute(PlayerCharacter $hero, PlayerCharacter $target);
	
	public void defend(PlayerCharacter $hero, PlayerCharacter $attacker);
}
