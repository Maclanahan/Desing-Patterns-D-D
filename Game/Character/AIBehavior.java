package Character;

import Combat.AISelector;

public interface AIBehavior 
{	
	public void execute(GameCharacter $char, AISelector $select);
}
