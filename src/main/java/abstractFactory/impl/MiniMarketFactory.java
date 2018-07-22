package abstractFactory.impl;

import abstractFactory.ShopFactory;

public class MiniMarketFactory implements ShopCreator {

    @Override
    public ShopFactory createShop(String title) {
        if("MiniMarket".equals(title)){
            return new abstractFactory.MiniMarketFactory();
        }
        return null;
    }
}
