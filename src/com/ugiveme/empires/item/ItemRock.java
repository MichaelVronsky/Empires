package com.ugiveme.empires.item;

import com.ugiveme.graphicsengine.spritesheet.SpriteSheet;

public class ItemRock extends Item {

	public ItemRock(int itemID) {
		super(itemID, SpriteSheet.loadImage("images/Rock.png", 0, 0, 16, 16));
	}

	@Override
	public void tick() {
		System.out.println("I am a rock.");
	}

}
