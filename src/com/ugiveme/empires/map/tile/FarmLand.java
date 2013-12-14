package com.ugiveme.empires.map.tile;

import java.awt.Image;

import com.ugiveme.empires.map.Map;
import com.ugiveme.empires.map.Tile;
import com.ugiveme.graphicsengine.spritesheet.SpriteSheet;

public class FarmLand extends Tile {

	public static final Image[] TILESETFARMLAND = new Image[] {
		SpriteSheet.loadImage("images/TilesetFarmland.png", 0, 0, 15, 15, SCALE),
		SpriteSheet.loadImage("images/TilesetFarmland.png", 16, 0, 15, 15, SCALE),
		SpriteSheet.loadImage("images/TilesetFarmland.png", 32, 0, 15, 15, SCALE),
		SpriteSheet.loadImage("images/TilesetFarmland.png", 48, 0, 15, 15, SCALE),
		SpriteSheet.loadImage("images/TilesetFarmland.png", 64, 0, 15, 15, SCALE)
	};
	
	public static final int STAGE_SOIL = 0; // soil
	public static final int STAGE_BEGINNING = 1; // no green
	public static final int STAGE_GROWING = 2; // green starts to appear
	public static final int STAGE_FINALIZING = 3;
	public static final int STAGE_READY = 4;
	
	public static final int GROWCHANCE = 240;
	
	public int currentStage;
	
	public FarmLand(Map map, int x, int y) {
		super(TILESETFARMLAND[0], map, x, y);
		
		currentStage = 0;
		setOwned(true);
	}

	@Override
	public void tick() {
		
		if (currentStage != STAGE_READY){
			if (Math.floor(Math.random()*GROWCHANCE) == 0) {
				currentStage++;
				setImage(TILESETFARMLAND[currentStage]);
			}
		}
	}
	
}
