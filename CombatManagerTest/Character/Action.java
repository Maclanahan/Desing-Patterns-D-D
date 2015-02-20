package Character;

public interface Action 
{
	public void execute(PlayerCharacter $hero, PlayerCharacter $target);
	
	public int attacked(PlayerCharacter $hero);
	
	public int specialed(PlayerCharacter $hero);
}
