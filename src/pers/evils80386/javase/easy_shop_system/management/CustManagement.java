package pers.evils80386.javase.easy_shop_system.management;

import pers.evils80386.javase.easy_shop_system.data.Customer;

/**
 * @Classname CustManagement
 * @Description Customer_Management
 * @Created by Evils80386
 */
public class CustManagement {
    /**
     * @Description call_printCustInfo()
     */
    public static void showAllInfo(){
        Customer.printCustInfo();
    }

    /**
     *
     * @param managerName-ligament_to_manager_identification
     * @param managerPassword-ligament_to_manager_identification
     */
    public static void addInfo(String managerName,String managerPassword){
        Customer.addCustInfo(managerName,managerPassword);
    }

    /**
     *
     * @param managerName-ligament_to_manager_identification
     * @param managerPassword-ligament_to_manager_identification
     */
    public static void modifyInfo(String managerName,String managerPassword){
        Customer.modifyCustInfo(managerName,managerPassword);
    }

    /**
     * @Description selectCustInfo
     */
    public static void selectInfo(){
        Customer.selectCustInfo();
    }
}
