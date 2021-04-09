package com.hundun.mahjong.badlogic.api;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

/**
 * @author hundun
 * Created on 2021/03/30
 */
public interface MahjongServerApi {
    @RequestLine("POST /reset")
    @Headers("Content-Type: application/json")
    JSONObject resetBoard(@Param("board_id") String board_id, @Param("mode") String mode);

    
}
