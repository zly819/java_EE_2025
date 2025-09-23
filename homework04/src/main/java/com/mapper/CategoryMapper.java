package com.mapper;

import com.entity.Category;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CategoryMapper {
    // 添加商品类别
    @Insert("INSERT INTO category(typename) VALUES(#{typename})")
    int addCategory(Category category);

    // 查询所有商品类别
    @Select("SELECT * FROM category")
    List<Category> getAllCategory();

    // 根据类别名称查询类别（用于关联查询）
    @Select("SELECT * FROM category WHERE typename = #{typename}")
    Category getCategoryByTypeName(String typename);
}