package Item;

//package application;

import Character.GameCharacter;
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
	GameCharacter holder;

	public WeaponSlot(Hand hand2, GameCharacter gameCharacter) {
		// TODO Auto-generated constructor stub
		this.hand = hand2;
		panel = new StackPane();
		this.holder = gameCharacter;
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
				// System.out.println("holder def " +
				// holder.getStats().DefenceMod);
				// System.out.println("holder int "
				// + holder.getStats().IntelligenceMod);
				// System.out.println("holder spd " +
				// holder.getStats().SpeedMod);
				// System.out.println("holder str "
				// + holder.getStats().StrengthMod);
				// System.out.println("holder hp "
				// + holder.getStats().HitPointsMod);
				// System.out.println("holder int "
				// + holder.getStats().IntelligenceMod);
				// System.out.println("holder str " +
				// holder.getStats().StrengthMod);
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
		holder.getStats().DefenceMod -= item.getDef();
		holder.getStats().SpeedMod -= item.getSpd();
		holder.getStats().StrengthMod -= item.getStr();
		holder.getStats().IntelligenceMod -= item.getInt();
		holder.getStats().HitPointsMod -= item.getHP();

	}

	@Override
	public void putItem(Item item) {
		panel.getChildren().add(item.getImage());
		this.item = item;
		holder.getStats().DefenceMod += item.getDef();
		holder.getStats().SpeedMod += item.getSpd();
		holder.getStats().StrengthMod += item.getStr();
		holder.getStats().IntelligenceMod += item.getInt();
		holder.getStats().HitPointsMod += item.getHP();
		empty = false;

		// TODO Auto-generated method stub

	}

	public void putItem() {
		panel.getChildren().add(hand.item.getImage());
		item = hand.item;
		empty = false;
		hand.empty = true;
		holder.getStats().DefenceMod += item.getDef();
		holder.getStats().SpeedMod += item.getSpd();
		holder.getStats().StrengthMod += item.getStr();
		holder.getStats().IntelligenceMod += item.getInt();
		holder.getStats().HitPointsMod += item.getHP();
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