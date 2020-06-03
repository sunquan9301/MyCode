abstract class TakeAwayManager {
    abstract void doShowAllFoodsByDefaultSortAlgorithm();

    abstract void doShowAllFoodsByUserPreferSortAlgorithm();

    abstract void doShowAllFoodsByShopCommentSortAlgorithm();

    abstract void doShowAllFoodsByShopEnvironmentSortAlgorithm();
}
abstract class User{
    //下订单
    abstract void orderFoods();
    //筛选
    abstract void showShopWithDiffereAlgorithm();
    //blablabla....
}

class OrderBean {
    //订单
}

interface SortAlgorithm {
    //最简单的根据用户和店铺向量化计算相似度呗
    void similaryAlgorithm();

    void recommentAlgorithm();
}

class UserBean {
    private String name;
    private String age;
    private String address;
    private Coupon coupons;
    private String preferFoods;
    private String preferFoodTypes;
}

class Coupon {

}

class shopBean {
    private String shopName;
    private String shopDes;
    private String shopCreateTime;
    private String[] shopDesImages;
    private String shopOwner;
    private ShopType shopType;
    private SpecialFoods[] specialFoods;
    private NormalFoods[] normalFoods;
}

class NormalFoods extends Food {

}

class SpecialFoods extends Food {

}

class Food {
    protected int stock;
    protected String ingredient;
    //...

}

enum ShopType {
    HOT_POT
    //...
}
