package com.ugiveme.empires.main;

import java.awt.Dimension;
import java.awt.Graphics;

import com.ugiveme.empires.map.Map;
import com.ugiveme.empires.map.Player;
import com.ugiveme.graphicsengine.KeyHandler;
import com.ugiveme.graphicsengine.Screen;

public class GameScreen extends Screen{

	private Map map;
	private Player player;
	
	public GameScreen(KeyHandler keyHandler) {
		player = new Player(keyHandler);
		map = new Map(keyHandler);
	}
	
	@Override
	public void reset() {
		
	}

	@Override
	public void tick() {
		
		player.tick();
		map.tick();
	}

	@Override
	public void render(Graphics g) {
		
		map.render(g);
		player.render(g);
		
	}

	@Override
	public Dimension getPrefferedScreenSize() {
		// TODO Auto-generated method stub
		return new Dimension(500, 500);
	}


}
