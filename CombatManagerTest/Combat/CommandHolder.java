package Combat;

import java.awt.Point;

import javafx.scene.Group;
import Character.PlayerCharacter;

public class CommandHolder 
{
	private AttackCommand atk;
	private DefendCommand def;
	private SpecialCommand spcl;
	
	public CommandHolder(PlayerCharacter _$hero, TurnStep $turn, Point $basePosition)
	{
		atk = new AttackCommand(_$hero, $turn, $basePosition);
		def = new DefendCommand(_$hero, $turn, $basePosition);
		spcl = new SpecialCommand(_$hero, $turn, $basePosition);
	}
	
	public Group getObjects()
	{
		Group g = new Group();
		g.getChildren().add(atk.getButton());
		g.getChildren().add(def.getButton());
		g.getChildren().add(spcl.getButton());
		
		return g;
		
	}
}