package model;

import model.enumerations.CategoryTitle;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private  int id;
    private CategoryTitle categoryTitle;
    private  int shopsId;
    private List<Products> products = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategoryTitle(CategoryTitle categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public void setShopsId(int shopsId) {
        this.shopsId = shopsId;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }
}
