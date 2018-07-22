package threads;

import abstractFactory.ShopFactory;
import abstractFactory.impl.MiniMarketFactory;
import abstractFactory.impl.ShopCreator;
import model.Category;
import model.Products;
import model.Shop;
import model.enumerations.Status;

import java.util.ArrayList;
import java.util.List;

public class MiniMarketThread extends Thread {


    @Override
    public void run() {
        ShopCreator shopCreator = new MiniMarketFactory();
        ShopFactory shopFactory = shopCreator.createShop("MiniMarket");
        System.out.println("Threat for MiniMarket was started.");

        /**adding products to the category*/
        List<Products> new_products = new ArrayList<>();
        new_products.add(new Products(201, 1200.50f, "name_11", Status.AVALIABLE, 3));
        new_products.add(new Products(202, 1500.50f, "name_22", Status.AVALIABLE, 3));
        new_products.add(new Products(203, 1660.50f, "name_33", Status.AVALIABLE, 3));
        new_products.add(new Products(204, 1800.50f, "name_44", Status.AVALIABLE, 3));
        new_products.add(new Products(205, 2000.50f, "name_55", Status.AVALIABLE, 4));
        new_products.add(new Products(206, 1750.50f, "name_66", Status.AVALIABLE, 4));
        new_products.add(new Products(207, 1460.50f, "name_77", Status.AVALIABLE, 4));
        new_products.add(new Products(208, 1000.50f, "name_88", Status.AVALIABLE, 4));

        Shop shop = shopFactory.getShop();
        shop.addProductToCategories(new_products);

        /**status change*/
        for (Category category : shop.getCategories()){
            List<Products> productsForUpdate = new ArrayList<>();
            if(category.getId()==3){
                shop.changeProductsStatus(category.getProducts(), Status.ABCENT);
            }
            else {
                for (Products products : category.getProducts()){
                    if (products.getId()% 2 != 0){
                        productsForUpdate.add(products);
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

        System.out.println("Threat for MiniMarket was finished.");
    }
}
