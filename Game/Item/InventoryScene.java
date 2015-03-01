package Item;

import java.util.Observable;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import application.GameScene;

public class InventoryScene extends Observable implements GameScene
{

	private Scene scene;
	private Group root;
	private Text txt;
	private int numVisited = 0;
	
	public InventoryScene()
	{
		root = new Group();
		scene = new Scene(root, 640, 480, Color.GRAY);
		
		txt = new Text(100,100, "I'm The Inventory Scene!\n Visited " + numVisited + " times");
		
		root.getChildren().add(txt);
		
		Rectangle button = new Rectangle(200, 100, Color.BLUE);
		
		button.setOnMousePressed(new EventHandler<MouseEvent>()
		{
			public void handle(MouseEvent me)
			{
				setChanged();
				notifyObservers("MAP");
			}
		});
		
		button.xProperty().set(300);
		button.yProperty().set(300);
		
		root.getChildren().add(button);
		
	}
	
	@Override
	public void Start() 
	{
		
	}

	@Override
	public Scene getScene() 
	{
		numVisited++;
		txt.textProperty().set("I'm The Inventory Scene!\n Visited " + numVisited + " times");
		return scene;
	}

	@Override
	public String getType() 
	{
		return "Map";
	}

}
