package dk.itu.DS;

import java.util.Random;

public class DiamondSquare {
	
	/**
	 * This is the method which should be used to construct the heightmap using the Diamond Square
	 * algorithm.
	 * @param iterations How many iterations to run the Diamond Square algorithm, influences the size of the height map.
	 * @param seed The height to seed the four corners of the first square with.
	 * @param variation The variation to used for the randomized heights.
	 * @param roughness The roughness factor to use to decrease variation over time.
	 * @return
	 */
	public int[][] buildMap(int iterations, int seed, int variation, double roughness)
	{
		int sizeSqrt = (int)Math.pow(2, iterations);
		int[][] map = new int[sizeSqrt][sizeSqrt]; //Just used as an example value to initialize array. See slides for how to properly initialize array.
		
		Random rng = new Random(seed);
		// Start with corners		
		map[0][0] = variation;
		map[sizeSqrt - 1][0] = variation;
		map[0][sizeSqrt - 1] = variation;
		map[sizeSqrt - 1][sizeSqrt - 1] = variation;
		// Diamond-Square
		double currVar = variation;
		for(int i = 0; i < iterations; ++i) {
			int step = (sizeSqrt) / (int)Math.pow(2, i);
			int halfStep = step / 2;
			//System.out.println("step " + step + " halfStep " + halfStep);
			// Square
			for(int x = halfStep; x < sizeSqrt; x += step) {
				for(int y = halfStep; y < sizeSqrt; y += step) {
					Square(x, y, halfStep, (int)((rng.nextDouble() * currVar * 2) - currVar), map);
				}
			}
			// Diamond
			for(int x = 0; x < sizeSqrt; x += halfStep) {
				for(int y = (x + halfStep) % step; y < sizeSqrt; y += step) {
					Diamond(x, y, halfStep, (int)((rng.nextDouble() * currVar * 2) - currVar), map);
				}
			}
			// Decrease variation
			currVar /= Math.pow(2, roughness);
		}
		
		return map;
	}

	
	private void Square(int x, int y, int stepSize, int offset, int[][] map) {
		// a b
		//  x 
		// c d
		int maxX = map.length - 1;
		int maxY = map[0].length - 1;
		int a = map[Wrap(x - stepSize, 0, maxX)][Wrap(y - stepSize, 0, maxY)];
		int b = map[Wrap(x + stepSize, 0, maxX)][Wrap(y - stepSize, 0, maxY)];
		int c = map[Wrap(x - stepSize, 0, maxX)][Wrap(y + stepSize, 0, maxY)];
		int d = map[Wrap(x + stepSize, 0, maxX)][Wrap(y + stepSize, 0, maxY)];
		int value = (a + b + c + d) / 4 + offset;		
		map[x][y] = value;
		//System.out.println(value);
	}
	
	private void Diamond(int x, int y, int stepSize, int offset, int[][] map) {
		//  a 
		// bxc
		//  d 
		int maxX = map.length - 1;
		int maxY = map[0].length - 1;
		int a = map[Wrap(x, 0, maxX)][Wrap(y - stepSize, 0, maxY)];
		int b = map[Wrap(x - stepSize, 0, maxX)][Wrap(y, 0, maxY)];
		int c = map[Wrap(x + stepSize, 0, maxX)][Wrap(y, 0, maxY)];
		int d = map[Wrap(x, 0, maxX)][Wrap(y + stepSize, 0, maxY)];
		int value = (a + b + c + d) / 4 + offset;		
		map[x][y] = value;
		//System.out.println(value);
	}
	
	
	private int Wrap(int val, int min, int max) {
		if(val < min) {
			int dif = min - val;
			//System.out.println(val + " -> " + (max - dif + 1));
			return max - dif + 1;
		} else if (val > max) {
			int dif = val - max;
			//System.out.println(val + " -> " + (min + dif - 1));
			return min + dif - 1;
		} else {
			return val;
		}
	}
}
