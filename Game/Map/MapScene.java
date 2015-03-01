package Map;

import java.util.Observable;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import application.GameScene;

public class MapScene extends Observable implements GameScene 
{
	private Scene scene;
	private Group root;
	private Text txt;
	private int numVisited = 0;
	
	public MapScene()
	{
		root = new Group();
		scene = new Scene(root, 640, 480, Color.WHITE);
		
		txt = new Text(100,100, "I'm The Map Scene!\n Visited " + numVisited + " times");
		
		root.getChildren().add(txt);
		
		Rectangle button = new Rectangle(200, 100, Color.RED);
		
		button.setOnMousePressed(new EventHandler<MouseEvent>()
		{
			public void handle(MouseEvent me)
			{
				//System.out.println("Mouse Pressed");
				//execute();
				setChanged();
				notifyObservers("COMBAT");
			}
		});
		
		button.xProperty().set(300);
		button.yProperty().set(300);
		
		root.getChildren().add(button);
		
		Rectangle button2 = new Rectangle(200, 100, Color.BLUE);
		
		button2.setOnMousePressed(new EventHandler<MouseEvent>()
		{
			public void handle(MouseEvent me)
			{
				//System.out.println("Mouse Pressed");
				//execute();
				setChanged();
				notifyObservers("INVENTORY");
			}
		});
		
		button2.xProperty().set(300);
		button2.yProperty().set(100);
		
		root.getChildren().add(button2);
		
	}
	
	@Override
	public void Start() 
	{
		Floor floor = new Floor(4,4);
	    
		floor.printFloor();
	}

	@Override
	public Scene getScene() 
	{
		numVisited++;
		txt.textProperty().set("I'm The Map Scene!\n Visited " + numVisited + " times");
		return scene;
	}

	@Override
	public String getType() 
	{
		return "Map";
	}

	

}
