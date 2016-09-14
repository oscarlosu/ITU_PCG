package DungeonGeneration;

public class Room {
	public Point position;
	public int width;
	public int height;
	
	public Room() {
		this.position = new Point(0, 0);
		this.width = 1;
		this.height = 1;
	}
	public Room(Point position, int width, int height) {
		this.position = position;
		this.width = width;
		this.height = height;
	}
}
