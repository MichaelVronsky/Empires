package com.ugiveme.empires.entity;

import java.awt.Graphics;

import com.ugiveme.empires.map.Map;

public abstract class Entity {

	public Map map;
	
	public float x;
	public float y;
	
	public float width;
	public float height;
	
	public Entity(Map map, float x, float y, float width, float height) {
		this.map = map;
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	//public abstract void interact(Entity e);
}
