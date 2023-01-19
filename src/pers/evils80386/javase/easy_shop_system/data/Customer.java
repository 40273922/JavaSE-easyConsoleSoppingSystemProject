package pers.evils80386.javase.easy_shop_system.data;

import pers.evils80386.javase.easy_shop_system.management.Menu;
import pers.evils80386.javase.easy_shop_system.management.VerifyEqual;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * Copyright © 2023 ZhaiJinPei-2145619745.qq.com
 * All rights reserved.
 * @Classname Customer
 * @Description providing_self-functions
 * @Created by Evils80386
 */
public class Customer {
    /**
     * @Description &lt;String custNo,String custPassword&gt;
     */
    public static HashMap<String,String> customer = new HashMap<>();
    /**
     * @Description &lt;String custNo,String[2]{custBirth,custScore}&gt;
     */
    public static HashMap<String,String[]> custInfo = new HashMap<>();

    /**
     *
     * @param NO_-setCustNo
     * @param password-setCustPassword
     */
    public static void setCustomer(String NO_,String password){
        customer.put(NO_,password);
    }

    /**
     *
     * @param N0_-setCustNo
     * @param info-setCustPassword
     */
    public static void setCustInfo(String N0_,String[] info){
        custInfo.put(N0_,info);
    }

    /**
     * @Description printCustInfo_toString
     */
   public static void printCustInfo(){
       System.out.println("""
                       会员号    生日     积分
                       ------|-------|-------|""");
      for (String i : custInfo.keySet()){
          System.out.println(i + "\t" + custInfo.get(i)[0] + "\t" + custInfo.get(i)[1]);
      }
       System.out.println();
   }

    /**
     *
     * @param managerName-ligament_to_manager_identification
     * @param managerPassword-ligament_to_manager_identification
     */
   public static void addCustInfo(String managerName,String managerPassword){
       Scanner scanner = new Scanner(System.in);
       System.out.print("请输入会员号(4位整数):");
       String custNo = scanner.next();
       System.out.print("请输入会员生日(月/日<用两位数表示>):");
       String custBirth = scanner.next();
       System.out.print("请输入积分:");
       String custScore = scanner.next();
       customer.put(custNo,custNo);
       custInfo.put(custNo, new String[]{custBirth, custScore});
       System.out.print("新会员添加成功!\n是否继续添加(y/n):");
       String yes = scanner.next();
       if (yes.equals("y")){
           addCustInfo( managerName, managerPassword);
       }else {
           Menu.custInfoManagerMenu( managerName, managerPassword);
       }
   }

    /**
     *
     * @param managerName-ligament_to_manager_identification
     * @param managerPassword-ligament_to_manager_identification
     */
   public static void modifyCustInfo(String managerName,String managerPassword){
       backToUp(managerName, managerPassword);
       Scanner scanner = new Scanner(System.in);
       System.out.print("请输入会员号:");
       String custNo = scanner.next();
       if (VerifyEqual.verifyCust(custNo)){
           System.out.println("""
                        会员号    生日     积分
                       -------|-------|-------|""");
           System.out.println(custNo + "\t" + custInfo.get(custNo)[0] + "\t" + custInfo.get(custNo)[1]);
           modifyMap(custNo,managerName,managerPassword);
           System.out.println("是否修改其他属性(y/n):");
           String confirm = scanner.next();
           if (confirm.equals("y")){
               modifyMap(custNo,managerName,managerPassword);
           }else {
               Menu.custInfoManagerMenu(managerName,managerPassword);
           }
       }else {
           System.out.println("会员不存在!");
           Menu.custInfoManagerMenu(managerName,managerPassword);
       }
   }

    /**
     *
     * @param custNo-select_from_HashMap
     * @param managerName-ligament_to_manager_identification
     * @param managerPassword-ligament_to_manager_identification
     */
   public static void modifyMap(String custNo,String managerName,String managerPassword){
       backToUp(managerName, managerPassword);
       System.out.print("""
                   *****************
                   1.修 改 会 员 生 日
                   2.修 改 会 员 积 分
                   *****************
                   请选择,输入数字:""");
       Scanner scanner = new Scanner(System.in);
       int select = scanner.nextInt();
       switch (select) {
           case 1 -> {
               System.out.print("请输入修改后的会员生日(月/日<两位整数>):");
               String birth = scanner.next();
               custInfo.get(custNo)[0] = birth;
           }
           case 2 -> {
               System.out.print("请输入修改后的会员积分:");
               String score = scanner.next();
               custInfo.get(custNo)[1] = score;
           }
           default -> {
               System.out.println("输入错误,请重新输入:");
               modifyMap(custNo,managerName,managerPassword);
           }
       }
   }

    /**
     *
     * @param managerName-ligament_to_manager_identification
     * @param managerPassword-ligament_to_manager_identification
     */
    public static void backToUp(String managerName, String managerPassword) {
        System.out.print("是否返回上级(y/n):");
        Scanner scanner = new Scanner(System.in);
        String back = scanner.next();
        switch (back){
            case "y":
                Menu.custInfoManagerMenu(managerName,managerPassword);
                break;
            case "n":
                break;
            default:
                System.out.println("已退出");
        }
    }

    /**
     * @Description selectCustInfo
     */
    public static void selectCustInfo() {
        System.out.print("请输入会员号:");
        Scanner scanner = new Scanner(System.in);
        String custNo = scanner.next();
        if (VerifyEqual.verifyCust(custNo)) {
            System.out.println("""
                    会员号     生日     积分
                    -------|-------|-------|""");
            System.out.println(custNo + "\t" + custInfo.get(custNo)[0] + "\t" + custInfo.get(custNo)[1]);
        }
    }
}
