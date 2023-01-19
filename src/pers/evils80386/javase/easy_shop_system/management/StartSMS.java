package pers.evils80386.javase.easy_shop_system.management;

import pers.evils80386.javase.easy_shop_system.data.Data;

/**
 *
 *  Copyright © 2023 ZhaiJinPei-2145619745.qq.com
 *  All rights reserved.
 *
 * @author Evils80386-2145619745
 * @version 2.0-add_some_handle_code
 * @Classname StartSMS
 * @Description main()
 *
 */
public class StartSMS {
    /**
     *
     * @param args-none
     */
    public static void main(String[] args) {
        //Data_Initialization
        Data.init();
        //Enter
        Menu.startMenu();
    }
}
