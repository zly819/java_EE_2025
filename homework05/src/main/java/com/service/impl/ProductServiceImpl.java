package com.service.impl;

import com.entity.Product;
import com.mapper.ProductMapper;
import com.service.ProductService;
import com.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Override
    public boolean addProduct(Product product) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
            return mapper.addProduct(product) > 0;
        }
    }

    @Override
    public List<Product> getProductByCategoryName(String typename) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
            return mapper.getProductByCategoryName(typename);
        }
    }

    @Override
    public List<Product> getProductWithCategory() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
            return mapper.getProductWithCategory();
        }
    }
}