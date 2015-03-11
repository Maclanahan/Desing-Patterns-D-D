package Item;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class TrashSlot implements Slot {
	Hand hand;
	StackPane panel;
	Text slotName;

	public TrashSlot(Hand hand, GridPane root) {
		this.hand = hand;
		panel = new StackPane();
		panel.setPrefSize(50, 50);
		slotName = new Text("Trash");
		panel.getChildren().add(slotName);
		Rectangle border = new Rectangle();
		border.setFill(Color.TRANSPARENT);
		border.setStroke(Color.BROWN);
		border.setWidth(50);
		border.setHeight(50);
		root.add(border, 5, 8);
		root.add(panel, 5, 8);// TODO Auto-generated constructor
		panel.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				// System.out.println("empty " + empty);
				// System.out.println("hand " + hand.empty);
				// if (hand.empty == false) {
				// // System.out.println("hand " + hand.item.getStr());
				// }
				// // System.out.println("item " + item.str);
				if (hand.empty != true) {
					hand.empty = true;
				}
				// stub
			}
		});
	}

	@Override
	public boolean hasItem() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void putItem(Item item) {
		// TODO Auto-generated method stub

	}

	@Override
	public void putItem() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getItem() {
		// TODO Auto-generated method stub

	}

	@Override
	public StackPane getPanel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
