/**
 * Copyright © 2023 JinPei Zhai-2145619745.qq.com
 * All rights reserved.
 */
package pers.evils.javase.easyshopsystem.data;

import pers.evils.javase.easyshopsystem.management.*;

import java.io.InputStream;
import java.util.*;

/**
 * <p>
 * <i>Two HashMap containers are provided and using <a href="https://bugs.openjdk.org/browse/JDK-8222530"  target="_blank">text blocks</a></i>
 *
 * @param <K> key
 * @param <V> value
 * @author Evils80386
 * @version OpenJDK-17.0.4
 * @Classname {@code Customer}
 */

public class Customer<K, V> extends HashMap<K, V> {
    /**
     * {@code HashMap}&lt;{@code K:String custNo,V:String custPassword}&gt;<br>
     * {@linkplain #toString() toString}
     * <hr>
     * <pre>
     *     {@code
     *       public static HashMap<String,String> customer = new HashMap<>();
     *       }
     * </pre>
     * <hr>
     *
     * @see HashMap
     * @see HashMap#HashMap()
     * @see Customer#setCustomer(String, String)
     * @see Customer#addCustInfo(String, String)
     * @see VerifyEqual#verifyCust(String)
     * @see Data#init()
     */
    public static HashMap<String, String> customer = new HashMap<>();
    /**
     * {@code Customer<K,V>}&lt;{@code K:String custNo,V:String[]{0:custBirth,1:custScore}}&gt;<br>
     * <hr>
     * <pre>
     *     {@code
     *       public static Customer<String,String[]> custInfo = new Customer<>();
     *       }
     * </pre>
     * <hr>
     *
     * @see HashMap
     * @see HashMap#HashMap()
     * @see Customer#toString()
     * @see Customer#setCustInfo(String, String[])
     * @see Customer#addCustInfo(String, String)
     * @see Customer#modifyCustInfo(String, String)
     * @see Customer#modifyMap(String, String, String)
     * @see Customer#selectCustInfo()
     * @see GiftManagement#fortuneGiving(String, String)
     * @see GiftManagement#birthGreeting(String, String)
     * @see Pay#pay(String, String)
     * @see Data#init()
     */
    public static Customer<String, String[]> custInfo = new Customer<>();

    /**
     * set customer information
     * <hr>
     * <pre>
     *     {@code
     *      public static void setCustomer(String NO_,String password){
     *         customer.put(NO_,password);
     *     }}
     * </pre>
     * <hr>
     *
     * @param NO_      {@code String}-<i>setCustNo</i>
     * @param password {@code String}-<i>setCustPassword</i>
     * @see HashMap#put(Object, Object)
     * @see Data#init()
     * @see Customer#customer
     */
    public static void setCustomer(String NO_, String password) {
        customer.put(NO_, password);
    }

    /**
     * set CustInfo information
     * <hr>
     * <pre>
     *     {@code
     *      public static void setCustInfo(String N0_,String[] info){
     *         custInfo.put(N0_,info);
     *     }}
     * </pre>
     * <hr>
     *
     * @param N0_  {@code String}-<i>setCustNo</i>
     * @param info {@code String[]}-<i>setCustPassword</i>
     * @see HashMap#put(Object, Object)
     * @see Data#init()
     * @see Customer#custInfo
     */
    public static void setCustInfo(String N0_, String[] info) {
        custInfo.put(N0_, info);
    }

