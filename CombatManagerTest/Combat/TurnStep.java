package Combat;

import Character.Action;
import Character.PlayerCharacter;

public class TurnStep 
{
	private PlayerCharacter _hero;
	private Action _act;
	private PlayerCharacter _target;
	private Selector _select;
	
	public TurnStep(Selector $select) 
	{
		_select = $select;
		
	}
	
	public void setAction(Action $act)
	{
		_act = $act;
	}
	
	public void setTarget(PlayerCharacter $target)
	{
		_target = $target;
	}
	
	public void execute()
	{
		_act.execute(_hero, _target);
	}
	
	public void reset()
	{
		//_act = emtpy version of class 
		//_target = empty version of class
	}

	public void setAttack() 
	{
		//setAction(_hero.getAttack());
		_select.beginChoose(this);
	}
	
	public void setDefend() 
	{
		//setAction(_hero.getDefend());
	}
	
	public void setSpecial() 
	{
		//setAction(_hero.getSpecial());
		_select.beginChoose(this);
	}
}
