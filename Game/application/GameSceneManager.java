package application;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import Character.AICharacterFactory;
import Character.GameCharacter;
import Character.PlayerCharacter;
import Combat.CombatScene;
import Item.InventoryScene;
import Map.MapScene;
import javafx.stage.Stage;

public class GameSceneManager implements Observer
{
	private ArrayList<GameCharacter> _characters = new ArrayList<>();
	//private ArrayList<GameCharacter> _enemies = new ArrayList<>();
	
	private Stage _primaryStage;
	
	private GameScene _map;
	private GameScene _inven;
	private AICharacterFactory EnemyFactory;
	private AnimationManager _animator;
	private boolean bossfight = false;
	
	public GameSceneManager(Stage primaryStage)
	{
		_primaryStage = primaryStage;
		
		setUpCharacters();
		setUpMap();
		setUpInventory();
	}
	
	public void start() 
	{
		goToMap();
	}
	
	private void goToCombat(int $difficulty)
	{
		CombatScene combat = new CombatScene(_characters, EnemyFactory.getEnemies($difficulty), _animator);
		combat.addObserver(this);
		
		_primaryStage.setScene(combat.getScene());
		_primaryStage.show();
		
		combat.Start();	
	}
	
	private void goToInventory()
	{
		_primaryStage.setScene(_inven.getScene());
		_primaryStage.show();
		
		
	}
	
	private void goToMap()
	{		
		_primaryStage.setScene(_map.getScene());
		_primaryStage.show();
		
		
	}
	
	private void setUpCharacters() 
	{
		_animator = new AnimationManager();
		
		EnemyFactory = new AICharacterFactory(4, _animator);
		
		_characters.add(new PlayerCharacter("Peter", _animator));
		_characters.add(new PlayerCharacter("Susan", _animator));
		_characters.add(new PlayerCharacter("Edmund", _animator));
		_characters.add(new PlayerCharacter("Lucy", _animator));
	}
	
	private void setUpInventory() 
	{
		_inven = new InventoryScene(_characters);
		((InventoryScene)_inven).addObserver(this);
		
		_inven.Start();
	}

	private void setUpMap() 
	{
		_map = new MapScene();
		((MapScene)_map).addObserver(this);
		
		_map.Start();
	}

	@Override
	public void update(Observable o, Object arg) 
	{
		SceneSwitchInfo info = (SceneSwitchInfo)arg;
		
		//System.out.println(str);
		
		if(info.getDifficulty() > 49)
			bossfight = true;
		
		if(info.getSceneInfo().equalsIgnoreCase("COMBAT"))
			goToCombat(info.getDifficulty());
		
		else if(info.getSceneInfo().equalsIgnoreCase("WIN"))
		{
			if(bossfight)
				goToEndScene("Won!");
			else
			{
				((InventoryScene)_inven).loot(((MapScene)_map).getDifficulty());
				goToMap();
			}
		}
		
		else if(info.getSceneInfo().equalsIgnoreCase("LOSE"))
		{
			goToEndScene("Lost...");
		}
		
		else if(info.getSceneInfo().equalsIgnoreCase("INVENTORY"))
			goToInventory();
		
		else if(info.getSceneInfo().equalsIgnoreCase("TREASURE"))
			((InventoryScene)_inven).loot(((MapScene)_map).getDifficulty());
		
		else
			goToMap();
	}

	private void goToEndScene(String $string) 
	{
		EndScreen end = new EndScreen($string);
		
		_primaryStage.setScene(end.getScene());
		_primaryStage.show();
		
		end.Start();	
		
	}

	
}
