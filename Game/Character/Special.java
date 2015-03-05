package Character;

import java.util.Random;

public class Special implements Action
{
	private Random rand = new Random();
	private int max = 5;
	@Override
	public void execute(GameCharacter $hero, GameCharacter $target) 
	{
		if($target != null)
		{
			
			int damage = $hero.getStats().getStrength() - $target.attacked();
			damage += rand.nextInt() % (max + 1);
			
			if(damage > 0)
			{
				$target.takeDamage(damage);
				System.out.println($hero.getName() + " does a special attack against " + $target.getName() 
						+ " and does " + damage + " points of damage.");
			}
			else
				System.out.println($hero.getName() + " does a special attack against " + $target.getName() + " and misses."); 
		}
	}
	
	@Override
	public int attacked(GameCharacter $hero) 
	{
		//System.out.println("In Special");
		return $hero.getStats().getDefense() / 2;
	}

	@Override
	public int specialed(GameCharacter $hero) 
	{
		//System.out.println("In Special");
		return $hero.getStats().getDefense();
	}

}
