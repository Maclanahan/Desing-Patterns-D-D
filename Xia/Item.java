package application;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public interface Item {

	//	int str=0;
//	int intel=0;
//	int def=0;
//	int speed=0;
//	boolean equip=false;
//	Image image=new Image("nothing.png", 40, 40, false, false);
//	ImageView imageview = new ImageView(image);
	public boolean equip();
	public boolean unequip();
	public int getID();
	public ImageView getImage();

}
