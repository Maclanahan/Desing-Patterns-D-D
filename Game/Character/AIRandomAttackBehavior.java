package Character;

import application.AnimationManager;
import Combat.AISelector;

public class AIRandomAttackBehavior implements AIBehavior
{
	@Override
	public void execute(GameCharacter $char, AISelector $select, AnimationManager $animator) 
	{
		$char.setActionToAttack();
		
		$char.getAction().execute($char, $select.getRandomHero(), $animator);
	}
	
	
}
