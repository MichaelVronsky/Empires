 package com.ugiveme.empires.map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.HashMap;

import com.ugiveme.empires.entity.Entity;
import com.ugiveme.empires.entity.Mob.Zombie;
import com.ugiveme.empires.inventory.Inventory;
import com.ugiveme.empires.item.ItemGroup;
import com.ugiveme.empires.item.ItemRock;
import com.ugiveme.empires.main.GameScreen;
import com.ugiveme.empires.map.tile.FarmLand;
import com.ugiveme.empires.map.tile.Flowers;
import com.ugiveme.empires.map.tile.Grass;
import com.ugiveme.empires.map.tile.Mushroom;
import com.ugiveme.empires.map.tile.Strawberry;
import com.ugiveme.empires.map.tile.Sunflower;
import com.ugiveme.empires.map.tile.Tree;

public abstract class Tile implements Inventory{

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
	
	private HashMap<Integer, ItemGroup> inventory;
	
	
	public Tile(Image image, Map map, int mapX, int mapY) {
		this.image = image;
		
		this.mapX = mapX;
		this.mapY = mapY;
		
		this.owned = false;
		
		this.map = map;
		
		this.inventory = new HashMap<Integer, ItemGroup>(0);
		
		if (Math.random() < 0.005) {
			GameScreen.addMob(new Zombie(map, mapX, mapY));
		}
	}
	
	/**
	 * sets the image of the Tile
	 * @param image the image to replace the current one with
	 */
	public void setImage(Image image) { //sets the current image
		this.image = image;
	}
	
	public void tick() {
        for (int i = 0; i < inventory.size(); i++) {
        	if (inventory.get(i) != null) {
        		inventory.get(i).tick();
        		inventory.get(i).getItemGround(mapX + map.mapXOffset, mapY + map.mapYOffset);
        	}
        }
	}
	
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
		
		for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i) != null) {
                    try {
                    	inventory.get(i).getItemGround(mapX + map.mapXOffset, mapY + map.mapYOffset).render(g);
                    } catch (Exception e) {
                    	e.printStackTrace();
                    	System.exit(1);
                    }
            }
		}
	}
	
	//public abstract void interact(Entity entity);
	
	public static Tile getRandomTile(Map map, int x, int y) { //gets random tile
		
		Tile tile;
		
		if (Math.random() < 0.92) {
			tile = new Grass(map, x, y);
		} else if (Math.random() < 0.25){
			tile = new Flowers(map, x, y);
		} else if (Math.random() < 0.25) {
			tile = new Tree(map, x, y);
		}  else if (Math.random() < 0.25) {
			tile = new Sunflower(map, x, y);
		} else if (Math.random() < 0.3) {
			tile = new Mushroom(map, x, y);
		} else {
			tile = new Strawberry(map, x, y);
		}
		
		return tile;
	}
	
	public boolean isOwned() {
		return owned;
	}
	
	public void setOwned(boolean owned) {
		this.owned = owned;
	}
	
	 public int getInventorySize() {
         return 64;
	 }
	 
	 public ItemGroup getItemInSlot(int slot) {
		 return inventory.get(slot);
	 }
	 
	 public void setItemInSlot(int slot, ItemGroup item) {
		 inventory.put(slot, item);
	 }
}
