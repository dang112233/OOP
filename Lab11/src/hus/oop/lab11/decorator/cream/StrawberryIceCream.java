package hus.oop.lab11.decorator.cream;

public class StrawberryIceCream extends IceCream {
    public StrawberryIceCream(NutsToppingDecorator nutsToppingDecorator) {

    }

    @Override
    String getDescription() {
        return "Strawberry ice cream";
    }
}
