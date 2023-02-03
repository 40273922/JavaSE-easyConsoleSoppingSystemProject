/**
 * Copyright © 2023 JinPei Zhai-2145619745.qq.com
 * All rights reserved.
 */
package pers.evils.javase.easyshopsystem.data;

import pers.evils.javase.easyshopsystem.management.GiftManagement;

/**
 * <table class="striped" >
 *     <caption style="display:none">Shows Goods' List</caption>
 *     <thead>
 *         <tr><th scope="col">Goods</th>
 *         <th scope="col">Price</th></tr>
 *     </thead>
 *     <tbody>
 *       <tr><td>addidas 运动鞋 </td>
 *           <td>￥420.78</td></tr>
 *       <tr><td>Kappa 网球裙  </td>
 *           <td>￥200</td></tr>
 *       <tr><td>网球拍  </td>
 *           <td>￥780</td></tr>
 *       <tr><td>addidas T恤 </td>
 *           <td>￥880</td></tr>
 *       <tr><td>Nike 运动鞋  </td>
 *           <td>￥900</td></tr>
 *       <tr><td>.Kappa 网球  </td>
 *           <td>￥45</td></tr>
 *       <tr><td>Kappa T恤  </td>
 *           <td>￥245</td></tr>
 *     </tbody>
 * </table><br>
 *
 * <p>
 *     <i>The quantity of these goods is fixed</i>
 *
 * @author Evils80386
 * @version OpenJDK-17.0.4
 * @Classname {@code Goods}
 */

public class Goods {
    /**
     * goods' price
     * <hr>
     * <pre>
     *     {@code
     *      public static final double[] goods = new double[]{420.78,200,780,880,900,45,245};
     *      }
     * </pre>
     * <hr>
     * <em>array of goods' prices</em>
     *
     * @see Goods#goodsGiving(int)
     */
    public static final double[] goods = new double[]{420.78, 200, 780, 880, 900, 45, 245};

    /**
     * goodsGiving implement
     * <hr>
     * <pre>
     *     {@code
     *       public static int goodsGiving(int num){
     *         for (int i = 0; i < goods.length - num; i++) {
     *             num *= goods[i] + 100;
     *         }
     *         return num;
     *     }}
     * </pre>
     * <hr>
     *
     * @param num {@code int}-<i>customer inputting</i>
     * @return {@code int}-<i>number which scanner have had</i>
     * @see GiftManagement#fortuneGiving(String, String)
     */
    public static int goodsGiving(int num) {
        for (int i = 0; i < goods.length - num; i++) {
            num *= goods[i] + 100;
        }
        return num;
    }
}
