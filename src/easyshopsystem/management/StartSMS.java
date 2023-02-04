package easyshopsystem.management;

import java.io.PrintStream;
import java.util.Scanner;

import static easyshopsystem.data.Data.init;
import static easyshopsystem.management.Menu.startMenu;

public class StartSMS {
    public static final PrintStream o = new PrintStream(System.out);
    public static final Scanner scan = new Scanner(System.in);

    static {
        init();
    }

    public static void main(String[] args) {
        startMenu();
    }
}
