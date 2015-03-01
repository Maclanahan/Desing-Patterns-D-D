package Map;

public class LURoom extends Room
{
   
   public LURoom(int x, int y, Room rooms[][])
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
     char[][] temp =  {{'X','X','X','X',' ',' ','X','X','X','X'},
                       {'X','X','X','X',' ',' ','X','X','X','X'},
                       {'X','X','X',' ',' ',' ','X','X','X','X'},
                       {' ',' ',' ',' ',' ',' ','X','X','X','X'},
                       {'X','X','X','X','X','X','X','X','X','X'},
                       {'X','X','X','X','X','X','X','X','X','X'},
                       {'X','X','X','X','X','X','X','X','X','X'}};
               
     _tile = temp;
   }
   
   private void setBounds(Room rooms[][])
   {
      _up = 0;
      _right = 1;
      _down = 1;
      _left = 0;
   }   
}