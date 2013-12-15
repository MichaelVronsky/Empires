package com.ugiveme.empires.entity.Mob;

import java.awt.Graphics;
import java.awt.Image;

import com.ugiveme.empires.entity.Entity;
import com.ugiveme.empires.main.GameScreen;
import com.ugiveme.empires.map.Map;

public abstract class Mob extends Entity{

	public Image image;
	
	public double speed;
	
	private int health;
	
	private boolean dead;
	
	public Mob(Map map, Image image, int health, float x, float y, int width, int height) {
		super(map, x, y, width, height);
		
		this.image = image;
		this.health = health;
		this.dead = false;
	}
	
	public abstract void move();
	
	public void hurt(int damage, Mob mob) {
		
		health -= damage;
		
		if (health <= 0) {
			dead = true;
		}
		
		makeDamageIndicator(damage, mob);
		
	}
	
	public void makeDamageIndicator(int damage, Mob mob) {
		GameScreen.addDamageIndicator(damage, (int) (mob.x + Math.floor(Math.random()*10) + 6), (int) mob.y - 7);
	}
	
	public void render(Graphics g) {
		g.drawImage(image, (int) x + map.mapXOffset, (int) y + map.mapYOffset, null);
	}
	
	/**
	 * Sets the image to be rendered with
	 * @param image the image
	 */
	public void setImage(Image image) {
		this.image = image;
	}

	public boolean isDead() {
		return dead;
	}
	
	
}
