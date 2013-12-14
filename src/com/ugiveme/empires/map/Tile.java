 package com.ugiveme.empires.map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import com.ugiveme.empires.entity.Entity;
import com.ugiveme.empires.map.tile.FarmLand;
import com.ugiveme.empires.map.tile.Flowers;
import com.ugiveme.empires.map.tile.Grass;
import com.ugiveme.empires.map.tile.Mushroom;
import com.ugiveme.empires.map.tile.Strawberry;
import com.ugiveme.empires.map.tile.Sunflower;
import com.ugiveme.empires.map.tile.Tree;

public abstract class Tile {

	public static final int IMAGESIZE = 15;
	public static final int SCALE = 3;
	public static final int SIZE = IMAGESIZE * SCALE;
	
	
	public Image image;
	
	public int mapX; //x value in the map
	public int mapY;
	
	public int listX; //index in the array
	public int listY;
	
	private boolean owned;
	
	private Map map;
	
	public Tile(Image image, Map map, int mapX, int mapY) {
		this.image = image;
		
		this.mapX = mapX;
		this.mapY = mapY;
		
		this.owned = false;
		
		this.map = map;
	}
	
	/**
	 * sets the image of the Tile
	 * @param image the image to replace the current one with
	 */
	public void setImage(Image image) { //sets the current image
		this.image = image;
	}
	
	public abstract void tick();
	
	public void render(Graphics g) {
		g.drawImage(image, map.mapXOffset + mapX, map.mapYOffset + mapY, null);
		
		if (owned) { //if owned, a blue rectangle appears around it on sides where there is unowned land
			g.setColor(Color.RED);
			Point listPoint = map.getListLocation(this);
			
			if (!map.tileIsOwned(listPoint.x, listPoint.y-1)) //on top
				g.drawLine(map.mapXOffset + mapX, map.mapYOffset + mapY+1, map.mapXOffset + mapX + Tile.SIZE, map.mapYOffset + mapY+1);
			if (!map.tileIsOwned(listPoint.x, listPoint.y+1)) //on botton
				g.drawLine(map.mapXOffset + mapX, map.mapYOffset + mapY + Tile.SIZE-1, map.mapXOffset + mapX + Tile.SIZE, map.mapYOffset + mapY + Tile.SIZE-1);
			if (!map.tileIsOwned(listPoint.x+1, listPoint.y)) //on right
				g.drawLine(map.mapXOffset + mapX + Tile.SIZE-1, map.mapYOffset + mapY, map.mapXOffset + mapX + Tile.SIZE-1, map.mapYOffset + mapY + Tile.SIZE-1);
			if (!map.tileIsOwned(listPoint.x-1, listPoint.y)) //on right
				g.drawLine(map.mapXOffset + mapX-1, map.mapYOffset + mapY, map.mapXOffset + mapX-1, map.mapYOffset + mapY + Tile.SIZE-1);
			
			//g.drawRect(map.mapXOffset + mapX, map.mapYOffset + mapY, Tile.SIZE-1, Tile.SIZE-1);
		}
	}
	
	//public abstract void interact(Entity entity);
	
	public static Tile getRandomTile(Map map, int x, int y) { //gets random tile
		
		if (Math.random() < 0.92) {
			return new Grass(map, x, y);
		} else if (Math.random() < 0.25){
			return new Flowers(map, x, y);
		} else if (Math.random() < 0.25) {
			return new Tree(map, x, y);
		}  else if (Math.random() < 0.25) {
			return new Sunflower(map, x, y);
		} else if (Math.random() < 0.3) {
			return new Mushroom(map, x, y);
		} else {
			return new Strawberry(map, x, y);
		}
	}
	
	public boolean isOwned() {
		return owned;
	}
	
	public void setOwned(boolean owned) {
		this.owned = owned;
	}
}
