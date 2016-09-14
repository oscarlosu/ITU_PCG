package DungeonGeneration;

import java.util.ArrayList;

public class Genotype {
	public ArrayList<Room> rooms;
	public ArrayList<Corridor> corridors;	
	public int width;
	public int height;
	
	
	public Genotype(int width, int height) {
		rooms = new ArrayList<Room>();
		corridors = new ArrayList<Corridor>();
		this.width = width;
		this.height = height;
	}
	public Genotype(int width, int height, ArrayList<Room> rooms, ArrayList<Corridor> corridors) {
		this.rooms = rooms;
		this.corridors = corridors;
		this.width = width;
		this.height = height;
	}
	
	public int[] Serialize() {
		// Initialize array
		int size = rooms.size() * 4 + corridors.size() * 4;
		int genotype[] = new int[size + 2];
		// Initialize index
		int index = 0;
		// Save # rooms
		genotype[index] = rooms.size();
		++index;
		// Save room data
		for(int i = 0; i < rooms.size(); ++i) {
			genotype[index] = rooms.get(i).position.x;
			++index;
			genotype[index] = rooms.get(i).position.y;
			++index;
			genotype[index] = rooms.get(i).width;
			++index;
			genotype[index] = rooms.get(i).height;
			++index;			
		}
		// Save # rooms
		genotype[index] = corridors.size();
		++index;
		// Save room data
		for(int i = 0; i < corridors.size(); ++i) {
			genotype[index] = corridors.get(i).start.x;
			++index;
			genotype[index] = corridors.get(i).start.y;
			++index;
			genotype[index] = corridors.get(i).end.x;
			++index;
			genotype[index] = corridors.get(i).end.y;
			++index;			
		}
		return genotype;
	}
	
	public Genotype Crossover(Genotype other){
		// TODO
		return new Genotype(0, 0);
	}
	
	public Genotype Mutate() {
		// TODO
		return new Genotype(0, 1);
	}
}
