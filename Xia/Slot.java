package application;

import javafx.scene.Node;

public interface Slot {
	public boolean hasItem();
	public void putItem(Item item);
	public Node getPanel();

	
}
