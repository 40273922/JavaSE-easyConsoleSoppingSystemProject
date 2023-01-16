package pers.evils80386.javase.easy_shop_system.management;

import pers.evils80386.javase.easy_shop_system.data.Customer;

import java.util.Scanner;

/**
 * @Classname Pay
 * @Created by Evils80386
 */
public class Pay {
    static String[][] info = new String[100][4];
    static float amountAll = 0;
    static int score = 0;

    /**
     *
     * @param custName-ligament_to_customer_identification
     * @param custPassword-ligament_to_customer_identification
     */
  public static void pay(String custName,String custPassword){
      Scanner scanner = new Scanner(System.in);
      System.out.print("请输入会员号: ");
      String custNo = scanner.next();
      boolean flag = Customer.custInfo.containsKey(custNo);
      int i = 0;
      if (flag){
          String str;
          do {
              score += calc(i,custNo);
              str = scanner.next();
              i++;
          }while (str.equals("y"));
          System.out.println("""
                      *************************消费清单*************************
                            物品            单价            个数           金额
                      """);
              printInfo(i);
              System.out.print("折扣:\t0.95\n金额总计:\t￥" + amountAll + "\n实际缴费: ");
              float real = scanner.nextFloat();
              System.out.println("找钱：\t￥" + (real - amountAll));
              System.out.println("本次购物所获得的积分是：\t" + score);
              Pay.amountAll = 0;
              score = 0;
              if (VerifyEqual.flag()) {
                  Menu.custHomeMenu(custName,custPassword);
              }
      }else {
          System.out.println("会员不存在。");
          Menu.payMenu(custName,custPassword);
      }
  }

    /**
     * 1.addidas运动鞋 ￥420.78
     * 2.Kappa网球裙   ￥200
     * 3.网球拍        ￥780
     * 4.addidasT恤    ￥880
     * 5.Nike运动鞋    ￥900
     * 6.Kappa网球     ￥45
     * 7.KappaT恤      ￥245
     *
     * @param i-record_element_info
     * @param custNo-select_from_HashMap
     * @return score
     */
  public static int calc(int i,String custNo){
      Scanner scanner = new Scanner(System.in);
      System.out.print("请输入商品编号：");
      int num = scanner.nextInt();
      System.out.print("请输入数目： ");
      int num2 = scanner.nextInt();
      String nums = "" + num2;
      switch (num) {
          case 1 -> {
              Customer.custInfo.get(custNo)[1] = num2 * 9 + Integer.parseInt(Customer.custInfo.get(custNo)[1]) + "";
              info[i] = new String[]{"addidas运动鞋", "￥420.78", nums, "" + 420.78 * num2};
              amountAll += 420.78 * num2;
              score += num2 * 9;
          }
          case 2 -> {
              Customer.custInfo.get(custNo)[1] = num2 * 9 + Integer.parseInt(Customer.custInfo.get(custNo)[1]) + "";
              info[i] = new String[]{"Kappa网球裙", "￥200", nums, "" + 200 * num2};
              amountAll += 200 * num2;
              score += num2 * 9;
          }
          case 3 -> {
              Customer.custInfo.get(custNo)[1] = num2 * 9 + Integer.parseInt(Customer.custInfo.get(custNo)[1]) + "";
              info[i] = new String[]{"网球拍  ", "￥780", nums, "" + 780 * num2};
              amountAll += 780 * num;
              score += num2 * 9;
          }
          case 4 -> {
              Customer.custInfo.get(custNo)[1] = num2 * 9 + Integer.parseInt(Customer.custInfo.get(custNo)[1]) + "";
              info[i] = new String[]{"addidasT恤", "￥880", nums, "" + 880 * num2};
              amountAll += 880 * num2;
              score += num2 * 9;
          }
          case 5 -> {
              Customer.custInfo.get(custNo)[1] = num2 * 9 + Integer.parseInt(Customer.custInfo.get(custNo)[1]) + "";
              info[i] = new String[]{"Nike运动鞋", "￥900", nums, "" + 900 * num2};
              amountAll += 900 * num2;
              score += num2 * 9;
          }
          case 6 -> {
              Customer.custInfo.get(custNo)[1] = num2 * 9 + Integer.parseInt(Customer.custInfo.get(custNo)[1]) + "";
              info[i] = new String[]{"Kappa网球 ", "￥45", nums, "" + 45 * num2};
              amountAll += 45 * num2;
              score += num2 * 9;
          }
          case 7 -> {
              Customer.custInfo.get(custNo)[1] = num2 * 9 + Integer.parseInt(Customer.custInfo.get(custNo)[1]) + "";
              info[i] = new String[]{"KappaT恤 ", "￥245", nums, "" + 245 * num2};
              amountAll += 245 * num2;
              score += num2 * 9;
          }
          default -> {
          }
      }
      System.out.print("是否继续(y/n) ");
      return score;
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
}
