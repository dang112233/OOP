package hus.oop.lab11.abstractfactory.exercises;

public class AnimalShelterConfigurator {
    public static void main(String[] args) {
        AnimalFactory factory;
        String type = "Domestic";

        if (type.equals("Domestic")) {
            factory = new DomesticAnimalFactory();
        } else if (type.equals("Wild")) {
            factory = new WildAnimalFactory();
        } else {
            throw new RuntimeException("Error! Unknown animal type.");
        }

        AnimalShelter shelter = new AnimalShelter(factory);
        shelter.makeNoise();
    }
}
