package pers.evils80386.javase.easy_shop_system.management;

import pers.evils80386.javase.easy_shop_system.data.Customer;
import pers.evils80386.javase.easy_shop_system.data.Manager;

import java.util.Scanner;

/**
 *
 * Copyright © 2023 ZhaiJinPei-2145619745.qq.com
 * All rights reserved.
 * @Classname VerifyEqual
 * @Description identification_actions
 * @Created by Evils80386
 */
public class VerifyEqual {
    /**
     *
     * @param custName-ligament_to_customer_identification
     * @param custPassword-ligament_to_customer_identification
     * @return Customer.customer.containsKey(custName) &amp;&amp; custPassword.equals(Customer.customer.get(custName))
     */
    public static boolean verifyCust(String custName,String custPassword){
        return Customer.customer.containsKey(custName) && custPassword.equals(Customer.customer.get(custName));
    }

    /**
     *
     * @param custName-ligament_to_customer_identification
     * @return Customer.customer.containsKey(custName)
     */
    public static boolean verifyCust(String custName){
        return Customer.customer.containsKey(custName);
    }

    /**
     *
     *  @param managerName-ligament_to_customer_identification
     *  @param managerPassword-ligament_to_customer_identification
     * @return Manager.manager.containsKey(managerName) &amp;&amp; managerPassword.equals(Manager.manager.get(managerName))
     */
    public static boolean verifyManager(String managerName,String managerPassword){
        return Manager.manager.containsKey(managerName) && managerPassword.equals(Manager.manager.get(managerName));
    }

    /**
     *
     * @return boolean
     */
    public static boolean flag(){
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        System.out.print("""
                        按'n'返回上级:""");
        String slogan = scanner.next();
        if (slogan.equals("n")){
            return true;
        }else {
            while (count < 2){
                count++;
                System.out.print("按'n'返回上级(否则退出):");
                slogan = scanner.next();
                if (slogan.equals("n")){
                    return true;
                }
            }
        }
        return false;
    }
}
