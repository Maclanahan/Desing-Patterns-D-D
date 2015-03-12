package Map;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Observable;
import java.util.Scanner;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import application.GameScene;
import application.SceneSwitchInfo;

public class MapScene extends Observable implements GameScene 
{
	private Scene scene;
	private Group root;
	private Text txt;
	private int numVisited = 0;
	
	private char[][] floor;
	private int current = 0, tileWidth = 5, tileHeight = 5;
	private Rectangle[][] tiles;
	private Rectangle playerPos;
	private DungeonFactory df = new DungeonFactory();
	private Floor[] floors = df.getFloors();

	private Player player = new Player(floors[current]);
	
	public MapScene()
	{
		Scanner scan = new Scanner(System.in);
		
		root = new Group();
		scene = new Scene(root, 640, 480, Color.WHITE);
		
		addFloor();
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() 
				{
					public void handle(KeyEvent key)
					{
						if(checkWall(0,1,player) && (key.getText().equals("d") || key.getCode() == KeyCode.RIGHT))
						{
							player.setCol(player.getCol()+1);
							playerPos.setX(player.getCol()*tileWidth);
						}
						
						if(checkWall(0,-1,player) && (key.getText().equals("a") || key.getCode() == KeyCode.LEFT))
						{
							player.setCol(player.getCol()-1);
							playerPos.setX(player.getCol()*tileWidth);
						}
						
						if(checkWall(-1,0,player) && (key.getText().equals("w") || key.getCode() == KeyCode.UP))
						{
							player.setRow(player.getRow()-1);
							playerPos.setY(player.getRow()*tileHeight);
						}
						
						if(checkWall(1,0,player) && (key.getText().equals("s") || key.getCode() == KeyCode.DOWN))
						{
							player.setRow(player.getRow()+1);
							playerPos.setY(player.getRow()*tileHeight);
						}
						
						if (floor[player.getRow()][player.getCol()] == 'E')
						{
							current += 1;
							
							removeFloor();
							addFloor();
							
						}
						
					}
				});
		
		scan.close();
		   
		//EventHandler handler = new EventHandler
		//txt = new Text(100,100, "I'm The Map Scene!\n Visited " + numVisited + " times");
		
		//root.getChildren().add(txt);
		
		Rectangle button = new Rectangle(200, 100, Color.RED);
		
		button.setOnMousePressed(new EventHandler<MouseEvent>()
		{
			public void handle(MouseEvent me)
			{
				//System.out.println("Mouse Pressed");
				//execute();
				setChanged();
				notifyObservers(new SceneSwitchInfo("COMBAT", current/2 +1));
			}
		});
		
		button.xProperty().set(400);
		button.yProperty().set(300);
		
		root.getChildren().add(button);
		
		Rectangle button2 = new Rectangle(200, 100, Color.BLUE);
		
		button2.setOnMousePressed(new EventHandler<MouseEvent>()
		{
			public void handle(MouseEvent me)
			{
				//System.out.println("Mouse Pressed");
				//execute();
				setChanged();
				notifyObservers(new SceneSwitchInfo("INVENTORY", current/2 + 1));
			}
		});
		
		button2.xProperty().set(400);
		button2.yProperty().set(100);
		
		root.getChildren().add(button2);
		
	}
	
	private boolean checkWall(int row, int col, Player player)
	{
		if ( floor[player.getRow()+row][player.getCol()+col] != 'X')
			return true;
		
		return false;
	}
	
	private void removeFloor()
	{
		int i, j;
		
		for ( i=0; i<tiles.length; i++ )
			for ( j=0; j<tiles[0].length; j++ )
			{
				root.getChildren().remove(tiles[i][j]);
			}
		
		root.getChildren().remove(playerPos);
	}
	
	private void addFloor()
	{
		int i, j;
		
		tiles = new Rectangle[floors[current].getFloor().length][floors[current].getFloor()[current].length];
		floor = floors[current].getFloor();
		
		for ( i=0; i<tiles.length; i++ )
			for ( j=0; j<tiles[0].length; j++ )
			{
				if ( floor[i][j] == 'X' )
					tiles[i][j] = new Rectangle(tileWidth,tileHeight,Color.BLACK);
				else if ( floor[i][j] == 'E')
					tiles[i][j] = new Rectangle(tileWidth,tileHeight,Color.RED);
				else if ( floor[i][j] == 'B')
					tiles[i][j] = new Rectangle(tileWidth,tileHeight,Color.ORANGE);
				else
					tiles[i][j] = new Rectangle(tileWidth,tileHeight,Color.WHITE);
				
				tiles[i][j].setX(j*tileWidth);
				tiles[i][j].setY(i*tileHeight);
				
				root.getChildren().add(tiles[i][j]);
			}
		
		player = new Player(floors[current]);
		playerPos = new Rectangle(tileWidth, tileHeight,Color.GREEN);
		playerPos.setX(player.getCol()*tileWidth);
		playerPos.setY(player.getRow()*tileHeight);
		root.getChildren().add(playerPos);
	}
	
	@Override
	public void Start() 
	{
		
	}

	@Override
	public Scene getScene() 
	{
		numVisited++;
		//txt.textProperty().set("I'm The Map Scene!\n Visited " + numVisited + " times");
		return scene;
	}

	@Override
	public String getType() 
	{
		return "Map";
	}

	public int getDifficulty()
	{
		return current/2 + 1;
	}

}
