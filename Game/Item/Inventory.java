package Item;

//package application;

import java.util.Arrays;
import java.util.List;

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
	private Slot[] slots_A;
	private Slot[] slots_B;
	private Slot[] slots_C;
	private Slot[] slots_D;
	private GridPane root;

	public List<Slot> slots_A() {
		List<Slot> slots_list_A = Arrays.asList(slots_A);

		return slots_list_A;
	}

	public List<Slot> slots_B() {
		List<Slot> slots_list_B = Arrays.asList(slots_B);

		return slots_list_B;
	}

	public List<Slot> slots_C() {
		List<Slot> slots_list_C = Arrays.asList(slots_C);

		return slots_list_C;
	}

	public List<Slot> slots_D() {
		List<Slot> slots_list_D = Arrays.asList(slots_D);

		return slots_list_D;
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

			slots_A = new Slot[3];
			slots_B = new Slot[3];
			slots_C = new Slot[3];
			slots_D = new Slot[3];

			slots_A[0] = new ArmorSlot(hand);

			slots_B[0] = new ArmorSlot(hand);

			slots_C[0] = new ArmorSlot(hand);

			slots_D[0] = new ArmorSlot(hand);

			slots_A[1] = new WeaponSlot(hand);

			slots_B[1] = new WeaponSlot(hand);

			slots_C[1] = new WeaponSlot(hand);

			slots_D[1] = new WeaponSlot(hand);

			slots_A[2] = new MiscSlot(hand);

			slots_B[2] = new MiscSlot(hand);

			slots_C[2] = new MiscSlot(hand);

			slots_D[2] = new MiscSlot(hand);

			for (int i = 0; i < 3; i++) {
				Rectangle border = new Rectangle();
				border.setFill(Color.TRANSPARENT);
				border.setStroke(Color.AQUA);
				border.setWidth(50);
				border.setHeight(50);
				root.add(border, 0, i);
				(root).add(slots_A[i].getPanel(), 0, i);
				Rectangle border2 = new Rectangle();
				border2.setFill(Color.TRANSPARENT);
				border2.setStroke(Color.GREEN);
				border2.setWidth(50);
				border2.setHeight(50);
				root.add(border2, 1, i);
				(root).add(slots_B[i].getPanel(), 1, i);
				Rectangle border3 = new Rectangle();
				border3.setFill(Color.TRANSPARENT);
				border3.setStroke(Color.RED);
				border3.setWidth(50);
				border3.setHeight(50);
				root.add(border3, 2, i);
				(root).add(slots_C[i].getPanel(), 2, i);
				Rectangle border4 = new Rectangle();
				border4.setFill(Color.TRANSPARENT);
				border4.setStroke(Color.BROWN);
				border4.setWidth(50);
				border4.setHeight(50);
				root.add(border4, 3, i);
				(root).add(slots_D[i].getPanel(), 3, i);

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
