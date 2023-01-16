package pers.evils80386.javase.easy_shop_system.data;

/**
 *                 1.addidas运动鞋<br/>
 *                 2.Kappa网球裙<br/>
 *                 3.网球拍<br/>
 *                 4.addidasT恤<br/>
 *                 5.Nike运动鞋<br/>
 *                 6.Kappa网球<br/>
 *                 7.KappaT恤<br/>
 * @Classname Goods
 */

public class Goods {
    /**
     * @Description goods_prices
     */
    public static final double[] goods = new double[]{420.78,200,780,880,900,45,245};

    /**
     *
     * @param num-from_customer_input
     * @return num
     */
    public static int goodsGiving(int num){
        //TODO
        for (int i = 0; i < goods.length - num; i++) {
            num *= goods[i] + 100;
        }
        return num;
    }
}
