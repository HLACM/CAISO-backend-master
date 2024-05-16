package com.chl.search.datasource;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chl.search.service.InterfaceInfoService;
import com.chl.search.model.vo.InterfaceInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiDataSource implements Datasource<InterfaceInfoVO> {

    @Autowired
    InterfaceInfoService interfaceInfoService;

    @Override
    public Page<InterfaceInfoVO> doSearch(String searchText, long pageNum, long pageSize) {
        if (searchText == null) {
            searchText = "";
        }
        QueryWrapper<InterfaceInfoVO> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", searchText);
        Page<InterfaceInfoVO> page = interfaceInfoService.page(new Page<>(pageNum, pageSize), queryWrapper);
        return page;
    }
}
