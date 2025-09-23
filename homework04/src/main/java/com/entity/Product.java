package com.entity;

import java.math.BigDecimal;

public class Product {
    private Integer id; // 商品编号
    private String goodsname; // 商品名称
    private BigDecimal price; // 商品单价
    private Integer typeid; // 商品类别编号
    private Category category; // 关联的商品类别对象（用于关联查询）

    // 无参构造方法
    public Product() {
    }

    // 有参构造方法（不含关联对象）
    public Product(Integer id, String goodsname, BigDecimal price, Integer typeid) {
        this.id = id;
        this.goodsname = goodsname;
        this.price = price;
        this.typeid = typeid;
    }

    // Getter和Setter方法
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

    // toString方法
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