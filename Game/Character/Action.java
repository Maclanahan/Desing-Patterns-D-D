package Character;

public interface Action 
{
	public void execute(GameCharacter $hero, GameCharacter $target);
	
	public int attacked(GameCharacter $hero);
	
	public int specialed(GameCharacter $hero);
}
