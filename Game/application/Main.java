package application;
	
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

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
	private ArrayList<PlayerCharacter> _characters = new ArrayList<>();
	private ArrayList<PlayerCharacter> _enemies = new ArrayList<>();
	
	private Stage _primaryStage;
	
	private MapScene _map;
	private InventoryScene _inven;
	
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
		CombatScene combat = new CombatScene(_characters, _enemies);
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
		_characters.add(new PlayerCharacter("Peter"));
		_characters.add(new PlayerCharacter("Susan"));
		_characters.add(new PlayerCharacter("Edmund"));
		_characters.add(new PlayerCharacter("Lucy"));
		
		_enemies.add(new PlayerCharacter("Wolf"));
		_enemies.add(new PlayerCharacter("White Witch"));
		_enemies.add(new PlayerCharacter("Dwarf"));
		_enemies.add(new PlayerCharacter("Gaint"));
	}
	
	private void setUpInventory() 
	{
		_inven = new InventoryScene();
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
		
		else if(str.equalsIgnoreCase("INVENTORY"))
			goToInventory();
		
		else
			goToMap();
	}
}
