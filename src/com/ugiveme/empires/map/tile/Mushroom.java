package com.ugiveme.empires.map.tile;

import java.awt.Image;

import com.ugiveme.empires.map.Map;
import com.ugiveme.empires.map.Tile;
import com.ugiveme.graphicsengine.spritesheet.SpriteSheet;

public class Mushroom extends Tile{

	public static final Image MUSHROOM = SpriteSheet.loadImage("images/Mushroom.png", 0, 0, IMAGESIZE, IMAGESIZE, SCALE);
	
	public Mushroom(Map map, int mapX, int mapY) {
		super(MUSHROOM, map, mapX, mapY);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	
}
