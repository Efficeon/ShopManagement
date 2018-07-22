package model;

import model.enumerations.Status;

import java.util.List;

public interface Shop {

    int getId();

    void setId(int id);

    void setTitle(String title);

    void setCategories(List<Category> categories);

    List<Category> getCategories();

    void changePrice(List<Products> products);

    void addProductToCategories(List<Products> products);

    void changeProductsStatus(List<Products> products, Status status);
}
