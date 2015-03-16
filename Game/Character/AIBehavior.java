package Character;

import application.AnimationManager;
import Combat.AISelector;

public interface AIBehavior 
{	
	public void execute(GameCharacter $char, AISelector $select, AnimationManager $animator);
}
