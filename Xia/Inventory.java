package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Inventory extends Application {

	StackPane hand = new StackPane();
	boolean got=false;
	public void start(Stage primaryStage) {
		try {
			GridPane root = new GridPane();
			root.setAlignment(Pos.BOTTOM_CENTER);
			Scene scene = new Scene(root, 400, 400);
			primaryStage.setScene(scene);
			primaryStage.show();
			BagSlot[] bag = new BagSlot[16];
			Sword testSword = new Sword();
			
			//for ( i = 6; i > 2; i--){
				//for (j = 6; j > 2; j--)
			for (int i = 0; i < 16; i++)
			{
				bag[i] = new BagSlot(hand, got);
			}
			bag[0].putItem(testSword);
			for (int i = 0; i < 4; i++) {
				Rectangle border = new Rectangle();
				border.setFill(Color.TRANSPARENT);
				border.setStroke(Color.BLACK);
				border.setWidth(50);
				border.setHeight(50);
				root.add(border,i, 5);
				(root).add(bag[i].panel, i, 5);
			}
			for (int i = 0; i < 4; i++) {
				Rectangle border = new Rectangle();
				border.setFill(Color.TRANSPARENT);
				border.setStroke(Color.BLACK);
				border.setWidth(50);
				border.setHeight(50);
				root.add(border,i, 6);
				(root).add(bag[i + 4].panel, i, 6);
			}
			for (int i = 0; i < 4; i++) {
				Rectangle border = new Rectangle();
				border.setFill(Color.TRANSPARENT);
				border.setStroke(Color.BLACK);
				border.setWidth(50);
				border.setHeight(50);
				root.add(border,i, 7);
				(root).add(bag[i + 8].panel, i, 7);
			}
			for (int i = 0; i < 4; i++) {
				Rectangle border = new Rectangle();
				border.setFill(Color.TRANSPARENT);
				border.setStroke(Color.BLACK);
				border.setWidth(50);
				border.setHeight(50);
				root.add(border,i, 8);
				(root).add(bag[i + 12].panel, i, 8);
			}
			Slot[] slots_A = new Slot[3];
			Slot[] slots_B = new Slot[3];
			Slot[] slots_C = new Slot[3];
			Slot[] slots_D = new Slot[3];
			
				slots_A[0] = new ArmorSlot(hand, got);
			
				slots_B[0] = new ArmorSlot(hand, got);
	
				slots_C[0] = new ArmorSlot(hand, got);
				
				slots_D[0] = new ArmorSlot(hand, got);
			
				slots_A[1] = new WeaponSlot(hand, got);
				
				slots_B[1] = new WeaponSlot(hand, got);
	
				slots_C[1] = new WeaponSlot(hand, got);
				
				slots_D[1] = new WeaponSlot(hand, got);
			
				slots_A[2] = new MiscSlot(hand, got);
				
				slots_B[2] = new MiscSlot(hand, got);
	
				slots_C[2] = new MiscSlot(hand, got);
				
				slots_D[2] = new MiscSlot(hand, got);
			
			
			for (int i = 0; i < 3; i++) {
				Rectangle border = new Rectangle();
				border.setFill(Color.TRANSPARENT);
				border.setStroke(Color.AQUA);
				border.setWidth(50);
				border.setHeight(50);
				root.add(border,0,i);
				(root).add(slots_A[i].getPanel(), 0, i);
				Rectangle border2 = new Rectangle();
				border2.setFill(Color.TRANSPARENT);
				border2.setStroke(Color.GREEN);
				border2.setWidth(50);
				border2.setHeight(50);
				root.add(border2,1,i);
				(root).add(slots_B[i].getPanel(), 1, i);
				Rectangle border3 = new Rectangle();
				border3.setFill(Color.TRANSPARENT);
				border3.setStroke(Color.RED);
				border3.setWidth(50);
				border3.setHeight(50);
				root.add(border3,2,i);
				(root).add(slots_C[i].getPanel(), 2, i);
				Rectangle border4 = new Rectangle();
				border4.setFill(Color.TRANSPARENT);
				border4.setStroke(Color.BROWN);
				border4.setWidth(50);
				border4.setHeight(50);
				root.add(border4,3,i);
				(root).add(slots_D[i].getPanel(), 3, i);
			}	
			//}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
