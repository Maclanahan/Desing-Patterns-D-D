package rooms;

public class URDRoom extends Room
{
   
   public URDRoom(int x, int y, Room rooms[][])
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
                       {'X','X','X','X',' ',' ','X','X','X'},
                       {'X','X','X','X',' ','X','X','X','X'},
                       {'X','X','X','X',' ','X','X','X','X'}};
               
     _tile = temp;
   }
   
   private void setBounds(Room rooms[][])
   {
      _up = 0;
      _right = 0;
      _down = 0;
      _left = 1;
   }   
   
   public void setType(char type)
   {   
	   _type = type;
	   
	   _tile[3][3] = type;
   }
}
