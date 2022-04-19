package com.example.sdust_confession_wall.model;

import lombok.Data;

/**
 * Created by LQZ on 2022/4/18 10:39
 **/
@Data
public class Question {
    private Long id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Long creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
}
