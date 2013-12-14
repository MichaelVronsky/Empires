package com.ugiveme.empires.map;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import com.ugiveme.empires.map.tile.FarmLand;
import com.ugiveme.empires.map.tile.Grass;
import com.ugiveme.graphicsengine.Game;
import com.ugiveme.graphicsengine.KeyHandler;

public class Map {

	public static int SCREENXOFFSET = Game.size.width/2;
	public static int SCREENYOFFSET = Game.size.height/2;
	
	public int mapXOffset = SCREENXOFFSET;
	public int mapYOffset = SCREENYOFFSET;
	
	public ArrayList<ArrayList<Tile>> tiles;
	public int firstTileXOffset;
	public int firstTileYOffset;
	
	
	public int mapRenderIndexX;
	public int mapRenderIndexY;
	
	public int screenTileWidth;
	public int screenTileHeight;
	
	public KeyHandler keyHandler;
	
	public Tile selectedTile;
	
	public Tile selectedBuyTile;
	public Rectangle selectedBuyRect;
	public boolean mouseOverSBR;
	
	public Map(KeyHandler keyHandler) {
		
		this.keyHandler = keyHandler;
		
		tiles = new ArrayList<ArrayList<Tile>>();
		
		firstTileXOffset = 0;
		firstTileYOffset = 0;
		
		ArrayList<Tile> newTiles = new ArrayList<Tile>();
		newTiles.add(new Grass(this, 0, 0));
		//newTiles.add(new Grass(0, 15));
		
		tiles.add(newTiles);
		
//		newTiles = new ArrayList<Tile>();
//		newTiles.add(new Grass(15, 0));
//		newTiles.add(new Grass(15, 15));
//		
//		tiles.add(newTiles);
		
		mapRenderIndexX = 0;
		mapRenderIndexY = 0;
		
		screenTileWidth = Game.size.width/Tile.SIZE;
		screenTileHeight = Game.size.height/Tile.SIZE;
		
	}
	
	public void tick() {
		
		mapXOffset = SCREENXOFFSET - (int) Player.x;
		mapYOffset = SCREENYOFFSET - (int) Player.y;
		
		//Adds a row on top
		if (firstTileXOffset + mapXOffset + Tile.SIZE > 0) {System.out.println("xM - New Array Length: " + (tiles.size()+1));
			
			firstTileXOffset -= Tile.SIZE;
			
			ArrayList<Tile> newTiles = new ArrayList<Tile>();
			for (int i=0;i<tiles.get(0).size();i++) {
				System.out.println("Added block " + i + " at x: " + firstTileXOffset + " y: " + (firstTileYOffset + Tile.SIZE*i));
				newTiles.add(Tile.getRandomTile(this, firstTileXOffset, firstTileYOffset + Tile.SIZE*i));
			}
			
			tiles.add(0, newTiles);
			
			
			
		} else if (firstTileYOffset + mapYOffset > 0) {System.out.println("yM - New Array Length: " + (tiles.size()));
		//adds a row to the left	
			firstTileYOffset -= Tile.SIZE;
			
			for (int i=0;i<tiles.size();i++) {
				tiles.get(i).add(0, Tile.getRandomTile(this, firstTileXOffset + Tile.SIZE*i, firstTileYOffset));
			}
			
		} else if (tiles.get(0).size()*Tile.SIZE + mapYOffset + firstTileYOffset < Game.size.width) { System.out.println("yP - New Array Length: " + (tiles.size()));
		//adds a row on botton
			for (int i=0;i<tiles.size();i++) {
				tiles.get(i).add(Tile.getRandomTile(this, firstTileXOffset + Tile.SIZE*i, firstTileYOffset + (tiles.get(i).size())*Tile.SIZE));
			}
			
		} else if (tiles.size()*Tile.SIZE + mapXOffset  + firstTileXOffset < Game.size.width) { System.out.println("xP - New Array Length: " + (tiles.size()));
			//adds a row to the right
			ArrayList<Tile> newTiles = new ArrayList<Tile>();
			for (int i=0;i<tiles.get(0).size();i++) {
				newTiles.add(Tile.getRandomTile(this, firstTileXOffset + Tile.SIZE*tiles.size() , firstTileYOffset + Tile.SIZE*i));
			}
			tiles.add(newTiles);
			
		} else {
			//System.out.println("" + (tiles.size()*Tile.SIZE + mapXOffset  + firstTileXOffset));
		}
		
//		mapRenderIndexX = ((int)Player.x - Tile.SIZE)/Tile.SIZE;
//		mapRenderIndexY = ((int)Player.y - Tile.SIZE) /Tile.SIZE;
		
		//System.out.println("x: " + mapRenderIndexX + "  to x: " + (mapRenderIndexX + screenTileHeight) + "  y: " + mapRenderIndexY + " to y: " + (mapRenderIndexY + screenTileHeight));
		//System.out.println("length: " + tiles.size() + " and " + tiles.get(0).size());
		
		//System.out.println("" + mapYOffset);
		
		
		//checks if the mouse is over the buy dialogue
		mouseOverSBR = false;
		if (selectedBuyRect != null){
			if (selectedBuyRect.contains(keyHandler.getMousePos())) {
				mouseOverSBR = true;
			}
		} else {
			//if it is not, a tile is selected which the mouse is over
			try { //it is surrounded by try/catch just in case, especially in the beginning where the tiles are getting generated
				selectedTile = tiles.get((keyHandler.getMousePos().x - firstTileXOffset - SCREENXOFFSET + (int)Player.x)/Tile.SIZE).get((keyHandler.getMousePos().y - firstTileYOffset - SCREENYOFFSET + (int)Player.y)/Tile.SIZE);
			} catch(Exception e) {}
		}
		
		if (keyHandler.isMouseClicked()) {			
			
			//if the mouse is over the 'buy land' dialogue, buy it
			if (mouseOverSBR) {
				selectedBuyTile.setOwned(true);
				selectedBuyTile = null;
				selectedBuyRect = null;
				mouseOverSBR = false;
			} else {
			
				selectedTile = tiles.get((keyHandler.getMouseClickPoint().x - firstTileXOffset - SCREENXOFFSET + (int)Player.x)/Tile.SIZE).get((keyHandler.getMouseClickPoint().y - firstTileYOffset - SCREENYOFFSET + (int)Player.y)/Tile.SIZE);
	
				//temporarily, if you click on an owned tile, it turns into farmland
				if (selectedTile.isOwned()) {
					tiles.get((selectedTile.mapX-firstTileXOffset)/Tile.SIZE).set((selectedTile.mapY-firstTileYOffset)/Tile.SIZE, new FarmLand(this, selectedTile.mapX, selectedTile.mapY));
					selectedBuyTile = null;
				} else {
					//if the tile is not owned, show the buy dialogue
					selectedBuyTile = selectedTile;
					selectedBuyRect = new Rectangle(mapXOffset + selectedBuyTile.mapX + Tile.SIZE + 20, mapYOffset + selectedBuyTile.mapY + ((Tile.SIZE-30)/2), 150, 30);
				}
			}
			keyHandler.setMouseClicked(false);
			
			System.out.println("clicked at x: " + selectedTile.mapX + " y: " + selectedTile.mapY);
		}
		
		for (ArrayList<Tile> tileList : tiles) {
			for (Tile tile : tileList) {
				tile.tick();
			}
		}
	}
	
