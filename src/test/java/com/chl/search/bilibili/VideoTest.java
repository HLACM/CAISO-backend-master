package com.chl.search.bilibili;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.chl.search.model.vo.VideoVO;
import org.junit.jupiter.api.Test;

import java.net.HttpCookie;
import java.util.List;

public class VideoTest {

    @Test
    public void test() {
        HttpResponse response = HttpRequest.get("https://www.bilibili.com/").execute();
        List<HttpCookie> cookies = response.getCookies();
        String body = HttpRequest.get("https://api.bilibili.com/x/web-interface/search/type?search_type=video&keyword=原神").cookie(cookies).execute().body();
        JSONObject jsonObject = JSONUtil.parseObj(body);
        JSONObject data = jsonObject.get("data", JSONObject.class);
        JSONArray result = data.get("result", JSONArray.class);

        for (Object video : result) {
            JSONObject ob = JSONUtil.parseObj(video);
            String author = ob.getStr("author");
            String url = ob.getStr("arcurl");
            String title = ob.getStr("title");
            String pic = ob.getStr("pic");
            VideoVO videoVO = new VideoVO(author, url, title, pic);
            System.out.println();
        }

        System.out.println();

    }

}
