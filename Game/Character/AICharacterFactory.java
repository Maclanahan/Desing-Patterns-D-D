package Character;

import java.util.ArrayList;
import java.util.Random;

public class AICharacterFactory 
{
	private final int _maxNumOfEnemies;
	
	private StatsGenerator _statGen;
	
	private NameGenerator _nameGen;
	
	private AIBehaviorGenerator _AIGen;
	
	private Random _rand = new Random();
	
	public AICharacterFactory(int $maxNumOfEnemies)
	{
		_maxNumOfEnemies = $maxNumOfEnemies;
		
		_statGen = new StatsGenerator(_rand);
		
		_nameGen = new NameGenerator(_rand);
		
		_AIGen = new AIBehaviorGenerator(_rand);
	}
	
	public ArrayList<GameCharacter> getEnemies(int $level, int NumOfEnemies)
	{
		ArrayList<GameCharacter> enemies = new ArrayList<GameCharacter>();
		
		for(int i = 0; i < NumOfEnemies; i++)
		{
			enemies.add( new AICharacter( _nameGen.getName(), _statGen.getNewStats($level), _AIGen.getRandomAIBehavior() ) );
		}
		
		return enemies;
	}
}
