package application;

import javafx.scene.Node;
import javafx.scene.layout.StackPane;

public interface Slot {
	public boolean hasItem();
	public void putItem(Item item);
	public void putItem();
	public void getItem();
	public StackPane getPanel();
	public boolean isEmpty();
	
}
