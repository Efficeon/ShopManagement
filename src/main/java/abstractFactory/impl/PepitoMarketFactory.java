package abstractFactory.impl;

import abstractFactory.ShopFactory;

public class PepitoMarketFactory implements ShopCreator {

    @Override
    public ShopFactory createShop(String title) {
        if ("PepitoMarket".equals(title)){
            return new abstractFactory.PepitoMarketFactory();
        }
        return null;
    }
}
