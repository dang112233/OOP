package hus.oop.lab11.factorymethod.fruit;

public class CallingClass {
    public static void main(String[] args) {
        FruitFactory fruitFactory = new FruitFactory();

        // Request an Apple object and produce juice
        Fruit apple = fruitFactory.provideFruit("Apple");
        if (apple != null) {
            apple.produceJuice();
        }

        // Request a Banana object and produce juice
        Fruit banana = fruitFactory.provideFruit("Banana");
        if (banana != null) {
            banana.produceJuice();
        }

        // Request an Orange object and produce juice
        Fruit orange = fruitFactory.provideFruit("Orange");
        if (orange != null) {
            orange.produceJuice();
        }
    }
}
