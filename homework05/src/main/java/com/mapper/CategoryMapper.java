package com.mapper;

import com.entity.Category;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CategoryMapper {
    // 1. 新增商品类别
    @Insert("INSERT INTO category(typename) VALUES(#{typename})")
    int addCategory(Category category);

    // 2. 查询所有类别
    @Select("SELECT * FROM category")
    List<Category> getAllCategory();

    // 3. 根据类别名称查询（用于关联查询时获取类别ID）
    @Select("SELECT * FROM category WHERE typename = #{typename}")
    Category getCategoryByTypeName(String typename);
}