package dk.itu.mario.entries;

import dk.itu.mario.MarioInterface.GamePlay;
import dk.itu.mario.MarioInterface.LevelGenerator;
import dk.itu.mario.MarioInterface.LevelInterface;

public class MyLevelGenerator implements LevelGenerator {

	@Override
	public LevelInterface generateLevel(GamePlay playerMetrics) {
		return new MyLevel(320, 15, playerMetrics);
	}

	@Override
	public LevelInterface generateLevel(String detailedInfo) {
		// TODO Auto-generated method stub
		return null;
	}

}
