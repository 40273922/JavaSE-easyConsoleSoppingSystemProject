/**
 * Copyright © 2023 JinPei Zhai-2145619745.qq.com
 * All rights reserved.
 */
package pers.evils.javase.easyshopsystem.data;

import pers.evils.javase.easyshopsystem.management.VerifyEqual;

import java.util.HashMap;

/**
 * <p>
 * <i>A HashMap container is provided</i>
 *
 * @author Evils80386
 * @version OpenJDK-17.0.4
 * @Classname {@code Manager}
 */
public class Manager {
    /**
     * {@code HashMap}&lt;{@code K:String managerName,V:String managerPassword}&gt;<br>
     * <hr>
     * <pre>
     *     {@code
     *       public static HashMap<String,String> manager = new HashMap<>(){};
     *       }
     * </pre>
     * <hr>
     *
     * @see HashMap
     * @see HashMap#HashMap()
     * @see Manager#setManager(String, String)
     * @see VerifyEqual#verifyManager(String, String)
     * @see Manager#setManager(String, String)
     * @see Data#init()
     */
    public static HashMap<String, String> manager = new HashMap<>() {
    };

    /**
     * set manager information
     * <hr>
     * <pre>
     *     {@code
     *      public static void setManager(String name,String password) {
     *         Manager.manager.put(name,password);
     *     }}
     * </pre>
     * <hr>
     *
     * @param name     {@code String}-<i>ligament to manager identification</i>
     * @param password {@code String}-<i>ligament to manager identification</i>
     * @see HashMap#put(Object, Object)
     * @see Manager#manager
     * @see Data#init()
     */
    public static void setManager(String name, String password) {
        Manager.manager.put(name, password);
    }
}
