package com.ugiveme.empires.entity;

import java.awt.Graphics;
import java.awt.Image;

import com.ugiveme.empires.map.Map;

public abstract class Mob extends Entity{

	public Image image;
	
	public double speed;
	
	public Mob(Map map, Image image, float x, float y, float width, float height) {
		super(map, x, y, width, height);
		
		this.image = image;
	}
	
	public abstract void move();
	
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

	
	
}
