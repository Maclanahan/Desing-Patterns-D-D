package Combat;

import java.awt.Point;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import Character.PlayerCharacter;

public interface CharacterHolder 
{
	public Group getObjects();

	public void setIconToSelectable();
	
	public void setIconToUnselectable();

	public void setButtonsToUnSelectable();
	
	public void setButtonsToSelectable();
}
