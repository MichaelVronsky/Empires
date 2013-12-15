package com.ugiveme.empires.entity;

/**
 * The interface for anything that changes as the game updates.
 * @author ben
 */
public interface Tickable {
	
	/**
	 * This function should do all the necessary updating when it is called each tick.
	 */
	public void tick();

}
