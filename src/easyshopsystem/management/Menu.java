package easyshopsystem.management;

import java.util.InputMismatchException;

import static easyshopsystem.data.Data.*;
import static easyshopsystem.data.Goods.getGOODS;
import static easyshopsystem.management.CustManagement.*;
import static easyshopsystem.management.GiftManagement.*;
import static easyshopsystem.management.Pay.pay;
import static easyshopsystem.management.StartSMS.o;
import static easyshopsystem.management.StartSMS.scan;
import static easyshopsystem.management.VerifyEqual.*;

public class Menu {
    public static void startMenu() throws InputMismatchException {
        o.print(start);
        try {
            String Num = scan.next();
            switch (Num) {
                case "1" -> {
                    o.print(cName);
                    String custName = scan.next();
                    o.print(cPw);
                    String custPassword = scan.next();
                    custHomeMenu(custName, custPassword);
                }
                case "2" -> {
                    o.print(Mname);
                    String managerName = scan.next();
                    o.print(password);
                    String managerPassword = scan.next();
                    managerHomeMenu(managerName, managerPassword);
                }
                case "3" -> {
                    o.print(wait);
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 5; j++) {
                            Thread.sleep(100);
                            o.print("\b");
                        }
                        for (int j = 0; j < 5; j++) {
                            Thread.sleep(100);
                            o.print(".");
                        }
                        o.print(2 - i + " ");
                        Thread.sleep(165);
                    }
                    o.print("\b\n" + err);
                    Thread.sleep(100);
                    System.exit(0);
                }
                default -> {
                    o.println(wr);
                    startMenu();
                }
            }
        } catch (InputMismatchException e) {
            o.println(err);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void custHomeMenu(String custName, String custPassword) {
        if (verifyCust(custName, custPassword)) {
            o.print(custHome);
            String s = scan.next();
            switch (s) {
                case "1" -> payMenu(custName, custPassword);
                case "2" -> funMenu(custName, custPassword);
                case "3" -> startMenu();
                default -> {
                    o.println(err);
                    custHomeMenu(custName, custPassword);
                }
            }
        } else {
            o.println(err);
            startMenu();
        }
    }

    public static void managerHomeMenu(String managerName, String managerPassword) {
        if (verifyManager(managerName, managerPassword)) {
            o.print(managerHome);
            String s = scan.next();
            switch (s) {
                case "1" -> custInfoManageMenu(managerName, managerPassword);
                case "n" -> startMenu();
                default -> {
                    o.println(exi);
                    managerHomeMenu(managerName, managerPassword);
                }
            }
        } else {
            o.println(err);
            startMenu();
        }
    }

    public static void custInfoManageMenu(String managerName, String managerPassword) {
        o.print(custInfoManage);
        String s = scan.next();
        switch (s) {
            case "1" -> {
                showAllInfo();
                if (flag()) custInfoManageMenu(managerName, managerPassword);
                else startMenu();
            }
            case "2" -> {
                showAllGOODS();
                if (flag()) custInfoManageMenu(managerName, managerPassword);
                else startMenu();
            }
            case "3" -> {
                addInfo(managerName, managerPassword);
                if (flag()) custInfoManageMenu(managerName, managerPassword);
                else startMenu();
            }
            case "4" -> {
                try {
                    o.print(GN);
                    int No_ = scan.nextInt();
                    o.print(Gnm);
                    String name = scan.next();
                    o.print(price);
                    String price = scan.next();
                    addGOODSInfo(No_, name, price, managerName, managerPassword);
                    if (flag()) custInfoManageMenu(managerName, managerPassword);
                    else startMenu();
                } catch (Exception e) {
                    o.println(err);
                    custInfoManageMenu(managerName, managerPassword);
                }
            }
            case "5" -> {
                modifyInfo_(managerName, managerPassword);
                if (flag()) custInfoManageMenu(managerName, managerPassword);
                else startMenu();
            }
            case "6" -> {
                modifyGOODSInfo_(managerName, managerPassword);
                if (flag()) custInfoManageMenu(managerName, managerPassword);
                else startMenu();
            }
            case "7" -> {
                selectInfo();
                if (flag()) custInfoManageMenu(managerName, managerPassword);
                else startMenu();
            }
            case "8" -> {
                try {
                    o.print(GN);
                    int No_ = scan.nextInt();
                    selectGOODSInfo(No_, managerName, managerPassword);
                    if (flag()) custInfoManageMenu(managerName, managerPassword);
                    else startMenu();
                } catch (Exception e) {
                    o.println(err);
                    custInfoManageMenu(managerName, managerPassword);
                }
            }
            case "n" -> managerHomeMenu(managerName, managerPassword);
            default -> {
                if (flag()) managerHomeMenu(managerName, managerPassword);
                else startMenu();
            }
        }
    }

    public static void payMenu(String custName, String custPassword) {
        o.print(getGOODS());
        pay(custName, custPassword);
    }

    public static void funMenu(String custName, String custPassword) {
        o.print(fun);
        String s = scan.next();
        switch (s) {
            case "1" -> fortuneGiving(custName, custPassword);
            case "2" -> luckyLottery(custName, custPassword);
            case "3" -> birthGreeting(custName, custPassword);
            case "n" -> custHomeMenu(custName, custPassword);
            default -> {
                o.println(err);
                custHomeMenu(custName, custPassword);
            }
        }
    }
}
