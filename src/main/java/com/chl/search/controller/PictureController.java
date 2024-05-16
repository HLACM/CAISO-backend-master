package com.chl.search.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chl.search.common.BaseResponse;
import com.chl.search.common.ErrorCode;
import com.chl.search.common.ResultUtils;
import com.chl.search.exception.ThrowUtils;
import com.chl.search.model.dto.picture.PictureQueryRequest;
import com.chl.search.model.entity.Picture;
import com.chl.search.service.PictureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 帖子接口
 *
 *
 */
@RestController
@Deprecated
@RequestMapping("/picture")
@Slf4j
@Api(tags = "图片模块")
public class PictureController {

    @Resource
    private PictureService pictureService;

    // region 增删改查

    /**
     * 分页获取列表（封装类）
     *
     * @param pictureQueryRequest
     * @param request
     * @return
     */
    @PostMapping("/list/page/vo")
    @ApiOperation("从bing搜索图片")
    public BaseResponse<Page<Picture>> listPictureByPage(@RequestBody PictureQueryRequest pictureQueryRequest,
                                                         HttpServletRequest request) {
        String searchText = pictureQueryRequest.getSearchText();
        long current = pictureQueryRequest.getCurrent();
        long size = pictureQueryRequest.getPageSize();
        // 限制爬虫
        ThrowUtils.throwIf(size > 20, ErrorCode.PARAMS_ERROR);
        Page<Picture> picturePage = pictureService.searchPicture(searchText, current, size);
        return ResultUtils.success(picturePage);
    }
}
