package com.test;

import com.entity.Category;
import com.entity.Product;
import com.service.CategoryService;
import com.service.ProductService;
import com.service.impl.CategoryServiceImpl;
import com.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

public class ProductTest {
    // 注入业务层对象
    private ProductService productService = new ProductServiceImpl();
    private CategoryService categoryService = new CategoryServiceImpl();

    // 测试1：新增商品（需先运行CategoryTest新增类别）
    @Test
    public void testAddProduct() {


        // 1. 查询类别：先判断“白色家电”是否已存在
        Category whiteAppliance = categoryService.getCategoryByTypeName("白色家电");
        // 若不存在，才添加（避免重复）
        if (whiteAppliance == null) {
            whiteAppliance = new Category(null, "白色家电");
            categoryService.addCategory(whiteAppliance);
            // 重新查询，获取新增后的类别（含id）
            whiteAppliance = categoryService.getCategoryByTypeName("白色家电");
        }

        // 2. 同理处理“智能手机”类别
        Category smartphone = categoryService.getCategoryByTypeName("智能手机");
        if (smartphone == null) {
            smartphone = new Category(null, "智能手机");
            categoryService.addCategory(smartphone);
            smartphone = categoryService.getCategoryByTypeName("智能手机");
        }

        // 3. 添加商品（此时类别唯一，不会触发重复查询问题）
        Product product1 = new Product(null, "格力空调", new BigDecimal("2999.00"), whiteAppliance.getId());
        Product product2 = new Product(null, "海尔冰箱", new BigDecimal("3299.00"), whiteAppliance.getId());
        Product product3 = new Product(null, "苹果iPhone 15", new BigDecimal("5999.00"), smartphone.getId());
        Product product4 = new Product(null, "华为Mate 60", new BigDecimal("4999.00"), smartphone.getId());

        boolean res1 = productService.addProduct(product1);
        boolean res2 = productService.addProduct(product2);
        boolean res3 = productService.addProduct(product3);
        boolean res4 = productService.addProduct(product4);

        System.out.println("添加格力空调：" + (res1 ? "成功" : "失败"));
        System.out.println("添加海尔冰箱：" + (res2 ? "成功" : "失败"));
        System.out.println("添加苹果iPhone 15：" + (res3 ? "成功" : "失败"));
        System.out.println("添加华为Mate 60：" + (res4 ? "成功" : "失败"));
    }

    // 测试2：查询指定类别（白色家电）的商品
    @Test
    public void testGetProductByCategoryName() {
        String categoryName = "白色家电";
        List<Product> productList = productService.getProductByCategoryName(categoryName);

        System.out.println("=== 类别【" + categoryName + "】的所有商品 ===");
        if (productList.isEmpty()) {
            System.out.println("该类别下无商品");
            return;
        }
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    // 测试3：查询所有商品（包含类别信息）
    @Test
    public void testGetProductWithCategory() {
        List<Product> productList = productService.getProductWithCategory();

        System.out.println("=== 所有商品（含类别信息） ===");
        if (productList.isEmpty()) {
            System.out.println("暂无商品数据");
            return;
        }
        for (Product product : productList) {
            System.out.println(product);
        }
    }
}