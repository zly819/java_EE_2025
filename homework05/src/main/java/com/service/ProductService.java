package com.service;

import com.entity.Product;

import java.util.List;

public interface ProductService {
    // 新增商品
    boolean addProduct(Product product);

    // 根据类别名称查询商品
    List<Product> getProductByCategoryName(String typename);

    // 查询所有商品（含类别信息）
    List<Product> getProductWithCategory();
}