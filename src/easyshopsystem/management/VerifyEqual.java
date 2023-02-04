package easyshopsystem.management;

import static easyshopsystem.data.Customer.getCustomer;
import static easyshopsystem.data.Data.back;
import static easyshopsystem.data.Manager.getManager;
import static easyshopsystem.management.StartSMS.o;
import static easyshopsystem.management.StartSMS.scan;

public class VerifyEqual {
    public static boolean verifyCust(String custName, String custPassword) {
        return getCustomer().containsKey(custName) && custPassword.equals(getCustomer().get(custName));
    }

    public static boolean verifyCust(String custName) {
        return getCustomer().containsKey(custName);
    }

    public static boolean verifyManager(String managerName, String managerPassword) {
        return getManager().containsKey(managerName) && managerPassword.equals(getManager().get(managerName));
    }

    public static boolean flag() {
        o.print(back);
        String slog = scan.next();
        return slog.equals("n");
    }
}
