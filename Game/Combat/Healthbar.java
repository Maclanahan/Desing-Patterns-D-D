package Combat;

import java.awt.Point;

import application.AnimationManager;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Healthbar 
{
	private Rectangle _healthbar;
	private Text _damage;
	private Point _basePosition;
	
	private int _length = 90;
	private int _height = 10;
	
	private double _currentLength = _length;
	private int _totalHitPoints;
	private int _prevHitPoints;
	
	private AnimationManager _animator;
	//private Rectangle _behindbar;
	
	public Healthbar(Point $basePosition, int $hitPoints, AnimationManager $animator)
	{
		_basePosition = $basePosition;
		_totalHitPoints = _prevHitPoints = $hitPoints;
		_animator = $animator;
		_healthbar = accessorizeRectangle(_length, _height, Color.GREEN);
		
		_damage = new Text();
		_damage.fontProperty().setValue(new Font(60));;
		
		placeObjects();
	}
	
	private void placeObjects() 
	{
		_healthbar.xProperty().set(_basePosition.x);
		_healthbar.yProperty().set(_basePosition.y);
		
		_damage.xProperty().set(_basePosition.x + 30);
		_damage.yProperty().set(_basePosition.y + 90);
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
		Group g = new Group();
		g.getChildren().add(_healthbar);
		g.getChildren().add(_damage);
		return g;
	}

	public void updateHealth(int $currentHealth) 
	{
		//System.out.println($currentHealth + " " + _prevHitPoints);
		
		if($currentHealth != _totalHitPoints && _currentLength != 0 && _prevHitPoints > $currentHealth)
		{
			_currentLength = ((double)$currentHealth / (double)_totalHitPoints) * (double)_length;
			_animator.displayDamage(_damage, $currentHealth - _prevHitPoints );
			_animator.moveHealth(_healthbar, _currentLength);
			
			_prevHitPoints = $currentHealth;
		}
	}
}
