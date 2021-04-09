package com.hundun.mahjong.badlogic.viewmodel;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.hundun.mahjong.badlogic.MyGdxGame;

/**
 * @author hundun
 * Created on 2021/03/30
 */
public abstract class ViewModel <T_MODEL> {
    protected T_MODEL model;
    protected Rectangle pos;
    
    public ViewModel() {
        this.pos = new Rectangle();
    }
    
    public abstract void handleInput(MyGdxGame game);
    public abstract void render(MyGdxGame game);
    public void dispose(MyGdxGame game) {};
}
