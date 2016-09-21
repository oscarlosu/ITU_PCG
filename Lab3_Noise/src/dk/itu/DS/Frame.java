package dk.itu.DS;

import java.awt.Dimension;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame{
	private static int [][] map;
	public Frame(){
		
	}
	
	JFrame frame = new JFrame();
	
	/**
	 * Method used to visualize heightmap by converting heights to RGB colours.
	 * @return
	 */
	private static JPanel drawPanel(int tiles) { 
		
				return new JPanel() {
					public void paint(java.awt.Graphics g){
						super.paint(g);
						for(int xOffset = 0; xOffset < tiles * map.length; xOffset += map.length) {
							for(int yOffset = 0; yOffset < tiles * map.length; yOffset += map.length) {
								// Tile
								for(int y = 0; y < map.length; y++){
									for(int x = 0; x < map.length; x++){
										int value = map[x][y];
										if(value > 255){
											value = 255;
										}else if(value < 0){
											value = 0;
										}
										java.awt.Color color = new java.awt.Color(value, value, value);
										g.setColor(color);
										g.fillRect(xOffset + x, yOffset + y, 1, 1);
									}
								}
							}
						}
					}
				};
	
	}
	

	/**
	 * The Main method.
	 */
	public static void main(String[] args){
		int seed = new Random().nextInt();
		seed = -838066981;
		System.out.println("Seed: " + seed);
		int tiles = 3;
		System.out.println("Tiles: " + tiles + "x" + tiles);
		
		
		DiamondSquare ds = new DiamondSquare();		
		map = ds.buildMap(8, seed, 128, 0.7);	
		JFrame frame = new Frame();		
		JPanel panel = drawPanel(tiles);
		panel.setPreferredSize(new Dimension(tiles * map.length, tiles * map.length));
		frame.setContentPane(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
