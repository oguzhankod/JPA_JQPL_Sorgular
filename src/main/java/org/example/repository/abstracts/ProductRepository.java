package org.example.repository.abstracts;

import org.example.entities.Brand;
import org.example.entities.Category;
import org.example.entities.Product;

import java.util.List;


public interface ProductRepository {

    Product saveProduct(Product product);
    Brand saveBrand(Brand brand);
    Category saveCategory(Category category);
    List<Product> findProducts();
    List<Product> findProductsEntities(int firstResult,int maxResult);
    Product findProductById(int productId);
    List<String> findProductNames();
    List<Object[]> findProductNameAndPrice();
    List<Product> findGreatPrice(double unitPrice);
    List<Product> findGreateAndLessPrice(double minUnitPrice,double maxUnitPrice);
    List<Product> findBetweenPrice(double minUnitPrice,double maxUnitPrice);
    List<Product> findLikeProductName(String productName);
    List<Product> findInCategoryName(String categoryName1,String cateogryName2);
    List<Product> findAllProduct(int categoryId);
    List<Object[]> findFunctionsPrice();
    List<Object[]> findGroupByCategory();
    List<Product> findOrderByPrice();


}
