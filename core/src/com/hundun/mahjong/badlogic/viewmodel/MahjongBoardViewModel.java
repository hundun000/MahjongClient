package com.hundun.mahjong.badlogic.viewmodel;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector3;
import com.hundun.mahjong.badlogic.MyGdxGame;
import com.hundun.mahjong.badlogic.api.MahjongApiRequest;
import com.hundun.mahjong.badlogic.api.MahjongServerApi;
import com.hundun.mahjong.badlogic.feign.FeignLogger;

import feign.Feign;
import feign.Logger.Level;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;



/**
 * @author hundun
 * Created on 2021/03/30
 */
public class MahjongBoardViewModel extends ViewModel<Object> {
    MahjongServerApi mahjongServerApi;
    BitmapFont font;
    JSONObject responseString;
    static final String JSON_FORMAT = "json";
    static final String IMAGE_FORMAT = "image";
    
    public MahjongBoardViewModel() {
        font = new BitmapFont();
        
        this.mahjongServerApi = Feign.builder()
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new FeignLogger(this.getClass().getSimpleName()))
                .logLevel(Level.FULL)
                .target(MahjongServerApi.class, "http://localhost:10099/mahjong")
                ;
    }

    @Override
    public void handleInput(MyGdxGame game) {
        if(Gdx.input.isKeyJustPressed(Keys.L)) {
            responseString = mahjongServerApi.resetBoard("1", JSON_FORMAT);
        }
    }

    @Override
    public void render(MyGdxGame game) {
        if (responseString != null) {
            this.font.draw(game.batch, JSON.toJSONString(responseString, true), 0, 400);
        }
        //
    }

}
