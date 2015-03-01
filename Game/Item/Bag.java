package Item;
//package application;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Bag {

	private BagSlot[] items;

	public Bag(Hand hand, GridPane root) {
		items = new BagSlot[16];
		for (int i = 0; i < items.length; i++) {
			items[i] = new BagSlot(hand);
		}

		for (int i = 0; i < 4; i++) {
			Rectangle border = new Rectangle();
			border.setFill(Color.TRANSPARENT);
			border.setStroke(Color.BLACK);
			border.setWidth(50);
			border.setHeight(50);
			root.add(border, i, 5);
			root.add(items[i].getPanel(), i, 5);
		}
		for (int i = 0; i < 4; i++) {
			Rectangle border = new Rectangle();
			border.setFill(Color.TRANSPARENT);
			border.setStroke(Color.BLACK);
			border.setWidth(50);
			border.setHeight(50);
			root.add(border, i, 6);
			root.add(items[i + 4].getPanel(), i, 6);
		}
		for (int i = 0; i < 4; i++) {
			Rectangle border = new Rectangle();
			border.setFill(Color.TRANSPARENT);
			border.setStroke(Color.BLACK);
			border.setWidth(50);
			border.setHeight(50);
			root.add(border, i, 7);
			root.add(items[i + 8].getPanel(), i, 7);
		}
		for (int i = 0; i < 4; i++) {
			Rectangle border = new Rectangle();
			border.setFill(Color.TRANSPARENT);
			border.setStroke(Color.BLACK);
			border.setWidth(50);
			border.setHeight(50);
			root.add(border, i, 8);
			root.add(items[i + 12].getPanel(), i, 8);
		}
	}

	public boolean hasItem() {
		// TODO Auto-generated method stub
		return false;
	}

	public void putItem(Item item) {
		// TODO Auto-generated method stub

		for (int i = 0; i < items.length; i++) {
			if (items[i].isEmpty() == true)
			{
				items[i].putItem(item);
				return;
			}
		}

	}

	// public void instanceBag(GridPane root) {
	// int i = 0;
	// int j = 0;
	// System.out.println("here!!!");
	// for (BagSlot slot : bag) {
	// root.add(slot.panel, i, j);
	// i++;
	// j++;
	// }
	// }

}
