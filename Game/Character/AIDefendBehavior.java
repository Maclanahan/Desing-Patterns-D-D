package Character;

import Combat.AISelector;
import application.AnimationManager;

public class AIDefendBehavior implements AIBehavior
{

	@Override
	public void execute(GameCharacter $char, AISelector $select,
			AnimationManager $animator) 
	{
		$char.setActionToDefend();
		$char.getAction().execute($char, null, $animator);
	}

}
