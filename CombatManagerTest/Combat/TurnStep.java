package Combat;

import Character.Action;
import Character.PlayerCharacter;

public class TurnStep 
{
	private PlayerCharacter _hero;
	private Action _act;
	private PlayerCharacter _target;
	
	public TurnStep() { }
	
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
}
