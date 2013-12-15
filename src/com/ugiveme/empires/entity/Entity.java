package com.ugiveme.empires.entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.ugiveme.empires.map.Map;

public abstract class Entity {

	public Map map;
	
	public float x;
	public float y;
	
	public int width;
	public int height;
	
	public Entity(Map map, float x, float y, int width, int height) {
		this.map = map;
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	//public abstract void interact(Entity e);
	
	public Rectangle getRect() {
		return new Rectangle((int) x, (int) y, width, height);
	}
}
