package org.example.repository.concretes;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.example.entities.Brand;
import org.example.entities.Category;
import org.example.entities.Product;
import org.example.jpaFactory.abstracts.JPAFactory;
import org.example.jpaFactory.concretes.JPAFactoryImpl;
import org.example.queries.ProductQueries;
import org.example.repository.abstracts.ProductRepository;

import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    private JPAFactory jpaFactory = new JPAFactoryImpl();
    private EntityManager entityManager = jpaFactory.getEntityManager();
    private EntityTransaction entityTransaction = jpaFactory.getTransaction();

    @Override
    public Product saveProduct(Product product) {

        entityTransaction.begin();
        entityManager.persist(product);
        entityTransaction.commit();


        return product;
    }

    @Override
    public Brand saveBrand(Brand brand) {

        entityTransaction.begin();
        entityManager.persist(brand);
        entityTransaction.commit();

        return brand;
    }

    @Override
    public Category saveCategory(Category category) {

        entityTransaction.begin();
        entityManager.persist(category);
        entityTransaction.commit();
        return category;
    }

    @Override
    public List<Product> findProducts() {

        TypedQuery<Product> typedQuery = entityManager.createQuery(ProductQueries.findProducts,Product.class);

        List<Product> products = typedQuery.getResultList();

        return products;
    }

    @Override
    public List<Product> findProductsEntities(int firstResult, int maxResult) {

        TypedQuery<Product> typedQuery = entityManager.createQuery(ProductQueries.findProducts,Product.class);
        typedQuery.setFirstResult(firstResult);
        typedQuery.setMaxResults(maxResult);

        List<Product> products = typedQuery.getResultList();
        return products;
    }

    @Override
    public Product findProductById(int productId) {

        TypedQuery<Product> typedQuery = entityManager.createQuery(ProductQueries.findProductById,Product.class);
        typedQuery.setParameter("productId",productId);
        Product product = typedQuery.getSingleResult();

        return product;
    }

    @Override
    public List<String> findProductNames() {

        TypedQuery<String> typedQuery = entityManager.createQuery(ProductQueries.findProductNames,String.class);
        List<String> productNames = typedQuery.getResultList();

        return productNames;
    }

    @Override
    public List<Object[]> findProductNameAndPrice() {

        //TYPEDQUERY'DE DIZI BELIRTLILEMEDI ICIN QUERY YAZMKATAYIZ
        Query query  =entityManager.createQuery(ProductQueries.findProductNamePrice);
        List<Object[]> productNameAndPrice = query.getResultList();


        return productNameAndPrice;
    }

    @Override
    public List<Product> findGreatPrice(double unitPrice) {

        TypedQuery<Product> typedQuery = entityManager.createQuery(ProductQueries.findGreatPrice,Product.class);

        typedQuery.setParameter("unitPrice",unitPrice);
        List<Product> greatPrice = typedQuery.getResultList();
        return greatPrice;
    }

    @Override
    public List<Product> findGreateAndLessPrice(double minUnitPrice, double maxUnitPrice) {

        TypedQuery<Product> typedQuery = entityManager.createQuery(ProductQueries.findGreatLessPrice,Product.class);
        typedQuery.setParameter("minUnitPrice",maxUnitPrice);
        typedQuery.setParameter("maxUnitPrice",maxUnitPrice);

        List<Product> greatAndLess = typedQuery.getResultList();
        return greatAndLess;
    }

    @Override
    public List<Product> findBetweenPrice(double minUnitPrice, double maxUnitPrice) {

        TypedQuery<Product> typedQuery = entityManager.createQuery(ProductQueries.findBetweenPrice,Product.class);
        typedQuery.setParameter("minUnitPrice",minUnitPrice);
        typedQuery.setParameter("maxUnitPrice",maxUnitPrice);

        List<Product> between = typedQuery.getResultList();

        return between;
    }

    @Override
    public List<Product> findLikeProductName(String productName) {

        TypedQuery<Product> typedQuery = entityManager.createQuery(ProductQueries.findLikeProductName,Product.class);

        //like komutu ıcın %
        typedQuery.setParameter("productName","%"+productName+"%");

        List<Product> like = typedQuery.getResultList();
        return like;
    }

    @Override
    public List<Product> findInCategoryName(String categoryName1, String cateogryName2) {
        TypedQuery<Product> typedQuery = entityManager.createQuery(ProductQueries.findInCategoryName,Product.class);
        typedQuery.setParameter("categoryName1",categoryName1);
        typedQuery.setParameter("categoryName2",cateogryName2);
        List<Product> products = typedQuery.getResultList();

        return products;
    }

    @Override
    public List<Product> findAllProduct(int categoryId) {
        TypedQuery<Product> typedQuery = entityManager.createQuery(ProductQueries.findAllProduct,Product.class);
        typedQuery.setParameter("categoryId",categoryId);

        List<Product> products = typedQuery.getResultList();


        return products;
    }

    @Override
    public List<Object[]> findFunctionsPrice() {
        Query query  =entityManager.createQuery(ProductQueries.findFunctionsPrice);

        List<Object[]> fucntion = query.getResultList();
        return fucntion;
    }

    @Override
    public List<Object[]> findGroupByCategory() {

        Query query = entityManager.createQuery(ProductQueries.findGroupByCategory);
        List<Object[]> group = query.getResultList();

        return group;
    }


    @Override
    public List<Product> findOrderByPrice() {

        TypedQuery<Product> typedQuery = entityManager.createQuery(ProductQueries.findOrderByPrice,Product.class);

        List<Product> products = typedQuery.getResultList();
        return products;
    }
}
