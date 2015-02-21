public class LURRoom extends Room
{
   
   public LURRoom(int x, int y, Room rooms[][])
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
                       {'X','X','X','X',' ',' ','X','X','X','X'},
                       {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                       {'X','X','X','X','X','X','X','X','X','X'},
                       {'X','X','X','X','X','X','X','X','X','X'},
                       {'X','X','X','X','X','X','X','X','X','X'}};
               
     _tile = temp;
   }
   
   private void setBounds(Room rooms[][])
   {
      _up = 0;
      _right = 0;
      _down = 1;
      _left = 0;
   }   
}