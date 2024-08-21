package oop.lab10.strategy.example;

public class StrategyPatternDemo {
    public static void main(String[] args) {
        FileContext fileContext = new FileContext(new ZipCompression());
        fileContext.executeCompression("myFile.txt");

        fileContext.setCompressionStrategy(new RarCompression());
        fileContext.executeCompression("myFile.txt");
    }
}
