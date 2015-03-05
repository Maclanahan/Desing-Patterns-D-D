package Item;

//package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Character.GameCharacter;
import Character.PlayerCharacter;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Inventory {

	private Hand hand;
	// private BagSlot[] bag;
	private Bag bag;
	private Scene scene;
	private ArrayList<Slot> slots_A;
	private ArrayList<Slot> slots_B;
	private ArrayList<Slot> slots_C;
	private ArrayList<Slot> slots_D;
	private GridPane root;
	private ArrayList<GameCharacter> chars;

	public Inventory(ArrayList<GameCharacter> _characters) {
		chars = _characters;
	}

	public List<Slot> slots_A() {
		return slots_A;
	}

	public List<Slot> slots_B() {
		return slots_B;
	}

	public List<Slot> slots_C() {
		return slots_C;
	}

	public List<Slot> slots_D() {
		return slots_D;
	}

	public Scene getScene() {
		return scene;
	}

	public GridPane getRoot() {
		return root;
	}

	public void initialInv() {
		// bag = new BagSlot[16];
		Sword testSword = new Sword();
		Sword testSword2 = new Sword();
		Sword testSword3 = new Sword();
		Sword testSword4 = new Sword();
		Clothes clothes = new Clothes();
		Clothes clothes2 = new Clothes();
		Clothes clothes3 = new Clothes();
		Clothes clothes4 = new Clothes();

		// for ( i = 6; i > 2; i--){
		// for (j = 6; j > 2; j--)
		// for (int i = 0; i < 16; i++)
		// {
		// bag[i] = new BagSlot(hand);
		// }
		Necklace neck = new Necklace();
		Necklace neck1 = new Necklace();
		Necklace neck2 = new Necklace();
		Necklace neck3 = new Necklace();
		bag.putItem(neck);
		bag.putItem(neck1);
		bag.putItem(neck2);
		bag.putItem(neck3);
		bag.putItem(testSword4);
		bag.putItem(testSword);
		bag.putItem(testSword3);
		bag.putItem(clothes2);
		bag.putItem(clothes);
		bag.putItem(clothes3);
		bag.putItem(clothes4);
		bag.putItem(testSword2);
	}

	public void start() {
		try {

			hand = new Hand();
			hand.empty = true;
			root = new GridPane();
			root.setAlignment(Pos.BOTTOM_CENTER);
			scene = new Scene(root, 400, 400);
			bag = new Bag(hand, root);

			// primaryStage.setScene(scene);
			// primaryStage.show();

			slots_A = new ArrayList<Slot>();
			slots_B = new ArrayList<Slot>();
			slots_C = new ArrayList<Slot>();
			slots_D = new ArrayList<Slot>();

			slots_A.add(0, new ArmorSlot(hand, chars.get(0)));

			slots_B.add(0, new ArmorSlot(hand, chars.get(1)));

			slots_C.add(0, new ArmorSlot(hand, chars.get(2)));

			slots_D.add(0, new ArmorSlot(hand, chars.get(3)));

			slots_A.add(0, new WeaponSlot(hand, chars.get(0)));

			slots_B.add(0, new WeaponSlot(hand, chars.get(1)));

			slots_C.add(0, new WeaponSlot(hand, chars.get(2)));

			slots_D.add(0, new WeaponSlot(hand, chars.get(3)));

			slots_A.add(0, new MiscSlot(hand, chars.get(0)));

			slots_B.add(0, new MiscSlot(hand, chars.get(1)));

			slots_C.add(0, new MiscSlot(hand, chars.get(2)));

			slots_D.add(0, new MiscSlot(hand, chars.get(3)));

			for (int i = 0; i < 3; i++) {
				Rectangle border = new Rectangle();
				border.setFill(Color.TRANSPARENT);
				border.setStroke(Color.AQUA);
				border.setWidth(50);
				border.setHeight(50);
				root.add(border, 0, i);
				(root).add(slots_A.get(i).getPanel(), 0, i);
				Rectangle border2 = new Rectangle();
				border2.setFill(Color.TRANSPARENT);
				border2.setStroke(Color.GREEN);
				border2.setWidth(50);
				border2.setHeight(50);
				root.add(border2, 1, i);
				(root).add(slots_B.get(i).getPanel(), 1, i);
				Rectangle border3 = new Rectangle();
				border3.setFill(Color.TRANSPARENT);
				border3.setStroke(Color.RED);
				border3.setWidth(50);
				border3.setHeight(50);
				root.add(border3, 2, i);
				(root).add(slots_C.get(i).getPanel(), 2, i);
				Rectangle border4 = new Rectangle();
				border4.setFill(Color.TRANSPARENT);
				border4.setStroke(Color.BROWN);
				border4.setWidth(50);
				border4.setHeight(50);
				root.add(border4, 3, i);
				(root).add(slots_D.get(i).getPanel(), 3, i);

			}

			// Sword x = new Sword();
			// bag.putItem(x);
			initialInv();
			// }

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
