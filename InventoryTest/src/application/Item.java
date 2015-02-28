package application;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public interface Item {
	
//	
//	int str;
//	int intel;
//	int def;
//	int dmg;
//	int speed;
//	boolean equip;
////	boolean empty;
//	Image image = new Image("nothing.png", 40, 40, false, false);
//	ImageView imageview = new ImageView(image);

	public boolean equip();
	public int getStr();
	public int getInt();
	public int getDmg();
	public int getDef();
	public int getSpd();
	public boolean unequip();
	public boolean getEquip();
	public int getID();
	public ImageView getImage();
	public int getType();

}
