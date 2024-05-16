package com.chl.search.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chl.search.model.entity.Picture;

/**
 * 帖子服务
 *
 *
 */
public interface PictureService {
    Page<Picture> searchPicture(String searchText, long pageNum, long pageSize);
}
