package pers.evils80386.javase.easy_shop_system.management;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * Copyright © 2023 ZhaiJinPei-2145619745.qq.com
 * All rights reserved.
 * @Classname Menu
 * @Description Menus
 * @Created by Evils80386
 */
public class Menu {
    /**
     *
     * @throw InputMismatchException-avoid_inputMismatching
     */
    public static void startMenu() throws InputMismatchException {
        try {
            System.out.print("""
                ***************
                1.客 户 登 陆
                2.管 理 员 登 陆
                3.退出
                ***************
                请选择，输入数字:""");
            Scanner scanner = new Scanner(System.in);
            int selectNum = scanner.nextInt();
            switch (selectNum) {
                case 1 -> {
                    System.out.print("请输入用户名:");
                    String custName = scanner.next();
                    System.out.print("请输入密码(初始密码与用户名相同):");
                    String custPassword = scanner.next();
                    Menu.custHomeMenu(custName, custPassword);
                }
                case 2 -> {
                    System.out.print("请输入管理员名:");
                    String managerName = scanner.next();
                    System.out.print("请输入密码:");
                    String managerPassword = scanner.next();
                    Menu.managerHomeMenu(managerName, managerPassword);
                }
                case 3 ->{
                    System.out.println("感谢使用!");
                    //Everything_End_Here
                    System.exit(0);
                }
                default -> System.out.println("错误!");
            }
        }catch (InputMismatchException e){
            System.out.println("错误!");
        }
    }

    /**
     *
     * @param custName-ligament_to_customer_identification
     * @param custPassword-ligament_to_customer_identification
     */
    public static void custHomeMenu(String custName,String custPassword ){
        if (VerifyEqual.verifyCust(custName,custPassword)){
            System.out.println("""
                    使 用 客 户 系 统
                    ************
                    1.购 物 结 算
                    2.真 情 回 馈
                    3.注 销
                    ************
                    请选择，输入数字:""");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.next();
            switch (s) {
                case "1" -> payMenu(custName, custPassword);
                case "2" -> funMenu(custName, custPassword);
                case "3" -> startMenu();
                default -> System.out.println("发生错误");
            }
        }else {
            System.out.println("输入错误");
            System.out.println("无此会员");
        }
    }

    /**
     *
     * @param managerName-ligament_to_customer_identification
     * @param managerPassword-ligament_to_customer_identification
     */
    public static void managerHomeMenu(String managerName,String managerPassword ){
        if (VerifyEqual.verifyManager(managerName,managerPassword)){
            System.out.println("""
                    使 用 管 理 系 统
                    *****************
                    1.客 户 信 息 管 理
                    *****************
                    请选择，输入数字或按'n'返回上级:""");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.next();
            switch (s){
                case "1":
                    custInfoManagerMenu(managerName,managerPassword);
                case "n":
                    startMenu();
                default:
                    if (VerifyEqual.flag()){
                        System.out.println("已退出");
                        break;
                    }
            }
        }else {
            System.out.println("已退出");
        }

    }

    /**
     *
     * @param managerName-ligament_to_customer_identification
     * @param managerPassword-ligament_to_customer_identification
     */
    public static void custInfoManagerMenu(String managerName,String managerPassword){
        System.out.println("""
                ***********************
                1.显 示 所 有 客 户 信 息
                2.添 加 客 户 信 息
                3.修 改 客 户 信 息
                4.查 询 客 户 信 息
                ***********************
                请选择，输入数字或按'n'返回上一级:""");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        switch (s){
            case "1":
                CustManagement.showAllInfo();
                if (VerifyEqual.flag()) {
                    custInfoManagerMenu(managerName, managerPassword);
                }
                break;
            case "2":
                CustManagement.addInfo(managerName,managerPassword);
                if (VerifyEqual.flag()) {
                    custInfoManagerMenu(managerName, managerPassword);
                }
                break;
            case "3":
                CustManagement.modifyInfo(managerName,managerPassword);
                if (VerifyEqual.flag()){
                    custInfoManagerMenu(managerName,managerPassword);
                }
                break;
            case "4":
                CustManagement.selectInfo();
                if (VerifyEqual.flag()) {
                    custInfoManagerMenu(managerName, managerPassword);
                }
                break;
            case "n":
                managerHomeMenu(managerName,managerPassword);
            default:
                if (VerifyEqual.flag()) {
                    managerHomeMenu(managerName,managerPassword);
                }
        }
    }

    /**
     *
     * @param custName-ligament_to_customer_identification
     * @param custPassword-ligament_to_customer_identification
     */
    public static void payMenu(String custName,String custPassword){
        System.out.println("""
                客 户 系 统 > 购 物 结 算
                ***请 选 择 商 品 编 号*****
                1.addidas 运动鞋  ￥420.78
                2.Kappa 网球裙    ￥200
                3.网球拍          ￥780
                4.addidas T恤    ￥880
                5.Nike 运动鞋     ￥900
                6.Kappa 网球      ￥45
                7.Kappa T恤       ￥245
                *************************
                请选择，输入数字或按'n'返回上级：""");
                Pay.pay(custName,custPassword);
    }

    /**
     *
     * @param custName-ligament_to_customer_identification
     * @param custPassword-ligament_to_customer_identification
     */
    public static void funMenu(String custName,String custPassword){
        System.out.println("""
                **************
                1.幸 运 大 放 送
                2.幸 运 抽 奖
                3.生 日 问 候
                **************
                请选择，输入数字或按'n'返回上级：""");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        switch (s){
            case "1":
                GiftManagement.fortuneGiving(custName,custPassword);
                break;
            case "2":
                GiftManagement.luckyLottery(custName,custPassword);
                break;
            case "3":
                GiftManagement.birthGreeting(custName,custPassword);
                break;
            case "n":
               custHomeMenu(custName,custPassword);
            default:
                System.out.println("输入错误");
        }
    }
}
