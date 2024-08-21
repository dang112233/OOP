package hus.oop.lab11.abstractfactory.exercises;

public class AnimalShelter {
    private Cat cat;
    private Dog dog;
    public AnimalShelter(AnimalFactory factory) {
        cat = factory.createCat();
        dog = factory.createDog();
    }
    public void makeNoise() {
        cat.meow();
        dog.bark();
    }
}
