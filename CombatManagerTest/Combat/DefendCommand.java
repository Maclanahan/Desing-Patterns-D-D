package Combat;

import java.awt.Point;

import Character.PlayerCharacter;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class DefendCommand implements Command 
{
	private Rectangle _button;
	private TurnStep _turn;
	
	public DefendCommand(PlayerCharacter _$hero, TurnStep $turn,
			Point $basePosition) 
	{
		_turn = $turn;
		
		setUpButton($basePosition);
		setUpEventListeners();
	}
	
	private void setUpEventListeners() 
	{
		_button.setOnMousePressed(new EventHandler<MouseEvent>()
		{
			public void handle(MouseEvent me)
			{
				System.out.println("Mouse Pressed");
				execute();
			}
		});
		
	}
	
	private void setUpButton(Point $basePosition) 
	{
		_button = new Rectangle(25, 25, Color.DARKBLUE);
		_button.xProperty().set($basePosition.x + 32);
		_button.yProperty().set($basePosition.y + 15);
		
		_button.arcHeightProperty().set(5);
		_button.arcWidthProperty().set(5);
		_button.strokeProperty().set(Color.BLACK);
		_button.strokeWidthProperty().set(2);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCommand() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rectangle getButton() {
		
		return _button;
	}

}
