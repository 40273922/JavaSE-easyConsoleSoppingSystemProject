package pers.evils80386.javase.easy_shop_system.data;

/**
 *
 * Copyright © 2023 ZhaiJinPei-2145619745.qq.com
 * All rights reserved.
 *                 1.addidas 运动鞋 <br/>
 *                 2.Kappa 网球裙 <br/>
 *                 3.网球拍 <br/>
 *                 4.addidas T恤 <br/>
 *                 5.Nike 运动鞋 <br/>
 *                 6.Kappa 网球 <br/>
 *                 7.Kappa T恤 <br/>
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
