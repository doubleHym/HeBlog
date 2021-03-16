package com.briup.hblog.dao;

import com.briup.hblog.po.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag,Long> {
    Tag findByName(String name);

    //按照分页的大小作为我们所要查询的条数
    @Query("select t from Tag t")
    List<Tag> findTop(Pageable pageable);
}
