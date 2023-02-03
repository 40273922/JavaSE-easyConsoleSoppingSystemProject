/**
 * Copyright © 2023 JinPei Zhai-2145619745.qq.com
 * All rights reserved.
 */
package pers.evils.javase.easyshopsystem.management;

import pers.evils.javase.easyshopsystem.data.Data;

/**
 * @author Evils80386
 * @version OpenJDK-17.0.4
 * @Classname {@code StartSMS}
 * @Description <em>main method</em>
 */
public class StartSMS {

    static {
        //Data-initialization
        Data.init();
    }

    /**
     * main method
     * <ul id="mission">
     *     <li>Enter the startMenu</li>
     * </ul>
     * <pre>
     *     {@code
     *     public static void main(String[] args) {
     *         //Enter the startMenu
     *         Menu.startMenu();
     *     }}
     * </pre>
     *
     * @param args String[]
     * @see Menu#startMenu()
     */
    public static void main(String[] args) {
        //Enter the startMenu
        Menu.startMenu();
    }
}
