package com.test;

import com.entity.Category;
import com.service.CategoryService;
import com.service.impl.CategoryServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CategoryTest {
    private CategoryService categoryService = new CategoryServiceImpl();

    // 测试添加商品类别
    @Test
    public void testAddCategory() {
        Category category1 = new Category(null, "白色家电");
        Category category2 = new Category(null, "智能手机");
        Category category3 = new Category(null, "笔记本电脑");

        boolean res1 = categoryService.addCategory(category1);
        boolean res2 = categoryService.addCategory(category2);
        boolean res3 = categoryService.addCategory(category3);

        System.out.println("添加白色家电类别：" + (res1 ? "成功" : "失败"));
        System.out.println("添加智能手机类别：" + (res2 ? "成功" : "失败"));
        System.out.println("添加笔记本电脑类别：" + (res3 ? "成功" : "失败"));
    }

    // 测试查询所有商品类别
    @Test
    public void testGetAllCategory() {
        List<Category> categoryList = categoryService.getAllCategory();
        System.out.println("所有商品类别：");
        for (Category category : categoryList) {
            System.out.println(category);
        }
    }
}