	public void render(Graphics g) {
//		for (int i=mapRenderIndexX;i<mapRenderIndexX + screenTileWidth;i++) {
//			for (int k=mapRenderIndexY;k<mapRenderIndexY + screenTileHeight;k++) {
//				try {
//					ArrayList<Tile> jimmy = tiles.get(i);
//					jimmy.get(k).render(g);
//				} catch(Exception e) {}
//			}
//		}
		
		//renders all the tiles on your screen (otherwise, you get EXTREMELY slow FPS)
		for (ArrayList<Tile> tileList : tiles) {
			for (Tile tile : tileList) {
				if (tile.mapX > Player.x - SCREENXOFFSET - Tile.SIZE && tile.mapX < Player.x + SCREENXOFFSET && tile.mapY > Player.y - SCREENYOFFSET - Tile.SIZE && tile.mapY < Player.y + SCREENYOFFSET) {
					tile.render(g);
				}
			}
		}
		
		//the tile your mouse is over
		if (selectedTile != null) {   
			g.setColor(Color.BLACK);
			g.drawRect(mapXOffset + selectedTile.mapX, mapYOffset + selectedTile.mapY, Tile.SIZE, Tile.SIZE);
		}
		
		//If you clicked on an unowned tile, this shows up for you to buy it
		if (selectedBuyTile != null) {
			if (mouseOverSBR) {
				g.setColor(Color.ORANGE);
			} else {
				g.setColor(new Color(250, 125, 0));
			}
			g.fillRect(selectedBuyRect.x, selectedBuyRect.y, selectedBuyRect.width, selectedBuyRect.height);
			g.setColor(Color.BLACK);
			g.drawRect(selectedBuyRect.x, selectedBuyRect.y, selectedBuyRect.width, selectedBuyRect.height);
			g.setFont(new Font("Arial", Font.BOLD, 15));
			g.drawString("Buy land: 100 Gold", selectedBuyRect.x + 10, selectedBuyRect.y + 20);
			g.drawRect(mapXOffset + selectedBuyTile.mapX, mapYOffset + selectedBuyTile.mapY, Tile.SIZE, Tile.SIZE);
		}
	}
	
	/**
	 * determines the location of a tile in the tiles list by the x and y coords
	 * @param tile The tile
	 * @return The point of the location
	 */
	public Point getListLocation(Tile tile) {
		Point point = new Point();
		
		point.x = (tile.mapX - firstTileXOffset)/Tile.SIZE;
		point.y = (tile.mapY - firstTileYOffset)/Tile.SIZE;
		
		return point;
	}
	
	public boolean tileIsOwned(int x, int y) {
		return tiles.get(x).get(y).isOwned();
	}
}
