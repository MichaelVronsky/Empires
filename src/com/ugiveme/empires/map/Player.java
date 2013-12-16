package com.ugiveme.empires.map;

import java.awt.Graphics;
import java.awt.Image;

import com.ugiveme.empires.entity.mob.Mob;
import com.ugiveme.graphicsengine.Game;
import com.ugiveme.graphicsengine.KeyHandler;
import com.ugiveme.graphicsengine.spritesheet.SpriteSheet;

public class Player extends Mob{

	public static final Image[][] PLAYERTILESET = SpriteSheet.loadImages("images/PlayerAnimated.png", 15, 28, 4, 5, 2);
	
	public static final int PLAYERWIDTH = PLAYERTILESET[0][0].getWidth(null);
	public static final int PLAYERHEIGHT = PLAYERTILESET[0][0].getHeight(null);
	
	public static final int XOFFSET = Game.size.width/2 - PLAYERWIDTH/2;
	public static final int YOFFSET = Game.size.height/2 - PLAYERHEIGHT/2;
	
	public static final String UPKEY = "w";
	public static final String DOWNKEY = "s";
	public static final String LEFTKEY = "a";
	public static final String RIGHTKEY = "d";
	
	
	public static final int UP = 0;
	public static final int DOWN = 1;
	public static final int LEFT = 2;
	public static final int RIGHT = 3;
	
	public int direction = DOWN;
	
	public int picNum;
	public int picDir;
	
	public int newPicTime;
	public int newPicFrame;
	
	private KeyHandler keyHandler;
	
	private double speed;
	private boolean isMoving;
	
	
	
	public Player(Map map, KeyHandler keyHandler) {
		super(map, PLAYERTILESET[DOWN][2], 20, 0, 0, PLAYERWIDTH, PLAYERHEIGHT);
		this.keyHandler = keyHandler;
		
		this.speed = 7;
		
		this.picNum = 0;
		this.picDir = 1;
		
		this.newPicTime = 6;
		this.newPicFrame = 0;
	}
	
	public void tick() {
		
		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(PLAYERTILESET[direction][picNum], XOFFSET, YOFFSET, null);
	}

	@Override
	public void move() {
		isMoving = false;
		if (keyHandler.isPressed(LEFTKEY)) {
			x -= speed;
			direction = LEFT;
			isMoving = true;
		}
		if (keyHandler.isPressed(RIGHTKEY)) {
			x += speed;
			direction = RIGHT;
			isMoving = true;
		}
		if (keyHandler.isPressed(UPKEY)) {
			y -= speed;
			direction = UP;
			isMoving = true;
		}
		if (keyHandler.isPressed(DOWNKEY)) {
			y += speed;
			direction = DOWN;
			isMoving = true;
		}
		
		if (isMoving) {
			if (newPicFrame >= newPicTime) {
				picNum += picDir;
				if (picNum == PLAYERTILESET[0].length - 1 || picNum == 0) {
					picDir = -picDir;
				}
				
				newPicFrame = 0;
			} else {
				newPicFrame++;
			}
		} else {
			picNum = 2;
		}
	}
	
}
