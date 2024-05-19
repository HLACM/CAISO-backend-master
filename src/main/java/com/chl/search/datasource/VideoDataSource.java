package com.chl.search.datasource;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chl.search.model.vo.VideoVO;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class VideoDataSource implements Datasource<VideoVO> {


    List<HttpCookie> cookies;


    @Scheduled(fixedRate = 60 * 1000 * 5)
    public void getCookie() {
        //向哔哩哔哩网站发送请求，获取该URL返回的响应
        HttpResponse response = HttpRequest.get("https://www.bilibili.com/").execute();
        //从响应中获取cookie信息
        cookies = response.getCookies();
    }

    @Override
    public Page<VideoVO> doSearch(String searchText, long pageNum, long pageSize) {
        if (searchText == null || searchText.equals("")) {
            Page<VideoVO> videoVOPage = new Page<>(pageNum, pageSize);
            videoVOPage.setRecords(null);
            return videoVOPage;
        }
        //通过.execute()方法执行该请求，并通过.body()方法获取HTTP响应的内容
        String body = HttpRequest.get("https://api.bilibili.com/x/web-interface/search/type?search_type=video&keyword=" + searchText)
                .cookie(cookies).execute().body();
        JSONObject jsonObject = JSONUtil.parseObj(body);
        //响应体中data字段和result字段存储主要信息
        JSONObject data = jsonObject.get("data", JSONObject.class);
        JSONArray result = data.get("result", JSONArray.class);
        Page<VideoVO> page = new Page<>();
        List<VideoVO> list = new ArrayList<>();
        for (Object video : result) {
            JSONObject ob = JSONUtil.parseObj(video);
            String author = ob.getStr("author");
            String url = ob.getStr("arcurl");
            String title = ob.getStr("title");
            Pattern pattern = Pattern.compile("<em class=\"keyword\">(.*?)</em>");
            Matcher matcher = pattern.matcher(title);
            while (matcher.find()) {
                String keyword = matcher.group(1);
                title = title.replaceFirst("<em class=\"keyword\">" + keyword + "</em>", "<font color=\"red\">" + keyword + "</font>");
            }
            //获取图片地址
            String pic = "http:" + ob.getStr("pic");
            VideoVO videoVO = new VideoVO(author, url, title, pic);
            list.add(videoVO);
        }
        page.setRecords(list);
        return page;
    }
}
