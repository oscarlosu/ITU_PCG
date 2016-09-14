package dk.itu.mario.entries;

import java.util.Random;

import dk.itu.mario.MarioInterface.GamePlay;
import dk.itu.mario.MarioInterface.LevelInterface;
import dk.itu.mario.engine.sprites.Enemy;
import dk.itu.mario.engine.sprites.SpriteTemplate;
import dk.itu.mario.level.Level;

public class MyLevel extends Level implements LevelInterface {

	public MyLevel(int width, int height, GamePlay playerMetrics) {
		super(width, height);
		create();
		
	}
	
	public void create() {
		int floor = height - 1 - new Random().nextInt(8);
		xExit = this.width - 10;
		yExit = floor;
		for(int x = 0; x < this.width; ++x) {
			for(int y = 0; y < this.height; ++y) {
				if(y > floor) {
					setBlock(x, y, Level.GROUND);
				} else  if(y == floor) {
					setBlock(x, y, Level.HILL_TOP);
				} else if(y < floor) {
					setBlock(x, y, Level.COIN);
				}
			}
			setSpriteTemplate(50, floor - 1, new SpriteTemplate(Enemy.ENEMY_RED_KOOPA, false));
		}
	}

}
