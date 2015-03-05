package Character;

import Combat.AISelector;

public class AIRandomAttackBehavior implements AIBehavior
{
	@Override
	public void execute(GameCharacter $char, AISelector $select) 
	{
		$char.setActionToAttack();
		
		$char.getAction().execute($char, $select.getRandomHero());
	}
	
	
}
