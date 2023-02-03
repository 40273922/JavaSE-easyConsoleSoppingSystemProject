/**
 * Copyright © 2023 JinPei Zhai-2145619745.qq.com
 * All rights reserved.
 */
package pers.evils.javase.easyshopsystem.management;

import pers.evils.javase.easyshopsystem.data.Customer;
import pers.evils.javase.easyshopsystem.data.Gift;
import pers.evils.javase.easyshopsystem.data.Goods;

import java.io.InputStream;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

/**
 * Gift Management to customer
 *
 * @author Evils80386
 * @version OpenJDK-17.0.4
 * @Classname {@code GiftManagement}
 * @see Menu#funMenu(String, String)
 */
public class GiftManagement {
    /**
     * Creates a new random number generator
     * <hr>
     * <pre>
     *     {@code
     *      static Random random = new Random();
     *      }
     * </pre>
     * <hr>
     *
     * @see Random
     * @see Random#Random()
     * @see GiftManagement#luckyLottery(String, String)
     */
    static Random random = new Random();

    /**
     * fortuneGiving implement
     * <hr>
     * <pre>
     *     {@code
     *      public static void fortuneGiving(String custName,String custPassword){
     *         System.out.print("输入会员号:");
     *         Scanner scanner = new Scanner(System.in);
     *         String No_ = scanner.next();
     *         if(VerifyEqual.verifyCust(No_)){
     *             System.out.print("输入(0~9):");
     *             int n = scanner.nextInt();
     *             int scoreGot = Goods.goodsGiving(n);
     *             Customer.custInfo.get(No_)[1] = Integer.parseInt( Customer.custInfo.get(No_)[1]) + scoreGot + "";
     *             System.out.println("会员" + No_ + "获" + scoreGot + "积分");
     *         }else {
     *             System.out.println("error");
     *             Menu.funMenu(custName,custPassword);
     *         }
     *         if (VerifyEqual.flag()) {
     *            Menu.funMenu(custName,custPassword);
     *         }
     *     }}
     * </pre>
     * <hr>
     *
     * @param custName     {@code String}-<i>ligament to customer identification</i>
     * @param custPassword {@code String}-<i>ligament to customer identification</i>
     * @see System#out
     * @see java.io.PrintStream#println(String)
     * @see java.io.PrintStream#print(String)
     * @see Scanner#Scanner(InputStream)
     * @see Scanner#next()
     * @see java.util.HashMap#get(Object)
     * @see Integer#parseInt(String)
     * @see Menu#funMenu(String, String)
     * @see VerifyEqual#verifyCust(String)
     * @see VerifyEqual#flag()
     * @see Goods#goodsGiving(int)
     */
    public static void fortuneGiving(String custName, String custPassword) {
        System.out.print("输入会员号:");
        Scanner scanner = new Scanner(System.in);
        String No_ = scanner.next();
        if (VerifyEqual.verifyCust(No_)) {
            System.out.print("输入(0~9):");
            int n = scanner.nextInt();
            int scoreGot = Goods.goodsGiving(n);
            Customer.custInfo.get(No_)[1] = Integer.parseInt(Customer.custInfo.get(No_)[1]) + scoreGot + "";
            System.out.println("会员" + No_ + "获" + scoreGot + "积分");
        } else {
            System.out.println("error");
            Menu.funMenu(custName, custPassword);
        }
        if (VerifyEqual.flag()) {
            Menu.funMenu(custName, custPassword);
        }
    }

