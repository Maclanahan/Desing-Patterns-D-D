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

public class EnemyHolder extends CharacterHolder
{	
	public EnemyHolder(GameCharacter gameCharacter, TurnStep $turn, Selector $select, int $x_position,
			int $y_position, AnimationManager $animator) 
	{
		super(gameCharacter, $select, $x_position, $y_position, $animator);
	}

	@Override
	public Group getObjects() 
	{
		Group g = new Group();
		g.getChildren().add(_sprite);
		g.getChildren().add(_healthbar.getObjects());
		
		return g;
	}	

	@Override
	public void setButtonsToUnSelectable() {	}

	@Override
	public void setButtonsToSelectable() {	}


	
}
