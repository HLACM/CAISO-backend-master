package com.chl.search;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.chl.search.model.entity.Post;
import com.chl.search.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class CrawlerTest {

    @Resource
    private PostService postService;


//    @Test
//    public void testBing() throws IOException {
//        int current = 1;
//        String url = "https://cn.bing.com/images/search?q=知更鸟&first=" + current;
//        Document doc = Jsoup.connect(url).get();
//        Elements elements = doc.select(".iuscp.isv");
//        List<Picture> pictures = new ArrayList<>();
//        for (Element element : elements) {
//            // 获取标题
//            String title = element.select(".inflnk").attr("aria-label");
//            // 获取图片
//            String m = element.select(".iusc").attr("m");
//            JSONObject j = JSONUtil.parseObj(m);
//            String imgUrl = j.get("murl", String.class);
////            System.out.println("title:" + title);
////            System.out.println("imgUrl:" + imgUrl);
//            pictures.add(new Picture(title, imgUrl));
//        }
//        System.out.println(pictures);
//    }
//
//
//    @Test
//    public void testBaidu() throws IOException {
//        int current = 1;
//        String url = "https://image.baidu.com/search/index?tn=baiduimage&fm=result&ie=utf-8&word=知更鸟";
//        Document doc = Jsoup.connect(url).get();
//        Elements elements = doc.select(".iuscp.isv");
//        List<Picture> pictures = new ArrayList<>();
//        for (Element element : elements) {
//            // 获取标题
//            String title = element.select(".inflnk").attr("aria-label");
//            // 获取图片
//            String m = element.select(".iusc").attr("m");
//            JSONObject j = JSONUtil.parseObj(m);
//            String imgUrl = j.get("murl", String.class);
////            System.out.println("title:" + title);
////            System.out.println("imgUrl:" + imgUrl);
//            pictures.add(new Picture(title, imgUrl));
//        }
//        System.out.println(pictures);
//    }

    @Test
    public void fetch() {
        String json = "{\"sortField\":\"createTime\",\"sortOrder\":\"descend\",\"reviewStatus\":1,\"current\":1}";
        String url = "https://www.code-nav.cn/api/post/list/page/vo";
        String res = HttpRequest.post(url)
                .body(json)
                .execute()
                .body();
        System.out.println(res);

        // 2. json 转对象
        Map<String, Object> map = new JSONUtil().toBean(res, Map.class);
        JSONObject data = (JSONObject) map.get("data");
        JSONArray records = (JSONArray) data.get("records");
        List<Post> postList = new ArrayList<>();
        for (Object record : records) {
            JSONObject rec = (JSONObject) record;
            System.out.println();
            Post post = new Post();
            post.setTitle(rec.getStr("title"));
            post.setContent(rec.getStr("content"));
            JSONArray tags = rec.getJSONArray("tags");
            String jsonStr = JSONUtil.toJsonStr(tags);
            post.setTags(jsonStr);
            post.setThumbNum(0);
            post.setFavourNum(0);
            post.setUserId(1L);
            postList.add(post);
        }
        boolean b = postService.saveBatch(postList);
    }


}
