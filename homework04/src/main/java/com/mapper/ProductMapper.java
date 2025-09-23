package com.mapper;

import com.entity.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
    // 添加商品
    @Insert("INSERT INTO product(goodsname, price, typeid) VALUES(#{goodsname}, #{price}, #{typeid})")
    int addProduct(Product product);

    // 1. 查询商品类别为"白色家电"的所有商品信息（通过映射文件实现）
    List<Product> getProductByCategoryName(@Param("typename") String typename);

    // 2. 实现商品与商品类别的关联查询（返回包含类别名称的完整商品信息）
    List<Product> getProductWithCategory();
}