package com.chl.search.datasource;


import com.chl.search.model.enums.SearchTypeEnum;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Component
public class DataSourceRegistry {
    @Resource
    Datasource<T> userDataSource;

    @Resource
    Datasource<T> postDataSource;

    @Resource
    Datasource<T> pictureDataSource;

    @Resource
    Datasource<T> videoDataSource;

    @Resource
    Datasource<T> apiDataSource;

    private Map<String, Datasource<T>> typeDataSourceMap;


    @PostConstruct
    public void doInit() {
        typeDataSourceMap = new HashMap<String, Datasource<T>>() {
            private static final long serialVersionUID = 1L;
            {
                put(SearchTypeEnum.POST.getValue(), postDataSource);
                put(SearchTypeEnum.USER.getValue(), userDataSource);
                put(SearchTypeEnum.PICTURE.getValue(), pictureDataSource);
                put(SearchTypeEnum.VIDEO.getValue(), videoDataSource);
                put(SearchTypeEnum.API.getValue(), apiDataSource);
            }
        };
    }

    public Datasource getDatasourceByType(String type) {
        if (typeDataSourceMap == null) {
            return null;
        }
        return typeDataSourceMap.get(type);
    }
}
