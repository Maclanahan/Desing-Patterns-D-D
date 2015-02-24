package Combat;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import Character.PlayerCharacter;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CombatScene implements Observer
{
	private Scene scene;
	private Group root;
	private ArrayList<TurnStep> _turn = new ArrayList<>();
	private ArrayList<PlayerCharacter> _heros;
	private ArrayList<PlayerCharacter> _enemies;
	private ArrayList<CharacterHolder> _characters = new ArrayList<>();
	private Selector select;
	private TurnManager _turnManager;
	
	public CombatScene(ArrayList<PlayerCharacter> $heros, ArrayList<PlayerCharacter> $enemies)
	{
		root = new Group();
		scene = new Scene(root, 640, 480, Color.GRAY);
		
		_heros = $heros;
		_enemies = $enemies;
		
		select = new Selector(_characters);
		
		setUpCharacters();
//this is gross
		
		_turnManager = new TurnManager(_turn, _characters, _heros, _enemies);
		_turnManager.addObserver(this);
		select.setTurnManager(_turnManager);
		
		_turnManager.addObserver(this);
	}
	
	private void addObjectsToScene() 
	{
		Group g = new Group();
		
		for(CharacterHolder ch : _characters)
		{
			g.getChildren().add(ch.getObjects());
		}
		
		g.getChildren().add(_turnManager.getObjects());
		
		root.getChildren().add(g);
	}

	private void setUpCharacters() 
	{
		if(_heros.size() > 0)
		{
			TurnStep turn = new TurnStep(select, _heros.get(0));
			_characters.add(new HeroHolder(_heros.get(0), turn, select, 160, 15));
			_turn.add(turn);
		}
		
		if(_heros.size() > 1)
		{
			TurnStep turn = new TurnStep(select, _heros.get(1));
			_characters.add(new HeroHolder(_heros.get(1), turn, select, 40, 90));
			_turn.add(turn);
		}
		
		if(_heros.size() > 2)
		{
			TurnStep turn = new TurnStep(select, _heros.get(2));
			_characters.add(new HeroHolder(_heros.get(2), turn, select, 40, 240));
			_turn.add(turn);
		}
		
		if(_heros.size() > 3)
		{
			TurnStep turn = new TurnStep(select, _heros.get(3));
			_characters.add(new HeroHolder(_heros.get(3), turn, select, 160, 330));
			_turn.add(turn);
		}
		
		if(_enemies.size() > 0)
		{
			TurnStep turn = new TurnStep(select,_enemies.get(0));
			_characters.add(new EnemyHolder(_enemies.get(0), turn, select, 400, 15));
			_turn.add(turn);
		}
		
		if(_enemies.size() > 1)
		{
			TurnStep turn = new TurnStep(select, _enemies.get(1));
			_characters.add(new EnemyHolder(_enemies.get(1), turn, select, 520, 90));
			_turn.add(turn);
		}
		
		if(_enemies.size() > 2)
		{
			TurnStep turn = new TurnStep(select, _enemies.get(2));
			_characters.add(new EnemyHolder(_enemies.get(2), turn, select,  520, 240));
			_turn.add(turn);
		}
		
		if(_enemies.size() > 3)
		{
			TurnStep turn = new TurnStep(select, _enemies.get(3));
			_characters.add(new EnemyHolder(_enemies.get(3), turn, select, 400, 330));
			_turn.add(turn);
		}
		
	}
	
	private boolean isCombatOver(ArrayList<PlayerCharacter> _group) 
	{
		int numDead = 0;
		
		for(PlayerCharacter pc : _group)
		{
			if(pc.getCurrentHealth() == 0)
				numDead++;
		}
		
		//System.out.println("Dead: " + numDead + " Size: " + _group.size());
		if(numDead == _group.size())
			return true;
		
		else
			return false;
		
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

	@Override
	public void update(Observable o, Object arg) 
	{
//System.out.println("In Update");
		if(isCombatOver(_heros))
			System.out.println("YOU LOSE");//lose state
	
		if(isCombatOver(_enemies))
			System.out.println("YOU WIN!");//win state
		
	}
}
