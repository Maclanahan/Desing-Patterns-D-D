package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;



public class Main extends Application 
{
	public static String combatScreen = "combat";
	public static String combatScreenFile = "CombatScreen.fxml";
	public static String worldScreen = "world";
	public static String worldScreenFile = "world.fxml";
	public static String inventoryScreen = "inventory";
	public static String inventoryScreenFile = "inventory.fxml";
	
	
	@Override
	public void start(Stage primaryStage) 
	{
		ScreenController mainContainer = new ScreenController();
        mainContainer.loadScreen(combatScreen, combatScreenFile);
        //mainContainer.loadScreen(worldScreen, worldScreenFile);
        //mainContainer.loadScreen(inventoryScreen, inventoryScreenFile);
        
        mainContainer.setScreen(combatScreen);
        
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
