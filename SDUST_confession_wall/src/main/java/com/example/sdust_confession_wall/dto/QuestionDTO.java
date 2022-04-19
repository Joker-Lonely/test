package com.example.sdust_confession_wall.dto;
/*
 * Create by Lpy_Now on 2022/4/18
 */

import com.example.sdust_confession_wall.model.User;
import lombok.Data;

@Data
public class QuestionDTO {
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
    private User user;
}
