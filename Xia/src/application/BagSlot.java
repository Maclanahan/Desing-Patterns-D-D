package application;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BagSlot implements Slot {
	private StackPane panel;
	private Item item;
	private boolean empty;
	private Hand hand;

	public BagSlot(Hand hand2) {
		empty = true;
		this.hand = hand2;
		panel = new StackPane();
		panel.setPrefSize(50, 50);
		Rectangle border = new Rectangle();
		border.setFill(Color.TRANSPARENT);
		border.setStroke(Color.BLACK);
		border.setWidth(50);
		border.setHeight(50);
		// panel.getChildren().add(border);
		panel.toFront();
		// TODO Auto-generated constructor stub
		panel.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				// System.out.println("empty " + empty);
				// System.out.println("hand " + hand.empty);
				if (hand.empty == false) {
					// System.out.println("hand " + hand.item.getStr());
				}
				// System.out.println("item " + item.str);
				if (empty == true && hand.empty != true) {
					// System.out.println("put down item!");
					putItem();
				} else if (empty == false && hand.empty == true) {
					// System.out.println("get item!");
					getItem();
				}
			}
		});
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return empty;
	}

	public void getItem() {
		panel.getChildren().remove(item.getImage());
		hand.item = item;
		hand.empty = false;
		empty = true;

	}

	@Override
	public void putItem(Item item) {
		panel.getChildren().add(item.getImage());
		this.item = item;
		this.empty = false;

		// TODO Auto-generated method stub

	}

	public void putItem() {
		panel.getChildren().add(hand.item.getImage());
		item = hand.item;
		empty = false;
		hand.empty = true;
		// TODO Auto-generated method stub

	}

	@Override
	public StackPane getPanel() {
		// TODO Auto-generated method stub
		return panel;
	}

	@Override
	public boolean hasItem() {
		// TODO Auto-generated method stub
		return empty;
	}

}
