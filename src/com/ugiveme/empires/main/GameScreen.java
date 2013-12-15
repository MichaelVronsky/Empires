package com.ugiveme.empires.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import com.ugiveme.empires.entity.Mob.Mob;
import com.ugiveme.empires.entity.Mob.Zombie;
import com.ugiveme.empires.entity.damageIndicator.DamageIndicatorHandler;
import com.ugiveme.empires.map.Map;
import com.ugiveme.empires.map.Player;
import com.ugiveme.graphicsengine.KeyHandler;
import com.ugiveme.graphicsengine.Screen;

public class GameScreen extends Screen{

	private static Map map;
	
	private static ArrayList<Mob> mobs;
	private static Player player;
	
	private static DamageIndicatorHandler dIH;
	
	public GameScreen(KeyHandler keyHandler) {
		mobs = new ArrayList<Mob>();
		
		map = new Map(keyHandler, player);
		player = new Player(map, keyHandler);
		map.player = player;
		
		mobs.add(player);
		
		dIH = new DamageIndicatorHandler(map);
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
	}

	@Override
	public void render(Graphics g) {
		
		map.render(g);
		
		for (Mob mob : mobs) {
			mob.render(g);
		}
		
		dIH.render(g);
		
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
