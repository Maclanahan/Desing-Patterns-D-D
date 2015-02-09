package Combat;

import java.util.ArrayList;

import Character.PlayerCharacter;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CombatScene 
{
	private Scene scene;
	private Group root;
	private ArrayList<TurnStep> _turn = new ArrayList<>();
	private ArrayList<PlayerCharacter> _heros;
	private ArrayList<PlayerCharacter> _enemies;
	private ArrayList<CharacterHolder> _characters = new ArrayList<>();
	
	public CombatScene(ArrayList<PlayerCharacter> $heros, ArrayList<PlayerCharacter> $enemies)
	{
		root = new Group();
		scene = new Scene(root, 640, 480, Color.GRAY);
		
		_heros = $heros;
		_enemies = $enemies;
		
		setUpCharacters();
		
		
	}
	
	private void addObjectsToScene() 
	{
		Group g = new Group();
		
		for(CharacterHolder ch : _characters)
		{
			g.getChildren().add(ch.getObjects());
		}
		
		root.getChildren().add(g);
	}

	private void setUpCharacters() 
	{
		if(_heros.size() > 0)
		{
			TurnStep turn = new TurnStep();
			_characters.add(new CharacterHolder(_heros.get(0), turn, 160, 15));
			_turn.add(turn);
		}
		
		if(_heros.size() > 1)
		{
			TurnStep turn = new TurnStep();
			_characters.add(new CharacterHolder(_heros.get(1), turn, 40, 90));
			_turn.add(turn);
		}
		
		if(_heros.size() > 2)
		{
			TurnStep turn = new TurnStep();
			_characters.add(new CharacterHolder(_heros.get(2), turn,  40, 240));
			_turn.add(turn);
		}
		
		if(_heros.size() > 3)
		{
			TurnStep turn = new TurnStep();
			_characters.add(new CharacterHolder(_heros.get(3), turn, 160, 330));
			_turn.add(turn);
		}
		
	}

	public Scene getScene()
	{
		return scene;
	}

	public void doSomething() 
	{
		//root.getChildren().add();
		addObjectsToScene();
	}
}
