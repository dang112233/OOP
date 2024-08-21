package hus.oop.lab11.abstractfactory.exercises;

public class WildAnimalFactory implements AnimalFactory {
    @Override
    public Cat createCat() {
        return new WildCat();
    }

    @Override
    public Dog createDog() {
        return new WildDog();
    }
}