    /**
     * luckyLottery implement
     * <hr>
     * <pre>
     *     {@code
     *     public static void luckyLottery(String custName,String custPassword){
     *         System.out.print("输入会员号:");
     *         Scanner scanner = new Scanner(System.in);
     *         String No_ = scanner.next();
     *         int luckyNum = Integer.parseInt(No_) % 10;
     *         if(VerifyEqual.verifyCust(No_)){
     *             int number = random.nextInt(100)*100;
     *                 if (number == 6666||number == 8888){
     *                     System.out.println("会员 " + No_ + " 获" + Gift.gifts[luckyNum] + "!");
     *                 }else {
     *                     System.out.println("Thanks!");
     *                 }
     *         }else {
     *             System.out.println("error");
     *             Menu.funMenu(custName,custPassword);
     *         }
     *         if (VerifyEqual.flag()) {
     *             Menu.funMenu(custName,custPassword);
     *         }
     *     }}
     * </pre>
     * <hr>
     *
     * @param custName     {@code String}-<i>ligament to customer identification</i>
     * @param custPassword {@code String}-<i>ligament to customer identification</i>
     * @see System#out
     * @see java.io.PrintStream#println(String)
     * @see java.io.PrintStream#print(String)
     * @see Scanner#Scanner(InputStream)
     * @see Scanner#next()
     * @see GiftManagement#random
     * @see Random#nextInt()
     * @see Integer#parseInt(String)
     * @see Menu#funMenu(String, String)
     * @see VerifyEqual#verifyCust(String)
     * @see VerifyEqual#flag()
     * @see Gift#gifts
     */
    public static void luckyLottery(String custName, String custPassword) {
        System.out.print("输入会员号:");
        Scanner scanner = new Scanner(System.in);
        String No_ = scanner.next();
        int luckyNum = Integer.parseInt(No_) % 10;
        if (VerifyEqual.verifyCust(No_)) {
            int number = random.nextInt(100) * 100;
            if (number == 6666 || number == 8888) {
                System.out.println("会员 " + No_ + " 获" + Gift.gifts[luckyNum] + "!");
            } else {
                System.out.println("Thanks!");
            }
        } else {
            System.out.println("error");
            Menu.funMenu(custName, custPassword);
        }
        if (VerifyEqual.flag()) {
            Menu.funMenu(custName, custPassword);
        }
    }

    /**
     * birthGreeting implement
     * <hr>
     * <pre>
     *     {@code
     *      public static void birthGreeting(String custName,String custPassword){
     *         System.out.print("输入会员号:");
     *         Scanner scanner = new Scanner(System.in);
     *         String No_ = scanner.next();
     *         Calendar calendar = Calendar.getInstance();
     *         int day = calendar.get(Calendar.DATE);
     *         int month = calendar.get(Calendar.MONTH ) + 1;
     *         int year = calendar.get(Calendar.YEAR);
     *         String birthDay =  month + "/" + day;
     *         if (month < 10){
     *             birthDay = "0" + month + "/" + day;
     *         }
     *         System.out.println("Date:" + year + "/0" + month + "/" + day);
     *         if(VerifyEqual.verifyCust(No_)){
     *             if (birthDay.equals(Customer.custInfo.get(No_)[0])){
     *                 System.out.println("会员 " + No_ + " :Happy Birthday!");
     *             }else {
     *                 System.out.println("None");
     *             }
     *         } else {
     *             System.out.println("error");
     *             Menu.funMenu(custName,custPassword);
     *         }
     *         if (VerifyEqual.flag()) {
     *             Menu.funMenu(custName,custPassword);
     *         }
     *     }}
     * </pre>
     * <hr>
     *
     * @param custName     {@code String}-<i>ligament to customer identification</i>
     * @param custPassword {@code String}-<i>ligament to customer identification</i>
     * @see System#out
     * @see java.io.PrintStream#println(String)
     * @see java.io.PrintStream#print(String)
     * @see Scanner#Scanner(InputStream)
     * @see Scanner#next()
     * @see Calendar
     * @see Calendar#getInstance()
     * @see Calendar#DATE
     * @see Calendar#MONTH
     * @see Calendar#YEAR
     * @see Calendar#get(int)
     * @see Menu#funMenu(String, String)
     * @see VerifyEqual#verifyCust(String)
     * @see VerifyEqual#flag()
     * @see String#equals(Object)
     */
    public static void birthGreeting(String custName, String custPassword) {
        System.out.print("输入会员号:");
        Scanner scanner = new Scanner(System.in);
        String No_ = scanner.next();
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);
        String birthDay = month + "/" + day;
        if (month < 10) {
            birthDay = "0" + month + "/" + day;
        }
        System.out.println("Date:" + year + "/0" + month + "/" + day);
        if (VerifyEqual.verifyCust(No_)) {
            if (birthDay.equals(Customer.custInfo.get(No_)[0])) {
                System.out.println("会员 " + No_ + " :Happy Birthday!");
            } else {
                System.out.println("None");
            }
        } else {
            System.out.println("error");
            Menu.funMenu(custName, custPassword);
        }
        if (VerifyEqual.flag()) {
            Menu.funMenu(custName, custPassword);
        }
    }
}
