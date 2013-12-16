package com.ugiveme.empires.inventory;

import com.ugiveme.empires.item.ItemGroup;

/**
 * All of the functions that an object needs to be used as an inventory.
 * Inventories can be anything from the player to a tile
 * as long as they are able to somehow "have" items.
 * @author ben
 */
public interface Inventory {
	
	public int getInventorySize();
	public ItemGroup getItemInSlot(int slot);
	public void setItemInSlot(int slot, ItemGroup item);

}
