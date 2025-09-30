package com.service.impl;

import com.entity.Category;
import com.mapper.CategoryMapper;
import com.service.CategoryService;
import com.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    @Override
    public boolean addCategory(Category category) {
        // 自动关闭SqlSession（try-with-resources语法）
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
            // 新增成功返回1，失败返回0
            return mapper.addCategory(category) > 0;
        }
    }

    @Override
    public List<Category> getAllCategory() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
            return mapper.getAllCategory();
        }
    }

    @Override
    public Category getCategoryByTypeName(String typename) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
            return mapper.getCategoryByTypeName(typename);
        }
    }
}