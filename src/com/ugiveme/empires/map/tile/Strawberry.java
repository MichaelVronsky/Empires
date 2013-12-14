package com.ugiveme.empires.map.tile;

import java.awt.Image;

import com.ugiveme.empires.map.Map;
import com.ugiveme.empires.map.Tile;
import com.ugiveme.graphicsengine.spritesheet.SpriteSheet;

public class Strawberry extends Tile{

	public static final Image STRAWBERRY = SpriteSheet.loadImage("images/Starberry.png", 0, 0, IMAGESIZE, IMAGESIZE, SCALE);
	
	public Strawberry(Map map, int mapX, int mapY) {
		super(STRAWBERRY, map, mapX, mapY);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	
}
