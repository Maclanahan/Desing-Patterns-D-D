package application;
	
import java.util.ArrayList;

import Character.PlayerCharacter;
import Combat.CombatScene;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class Main extends Application 
{
	private ArrayList<PlayerCharacter> _characters = new ArrayList<>();
	private ArrayList<PlayerCharacter> _enemies = new ArrayList<>();
	
	
	@Override
	public void start(Stage primaryStage) 
	{
		setUpCharacters();
		
		CombatScene combat = new CombatScene(_characters, _enemies);
		
		primaryStage.setScene(combat.getScene());
		primaryStage.show();
		
		combat.doSomething();
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

	public static void main(String[] args) {
		launch(args);
	}
}
