package hus.oop.lab11.decorator.cream;

public class ChocolateIceCream extends IceCream {
    public ChocolateIceCream(NutsToppingDecorator nutsToppingDecorator) {

    }

    @Override
    String getDescription() {
        return "Chocolate ice cream";
    }
}