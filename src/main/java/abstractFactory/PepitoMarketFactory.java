package abstractFactory;

import model.PepitoMarket;
import model.Shop;

public class PepitoMarketFactory implements ShopFactory {

    @Override
    public Shop getShop() {
        return PepitoMarket.getInstance();
    }
}