package com.ugiveme.empires.entity;

import java.awt.Graphics;

/**
 * The interface for anything that draws itself.
 * @author ben
 */
public interface Drawable {
	
	/**
	 * Draws this object onto a provided graphics interface.
	 * @param g The graphics interface being worked with.
	 */
	public void render(Graphics g);

}
