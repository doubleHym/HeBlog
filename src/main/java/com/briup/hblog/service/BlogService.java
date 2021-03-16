package com.briup.hblog.service;

import com.briup.hblog.po.Blog;
import com.briup.hblog.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    Blog getBlog(Long id);
    Blog getAndConver(Long id);
    Page<Blog> listBlog (Pageable pageable, BlogQuery blog);
    Blog saveBlog(Blog blog);
    Blog updataBlog(Long id, Blog blog);
    void deleteBlog(Long id);
    Page<Blog> listBlog(Pageable pageable);
    Page<Blog> listBlog(String query,Pageable pageable);
    List<Blog> listRecommendBlogTop(Integer size);

    //针对tag标签的分页查询
    Page<Blog> listBlog (Long tagId,Pageable pageable);
}
