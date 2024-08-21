package hus.oop.lab7.viewanimal;

public class BigDog extends Dog {
    @Override
    public void greeting() {
        System.out.println("Woof!");
    }

    @Override
    public void greeting(Dog another) {
        System.out.println("Woooooowwwww!");
    }
}
