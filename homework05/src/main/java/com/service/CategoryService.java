package com.service;

import com.entity.Category;

import java.util.List;

public interface CategoryService {
    // 新增类别
    boolean addCategory(Category category);

    // 查询所有类别
    List<Category> getAllCategory();

    // 根据名称查询类别
    Category getCategoryByTypeName(String typename);
}