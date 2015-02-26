package application;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Bag extends BagSlot {
	public Bag(StackPane hand, boolean get) {
		super(hand, get);
		// TODO Auto-generated constructor stub
	}

	BagSlot[] bag;
	boolean empty;
//	public Bag() {
//		bag = new BagSlot[16];
//		for (BagSlot slot: bag)
//		{
//			slot = new BagSlot(new StackPane(), false);
//		}
//	}

	@Override
	public boolean hasItem() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void putItem(Item item) {
		// TODO Auto-generated method stub

	}
	
	public void instanceBag(GridPane root)
	{
		int i = 0;
		int j = 0;
		System.out.println("here!!!");
		for (BagSlot slot : bag)
		{
			root.add(slot.panel, i, j);
			i++;
			j++;
		}
	}

}
