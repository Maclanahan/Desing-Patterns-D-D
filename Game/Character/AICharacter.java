package Character;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import application.AnimationManager;
import Combat.AISelector;

public class AICharacter implements GameCharacter
{

	public String _name;
	public Stats _stats;
	protected CharacterInventory _items;
	protected Action _actionState;
	protected AIBehavior _behave;
	protected AISelector _select;
	protected AnimationManager _animator;
	protected Rectangle _image;
	
	
	public AICharacter(String $name, BaseStats $baseStats, AIBehavior $behave, AnimationManager $animator)
	{
		_name = $name;
		_animator = $animator;
		_actionState = new NoAction();
		_behave = $behave;
		_stats = new Stats($baseStats);
		setUpImage();
	}
	
	public void execute(GameCharacter $target)
	{
		if(_select == null)
			_actionState.execute(this, $target, _animator);
		
		else if(_stats.CurrentHitPoints != 0)
			_behave.execute(this, _select, _animator);
		//else
			//System.out.println("Something is going wrong");
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
	
	public void setSelector(AISelector $select)
	{
		_select = $select;
	}

	@Override
	public CharacterInventory getInv() 
	{
		return _items;
	}

	@Override
	public void reset() 
	{
		
	}

	@Override
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
