package com.ugiveme.empires.entity.mob;

import java.awt.Image;

import com.ugiveme.empires.main.GameScreen;
import com.ugiveme.empires.map.Map;
import com.ugiveme.empires.map.Tile;

public abstract class OffensiveMob extends Mob{

	public static final int RANGERADIUS = Tile.SIZE*20;
	//The block radius in which it goes towards the target mob
	public static final int DAMAGERADIUS = 20;
	
	
	private Mob targetMob;
	
	private boolean targetMobInRange;
	
	private float dx;
	private float dy;
	
	private int speed;
	
	private int damageFrame;
	private int damageTime;
	
	/**
	 * 
	 * The offensive mob class defines any offensive mob, like the zombie. 
	 * They follow the player if he is in range
	 * 
	 * @param map The map it is rendered on
	 * @param image the image to be rendered with
	 * @param health health
	 * @param x x (not including offset)
	 * @param y y (not including offset)
	 * @param width the width of the mob
	 * @param height the height of the mob
	 */
	public OffensiveMob(Map map, Image image, int health, float x, float y,
			int width, int height) {
		super(map, image, health, x, y, width, height);
		
		targetMob = GameScreen.getPlayer();
		targetMobInRange = false;
		//temporarily it is always player. might change
		
		speed = 1;
		
		this.damageFrame = 30;
		this.damageTime = 0;
	}
	
	@Override
	public void tick() {
		if (targetMob != null && !targetMob.isDead()) {
			if (Math.abs(targetMob.x - x) < RANGERADIUS && Math.abs(targetMob.y - y) < RANGERADIUS) {
				targetMobInRange = true;
			} else {
				targetMobInRange = false;
			}
			
			if (targetMobInRange) {
				double angle = Math.toDegrees(Math.atan2((targetMob.x-x), (targetMob.y-y)));
				//EDWARD DO NOT FORGET THIS IS IN RADIANS
				
				dx = (float) Math.sin(Math.toRadians(angle))*speed;
				dy = (float) Math.cos(Math.toRadians(angle))*speed;
			}
			
			
			if (Math.abs(targetMob.x - x) < DAMAGERADIUS && Math.abs(targetMob.y - y) < DAMAGERADIUS) {
				if (++damageTime >= damageFrame) {
					targetMob.hurt(1);
					damageTime = 0;
				}
			}
			
		} else {
			
			//TODO put code here so that it walks randomly
			//It can't walk completely randomly, that would be weird
			
			
			
		}
		
		
	}
	
	@Override
	public void move() {
		if (targetMob != null && targetMobInRange) {
			x += dx;
			y += dy;
		}
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
}
