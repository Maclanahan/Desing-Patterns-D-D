package Combat;

import java.awt.Point;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import Character.PlayerCharacter;

public abstract class CharacterHolder 
{
	private CommandHolder _commands;
	private Rectangle _sprite;
	private Rectangle _healthbar;
	private PlayerCharacter _hero;
	private Point basePosition;
	private Point baseSize;
	
	public CharacterHolder(PlayerCharacter $hero, TurnStep $turn, int $x_position, int $y_position)
	{
		_hero = $hero;
		basePosition = new Point($x_position, $y_position);
		baseSize = new Point(90, 135);
		
		_commands = new CommandHolder(_hero, $turn, basePosition);
		
		_sprite = accessorizeRectangle(90, 90, Color.DODGERBLUE);
		_healthbar = accessorizeRectangle(90, 10, Color.GREEN);
		
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
		_healthbar.xProperty().set(basePosition.x);
		_healthbar.yProperty().set(basePosition.y);
		
		_sprite.xProperty().set(basePosition.x);
		_sprite.yProperty().set(basePosition.y + baseSize.y - _sprite.heightProperty().intValue() );
		
	}
	
	public Group getObjects()
	{
		Group g = new Group();
		g.getChildren().add(_healthbar);
		g.getChildren().add(_sprite);
		g.getChildren().add(_commands.getObjects());
		
		return g;
	}
	
}
