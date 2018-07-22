package threads;

import abstractFactory.ShopFactory;
import abstractFactory.impl.PepitoMarketFactory;
import abstractFactory.impl.ShopCreator;
import model.Category;
import model.Products;
import model.Shop;
import model.enumerations.Status;

import java.util.ArrayList;
import java.util.List;

public class PepitoMarketThread extends Thread {

    @Override
    public  void run() {
        System.out.println("Threat for PepitoMarket was started.");

        ShopCreator shopCreator = new PepitoMarketFactory();
        ShopFactory shopFactory = shopCreator.createShop("PepitoMarket");

        /**adding products to the category*/
        List<Products> new_products = new ArrayList<>();
        new_products.add(new Products(101, 12.50f, "name_1", Status.AVALIABLE, 1));
        new_products.add(new Products(102, 15.50f, "name_2", Status.AVALIABLE, 1));
        new_products.add(new Products(103, 166.50f, "name_3", Status.AVALIABLE, 1));
        new_products.add(new Products(104, 18.50f, "name_4", Status.AVALIABLE, 1));
        new_products.add(new Products(105, 2.50f, "name_5", Status.AVALIABLE, 2));
        new_products.add(new Products(106, 175.50f, "name_6", Status.AVALIABLE, 2));
        new_products.add(new Products(107, 146.50f, "name_7", Status.AVALIABLE, 2));
        new_products.add(new Products(108, 100.50f, "name_8", Status.AVALIABLE, 2));

        Shop shop = shopFactory.getShop();
        shop.addProductToCategories(new_products);

        /**status change*/
        for (Category category : shop.getCategories()){
            List<Products> productsForUpdate = new ArrayList<>();
            if(category.getId()==1){
                shop.changeProductsStatus(category.getProducts(), Status.ABCENT);
            }
            else {
                for (Products product : category.getProducts()){
                    if (product.getId()% 2 != 0){
                        productsForUpdate.add(product);
                    }
                }
                shop.changeProductsStatus(productsForUpdate, Status.EXPECTED);
            }
        }
        /**price change by 20%*/
        for (Category category : shop.getCategories()) {
            List<Products> productsForUpdate = new ArrayList<>();
            for (Products product : category.getProducts()){
                if (product.getStatus().equals(Status.AVALIABLE)){
                    product.setPrice(product.getPrice()*1.2f);
                    productsForUpdate.add(product);
                }
            }
            shop.changePrice(productsForUpdate);
        }

            System.out.println("Threat for PepitoMarket was finished.");
    }
}
