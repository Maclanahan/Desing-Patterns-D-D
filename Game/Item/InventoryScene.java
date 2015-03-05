package Item;

import java.util.ArrayList;
import java.util.Observable;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import Character.GameCharacter;
import Character.PlayerCharacter;
import application.GameScene;

public class InventoryScene extends Observable implements GameScene {

	private Scene scene;
	private Group root;
	private Text txt;
	private int numVisited = 0;

	public InventoryScene(ArrayList<GameCharacter> _characters) {
		Inventory inv = new Inventory(_characters);
		inv.start();

		_characters.get(0).getInv().setItems(inv.slots_A());
		_characters.get(1).getInv().setItems(inv.slots_B());
		_characters.get(2).getInv().setItems(inv.slots_C());
		_characters.get(3).getInv().setItems(inv.slots_D());

		root = new Group();
		root.getChildren().add(inv.getRoot());
		scene = new Scene(root, 640, 480, Color.WHITE);
		// scene = inv.getScene();
		txt = new Text(250, 250, "I'm The Inventory Scene!\n Visited "
				+ numVisited + " times");

		root.getChildren().add(txt);
		Rectangle button = new Rectangle(200, 100, Color.BLUE);

		button.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				setChanged();
				notifyObservers("MAP");
			}
		});

		button.xProperty().set(300);
		button.yProperty().set(300);

		root.getChildren().add(button);

	}

	@Override
	public void Start() {

	}

	@Override
	public Scene getScene() {
		numVisited++;
		txt.textProperty().set(
				"I'm The Inventory Scene!\n Visited " + numVisited + " times");
		return scene;
	}

	@Override
	public String getType() {
		return "Map";
	}

}
