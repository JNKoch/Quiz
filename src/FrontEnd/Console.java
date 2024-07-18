package FrontEnd;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {

    public Console() {
    }
    public int rangeOfInput(int max) {
        int minInput = 1;
        int input = inputWithScanner();
        int check = 0;
        do {
            if (input < minInput || input > max) {
                print("Falsche Eingabe nochmal eingeben");
                input = inputWithScanner();
            } else check = 1;
        } while (check == 0);
        return input;
    }

    public void print(String output) {
        String str = ("-------------------------------" + "\n" +
                output +"\n"+
                "-------------------------------" + "\n");
        System.out.println(str);
    }

    public int inputWithScanner() {
        int input = 0;
        int exceptionHandler;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                input = scanner.nextInt();
                exceptionHandler = 1;
            } catch (InputMismatchException ex) {
                scanner.next();
                exceptionHandler = 0;
                print("Bitte nur eine Zahl und keine Buchstaben eingeben");
            }
        } while (exceptionHandler == 0);

        return input;
    }

    public void menu() {
        print("""
                Das Menü
                (1) Das Quiz beginnen
                (2) Das Quiz beenden""");
    }

    public void printFinalScores(int rightAnswers, int wrongAnswers) {

        print("Richtig beantwortete Fragen:" + rightAnswers+"\n"+
                "Falsch beantwortete Fragen:" + wrongAnswers);
    }
}
