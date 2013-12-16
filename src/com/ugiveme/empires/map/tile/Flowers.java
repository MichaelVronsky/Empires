package com.ugiveme.empires.map.tile;

import java.awt.Image;

import com.ugiveme.empires.map.Map;
import com.ugiveme.empires.map.Tile;
import com.ugiveme.graphicsengine.spritesheet.SpriteSheet;

public class Flowers extends Tile{

	public static final Image FLOWERS = SpriteSheet.loadImage("images/Flowers.png", 0, 0, IMAGESIZE, IMAGESIZE, SCALE);
	
	public Flowers(Map map, int mapX, int mapY) {
		super(FLOWERS, map, mapX, mapY);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	
}
