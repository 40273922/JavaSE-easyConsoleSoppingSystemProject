/**
 * Copyright © 2023 JinPei Zhai-2145619745.qq.com
 * All rights reserved.
 */
package pers.evils.javase.easyshopsystem.management;

import pers.evils.javase.easyshopsystem.data.Customer;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * <p>
 * <strong>
 * <i> Providing all Menus and using <a href="https://bugs.openjdk.org/browse/JDK-8222530" target="_blank">text blocks</a></i>
 * </strong>
 *
 * @author Evils80386
 * @version OpenJDK-17.0.4
 * @Classname {@code Menu}
 */
public class Menu {

    /**
     * <mark>show start menu and <b>exit normally</b></mark>
     * <hr>
     * <pre>
     *     {@code
     *     public static void startMenu() throws InputMismatchException {
     *         try {
     *             System.out.print("""
     *                 Welcome to SMS!
     *                 ----------------
     *                 1.客 户 登 陆
     *                 2.管 理 员 登 陆
     *                 3.退 出
     *                 ----------------
     *                 请选择:""");
     *             Scanner scanner = new Scanner(System.in);
     *             String selectNum = scanner.next();
     *             switch (selectNum) {
     *                 case "1" -> {
     *                     System.out.print("输入用户名:");
     *                     String custName = scanner.next();
     *                     System.out.print("输入密码(同用户名):");
     *                     String custPassword = scanner.next();
     *                     Menu.custHomeMenu(custName, custPassword);
     *                 }
     *                 case "2" -> {
     *                     System.out.print("输入管理员名:");
     *                     String managerName = scanner.next();
     *                     System.out.print("输入密码:");
     *                     String managerPassword = scanner.next();
     *                     Menu.managerHomeMenu(managerName, managerPassword);
     *                 }
     *                 case "3" ->{
     *                     System.out.println("waiting for exiting process");
     *                     System.out.print("............3");
     *                     for (int i = 0; i < 3; i++) {
     *                         for (int j = 0; j < 5; j++) {
     *                             Thread.sleep(100);
     *                             System.out.print("\b");
     *                         }
     *                         for (int j = 0; j < 5; j++) {
     *                             Thread.sleep(100);
     *                             System.out.print(".");
     *                         }
     *                         System.out.print( 2 - i + " ");
     *                         Thread.sleep(165);
     *                     }
     *                     System.out.print("\b");
     *                     System.out.print("\nexit!");
     *                     Thread.sleep(100);
     *                     //Everything end here
     *                     System.exit(0);
     *                 }
     *                 default -> {
     *                     System.out.println("input error!");
     *                     startMenu();
     *                 }
     *             }
     *         }catch (InputMismatchException e){
     *             System.out.println("startMenu error!");
     *         } catch (InterruptedException e) {
     *             throw new RuntimeException(e);
     *         }
     *     }}
     * </pre>
     * <hr>
     *
     * @throws InputMismatchException <i>to indicate that the token retrieved does not match the pattern for the expected
     *                                type,<wbr> or that the token is out of range for the expected type.</i>
     * @see InputMismatchException
     * @see System#out
     * @see java.io.PrintStream#println(String)
     * @see java.io.PrintStream#print(String)
     * @see Scanner#Scanner(InputStream)
     * @see Scanner#nextInt()
     * @see System#exit(int)
     * @see Menu#custHomeMenu(String, String)
     * @see Menu#managerHomeMenu(String, String)
     * @see StartSMS#main(String[])
     */
    public static void startMenu() throws InputMismatchException {
        try {
            System.out.print("""
                    Welcome to SMS!
                    ----------------
                    1.客 户 登 陆
                    2.管 理 员 登 陆
                    3.退 出
                    ----------------
                    请选择:""");
            Scanner scanner = new Scanner(System.in);
            String selectNum = scanner.next();
            switch (selectNum) {
                case "1" -> {
                    System.out.print("输入用户名:");
                    String custName = scanner.next();
                    System.out.print("输入密码(同用户名):");
                    String custPassword = scanner.next();
                    Menu.custHomeMenu(custName, custPassword);
                }
                case "2" -> {
                    System.out.print("输入管理员名:");
                    String managerName = scanner.next();
                    System.out.print("输入密码:");
                    String managerPassword = scanner.next();
                    Menu.managerHomeMenu(managerName, managerPassword);
                }
                case "3" -> {
                    System.out.println("waiting for exiting process");
                    System.out.print("............3");
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 5; j++) {
                            Thread.sleep(100);
                            System.out.print("\b");
                        }
                        for (int j = 0; j < 5; j++) {
                            Thread.sleep(100);
                            System.out.print(".");
                        }
                        System.out.print(2 - i + " ");
                        Thread.sleep(165);
                    }
                    System.out.print("\b");
                    System.out.print("\nexit!");
                    Thread.sleep(100);
                    //Everything end here
                    System.exit(0);
                }
                default -> {
                    System.out.println("input error!");
                    startMenu();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("startMenu error!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * show cust home menu
     * <hr>
     * <pre>
     *     {@code
     *     public static void custHomeMenu(String custName,String custPassword ){
     *         if (VerifyEqual.verifyCust(custName,custPassword)){
     *             System.out.println("""
     *                     -------------
     *                     1.购 物 结 算
     *                     2.真 情 回 馈
     *                     3.注 销
     *                     -------------
     *                     请选择:""");
     *             Scanner scanner = new Scanner(System.in);
     *             String s = scanner.next();
     *             switch (s) {
     *                 case "1" -> payMenu(custName, custPassword);
     *                 case "2" -> funMenu(custName, custPassword);
     *                 case "3" -> startMenu();
     *                 default -> System.out.println("error");
     *             }
     *         }else {
     *             System.out.println("error!");
     *             startMenu();
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
     * @see VerifyEqual#verifyCust(String, String)
     * @see Menu#startMenu()
     * @see Pay#pay(String, String)
     * @see Menu#funMenu(String, String)
     */
    public static void custHomeMenu(String custName, String custPassword) {
        if (VerifyEqual.verifyCust(custName, custPassword)) {
            System.out.print("""
                    -------------
                    1.购 物 结 算
                    2.真 情 回 馈
                    3.注 销
                    -------------
                    请选择:""");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.next();
            switch (s) {
                case "1" -> payMenu(custName, custPassword);
                case "2" -> funMenu(custName, custPassword);
                case "3" -> startMenu();
                default -> {
                    System.out.println("error");
                    custHomeMenu(custName, custPassword);
                }
            }
        } else {
            System.out.println("error!");
            startMenu();
        }
    }

    /**
     * show manager home menu
     * <hr>
     * <pre>
     *     {@code
     *     public static void managerHomeMenu(String managerName,String managerPassword ){
     *         if (VerifyEqual.verifyManager(managerName,managerPassword)){
     *             System.out.print("""
     *                     --------------
     *                     1.信 息 管 理
     *                     --------------
     *                     请选择,按'n'返回:""");
     *             Scanner scanner = new Scanner(System.in);
     *             String s = scanner.next();
     *             switch (s) {
     *                 case "1" -> custInfoManagerMenu(managerName, managerPassword);
     *                 case "n" -> startMenu();
     *                 default -> {
     *                         System.out.println("exit");
     *                         managerHomeMenu(managerName,managerPassword);
     *                 }
     *             }
     *         }else {
     *             System.out.println("error");
     *             startMenu();
     *         }
     *     }}
     * </pre>
     * <hr>
     *
     * @param managerName     {@code String}-<i>ligament to customer identification</i>
     * @param managerPassword {@code String}-<i>ligament to customer identification</i>
     * @see System#out
     * @see java.io.PrintStream#println(String)
     * @see java.io.PrintStream#print(String)
     * @see Scanner#Scanner(InputStream)
     * @see Scanner#next()
     * @see Menu#startMenu()
     * @see Menu#custInfoManagerMenu(String, String)
     */
    public static void managerHomeMenu(String managerName, String managerPassword) {
        if (VerifyEqual.verifyManager(managerName, managerPassword)) {
            System.out.print("""
                    --------------
                    1.信 息 管 理
                    --------------
                    请选择,按'n'返回:""");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.next();
            switch (s) {
                case "1" -> custInfoManagerMenu(managerName, managerPassword);
                case "n" -> startMenu();
                default -> {
                    System.out.println("exit");
                    managerHomeMenu(managerName, managerPassword);
                }
            }
        } else {
            System.out.println("error");
            startMenu();
        }
    }

    /**
     * show cust info manager menu
     * <hr>
     * <pre>
     *     {@code
     *     public static void custInfoManagerMenu(String managerName,String managerPassword){
     *         System.out.print("""
     *                 -------------------
     *                 1.显 示 所 有 信 息
     *                 2.添 加 信 息
     *                 3.修 改 信 息
     *                 4.查 询 信 息
     *                 -------------------
     *                 请选择,按'n'返回:""");
     *         Scanner scanner = new Scanner(System.in);
     *         String s = scanner.next();
     *         switch (s) {
     *             case "1" -> {
     *                 CustManagement.showAllInfo();
     *                 if (VerifyEqual.flag()) {
     *                     custInfoManagerMenu(managerName, managerPassword);
     *                 }else {
     *                     startMenu();
     *                 }
     *             }
     *             case "2" -> {
     *                 CustManagement.addInfo(managerName, managerPassword);
     *                 if (VerifyEqual.flag()) {
     *                     custInfoManagerMenu(managerName, managerPassword);
     *                 }else {
     *                     startMenu();
     *                 }
     *             }
     *             case "3" -> {
     *                 CustManagement.modifyInfo(managerName, managerPassword);
     *                 if (VerifyEqual.flag()) {
     *                     custInfoManagerMenu(managerName, managerPassword);
     *                 }else {
     *                     startMenu();
     *                 }
     *             }
     *             case "4" -> {
     *                 CustManagement.selectInfo();
     *                 if (VerifyEqual.flag()) {
     *                     custInfoManagerMenu(managerName, managerPassword);
     *                 }
     *             }
     *             case "n" -> managerHomeMenu(managerName, managerPassword);
     *             default -> {
     *                 if (VerifyEqual.flag()) {
     *                     managerHomeMenu(managerName, managerPassword);
     *                 }else {
     *                     startMenu();
     *                 }
     *             }
     *         }
     *     }}
     * </pre>
     * <hr>
     *
     * @param managerName     {@code String}-<i>ligament to customer identification</i>
     * @param managerPassword {@code String}-<i>ligament to customer identification</i>
     * @see System#out
     * @see java.io.PrintStream#print(String)
     * @see Scanner#Scanner(InputStream)
     * @see Scanner#next()
     * @see Customer#addCustInfo(String, String)
     * @see Customer#modifyCustInfo(String, String)
     * @see Customer#backToUp(String, String)
     * @see Menu#managerHomeMenu(String, String)
     * @see Menu#custInfoManagerMenu(String, String)
     * @see VerifyEqual#flag()
     * @see CustManagement#showAllInfo()
     * @see CustManagement#addInfo(String, String)
     * @see CustManagement#modifyInfo(String, String)
     * @see CustManagement#selectInfo()
     */
    public static void custInfoManagerMenu(String managerName, String managerPassword) {
        System.out.print("""
                -------------------
                1.显 示 所 有 信 息
                2.添 加 信 息
                3.修 改 信 息
                4.查 询 信 息
                -------------------
                请选择,按'n'返回:""");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        switch (s) {
            case "1" -> {
                CustManagement.showAllInfo();
                if (VerifyEqual.flag()) {
                    custInfoManagerMenu(managerName, managerPassword);
                } else {
                    startMenu();
                }
            }
            case "2" -> {
                CustManagement.addInfo(managerName, managerPassword);
                if (VerifyEqual.flag()) {
                    custInfoManagerMenu(managerName, managerPassword);
                } else {
                    startMenu();
                }
            }
            case "3" -> {
                CustManagement.modifyInfo(managerName, managerPassword);
                if (VerifyEqual.flag()) {
                    custInfoManagerMenu(managerName, managerPassword);
                } else {
                    startMenu();
                }
            }
            case "4" -> {
                CustManagement.selectInfo();
                if (VerifyEqual.flag()) {
                    custInfoManagerMenu(managerName, managerPassword);
                }
            }
            case "n" -> managerHomeMenu(managerName, managerPassword);
            default -> {
                if (VerifyEqual.flag()) {
                    managerHomeMenu(managerName, managerPassword);
                } else {
                    startMenu();
                }
            }
        }
    }

    /**
     * show pay menu
     * <hr>
     * <pre>
     *     {@code
     *     public static void payMenu(String custName,String custPassword){
     *         System.out.println("""
     *                 --------------------------
     *                 1.addidas 运动鞋  ￥420.78
     *                 2.Kappa 网球裙    ￥200
     *                 3.网球拍          ￥780
     *                 4.addidas T恤    ￥880
     *                 5.Nike 运动鞋     ￥900
     *                 6.Kappa 网球      ￥45
     *                 7.Kappa T恤       ￥245
     *                 --------------------------
     *                 请选择,按'n'返回:""");
     *                 Pay.pay(custName,custPassword);
     *     }}
     * </pre>
     * <hr>
     *
     * @param custName     {@code String}-<i>ligament to customer identification</i>
     * @param custPassword {@code String}-<i>ligament to customer identification</i>
     * @see System#out
     * @see java.io.PrintStream#print(String)
     * @see java.io.PrintStream#println(String)
     * @see Menu#custHomeMenu(String, String)
     * @see Pay#pay(String, String)
     */
    public static void payMenu(String custName, String custPassword) {
        System.out.print("""
                --------------------------
                1.addidas 运动鞋  ￥420.78
                2.Kappa 网球裙    ￥200
                3.网球拍          ￥780
                4.addidas T恤    ￥880
                5.Nike 运动鞋     ￥900
                6.Kappa 网球      ￥45
                7.Kappa T恤       ￥245
                --------------------------""");
        Pay.pay(custName, custPassword);
    }

    /**
     * show fun menu
     * <hr>
     * <pre>
     *     {@code
     *     public static void funMenu(String custName,String custPassword){
     *         System.out.print("""
     *                 ----------------
     *                 1.幸 运 大 放 送
     *                 2.幸 运 抽 奖
     *                 3.生 日 问 候
     *                 ----------------
     *                 请选择,按'n'返回:""");
     *         Scanner scanner = new Scanner(System.in);
     *         String s = scanner.next();
     *         switch (s) {
     *             case "1" -> GiftManagement.fortuneGiving(custName, custPassword);
     *             case "2" -> GiftManagement.luckyLottery(custName, custPassword);
     *             case "3" -> GiftManagement.birthGreeting(custName, custPassword);
     *             case "n" -> custHomeMenu(custName, custPassword);
     *             default -> {
     *                 System.out.println("error");
     *                 custHomeMenu(custName,custPassword);
     *             }
     *         }
     *     }
     * }}
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
     * @see GiftManagement#fortuneGiving(String, String)
     * @see GiftManagement#luckyLottery(String, String)
     * @see GiftManagement#birthGreeting(String, String)
     * @see Menu#custHomeMenu(String, String)
     */
    public static void funMenu(String custName, String custPassword) {
        System.out.print("""
                ----------------
                1.幸 运 大 放 送
                2.幸 运 抽 奖
                3.生 日 问 候
                ----------------
                请选择,按'n'返回:""");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        switch (s) {
            case "1" -> GiftManagement.fortuneGiving(custName, custPassword);
            case "2" -> GiftManagement.luckyLottery(custName, custPassword);
            case "3" -> GiftManagement.birthGreeting(custName, custPassword);
            case "n" -> custHomeMenu(custName, custPassword);
            default -> {
                System.out.println("error");
                custHomeMenu(custName, custPassword);
            }
        }
    }
}
