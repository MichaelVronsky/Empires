package com.ugiveme.empires.entity.damageIndicator;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.ugiveme.empires.entity.Entity;
import com.ugiveme.empires.map.Map;

public class DamageIndicator extends Entity{

	
	
	private String number;
	private float numSize;
	
	private Color color;
	
	private float opacity = 100;
	
	private boolean active;
	
	public DamageIndicator(Map map, int x, int y, String number, Color color) {
		super(map, x, y, 0, 0);
		
		this.number = number;
		this.numSize = 35;
		
		this.color = color;
		
		this.opacity = 100;
		
		this.active = true;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void tick() {
		opacity -= 0.4;
		numSize -= 0.1;
		y -= 1;
		
		if(opacity <= 0) {
			active = false;
			opacity = 0;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), (int) opacity));
		g.setFont(new Font("Arial", Font.BOLD, (int) numSize));
		g.drawString(number, (int) x + map.mapXOffset - 10, (int) y + map.mapYOffset);
		System.out.println("rendered");
	}

}
