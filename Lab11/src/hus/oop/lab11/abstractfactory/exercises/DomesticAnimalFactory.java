package hus.oop.lab11.abstractfactory.exercises;

public class DomesticAnimalFactory implements AnimalFactory {
    @Override
    public Cat createCat() {
        return new DomesticCat();
    }

    @Override
    public Dog createDog() {
        return new DomesticDog();
    }
}
