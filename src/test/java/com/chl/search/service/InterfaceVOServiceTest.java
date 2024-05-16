package com.chl.search.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chl.search.datasource.ApiDataSource;
import com.chl.search.model.vo.InterfaceInfoVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InterfaceVOServiceTest {

    @Autowired
    ApiDataSource apiDataSource;

    @Test
    public void test() {
        Page<InterfaceInfoVO> test = apiDataSource.doSearch("测试", 1, 10);
        System.out.println(test);

    }

}
