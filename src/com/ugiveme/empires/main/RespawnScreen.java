package com.ugiveme.empires.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.ugiveme.graphicsengine.Game;
import com.ugiveme.graphicsengine.KeyHandler;
import com.ugiveme.graphicsengine.Screen;

public class RespawnScreen extends Screen{

	public static final String STARTTEXT = "RESPAWN";
	
	public Rectangle STARTRECT = new Rectangle(300, Game.size.height - 300, Game.size.width-600, 80);
	
	private KeyHandler keyHandler;
	
	public RespawnScreen(KeyHandler keyHandler) {
		this.keyHandler = keyHandler;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tick() {
		
		if (keyHandler.isMouseClicked()){
			EmpiresGame.setScreenRenderIndex(EmpiresGame.GAMESCREEN);
			
			keyHandler.setMouseClicked(false);
		}
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, Game.size.width, Game.size.height);
		
		g.setColor(Color.ORANGE);
		g.fillRect(STARTRECT.x, STARTRECT.y, STARTRECT.width, STARTRECT.height);
		g.setColor(Color.BLACK);
		g.drawRect(STARTRECT.x, STARTRECT.y, STARTRECT.width, STARTRECT.height);
		g.setFont(new Font("Arial", Font.BOLD, 60));
		g.drawString(STARTTEXT, STARTRECT.x + STARTRECT.width/2 - STARTTEXT.length()*20, STARTRECT.y + 60);
		
		g.setColor(new Color((int) Math.floor(Math.random()*255), (int) Math.floor(Math.random()*255), (int) Math.floor(Math.random()*255)));
		g.setFont(new Font("Arial", Font.BOLD, 200));
		g.drawString("YOU DIED!", 100, 300);
	}

	@Override
	public Dimension getPrefferedScreenSize() {
		return null;
	}
	
}
