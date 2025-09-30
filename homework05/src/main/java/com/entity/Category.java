package com.entity;

public class Category {
    private Integer id; // 商品类别编号
    private String typename; // 商品类别名称

    // 无参构造
    public Category() {
    }

    // 有参构造（不含id，用于新增）
    public Category(String typename) {
        this.typename = typename;
    }

    // 全参构造
    public Category(Integer id, String typename) {
        this.id = id;
        this.typename = typename;
    }

    // Getter & Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    // toString（用于打印结果）
    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", typename='" + typename + '\'' +
                '}';
    }
}