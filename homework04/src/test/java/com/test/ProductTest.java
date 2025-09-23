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
    private ProductService productService = new ProductServiceImpl();
    private CategoryService categoryService = new CategoryServiceImpl();

    // 1. 测试添加商品
    @Test
    public void testAddProduct() {
        // 获取类别ID（白色家电ID假设为1，可根据实际查询结果调整）
        Category whiteAppliance = categoryService.getCategoryByTypeName("白色家电");
        Category smartphone = categoryService.getCategoryByTypeName("智能手机");

        // 添加白色家电商品
        Product product1 = new Product(null, "格力空调", new BigDecimal("2999.00"), whiteAppliance.getId());
        Product product2 = new Product(null, "海尔冰箱", new BigDecimal("3299.00"), whiteAppliance.getId());

        // 添加智能手机商品
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

    // 2. 测试核心功能1：查询商品类别为"白色家电"的所有商品信息
    @Test
    public void testGetProductByCategoryName() {
        String categoryName = "白色家电";
        List<Product> productList = productService.getProductByCategoryName(categoryName);

        System.out.println("=== 类别为【" + categoryName + "】的所有商品 ===");
        if (productList.isEmpty()) {
            System.out.println("该类别下无商品");
            return;
        }
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    // 3. 测试核心功能2：商品与商品类别的关联查询（返回完整商品信息）
    @Test
    public void testGetProductWithCategory() {
        List<Product> productList = productService.getProductWithCategory();

        System.out.println("=== 所有商品（包含类别信息） ===");
        if (productList.isEmpty()) {
            System.out.println("暂无商品数据");
            return;
        }
        for (Product product : productList) {
            System.out.println(product);
        }
    }
}