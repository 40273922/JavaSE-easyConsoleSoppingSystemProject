/**
 * Copyright © 2023 JinPei Zhai-2145619745.qq.com
 * All rights reserved.
 */
package pers.evils.javase.easyshopsystem.management;

import pers.evils.javase.easyshopsystem.data.Customer;
import pers.evils.javase.easyshopsystem.data.Manager;

import java.io.InputStream;
import java.util.Scanner;

/**
 * <p>
 * <i>Identification actions and and using <a href="https://bugs.openjdk.org/browse/JDK-8222530" target="_blank">text blocks</a></i>
 *
 * @author Evils80386
 * @version OpenJDK-17.0.4
 * @Classname {@code VerifyEqual}
 */
public class VerifyEqual {
    /**
     * confirm customer information
     * <pre>
     *     {@code
     *     public static boolean verifyCust(String custName,String custPassword){
     *         return Customer.customer.containsKey(custName) && custPassword.equals(Customer.customer.get(custName));
     *     }}
     * </pre>
     *
     * @param custName     {@code String}-<i>ligament to customer identification</i>
     * @param custPassword {@code String}-<i>ligament to customer identification</i>
     * @return {@code boolean}-<i>Customer.customer.containsKey(custName) &amp;&amp; custPassword.equals(Customer.customer.get(custName))</i>
     * @see java.util.HashMap#containsKey(Object)
     * @see String#equals(Object)
     * @see Menu#custHomeMenu(String, String)
     */
    public static boolean verifyCust(String custName, String custPassword) {
        return Customer.customer.containsKey(custName) && custPassword.equals(Customer.customer.get(custName));
    }

    /**
     * confirm customer's Name
     * <pre>
     *     {@code
     *     public static boolean verifyCust(String custName){
     *         return Customer.customer.containsKey(custName);
     *     }}
     * </pre>
     *
     * @param custName {@code String}-<i>ligament to customer identification</i>
     * @return {@code boolean}-<i>Customer.customer.containsKey(custName)</i>
     * @see java.util.HashMap#containsKey(Object)
     * @see Customer#modifyCustInfo(String, String)
     * @see Customer#selectCustInfo()
     * @see GiftManagement#fortuneGiving(String, String)
     * @see GiftManagement#luckyLottery(String, String)
     * @see GiftManagement#birthGreeting(String, String)
     */
    public static boolean verifyCust(String custName) {
        return Customer.customer.containsKey(custName);
    }

    /**
     * confirm manager information
     * <pre>
     *     {@code
     *     public static boolean verifyManager(String managerName,String managerPassword){
     *         return Manager.manager.containsKey(managerName) && managerPassword.equals(Manager.manager.get(managerName));
     *     }}
     * </pre>
     *
     * @param managerName     {@code String}-<i>ligament to customer identification</i>
     * @param managerPassword {@code String}-<i>ligament to customer identification</i>
     * @return {@code boolean}-<i>Manager.manager.containsKey(managerName) &amp;&amp; managerPassword.equals(Manager.manager.get(managerName))</i>
     * @see java.util.HashMap#containsKey(Object)
     * @see String#equals(Object)
     * @see java.util.HashMap#get(Object)
     * @see Menu#managerHomeMenu(String, String)
     */
    public static boolean verifyManager(String managerName, String managerPassword) {
        return Manager.manager.containsKey(managerName) && managerPassword.equals(Manager.manager.get(managerName));
    }

    /**
     * return back
     * <pre>
     *     {@code
     *     public static boolean flag(){
     *         Scanner scanner = new Scanner(System.in);
     *         int count = 0;
     *         System.out.print("""
     *                         按'n'返回:""");
     *         String slogan = scanner.next();
     *         if (slogan.equals("n")){
     *             return true;
     *         }else {
     *             while (count < 2){
     *                 count++;
     *                 System.out.print("按'n'返回:");
     *                 slogan = scanner.next();
     *                 if (slogan.equals("n")){
     *                     return true;
     *                 }
     *             }
     *         }
     *         return false;
     *     }}
     * </pre>
     *
     * @return {@code boolean}-<i>false if wrong 2 times</i>
     * @see System#out
     * @see java.io.PrintStream#print(String)
     * @see Scanner#Scanner(InputStream)
     * @see Scanner#next()
     * @see String#equals(Object)
     * @see GiftManagement#fortuneGiving(String, String)
     * @see GiftManagement#birthGreeting(String, String)
     * @see GiftManagement#luckyLottery(String, String)
     * @see Pay#pay(String, String)
     * @see Menu#custInfoManagerMenu(String, String)
     * @see Menu#managerHomeMenu(String, String)
     */
    public static boolean flag() {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        System.out.print("按'n'返回:");
        String slogan = scanner.next();
        if (slogan.equals("n")) {
            return true;
        } else {
            while (count < 2) {
                count++;
                System.out.print("按'n'返回:");
                slogan = scanner.next();
                if (slogan.equals("n")) {
                    return true;
                }
            }
        }
        return false;
    }
}
