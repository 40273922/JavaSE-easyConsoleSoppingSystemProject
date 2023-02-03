/**
 * Copyright © 2023 JinPei Zhai-2145619745.qq.com
 * All rights reserved.
 */
package pers.evils.javase.easyshopsystem.management;

import pers.evils.javase.easyshopsystem.data.Customer;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * <p>
 * <i>Providing payment operation and and using <a href="https://bugs.openjdk.org/browse/JDK-8222530" target="_blank">text blocks</a></i>
 *
 * @author Evils80386
 * @version OpenJDK-17.0.4
 * @Classname {@code Pay}
 */
public class Pay {

    /**
     * Store shopping information
     * <hr>
     * <pre>
     *     {@code
     *      static String[][] info = new String[100][4];
     *      }
     * </pre>
     * <hr>
     *
     * @see Pay#calc(int, String, String)
     * @see Pay#printInfo(int)
     * @see Pay#scoreCalc(int)
     */
    static String[][] info = new String[100][4];

    /**
     * Total amount stored
     * <hr>
     * <pre>
     *     {@code
     *     static float amountAll = 0;
     *     }
     * </pre>
     * <hr>
     *
     * @see Pay#pay(String, String)
     * @see Pay#calc(int, String, String)
     */
    static float amountAll = 0;

