package abstractFactory;

import model.MiniMarket;
import model.Shop;

public class MiniMarketFactory implements ShopFactory {

    @Override
    public Shop getShop() { return MiniMarket.getInstance(); }
}