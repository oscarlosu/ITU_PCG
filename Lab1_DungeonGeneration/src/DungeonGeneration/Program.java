package DungeonGeneration;

import java.util.ArrayList;

public class Program {

	public static void main(String[] args) {		
		ArrayList<Room> rooms = new ArrayList<Room>();
		Room room = new Room(new Point(1, 3), 3, 3);
		//rooms.add(room);
		room = new Room(new Point(8, 1), 4, 4);
		//rooms.add(room);
		
		ArrayList<Corridor> corridors = new ArrayList<Corridor>();
		Corridor corridor = new Corridor(new Point(0, 0), new Point(7, 5));
		corridors.add(corridor);

		
		Genotype g = new Genotype(20, 20, rooms, corridors);
		int array[] = g.Serialize();
		System.out.println("Genome: ");
		for(int i = 0; i < array.length; ++i) {
			System.out.print(array[i]);
			System.out.print(' ');
		}
		System.out.println("\nMap: ");
		Phenotype p = new Phenotype(g);
		for(int x = 0; x < p.symbols.length; ++x) {
			for(int y = 0; y < p.symbols[x].length; ++y) {
				System.out.print(p.symbols[y][x]);
			}
			System.out.print('\n');
		}
		
	}
}
