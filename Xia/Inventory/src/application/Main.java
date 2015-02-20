package application;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Main extends Application {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane root = new GridPane();
			root.setAlignment(Pos.BOTTOM_CENTER);
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(
					getClass().getResource("application.css").toExternalForm());
			Rectangle[] inventory = new Rectangle[20];
			// Canvas canvas = new Canvas(50, 50);
			// GraphicsContext gc = canvas.getGraphicsContext2D();
			// gc.setFill(Color.BLUE);
			// gc.fillRect(75, 75, 100, 100);
			for (int i = 0; i < 16; i++)
			{
				inventory[i] = new Rectangle();
				inventory[i].setFill(Color.TRANSPARENT);
				inventory[i].setStroke(Color.BLACK);
				inventory[i].setWidth(50);
				inventory[i].setHeight(50);
				
			}
			for (int i = 0; i < 4; i++)
			{
				root.add(inventory[i], i, 5);
			}
			for (int i = 0; i < 4; i++)
			{
				root.add(inventory[i+4], i, 6);
			}
			for (int i = 0; i < 4; i++)
			{
				root.add(inventory[i+8], i, 7);
			}
			for (int i = 0; i < 4; i++)
			{
				root.add(inventory[i+12], i, 8);
			}
			Rectangle[] slots_A = new Rectangle[3];
			Rectangle[] slots_B = new Rectangle[3];
			Rectangle[] slots_C = new Rectangle[3];
			Rectangle[] slots_D = new Rectangle[3];
			for (int i = 0; i < 3; i++)
			{
				slots_A[i] = new Rectangle();
				slots_A[i].setFill(Color.TRANSPARENT);
				slots_A[i].setStroke(Color.BLUE);
				slots_A[i].setWidth(50);
				slots_A[i].setHeight(50);
				slots_B[i] = new Rectangle();
				slots_B[i].setFill(Color.TRANSPARENT);
				slots_B[i].setStroke(Color.BLUE);
				slots_B[i].setWidth(50);
				slots_B[i].setHeight(50);
				slots_C[i] = new Rectangle();
				slots_C[i].setFill(Color.TRANSPARENT);
				slots_C[i].setStroke(Color.BLUE);
				slots_C[i].setWidth(50);
				slots_C[i].setHeight(50);
				slots_D[i] = new Rectangle();
				slots_D[i].setFill(Color.TRANSPARENT);
				slots_D[i].setStroke(Color.BLUE);
				slots_D[i].setWidth(50);
				slots_D[i].setHeight(50);
				
			}
			for (int i = 0; i < 3; i++)
			{
			root.add(slots_A[i], 0, i);
			root.add(slots_B[i], 1, i);
			root.add(slots_C[i], 2, i);
			root.add(slots_D[i], 3, i);
			}
			// root.getChildren().add(canvas);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void rect() {
		Rectangle r = new Rectangle();
		r.setX(50);
		r.setY(50);
		r.setWidth(200);
		r.setHeight(100);
		r.setArcWidth(20);
		r.setArcHeight(20);

		return;
	}

	public static void main(String[] args) {
		launch(args);
		rect();
	}
}
