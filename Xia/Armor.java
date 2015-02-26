package application;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public abstract class Armor implements Item {
	int str=0;
	int intel=0;
	int def=0;
	int speed=0;
	boolean equip=false;
	Image image=new Image("nothing.png", 40, 40, false, false);
	ImageView imageview = new ImageView(image);
	public Armor() {
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean equip() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unequip() {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
