package com.chl.search.datasource;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chl.search.model.entity.Post;
import com.chl.search.service.PostService;
import com.chl.search.model.dto.post.PostQueryRequest;
import com.chl.search.model.vo.PostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 帖子服务实现
 *
 *
 */
@Component
public class PostDataSource implements Datasource<PostVO> {


    @Resource
    private PostService postService;
    @Autowired
    private HttpServletRequest request;

    @Override
    public Page<PostVO> doSearch(String searchText, long pageNum, long pageSize) {
        PostQueryRequest postQueryRequest = new PostQueryRequest();
        postQueryRequest.setSearchText(searchText);
        postQueryRequest.setCurrent(pageNum);
        postQueryRequest.setPageSize(pageSize);
        Page<Post> postVOPage = postService.searchFromEs(postQueryRequest);
        return postService.getPostVOPage(postVOPage, request);
    }
}




