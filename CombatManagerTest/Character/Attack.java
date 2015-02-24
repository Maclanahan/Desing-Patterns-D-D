package Character;

import java.util.Random;

public class Attack implements Action
{
	private Random rand = new Random();
	private int max = 5;
	@Override
	public void execute(PlayerCharacter $hero, PlayerCharacter $target) 
	{
		if($target != null)
		{
			//System.out.println($hero._name + " attacks " + $target._name);
			int damage = $hero._stats.getStrength() - $target.attacked();
			damage += rand.nextInt() % (max + 1);
			
			if(damage > 0)
			{
				$target.takeDamage(damage);
				System.out.println($hero._name + " attacks " + $target._name + " and does " + damage + " points of damage.");
			}
			else
				System.out.println($hero._name + " attacks " + $target._name + " and missed.");
		}
	}
	
	@Override
	public int attacked(PlayerCharacter $hero) 
	{
		//System.out.println("In Action");
		return $hero._stats.getDefense();
	}

	@Override
	public int specialed(PlayerCharacter $hero) 
	{
		//System.out.println("In Action");
		return $hero._stats.getDefense();
	}

	
}
