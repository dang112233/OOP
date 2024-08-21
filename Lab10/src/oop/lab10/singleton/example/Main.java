package oop.lab10.singleton.example;

public class Main {
    public static void main(String[] args) {
        Printer printer1 = Printer.getInstance();
        printer1.print("This is the first document.");

        Printer printer2 = Printer.getInstance();
        printer2.print("This is the second document.");

        // printer1 and printer2 are the same instance
        if (printer1 == printer2) {
            System.out.println("printer1 and printer2 are the same instance.");
        }
    }
}
