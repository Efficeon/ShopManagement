package dao;

import model.Products;

import java.util.List;

public interface ProductsDao {
    void create(Products product);
    void update(Products product);
    List<Products> getByCategoriesId(int id);
}