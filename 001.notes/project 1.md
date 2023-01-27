# To do list
+ DONE 创建类：Position(int x, int y) 
包括以下方法：
1) move(int x, int y)
2) getX()
3) getY()
4) constructor: Position(int x, int y)
+ 创建类：Room(Position p, int width, int height)。
1) 三个参数要随机生成；
2) Write an overlap method for the Room class, and reject any generated room that overlaps an existing one.

3) 创建了以下方法：
1) drawRoom(TETile[][] tiles, Position p, int width, int height)
2) drawHallway(TETile[][] tiles, Position p1, Position p2)
3) a helper method: drawLTiles(TETile[][] tiles, Position p1, Position p2, TETile t)

+ 创建类：MapGenerator:
1) 创建变量 existingRooms:将生成的每一个Room存储在一个list里；
2) 创建方法：随机添加门；
3) 创建方法：随机添加player；
+ how to generate turnning hallways?
 1) For each room, randomly generate neighbor rooms that branch off of the current room. Since a hallway is just a width 1 room, this algorithm is capable of generating turning hallways.(from jh's slids) 
+ how to connect rooms with hallways?
  待补充
