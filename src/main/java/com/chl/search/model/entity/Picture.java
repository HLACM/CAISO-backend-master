package com.chl.search.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 图片
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Picture implements Serializable {

    private static final long serialVersionUID = 1L;


    private String title;

    private String url;

}
