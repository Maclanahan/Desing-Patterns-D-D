package application;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class WeaponSlot implements Slot {
	StackPane panel;
	Item item;
	boolean empty;
	protected boolean got;
	StackPane hand;
	public WeaponSlot(StackPane hand, Boolean get) {
		// TODO Auto-generated constructor stub
		this.hand = hand;
		this.got = get;
		panel = new StackPane();
		panel.setPrefSize(50, 50);
		Rectangle border = new Rectangle();
		border.setFill(Color.TRANSPARENT);
		border.setStroke(Color.BEIGE);
		border.setWidth(50);
		border.setHeight(50);
		//panel.getChildren().add(border);
		// TODO Auto-generated constructor stub
		panel.toFront();
		empty = true;
		got = false;
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
		return empty;
	}

	@Override
	public void putItem(Item item) {
		// TODO Auto-generated method stub

	}
	
	public Node getPanel()
	{
		return panel;
	}
}
