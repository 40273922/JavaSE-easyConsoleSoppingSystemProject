package pers.evils80386.javase.easy_shop_system.management;

import pers.evils80386.javase.easy_shop_system.data.Customer;
import pers.evils80386.javase.easy_shop_system.data.Gift;
import pers.evils80386.javase.easy_shop_system.data.Goods;

import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

/**
 * @Classname GiftManagement
 * @Description Gift_Management_to_customer
 * @Created by Evils80386
 */
public class GiftManagement {
    static Random random = new Random();

    /**
     *
     * @param custName-ligament_to_customer_identification
     * @param custPassword-ligament_to_customer_identification
     */
    public static void fortuneGiving(String custName,String custPassword){
        System.out.print("请输入会员号：");
        Scanner scanner = new Scanner(System.in);
        String No_ = scanner.next();
        if(VerifyEqual.verifyCust(No_)){
            System.out.print("请输入数字（0~6）：");
            int n = scanner.nextInt();
            int scoreGot = Goods.goodsGiving(n);
            Customer.custInfo.get(No_)[1] =  Integer.parseInt( Customer.custInfo.get(No_)[1]) + scoreGot + "";
            System.out.println("恭喜会员" + No_ + "获得" + scoreGot + "点积分!");
        }else {
            System.out.println("无此会员号！");
            Menu.funMenu(custName,custPassword);
        }
        if (VerifyEqual.flag()) {
           Menu.funMenu(custName,custPassword);
        }
    }

    /**
     *
     * @param custName-ligament_to_customer_identification
     * @param custPassword-ligament_to_customer_identification
     */
    public static void luckyLottery(String custName,String custPassword){
        System.out.print("请输入会员号：");
        Scanner scanner = new Scanner(System.in);
        String No_ = scanner.next();
        int luckyNum = Integer.parseInt(No_) % 10;
        if(VerifyEqual.verifyCust(No_)){
            int number = random.nextInt(100)*100;
                if (number == 6666||number == 8888){
                    System.out.println("恭喜会员 " + No_ + " 是今日幸运会员！");
                    System.out.println("恭喜会员 " + No_ + " 获得" + Gift.gifts[luckyNum] + "!");
                }else {
                    System.out.println("感谢参与！");
                }
        }else {
            System.out.println("无此会员号！");
            Menu.funMenu(custName,custPassword);
        }
        if (VerifyEqual.flag()) {
            Menu.funMenu(custName,custPassword);
        }
    }

    /**
     *
     * @param custName-ligament_to_customer_identification
     * @param custPassword-ligament_to_customer_identification
     */
    public static void birthGreeting(String custName,String custPassword){
        System.out.print("请输入会员号：");
        Scanner scanner = new Scanner(System.in);
        String No_ = scanner.next();
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH ) + 1;
        int year = calendar.get(Calendar.YEAR);
        String birthDay =  month + "/" + day;
        if (month < 10){
            birthDay = "0" + month + "/" + day;
        }
        System.out.println("现在的日期是：" + year + "/0" + month + "/" + day);
        if(VerifyEqual.verifyCust(No_)){
            if (birthDay.equals(Customer.custInfo.get(No_)[0])){
                System.out.println("祝贺会员 " + No_ + " 今天过生日!!!!!!");
            }else {
                System.out.println("今天无会员过生日。");
            }
        } else {
            System.out.println("无此会员号！");
            Menu.funMenu(custName,custPassword);
        }
        if (VerifyEqual.flag()) {
            Menu.funMenu(custName,custPassword);
        }
    }
}
