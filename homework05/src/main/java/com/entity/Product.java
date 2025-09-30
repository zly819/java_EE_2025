package com.entity;

import java.math.BigDecimal;

public class Product {
    private Integer id; // 商品编号
    private String goodsname; // 商品名称
    private BigDecimal price; // 商品单价
    private Integer typeid; // 商品类别编号（外键）
    private Category category; // 关联的类别对象（用于关联查询）

    // 无参构造
    public Product(Object o, String 格力空调, BigDecimal bigDecimal, Integer id) {
    }

    // 有参构造（不含id和category，用于新增商品）
    public Product(String goodsname, BigDecimal price, Integer typeid) {
        this.goodsname = goodsname;
        this.price = price;
        this.typeid = typeid;
    }

    // 全参构造
    public Product(Integer id, String goodsname, BigDecimal price, Integer typeid, Category category) {
        this.id = id;
        this.goodsname = goodsname;
        this.price = price;
        this.typeid = typeid;
        this.category = category;
    }

    public Product(Integer id, String goodsname, BigDecimal price, Integer typeid) {
        this.id = id;
        this.goodsname = goodsname;
        this.price = price;
        this.typeid = typeid;
    }

    public Product(Integer id, String goodsname, BigDecimal price, Integer typeid, Integer categoryId, String categoryName) {
        this.id = id;
        this.goodsname = goodsname;
        this.price = price;
        this.typeid = typeid;
        // 这里可以根据需要，将categoryId和categoryName设置到关联的Category对象中
        this.category = new Category(categoryId, categoryName);
    }


    // Getter & Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    // toString（用于打印结果）
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", goodsname='" + goodsname + '\'' +
                ", price=" + price +
                ", typeid=" + typeid +
                ", category=" + category +
                '}';
    }
}