package com.service;

import com.entity.Product;

import java.util.List;

public interface ProductService {
    // 添加商品
    boolean addProduct(Product product);

    // 查询指定类别（如"白色家电"）的所有商品
    List<Product> getProductByCategoryName(String typename);

    // 查询所有商品（包含类别信息）
    List<Product> getProductWithCategory();
}