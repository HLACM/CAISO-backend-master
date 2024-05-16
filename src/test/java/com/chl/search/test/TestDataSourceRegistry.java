package com.chl.search.test;


import org.springframework.stereotype.Component;

@Component
public class TestDataSourceRegistry {
//    @Resource
//    Datasource<T> userDatasource;
//
//    @Resource
//    Datasource<T> postDataSource;
//
//    @Resource
//    Datasource<T> pictureDataSource;
//
//    private Map<String, Datasource<T>> typeDataSourceMap;
//
//    @PostConstruct
//    public void doInit() {
//        typeDataSourceMap = new HashMap() {
//            private static final long serialVersionUID = 1L;
//
//            {
//                put(SearchTypeEnum.POST.getValue(), postDataSource);
//                put(SearchTypeEnum.USER.getValue(), userDatasource);
//                put(SearchTypeEnum.PICTURE.getValue(), pictureDataSource);
//            }
//        };
//    }
//
//    public Datasource<T> getDatasourceByType(String type) {
//        if (typeDataSourceMap == null) {
//            return null;
//        }
//
//        return typeDataSourceMap.get(type);
//    }
}
