package Character;

import Combat.AISelector;
import application.AnimationManager;

public class AIRandomSpecialBehavior implements AIBehavior
{

	@Override
	public void execute(GameCharacter $char, AISelector $select,
			AnimationManager $animator) 
	{
		$char.setActionToSpecial();
		
		$char.getAction().execute($char, $select.getRandomHero(), $animator);
		
	}

}
