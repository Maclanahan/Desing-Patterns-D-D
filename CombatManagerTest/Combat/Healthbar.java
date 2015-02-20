package Combat;

import java.awt.Point;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Healthbar 
{
	private Rectangle _healthbar;
	private Point _basePosition;
	
	private int _length = 90;
	private int _height = 10;
	
	private double _currentLength = _length;
	private int _totalHitPoints;
	//private Rectangle _behindbar;
	
	public Healthbar(Point $basePosition, int $hitPoints)
	{
		_basePosition = $basePosition;
		_totalHitPoints = $hitPoints;
		
		_healthbar = accessorizeRectangle(_length, _height, Color.GREEN);
		
		placeObjects();
	}
	
	private void placeObjects() 
	{
		_healthbar.xProperty().set(_basePosition.x);
		_healthbar.yProperty().set(_basePosition.y);
		
	}

	private Rectangle accessorizeRectangle(int i, int j, Color color) 
	{
		Rectangle rect = new Rectangle(i, j, color);
		rect.arcHeightProperty().set(5);
		rect.arcWidthProperty().set(5);
		rect.strokeProperty().set(Color.BLACK);
		rect.strokeWidthProperty().set(2);
		
		return rect;
	}

	public Node getObjects()
	{		
		return _healthbar;
	}

	public void updateHealth(int $currentHealth) 
	{
		_currentLength = ((double)$currentHealth / (double)_totalHitPoints) * (double)_length;
		_healthbar.widthProperty().set(_currentLength);
	}
}
