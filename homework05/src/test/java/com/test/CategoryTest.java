package com.test;

import com.entity.Category;
import com.service.CategoryService;
import com.service.impl.CategoryServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CategoryTest {
    // 注入业务层对象（面向接口编程）
    private CategoryService categoryService = new CategoryServiceImpl();

    // 测试1：新增商品类别
    @Test
    public void testAddCategory() {
        // 创建类别对象
        Category category1 = new Category("白色家电");
        Category category2 = new Category("智能手机");
        Category category3 = new Category("笔记本电脑");

        // 调用业务层方法
        boolean res1 = categoryService.addCategory(category1);
        boolean res2 = categoryService.addCategory(category2);
        boolean res3 = categoryService.addCategory(category3);

        // 打印结果
        System.out.println("添加白色家电：" + (res1 ? "成功" : "失败"));
        System.out.println("添加智能手机：" + (res2 ? "成功" : "失败"));
        System.out.println("添加笔记本电脑：" + (res3 ? "成功" : "失败"));
    }

    // 测试2：查询所有类别
    @Test
    public void testGetAllCategory() {
        List<Category> categoryList = categoryService.getAllCategory();
        System.out.println("=== 所有商品类别 ===");
        for (Category category : categoryList) {
            System.out.println(category);
        }
    }
}