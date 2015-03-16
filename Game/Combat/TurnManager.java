package Combat;

import java.util.ArrayList;
import java.util.Observable;

import application.AnimationManager;
import Character.GameCharacter;
import Character.PlayerCharacter;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TurnManager extends Observable
{
	private ArrayList<TurnStep> _turns;
	private ArrayList<CharacterHolder> _chars;
	private ArrayList<GameCharacter> _heros;
	private ArrayList<GameCharacter> _enemies;
	private Rectangle button;
	private AnimationManager _animator;
	
	public TurnManager(ArrayList<TurnStep> $turns, ArrayList<CharacterHolder> $chars, ArrayList<GameCharacter> $heros, 
			ArrayList<GameCharacter>$enemies, AnimationManager $animator) 
	{
		_turns = $turns;
		_chars = $chars;
		_heros = $heros;
		_enemies = $enemies;
		_animator = $animator;
		
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
		
		button.fillProperty().set(Color.RED);
		
	}
	
	private void executeTurn() 
	{
		setTurnButtonUnSelectable();
		
		sortTurns();
		
		for(TurnStep ts : _turns)
		{
			ts.execute();
			
			for(CharacterHolder ch : _chars)
			{
				ch.update();
			}
		}
		
		_animator.playAnimations();
		
	}
	
	private void sortTurns() 
	{
		for(int i = _turns.size(); i >= 0; i--)
			for(int j = 0; j < _turns.size() - 1; j++)
		{
			if(_turns.get(j).getSpeed() > _turns.get(j+1).getSpeed())
				swap(j, j+1);
		}
	}

	private void swap(int j, int i) 
	{
		TurnStep temp = _turns.get(j);
		_turns.set(j, _turns.get(i));
		_turns.set(i, temp);
	}

	public void afterAnimationExecute() 
	{
		for(TurnStep ts : _turns)
		{
			ts.reset();	
		}
		
		for(CharacterHolder ch : _chars)
		{
			ch.update();
		}
		
		this.setChanged();
		this.notifyObservers("words");
		
		setTurnButtonSelectable();
	}
	
	

	public void setTurnButtonUnSelectable()
	{
		button.fillProperty().set(Color.GREY);
		button.setOnMousePressed(null);
	}

	public Node getObjects() 
	{
		return button;
	}

	

	
	
	
}
