package com.ugiveme.empires.item;

import java.util.HashMap;
import java.util.Map;

/**
 * This class manages all of the instances and ID's of items.
 * @author ben
 */
public class ItemManager {
	
	public static final ItemManager instance = new ItemManager();
	
	public final static ItemRock rock = new ItemRock(0);
	//Add more public final static items here
	
	private static Map<Integer, Item> registry = new HashMap<Integer, Item>(0);
	
	static {
		registry.put(rock.itemID, rock);
		//add the items to the registry here
	}
	
	private ItemManager() {
		registry = new HashMap<Integer, Item>(0);
	}
	
	public static void addItemToRegistry(Item item) {
        registry.put(item.itemID, item);
	}
	
	public static void removeItemFromRegistry(Item item) {
	        registry.remove(item.itemID);
	}

}
