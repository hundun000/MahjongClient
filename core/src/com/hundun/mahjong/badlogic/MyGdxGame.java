package com.hundun.mahjong.badlogic;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.hundun.mahjong.badlogic.viewmodel.MahjongBoardViewModel;
import com.hundun.mahjong.badlogic.viewmodel.Pointer;


public class MyGdxGame extends ApplicationAdapter {
    public static final int APP_WIDTH = 800;
    public static final int APP_HEIGHT = 480;
	private static final float VIEWPORT_WIDTH = 800;
    private static final float VIEWPORT_HEIGHT = 480;
    public SpriteBatch batch;
	
	MahjongBoardViewModel mahjongBoardViewModel;
	Pointer pointer;
	
	
	public OrthographicCamera camera;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		
		
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
		
		mahjongBoardViewModel = new MahjongBoardViewModel();
		pointer = new Pointer();
	}

	@Override
	public void render () {
	    ScreenUtils.clear(0, 0, 0.5f, 1);
	    camera.update();
	    
	    mahjongBoardViewModel.handleInput(this);
	    pointer.handleInput(this);
	    
	    batch.setProjectionMatrix(camera.combined);
		batch.begin();
		
		mahjongBoardViewModel.render(this);
        pointer.render(this);
		
		batch.end();
		
		
	}


    @Override
	public void dispose () {
		batch.dispose();
		mahjongBoardViewModel.dispose(this);
        pointer.dispose(this);
	}
}
