package model;

import dao.ProductsDao;
import dao.ShopDao;
import dao.jdbc.ProductsJdbcDao;
import dao.jdbc.ShopJdbcDao;
import model.enumerations.Status;

import java.util.ArrayList;
import java.util.List;

public class PepitoMarket implements Shop {
    private static PepitoMarket instance;
    private static ShopDao shopDao = new ShopJdbcDao();

    private int id;
    private String title;
    private List<Category> categories = new ArrayList<>();

    private PepitoMarket() {
    }

    public static Shop getInstance() {
        if (instance == null) {
            synchronized (PepitoMarket.class) {
                if (instance == null) {
                    instance = new PepitoMarket();
                    instance.setId(1);
                    instance = (PepitoMarket) shopDao.read(instance);
                }
            }
        }
        return instance;
    }

    public void changePrice(List<Products> products){
        ProductsDao productsDao = new ProductsJdbcDao();
        for (Products product : products){
            productsDao.update(product);
        }
    }

    public void addProductToCategories(List<Products> products){
        for (Category category : instance.getCategories()){
            for (Products product : products){
                if (category.getId() == product.getCategoryId())
                    category.getProducts().add(product);
            }
        }

        ProductsJdbcDao productsJdbcDao = new ProductsJdbcDao();
        for (Products product : products){
            productsJdbcDao.create(product);
        }
    }

    public void changeProductsStatus(List<Products> products, Status status){
        ProductsDao productsDao = new ProductsJdbcDao();
        for (Category category:instance.getCategories()){
                for (Products product : products){
                    if (category.getId() == product.getCategoryId()){
                        product.setStatus(status);
                        productsDao.update(product);
                    }
                }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "PepitoMarket{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", categories=" + categories +
                '}';
    }
}
