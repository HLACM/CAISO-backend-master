package com.chl.search.model.vo;


import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 聚合搜索
 */
@Data
public class SearchVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Object> dataList;

}
