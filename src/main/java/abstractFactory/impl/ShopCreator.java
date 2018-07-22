package abstractFactory.impl;

import abstractFactory.ShopFactory;

public interface ShopCreator {
    ShopFactory createShop(String title);
}
