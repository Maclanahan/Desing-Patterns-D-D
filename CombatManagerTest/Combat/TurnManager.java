package Combat;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TurnManager 
{
	private ArrayList<TurnStep> _turns;
	private ArrayList<CharacterHolder> _chars;
	private Rectangle button;
	
	public TurnManager(ArrayList<TurnStep> $turns, ArrayList<CharacterHolder> $chars)
	{
		_turns = $turns;
		_chars = $chars;
		
		setUpTurnButton();
	}

	private void setUpTurnButton() 
	{
		button = new Rectangle(100, 50, Color.RED);
		button.xProperty().set(320 - 50);
		button.yProperty().set(240 - 25);
		
		button.arcHeightProperty().set(5);
		button.arcWidthProperty().set(5);
		button.strokeProperty().set(Color.BLACK);
		button.strokeWidthProperty().set(2);
		
		setTurnButtonSelectable();
	}
	
	public void setTurnButtonSelectable()
	{
		button.setOnMousePressed(new EventHandler<MouseEvent>()
				{
					public void handle(MouseEvent me)
					{
						//System.out.println("Turn Button Pressed");
						executeTurn();
					}
				});
		
	}
	
	private void executeTurn() 
	{
		for(TurnStep ts : _turns)
		{
			ts.execute();
			ts.reset();
		}
		
		for(CharacterHolder ch : _chars)
		{
			ch.update();
		}
		
	}
	
	public void setTurnButtonUnSelectable()
	{
		button.setOnMousePressed(null);
	}

	public Node getObjects() 
	{
		return button;
	}
	
	
}
