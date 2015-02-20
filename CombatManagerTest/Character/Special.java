package Character;

import java.util.Random;

public class Special implements Action
{
	private Random rand = new Random();
	private int max = 5;
	@Override
	public void execute(PlayerCharacter $hero, PlayerCharacter $target) 
	{
		if($target != null)
		{
			
			int damage = $hero._stats.getStrength() - $target.attacked();
			damage += rand.nextInt() % (max + 1);
			
			if(damage > 0)
			{
				$target.takeDamage(damage);
				System.out.println($hero._name + " does a special attack against " + $target._name 
						+ " and does " + damage + " points of damage.");
			}
			else
				System.out.println($hero._name + " does a special attack against " + $target._name + " and misses."); 
		}
	}
	
	@Override
	public int attacked(PlayerCharacter $hero) 
	{
		return $hero._stats.getDefense() / 2;
	}

	@Override
	public int specialed(PlayerCharacter $hero) 
	{
		return $hero._stats.getDefense();
	}

}
