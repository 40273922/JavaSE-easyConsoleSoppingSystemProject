package easyshopsystem.data;

import java.util.HashMap;

public class Manager<K, V> extends HashMap<K, V> {
    private static final Manager<String, String> manager = new Manager<>();

    public static void setManager(String name, String password) {
        manager.put(name, password);
    }

    public static Manager<String, String> getManager() {
        return manager;
    }
}
