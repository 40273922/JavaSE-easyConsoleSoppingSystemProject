package easyshopsystem.management;

import static easyshopsystem.data.Customer.*;
import static easyshopsystem.data.Data.*;
import static easyshopsystem.data.Goods.getGOODS_N;
import static easyshopsystem.management.Menu.custHomeMenu;
import static easyshopsystem.management.StartSMS.o;
import static easyshopsystem.management.StartSMS.scan;
import static easyshopsystem.management.VerifyEqual.flag;

public class Pay {
    static String[][] info = new String[100][4];
    static float amountAll = 0;

    public static void pay(String custName, String custPassword) {
        o.print("\n" + custNo);
        String custNo = scan.next();
        boolean flag = getCustInfo().containsKey(custNo);
        int i = 0;
        if (flag) {
            String str;
            do {
                calc(i, custName, custPassword);
                o.print("继续(y/n):");
                str = scan.next();
                i++;
            } while (str.equals("y"));
            o.println(list);
            printInfo(i);
            o.print("折扣:\t0.95\n总计:\t￥" + amountAll + "\n支付:\t￥");
            float real = scan.nextFloat();
            changeCalc(real, amountAll);
            int score = scoreCalc(i);
            o.println("所得积分:\t" + score);
            setCustInfo_N(custNo, 1, score + "" + Integer.parseInt(getCustInfo_N(custNo, 1)));
            amountAll = 0;
            if (flag()) custHomeMenu(custName, custPassword);
        } else {
            o.println(err);
            custHomeMenu(custName, custPassword);
        }
    }

    public static void calc(int i, String custName, String custPassword) {
        try {
            o.print("编号:");
            int num1 = scan.nextInt();
            System.out.print("数目:");
            int num2 = scan.nextInt();
            String nums = "" + num2;
            try {
                info[i] = new String[]{getGOODS_N(num1, 0), getGOODS_N(num1, 1), nums, "￥" + Float.parseFloat((getGOODS_N(num1, 1))) * num2};
                amountAll += Float.parseFloat(getGOODS_N(num1, 1)) * num2;
            } catch (Exception e) {
                o.println(err);
            }
        } catch (Exception e) {
            amountAll = 0;
            o.println(err);
            pay(custName, custPassword);
        }
    }

    public static void printInfo(int i) {
        for (int j = 0; j < i; j++) {
            if (info[j][0] == null) continue;
            for (int k = 0; k < info[j].length; k++) System.out.print(info[j][k] + "\t");
            o.println();
        }
    }

    public static int scoreCalc(int i) {
        int score = 0;
        for (int j = 0; j < i; j++) {
            if (info[j][0] == null) continue;
            score += Integer.parseInt(info[j][2]) * 9;
        }
        return score;
    }

    public static void changeCalc(float real, float amountAll) {
        float a = real;
        float b = amountAll;
        if ((a - b) > 0) {
            o.printf("找钱:\t￥%.2f", (a - b));
            o.println();
        } else {
            o.print("继续支付:\t");
            b = b - a;
            a = scan.nextFloat();
            changeCalc(a, b);
        }
    }
}
