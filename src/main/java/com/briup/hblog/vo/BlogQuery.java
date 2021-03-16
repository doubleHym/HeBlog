package com.briup.hblog.vo;

import com.briup.hblog.po.User;

/**
 * Created by limi on 2017/10/20.
 */
public class BlogQuery {

    private String title;
    private Long typeId;
    private Long userId;
    private boolean recommend;

    private boolean published;

    public BlogQuery() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }
}
