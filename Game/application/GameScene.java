package application;

import javafx.scene.Scene;

public interface GameScene 
{
	public void Start();
	
	public Scene getScene();
	
	public String getType();
}
