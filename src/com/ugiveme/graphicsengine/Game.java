package com.ugiveme.graphicsengine;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class Game extends JPanel implements Runnable{
	private static final long serialVersionUID = 1L;
	
	public static final String title = "Game";
	public static final Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
	
	public static Thread gameLoop;
	public static Game game;
	public static JFrame frame;
	
	public boolean running;
	
	public static KeyHandler keyHandler;
	
	public static ArrayList<Screen> screens;
	public static int renderIndex;
	
	private int ticks = 0;
	private int fps = 0;
	
	public Game() {
		game = this;
		
		frame = new JFrame();
		
		frame.setTitle(title);
		frame.setSize(size);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setUndecorated(true);
//		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
//
//    	if (gd.isFullScreenSupported()) {
//    		gd.setFullScreenWindow(frame);
//    	}
//    	else {
//    		System.err.println("Full screen not supported");
//    	}
    	
		
		frame.setLayout(new BorderLayout());
		frame.add(game, BorderLayout.CENTER);
		frame.setVisible(true);
		
		keyHandler = new KeyHandler(this);
		
		screens = new ArrayList<Screen>();
	}
	
	public void addKeyHandler(KeyHandler keyHandler) {
		frame.addKeyListener(keyHandler);
	}
	
	public synchronized int addScreen(Screen screen) {
		screens.add(screen);
		System.out.println("added screen #" + (screens.size()-1));
		return screens.size()-1;
	}
	
	public static void setScreenRenderIndex(int renderIndex) {
		Game.renderIndex = renderIndex;
		screens.get(renderIndex).reset();
	}
	
	public synchronized void start() {
		running = true;
		
		gameLoop = new Thread(this, "GameLoop");
		gameLoop.start();
	}
	
	public synchronized void stop() {
		running = false;
		
		try {
			gameLoop.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void tick() {
		screens.get(renderIndex).tick();
	}
	
	public synchronized void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setClip(0, 0, size.width, size.height);
		if (running) {
			render(g);
		}
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.BOLD, 15));
		g.drawString("FPS: " + fps, 20, 20);
		g.drawString("Head space used (in megabytes): " + ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())/1000000), 20, 40);
	}
	
	public synchronized void render(Graphics g) {
		screens.get(renderIndex).render(g);
	}
	
	public void run() {
		double ticksPerSecond = 60;
		int nanoSecondsPerTick = (int) (1000000000/ticksPerSecond);
		
		long timePassed = 0;
		long lastTime = System.nanoTime();
		long now;
		
		long tickTimer = System.currentTimeMillis();
		
		while (running) {
			now = System.nanoTime();
			timePassed += now - lastTime;
			lastTime = now;
			boolean ticked = false;
			
			while (timePassed >= nanoSecondsPerTick) {
				timePassed -= nanoSecondsPerTick;
				ticked = true;
			}
			
			if (ticked) {
				ticks++;
				tick();
				repaint();
			}
			
			if (System.currentTimeMillis() - tickTimer > 1000) {
				tickTimer += 1000;
				fps = ticks;
				ticks = 0;
			}
			
			try {
				Thread.sleep(2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
