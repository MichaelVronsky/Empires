package com.ugiveme.empires.entity.damageIndicator;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import com.ugiveme.empires.map.Map;

public class DamageIndicatorHandler {

	private static ArrayList<DamageIndicator> damageIndicators;
	
	public Map map;
	
	public DamageIndicatorHandler(Map map) {
		damageIndicators = new ArrayList<DamageIndicator>();
		
		this.map = map;
	}
	
	public void addDamageIndicator(DamageIndicator damageIndicator) {
		damageIndicators.add(damageIndicator);
	}
	
	public void addDamageIndicator(int x, int y, String number, Color color) {
		damageIndicators.add(new DamageIndicator(map, x, y, number, color));
		
		System.out.println("damaged");
	}
	
	public void tick() {
//		for (DamageIndicator d : damageIndicators) {
//			d.tick();
//			if (!d.isActive()) damageIndicators.remove(d);
//		}
		
		for (int i=0;i<damageIndicators.size();i++) {
			damageIndicators.get(i).tick();
			if (!damageIndicators.get(i).isActive()) {
				damageIndicators.remove(i);
				i--;
			}
		}
	}
	
	public void render(Graphics g) {
		for (DamageIndicator d : damageIndicators) {
			d.render(g);
		}
	}

}
