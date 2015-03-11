package Character;

import java.util.ArrayList;
import java.util.Random;

public class AIBehaviorGenerator 
{
	Random _rand;
	ArrayList<AIBehavior> _behaviors;
	
	public AIBehaviorGenerator(Random $rand) 
	{
		_rand = $rand;
		
		initializeAIBehaviors();
	}

	private void initializeAIBehaviors() 
	{
		_behaviors = new ArrayList<AIBehavior>();
		
		_behaviors.add(new AIRandomAttackBehavior());
	}
	
	public AIBehavior getRandomAIBehavior()
	{
		return _behaviors.get( Math.abs(_rand.nextInt() % _behaviors.size() ));
	}
	
}
