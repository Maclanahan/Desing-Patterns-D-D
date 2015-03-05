package Item;

//package application;

import Character.PlayerCharacter;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class WeaponSlot implements Slot {
	private StackPane panel;
	private Item item;
	private boolean empty;
	private Hand hand;
	PlayerCharacter holder;

	public WeaponSlot(Hand hand2, PlayerCharacter holder) {
		// TODO Auto-generated constructor stub
		this.hand = hand2;
		panel = new StackPane();
		this.holder = holder;
		panel.setPrefSize(50, 50);
		Text slot = new Text("Weapon");
		panel.getChildren().add(slot);
		Rectangle border = new Rectangle();
		border.setFill(Color.TRANSPARENT);
		border.setStroke(Color.BEIGE);
		border.setWidth(50);
		border.setHeight(50);
		// panel.getChildren().add(border);
		// TODO Auto-generated constructor stub
		panel.toFront();
		empty = true;
		panel.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				// System.out.println("holder def " + holder._stats.DefenceMod);
				// System.out.println("holder int "
				// + holder._stats.IntelligenceMod);
				// System.out.println("holder str " +
				// holder._stats.StrengthMod);
				// System.out.println("empty " + empty);
				// System.out.println("hand " + hand.empty);
				// if (hand.empty == false) {
				// // System.out.println("hand " + hand.item.getStr());
				// }
				// System.out.println("item " + item.str);
				if (empty == true && hand.empty != true
						&& hand.item.getType() == 2) {
					// System.out.println("put down item!");
					putItem();
					hand.item.equip();
				} else if (empty == false && hand.empty == true) {
					// System.out.println("get item!");
					getItem();
					hand.item.unequip();
				}
			}
		});
	}

	public void getItem() {
		panel.getChildren().remove(item.getImage());
		hand.item = item;
		hand.empty = false;
		empty = true;
		holder._stats.DefenceMod -= item.getDef();
		holder._stats.SpeedMod -= item.getSpd();
		holder._stats.StrengthMod -= item.getStr();
		holder._stats.IntelligenceMod -= item.getInt();

	}

	@Override
	public void putItem(Item item) {
		panel.getChildren().add(item.getImage());
		this.item = item;
		holder._stats.DefenceMod += item.getDef();
		holder._stats.SpeedMod += item.getSpd();
		holder._stats.StrengthMod += item.getStr();
		holder._stats.IntelligenceMod += item.getInt();
		empty = false;

		// TODO Auto-generated method stub

	}

	public void putItem() {
		panel.getChildren().add(hand.item.getImage());
		item = hand.item;
		empty = false;
		hand.empty = true;
		holder._stats.DefenceMod += item.getDef();
		holder._stats.SpeedMod += item.getSpd();
		holder._stats.StrengthMod += item.getStr();
		holder._stats.IntelligenceMod += item.getInt();
		// TODO Auto-generated method stub

	}

	@Override
	public boolean hasItem() {
		// TODO Auto-generated method stub
		return empty;
	}

	public StackPane getPanel() {
		return panel;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return empty;
	}
}