package com.ugiveme.graphicsengine;

import java.awt.Dimension;
import java.awt.Graphics;

public abstract class Screen {
	
	public abstract void reset();
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public abstract Dimension getPrefferedScreenSize();
	
}
