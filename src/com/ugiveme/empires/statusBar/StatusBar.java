package com.ugiveme.empires.statusBar;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import com.ugiveme.empires.main.GameScreen;
import com.ugiveme.empires.map.Player;
import com.ugiveme.graphicsengine.Game;
import com.ugiveme.graphicsengine.spritesheet.SpriteSheet;

public class StatusBar {

	public static final Image HEART = SpriteSheet.loadImage("images/heart.png", 2);
	public static final Image COIN = SpriteSheet.loadImage("images/coin.png", 2);
	
	
	public Player player;
	
	public StatusBar(Player player) {
		
		this.player = player;
		
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		
		g.setColor(new Color(126, 184, 204));
		g.fillRect(0, 0, Game.size.width, 60);
		
		g.drawImage(COIN, 500, 15, null);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString("" + GameScreen.gold, 500 + ("" + GameScreen.gold).length()*12, 42);
		
	}
	
}
