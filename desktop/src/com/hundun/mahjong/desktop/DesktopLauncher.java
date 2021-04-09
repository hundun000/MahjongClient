package com.hundun.mahjong.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.hundun.mahjong.badlogic.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = MyGdxGame.APP_WIDTH;
		config.height = MyGdxGame.APP_HEIGHT;
		new LwjglApplication(new MyGdxGame(), config);
	}
}
