package com.ugiveme.empires.item;

import java.awt.Graphics;
import java.awt.Image;

import com.ugiveme.empires.entity.Entity;
import com.ugiveme.empires.map.Map;
import com.ugiveme.empires.map.Tile;

/**
 * The representation of a group on items when they are free in the world.
 * 
 * @author ben
 */
public class ItemGround extends Entity {
	
	private int yoffset = 0;
	private boolean up = true;
	private ItemGroup group;
	private Image texture;

	/**
     * Create a new item on the ground
     * @param map the map used to render.
     * @param x The x coordinate of this item.
     * @param y The y coordinate of this item.
     * @param group The ItemGroup that this entity is representing.
     */
	public ItemGround(Map map, int x, int y, ItemGroup group) {
		super(map, (float) x, (float) y, group.item.getTexture().getWidth(null), group.item.getTexture().getHeight(null));
		this.group = group;
		this.texture = this.group.item.getTexture();
	}
	
	@Override
	public void tick() { }
	
	@Override
	public void render(Graphics g) {
		g.drawImage(texture,
				(int) x + Tile.SIZE / 4, (int) (-yoffset / 8 + y + Tile.SIZE / 4), (int) x + Tile.SIZE / 4 * 3, (int) (-yoffset / 8 + y + Tile.SIZE / 4 * 3),
				0, 0, texture.getWidth(null), texture.getHeight(null), null);
		if (up && yoffset < 32) {
			yoffset++;
		} else if (up && yoffset >= 32) {
			yoffset--;
			up = false;
		} else if (!up && yoffset > -32) {
			yoffset--;
		} else if (!up && yoffset <= -32) {
			yoffset++;
			up = true;
		}
	}

}
