package com.mapper;

import com.entity.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
    // 1. 新增商品
    @Insert("INSERT INTO product(goodsname, price, typeid) VALUES(#{goodsname}, #{price}, #{typeid})")
    int addProduct(Product product);

    // 2. 根据类别名称查询商品（关联查询，映射文件实现）
    List<Product> getProductByCategoryName(@Param("typename") String typename);

    // 3. 查询所有商品（包含类别信息，关联查询，映射文件实现）
    List<Product> getProductWithCategory();
}