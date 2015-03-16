package Character;

import application.AnimationManager;

public interface Action 
{
	public void execute(GameCharacter $hero, GameCharacter $target, AnimationManager $animator);
	
	public int attacked(GameCharacter $hero);
	
	public int specialed(GameCharacter $hero);
}