    /**
     * payment operation implement
     * <hr>
     * <pre>
     *     {@code
     *      public static void pay(String custName,String custPassword){
     *       Scanner scanner = new Scanner(System.in);
     *       System.out.print("输入会员号:");
     *       String custNo = scanner.next();
     *       boolean flag = Customer.custInfo.containsKey(custNo);
     *       int i = 0;
     *       if (flag){
     *           String str;
     *           do {
     *               calc(i);
     *               str = scanner.next();
     *               i++;
     *           }while (str.equals("y"));
     *           System.out.println("""
     *                       -------------------消费清单-------------------
     *                              物品      单价      个数     金额""");
     *               printInfo(i);
     *               System.out.print("折扣:\t0.95\n总计:\t￥" + amountAll + "\n支付:");
     *               float real = scanner.nextFloat();
     *               changeCalc(real,amountAll);
     *               int score = scoreCalc(i);
     *               System.out.println("购物所得积分:\t" + score);
     *               Customer.custInfo.get(custNo)[1] = score + Integer.parseInt(Customer.custInfo.get(custNo)[1]) + "";
     *               Pay.amountAll = 0;
     *               if (VerifyEqual.flag()) {
     *                   Menu.custHomeMenu(custName,custPassword);
     *               }
     *       }else {
     *           System.out.println("error");
     *           Menu.payMenu(custName,custPassword);
     *       }
     *   }}
     * </pre>
     * <hr>
     *
     * @param custName     ligament to customer identification
     * @param custPassword ligament to customer identification
     * @see System#out
     * @see java.io.PrintStream#println(String)
     * @see java.io.PrintStream#print(String)
     * @see Scanner#Scanner(InputStream)
     * @see Scanner#next()
     * @see java.util.HashMap#containsKey(Object)
     * @see String#equals(Object)
     * @see java.util.HashMap#get(Object)
     * @see Menu#payMenu(String, String)
     * @see Menu#custHomeMenu(String, String)
     * @see VerifyEqual#flag()
     * @see Pay#printInfo(int)
     * @see Pay#calc(int, String, String)
     * @see Pay#changeCalc(float, float)
     */
    public static void pay(String custName, String custPassword) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n输入会员号:");
        String custNo = scanner.next();
        boolean flag = Customer.custInfo.containsKey(custNo);
        int i = 0;
        if (flag) {
            String str;
            do {
                calc(i, custName, custPassword);
                System.out.print("继续(y/n):");
                str = scanner.next();
                i++;
            } while (str.equals("y"));
            System.out.println("""
                    -------------------消费清单-------------------
                           物品      单价      个数     金额""");
            printInfo(i);
            System.out.print("折扣:\t0.95\n总计:\t￥" + amountAll + "\n支付:\t￥");
            float real = scanner.nextFloat();
            changeCalc(real, amountAll);
            int score = scoreCalc(i);
            System.out.println("购物所得积分:\t" + score);
            Customer.custInfo.get(custNo)[1] = score + Integer.parseInt(Customer.custInfo.get(custNo)[1]) + "";
            Pay.amountAll = 0;
            if (VerifyEqual.flag()) {
                Menu.custHomeMenu(custName, custPassword);
            }
        } else {
            System.out.println("error");
            Menu.custHomeMenu(custName, custPassword);
        }
    }

    /**
     * calculate total amount and store information
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
     * <hr>
     * <pre>
     *     {@code
     *     public static void calc(int i,String custName,String custPassword){
     *       try {
     *           Scanner scanner = new Scanner(System.in);
     *           System.out.print("输入编号:");
     *           int num = scanner.nextInt();
     *           System.out.print("输入数目:");
     *           int num2 = scanner.nextInt();
     *           String nums = "" + num2;
     *           switch (num) {
     *               case 1 -> {
     *                   info[i] = new String[]{"addidas 运动鞋", "￥420.78", nums, "￥" + 420.78 * num2};
     *                   amountAll += 420.78 * num2;
     *               }
     *               case 2 -> {
     *                   info[i] = new String[]{"Kappa 网球裙", "￥200", nums, "￥" + 200 * num2};
     *                   amountAll += 200 * num2;
     *               }
     *               case 3 -> {
     *                   info[i] = new String[]{"网球拍  ", "￥780", nums, "￥" + 780 * num2};
     *                   amountAll += 780 * num;
     *               }
     *               case 4 -> {
     *                   info[i] = new String[]{"addidas T恤", "￥880", nums, "￥" + 880 * num2};
     *                   amountAll += 880 * num2;
     *               }
     *               case 5 -> {
     *                   info[i] = new String[]{"Nike 运动鞋", "￥900", nums, "￥" + 900 * num2};
     *                   amountAll += 900 * num2;
     *               }
     *               case 6 -> {
     *                   info[i] = new String[]{"Kappa 网球 ", "￥45", nums, "￥" + 45 * num2};
     *                   amountAll += 45 * num2;
     *               }
     *               case 7 -> {
     *                   info[i] = new String[]{"Kappa T恤 ", "￥245", nums, "￥" + 245 * num2};
     *                   amountAll += 245 * num2;
     *               }
     *               default -> {
     *                   System.out.println("error!");
     *                   Pay.pay(custName,custPassword);
     *               }
     *           }
     *       }catch (Exception e){
     *           System.out.println("input error!");
     *           Pay.pay(custName,custPassword);
     *       }
     *   }}
     * </pre>
     * <hr>
     *
     * @param i Recording elements' frequency
     * @see System#out
     * @see PrintStream#print(String)
     * @see Scanner#Scanner(InputStream)
     * @see Scanner#nextInt()
     * @see Pay#pay(String, String)
     */
    public static void calc(int i, String custName, String custPassword) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("输入编号:");
            int num = scanner.nextInt();
            System.out.print("输入数目:");
            int num2 = scanner.nextInt();
            String nums = "" + num2;
            switch (num) {
                case 1 -> {
                    info[i] = new String[]{"addidas 运动鞋", "￥420.78", nums, "￥" + 420.78 * num2};
                    amountAll += 420.78 * num2;
                }
                case 2 -> {
                    info[i] = new String[]{"Kappa 网球裙", "￥200", nums, "￥" + 200 * num2};
                    amountAll += 200 * num2;
                }
                case 3 -> {
                    info[i] = new String[]{"网球拍  ", "￥780", nums, "￥" + 780 * num2};
                    amountAll += 780 * num;
                }
                case 4 -> {
                    info[i] = new String[]{"addidas T恤", "￥880", nums, "￥" + 880 * num2};
                    amountAll += 880 * num2;
                }
                case 5 -> {
                    info[i] = new String[]{"Nike 运动鞋", "￥900", nums, "￥" + 900 * num2};
                    amountAll += 900 * num2;
                }
                case 6 -> {
                    info[i] = new String[]{"Kappa 网球 ", "￥45", nums, "￥" + 45 * num2};
                    amountAll += 45 * num2;
                }
                case 7 -> {
                    info[i] = new String[]{"Kappa T恤 ", "￥245", nums, "￥" + 245 * num2};
                    amountAll += 245 * num2;
                }
                default -> System.out.println("error!");
            }
        } catch (Exception e) {
            amountAll = 0;
            System.out.println("input error!");
            Pay.pay(custName, custPassword);
        }
    }

    /**
     * printInfo
     * <hr>
     * <pre>
     *     {@code
     *    public static void printInfo(int i){
     *         for (int j = 0; j < i; j++) {
     *             if (info[j][0] == null){
     *                 continue;
     *             }
     *             for (int k = 0; k < info[j].length; k++) {
     *                 System.out.print(info[j][k] + "\t");
     *             }
     *             System.out.println();
     *         }
     *     }}
     * </pre>
     * <hr>
     *
     * @param i sync-print information to console
     * @see System#out
     * @see PrintStream#print(String)
     * @see PrintStream#println()
     * @see Pay#pay(String, String)
     */
    public static void printInfo(int i) {
        for (int j = 0; j < i; j++) {
            if (info[j][0] == null) {
                continue;
            }
            for (int k = 0; k < info[j].length; k++) {
                System.out.print(info[j][k] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * calculate score
     * <hr>
     * <pre>
     *     {@code
     *       public static int scoreCalc(int i){
     *         int score = 0;
     *         for (int j = 0; j < i; j++) {
     *             if (info[j][0] == null){
     *                 continue;
     *             }
     *                 score += Integer.parseInt(info[j][2])*9;
     *         }
     *         return score;
     *     }}
     * </pre>
     * <hr>
     *
     * @param i sync-print information to console
     * @return {@code int}-<i>score</i>
     * @see Integer#parseInt(String)
     * @see Pay#pay(String, String)
     */
    public static int scoreCalc(int i) {
        int score = 0;
        for (int j = 0; j < i; j++) {
            if (info[j][0] == null) {
                continue;
            }
            score += Integer.parseInt(info[j][2]) * 9;
        }
        return score;
    }

    /**
     * calculate changes
     * <hr>
     * <pre>
     *     {@code
     *      public static void changeCalc(float real,float amountAll){
     *         float a = real;
     *         float b = amountAll;
     *         if ((a - b)>0){
     *             System.out.printf("找钱:\t￥%.2f" , (a - b));
     *             System.out.println();
     *         }else {
     *             System.out.print("继续支付:");
     *             Scanner scanner = new Scanner(System.in);
     *             b = b - a;
     *             a = scanner.nextFloat();
     *             changeCalc(a,b);
     *         }
     *     }}
     * </pre>
     * <hr>
     *
     * @param real      realPay
     * @param amountAll Total amount
     * @see System#out
     * @see java.io.PrintStream#println(String)
     * @see java.io.PrintStream#print(String)
     * @see Scanner#Scanner(InputStream)
     * @see Scanner#nextFloat()
     * @see Pay#pay(String, String)
     * @see Pay#changeCalc(float, float)
     */
    public static void changeCalc(float real, float amountAll) {
        float a = real;
        float b = amountAll;
        if ((a - b) > 0) {
            System.out.printf("找钱:\t￥%.2f", (a - b));
            System.out.println();
        } else {
            System.out.print("继续支付:\t");
            Scanner scanner = new Scanner(System.in);
            b = b - a;
            a = scanner.nextFloat();
            changeCalc(a, b);
        }
    }
}
