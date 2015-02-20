package Combat;

import java.awt.Point;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import Character.PlayerCharacter;

public class EnemyHolder implements CharacterHolder
{
	private PlayerCharacter _monster;
	private Rectangle _sprite;
	private Healthbar _healthbar;
	private Point basePosition;
	private Point baseSize;
	private Selector _select;
	
	public EnemyHolder(PlayerCharacter $enemy, TurnStep $turn, Selector $select, int $x_position,
			int $y_position) 
	{
		_monster = $enemy;
		_select = $select;
		basePosition = new Point($x_position, $y_position);
		baseSize = new Point(90, 135);
		
		_healthbar = new Healthbar(basePosition, _monster.getTotalHitPoints());
		
		_sprite = accessorizeRectangle(90, 90, Color.DODGERBLUE);
		
		placeObjects();
	}
	
	private Rectangle accessorizeRectangle(int i, int j,
			Color color) 
	{
		Rectangle rect = new Rectangle(i, j, color);
		rect.arcHeightProperty().set(5);
		rect.arcWidthProperty().set(5);
		rect.strokeProperty().set(Color.BLACK);
		rect.strokeWidthProperty().set(2);
		
		return rect;
		
	}

	private void placeObjects() 
	{
		_sprite.xProperty().set(basePosition.x);
		_sprite.yProperty().set(basePosition.y + baseSize.y - _sprite.heightProperty().intValue() );
	}

	@Override
	public Group getObjects() 
	{
		Group g = new Group();
		g.getChildren().add(_healthbar.getObjects());
		g.getChildren().add(_sprite);
		
		return g;
	}

	@Override
	public void setIconToSelectable() 
	{
		_sprite.setOnMousePressed(new EventHandler<MouseEvent>()
		{
			public void handle(MouseEvent me)
			{
				//System.out.println("Sprite Pressed");
				
				_select.setTarget(_monster);
			}
		});
	}
	
	@Override
	public void setIconToUnselectable() 
	{
		_sprite.setOnMousePressed(null);
		
	}

	@Override
	public void setButtonsToUnSelectable() {	}

	

	@Override
	public void setButtonsToSelectable() {	}

	@Override
	public void update()
	{
		_healthbar.updateHealth(_monster.getCurrentHealth());
	}
	
}
