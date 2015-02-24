package Combat;

import java.awt.Point;

import Character.PlayerCharacter;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SpecialCommand implements Command 
{
	private Rectangle _button;
	private TurnStep _turn;
	private boolean _isDead = false;

	public SpecialCommand(PlayerCharacter _$hero, TurnStep $turn,
			Point $basePosition) 
	{
		_turn = $turn;
		
		setUpButton($basePosition);
		setUpEventListeners();
	}
	
	private void setUpEventListeners() 
	{
		setToSelectable();
	}

	private void setUpButton(Point $basePosition) 
	{
		_button = new Rectangle(25, 25, Color.ORCHID);
		_button.xProperty().set($basePosition.x + 64);
		_button.yProperty().set($basePosition.y + 15);
		
		_button.arcHeightProperty().set(5);
		_button.arcWidthProperty().set(5);
		_button.strokeProperty().set(Color.BLACK);
		_button.strokeWidthProperty().set(2);
	}

	@Override
	public void execute() 
	{
		_turn.setSpecial();
		
	}

	@Override
	public void setCommand() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rectangle getButton() {
		return _button;
	}

	@Override
	public void setToUnselectable() 
	{
		_button.setOnMousePressed(null);
		
	}

	@Override
	public void setToSelectable() 
	{
		if(!_isDead)
			_button.setOnMousePressed(new EventHandler<MouseEvent>()
			{
				public void handle(MouseEvent me)
				{
					//System.out.println("Mouse Pressed");
					execute();
				}
			});
		
	}

	@Override
	public void setToDead() 
	{
		_isDead = true;
		setToUnselectable();
		
		_button.fillProperty().set(Color.GRAY);
	}

}
