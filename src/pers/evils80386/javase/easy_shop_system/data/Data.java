package pers.evils80386.javase.easy_shop_system.data;

/**
 * @Classname Data
 * @Description data_initialization
 * @Created by Evils80386
 */
public class Data {
    /**
     *
     * Copyright © 2023 ZhaiJinPei-2145619745.qq.com
     * All rights reserved.
     * @Description data_initialization
     */
    public static void init(){
        //TODO
        Manager.setManager("manager","1234");
        Customer.setCustomer("1900","1900");
        Customer.setCustomer("1711","1711");
        Customer.setCustomer("1623","1623");
        Customer.setCustomer("1545","1545");
        Customer.setCustomer("1464","1464");
        Customer.setCustomer("1372","1372");
        Customer.setCustomer("1286","1286");
        Customer.setCustInfo("1900", new String[]{"08/05", "2000"});
        Customer.setCustInfo("1711", new String[]{"07/03", "4000"});
        Customer.setCustInfo("1623", new String[]{"06/26", "5000"});
        Customer.setCustInfo("1545", new String[]{"04/08", "2200"});
        Customer.setCustInfo("1464", new String[]{"08/16", "1000"});
        Customer.setCustInfo("1372", new String[]{"12/23", "3000"});
        Customer.setCustInfo("1286", new String[]{"12/21", "10080"});
    }
}
