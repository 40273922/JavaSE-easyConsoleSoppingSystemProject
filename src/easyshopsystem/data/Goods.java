package easyshopsystem.data;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

import static easyshopsystem.data.Data.*;
import static easyshopsystem.management.Menu.custInfoManageMenu;
import static easyshopsystem.management.StartSMS.o;

public class Goods<K, V> extends HashMap<K, V> {
    private static final Goods<Integer, String[]> GOODS = new Goods<>();

    public static void setGOODS(int goodsNo_, String[] goodsInfo) {
        GOODS.put(goodsNo_, goodsInfo);
    }

    public static Goods<Integer, String[]> getGOODS() {
        return GOODS;
    }

    public static String getGOODS_N(int No_, int num) {
        return GOODS.get(No_)[num];
    }

    public static int goodsGiving(int num) {
        return num * Integer.parseInt(GOODS.get(num)[1]);
    }

    public static void modifyGOODS_0(int No_, String info, String managerName, String managerPassword) {
        if (GOODS.containsKey(No_) && No_ > 0 && info.length() <= 60) GOODS.get(No_)[0] = info;
        else {
            o.println(wr);
            custInfoManageMenu(managerName, managerPassword);
        }
    }

    public static void modifyGOODS_1(int No_, String info, String managerName, String managerPassword) {
        if (GOODS.containsKey(No_) && No_ > 0 && new BigDecimal(String.valueOf(Float.parseFloat(price))).scale() < 3)
            GOODS.get(No_)[1] = info;
        else {
            o.println(wr);
            custInfoManageMenu(managerName, managerPassword);
        }
    }

    public static void addGOODS(int No_, String name, String price, String managerName, String managerPassword) {
        if (qualify(No_, name, price)) GOODS.put(No_, new String[]{name, price});
        else {
            o.println(wr);
            custInfoManageMenu(managerName, managerPassword);
        }
    }

    public static boolean qualify(int No_, String name, String price) {
        return GOODS.containsKey(No_) && No_ > 0 && name.length() <= 60 && new BigDecimal(String.valueOf(Float.parseFloat(price))).scale() < 3;
    }

    public static void selectGOODS_(int No_, String managerName, String managerPassword) {
        if (No_ > 0)
            o.println(line + "\n" + No_ + "\t" + GOODS.get(No_)[0] + "\t\t￥" + GOODS.get(No_)[1] + "\n" + line);
        else custInfoManageMenu(managerName, managerPassword);
    }

    @Override
    public String toString() {
        Iterator<Entry<K, V>> i = entrySet().iterator();
        if (!i.hasNext()) return no;
        StringBuilder s = new StringBuilder();
        s.append(line).append("\n");
        for (; ; ) {
            Entry<K, V> e = i.next();
            K key = e.getKey();
            V value = e.getValue();
            String val = Arrays.toString((String[]) value)
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", "\t\t￥");
            s.append(key.toString()).append(" ").append(val).append("\n");
            if (!i.hasNext()) return s.append(line).toString();
        }
    }
}
