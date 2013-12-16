package com.ugiveme.empires.map.tile;

import java.awt.Image;

import com.ugiveme.empires.map.Map;
import com.ugiveme.empires.map.Tile;
import com.ugiveme.graphicsengine.spritesheet.SpriteSheet;

public class Tree extends Tile{

	public static final Image TREE = SpriteSheet.loadImage("images/Tree.png", 0, 0, IMAGESIZE, IMAGESIZE, SCALE);
	
	public Tree(Map map, int mapX, int mapY) {
		super(TREE, map, mapX, mapY);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	
}
