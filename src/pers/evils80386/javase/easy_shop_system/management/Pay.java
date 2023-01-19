package pers.evils80386.javase.easy_shop_system.management;

import pers.evils80386.javase.easy_shop_system.data.Customer;

import java.util.Scanner;

/**
 *
 * Copyright © 2023 ZhaiJinPei-2145619745.qq.com
 * All rights reserved.
 * @Classname Pay
 * @Created by Evils80386
 */
public class Pay {
    static String[][] info = new String[100][4];
    static float amountAll = 0;

    /**
     *
     * @param custName-ligament_to_customer_identification
     * @param custPassword-ligament_to_customer_identification
     */
  public static void pay(String custName,String custPassword){
      Scanner scanner = new Scanner(System.in);
      System.out.print("请输入会员号:");
      String custNo = scanner.next();
      boolean flag = Customer.custInfo.containsKey(custNo);
      int i = 0;
      if (flag){
          String str;
          do {
              calc(i);
              str = scanner.next();
              i++;
          }while (str.equals("y"));
          System.out.println("""
                      *******************消费清单***********************
                             物品      单价      个数     金额""");
              printInfo(i);
              System.out.print("折扣:\t0.95\n金额总计:\t￥" + amountAll + "\n请缴费: ");
              float real = scanner.nextFloat();
              changeCalc(real,amountAll);
              int score = scoreCalc(i);
              System.out.println("本次购物所得积分:\t" + score);
              Customer.custInfo.get(custNo)[1] = score + Integer.parseInt(Customer.custInfo.get(custNo)[1]) + "";
              Pay.amountAll = 0;
              if (VerifyEqual.flag()) {
                  Menu.custHomeMenu(custName,custPassword);
              }
      }else {
          System.out.println("无此会员");
          Menu.payMenu(custName,custPassword);
      }
  }

    /**
     * 1.addidas 运动鞋  ￥420.78 <br/>
     * 2.Kappa 网球裙    ￥200 <br/>
     * 3.网球拍          ￥780 <br/>
     * 4.addidas T恤    ￥880 <br/>
     * 5.Nike 运动鞋     ￥900 <br/>
     * 6.Kappa 网球      ￥45 <br/>
     * 7.Kappa T恤       ￥245 <br/>
     *
     * @param i-record_element_info
     */
  public static void calc(int i){
      Scanner scanner = new Scanner(System.in);
      System.out.print("请输入商品编号:");
      int num = scanner.nextInt();
      System.out.print("请输入数目:");
      int num2 = scanner.nextInt();
      String nums = "" + num2;
      switch (num) {
          case 1 -> {
              info[i] = new String[]{"addidas 运动鞋", "￥420.78", nums, "" + 420.78 * num2};
              amountAll += 420.78 * num2;
          }
          case 2 -> {
              info[i] = new String[]{"Kappa 网球裙", "￥200", nums, "" + 200 * num2};
              amountAll += 200 * num2;
          }
          case 3 -> {
              info[i] = new String[]{"网球拍  ", "￥780", nums, "" + 780 * num2};
              amountAll += 780 * num;
          }
          case 4 -> {
              info[i] = new String[]{"addidas T恤", "￥880", nums, "" + 880 * num2};
              amountAll += 880 * num2;
          }
          case 5 -> {
              info[i] = new String[]{"Nike 运动鞋", "￥900", nums, "" + 900 * num2};
              amountAll += 900 * num2;
          }
          case 6 -> {
              info[i] = new String[]{"Kappa 网球 ", "￥45", nums, "" + 45 * num2};
              amountAll += 45 * num2;
          }
          case 7 -> {
              info[i] = new String[]{"Kappa T恤 ", "￥245", nums, "" + 245 * num2};
              amountAll += 245 * num2;
          }
          default -> {
          }
      }
      System.out.print("是否继续(y/n):");
  }

    /**
     *
     * @param i-sync_print_info_to_console
     */
    public static void printInfo(int i){
        for (int j = 0; j < i; j++) {
            for (int k = 0; k < 4; k++) {
                System.out.print(info[j][k] + "\t");
            }
            System.out.println();
        }
    }

    /**
     *
     * @param i-sync_print_info_to_console
     * @return score
     */
    public static int scoreCalc(int i){
        int score = 0;
        for (int j = 0; j < i; j++) {
                score += Integer.parseInt(info[j][2])*9;
        }
        return score;
    }

    /**
     *
     * @param real-realPay
     * @param amountAll-amountAll
     */
    public static void changeCalc(float real,float amountAll){
        float a = real;
        float b = amountAll;
        if ((a - b)>0){
            System.out.println("找钱:\t￥" + (a - b));
        }else {
            System.out.print("支付金额不足!\n请继续缴费:");
            Scanner scanner = new Scanner(System.in);
            b = b -a;
            a = scanner.nextFloat();
            changeCalc(a,b);
        }
    }
}
