package DungeonGeneration;

import java.util.ArrayList;

import Resources.AStar;

public class Phenotype {
	public char symbols[][];
	
	public char emptySymbol = '·';
	public char wallSymbol = '#';
	
	private Genotype genotype;
	
	public Phenotype(Genotype genotype) {
		this.genotype = genotype;
		
		symbols = new char[genotype.width][genotype.height];
		// Fill map
		for(int x = 0; x < genotype.width; ++x) {
			for(int y = 0; y < genotype.height; ++y) {
				// 
				symbols[x][y] = wallSymbol;
			}
		}
		// Draw rooms
		for(int i = 0; i < genotype.rooms.size(); ++i) {
			Room room = genotype.rooms.get(i);
			for(int x = room.position.x; x < room.position.x + room.width; ++x) {
				for(int y = room.position.y; y < room.position.y + room.height; ++y) {
					// Clear inside room
					symbols[x][y] = emptySymbol;
				}
			}
		}
		// Draw corridors
		boolean passable[][] = new boolean[genotype.width][genotype.height];
		for(int x = 0; x < genotype.width; ++x) {
			for(int y = 0; y < genotype.height; ++y) {
				passable[x][y] = true;
			}
		}
		for(int i = 0; i < genotype.corridors.size(); ++i) {
			Corridor corridor = genotype.corridors.get(i);
			// Calculate path
			ArrayList<Point> path = new ArrayList<Point>();
			AStar.distance(passable, corridor.start.x, corridor.start.y, corridor.end.x, corridor.end.y, path);
			// Modify map
			for(Point p : path) {
				symbols[p.x][p.y] = emptySymbol;
			}
		}
	}
}
