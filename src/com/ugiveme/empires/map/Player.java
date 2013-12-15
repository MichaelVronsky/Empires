package com.ugiveme.empires.map;

import java.awt.Graphics;
import java.awt.Image;

import com.ugiveme.empires.entity.Mob;
import com.ugiveme.graphicsengine.Game;
import com.ugiveme.graphicsengine.KeyHandler;
import com.ugiveme.graphicsengine.spritesheet.SpriteSheet;

public class Player extends Mob{

	public static final Image PLAYERIMAGE = SpriteSheet.loadImage("images/SpriteSheetSimple.png", 0, 0, 7, 14, 4);
	
	public static final int XOFFSET = Game.size.width/2 - PLAYERIMAGE.getWidth(null)/2;
	public static final int YOFFSET = Game.size.height/2 - PLAYERIMAGE.getHeight(null)/2;
	
	public static final String UPKEY = "w";
	public static final String DOWNKEY = "s";
	public static final String LEFTKEY = "a";
	public static final String RIGHTKEY = "d";
	
	public static double x = 0;
	public static double y = 0;
	
	private KeyHandler keyHandler;
	
	private double speed;
	
	public Player(Map map, KeyHandler keyHandler) {
		super(map, PLAYERIMAGE, 0, 0, 0, 0);
		this.keyHandler = keyHandler;
		
		speed = 10;
	}
	
	public void tick() {
		
		if (keyHandler.isPressed(UPKEY)) {
			y -= speed;
		}
		if (keyHandler.isPressed(DOWNKEY)) {
			y += speed;
		}
		if (keyHandler.isPressed(LEFTKEY)) {
			x -= speed;
		}
		if (keyHandler.isPressed(RIGHTKEY)) {
			x += speed;
		}
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(PLAYERIMAGE, XOFFSET, YOFFSET, null);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
	
}
