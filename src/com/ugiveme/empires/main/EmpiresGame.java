package com.ugiveme.empires.main;

import com.ugiveme.graphicsengine.Game;

public class EmpiresGame extends Game{

	public static final int GAMESCREENNUM = 0;
	
	public static int gold = 100;

	public EmpiresGame() {
		setScreenRenderIndex(addScreen(new GameScreen(keyHandler)));
		
		start();
	}

}
