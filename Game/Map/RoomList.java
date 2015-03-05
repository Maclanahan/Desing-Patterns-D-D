package Map;
import rooms.*;

public class RoomList
{
   private static final int ROOM_AMOUNT = 15;
   private Room[] _list = new Room[ROOM_AMOUNT];
   private Room[][] _rooms;
   private int _x, _y;
   
   public RoomList(int x, int y, Room[][] rooms)
   {  
      _rooms = rooms;
      _x = x;
      _y = y;
      
      _list[0] = new URoom(x,y,rooms);
      _list[1] = new RRoom(x,y,rooms);
      _list[2] = new DRoom(x,y,rooms);
      _list[3] = new LRoom(x,y,rooms);
      _list[4] = new URRoom(x,y,rooms);
      _list[5] = new RDRoom(x,y,rooms);
      _list[6] = new DLRoom(x,y,rooms);
      _list[7] = new LURoom(x,y,rooms);
      _list[8] = new UDRoom(x,y,rooms);
      _list[9] = new LRRoom(x,y,rooms);
      _list[10] = new URDRoom(x,y,rooms);
      _list[11] = new RDLRoom(x,y,rooms);
      _list[12] = new DLURoom(x,y,rooms);
      _list[13] = new LURRoom(x,y,rooms);
      _list[14] = new URDLRoom(x,y,rooms);
   }
   
   public Room getRoom(int up, int right, int down, int left)
   {
      int i;
      
      Room room = new EmptyRoom(_x,_y,_rooms);
      
      for ( i=0; i<ROOM_AMOUNT; i++ )
         if ( _list[i].getUp() == up &&
              _list[i].getRight() == right &&
              _list[i].getDown() == down &&
              _list[i].getLeft() == left )
                  return _list[i];
      
      return room;
   }
}
