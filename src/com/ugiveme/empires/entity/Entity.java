package com.ugiveme.empires.entity;

import java.awt.Graphics;

public abstract class Entity {

	public float x;
	public float y;
	
	public float width;
	public float height;
	
	public Entity(float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		
	}
}
