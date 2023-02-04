package easyshopsystem.data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

import static easyshopsystem.data.Data.*;
import static easyshopsystem.management.Menu.custInfoManageMenu;
import static easyshopsystem.management.StartSMS.o;
import static easyshopsystem.management.StartSMS.scan;
import static easyshopsystem.management.VerifyEqual.verifyCust;

public class Customer<K, V> extends HashMap<K, V> {
    private static final Customer<String, String> customer = new Customer<>();
    private static final Customer<String, String[]> custInfo = new Customer<>();

    public static void setCustomer(String NO_, String password) {
        customer.put(NO_, password);
    }

    public static void setCustInfo(String N0_, String[] info) {
        custInfo.put(N0_, info);
    }

    public static void setCustInfo_N(String No_, int num, String info) {
        custInfo.get(No_)[num] = info;
    }

    public static Customer<String, String> getCustomer() {
        return customer;
    }

    public static Customer<String, String[]> getCustInfo() {
        return custInfo;
    }

    public static String getCustInfo_N(String No_, int num) {
        return custInfo.get(No_)[num];
    }

    public static void addCustInfo(String managerName, String managerPassword) {
        try {
            o.print(custNo);
            String custNo = scan.next();
            o.print(birth);
            String custBirth = scan.next();
            o.print(score);
            String custScore = scan.next();
            int score = Integer.parseInt(custScore);
            int No_ = Integer.parseInt(custNo);
            int month = Integer.parseInt(custBirth.charAt(0) + "" + custBirth.charAt(1));
            int day = Integer.parseInt(custBirth.charAt(3) + "" + custBirth.charAt(4));
            boolean dateIsTrue = dateIsTrue(month, day, custBirth.length(), custBirth.charAt(2));
            if (dateIsTrue && (score >= 0) && (No_ > 999 && No_ < 10000)) {
                customer.put(custNo, custNo);
                custInfo.put(custNo, new String[]{custBirth, custScore});
                o.print(sus);
                String yes = scan.next();
                if (yes.equals("y")) addCustInfo(managerName, managerPassword);
                else custInfoManageMenu(managerName, managerPassword);
            } else {
                o.println(err);
                addCustInfo(managerName, managerPassword);
            }
        } catch (Exception e) {
            o.println(err);
            custInfoManageMenu(managerName, managerPassword);
        }
    }

    public static boolean dateIsTrue(int Month, int Day, int length, char c) {
        boolean dateIsTrue = true;
        if ((Month == 0) && (Day == 0)) dateIsTrue = false;
        else {
            switch (Month) {
                case 1, 3, 5, 7, 8, 10, 12 -> {
                    if ((Day < 1) || (Day > 31)) dateIsTrue = false;
                }
                case 2 -> {
                    if ((Day < 1) || (Day > 29)) dateIsTrue = false;
                }
                default -> {
                    if ((Day < 1) || (Day > 30)) dateIsTrue = false;
                }
            }
        }
        return dateIsTrue && (length == 5) && (c == '/');
    }

    public static void modifyInfo(String managerName, String managerPassword) {
        backToUp(managerName, managerPassword);
        o.print(custNo);
        String custNo = scan.next();
        if (verifyCust(custNo)) {
            o.println(title);
            o.println(custNo + "\t" + custInfo.get(custNo)[0] + "\t" + custInfo.get(custNo)[1]);
            modifyMap(custNo, managerName, managerPassword);
            o.println(mod);
            String conf = scan.next();
            if (conf.equals("y")) modifyMap(custNo, managerName, managerPassword);
            else custInfoManageMenu(managerName, managerPassword);
        } else {
            o.println(err);
            custInfoManageMenu(managerName, managerPassword);
        }
    }

    public static void modifyMap(String custNo, String managerName, String managerPassword) {
        backToUp(managerName, managerPassword);
        o.print(modify);
        int select = scan.nextInt();
        switch (select) {
            case 1 -> {
                o.print(birth);
                String birth = scan.next();
                int mon = Integer.parseInt(birth.charAt(0) + "" + birth.charAt(1));
                int day = Integer.parseInt(birth.charAt(3) + "" + birth.charAt(4));
                boolean dateIsTrue = dateIsTrue(mon, day, birth.length(), birth.charAt(2));
                if (dateIsTrue) {
                    custInfo.get(custNo)[0] = birth;
                    o.println(done);
                } else o.println(err);
            }
            case 2 -> {
                try {
                    o.print(score);
                    String score = scan.next();
                    if (Integer.parseInt(score) >= 0) {
                        custInfo.get(custNo)[1] = score;
                        o.println(done);
                    } else o.println(err);
                } catch (Exception e) {
                    o.println(err);
                    modifyMap(custNo, managerName, managerPassword);
                }
            }
            default -> {
                o.println(err);
                modifyMap(custNo, managerName, managerPassword);
            }
        }
    }

    public static void backToUp(String managerName, String managerPassword) {
        o.print(backup);
        String back = scan.next();
        switch (back) {
            case "y" -> custInfoManageMenu(managerName, managerPassword);
            case "n" -> o.println();
            default -> o.println(exi);
        }
    }

    public static void selectCustInfo() {
        o.print(custNo);
        String custNo = scan.next();
        if (verifyCust(custNo)) {
            o.println(title);
            o.println(custNo + "\t" + custInfo.get(custNo)[0] + "\t" + custInfo.get(custNo)[1]);
        } else {
            o.println(no);
        }
    }

    @Override
    public String toString() {
        Iterator<Entry<K, V>> i = entrySet().iterator();
        if (!i.hasNext()) return no;
        StringBuilder s = new StringBuilder();
        s.append(title).append("\n");
        for (; ; ) {
            Entry<K, V> e = i.next();
            K key = e.getKey();
            V value = e.getValue();
            String val = Arrays.toString((String[]) value)
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", "\t");
            s.append(key.toString()).append("\t").append(val).append("\n");
            if (!i.hasNext()) return s.toString();
        }
    }
}
