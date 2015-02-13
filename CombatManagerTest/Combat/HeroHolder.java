package Combat;

import java.awt.Point;

import javafx.scene.shape.Rectangle;
import Character.PlayerCharacter;

public class HeroHolder extends CharacterHolder
{
	private PlayerCharacter _hero;
	private CommandHolder _commands;
	
	public HeroHolder(PlayerCharacter $hero, TurnStep $turn, int $x_position,
			int $y_position) 
	{
		super($hero, $turn, $x_position, $y_position);
		// TODO Auto-generated constructor stub
	}
}
