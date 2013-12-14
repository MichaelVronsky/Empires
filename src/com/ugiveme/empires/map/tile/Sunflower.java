package com.ugiveme.empires.map.tile;

import java.awt.Image;

import com.ugiveme.empires.map.Map;
import com.ugiveme.empires.map.Tile;
import com.ugiveme.graphicsengine.spritesheet.SpriteSheet;

public class Sunflower extends Tile{

	public static final Image SUNFLOWER = SpriteSheet.loadImage("images/Sunflower.png", 0, 0, IMAGESIZE, IMAGESIZE, SCALE);
	
	public Sunflower(Map map, int mapX, int mapY) {
		super(SUNFLOWER, map, mapX, mapY);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	
}
