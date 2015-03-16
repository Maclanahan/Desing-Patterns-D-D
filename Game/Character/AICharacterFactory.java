package Character;

import java.util.ArrayList;
import java.util.Random;

import application.AnimationManager;

public class AICharacterFactory 
{
	private final int _maxNumOfEnemies;
	
	private StatsGenerator _statGen;
	
	private NameGenerator _nameGen;
	
	private AIBehaviorGenerator _AIGen;
	
	private Random _rand = new Random();
	
	private AnimationManager _animator;
	
	public AICharacterFactory(int $maxNumOfEnemies, AnimationManager $animator)
	{
		_maxNumOfEnemies = $maxNumOfEnemies;
		
		_statGen = new StatsGenerator(_rand);
		
		_nameGen = new NameGenerator(_rand);
		
		_AIGen = new AIBehaviorGenerator(_rand);
		
		_animator = $animator;
	}
	
	public ArrayList<GameCharacter> getEnemies(int $level)
	{
		if($level < 50)
			return minorEnemies($level);
		
		else
			return bossEnemy($level);
		
	}
	
	private ArrayList<GameCharacter> bossEnemy(int $level) 
	{
		ArrayList<GameCharacter> enemies = new ArrayList<GameCharacter>();
		
		enemies.add( new AICharacter( "STUpendus Dragon", _statGen.getNewStats($level), _AIGen.getRandomAIBehavior(), _animator ) );
		
		return enemies;
	}

	private ArrayList<GameCharacter> minorEnemies(int $level)
	{
		ArrayList<GameCharacter> enemies = new ArrayList<GameCharacter>();
		
		int numOfEnemies = Math.abs(_rand.nextInt() % _maxNumOfEnemies + $level);
		
		if(numOfEnemies < 4)
			numOfEnemies++;
		
		for(int i = 0; i < numOfEnemies; i++)
		{
			enemies.add( new AICharacter( _nameGen.getName(), _statGen.getNewStats($level), _AIGen.getRandomAIBehavior(), _animator ) );
		}
		
		return enemies;
	}
}
