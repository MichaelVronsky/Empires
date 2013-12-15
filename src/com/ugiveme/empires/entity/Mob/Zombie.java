package com.ugiveme.empires.entity.Mob;

import java.awt.Image;

import com.ugiveme.empires.map.Map;
import com.ugiveme.graphicsengine.spritesheet.SpriteSheet;

public class Zombie extends OffensiveMob{

	public static final Image ZOMBIE = SpriteSheet.loadImage("images/Zombie.png", 4);
	
	public Zombie(Map map, int x, int y) {
		super(map, ZOMBIE, 20, x, y, ZOMBIE.getWidth(null), ZOMBIE.getHeight(null));
		// TODO Auto-generated constructor stub
	}

}
