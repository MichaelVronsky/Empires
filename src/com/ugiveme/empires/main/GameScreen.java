package com.ugiveme.empires.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import com.ugiveme.empires.entity.Mob.Mob;
import com.ugiveme.empires.entity.damageIndicator.DamageIndicatorHandler;
import com.ugiveme.empires.map.Map;
import com.ugiveme.empires.map.Player;
import com.ugiveme.empires.statusBar.StatusBar;
import com.ugiveme.graphicsengine.KeyHandler;
import com.ugiveme.graphicsengine.Screen;

public class GameScreen extends Screen{

	public static int gold = 100;
	
	private static Map map;
	
	private static ArrayList<Mob> mobs;
	private static Player player;
	
	private static DamageIndicatorHandler dIH;
	
	private static StatusBar statusBar;
	
	public GameScreen(KeyHandler keyHandler) {
		mobs = new ArrayList<Mob>();
		
		map = new Map(keyHandler, player);
		player = new Player(map, keyHandler);
		map.player = player;
		
		mobs.add(player);
		
		dIH = new DamageIndicatorHandler(map);
		
		statusBar = new StatusBar(player);
	}
	
	@Override
	public void reset() {
		
	}

	@Override
	public void tick() {
		
		for (int i=0;i<mobs.size();i++) {
			mobs.get(i).move();
			mobs.get(i).tick();
			if (mobs.get(i).isDead()) {
				mobs.remove(i);
			}
		}
		
		map.tick();
		dIH.tick();
		
		statusBar.tick();
	}

	@Override
	public void render(Graphics g) {
		
		map.render(g);
		
		for (Mob mob : mobs) {
			mob.render(g);
		}
		
		dIH.render(g);
		
		statusBar.render(g);
		
	}

	@Override
	public Dimension getPrefferedScreenSize() {
		// TODO Auto-generated method stub
		return new Dimension(500, 500);
	}

	public static void addDamageIndicator(int damage, int x, int y) {
		dIH.addDamageIndicator(x, y, "" + damage, Color.RED);
	}
	
	//synchronized to prevent concurrency issues, which, yes, is a thing that has happened before
	public static synchronized ArrayList<Mob> getMobs() {
		return mobs;
	}
	
	public static void addMob(Mob mob) {
		mobs.add(mob);
	}
	
	public static Player getPlayer() {
		return player;
	}
	
}
