package com.chl.search.datasource;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chl.search.service.UserService;
import com.chl.search.model.dto.user.UserQueryRequest;
import com.chl.search.model.vo.UserVO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 用户服务实现
 *
 *
 */
@Component
public class UserDataSource implements Datasource<UserVO> {


    @Resource
    private UserService userService;

    @Override
    public Page<UserVO> doSearch(String searchText, long pageNum, long pageSize) {
        UserQueryRequest userQueryRequest = new UserQueryRequest();
        userQueryRequest.setUserName(searchText);
        userQueryRequest.setCurrent(pageNum);
        userQueryRequest.setPageSize(pageSize);
        Page<UserVO> userVOPage = userService.listUserVoByPage(userQueryRequest);
        return userVOPage;
    }
}
