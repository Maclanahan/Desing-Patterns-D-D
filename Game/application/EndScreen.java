package application;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class EndScreen implements Observer, GameScene
{
	private Scene scene;
	private Group root;

	public EndScreen(String $display)
	{
		root = new Group();
		scene = new Scene(root, 640, 480, Color.BLACK);
		
		addObjectsToScene($display);
	}
	
	@Override
	public void Start() 
	{
		
	}

	private void addObjectsToScene(String $display) 
	{
		Text displayText = new Text("You " + $display);
		displayText.xProperty().set(320);
		displayText.yProperty().set(240);
		displayText.setFont(new Font(60));
		displayText.setFill(Color.WHITE);
		root.getChildren().add(displayText);
	}

	@Override
	public Scene getScene() 
	{
		return scene;
	}

	@Override
	public String getType() 
	{
		return "End";
	}

	@Override
	public void update(Observable o, Object arg) 
	{
		
		
	}

}
