package pers.evils80386.javase.easy_shop_system.data;

import java.util.HashMap;

/**
 * @Classname Manager
 * @Created by Evils80386
 */
public class Manager {
    /**
     * @Description &lt;String managerName,String managerPassword&gt;
     */
    public static HashMap<String,String> manager = new HashMap<>(){};

    /**
     *
     * @param name-ligament_to_manager_identification
     * @param password-ligament_to_manager_identification
     */
    public static void setManager(String name,String password) {
        Manager.manager.put(name,password);
    }
}
