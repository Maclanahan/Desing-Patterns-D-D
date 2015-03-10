package Combat;

import java.util.ArrayList;
import java.util.Random;

import Character.AICharacter;
import Character.BaseStats;
import Character.GameCharacter;
import Character.PlayerCharacter;

public class AISelector 
{
	private ArrayList<GameCharacter> _heros;
	private ArrayList<GameCharacter> _enemies;
	private Random _rand = new Random();
	
	public AISelector(ArrayList<GameCharacter> $heros, ArrayList<GameCharacter>$enemies)
	{
		_heros = makeShallowCopy($heros);
		_enemies = makeShallowCopy($enemies);
	}
	
	private ArrayList<GameCharacter> makeShallowCopy(ArrayList<GameCharacter> $group)
	{
		ArrayList<GameCharacter> list = new ArrayList<GameCharacter>();
		
		for(GameCharacter gc : $group)
			list.add(gc);
		
		return list;
	}
	
	public GameCharacter getRandomHero()
	{
		boolean isValidTarget = false;
		GameCharacter temp = new AICharacter("nothing", new BaseStats(0,0,0,0,0), null);
		
		while(isValidTarget == false && _heros.size() > 0)
		{
			int num = Math.abs( _rand.nextInt() % (_heros.size()) );
		
			temp = _heros.get(num);
			
			if(temp.getCurrentHealth() == 0)
				_heros.remove(num);
			
			if(temp.getCurrentHealth() != 0)
				break;
		}
		
		return temp;
		
	}
}
