package Combat;

import java.awt.Point;

import application.AnimationManager;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import Character.GameCharacter;
import Character.PlayerCharacter;

public abstract class CharacterHolder 
{
	protected Rectangle _sprite;
	protected Healthbar _healthbar;
	protected GameCharacter _char;
	protected Point basePosition;
	protected Point baseSize;
	protected Selector _select;
	protected boolean _isDead = false;
	
	public CharacterHolder(GameCharacter $char, Selector $select, int $x_position, int $y_position, AnimationManager $animator)
	{
		_char = $char;
		_select = $select;
		basePosition = new Point($x_position, $y_position);
		baseSize = new Point(90, 135);
		
		_healthbar = new Healthbar(basePosition, _char.getTotalHitPoints(), $animator);
		
		_sprite = $char.getImage();//accessorizeRectangle(90, 90, Color.DODGERBLUE);
		
		placeObjects();
	}
	
	protected Rectangle accessorizeRectangle(int i, int j, Color color) 
	{
		Rectangle rect = new Rectangle(i, j, color);
		rect.arcHeightProperty().set(5);
		rect.arcWidthProperty().set(5);
		rect.strokeProperty().set(Color.BLACK);
		rect.strokeWidthProperty().set(2);
		
		return rect;
	}
	
	protected void placeObjects() 
	{
		//_healthbar.xProperty().set(basePosition.x);
		//_healthbar.yProperty().set(basePosition.y);
		
		_sprite.xProperty().set(basePosition.x);
		_sprite.yProperty().set(basePosition.y + baseSize.y - _sprite.heightProperty().intValue() );
		
	}
	
	public abstract Group getObjects();

	public void setIconToSelectable() 
	{
		_sprite.setOnMousePressed(new EventHandler<MouseEvent>()
		{
			public void handle(MouseEvent me)
			{
				//System.out.println("Sprite Pressed");
				
				_select.setTarget(_char);
			}
		});
		
	}
	
	public void setIconToUnselectable() 
	{
		_sprite.setOnMousePressed(null);
		
	}

	public abstract void setButtonsToUnSelectable();
	
	public abstract void setButtonsToSelectable();
	
	public void update()
	{
		_healthbar.updateHealth(_char.getCurrentHealth());
			
		if(_char.getCurrentHealth() == 0)
		{
			makeDead();
		}
	}
	
	protected void makeDead() 
	{
		_isDead = true;
		
		setIconToUnselectable();
		
		recolorRectangle(_sprite, Color.GREY);
	}

	protected void recolorRectangle(Rectangle $sprite, Color $color) 
	{
		$sprite.fillProperty().set($color);
	}
}
