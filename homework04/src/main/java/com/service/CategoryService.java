package com.service;

import com.entity.Category;

import java.util.List;

public interface CategoryService {
    // 添加商品类别
    boolean addCategory(Category category);

    // 查询所有商品类别
    List<Category> getAllCategory();

    // 根据类别名称查询类别
    Category getCategoryByTypeName(String typename);
}