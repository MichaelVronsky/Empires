package com.ugiveme.graphicsengine;

import java.awt.Point;
import java.awt.event.*;
import java.util.*;

public class KeyHandler implements KeyListener, MouseListener, MouseMotionListener{
	
	public ArrayList<String> keys;
	
	public Point mousePoint;
	
	public boolean mouseClicked;
	public int mouseClickButton;
	public Point mouseClickPoint;
	
	public KeyHandler(Game game) {
		game.addKeyHandler(this);
		game.addMouseListener(this);
		game.addMouseMotionListener(this);
		
		keys = new ArrayList<String>();
		
		mousePoint = new Point(0, 0);
		
		mouseClicked = false;
		mouseClickButton = 1;
		mouseClickPoint = new Point(0, 0);
	}
	
	public boolean isPressed(String key) {
		return keys.contains(key);
	}
	
	public void removeKey(String key) {
		keys.remove(key);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP && !keys.contains("up")) 
			keys.add("up");
		if (e.getKeyCode() == KeyEvent.VK_DOWN && !keys.contains("down")) 
			keys.add("down");
		if (e.getKeyCode() == KeyEvent.VK_LEFT && !keys.contains("left")) 
			keys.add("left");
		if (e.getKeyCode() == KeyEvent.VK_RIGHT && !keys.contains("right")) 
			keys.add("right");
		if (e.getKeyCode() == KeyEvent.VK_W && !keys.contains("w"))
			keys.add("w");
		
		if (e.getKeyCode() == KeyEvent.VK_S && !keys.contains("s")) 
			keys.add("s");
		if (e.getKeyCode() == KeyEvent.VK_A && !keys.contains("a")) 
			keys.add("a");
		if (e.getKeyCode() == KeyEvent.VK_D && !keys.contains("d")) 
			keys.add("d");
		if (e.getKeyCode() == KeyEvent.VK_Q && !keys.contains("q")) 
			keys.add("q");
		
		if (e.getKeyCode() == KeyEvent.VK_SPACE && !keys.contains("space")) 
			keys.add("space");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) 
			keys.remove("up");
		if (e.getKeyCode() == KeyEvent.VK_DOWN) 
			keys.remove("down");
		if (e.getKeyCode() == KeyEvent.VK_LEFT) 
			keys.remove("left");
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) 
			keys.remove("right");
		
		if (e.getKeyCode() == KeyEvent.VK_W) 
			keys.remove("w");
		if (e.getKeyCode() == KeyEvent.VK_S) 
			keys.remove("s");
		if (e.getKeyCode() == KeyEvent.VK_A) 
			keys.remove("a");
		if (e.getKeyCode() == KeyEvent.VK_D) 
			keys.remove("d");
		if (e.getKeyCode() == KeyEvent.VK_Q) 
			keys.remove("q");
		
		if (e.getKeyCode() == KeyEvent.VK_SPACE) 
			keys.remove("space");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mousePoint = new Point(e.getX(), e.getY());
		mouseClicked = true;
		mouseClickButton = e.getButton();
		mouseClickPoint = new Point(e.getX(), e.getY());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mousePoint = new Point(e.getX(), e.getY());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		mouseClicked = true;
		mouseClickButton = e.getButton();
		mouseClickPoint = new Point(e.getX(), e.getY());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
	
	public Point getMousePos() {
		return mousePoint;
	}
	
	public boolean isMouseClicked() {
		return mouseClicked;
	}
	
	public void setMouseClicked(boolean mouseClicked) {
		this.mouseClicked = mouseClicked;
	}
	
	public int getMouseClickButton() {
		return mouseClickButton;
	}
	
	public Point getMouseClickPoint() {
		return mouseClickPoint;
	}
	
}