    /**
     * add custInfo
     * <hr>
     * <pre>
     *     {@code
     *      public static void addCustInfo(String managerName,String managerPassword){
     *        try {
     *            Scanner scanner = new Scanner(System.in);
     *            System.out.print("输入会员号(4位):");
     *            String custNo = scanner.next();
     *            System.out.print("输入会员生日(月/日<2位>):");
     *            String custBirth = scanner.next();
     *            System.out.print("输入积分:");
     *            String custScore = scanner.next();
     *            int score = Integer.parseInt(custScore);
     *            int No_ = Integer.parseInt(custNo);
     *            int month = Integer.parseInt(custBirth.charAt(0) + "" + custBirth.charAt(1));
     *            int day = Integer.parseInt(custBirth.charAt(3) + "" + custBirth.charAt(4));
     *            boolean dateIsTrue = dateIsTrue(month,day,custBirth.length(),custBirth.charAt(2));
     *            if (dateIsTrue&&(score >= 0)&&(No_>999&&No_<10000)){
     *                customer.put(custNo,custNo);
     *                custInfo.put(custNo, new String[]{custBirth, custScore});
     *                System.out.print("添加成功\n继续添加(y/n):");
     *                String yes = scanner.next();
     *                if (yes.equals("y")){
     *                    addCustInfo( managerName, managerPassword);
     *                }else {
     *                    Menu.custInfoManagerMenu( managerName, managerPassword);
     *                }
     *            }else {
     *                System.out.println("error");
     *                addCustInfo(managerName,managerPassword);
     *            }
     *        }catch (Exception e){
     *            System.out.println("error");
     *            Menu.custInfoManagerMenu( managerName, managerPassword);
     *        }
     *    }}
     * </pre>
     * <hr>
     *
     * @param managerName     {@code String}-<i>ligament to customer identification</i>
     * @param managerPassword {@code String}-<i>ligament to customer identification</i>
     * @see System#out
     * @see java.io.PrintStream#print(String)
     * @see Scanner#Scanner(InputStream)
     * @see Scanner#next()
     * @see HashMap#put(Object, Object)
     * @see String#equals(Object)
     * @see CustManagement#addInfo(String, String)
     * @see Customer#custInfo
     * @see Customer#customer
     * @see Menu#custInfoManagerMenu(String, String)
     * @see Customer#dateIsTrue(int, int, int, char)
     */
    public static void addCustInfo(String managerName, String managerPassword) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("输入会员号(4位):");
            String custNo = scanner.next();
            System.out.print("输入会员生日(月/日<2位>):");
            String custBirth = scanner.next();
            System.out.print("输入积分:");
            String custScore = scanner.next();
            int score = Integer.parseInt(custScore);
            int No_ = Integer.parseInt(custNo);
            int month = Integer.parseInt(custBirth.charAt(0) + "" + custBirth.charAt(1));
            int day = Integer.parseInt(custBirth.charAt(3) + "" + custBirth.charAt(4));
            boolean dateIsTrue = dateIsTrue(month, day, custBirth.length(), custBirth.charAt(2));
            if (dateIsTrue && (score >= 0) && (No_ > 999 && No_ < 10000)) {
                customer.put(custNo, custNo);
                custInfo.put(custNo, new String[]{custBirth, custScore});
                System.out.print("添加成功\n继续添加(y/n):");
                String yes = scanner.next();
                if (yes.equals("y")) {
                    addCustInfo(managerName, managerPassword);
                } else {
                    Menu.custInfoManagerMenu(managerName, managerPassword);
                }
            } else {
                System.out.println("error");
                addCustInfo(managerName, managerPassword);
            }
        } catch (Exception e) {
            System.out.println("error");
            Menu.custInfoManagerMenu(managerName, managerPassword);
        }
    }

    /**
     * dateIsTrue
     * <pre>
     *     {@code
     *     public static boolean dateIsTrue(int Month,int Day){
     *        boolean dateIsTrue = true;
     *        if((Month == 0)&&(Day == 0)){
     *            dateIsTrue = false;
     *        }else {
     *            switch (Month) {
     *                case 1, 3, 5, 7, 8, 10, 11 -> {
     *                    if ((Day < 1) || (Day > 31)) {
     *                        dateIsTrue = false;
     *                    }
     *                }
     *                case 2 -> {
     *                    if ((Day < 1) || (Day > 29)) {
     *                        dateIsTrue = false;
     *                    }
     *                }
     *                default -> {
     *                    if ((Day < 1)||(Day > 30){
     *                        dateIsTrue = false;
     *                    }
     *                }
     *            }
     *        }
     *        return dateIsTrue&&(length == 5)&&(c == '/');
     *    }}
     * </pre>
     *
     * @param Month  parseInt
     * @param Day    parseInt
     * @param length String[]
     * @param c      char
     * @return true if dateIsTrue
     */
    public static boolean dateIsTrue(int Month, int Day, int length, char c) {
        boolean dateIsTrue = true;
        if ((Month == 0) && (Day == 0)) {
            dateIsTrue = false;
        } else {
            switch (Month) {
                case 1, 3, 5, 7, 8, 10, 12 -> {
                    if ((Day < 1) || (Day > 31)) {
                        dateIsTrue = false;
                    }
                }
                case 2 -> {
                    if ((Day < 1) || (Day > 29)) {
                        dateIsTrue = false;
                    }
                }
                default -> {
                    if ((Day < 1) || (Day > 30)) {
                        dateIsTrue = false;
                    }
                }
            }
        }
        return dateIsTrue && (length == 5) && (c == '/');
    }

    /**
     * modify custInfo
     * <hr>
     * <pre>
     *     {@code
     *     public static void modifyCustInfo(String managerName,String managerPassword){
     *        backToUp(managerName, managerPassword);
     *        Scanner scanner = new Scanner(System.in);
     *        System.out.print("输入会员号:");
     *        String custNo = scanner.next();
     *        if (VerifyEqual.verifyCust(custNo)){
     *            System.out.println("""
     *                         会员号    生日     积分
     *                        -------|-------|-------|""");
     *            System.out.println(custNo + "\t" + custInfo.get(custNo)[0] + "\t" + custInfo.get(custNo)[1]);
     *            modifyMap(custNo,managerName,managerPassword);
     *            System.out.println("修改其他(y/n):");
     *            String confirm = scanner.next();
     *            if (confirm.equals("y")){
     *                modifyMap(custNo,managerName,managerPassword);
     *            }else {
     *                Menu.custInfoManagerMenu(managerName,managerPassword);
     *            }
     *        }else {
     *            System.out.println("error");
     *            Menu.custInfoManagerMenu(managerName,managerPassword);
     *        }
     *    }}
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
     * @see String#equals(Object)
     * @see Customer#modifyCustInfo(String, String)
     * @see CustManagement#modifyInfo(String, String)
     * @see Customer#backToUp(String, String)
     * @see Customer#custInfo
     */
    public static void modifyCustInfo(String managerName, String managerPassword) {
        backToUp(managerName, managerPassword);
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入会员号:");
        String custNo = scanner.next();
        if (VerifyEqual.verifyCust(custNo)) {
            System.out.println("""
                     会员号    生日     积分
                    -------|-------|-------|""");
            System.out.println(custNo + "\t" + custInfo.get(custNo)[0] + "\t" + custInfo.get(custNo)[1]);
            modifyMap(custNo, managerName, managerPassword);
            System.out.println("修改其他(y/n):");
            String confirm = scanner.next();
            if (confirm.equals("y")) {
                modifyMap(custNo, managerName, managerPassword);
            } else {
                Menu.custInfoManagerMenu(managerName, managerPassword);
            }
        } else {
            System.out.println("error");
            Menu.custInfoManagerMenu(managerName, managerPassword);
        }
    }

    /**
     * modify HashMap information
     * <hr>
     * <pre>
     *     {@code
     *      public static void modifyMap(String custNo,String managerName,String managerPassword){
     *        backToUp(managerName, managerPassword);
     *        System.out.print("""
     *                    -------------------
     *                    1.修 改 会 员 生 日
     *                    2.修 改 会 员 积 分
     *                    -------------------
     *                    请选择:""");
     *        Scanner scanner = new Scanner(System.in);
     *        int select = scanner.nextInt();
     *        switch (select) {
     *            case 1 -> {
     *                System.out.print("输入生日(月/日<2位>):");
     *                String birth = scanner.next();
     *                int month = Integer.parseInt(birth.charAt(0) + "" + birth.charAt(1));
     *                int day = Integer.parseInt(birth.charAt(3) + "" + birth.charAt(4));
     *                boolean dateIsTrue = dateIsTrue(month,day,birth.length(),birth.charAt(2));
     *                if (dateIsTrue) {
     *                    custInfo.get(custNo)[0] = birth;
     *                    System.out.println("done");
     *                } else {
     *                    System.out.println("error");
     *                }
     *            }
     *            case 2 -> {
     *                try {
     *                    System.out.print("输入积分:");
     *                    String score = scanner.next();
     *                    if (Integer.parseInt(score) >= 0){
     *                        custInfo.get(custNo)[1] = score;
     *                        System.out.println("done");
     *                    }else {
     *                        System.out.println("error");
     *                    }
     *                }catch (Exception e){
     *                    System.out.println("error");
     *                    modifyMap(custNo,managerName,managerPassword);
     *                }
     *            }
     *            default -> {
     *                System.out.println("error");
     *                modifyMap(custNo,managerName,managerPassword);
     *            }
     *        }
     *    }}
     * </pre>
     * <hr>
     *
     * @param custNo          {@code String}-<i>select from HashMap</i>
     * @param managerName     {@code String}-<i>ligament to customer identification</i>
     * @param managerPassword {@code String}-<i>ligament to customer identification</i>
     * @see System#out
     * @see java.io.PrintStream#println(String)
     * @see java.io.PrintStream#print(String)
     * @see Scanner#Scanner(InputStream)
     * @see Scanner#nextInt()
     * @see HashMap#get(Object)
     * @see Customer#modifyCustInfo(String, String)
     * @see Customer#modifyMap(String, String, String)
     * @see Customer#backToUp(String, String)
     * @see Customer#custInfo
     * @see Customer#dateIsTrue(int, int, int, char)
     */
    public static void modifyMap(String custNo, String managerName, String managerPassword) {
        backToUp(managerName, managerPassword);
        System.out.print("""
                -------------------
                1.修 改 会 员 生 日
                2.修 改 会 员 积 分
                -------------------
                请选择:""");
        Scanner scanner = new Scanner(System.in);
        int select = scanner.nextInt();
        switch (select) {
            case 1 -> {
                System.out.print("输入生日(月/日<2位>):");
                String birth = scanner.next();
                int month = Integer.parseInt(birth.charAt(0) + "" + birth.charAt(1));
                int day = Integer.parseInt(birth.charAt(3) + "" + birth.charAt(4));
                boolean dateIsTrue = dateIsTrue(month, day, birth.length(), birth.charAt(2));
                if (dateIsTrue) {
                    custInfo.get(custNo)[0] = birth;
                    System.out.println("done");
                } else {
                    System.out.println("error");
                }
            }
            case 2 -> {
                try {
                    System.out.print("输入积分:");
                    String score = scanner.next();
                    if (Integer.parseInt(score) >= 0) {
                        custInfo.get(custNo)[1] = score;
                        System.out.println("done");
                    } else {
                        System.out.println("error");
                    }
                } catch (Exception e) {
                    System.out.println("error");
                    modifyMap(custNo, managerName, managerPassword);
                }
            }
            default -> {
                System.out.println("error");
                modifyMap(custNo, managerName, managerPassword);
            }
        }
    }

    /**
     * back to up
     * <hr>
     * <pre>
     *     {@code
     *      public static void backToUp(String managerName, String managerPassword) {
     *         System.out.print("返回上层菜单(y/n):");
     *         Scanner scanner = new Scanner(System.in);
     *         String back = scanner.next();
     *         switch (back){
     *             case "y":
     *                 Menu.custInfoManagerMenu(managerName,managerPassword);
     *                 break;
     *             case "n":
     *                 break;
     *             default:
     *                 System.out.println("exit");
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
     * @see Customer#modifyCustInfo(String, String)
     * @see Customer#modifyMap(String, String, String)
     * @see Menu#custInfoManagerMenu(String, String)
     */
    public static void backToUp(String managerName, String managerPassword) {
        System.out.print("返回上层菜单(y/n):");
        Scanner scanner = new Scanner(System.in);
        String back = scanner.next();
        switch (back) {
            case "y":
                Menu.custInfoManagerMenu(managerName, managerPassword);
                break;
            case "n":
                break;
            default:
                System.out.println("exit");
        }
    }

    /**
     * Select customer information
     * <hr>
     * <pre>
     *     {@code
     *      public static void selectCustInfo() {
     *         System.out.print("输入会员号:");
     *         Scanner scanner = new Scanner(System.in);
     *         String custNo = scanner.next();
     *         if (VerifyEqual.verifyCust(custNo)) {
     *             System.out.println("""
     *                     会员号     生日     积分
     *                     -------|-------|-------|""");
     *             System.out.println(custNo + "\t" + custInfo.get(custNo)[0] + "\t" + custInfo.get(custNo)[1]);
     *         }
     *     }}
     * </pre>
     * <hr>
     *
     * @see System#out
     * @see java.io.PrintStream#println(String)
     * @see java.io.PrintStream#print(String)
     * @see Scanner#Scanner(InputStream)
     * @see Scanner#next()
     * @see HashMap#get(Object)
     * @see CustManagement#selectInfo()
     * @see VerifyEqual#verifyCust(String)
     * @see Customer#custInfo
     */
    public static void selectCustInfo() {
        System.out.print("输入会员号:");
        Scanner scanner = new Scanner(System.in);
        String custNo = scanner.next();
        if (VerifyEqual.verifyCust(custNo)) {
            System.out.println("""
                    会员号     生日     积分
                    -------|-------|-------|""");
            System.out.println(custNo + "\t" + custInfo.get(custNo)[0] + "\t" + custInfo.get(custNo)[1]);
        } else {
            System.out.println("none");
        }
    }

    /**
     * toString
     * <hr>
     * <pre>
     *     {@code
     *      @Override
     *     public String toString(){
     *         Iterator<Entry<K,V>> i = entrySet().iterator();
     *         if (! i.hasNext()) {
     *             return "No customer information here.";
     *         }
     *         String str = """
     *                         会员号    生日     积分
     *                         ------|-------|-------|""";
     *         StringBuilder sb = new StringBuilder();
     *         sb.append(str).append("\n");
     *         for (;;) {
     *             Entry<K,V> e = i.next();
     *             K key = e.getKey();
     *             V value = e.getValue();
     *             sb.append(key.toString()).append("\t");
     *             String v = Arrays.toString((String[]) value).replace("[","").replace("]","").replace(",","\t");
     *             sb.append(v).append("\n");
     *             if (! i.hasNext())
     *                 return sb.toString();
     *         }
     *     }}
     * </pre>
     * <hr>
     *
     * @return {@code String}-<i>custInfo(.toString)</i>
     * @see Object#toString()
     * @see StringBuilder
     * @see StringBuilder#append(String)
     * @see Arrays#toString(Object[])
     * @see String#replace(char, char)
     * @see HashMap#keySet()
     * @see HashMap#get(Object)
     * @see Customer#custInfo
     * @see AbstractMap#toString()
     * @see Iterator
     * @see java.util.Map.Entry
     */
    @Override
    public String toString() {
        Iterator<Entry<K, V>> i = entrySet().iterator();
        if (!i.hasNext()) {
            return "No customer information here.";
        }
        String str = """
                会员号    生日     积分
                ------|-------|-------|""";
        StringBuilder sb = new StringBuilder();
        sb.append(str).append("\n");
        for (; ; ) {
            Entry<K, V> e = i.next();
            K key = e.getKey();
            V value = e.getValue();
            sb.append(key.toString()).append("\t");
            String v = Arrays.toString((String[]) value).replace("[", "").replace("]", "").replace(",", "\t");
            sb.append(v).append("\n");
            if (!i.hasNext())
                return sb.toString();
        }
    }
}
