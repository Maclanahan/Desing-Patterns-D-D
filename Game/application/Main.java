package application;
	
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import Character.AICharacter;
import Character.AICharacterFactory;
import Character.GameCharacter;
import Character.PlayerCharacter;
import Combat.CombatScene;
import Item.InventoryScene;
import Map.MapScene;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class Main extends Application implements Observer
{
	private ArrayList<GameCharacter> _characters = new ArrayList<>();
	private ArrayList<GameCharacter> _enemies = new ArrayList<>();
	
	private Stage _primaryStage;
	
	private MapScene _map;
	private InventoryScene _inven;
	private AICharacterFactory EnemyFactory;
	
	@Override
	public void start(Stage primaryStage) 
	{
		_primaryStage = primaryStage;
		
		setUpCharacters();
		setUpMap();
		setUpInventory();
		
		goToMap();
	}

	private void goToCombat()
	{
		CombatScene combat = new CombatScene(_characters, EnemyFactory.getEnemies(1, 4));
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
		EnemyFactory = new AICharacterFactory(4);
		
		_characters.add(new PlayerCharacter("Peter"));
		_characters.add(new PlayerCharacter("Susan"));
		_characters.add(new PlayerCharacter("Edmund"));
		_characters.add(new PlayerCharacter("Lucy"));
	}
	
	private void setUpInventory() 
	{
		_inven = new InventoryScene(_characters);
		_inven.addObserver(this);
		
		_inven.Start();
	}

	private void setUpMap() 
	{
		_map = new MapScene();
		_map.addObserver(this);
		
		_map.Start();
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void update(Observable o, Object arg) 
	{
		String str = (String)arg;
		
		//System.out.println(str);
		
		if(str.equalsIgnoreCase("COMBAT"))
			goToCombat();
		
		else if(str.equalsIgnoreCase("WIN"))
		{
			_inven.loot(1);
			goToMap();
		}
		
		else if(str.equalsIgnoreCase("INVENTORY"))
			goToInventory();
		
		else
			goToMap();
	}
}
