package Combat;

import Character.Action;
import Character.PlayerCharacter;

public class TurnStep 
{
	private PlayerCharacter _hero;
	private Action _act;
	private PlayerCharacter _target;
	private Selector _select;
	private PlayerCharacter _empty = new PlayerCharacter("nothing");
	
	public TurnStep(Selector $select, PlayerCharacter $hero) 
	{
		_select = $select;
		_hero = $hero;
		_target = _empty;
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
		//if(_target != null)
			_hero.execute(_target);
	}
	
	public void reset()
	{
		//_act = emtpy version of class 
		_hero.setActionToNoAction();
		_target = _empty;
	}

	public void setAttack() 
	{
		//setAction(_hero.getAttack());
		_hero.setActionToAttack();
		_select.beginChoose(this);
	}
	
	public void setDefend() 
	{
		_hero.setActionToDefend();
		//setAction(_hero.getDefend());
	}
	
	public void setSpecial() 
	{
		//setAction(_hero.getSpecial());
		_hero.setActionToSpecial();
		_select.beginChoose(this);
	}
}
