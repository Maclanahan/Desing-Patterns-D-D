package Character;

import java.util.ArrayList;

import Item.Item;

public class PlayerCharacter 
{
	public String _name;
	public Stats _stats;
	protected CharacterInventory _items;
	protected Action _actionState;
	
	
	public PlayerCharacter(String $name)
	{
		_name = $name;
		_actionState = new NoAction();
		setStats();
	}

	private void setStats() 
	{
		_stats = new Stats();
		
	}
	
	public void execute(PlayerCharacter $target)
	{
		_actionState.execute(this, $target);
	}
	
	public int attacked()
	{
		return _actionState.attacked(this);
	}
	
	public int specialed()
	{
		return _actionState.specialed(this);
	}
	
	public void setActionToAttack()
	{
		_actionState = new Attack();
	}
	
	public void setActionToDefend()
	{
		_actionState = new Defend();
	}
	
	public void setActionToSpecial()
	{
		_actionState = new Special();
	}
	
	public void setActionToNoAction()
	{
		_actionState = new NoAction();
	}

	public void takeDamage(int $damage) 
	{
		_stats.takeDamage($damage);
	}

	public int getTotalHitPoints()
	{
		return _stats.getHitPoints();
	}

	public int getCurrentHealth() 
	{
		return _stats.CurrentHitPoints;
	}
}
