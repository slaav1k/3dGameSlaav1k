package com.deeep.spaceglad;


import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;


public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("Space Gladiators");
		config.setWindowedMode((int) Core.VIRTUAL_WIDTH, (int) Core.VIRTUAL_HEIGHT);
		config.setWindowIcon("icon128.png");
		config.setWindowIcon("icon64.png");
		config.setWindowIcon("icon32.png");
		new Lwjgl3Application(new Core(), config);
	}


}
