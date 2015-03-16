package Character;

import java.util.Random;

import application.AnimationManager;

public class Special implements Action
{
	private Random rand = new Random();
	private int max = 5;
	@Override
	public void execute(GameCharacter $hero, GameCharacter $target, AnimationManager $animator) 
	{
		if($target != null)
		{
			$animator.SpecialAnimation($hero.getImage());
			int damage = $hero.getStats().getStrength() - $target.specialed();
			damage += rand.nextInt() % (max + 1);
			
			if(damage > 0)
			{
				$animator.takeHitAnimation($target.getImage());
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
