package Character;

import java.util.Random;

public class Attack implements Action
{
	private Random rand = new Random();
	private int max = 5;
	@Override
	public void execute(GameCharacter $hero, GameCharacter $target) 
	{
		if($target != null)
		{
			//System.out.println($hero._name + " attacks " + $target._name);
			int damage = $hero.getStats().getStrength() - $target.attacked();
			damage += rand.nextInt() % (max + 1);
			
			if(damage > 0)
			{
				$target.takeDamage(damage);
				System.out.println($hero.getName() + " attacks " + $target.getName() + " and does " + damage + " points of damage.");
			}
			else
				System.out.println($hero.getName() + " attacks " + $target.getName() + " and missed.");
		}
	}
	
	@Override
	public int attacked(GameCharacter $hero) 
	{
		//System.out.println("In Action");
		return $hero.getStats().getDefense();
	}

	@Override
	public int specialed(GameCharacter $hero) 
	{
		//System.out.println("In Action");
		return $hero.getStats().getDefense();
	}

	
}
