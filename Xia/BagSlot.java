package application;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BagSlot implements Slot {
	StackPane panel;
	Item item;
	boolean empty;
	protected boolean got;
	StackPane hand;
	public BagSlot(StackPane hand, boolean get) {
		
		empty = true;
		got = false;
		this.got = get;
		this.hand = hand;
		panel = new StackPane();
		panel.setPrefSize(50, 50);
		Rectangle border = new Rectangle();
		border.setFill(Color.TRANSPARENT);
		border.setStroke(Color.BLACK);
		border.setWidth(50);
		border.setHeight(50);
		//panel.getChildren().add(border);
		panel.toFront();
		// TODO Auto-generated constructor stub
		panel.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				System.out.println("Mouse clicked!!");
				if (got == true) {
					panel.getChildren().addAll(hand.getChildren());
					got = false;
				} else {
					System.out.println("null!");
					hand.getChildren().addAll(panel.getChildren());
					got = true;
				}
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
		panel.getChildren().add(item.getImage());
		this.item = item;
		empty=false;
		// TODO Auto-generated method stub

	}

	@Override
	public Node getPanel() {
		// TODO Auto-generated method stub
		return null;
	}

}
