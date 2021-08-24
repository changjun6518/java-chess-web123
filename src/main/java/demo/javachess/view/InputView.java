package demo.javachess.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String SPACE = " ";

    public static String[] inputCommand() {
        return SCANNER.nextLine().split(SPACE);
    }
}
