package com.ugiveme.empires.map.tile;

import java.awt.Image;

import com.ugiveme.empires.map.Map;
import com.ugiveme.empires.map.Tile;
import com.ugiveme.graphicsengine.spritesheet.SpriteSheet;

public class Grass extends Tile{

	public static final Image GRASS = SpriteSheet.loadImage("images/Grass.png", 0, 0, IMAGESIZE, IMAGESIZE, SCALE);
	
	public Grass(Map map, int mapX, int mapY) {
		super(GRASS, map, mapX, mapY);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	
}
