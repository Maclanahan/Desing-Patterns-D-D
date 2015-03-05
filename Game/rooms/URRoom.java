package rooms;

public class URRoom extends Room
{
   
   public URRoom(int x, int y, Room rooms[][])
   {  
      super(x,y,rooms);
   }
   
   protected void init(Room rooms[][])
   {
      setBounds(rooms);
      createRoom();
   }
   
   private void createRoom()
   {
     char[][] temp =  {{'X','X','X','X',' ','X','X','X','X'},
                       {'X','X','X','X',' ','X','X','X','X'},
                       {'X','X','X','X',' ',' ','X','X','X'},
                       {'X','X','X','X',' ',' ',' ',' ',' '},
                       {'X','X','X','X','X','X','X','X','X'},
                       {'X','X','X','X','X','X','X','X','X'},
                       {'X','X','X','X','X','X','X','X','X'}};
               
     _tile = temp;
   }
   
   private void setBounds(Room rooms[][])
   {
      _up = 0;
      _right = 0;
      _down = 1;
      _left = 1;
   } 
   
   public void setType(char type)
   {   
	   _type = type;
	   
	   _tile[3][3] = type;
   }
}