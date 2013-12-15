package com.ugiveme.empires.main;

import com.ugiveme.graphicsengine.Game;

public class EmpiresGame extends Game{

	public static final int BEGINNINGSCREEN = 0;
	public static final int GAMESCREEN = 1;
	

	public EmpiresGame() {
		setScreenRenderIndex(addScreen(new BeginningScreen(keyHandler)));
		addScreen(new GameScreen(keyHandler));
		
		start();
	}

}
