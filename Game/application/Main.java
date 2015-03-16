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
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application
{
	
	@Override
	public void start(Stage primaryStage) 
	{
		GameSceneManager gameScene = new GameSceneManager(primaryStage);
		gameScene.start();
	}


	public static void main(String[] args) {
		launch(args);
	}

}
