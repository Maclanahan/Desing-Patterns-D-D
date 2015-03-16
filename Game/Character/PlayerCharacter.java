package Character;

import java.util.ArrayList;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import application.AnimationManager;
import Item.Item;

public class PlayerCharacter implements GameCharacter
{
	public String _name;
	public Stats _stats;
	protected CharacterInventory _items;
	protected Action _actionState;
	protected AnimationManager _animator;
	protected Action _noAction;
	protected Action _attack;
	protected Action _defend;
	protected Action _special;
	protected Rectangle _image;

	public PlayerCharacter(String $name, AnimationManager $animator)
	{
		_name = $name;
		_animator = $animator;
		
		initializeActions();
		
		setStats();
		
		_items = new CharacterInventory();
		setUpImage();
	}

	private void initializeActions()
	{
		_noAction = new NoAction();
		_attack = new Attack();
		_defend = new Defend();
		_special = new Special();
		
		_actionState = _noAction;
	}
	
	public CharacterInventory getInv() 
	{
		return _items;
	}

	private void setStats() 
	{
		_stats = new Stats(new BaseStats(5,5,5,5,5));

	}
	
	public void execute(GameCharacter $target)
	{
		if(getCurrentHealth() != 0)
			_actionState.execute(this, $target, _animator);
	}

	public int attacked() {
		return _actionState.attacked(this);
	}

	public int specialed() {
		return _actionState.specialed(this);
	}

	public void setActionToAttack() {
		_actionState = _attack;
	}

	public void setActionToDefend() {
		_actionState = _defend;
	}

	public void setActionToSpecial() {
		_actionState = _special;
	}

	public void setActionToNoAction() {
		_actionState =_noAction;
	}

	public void takeDamage(int $damage) {
		_stats.takeDamage($damage);
	}

	public int getTotalHitPoints() {
		return _stats.getHitPoints();
	}

	public int getCurrentHealth() {
		return _stats.CurrentHitPoints;
	}

	@Override
	public String getName() 
	{
		return _name;
	}

	@Override
	public Stats getStats()
	{
		return _stats;
	}
	
	@Override
	public Action getAction() 
	{
		return _actionState;
	}

	@Override
	public void reset() 
	{
		_stats.reset();
		setUpImage();
	}
	
	public Rectangle getImage()
	{
		return _image;
	}
	private void setUpImage()
	{
		_image = new Rectangle(90, 90, Color.DODGERBLUE);
		_image.arcHeightProperty().set(5);
		_image.arcWidthProperty().set(5);
		_image.strokeProperty().set(Color.BLACK);
		_image.strokeWidthProperty().set(2);
	}
}
