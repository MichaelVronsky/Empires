package com.ugiveme.empires.item;

import java.awt.Image;

import com.ugiveme.empires.entity.Tickable;

public abstract class Item implements Tickable {
	
	public final int itemID;
	
	protected final Image texture;
	
	 /**
     * Create a new type of Item.
     * @param itemID The ID of the new item.
     * @param texture The texture to be used by the new item.
     */
	public Item(int itemID, Image texture) {
		this.itemID = itemID;
		this.texture = texture;
	}
	
	/**
     * @return The texture used by this type of item.
     */
	public Image getTexture() {
		return this.texture;
	}

}
