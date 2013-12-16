package com.ugiveme.empires.item;

import com.ugiveme.empires.map.Map;

/**
 * A group of items.
 * Due to the nature of Items, this class is used to represent
 * items in all practical use cases.
 * @author ben
 *
 */
public class ItemGroup {
	
	public int quantity;
	public Item item;
	
	private ItemGround itemGround = null;
	
	private Map map;
	
	/**
     * Create a new ItemGroup
     * @param item The item that this group is composed of.
     * @param quantity The amount of the item that this group has.
     */
	public ItemGroup(Map map, Item item, int quantity) {
		this.map = map;
		this.item = item;
		this.quantity = quantity;
	}
	
	public void tick() {
		
	}
	
	/**
     * Get the entity version of this item.
     * This method will create a new ItemGround if needed.
     * This method can also be used to move a ground item.
     * @param x The x coordinate of the ground item.
     * @param y The y coordinate of the ground item.
     * @return The new, moved, or existing ground item.
     */
	public ItemGround getItemGround(int x, int y) {
		if (itemGround == null) {
			itemGround = new ItemGround(map, x, y, this);
		} else if (itemGround.x != x || itemGround.y != y) {
			itemGround.x = x;
			itemGround.y = y;
		}
		return itemGround;
	}
	
	/**
     * Get the entity version of this item.
     * This method will create a new ItemGround if needed.
     * If a new ItemGround is created, it will be given the coordinates (0, 0)
     * @return The new or existing ground item.
     */
    public ItemGround getItemGround() {
            if (itemGround == null) {
                    itemGround = new ItemGround(map, 0, 0, this);
            }
            return itemGround;
    }

}
