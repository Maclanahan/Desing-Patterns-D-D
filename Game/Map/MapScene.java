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
	private int current = 0, tileWidth = 64, tileHeight = 64;
	private Rectangle[][] tiles;
	private Rectangle playerPos;
	private DungeonFactory df = new DungeonFactory();
	private Floor[] floors = df.getFloors();

	private Player player = new Player(floors[current]);
	private Rectangle button;
	private Rectangle button2;
	
	
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
							movePlayer(0,-1);
							player.setCol(player.getCol()+1);
						}
						
						if(checkWall(0,-1,player) && (key.getText().equals("a") || key.getCode() == KeyCode.LEFT))
						{
							movePlayer(0,1);
							player.setCol(player.getCol()-1);
						}
						
						if(checkWall(-1,0,player) && (key.getText().equals("w") || key.getCode() == KeyCode.UP))
						{
							movePlayer(1,0);
							player.setRow(player.getRow()-1);
						}
						
						if(checkWall(1,0,player) && (key.getText().equals("s") || key.getCode() == KeyCode.DOWN))
						{
							movePlayer(-1,0);
							player.setRow(player.getRow()+1);
						}
						
						if (floor[player.getRow()][player.getCol()] == 'E')
						{
							current += 1;
							
							removeFloor();
							addFloor();
							refreshButtons();
						}
						
					}
				});
		
		scan.close();
		   
		//EventHandler handler = new EventHandler
		//txt = new Text(100,100, "I'm The Map Scene!\n Visited " + numVisited + " times");
		
		//root.getChildren().add(txt);
		
		button = new Rectangle(100, 30, Color.RED);
		
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
		
		button.xProperty().set(520);
		button.yProperty().set(20);
		
		root.getChildren().add(button);
		
		button2 = new Rectangle(100, 30, Color.BLUE);
		
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
		
		button2.xProperty().set(520);
		button2.yProperty().set(440);
		
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
				root.getChildren().remove(tiles[i][j]);
		
		root.getChildren().remove(playerPos);
	}
	
	private void addFloor()
	{
		int i, j;
		
		tiles = new Rectangle[floors[current].getFloor().length][floors[current].getFloor()[current].length];
		floor = floors[current].getFloor();
		player = new Player(floors[current]);
		
		for ( i=0; i<tiles.length; i++ )
			for ( j=0; j<tiles[0].length; j++ )
			{
				if ( floor[i][j] == 'X' )
					tiles[i][j] = new Rectangle(tileWidth,tileHeight,Color.BLACK);
				else if ( floor[i][j] == 'T')
					tiles[i][j] = new Rectangle(tileWidth,tileHeight,Color.YELLOW);
				else if ( floor[i][j] == 'E')
					tiles[i][j] = new Rectangle(tileWidth,tileHeight,Color.RED);
				else if ( floor[i][j] == 'B')
					tiles[i][j] = new Rectangle(tileWidth,tileHeight,Color.ORANGE);
				else
					tiles[i][j] = new Rectangle(tileWidth,tileHeight,Color.WHITE);
				
				tiles[i][j].setX((j*tileWidth)-(player.getCol()*tileWidth)+(scene.getWidth()/2)-(tileWidth/2));
				tiles[i][j].setY((i*tileHeight)-(player.getRow()*tileHeight)+(scene.getHeight()/2)-(tileHeight/2));
				
				root.getChildren().add(tiles[i][j]);
			}
		
		playerPos = new Rectangle(tileWidth, tileHeight,Color.GREEN);
		playerPos.setX((scene.getWidth()/2)-(tileWidth/2));
		playerPos.setY((scene.getHeight()/2)-(tileHeight/2));
		root.getChildren().add(playerPos);
	}
	
	private void movePlayer(int row, int col)
	{
		int i, j;
		
		for ( i=0; i<tiles.length; i++ )
			for ( j=0; j<tiles[0].length; j++ )
			{
				tiles[i][j].setX(tiles[i][j].getX()+(col*tileWidth));
				tiles[i][j].setY(tiles[i][j].getY()+(row*tileHeight));
			}
	}
	
	private void refreshButtons()
	{
		button.toFront();
		button2.toFront();
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
