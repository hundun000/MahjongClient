package com.hundun.mahjong.badlogic.viewmodel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.hundun.mahjong.badlogic.MyGdxGame;

/**
 * @author hundun
 * Created on 2021/03/30
 */
public class Pointer extends ViewModel<Void> {

    Texture img;
    
    public Pointer() {
        img = new Texture("pointer.png");
    }


    @Override
    public void handleInput(MyGdxGame game) {
        if(Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            game.camera.unproject(touchPos);
            this.pos.x = touchPos.x - 32 / 2;
            this.pos.y = touchPos.y - 32 / 2;
        }
    }

    @Override
    public void render(MyGdxGame game) {
        game.batch.draw(img, this.pos.x, this.pos.y);
    }

}
