package oop.lab10.strategy.example;

public class RarCompression implements CompressionStrategy {
    @Override
    public void compress(String fileName) {
        System.out.println("Compressing " + fileName + " using RAR.");
    }
}
