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

public class ArmorSlot implements Slot {
	private StackPane panel;
	private Item item;
	private boolean empty;
	private Hand hand;
	GameCharacter holder;

	public ArmorSlot(Hand hand2, GameCharacter gameCharacter) {
		this.hand = hand2;
		this.holder = gameCharacter;
		panel = new StackPane();
		panel.setPrefSize(50, 50);
		Text slot = new Text("Armor");
		panel.getChildren().add(slot);
		Rectangle border = new Rectangle();
		border.setFill(Color.TRANSPARENT);
		border.setStroke(Color.AQUA);
		border.setWidth(50);
		border.setHeight(50);
		// panel.getChildren().add(border);
		empty = true;
		panel.toFront();
		panel.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				// System.out.println("empty " + empty);
				// System.out.println("hand " + hand.empty);
				// if (hand.empty == false) {
				// // System.out.println("hand " + hand.item.getStr());
				// }
				// // System.out.println("item " + item.str);
				if (empty == true && hand.empty != true
						&& hand.item.getType() == 1) {
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
		// TODO Auto-generated constructor stub
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
		empty = false;
		holder.getStats().DefenceMod += item.getDef();
		holder.getStats().SpeedMod += item.getSpd();
		holder.getStats().StrengthMod += item.getStr();
		holder.getStats().IntelligenceMod += item.getInt();
		holder.getStats().HitPointsMod += item.getHP();
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

	@Override
	public StackPane getPanel() {
		return panel;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return empty;
	}

}
