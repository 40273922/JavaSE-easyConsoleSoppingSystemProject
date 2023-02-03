/**
 * Copyright © 2023 JinPei Zhai-2145619745.qq.com
 * All rights reserved.
 */
package pers.evils.javase.easyshopsystem.management;

import pers.evils.javase.easyshopsystem.data.Customer;

/**
 * Customer_Management
 *
 * @author Evils80386
 * @version OpenJDK-17.0.4
 * @Classname {@code CustManagement}
 */
public class CustManagement {
    /**
     * Call the printCustInfo function to show all customers' information
     * <hr>
     * <pre>
     *     {@code
     *      public static void showAllInfo(){
     *         Customer.printCustInfo();
     *     }}
     * </pre>
     * <hr>
     *
     * @see Menu#custInfoManagerMenu(String, String)
     */
    public static void showAllInfo() {
        System.out.println(Customer.custInfo);
    }

    /**
     * Call the selectCustInfo function to add customers' information
     * <hr>
     * <pre>
     *     {@code
     *       public static void addInfo(String managerName,String managerPassword){
     *         Customer.addCustInfo(managerName,managerPassword);
     *     }}
     * </pre>
     * <hr>
     *
     * @param managerName     {@code String}-<i>ligament to customer identification</i>
     * @param managerPassword {@code String}-<i>ligament to customer identification</i>
     * @see Menu#custInfoManagerMenu(String, String)
     * @see Customer#addCustInfo(String, String)
     */
    public static void addInfo(String managerName, String managerPassword) {
        Customer.addCustInfo(managerName, managerPassword);
    }

    /**
     * Call the selectCustInfo function to modify customers' information
     * <hr>
     * <pre>
     *     {@code
     *      public static void modifyInfo(String managerName,String managerPassword){
     *         Customer.modifyCustInfo(managerName,managerPassword);
     *     }}
     * </pre>
     * <hr>
     *
     * @param managerName     {@code String}-<i>ligament to customer identification</i>
     * @param managerPassword {@code String}-<i>ligament to customer identification</i>
     * @see Menu#custInfoManagerMenu(String, String)
     * @see Customer#modifyCustInfo(String, String)
     */
    public static void modifyInfo(String managerName, String managerPassword) {
        Customer.modifyCustInfo(managerName, managerPassword);
    }

    /**
     * Call the selectCustInfo function to select customers' information
     * <hr>
     * <pre>
     *     {@code
     *      public static void selectInfo(){
     *         Customer.selectCustInfo();
     *     }}
     * </pre>
     * <hr>
     *
     * @see Menu#custInfoManagerMenu(String, String)
     * @see Customer#selectCustInfo()
     */
    public static void selectInfo() {
        Customer.selectCustInfo();
    }
}
