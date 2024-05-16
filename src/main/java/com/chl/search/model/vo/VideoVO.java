package com.chl.search.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String author;
    private String url;
    private String title;
    private String pic;
}
