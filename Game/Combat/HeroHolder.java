package Combat;

import java.awt.Point;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import Character.GameCharacter;
import Character.PlayerCharacter;

public class HeroHolder extends CharacterHolder
{
	private CommandHolder _commands;
	
	public HeroHolder(GameCharacter $hero, TurnStep $turn, Selector $select, int $x_position, int $y_position)
	{
		super($hero, $select, $x_position, $y_position);		
		_commands = new CommandHolder(_char, $turn, basePosition);
	}
	
	public Group getObjects()
	{
		Group g = new Group();
		g.getChildren().add(_healthbar.getObjects());
		g.getChildren().add(_sprite);
		g.getChildren().add(_commands.getObjects());
		
		return g;
	}

	@Override
	public void setButtonsToUnSelectable() 
	{
		_commands.setToUnselectable();
		
	}

	@Override
	public void setButtonsToSelectable() 
	{
		_commands.setToSelectable();
		
	}
	
	@Override
	protected void makeDead() 
	{
		super.makeDead();
		
		_commands.setToDead();
	}
}
