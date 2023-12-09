package com.deeep.spaceglad;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.deeep.spaceglad.Core;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("Space Gladiators");
		config.setWindowedMode((int) Core.VIRTUAL_WIDTH, (int) Core.VIRTUAL_HEIGHT);
		new Lwjgl3Application(new Core(), config);
	}


}
