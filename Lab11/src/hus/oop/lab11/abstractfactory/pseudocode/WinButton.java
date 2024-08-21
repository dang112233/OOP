package hus.oop.lab11.abstractfactory.pseudocode;

public class WinButton implements Button {
    @Override
    public void paint() {
        System.out.println("You have created WinButton");
    }
}
