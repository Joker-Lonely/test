package com.example.sdust_confession_wall.dto;
/*
 * Create by Lpy_Now on 2022/4/19
 */

import com.example.sdust_confession_wall.model.Question;
import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private boolean showPrevious;//是否包含向前的按钮
    private boolean showFirstPage;//是否显示第一页的按钮
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;//当前页
    private List<Integer> pages = new ArrayList<>();//当前页数
    private Integer totalPage;

    public void setPagination(Integer totalCount, Integer page, Integer size) {
        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        }
        else {
            totalPage = totalCount / size + 1;
        }
        //简单安全问题，保证页面页数在合理范围内
        if (page < 1) {
            page = 1;
        }
        if (page > totalPage) {
            page = totalPage;
        }
        this.page = page;
        pages.add(page);
        /*分页显示逻辑*/
        for (int i = 1; i <= 3; ++ i){
            if (page - i > 0) {
                pages.add(0, page - i);
            }
            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }
        /*分页情况*/
        //是否展示上一页
        if (page == 1) {
            showPrevious = false;
        }
        else {
            showPrevious = true;
        }
        //是否展示下一页
        if (page == totalPage) {
            showNext = false;
        }
        else {
            showNext = true;
        }
        //是否展示第一页
        if (pages.contains(1)) {
            showFirstPage = false;
        }
        else {
            showFirstPage = true;
        }
        //是否展示最后一页
        if (pages.contains(totalPage)) {
            showEndPage = false;
        }
        else {
            showEndPage = true;
        }
    }
}

